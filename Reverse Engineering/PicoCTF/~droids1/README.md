# droids1 - PicoCTF 2019

###### Author: Jason

Find the pass, get the flag. Check out this [file](https://jupiter.challenges.picoctf.org/static/b12c6d058c7f52eb1fd2015cfd291716/one.apk).

<details><summary>Hint 1</summary>
Try using apktool and an emulator
</details>

<details><summary>Hint 2</summary>
https://ibotpeaches.github.io/Apktool/
</details>

<details><summary>Hint 3</summary>
https://play.picoctf.org/practice/challenge/14?category=3&page=2&solved=1
</details>

## Files

This one is more or less the same with `droids0`,
including the `MainActivity.java` code.
If you haven't read that write-up,
then what else to wait?
What differs is `FlagstaffHill`.

## Reversing

```Java
public class FlagstaffHill {  
    public static native String fenugreek(String str);  
  
    public static String getFlag(String input, Context ctx) {  
        String password = ctx.getString(R.string.password);  
        return input.equals(password) ? fenugreek(input) : "NOPE";  
    }  
}
```

So there's a password check on this _one_.
We can just ripgrep the password,

```sh
> rg '"password"'
resources/res/values/strings.xml
50:    <string name="password">opossum</string>

resources/res/values/public.xml
893:    <public type="string" name="password" id="0x7f0b002f" />
```

and we have it!
`opossum` is the password.

But what we're after is the return of `fenugreek`.
I swear these native function names are weird...
It should be on the `hellojni` library,
and again I'm going for the x86_64 _one_.

![[Reverse Engineering/PicoCTF/droids1/Screenshot 2025-01-01 at 20.48.30.png]]

This time, it call `anise` on success.
The problem is that,

![[Reverse Engineering/PicoCTF/droids1/Screenshot 2025-01-01 at 20.49.42.png]]

the key is based on the argument!
It's passed with `pcVar2`.
However, a peculiar function in `fenugreek`,
might give a hint on this one, namely `nutmeg`.
Based on `fenugreek`,
its return value must be evaluated as true to get to `anise`.

![[Reverse Engineering/PicoCTF/droids1/Screenshot 2025-01-01 at 20.51.17.png]]

Okay, so it just checks if the input,
equivalent to the key,
is equal to that...
If we see `alphabet`,
it points to this:

![[Reverse Engineering/PicoCTF/droids1/Screenshot 2025-01-01 at 20.53.41.png]]

Just a lowercase charset!
We can see what `nutmeg` expects as the key,

```Python
alphabet = b"abcdefghijklmnopqrstuvwxyz"

key = [alphabet[0xe], alphabet[0xf], alphabet[0xe], alphabet[0x12], alphabet[0x12], alphabet[0x14], alphabet[0xc]]

print(''.join(chr(c) for c in key))
```

```sh
> python3 key.py
opossum
```

It's the same password,
I really thought it would differ from the Java password...
sigh.

Anyway, so now that we know the key for `anise` is `opossum`,
we can unscramble the data!
This is just the same process as `droids0`,
but with different data :p

## Solver

```Python
anise = [0x1f, 0x19, 0x0c, 0x1c, 0x30, 0x21, 0x2b, 0x14, 0x00, 0x06, 0x1d, 0x1a, 0x1b, 0x0a, 0x41, 0x16, 0x00, 0x01, 0x5d, 0x01, 0x05, 0x0a, 0x5e, 0x09, 0x19, 0x1c, 0x07, 0x09, 0x1c, 0x0d, 0x00]
key = b"opossum"
key_len = len(key)

for i in range(0x1e):
    print(chr(anise[i] ^ key[i % key_len]), end='')
print()
```

```sh
> python3 solve.py
picoCTF{pining.for.the.fjords}
```

Flag: `picoCTF{pining.for.the.fjords}`
