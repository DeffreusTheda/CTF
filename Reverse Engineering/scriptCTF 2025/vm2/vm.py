import os
import sys

def lil_end_4bytes(code, pos):
    """Read 4-byte little endian value from code at position pos"""
    if pos + 4 > len(code):
        raise IndexError("OOB reading 4 bytes")
    return int.from_bytes(code[pos:pos+4], 'little')

def reverse_digits(n):
    """Reverse decimal digits of number n"""
    if n == 0:
        return 0
    res = 0
    while n > 9:
        res = res * 10 + (n % 10)
        n //= 10
    return res * 10 + n

def run_vm(code):
    """Run VM with given bytecode. Returns True if all 100 iterations pass."""
    remaining_ticks = 100
    
    while remaining_ticks > 0:
        # Get random byte
        rand_byte = os.urandom(1)[0]
        print(f'[*] :: {rand_byte} ::')
        
        # Initialize registers
        regs = [0] * 8
        regs[0] = rand_byte
        
        # VM execution
        pc = 0
        cycles = 50
        diff = 0
        
        while cycles > 0 and pc < len(code):
            op = code[pc]
            
            # 3-byte instructions
            if op in [0x20, 0x30, 0x40, 0x50, 0x60, 0x70, 0x80, 0xA0]:  # ADD, SUB, MUL, DIV, XOR, OR, AND, CMP
                if pc + 2 >= len(code):
                    print("OOB access")
                    return False
                r1, r2 = code[pc+1] & 7, code[pc+2] & 7
                
                if op == 0x20:    # ADD
                    print(f'r{r1} += r{r2} == {regs[r1] + regs[r2]}')
                    regs[r1] += regs[r2]
                elif op == 0x30:  # SUB
                    print(f'r{r1} -= r{r2} == {regs[r1] - regs[r2]}')
                    regs[r1] -= regs[r2]
                elif op == 0x40:  # MUL
                    print(f'r{r1} *= r{r2} == {regs[r1] * regs[r2]}')
                    regs[r1] *= regs[r2]
                elif op == 0x50:  # DIV
                    if regs[r2] == 0:
                        print("Division by zero")
                        return False
                    print(f'r{r1} //= r{r2} == {regs[r1] // regs[r2]}')
                    regs[r1] //= regs[r2]
                elif op == 0x60:  # XOR
                    print(f'r{r1} ^= r{r2} == {regs[r1] ^ regs[r2]}')
                    regs[r1] ^= regs[r2]
                elif op == 0x70:  # OR
                    print(f'r{r1} |= r{r2} == {regs[r1] | regs[r2]}')
                    regs[r1] |= regs[r2]
                elif op == 0x80:  # AND
                    print(f'r{r1} &= r{r2} == {regs[r1] & regs[r2]}')
                    regs[r1] &= regs[r2]
                elif op == 0xA0:  # CMP
                    print(f'diff = r{r1} - r{r2} == {regs[r1] - regs[r2]}')
                    diff = regs[r1] - regs[r2]
                
                regs[r1] &= 0xFFFFFFFF  # Keep 32-bit
                pc += 3
                
            # MOV immediate (6 bytes)
            elif op == 0x10:
                if pc + 5 >= len(code):
                    print("OOB access")
                    return False
                r1 = code[pc+1] & 7
                val = lil_end_4bytes(code, pc+2)
                print(f'r{r1} = {val & 0xFFFFFFFF}')
                regs[r1] = val & 0xFFFFFFFF
                pc += 6
                
            # Jump instructions (5 bytes)
            elif op in [0x90, 0xB0, 0xC0, 0xD0, 0xE0]:
                if pc + 4 >= len(code):
                    print("OOB access")  
                    return False
                target = lil_end_4bytes(code, pc+1)
                
                should_jump = False
                if op == 0x90:    # JMP
                    should_jump = True
                elif op == 0xB0:  # JE (mislabeled as JNE in comment)
                    should_jump = (diff == 0)
                elif op == 0xC0:  # JG (mislabeled as JLE in comment)  
                    should_jump = (diff > 0)
                elif op == 0xD0:  # JL (mislabeled as JGE in comment)
                    should_jump = (diff < 0)
                elif op == 0xE0:  # JNE (mislabeled as JE in comment)
                    should_jump = (diff != 0)
                
                print(f'{ {0x90: 'JMP', 0xB0: 'JE', 0xC0: 'JG', 0xD0: "JL", 0xE0: 'JNE'}[op] } {target} ({should_jump})')
                if should_jump:
                    pc = target
                else:
                    pc += 5
                    
            # END
            elif op == 0xF0:
                print(f'[*] :: REM {remaining_ticks} :: IN {cycles} CYCLE :: ')
                break
                
            else:
                print(f"Invalid opcode: 0x{op:02x}")
                return False
                
            cycles -= 1
            
            if pc >= len(code):
                break
        
        if cycles == 0:
            print("Timeout")
            return False
            
        # Check result
        result_r0 = regs[0] & 0xFF
        
        # Calculate expected
        if rand_byte == 0:
            expected_res = 0
        else:
            expected_res = reverse_digits(rand_byte)
        
        # Validation logic: (rand_byte == expected_res) != result_r0
        palindrome_match = (rand_byte == expected_res)
        
        if palindrome_match != bool(result_r0):
            print(f"Failed on iteration {101-remaining_ticks}: rand={rand_byte}, expected_res={expected_res}, r0={result_r0}")
            return False
            
        remaining_ticks -= 1
        print(f"Success on iteration {101-remaining_ticks}: rand={rand_byte}, expected_res={expected_res}, r0={result_r0}")
    
    print("SUCCESS: All 100 iterations passed!")
    return True

# Test with palindrome detection bytecode
bytecode = bytes([
    # r4 = 10
    0x10, 0x04, 0x0A, 0x00, 0x00, 0x00,
    # r2 = 0  
    0x10, 0x02, 0x00, 0x00, 0x00, 0x00,
    # r1 = r0
    0x20, 0x01, 0x00,
    # REVERSE_LOOP (pc=15):
    # cmp r1, r4
    0xA0, 0x01, 0x04,
    # jl REVERSE_DONE (pc=39)
    0xD0, 0x26, 0x00, 0x00, 0x00,
    # r3 = r1
    0x20, 0x03, 0x01,
    # r3 /= r4
    0x50, 0x03, 0x04, 
    # r3 *= r4
    0x40, 0x03, 0x04,
    # r3 = r1 - r3 (r1 % 10)
    0x30, 0x03, 0x01,
    # r2 *= r4
    0x40, 0x02, 0x04,
    # r2 += r3  
    0x20, 0x02, 0x03,
    # r1 /= r4
    0x50, 0x01, 0x04,
    # jmp REVERSE_LOOP (pc=15)
    0x90, 0x0F, 0x00, 0x00, 0x00,
    # REVERSE_DONE (pc=39):
    # r2 *= r4
    0x40, 0x02, 0x04,
    # r2 += r1
    0x20, 0x02, 0x01, 
    # cmp r0, r2
    0xA0, 0x00, 0x02,
    # jne NOT_PALINDROME (pc=56)
    0xE0, 0x38, 0x00, 0x00, 0x00,
    # r0 = 0 (palindrome)
    0x10, 0x00, 0x00, 0x00, 0x00, 0x00,
    0xF0,
    # NOT_PALINDROME (pc=56):
    # r0 = 1 (not palindrome)  
    0x10, 0x00, 0x01, 0x00, 0x00, 0x00,
    0xF0
])

bytecode = [

    0x10, 0x04, 0x0A, 0x00, 0x00, 0x00, # r4 = 10
    0x10, 0x05, 0x64, 0x00, 0x00, 0x00, # r5 = 100
    0x10, 0x06, 0x00, 0x00, 0x00, 0x00, # r6 = 0
    0xA0, 0x00, 0x04,                   # cmp ro r4
    0xD0, 0x5C, 0x00, 0x00, 0x00,       # jl RES_1
    0x20, 0x01, 0x00,                   # r1 = r0
    0x20, 0x02, 0x00,                   # r2 = r0
    0x50, 0x02, 0x04,                   # r2 /= r4 (10)
    0x40, 0x02, 0x04,                   # r2 *= r4 (10) ; xx_
    0xA0, 0x01, 0x05,                   # cmp ro r5 (100)
    0xD0, 0x49, 0x00, 0x00, 0x00,       # jl two_digit
    #three_digit: 11
    0x30, 0x00, 0x02,                   # r0 -= r2  ; __x
    0xA0, 0x01, 0x06,                   # cmp ro r6 (0)
    0xB0, 0x63, 0x00, 0x00, 0x00,       # JE RES_0 ; not palindrome
    0x50, 0x01, 0x05,                   # r1 /= r5 (100) ; x__
    0xA0, 0x00, 0x01,                   # cmp r0 r1
    0xE0, 0x63, 0x00, 0x00, 0x00,       # JNE RES_0 ; not palindrome
    0x90, 0x5C, 0x00, 0x00, 0x00,       # JMP RES_1 ; palindrome

    #two_digit: 11
    0x30, 0x00, 0x02,                   # r0 -= r2 ; _x
    0x50, 0x01, 0x04,                   # r1 /= r4 (10) ; x_
    0xA0, 0x00, 0x01,                   # cmp r0 r1
    0xE0, 0x63, 0x00, 0x00, 0x00,       # JNE RES_0 ; not palindrome
    0x90, 0x5C, 0x00, 0x00, 0x00,       # JMP RES_1 ; palindrome

    #RES_1:
    0x10, 0x00, 0x01, 0x00, 0x00, 0x00,
    0xF0,

    #RES_0: 
    0x10, 0x00, 0x00, 0x00, 0x00, 0x00,
    0xF0,

]

offset = int(sys.argv[1])
rep = {
    0x49: 0x49 + offset,
    0x63: 0x63 + offset,
    0x5c: 0x5c + offset,
}

bytecode = [rep[x] if x in rep.keys() else x for x in bytecode]
bytecode = bytes(bytecode)

if __name__ == "__main__":
    run_vm(bytecode)
    open('code.bin', 'wb').write(bytecode)
