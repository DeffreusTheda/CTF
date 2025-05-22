# droids4 - PicoCTF 2019

###### Author: Jason

Reverse the pass, patch the file, get the flag. Check out this [file](https://jupiter.challenges.picoctf.org/static/926d4bfd7030b13dbc98ca26e608c740/four.apk).
## Solution

Well, the description is kinda scary.
Not really :D

Similar to previous challenges...
Only difference is in `FlagstaffHill.java`:

```
public class FlagstaffHill {  
    public static native String cardamom(String str);  
  
    public static String getFlag(String input, Context ctx) {  
        StringBuilder ace = new StringBuilder("aaa");  
        StringBuilder jack = new StringBuilder("aaa");  
        StringBuilder queen = new StringBuilder("aaa");  
        StringBuilder king = new StringBuilder("aaa");  
        ace.setCharAt(0, (char) (ace.charAt(0) + 4));  
        ace.setCharAt(1, (char) (ace.charAt(1) + 19));  
        ace.setCharAt(2, (char) (ace.charAt(2) + 18));  
        jack.setCharAt(0, (char) (jack.charAt(0) + 7));  
        jack.setCharAt(1, (char) (jack.charAt(1) + 0));  
        jack.setCharAt(2, (char) (jack.charAt(2) + 1));  
        queen.setCharAt(0, (char) (queen.charAt(0) + 0));  
        queen.setCharAt(1, (char) (queen.charAt(1) + 11));  
        queen.setCharAt(2, (char) (queen.charAt(2) + 15));  
        king.setCharAt(0, (char) (king.charAt(0) + 14));  
        king.setCharAt(1, (char) (king.charAt(1) + 20));  
        king.setCharAt(2, (char) (king.charAt(2) + 15));  
        String password = "".concat(queen.toString()).concat(jack.toString()).concat(ace.toString()).concat(king.toString());  
        return input.equals(password) ? "call it" : "NOPE";  
    }  
}
```

This one doesn't even use native code- what the hell.
Actually nevermind,
the challenge seems like asking us to implement the call to `cardamom` ourself.
Ewww, just do this static like me! ;)

I run an online Java code compiler, and got the key as `alphabetsoup`:

![[Reverse Engineering/PicoCTF/droids4/Screenshot 2025-01-01 at 21.31.25.png]]

Yeah, do the same like in previous challenges and you get the flag.
This one is closer to `droids1` or `droids2`, I don't even remember.
Nothing's new, really.

Flag: `picoCTF{not.particularly.silly}`
