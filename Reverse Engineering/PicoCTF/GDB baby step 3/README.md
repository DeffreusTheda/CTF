# GDB baby step 3 Writeup by Deffreus - PicoCTF picoGym

I get a x86_64 binary, with size 16k, small!

The main function just return the address `0x2262c96b`.

```
int main(int argc, const char **argv, const char **envp) {
  return 576899435; // 0x2262c96b
}
```

Now let's just read the content of the memory address!

``

Azzam X-2
Firhan X-1
Keandre X-2 Bogor
Nizam X-4 Depok
