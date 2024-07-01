# PicoCTF Writeup by Deffreus - PicoCTF 2019

Just modify the code to print the flag LMAO.
To reverse a XOR, just XOR it again!

```vaultDoor6.java
static public void printPassword() {
	byte[] myBytes = {
		0x3b, 0x65, 0x21, 0xa , 0x38, 0x0 , 0x36, 0x1d,
		0xa , 0x3d, 0x61, 0x27, 0x11, 0x66, 0x27, 0xa ,
		0x21, 0x1d, 0x61, 0x3b, 0xa , 0x2d, 0x65, 0x27,
		0xa , 0x66, 0x36, 0x30, 0x67, 0x6c, 0x64, 0x6c,
	};
	for ( int i = 0; i < myBytes.length; ++i) {
		System.out.print(Integer.toString(myBytes[i] ^ 0x55, 16));
	}
}
```

Just make sure it's called in `main()` (also comment the checking code) and run the code!

```$ javac VaultDoor6.java && java VaultDoor6 
Enter vault password: idc bleh
6e30745f6d5563485f6834724433725f7448346e5f7830725f33636532393139
```
```$ python3
Python 3.12.3 (main, Apr 17 2024, 00:00:00) [GCC 13.2.1 20240316 (Red Hat 13.2.1-7)] on linux
Type "help", "copyright", "credits" or "license" for more information.
>>> s = '6e30745f6d5563485f6834724433725f7448346e5f7830725f33636532393139'
>>> len(s)
64
>>> for i in range(0,len(s),2):
...     print(chr(int(s[i:i+2],16)),end='')
... 
n0t_mUcH_h4rD3r_tH4n_x0r_3ce2919>>> 
```

That means the flag is `picoCTF{n0t_mUcH_h4rD3r_tH4n_x0r_3ce2919}`
