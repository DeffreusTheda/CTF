Author: Dimas Maulana

Aku mencoba untuk mengirimkan pesan rahasia ke google :)

## Solution

`tshark -r capture.pcap -Y '(ip.src == 192.168.183.138) && (_ws.col.protocol == "HTTP")' -T fields -e urlencoded-form.key`
