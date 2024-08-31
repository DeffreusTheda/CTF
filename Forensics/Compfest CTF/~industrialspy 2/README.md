# industrialspy 2 Writeup by Deffreus - CompfestCTF 16

######  Author: k3ng

## Description

After we intercepted Lyubov's last attempt at stealing documents, she disabled our RAM capturer.
Fortunately, we still have other loggers active.
Is she still trying?

[traffic.pcapng](https://ctf.compfest.id/files/4cfb81a1c0c9420fef9224284e29e7b1/traffic.pcapng?token=eyJ1c2VyX2lkIjo3MiwidGVhbV9pZCI6MzA3LCJmaWxlX2lkIjo0M30.ZrDI4g.Vg_0XZqm48xsvxTDDXzl7huHE18)

## Solution

This writeup is a big help.
https://teamrocketist.github.io/2017/08/29/Forensics-Hackit-2017-USB-ducker/

```
$ tshark -r traffic.pcapng -Y 'usb.irp_info == 0x01' -T fields -e usbhid.data >extracted
```

I've tried with adding `&& usb.irp_id == 0xffff8082e120d920` for the `-Y` argument, because I thought the logs is one way.
It cause quite a lot of characters to be missing.

`solve.py`:

```solve.py
KEY_CODES = {
    0x00:['<0>', '<!0>'],
    0x04:['a', 'A'],
    0x05:['b', 'B'],
    0x06:['c', 'C'],
    0x07:['d', 'D'],
    0x08:['e', 'E'],
    0x09:['f', 'F'],
    0x0A:['g', 'G'],
    0x0B:['h', 'H'],
    0x0C:['i', 'I'],
    0x0D:['j', 'J'],
    0x0E:['k', 'K'],
    0x0F:['l', 'L'],
    0x10:['m', 'M'],
    0x11:['n', 'N'],
    0x12:['o', 'O'],
    0x13:['p', 'P'],
    0x14:['q', 'Q'],
    0x15:['r', 'R'],
    0x16:['s', 'S'],
    0x17:['t', 'T'],
    0x18:['u', 'U'],
    0x19:['v', 'V'],
    0x1A:['w', 'W'],
    0x1B:['x', 'X'],
    0x1C:['y', 'Y'],
    0x1D:['z', 'Z'],
    0x1E:['1', '!'],
    0x1F:['2', '@'],
    0x20:['3', '#'],
    0x21:['4', '$'],
    0x22:['5', '%'],
    0x23:['6', '^'],
    0x24:['7', '&'],
    0x25:['8', '*'],
    0x26:['9', '('],
    0x27:['0', ')'],
    0x28:['\n','\n'],
    0x2C:[' ', ' '],
    0x2D:['-', '_'],
    0x2E:['=', '+'],
    0x2F:['[', '{'],
    0x30:[']', '}'],
    0x32:['#','~'],
    0x33:[';', ':'],
    0x34:['\'', '"'],
    0x36:[',', '<'],
    0x38:['/', '?'],
    0x37:['.', '>'],
    0x2b:['\t','\t'],
    0x4f:[u'→',u'→'],
    0x50:[u'←',u'←'],
    0x51:[u'↓',u'↓'],
    0x52:[u'↑',u'↑']
}
res = ''
skip = 0
with open('extracted', 'rb') as extracted:
    for line in extracted:
        if skip < 3:
            skip += 1
            continue
        b = int(line[4:6].decode('utf-8'), 16)
        if b == 0:
            continue
        s = 1 if line[:2] == b'02' else 0
        res += KEY_CODES[b][s]
print(res)
```

I used `skip` because 3 configuration and setup packets are included, and they need to be skipped.
I could just delete it through a hex editor but I was lazy to open up another program.

```
$ python3 solve.py
chrome
youtube.com/watch?v=p7YXXieghto
discord
hello, i got news. i think this is the flag COMPFEST16{L0Ve_m3_s0me_USB_f0rens1CS_fd746ec8b3}. lyubov.
```

Yay!

Flag: `COMPFEST16{L0Ve_m3_s0me_USB_f0rens1CS_fd746ec8b3}`
