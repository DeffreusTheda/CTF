#!/usr/bin/env python3

import random
from sympy import nextprime
import base64
import os
import socket
import subprocess

def gen_prime(bits):
    candidate = random.getrandbits(bits)
    if candidate % 2 == 0:
        candidate += 1
    return nextprime(candidate)

def generate_rsa_keypair():
    e = 65537
    bits = 64 

    p = gen_prime(bits)
    q = gen_prime(bits)
    while q == p:
        q = gen_prime(bits)

    n = p * q
    phi = (p - 1) * (q - 1)
    d = pow(e, -1, phi)

    return n, e, d, p, q

def gen_challenge():
    access_pwd = os.urandom(6).hex()
    n, e, d, p, q = generate_rsa_keypair()

    m_int = int.from_bytes(access_pwd.encode(), byteorder="big")
    c_int = pow(m_int, e, n)
    c_bytes = c_int.to_bytes((c_int.bit_length() + 7) // 8, "big")
    c_b64 = base64.b64encode(c_bytes).decode()

    chall_text = f"----------- SECRET MESSAGE FROM NEON CITY MAYOR -----------\nn = {n}\ne = {e}\ncipher = {c_b64}\n-----------------------------------------------------------\n"
    return chall_text, access_pwd

def main():
    flag = os.getenv("FLAG", "flag{fake_flag}")
    host = "0.0.0.0"
    port = 1338
    wrong_pw_count = 0


    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.bind((host, port))
    server_socket.listen(5)
    print(f"Server listening on port {port}...")

    while True:
        client_socket, addr = server_socket.accept()
        print(f"Connection from {addr} established.")

        try:
            chall_text, pwd = gen_challenge()
            client_socket.sendall(chall_text.encode())

            client_socket.sendall(b"\nEnter password:\n")
            answer = client_socket.recv(4096).decode().strip()

            if answer == pwd:
                msg = f"V, inject this code into the mainframe backdoor: {flag}\n"
            else:
                if wrong_pw_count > 10:
                    msg = "Shard locked\n"
                else:
                    msg = "Invalid access code\n"
                    wrong_pw_count += 1
            client_socket.sendall(msg.encode())

        except subprocess.CalledProcessError as e:
            err_msg = f"Error generating challenge: {e}\n"
            client_socket.sendall(err_msg.encode("utf-8"))
        finally:
            client_socket.close()
            print(f"Connection from {addr} closed.")

if __name__ == "__main__":
    main()
