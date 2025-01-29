import winreg
import subprocess
import sys
import os
import random
import string
import json

class RegistryManager:
    def __init__(self):
        self.root = winreg.HKEY_CURRENT_USER
        self.base_path = r"Software\OneShot"
        self._ensure_base_exists()
    
    def _ensure_base_exists(self):
        try:
            winreg.CreateKey(self.root, self.base_path)
        except:
            pass
    
    def set(self, name, value):
        try:
            key = winreg.CreateKey(self.root, self.base_path)
            # print(f'[!] SET {name} ({type(value)}) = {value}')
            try:
                if isinstance(value, int):
                    if -2**31 <= value <= 2**31 - 1:
                        winreg.SetValueEx(key, name, 0, winreg.REG_DWORD, value & 0xFFFFFFFF)
                    else:
                        winreg.SetValueEx(key, name, 0, winreg.REG_SZ, hex(value))  # Store as hex string
                elif isinstance(value, bytes):
                    winreg.SetValueEx(key, name, 0, winreg.REG_BINARY, value)
                elif isinstance(value, (list, dict)):
                    serialized = json.dumps(value, default=lambda x: x.hex() if isinstance(x, bytes) else str(x))
                    winreg.SetValueEx(key, name, 0, winreg.REG_SZ, serialized)
                else:
                    winreg.SetValueEx(key, name, 0, winreg.REG_SZ, str(value))
            finally:
                winreg.CloseKey(key)
        except WindowsError as e:
            raise WindowsError(f"Failed to set {name}: {e}")

    def u2s(self, v):
        if v > 0x7FFFFFFF:
            return v - 0x100000000
        return v
    def get(self, name):
        try:
            key = winreg.OpenKey(self.root, self.base_path, 0, winreg.KEY_READ)
            try:
                value, regtype = winreg.QueryValueEx(key, name)
                if regtype == winreg.REG_DWORD:
                    value = self.u2s(value)
                elif regtype == winreg.REG_SZ and value.startswith('0x'):
                    value = int(value, 16)  # Convert hex string to int
                elif regtype == winreg.REG_SZ and (value.startswith('[') or value.startswith('{')):
                    try:
                        value = json.loads(value)
                        if isinstance(value, list):
                            value = [bytes.fromhex(item) if isinstance(item, str) and all(c in '0123456789abcdef' for c in item) else item for item in value]
                    except json.JSONDecodeError:
                        pass
                # print(f'[*] GET {name} ({type(value)}) = {value}')
                return value
            finally:
                winreg.CloseKey(key)
        except WindowsError:
            return None

    def delete(self, name):
        """Delete a registry value"""
        try:
            key = winreg.OpenKey(self.root, self.base_path, 0, winreg.KEY_WRITE)
            winreg.DeleteValue(key, name)
            winreg.CloseKey(key)
        except:
            pass

def main():
    reg = RegistryManager()
    
    if reg.get('r8') == '.effie':
        print()
        print("You've done it, my man.")
        print("The sun now glows a little brighter.")
        print("\"Thank you for playing.\"")
        print()
        destruction(reg, False)
    if any((reg.get('r'+str(k)) is not None) for k in range(8)):
        print()
        print("You return to the same room.")
        print("Niko is still there. Waiting.")
        print("\"You failed last time. We're stuck in a loop now.\"")
        print("\"Like Sisyphus pushing the boulder. Like Bill Murray in Groundhog Day.\"")
        print("\"We're trapped here. Forever. Rolling the same rock up the same hill.\"")
        print("\"There's no way out anymore. You had one chance.\"")
        print("[The program terminates. The loop is sealed.]")
        print()
        destruction(reg, False)
    
    print()
    print("Niko is trapped in a puzzle.")
    print("Scratches on the walls read:")
    print()
    print("   THIS IS YOUR ONLY CHANCE.   ")
    print("ONE SHOT, OR STUCK HERE TRYING,")
    print("            FOREVER.           ")
    print()
    print("\"Please... you have to help me. I don't understand this.\"")
    print("Niko looks at you with desperate hope.")
    print()
    
    try:
        reg.set('r0', input("\"Do you know the way out?\"\n> ").strip().encode())
        # reg.set('r0', flag)
        print(reg.get('r0'))
        if len(reg.get('r0')) != 162:
            destruction(reg)
    except EOFError:
        destruction(reg)
    
    reg.set('r1', [reg.get('r0')[i*27:(i+1)*27] for i in range(6)])
    reg.set('r0', 0) # state

    while True:
        if reg.get('r0') == 0: # Multi-round Feistel
            print(f'============{reg.get('r0')}===========')
            reg.set('r3', [213, 102, 213, 85, 64, 198, 119, 243, 85, 179, 64, 85, 230, 183, 115, 179, 85, 179, 85, 179, 247, 179, 230, 102, 179, 102, 85])
            reg.set('r2', 0)
            while reg.get('r2') < 27:
                reg.set('r4', reg.get('r1')[reg.get('r0')][reg.get('r2')])
                reg.set('r6', 0)
                while reg.get('r6') < 4:
                    reg.set('r5', (reg.get('r4') >> 4) & 0xF)
                    reg.set('r6', reg.get('r4') & 0xF)
                    # Feistel function: mix left half into right
                    reg.set('r6', reg.get('r6') ^ ((reg.get('r5') * 7 + reg.get('r6') * 3) ^ (reg.get('r5') << 1)) & 0xF)
                    # Swap halves
                    reg.set('r4', (reg.get('r6') << 4) | reg.get('r5'))
                reg.set('r1',
                    reg.get('r1')[:reg.get('r0')] + [
                        reg.get('r1')[reg.get('r0')][:reg.get('r2')] + \
                        bytes([reg.get('r4')]) + \
                        reg.get('r1')[reg.get('r0')][reg.get('r2')+1:]
                    ] + \
                    reg.get('r1')[reg.get('r0')+1:]
                )
                if reg.get('r1')[reg.get('r0')][reg.get('r2')] != reg.get('r3')[reg.get('r2')]:
                    destruction(reg)
                reg.set('r2', reg.get('r2') + 1)
            reg.set('r0', reg.get('r0') + 1)        

        elif reg.get('r0') == 1: # yea yea yea
            print(f'============{reg.get('r0')}===========')
            reg.set('r4', [152, 245, 229, 38, 25, 181, 212, 42, 27, 185, 33, 161, 163, 166, 229, 114, 162, 239, 0, 215, 13, 152, 169, 181, 40, 122, 200])
            reg.set('r3', 0x42) # state
            reg.set('r2', 0) # idx
            while reg.get('r2') < 27:
                reg.set('r3', ((reg.get('r3') * 17) ^ reg.get('r2')) & 0xFF)
                reg.set('r1',
                    reg.get('r1')[:reg.get('r0')] + [
                        reg.get('r1')[reg.get('r0')][:reg.get('r2')] + \
                        bytes([(reg.get('r1')[reg.get('r0')][reg.get('r2')] + reg.get('r3')) & 0xFF]) + \
                        reg.get('r1')[reg.get('r0')][reg.get('r2')+1:]
                    ] + \
                    reg.get('r1')[reg.get('r0')+1:]
                )
                if reg.get('r1')[reg.get('r0')][reg.get('r2')] != reg.get('r4')[reg.get('r2')]:
                    destruction(reg)
                reg.set('r2', reg.get('r2') + 1)
            reg.set('r0', reg.get('r0') + 1)
                
        elif reg.get('r0') == 2: # custom base69 + base73
            print(f'============{reg.get('r0')}===========')
            reg.set('r3', []) # digits
            reg.set('r2', int.from_bytes(reg.get('r1')[reg.get('r0')])) # n
            while reg.get('r2') > 0:
                reg.set('r3', [reg.get('r2') % 69] + reg.get('r3'))
                reg.set('r2', reg.get('r2') // 69)
            reg.set('r2', 0) # n
            for d in reg.get('r3'):
                reg.set('r2', 69 * reg.get('r2') + d)
            reg.set('r3', []) # digits
            while reg.get('r2') > 0:
                reg.set('r3', [reg.get('r2') % 73] + reg.get('r3'))
                reg.set('r2', reg.get('r2') // 73)
            if reg.get('r3') != [9, 41, 37, 34, 21, 5, 29, 42, 16, 37, 31, 5, 53, 18, 72, 65, 5, 23, 67, 26, 30, 53, 64, 7, 55, 19, 27, 22, 68, 62, 18, 1, 39, 6, 50]:
                destruction(reg)
            reg.set('r0', reg.get('r0') + 1)

        elif reg.get('r0') == 3: # jump by ascii value
            print(f'============{reg.get('r0')}===========')
            reg.set('r4', """
========================
  THE ENIGMA OF HEAVEN
=====================†==

PRAISE THE LORD! The air conditioner keeps them away it sings gospels and
PRA†SE THE LORD! Finding faith in whit† noise.
PRAISE THE LORD! The messages are coming in loud and clear and
I hear them and I see them in the sky the towers are sending m†ssages and
I hear them and I see t†em.
PRAISE THE LORD! The people in the parking lot can't hurt me anymore
they can't hurt me †ny†ore their words are weak an† the lord is strong.
PRAIS† THE LORD† The bibl††shows the way and†the way protects me and
I've seen the messages and I†heart them and † see them and they can't
hurt me anymore†
PRAISE THE LORD!

CHAPTERS:      †                          ╔═══════════════╗
—————————                                 ║               ║
I. The Eni†ma of Hea†en:                  ║†   H†AVEN     ║
 9†999,999 Channels,†Finding Faith†    †  ╟───────────────╢
 in White Noise... The God Stimulation!   ║               ║
II. The Hierarchy of Equality:            ║   †ADIATION   ║
 Angelic Voices Echo Through the Halls    ╟───────────────╢
 of Heaven, Under the Railroad Bridge     ║               ║    "And I have
III. The Paradox of Faith:                ║     RADIO     ║      told you
 There's a Knocking at the Door!          ╟───────────────╢     the TRUTH,
 God is in, God is in!                    ║               ║
IV. The Senselessness of Endlessness:     ║  TELEVISION   ║      for you
 Returning to an Empty Apartment          ║               ║   are my child,
 with a Grocery Store Guardian Angel      ╚═══════════════╝    and you have
                                                              seen my face"

An EP titled "The Enigma of Heaven and Other Daily De†usions" """)
            reg.set('r2', 0)
            reg.set('r3', 0)
            while reg.get('r2') < 27:
                reg.set('r3',
                    reg.get('r3') + \
                    (reg.get('r1')[reg.get('r0')][reg.get('r2')] - 0x10) * \
                    (2 if reg.get('r2') & 1 == 0 else -1)
                )
                try:
                    if reg.get('r4')[reg.get('r3')] != '†':
                        destruction(reg)
                except IndexError:
                    destruction(reg)
                reg.set('r2', reg.get('r2') + 1)
            reg.set('r0', reg.get('r0') + 1)
        
        elif reg.get('r0') == 4: # modmod
            print(f'============{reg.get('r0')}===========')
            reg.set('r2', 0)
            reg.set('r3', 0) # a = x // 10
            reg.set('r4', 0) # b = x % 10
            reg.set('r5', [(9, 5), (14, 8), (19, 6), (29, 4), (33, 8), (43, 3), (54, 5), (65, 3), (70, 4), (75, 6), (80, 9), (86, 0), (95, 5), (105, 5), (110, 3), (119, 8), (130, 8), (135, 6), (141, 1), (150, 6), (161, 5), (166, 4), (177, 4), (187, 4), (191, 8), (201, 3), (204, 6)])
            while reg.get('r2') < 27:
                reg.set('r3', (10 * reg.get('r3') + reg.get('r4') + reg.get('r1')[reg.get('r0')][reg.get('r2')]) // 10)
                reg.set('r4', (reg.get('r4') + reg.get('r1')[reg.get('r0')][reg.get('r2')]) % 10)
                if reg.get('r5')[reg.get('r2')] != [reg.get('r3'), reg.get('r4')]:
                    destruction(reg)
                reg.set('r2', reg.get('r2') + 1)
            reg.set('r0', reg.get('r0') + 1)

        elif reg.get('r0') == 5: # ez
            print(f'============{reg.get('r0')}===========')
            reg.set('r4', [33, 20, 23, 94, 127, 14, 26, 30, 58, 27, 84, 68, 27, 51, 78, 72, 80, 62, 2, 71, 92, 65, 64, 43, 89, 87, 83])
            reg.set('r3', [73, 32, 97, 109, 32, 104, 111, 112, 101, 108, 101, 115, 115, 108, 121, 32, 99, 97, 112, 116, 105, 118, 97, 116, 101, 100, 46])
            reg.set('r2', 2)
            while reg.get('r2') < 110:
                if reg.get('r1')[reg.get('r0')][(reg.get('r2')-2)//4] ^ reg.get('r4')[(reg.get('r2')-2)//4] != reg.get('r3')[(reg.get('r2')-2)//4]:
                    destruction(reg)
                reg.set('r2', reg.get('r2') + 4)
            reg.set('r0', reg.get('r0') + 1)

        elif reg.get('r0') == 6:
            print()
            print("Niko's eyes light up. The puzzle dissolves.")
            print("\"We did it! We actually made it!\"")
            print("The way forward opens. Niko is free.")
            print()
            reg.set('r8', '.effie')
            break
        
        else: # invalid state
            destruction(reg)

def destruction(reg, mes=True):
    if mes:
        print()
        print("Niko's hope shatters.")
        print("\"No... we were so close...\"")
        print("Everything collapses. The loop seals shut.")
        print("Niko is trapped. Forever.")
        print("[System shutting down]")
        print()
    
    import time
    time.sleep(3) # Delay before spawning child

    exe_path = sys.executable if getattr(sys, 'frozen', False) else sys.argv[0]
    
    try: os.remove(exe_path)
    except: pass
    
    sys.exit(1)

if __name__ == "__main__":
    main()
