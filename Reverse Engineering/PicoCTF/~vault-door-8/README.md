# vault-door-8 - picoCTF 2019

###### Author: Mark E. Haase

Apparently Dr. Evil's minions knew that our agency was making copies of their source code, because they intentionally sabotaged this source code in order to make it harder for our agents to analyze and crack into!
The result is a quite mess, but I trust that my best special agent will find a way to solve it.
The source code for this vault is here: [VaultDoor8.java](https://jupiter.challenges.picoctf.org/static/ce6b6f8b56b6a332bd06dc71be2fc244/VaultDoor8.java)

## Files

`VaultDoor8.java`:

```java
   1   │ // These pesky special agents keep reverse engineering our source code and then
   2   │ // breaking into our secret vaults. THIS will teach those sneaky sneaks a
   3   │ // lesson.
   4   │ //
   5   │ // -Minion #0891
   6   │ import java.util.*; import javax.crypto.Cipher; import javax.crypto.spec.SecretKeySpec;
   7   │ import java.security.*; class VaultDoor8 {public static void main(String args[]) {
   8   │ Scanner b = new Scanner(System.in); System.out.print("Enter vault password: ");
   9   │ String c = b.next(); String f = c.substring(8,c.length()-1); VaultDoor8 a = new VaultDoor
       │ 8(); if (a.checkPassword(f)) {System.out.println("Access granted."); }
  10   │ else {System.out.println("Access denied!"); } } public char[] scramble(String password) {
       │ /* Scramble a password by transposing pairs of bits. */
  11   │ char[] a = password.toCharArray(); for (int b=0; b<a.length; b++) {char c = a[b]; c = swi
       │ tchBits(c,1,2); c = switchBits(c,0,3); /* c = switchBits(c,14,3); c = switchBits(c, 2, 0)
       │ ; */ c = switchBits(c,5,6); c = switchBits(c,4,7);
  12   │ c = switchBits(c,0,1); /* d = switchBits(d, 4, 5); e = switchBits(e, 5, 6); */ c = switch
       │ Bits(c,3,4); c = switchBits(c,2,5); c = switchBits(c,6,7); a[b] = c; } return a;
  13   │ } public char switchBits(char c, int p1, int p2) {/* Move the bit in position p1 to posit
       │ ion p2, and move the bit
  14   │ that was in position p2 to position p1. Precondition: p1 < p2 */ char mask1 = (char)(1 <<
       │  p1);
  15   │ char mask2 = (char)(1 << p2); /* char mask3 = (char)(1<<p1<<p2); mask1++; mask1--; */ cha
       │ r bit1 = (char)(c & mask1); char bit2 = (char)(c & mask2); /* System.out.println("bit1 " 
       │ + Integer.toBinaryString(bit1));
  16   │ System.out.println("bit2 " + Integer.toBinaryString(bit2)); */ char rest = (char)(c & ~(m
       │ ask1 | mask2)); char shift = (char)(p2 - p1); char result = (char)((bit1<<shift) | (bit2>
       │ >shift) | rest); return result;
  17   │ } public boolean checkPassword(String password) {char[] scrambled = scramble(password); c
       │ har[] expected = {
  18   │ 0xF4, 0xC0, 0x97, 0xF0, 0x77, 0x97, 0xC0, 0xE4, 0xF0, 0x77, 0xA4, 0xD0, 0xC5, 0x77, 0xF4,
       │  0x86, 0xD0, 0xA5, 0x45, 0x96, 0x27, 0xB5, 0x77, 0xD2, 0xD0, 0xB4, 0xE1, 0xC1, 0xE0, 0xD0
       │ , 0xD0, 0xE0 }; return Arrays.equals(scrambled, expected); } }
```

Ugly?
Definitely!
This is not that bad of an obfuscation to be honest.
The linebreak and indent can be simply fixed,
by pasting the code to IntelliJ Idea Ultimate :p
There's still a bit of inconvenience,
but small edits are easy!

There's also a few commented codes,
and I guess they're there to just add to the confusion?
I'm sure they're not supposed to be uncommented...

```java
import java.util.*;  
  
class VaultDoor8 {  
  public static void main(String[] args) {  
    Scanner b = new Scanner(System.in);  
    System.out.print("Enter vault password: ");  
    String c = b.next();  
    String f = c.substring(8,c.length()-1);  
    VaultDoor8 a = new VaultDoor8();  
    if (a.checkPassword(f)) {  
      System.out.println("Access granted.");  
    } else {  
      System.out.println("Access denied!");  
    }  
  }  
  public char[] scramble(String password) {  
    /* Scramble a password by transposing pairs of bits. */  
    char[] a = password.toCharArray();  
    for (int b = 0; b < a.length; b++) {  
      char c = a[b];  
      c = switchBits(c,1,2);  
      c = switchBits(c,0,3);  
      c = switchBits(c,5,6);  
      c = switchBits(c,4,7);  
      c = switchBits(c,0,1);  
      c = switchBits(c,3,4);  
      c = switchBits(c,2,5);  
      c = switchBits(c,6,7);  
      a[b] = c;  
    }  
    return a;  
  }  
  public char switchBits(char c, int p1, int p2) {  
    /* Move the bit in position p1 to position p2, and move the bit  
  that was in position p2 to position p1. Precondition: p1 < p2 */    char mask1 = (char)(1 << p1);  
    char mask2 = (char)(1 << p2);  
    char bit1 = (char)(c & mask1);  
    char bit2 = (char)(c & mask2);  
    char rest = (char)(c & ~(mask1 | mask2));  
    char shift = (char)(p2 - p1);  
    return (char)((bit1<<shift) | (bit2>>shift) | rest);  
  }  
  public boolean checkPassword(String password) {  
    char[] scrambled = scramble(password);  
    char[] expected = {0xF4, 0xC0, 0x97, 0xF0, 0x77, 0x97, 0xC0, 0xE4, 0xF0, 0x77, 0xA4, 0xD0, 0xC5, 0x77, 0xF4, 0x86, 0xD0, 0xA5, 0x45, 0x96, 0x27, 0xB5, 0x77, 0xD2, 0xD0, 0xB4, 0xE1, 0xC1, 0xE0, 0xD0, 0xD0, 0xE0};  
    return Arrays.equals(scrambled, expected);  
  }  
}
```

Just some bit swapping!
It's the same operations for all bytes,
so just do the reversal swaps,
in reverse order,
to reverse this! :D

If it's hard for you to understand `switchBits`,
don't worry!
Sometimes the function name,
and maybe after some testing,
you know what it does!

## Solver

```Python
def swap(str: str, i1, i2):
    l = list(str)
    l[i1], l[i2] = l[i2], l[i1]
    return ''.join(l)

def main():
    enc = [0xF4, 0xC0, 0x97, 0xF0, 0x77, 0x97, 0xC0, 0xE4, 0xF0, 0x77, 0xA4, 0xD0, 0xC5, 0x77, 0xF4, 0x86, 0xD0, 0xA5, 0x45, 0x96, 0x27, 0xB5, 0x77, 0xD2, 0xD0, 0xB4, 0xE1, 0xC1, 0xE0, 0xD0, 0xD0, 0xE0]

    for e in enc:
        c = bin(e)[2:].rjust(8, '0')

        c = swap(c, 6, 7);
        c = swap(c, 2, 5);
        c = swap(c, 3, 4);
        c = swap(c, 0, 1);
        c = swap(c, 4, 7);
        c = swap(c, 5, 6);
        c = swap(c, 0, 3);
        c = swap(c, 1, 2);

        print(chr(int(c, 2)), end='')

    print()

if __name__ == "__main__":
    main()
```

```sh
> python3 solve.py
s0m3_m0r3_b1t_sh1fTiNg_91c642112
```

Flag: `picoCTF{s0m3_m0r3_b1t_sh1fTiNg_91c642112}`