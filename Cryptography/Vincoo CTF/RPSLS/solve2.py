from pwn import *
from tqdm import tqdm
p = remote("gzcli.1pc.tf", 57108)
# p = process(["python3", "chall.py"])
context.log_level = 'debug'

## LIBS

MASK = 0xFFFFFFFF # 32 bit mask 
N = 32
M = 7
MATRIX_A = 0x9908B0DF
UPPER_MASK = 0x80000000
LOWER_MASK = 0x7FFFFFFF
WIN_MAP = {0: [2, 3], 1: [0, 4], 2: [1, 3], 3: [1, 4], 4: [0, 2]}

state = [0] * N
index = N

def seed_mt(seed):
    global index
    state[0] = seed & MASK
    for i in range(1, N):
        state[i] = (1812433253 * (state[i-1] ^ (state[i-1] >> 30)) + i) & MASK
    index = N

## this is like the state refresher thingy
def twist():
    global index
    for i in range(N):
        x = (state[i] & UPPER_MASK) | (state[(i+1) % N] & LOWER_MASK)
        xa = x >> 1
        if x & 1:
            xa ^= MATRIX_A
        state[i] = state[(i + M) % N] ^ xa
    index = 0

def extract_number():
    global index
    if index >= N:
        twist()
    y = state[index]
    index += 1
    y ^= y >> 11
    y ^= (y << 7) & 0x9D2C5680
    y ^= (y << 15) & 0xEFC60000
    y ^= y >> 18
    return y & MASK

def server_move():
    return extract_number() % 5


## SOLVER CODE START HERE

def pick_winning_move(b):
    for a, beaten in WIN_MAP.items():
        if b in beaten:
            return a  # guaranteed win
    return None  # no winning move

def get_server_move():
    p.sendlineafter(b"Input (0-4): ", b"0") ## our answer doens't matter for now
    p.recvuntil(b"Server played: ")
    sm = ["Rock", "Paper", "Scissors", "Lizard", "Spock"].index(p.recvline().strip().decode())
    print(f'{sm=}')
    return sm

def play_and_check(move: bytes):
    status = b''
    try:
        p.sendlineafter(b"Input (0-4): ", move)
        p.recvuntil("Server played: ")
        sm = ["Rock", "Paper", "Scissors", "Lizard", "Spock"].index(p.recvline().strip().decode())
        print(f'{sm=}')
        status = p.recvline()
    except EOFError:
        print("I think the challenge ended, the flag should be printed now thx to the debugger :3")
        pass
    return status


seeds = [i for i in range(2**24)]

## get server move
server_moves = [get_server_move() for _ in range(11)]
print(server_moves)

for seed in tqdm(seeds):
    state = [0] * N
    index = N

    seed_mt(seed)
    found = True
    for move in server_moves:
        curseed_move = server_move()
        if curseed_move != move:
            found = False
            break
    
    if found:
        print("[!] We have finally found it")
        break

while True:
    picked_sm = server_move()
    # given_sm = get_server_move()
    print(f"What we predict: {picked_sm}")
    # print(f"Server picked {given_sm}")
    # print('='*10)
    # if picked_sm != given_sm:
    #     print("HAHAHAHAHA, failed lol")
    #     break
    # # hey it didn't failed :D

    our_move = pick_winning_move(picked_sm)
    print(our_move)
    status = play_and_check(str(our_move).encode())
    print(status)
    if status == b'':
        break

