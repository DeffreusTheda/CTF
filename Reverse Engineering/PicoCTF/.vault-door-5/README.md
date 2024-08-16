# vault-door-5 Writeup by Deffreus - PicoCTF 2019

```vault-door-5.java
public boolean checkPassword(String password) {
	String urlEncoded = urlEncode(password.getBytes());
	String base64Encoded = base64Encode(urlEncoded.getBytes());
	String expected = "JTYzJTMwJTZlJTc2JTMzJTcyJTc0JTMxJTZlJTY3JTVm"
	+ "JTY2JTcyJTMwJTZkJTVmJTYyJTYxJTM1JTY1JTVmJTM2"
	+ "JTM0JTVmJTM4JTM0JTY2JTY0JTM1JTMwJTM5JTM1";
	return base64Encoded.equals(expected);
}
```

```sh
$ echo "JTYzJTMwJTZlJTc2JTMzJTcyJTc0JTMxJTZlJTY3JTVmJTY2JTcyJTMwJTZkJTVmJTYyJTYxJTM1JTY1JTVmJTM2JTM0JTVmJTM4JTM0JTY2JTY0JTM1JTMwJTM5JTM1" | base64 -d
%63%30%6e%76%33%72%74%31%6e%67%5f%66%72%30%6d%5f%62%61%35%65%5f%36%34%5f%38%34%66%64%35%30%39%35
$ python3
Python 3.12.3 (main, Apr 17 2024, 00:00:00) [GCC 13.2.1 20240316 (Red Hat 13.2.1-7)] on linux
Type "help", "copyright", "credits" or "license" for more information.
>>> s = '63306e76337274316e675f6672306d5f626135655f36345f3834666435303935'
>>> for i in range(0,len(s),2):
...     print(chr(int(s[i:i+2],16)),end='')
... 
c0nv3rt1ng_fr0m_ba5e_64_84fd5095>>> 
>>>
```

Then, the flag is `picoCTF{c0nv3rt1ng_fr0m_ba5e_64_84fd5095}`
