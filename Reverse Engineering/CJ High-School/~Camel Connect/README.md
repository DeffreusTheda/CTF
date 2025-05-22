`strace -s 4096 -f -e trace=network,read,write,connect,sendto,recvfrom,sendmsg,recvmsg,execve ./connect 2>out`

there's this link to [https://gist.githubusercontent.com/vidner/74930243019c7e715c3989e7bb6b0ac8/raw/c40f48744e9677dbadb3eb252ae047349f3390ec/connected.txt](https://gist.githubusercontent.com/vidner/74930243019c7e715c3989e7bb6b0ac8/raw/c40f48744e9677dbadb3eb252ae047349f3390ec/connected.txt)

go there and there's the flag!
