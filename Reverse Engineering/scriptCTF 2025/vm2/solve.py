# VM Bytecode to check if random byte is palindrome
# Input: r0 contains the random byte (0-255)
# Output: r0 = 0 if palindrome, non-zero if not palindrome
# The VM will automatically loop this 100 times

# Register usage:
# r0: original random byte (input), final result (output)  
# r1: working copy for digit reversal
# r2: reversed number accumulator
# r3: temp for arithmetic
# r4: constant 10

code = bytes([ # START

    # Initialize constants
    0x10, 0x04, 0x0A, 0x00, 0x00, 0x00, # r4 = 10
    0x10, 0x02, 0x00, 0x00, 0x00, 0x00, # r2 = 0 (accumulator)

    # Copy r0 to r1 for processing
    0x20, 0x01, 0x00,                   # r1 = r0

    # Reverse the digits
# REVERSE_LOOP:
    # Check if r1 < 10 (single digit left)
    0xA0, 0x01, 0x04,                   # compare r1 with 10
    0xD0, 0x31, 0x00, 0x00, 0x00,       # jump to REVERSE_DONE if r1 < 10
    
    # Get last digit: r3 = r1 % 10
    0x20, 0x03, 0x01,                   # r3 = r1 (copy)
    0x50, 0x03, 0x04,                   # r3 = r3 / 10
    0x40, 0x03, 0x04,                   # r3 = r3 * 10  
    0x30, 0x03, 0x01,                   # r3 = r1 - r3 (this gives r1 % 10)
    
    # r2 = r2 * 10 + digit
    0x40, 0x02, 0x04,                   # r2 = r2 * 10
    0x20, 0x02, 0x03,                   # r2 = r2 + digit
    
    # r1 = r1 / 10
    0x50, 0x01, 0x04,                   # r1 = r1 / 10
    
    0x90, 0x0F, 0x00, 0x00, 0x00,       # jump back to REVERSE_LOOP

# REVERSE_DONE:
    # Add the final digit (r1) to r2
    0x40, 0x02, 0x04,                   # r2 = r2 * 10
    0x20, 0x02, 0x01,                   # r2 = r2 + r1

    # Compare original (r0) with reversed (r2)  
    0xA0, 0x00, 0x02,                   # compare r0 with r2
    0xB0, 0x46, 0x00, 0x00, 0x00,       # jump to NOT_PALINDROME if not equal

    # Is palindrome: set r0 = 0
    0x10, 0x00, 0x00, 0x00, 0x00, 0x00, # r0 = 0
    0xF0,                               # end execution

# NOT_PALINDROME:
    # Not palindrome: set r0 = 1  
    0x10, 0x00, 0x01, 0x00, 0x00, 0x00, # r0 = 1
    0xF0                                # end execution

]) # END

open('code.bin', 'wb').write(code)

def simulate():
    pass
    # r4 = 10
    # r2 = 0 (accumulator)
    # r1 = r0

    # while True:
    #     r3 = r1 (copy)
    #     r3 = r3 / 10
    #     r3 = r3 * 10  
    #     r3 = r1 - r3 (this gives r1 % 10)
    
    #     r2 = r2 * 10
    #     r2 = r2 + digit
    
    #     r1 = r1 / 10
    #     r1 = r1 / 10
    
    #     if r1 < 10:
    #         break

    # r2 = r2 * 10
    # r2 = r2 + r1
    # compare r0 with r2
    # jump to NOT_PALINDROME if not equal
    # r0 = 0
    # end execution

    # # NOT_PALINDROME:
    # r0 = 1
    # end execution

