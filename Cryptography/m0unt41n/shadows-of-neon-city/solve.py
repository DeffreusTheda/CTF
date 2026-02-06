import base64
cipher = input().encode()
c_bytes = base64.b64decode(cipher)
c_int = int.from_bytes(c_bytes, 'big')
