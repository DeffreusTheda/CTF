#!/usr/bin/env python3
import sys
import os
import time

MASK = 0xFFFFFFFF
N = 32
M = 7
MATRIX_A = 0x9908B0DF
UPPER_MASK = 0x80000000
LOWER_MASK = 0x7FFFFFFF

state = [0] * N
index = N

def seed_mt(seed):
    global index
    state[0] = seed & MASK
    for i in range(1, N):
        state[i] = (1812433253 * (state[i-1] ^ (state[i-1] >> 30)) + i) & MASK
    index = N

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

MOVES = ["Rock", "Paper", "Scissors", "Lizard", "Spock"]
WIN_MAP = {0: [2, 3], 1: [0, 4], 2: [1, 3], 3: [1, 4], 4: [0, 2]}

def beats(a, b):
    return b in WIN_MAP[a]

def send(msg):
    sys.stdout.write(msg)
    sys.stdout.flush()

def recv():
    try:
        line = sys.stdin.readline()
        if not line: return None
        return line.strip()
    except: return None

def get_flag():
    try:
        with open("flag.txt", "r") as f:
            return f.read().strip()
    except FileNotFoundError:
        return "VincooCTF{fakeflag}"

def main():
    send("Win the game, get the flag.\n")
    send("Here's free 100 trial games for you.\n\n")
    send("0: Rock, 1: Paper, 2: Scissors, 3: Lizard, 4: Spock\n\n")

    seed = int.from_bytes(os.urandom(3), "big")
    seed_mt(seed)

    free_rounds = 100
    required_wins = 200
    streak = 0
    round_no = 0

    flag = get_flag()

    while True:
        round_no += 1
        sm = server_move()

        if round_no <= free_rounds:
            send(f"[Trial {round_no}/100] ")
        else:
            send(f"[Streak {streak}/{required_wins}] ")

        send("Input (0-4): ")
        
        user_input = recv()
        if user_input is None: return 

        try:
            cm = int(user_input)
        except:
            send("Invalid.\n")
            return

        if cm not in range(5):
            send("Invalid.\n")
            return

        send(f"Server played: {MOVES[sm]}\n")

        if cm == sm:
            send("Draw.\n")
            if round_no > free_rounds: streak = 0
        elif beats(cm, sm):
            send("Win!\n")
            if round_no > free_rounds: streak += 1
        else:
            send("Lose.\n")
            if round_no > free_rounds: streak = 0

        if streak >= required_wins:
            send("\nCongratz!\n")
            send(f"{flag}\n")
            return

if __name__ == "__main__":
    try:
        main()
    except KeyboardInterrupt:
        pass
