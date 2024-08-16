# number mashing Writeup by Deffreus - DownUnderCTF 2024

```$ file number-mashing 
number-mashing: ELF 64-bit LSB pie executable, ARM aarch64, version 1 (SYSV), dynamically linked, interpreter /lib/ld-linux-aarch64.so.1, BuildID[sha1]=ab93f9bc0ec8c3d321da1b7e954e739e13ee8ab1, for GNU/Linux 3.7.0, not stripped
```
```$ du -h number-mashing 
16K	number-mashing
```

OH MY HOLY GRAIL

aarch64 binary!!

This is weird...

```number-mashing.c
  __isoc99_scanf("%d %d",&local_11c,&local_118);
  if (((local_11c == 0) || (local_118 == 0)) || (local_118 == 1)) {
    puts("Nope!");
                    // WARNING: Subroutine does not return
    exit(1);
  }
  local_114 = 0;
  if (local_118 != 0) {
    local_114 = local_11c / local_118;
  }
  if (local_114 != local_11c) {
    puts("Nope!");
                    // WARNING: Subroutine does not return
    exit(1);
  }
```

How is it possible to pass through this check?
This might have something to do with `int`.
I decided to test some things out with this code:

```test.c
#include <stdio.h>

int main() {
	int var;

	scanf("%d", &var);
	printf("%d", var);
}
```

```
$  rgcc test.c
2147483646                    
2147483646%                                                   $  rgcc test.c
2147483647
2147483647%                                                   $  rgcc test.c
2147483648
-2147483648%                                                  $  ./attempt.sh 
Give me some numbers: 2147483648 -1
Correct! DUCTF{w0w_y0u_just_br0ke_math!!}
```

Well, took me a f'ing hour to realize this :/
