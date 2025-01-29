extends Node

func _ready() -> void :
    var plaintext: = "BEECTF{redacted}"
    var key: = 90

    var data: PackedByteArray = plaintext.to_utf8_buffer()
    var encrypted: PackedByteArray = xor_bytes(data, key)
    var encrypted_hex: String = bytes_to_hex(encrypted)

    print("Encrypted (hex): ", encrypted_hex)


func xor_bytes(data: PackedByteArray, key: int) -> PackedByteArray:
    var out: = PackedByteArray()
    out.resize(data.size())
    var k: = key & 255
    for i in data.size():
        out[i] = data[i] ^ k
    return out


func bytes_to_hex(b: PackedByteArray) -> String:
    var s: = ""
    for byte in b:
        s += "%02X" % byte
    return s
