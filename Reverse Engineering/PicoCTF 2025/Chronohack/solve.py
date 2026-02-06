from pwn import remote, context
import random
import time

context.log_level = 'debug'

def get_random(predicted):
    alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    random.seed(predicted) # predict
    s = ""
    for i in range(20): # length is 20
        s += random.choice(alphabet)
    return s

con = remote("verbal-sleep.picoctf.net", 52323)
timetime = int((time.time()) * 1000)
for i in range(50):
    guess = str(get_random(timetime + i)).encode()
    print(f'{i=}')
    con.sendlineafter(b"(or exit):", guess)
    con.recvuntil(b'Try again!', 1)
con.recvall()
