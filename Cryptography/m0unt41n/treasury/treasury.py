import json, os
from datetime import datetime
from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes

FLAG = os.environ.get("FLAG", "flag{FAKE_FLAG}")
KEY = get_random_bytes(16)

def wrap(key: bytes, data: str) -> str:
    nonce = get_random_bytes(8)

    cipher = AES.new(key, AES.MODE_CTR, nonce=nonce)
    encr_data = cipher.encrypt(data.encode("utf-8"))
    cipher = AES.new(key, AES.MODE_CTR, nonce=nonce)
    encr_time = cipher.encrypt(datetime.utcnow().isoformat().encode("utf-8"))
    return json.dumps({
        "data": encr_data.hex(),
        "time": encr_time.hex(),
        "nonce": nonce.hex()
    })

def unwrap(key: bytes, enc_json: str) -> (str, str):
    enc_data = json.loads(enc_json)
    nonce = bytes.fromhex(enc_data["nonce"])
    enc_time = bytes.fromhex(enc_data["time"])
    enc_data = bytes.fromhex(enc_data["data"])

    cipher = AES.new(key, AES.MODE_CTR, nonce=nonce)
    data = cipher.decrypt(enc_data)
    cipher = AES.new(key, AES.MODE_CTR, nonce=nonce)
    time = cipher.decrypt(enc_time)
    return (data.decode("utf-8"), time.decode("utf-8"))

if __name__ == "__main__":
    print("Welcome to the treasury!")
    print("We have encrypted many different secrets already and offer")
    print("to do the same for you! One example we have here:")
    print(wrap(KEY, FLAG))

    while True:
        print("What would you like to do?")
        print(" 1. Wrap")
        print(" 2. Unwrap")
        print(" 3. Exit")
        answer = input("> ").strip()
        try:
            if answer == "1":
                data = input("Enter the data to wrap\n> ").strip()
                data = wrap(KEY, data)
                print("Its wrapped now:")
                print(data)
            if answer == "2":
                data = input("Enter the data to unwrap\n> ").strip()
                data, time = unwrap(KEY, data)
                if data == FLAG:
                    print(f"Sorry, we can't tell you what was wrapped at {time}.")
                    continue
                print(f"Data unwrapped (was created at {time}):")
                print(data)
            if answer == "3":
                print("Exiting...")
                break
        except:
            print("Something went wrong.")
