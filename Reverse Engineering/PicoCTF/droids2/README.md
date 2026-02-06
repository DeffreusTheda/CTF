# droids2 - PicoCTF 2019

###### Author: Jason

Find the pass, get the flag. Check out this [file](https://jupiter.challenges.picoctf.org/static/b7d30de6eaaf83e685aea7c10c5bdea8/two.apk).

## Files

Similar to previous challenges...
Only difference is in `FlagstaffHill.java`:

```Java
public class FlagstaffHill {  
    public static native String sesame(String str);  
  
    public static String getFlag(String input, Context ctx) {  
        String[] witches = {"weatherwax", "ogg", "garlick", "nitt", "aching", "dismass"};  
        int second = 3 - 3;  
        int third = (3 / 3) + second;  
        int fourth = (third + third) - second;  
        int fifth = 3 + fourth;  
        int sixth = (fifth + second) - third;  
        String password = "".concat(witches[fifth]).concat(".").concat(witches[third]).concat(".").concat(witches[second]).concat(".").concat(witches[sixth]).concat(".").concat(witches[3]).concat(".").concat(witches[fourth]);  
        return input.equals(password) ? sesame(input) : "NOPE";  
    }  
}
```

There's still native code here...
However, based on `droids1`,
we can assume the password for both native and Java are the same, hopefully :v
We can just run this java code to see what the password is:

![[Reverse Engineering/PicoCTF/droids2/Screenshot 2025-01-01 at 21.09.25.png]]

So, I see, the password is `dismass.ogg.weatherwax.aching.nitt.garlick`!

So just do the same like in previous challenges,
get data pointed by `unscramble`'s first argument,
and just do the same kind of solver!

## Solver

```Python3
oregano = b'\x14\x00\x10\x02\x22\x27\x35\x55\x18\x0f\x06\x5a\x59\x0c\x12\x5a\x11\x0a\x07\x05\x4f\x1e\x4f\x17\x0c\x1d\x1b\x07\x13\x4b\x40\x0a\x1b\x18\x41\x12\x13\x0f\x6c\x00'
key = b"dismass.ogg.weatherwax.aching.nitt.garlick"
key_len = len(key)

for i in range(0x27):
    print(chr(oregano[i] ^ key[i % key_len]), end='')
print()
```

```sh
> python3 solve.py
picoCTF{what.is.your.favourite.colour}
```

Flag: `picoCTF{what.is.your.favourite.colour}`
