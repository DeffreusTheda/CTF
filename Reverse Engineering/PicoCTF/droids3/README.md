# droids3 - PicoCTF 2019

###### Author: Jason

Find the pass, get the flag. Check out this [file](https://jupiter.challenges.picoctf.org/static/b7d30de6eaaf83e685aea7c10c5bdea8/two.apk).

## Files

Similar to previous challenges...
Only difference is in `FlagstaffHill.java`:

```
public class FlagstaffHill {  
    public static native String cilantro(String str);  
  
    public static String nope(String input) {  
        return "don't wanna";  
    }  
  
    public static String yep(String input) {  
        return cilantro(input);  
    }  
  
    public static String getFlag(String input, Context ctx) {  
        String flag = nope(input);  
        return flag;  
    }
```

Seems like this time,
it's hardcoded to fail.
Doesn't matter that much.

Welp, this doesn't differ much from that with `droids0` :>
The key is `againmissing`, that's it.

Underwhelming :/
Something about the solve count on `droids3` compared to `droids4` kinda bothers me.

## Solver

```Python
sumac = b'\x11\x0e\x02\x06\x2d\x39\x2f\x08\x07\x00\x1d\x49\x03\x12\x15\x47\x0f\x43\x1a\x10\x01\x08\x1a\x04\x09\x1a\x00'
key = b"againmissing"
key_len = len(key)

for i in range(0x1a):
    print(chr(sumac[i] ^ key[i % key_len]), end='')
print()
```

```sh
> python3 solve.py
picoCTF{tis.but.a.scratch}
```

Flag: `picoCTF{tis.but.a.scratch}`
