`Author: Yannik` | Hard

Zero minus zero equals zero. How can it ever be non-zero?

[floats](https://wwctf.com/files/f7bc5f903f4557f62185f86aa0e52a87/floats?token=eyJ1c2VyX2lkIjoxNDY0LCJ0ZWFtX2lkIjo0ODgsImZpbGVfaWQiOjIyfQ.Z0sQ5g.sPYZwAAyPmzOG8de6STUlfGRlb8 "floats")

## Files

```
> file floats 
floats: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=f32b4ecae8e02e358443b456f949d08bb3ae4af0, for GNU/Linux 3.2.0, not stripped
```

I used [dogbolt.com](https://dogbolt.org/?id=aa69e522-3374-4753-a8be-236a3b6e22e5#Ghidra=2066&Hex-Rays=1831) with Hex-Rays cuz it says `ALL OK, ... successfully decompiled` which seems really promising.

```
> strings floats               
/lib64/ld-linux-x86-64.so.2
puts
__stack_chk_fail
strlen
__libc_start_main
__cxa_finalize
printf
libc.so.6
GLIBC_2.4
GLIBC_2.2.5
GLIBC_2.34
_ITM_deregisterTMCloneTable
__gmon_start__
_ITM_registerTMCloneTable
PTE1
u+UH
 u{H
Usage: %s <flag>
Correct!
Wrong :(
9*3$"
GCC: (Ubuntu 13.2.0-23ubuntu4) 13.2.0
Scrt1.o
__abi_tag
crtstuff.c
deregister_tm_clones
__do_global_dtors_aux
completed.0
__do_global_dtors_aux_fini_array_entry
frame_dummy
__frame_dummy_init_array_entry
challenge.c
__FRAME_END__
_DYNAMIC
__GNU_EH_FRAME_HDR
_GLOBAL_OFFSET_TABLE_
__libc_start_main@GLIBC_2.34
_ITM_deregisterTMCloneTable
puts@GLIBC_2.2.5
check2
_edata
_fini
strlen@GLIBC_2.2.5
__stack_chk_fail@GLIBC_2.4
printf@GLIBC_2.2.5
__data_start
__gmon_start__
__dso_handle
_IO_stdin_used
_end
check1
__bss_start
main
__TMC_END__
_ITM_registerTMCloneTable
__cxa_finalize@GLIBC_2.2.5
_init
.symtab
.strtab
.shstrtab
.interp
.note.gnu.property
.note.gnu.build-id
.note.ABI-tag
.gnu.hash
.dynsym
.dynstr
.gnu.version
.gnu.version_r
.rela.dyn
.rela.plt
.init
.plt.got
.plt.sec
.text
.fini
.rodata
.eh_frame_hdr
.eh_frame
.init_array
.fini_array
.dynamic
.data
.bss
.comment
```

Seems like the program just read flag from input and tell you if it's right or wrong.
It has a lot of sections headers, interesting, really way more than usual especially for a small binary like this.
You see, these `.dyn*` headers relate to the process of dynamic linking.

You can even see the original source code file name, and some potentially interesting functions name like `check2` and `check1`.

## Background Information

### Float Structure in 64-bit

|Field|Length (bits)|Description|
|---|---|---|
|**Sign**|1 bit|Indicates positive (0) or negative (1).|
|**Exponent**|11 bits|Encodes the range of the value using a biased representation.|
|**Mantissa**|52 bits|Stores the significant digits (fractional part).|

### Main

```c
undefined8 main(int argc,undefined8 *argv) {
  undefined4 _check_result;
  size_t _input_len;
  
  if (argc == 2) {
    _input_len = strlen((char *)argv[1]);
    if (((_input_len == 0x20) &&
        (_check_result = check1(*(ulong *)argv[1],((ulong *)argv[1])[1]),
        (char)_check_result != '\0')) &&
       (_check_result = check2(*(ulong *)(argv[1] + 0x10),*(long *)(argv[1] + 0x18)),
       (char)_check_result != '\0')) {
      puts("Correct!");
    }
    else {
      puts("Wrong :(");
    }
  }
  else {
    printf("Usage: %s <flag>\n",(char *)*argv);
  }
  return 0;
}
```

Looks horrible, I guess.

### check1

Return 0xXXXXXXYY, where XXXXXX comes from `(uint)_result  >> 8`,
and YY from `_result != 0.0`.
To pass, it shouldn't return 0x00000000, so YY should not be zero i.e. `_result` is zero.