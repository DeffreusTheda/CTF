# vault-door-7 Writeup by Deffreus - PicoCTF 2019

```VaultDoor7.java
	// 0x30: 00110000
	// 0x31: 00110001
	// 0x61: 01100001
	// 0x62: 01100010
	//
	// If we put those 4 binary numbers end to end, we end up with 32
	// bits that can be interpreted as an int.
	//
	// 00110000001100010110000101100010 -> 808542562
--- snip ---
public boolean checkPassword(String password) {
	if (password.length() != 32) {
		return false;
	}
	int[] x = passwordToIntArray(password);
	return x[0] == 1096770097
		&& x[1] == 1952395366
		&& x[2] == 1600270708
		&& x[3] == 1601398833
		&& x[4] == 1716808014
		&& x[5] == 1734293296
		&& x[6] == 842413104
		&& x[7] == 1684157793;
}
```
```$ python3
Python 3.12.3 (main, Apr 17 2024, 00:00:00) [GCC 13.2.1 20240316 (Red Hat 13.2.1-7)] on linux
Type "help", "copyright", "credits" or "license" for more information.
>>> x = [0 for i in range(8)]
>>> x[0] = 1096770097
>>> x[1] = 1952395366
>>> x[2] = 1600270708
>>> x[3] = 1601398833
>>> x[4] = 1716808014
>>> x[5] = 1734293296
>>> x[6] = 842413104
>>> x[7] = 1684157793
>>> for xi in x:
...     print(format(xi,'x'),end='')
... 
415f6231745f30665f6231745f7368316654694e675f37303236343064623561>>> 
>>> s = '415f6231745f30665f6231745f7368316654694e675f37303236343064623561'
>>> for i in range(0,len(s),2):
...     print(chr(int(s[i:i+2],16)),end='')
... 
A_b1t_0f_b1t_sh1fTiNg_702640db5a>>>
```

Thus, the flag is `picoCTF{A_b1t_0f_b1t_sh1fTiNg_702640db5a}`
