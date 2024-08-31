# File types Writeup by Deffreus - PicoCTF 2022

###### Author: Geoffrey Njogu

## Description

This file was found among some files marked confidential but my pdf reader cannot read it, maybe yours can.<br>
You can download the file from [here](https://artifacts.picoctf.net/c/81/Flag.pdf).

<details><summary>Hint 1</summary>
	Remember that some file types can contain and nest other files
</details>

## Files

```
$ file Flag.pdf    
Flag.pdf: shell archive text
```

## Solution

Woah!
Look at that!
The `.pdf` is just a disguise!

Okay,
it might be a lot but here's how the shell archive text looks like:

    #!/bin/sh
    # This is a shell archive (produced by GNU sharutils 4.15.2).
    # To extract the files from this archive, save it to some FILE, remove
    # everything before the '#!/bin/sh' line above, then type 'sh FILE'.
    #
    lock_dir=_sh00046
    # Made on 2023-03-16 01:40 UTC by <root@e023b7dee37c>.
    # Source directory was '/app'.
    #
    # Existing files will *not* be overwritten, unless '-c' is specified.
    #
    # This shar contains:
    # length mode       name
    # ------ ---------- ------------------------------------------
    #   1092 -rw-r--r-- flag
    #
    MD5SUM=${MD5SUM-md5sum}
    f=`${MD5SUM} --version | egrep '^md5sum .*(core|text)utils'`
    test -n "${f}" && md5check=true || md5check=false
    ${md5check} || \
      echo 'Note: not verifying md5sums.  Consider installing GNU coreutils.'
    if test "X$1" = "X-c"
    then keep_file=''
    else keep_file=true
    fi
    echo=echo
    save_IFS="${IFS}"
    IFS="${IFS}:"
    gettext_dir=
    locale_dir=
    set_echo=false
    
    for dir in $PATH
    do
      if test -f $dir/gettext \
         && ($dir/gettext --version >/dev/null 2>&1)
      then
        case `$dir/gettext --version 2>&1 | sed 1q` in
          *GNU*) gettext_dir=$dir
          set_echo=true
          break ;;
        esac
      fi
    done
    
    if ${set_echo}
    then
      set_echo=false
      for dir in $PATH
      do
        if test -f $dir/shar \
           && ($dir/shar --print-text-domain-dir >/dev/null 2>&1)
        then
          locale_dir=`$dir/shar --print-text-domain-dir`
          set_echo=true
          break
        fi
      done
    
      if ${set_echo}
      then
        TEXTDOMAINDIR=$locale_dir
        export TEXTDOMAINDIR
        TEXTDOMAIN=sharutils
        export TEXTDOMAIN
        echo="$gettext_dir/gettext -s"
      fi
    fi
    IFS="$save_IFS"
    if (echo "testing\c"; echo 1,2,3) | grep c >/dev/null
    then if (echo -n test; echo 1,2,3) | grep n >/dev/null
         then shar_n= shar_c='
    '
         else shar_n=-n shar_c= ; fi
    else shar_n= shar_c='\c' ; fi
    f=shar-touch.$$
    st1=200112312359.59
    st2=123123592001.59
    st2tr=123123592001.5 # old SysV 14-char limit
    st3=1231235901
    
    if   touch -am -t ${st1} ${f} >/dev/null 2>&1 && \
         test ! -f ${st1} && test -f ${f}; then
      shar_touch='touch -am -t $1$2$3$4$5$6.$7 "$8"'
    
    elif touch -am ${st2} ${f} >/dev/null 2>&1 && \
         test ! -f ${st2} && test ! -f ${st2tr} && test -f ${f}; then
      shar_touch='touch -am $3$4$5$6$1$2.$7 "$8"'
    
    elif touch -am ${st3} ${f} >/dev/null 2>&1 && \
         test ! -f ${st3} && test -f ${f}; then
      shar_touch='touch -am $3$4$5$6$2 "$8"'
    
    else
      shar_touch=:
      echo
      ${echo} 'WARNING: not restoring timestamps.  Consider getting and
    installing GNU '\''touch'\'', distributed in GNU coreutils...'
      echo
    fi
    rm -f ${st1} ${st2} ${st2tr} ${st3} ${f}
    #
    if test ! -d ${lock_dir} ; then :
    else ${echo} "lock directory ${lock_dir} exists"
         exit 1
    fi
    if mkdir ${lock_dir}
    then ${echo} "x - created lock directory ${lock_dir}."
    else ${echo} "x - failed to create lock directory ${lock_dir}."
         exit 1
    fi
    # ============= flag ==============
    if test -n "${keep_file}" && test -f 'flag'
    then
    ${echo} "x - SKIPPING flag (file already exists)"
    
    else
    ${echo} "x - extracting flag (text)"
      sed 's/^X//' << 'SHAR_EOF' | uudecode &&
    begin 600 flag
    M(3QA<F-H/@IF;&%G+R`@("`@("`@("`@,"`@("`@("`@("`@,"`@("`@,"`@
    M("`@-C0T("`@("`Q,#(T("`@("`@8`K'<>H`,I*D@0`````!````$F2!<P4`
    M``#^`69L86<``$)::#DQ05DF4UD'O9@<```@______OS^>+_/=OO_73W_^[Y
    M\0O]#?]_;L\W^WS?WPEJB[`!&VH(-#3$#0`!DR`&0T````,@`&F0`-&@9!HR
    M-`>D-&C1H&C0T>4&3)IY&)#H9#3(&0T:#(Q``T]$TR&$!D`/4:#(,FFF$-``
    M`/29&F0T!H#1ZC1H-!H&0%5/U(#30T`R`9`#$-``T,(T`831ID`:``#)IH&@
    M8@#0`TTR:#)@@T9-`(`@`$Y`O(#0;.-IP&'H0%,$"M*(":A.ZM:B\SK&P]U]
    M_(Q+>RNUWW_)RZN#W7YT.1Q?M@S$UK+:D]79/DD9>RTD?>'QO?>C:";TN$KN
    MHIZZ!B1CJX9+7+?@3X?+BO7.Z!6L)D'TK$$R17C2N-6Z[`4I2;[=>.X!XOE1
    MD@%0%*U</^:9QX5`YS/6]>D(USMFZCD2P10!L4VP=!Q5.<0)0O8#`!&H.,B*
    MO#5Z[0`/'<'WV=S`02\FL(V^%!*T'L,T"-U!V(*)Q(,XVS#\/Z_32>+L^HPK
    M/]G@&IZTI--JV+&EV$'BO$-@"!M&&SG$E1V[28@9I&0*+._^NC2)1*,EHF:[
    MLZ#4-%6OPRG$06".S1LD(@I@-J*3,KAA"P9V8;'ADW&D0D#S?2,C$F]Z[998
    MPX&P$M-1_KERJ@$+F0_Q=R13A0D`>]F!P,=Q``````````````$`````````
    M"P``````5%)!24Q%4B$A(0``````````````````````````````````````
    M````````````````````````````````````````````````````````````
    M````````````````````````````````````````````````````````````
    M````````````````````````````````````````````````````````````
    M````````````````````````````````````````````````````````````
    M````````````````````````````````````````````````````````````
    M````````````````````````````````````````````````````````````
    M````````````````````````````````````````````````````````````
    M````````````````````````````````````````````````````````````
    M````````````````````````````````````````````````````````````
    ,````````````````
    `
    end
    SHAR_EOF
      (set 20 23 03 16 01 40 17 'flag'
       eval "${shar_touch}") && \
      chmod 0644 'flag'
    if test $? -ne 0
    then ${echo} "restore of flag failed"
    fi
      if ${md5check}
      then (
           ${MD5SUM} -c >/dev/null 2>&1 || ${echo} 'flag': 'MD5 check failed'
           ) << \SHAR_EOF
    476b60fc688364738f1887d495498b14  flag
    SHAR_EOF
    
    else
    test `LC_ALL=C wc -c < 'flag'` -ne 1092 && \
      ${echo} "restoration warning:  size of 'flag' is not 1092"
      fi
    fi
    if rm -fr ${lock_dir}
    then ${echo} "x - removed lock directory ${lock_dir}."
    else ${echo} "x - failed to remove lock directory ${lock_dir}."
         exit 1
    fi
    exit 0

Okay, let's just go to the `flag` section...

Seems like we need to know what `uudecode` does...
It's provided by the package `sharutils`,
and the ubiquitous mention of `shar` in the code means that this challenge is about that thing, whatever that is.

Let's extract the encoded text into `uuencoded`, starting from `begin` to `end`:

    begin 600 flag
    M(3QA<F-H/@IF;&%G+R`@("`@("`@("`@,"`@("`@("`@("`@,"`@("`@,"`@
    M("`@-C0T("`@("`Q,#(T("`@("`@8`K'<>H`,I*D@0`````!````$F2!<P4`
    M``#^`69L86<``$)::#DQ05DF4UD'O9@<```@______OS^>+_/=OO_73W_^[Y
    M\0O]#?]_;L\W^WS?WPEJB[`!&VH(-#3$#0`!DR`&0T````,@`&F0`-&@9!HR
    M-`>D-&C1H&C0T>4&3)IY&)#H9#3(&0T:#(Q``T]$TR&$!D`/4:#(,FFF$-``
    M`/29&F0T!H#1ZC1H-!H&0%5/U(#30T`R`9`#$-``T,(T`831ID`:``#)IH&@
    M8@#0`TTR:#)@@T9-`(`@`$Y`O(#0;.-IP&'H0%,$"M*(":A.ZM:B\SK&P]U]
    M_(Q+>RNUWW_)RZN#W7YT.1Q?M@S$UK+:D]79/DD9>RTD?>'QO?>C:";TN$KN
    MHIZZ!B1CJX9+7+?@3X?+BO7.Z!6L)D'TK$$R17C2N-6Z[`4I2;[=>.X!XOE1
    MD@%0%*U</^:9QX5`YS/6]>D(USMFZCD2P10!L4VP=!Q5.<0)0O8#`!&H.,B*
    MO#5Z[0`/'<'WV=S`02\FL(V^%!*T'L,T"-U!V(*)Q(,XVS#\/Z_32>+L^HPK
    M/]G@&IZTI--JV+&EV$'BO$-@"!M&&SG$E1V[28@9I&0*+._^NC2)1*,EHF:[
    MLZ#4-%6OPRG$06".S1LD(@I@-J*3,KAA"P9V8;'ADW&D0D#S?2,C$F]Z[998
    MPX&P$M-1_KERJ@$+F0_Q=R13A0D`>]F!P,=Q``````````````$`````````
    M"P``````5%)!24Q%4B$A(0``````````````````````````````````````
    M````````````````````````````````````````````````````````````
    M````````````````````````````````````````````````````````````
    M````````````````````````````````````````````````````````````
    M````````````````````````````````````````````````````````````
    M````````````````````````````````````````````````````````````
    M````````````````````````````````````````````````````````````
    M````````````````````````````````````````````````````````````
    M````````````````````````````````````````````````````````````
    M````````````````````````````````````````````````````````````
    ,````````````````
    `
    end

The output will be in the in the file `flag`.
Now, let's just extract whatever this is...

```
$ uudecode uuencoded
$ ls
flag  Flag.pdf  uuencoded  Writeup.md
$ file flag
flag: current ar archive
$ ar x flag
$ file flag
flag: cpio archive
$ mv flag flag.cpio # else, cpio complains
$ cpio -idv <flag.cpio
$ ls 
flag  flag.cpio  Flag.pdf  uuencoded  Writeup.md
$ file flag
$ bunzip2 flag
bunzip2: Can't guess original name for flag -- using flag.out
$ file flag.out 
flag.out: gzip compressed data, was "flag", last modified: Thu Mar 16 01:40:17 2023, from Unix, original size modulo 2^32 327
$ mv flag.out flag.gz
$ gunzip flag.gz
$ file flag
flag: lzip compressed data, version: 1
$ lzip -d flag
$ ls          
flag.cpio  flag.out  Flag.pdf  Flag.sh  uuencoded  Writeup.md
$ file *
flag.cpio:  cpio archive
flag.out:   LZ4 compressed data (v1.4+)
Flag.pdf:   shell archive text
Flag.sh:    shell archive text
uuencoded:  uuencoded text, file name "flag", ASCII text
Writeup.md: ASCII text
$ lz4 -d flag.out flag
                                                                        flag.out             : decoded 265 bytes 
$ file flag
flag: LZMA compressed data, non-streamed, size 254
$ mv flag flag.lzma
$ xz --format=lzma -d flag.lzma 
$ ls
flag  flag.cpio  flag.out  Flag.pdf  Flag.sh  uuencoded  Writeup.md
$ file flag
flag: lzop compressed data - version 1.040, LZO1X-1, os: Unix
$ mv flag flag.lzop
$ lzop -d -S lzop flag.lzop
$ ls
flag       flag.lzop  Flag.pdf  uuencoded
flag.cpio  flag.out   Flag.sh   Writeup.md
$ file flag
flag: lzip compressed data, version: 1
$ mv flag.out flag.lz4
$ lzip -d flag
$ file flag.out
flag.out: XZ compressed data, checksum CRC64
$ xz -d -S .out flag.out
$ file flag
flag:       ASCII text
$ cat flag
7069636f4354467b66316c656e406d335f6d406e3170756c407431306e5f
6630725f3062326375723137795f37396230316332367d0a
```

OMG, hell we can now get out of this horrible shell... T_T<br>
*run in tears to CyberChef*

![cyberchef](./cyberchef.png)

Finally...

FLAG: `picoCTF{f1len@m3_m@n1pul@t10n_f0r_0b2cur17y_79b01c26}`

This challenge actually makes me feel sad,
I don't know why,
my terminal looks so depressing.
