from z3 import Solver, BitVec

# https://claude.ai/share/18e32458-93f5-4665-9be1-6cbe19244213

# Stack-based virtual machine that validates a flag
# This is essentially a custom bytecode interpreter

# Operation codes
PUSH_CONST = 0x1    # Push constant to stack
PUSH_FLAG = 0x2     # Push character from flag to stack
POP_PRINT = 0x3     # Pop and print value
ADD = 0x4           # Add two values
SUBTRACT = 0x5      # Subtract two values
MULTIPLY = 0x6      # Multiply two values
XOR = 0x7           # XOR two values
CHECK_ZERO = 0x8    # Check if value is zero

stack = []                              # VM stack
binary_code = open("instructions.bin",'rb').read()  # Load binary instructions
# 49
flag_length = binary_code[0]            # First byte contains expected flag length
user_input = input("Enter the flag: ")  # Get user input

# Validate input length
if len(user_input) != flag_length:
    print("Incorrect")
    exit()

user_input = user_input[:flag_length]   # Truncate input to expected length
flag_bytes = [BitVec(f'b{i:02}', 8) for i in range(49)]                         # Store numeric ASCII values of flag characters
s = Solver()

# Convert input string to ASCII values
for char in user_input:
    flag_bytes.append(ord(char))

instruction_pointer = 1                 # Start after flag length byte
flag_index = 0                          # Index to track which flag character to use

# Main execution loop
while instruction_pointer < len(binary_code):
    opcode = binary_code[instruction_pointer]  # Get current instruction
    
    # Push constant to stack
    if opcode == PUSH_CONST:
        print(f"PUSH {binary_code[instruction_pointer+1]}")
        stack.append(binary_code[instruction_pointer+1])
        instruction_pointer += 2
    
    # Push character from flag to stack
    elif (opcode == PUSH_FLAG) and (flag_index < flag_length):
        print(f"PUSHF {flag_bytes[flag_index]}")
        stack.append(flag_bytes[flag_index])
        flag_index += 1
        instruction_pointer += 1
    
    # Pop and print value
    elif opcode == POP_PRINT:
        value = stack.pop()
        print(f'POP {value}')
        instruction_pointer += 1
    
    # Addition operation
    elif opcode == ADD:
        right = stack.pop()
        left = stack.pop()
        stack.append(right + left)
        print(f'PUSH {right} + {left}')
        instruction_pointer += 1
    
    # Subtraction operation
    elif opcode == SUBTRACT:
        right = stack.pop()
        left = stack.pop()
        print(f'PUSH {right} - {left}')
        stack.append(right - left)
        instruction_pointer += 1
    
    # Multiplication operation
    elif opcode == MULTIPLY:
        right = stack.pop()
        left = stack.pop()
        print(f'PUSH {right} * {left}')
        stack.append(right * left)
        instruction_pointer += 1
    
    # XOR operation
    elif opcode == XOR:
        right = stack.pop()
        left = stack.pop()
        print(f'PUSH {right} ^ {left}')
        stack.append(right ^ left)
        instruction_pointer += 1
    
    # Check if top of stack is zero (validates correctness)
    elif opcode == CHECK_ZERO:
        result = stack.pop()
        print(f'CK0 {result}')
        if result != 0:
            print("Incorrect!")
            exit()
        instruction_pointer += 1
    
    # Invalid opcode handling
    else:
        print("Invalid instruction")
        exit()

    print(f'{stack=}')

print("Correct!!")
