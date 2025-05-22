kbd_US = [
    0,  27, '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '=', '\b',   
  '\t', # <-- Tab */
  'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', '[', ']', '\n',     
    0, # <-- control key */
  'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';', '\'', '`',  0, '\\', 'z', 'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '/',   0,
  '*',
    0,  # Alt */
  ' ',  # Space bar */
    0,  # Caps lock */
    0,  # 59 - F1 key ... > */
    0,   0,   0,   0,   0,   0,   0,   0,
    0,  # < ... F10 */
    0,  # 69 - Num lock*/
    0,  # Scroll Lock */
    0,  # Home key */
    0,  # Up Arrow */
    0,  # Page Up */
  '-',
    0,  # Left Arrow */
    0,
    0,  # Right Arrow */
  '+',
    0,  # 79 - End key*/
    0,  # Down Arrow */
    0,  # Page Down */
    0,  # Insert Key */
    0,  # Delete Key */
    0,   0,   0,
    0,  # F11 Key */
    0,  # F12 Key */
    0,  # All other keys are undefined */
];

scancode_map = {
    0x02: '1', 0x03: '2', 0x04: '3', 0x05: '4',
    0x06: '5', 0x07: '6', 0x08: '7', 0x09: '8',
    0x0A: '9', 0x0B: '0', 0x1E: 'a', 0x30: 'b',
    0x2E: 'c', 0x20: 'd', 0x12: 'e', 0x21: 'f',
    0x22: 'g', 0x23: 'h', 0x17: 'i', 0x24: 'j',
    0x25: 'k', 0x26: 'l', 0x32: 'm', 0x31: 'n',
    0x18: 'o', 0x19: 'p', 0x10: 'q', 0x13: 'r',
    0x1F: 's', 0x14: 't', 0x16: 'u', 0x2F: 'v',
    0x11: 'w', 0x2D: 'x', 0x15: 'y', 0x2C: 'z',
    0x39: ' ',  # Space
    0x0E: '`', 0x1A: '[', 0x1B: ']', 0x2B: '\\',
    0x27: ';', 0x28: "'", 0x33: ',', 0x34: '.',
    0x35: '/', 0x0C: '-', 0x0D: '=',

    # Shift + number keys for special characters
    0x02 | 0x80: '!', 0x03 | 0x80: '@', 0x04 | 0x80: '#', 0x05 | 0x80: '$',
    0x06 | 0x80: '%', 0x07 | 0x80: '^', 0x08 | 0x80: '&', 0x09 | 0x80: '*',
    0x0A | 0x80: '(', 0x0B | 0x80: ')',

    # Shift + other keys
    0x1A | 0x80: '{', 0x1B | 0x80: '}', 0x2B | 0x80: '|', 0x27 | 0x80: ':',
    0x28 | 0x80: '"', 0x33 | 0x80: '<', 0x34 | 0x80: '>', 0x35 | 0x80: '?',
    0x0E | 0x80: '~', 0x0C | 0x80: '_', 0x0D | 0x80: '+',

    # Number pad (if applicable)
    0x4F: '1', 0x50: '2', 0x51: '3', 0x4B: '4',
    0x4C: '5', 0x4D: '6', 0x47: '7', 0x48: '8',
    0x49: '9', 0x52: '0', 0x37: '*', 0x4A: '-',
    0x4E: '+', 0x53: '.'
}

def decode_scancodes(file):
    with open(file, "rb") as f:
        data = f.read()
        # decoded = ''.join(scancode_map.get(byte, '?') for byte in data)
        for i in range(0,len(data),2):
            print(kbd_US[int(data[i:i+2], 16)], end='')

decode_scancodes("data")

