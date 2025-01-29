Easy pcap chall to be conquered!

Sebuah file capture terlihat biasa saja—hanya lalu lintas ICMP.
Tapi jangan remehkan ping.
Terkadang, data penting dikirim sedikit demi sedikit, tersembunyi di tempat yang paling sederhana.

    Format: FGTE{...}

## Solution

`tshark -r ./pikepienji.pcapng -Y '_ws.col.protocol == "ICMP"' -T fields -e data.data >dat`

`}s0c43_efaar0fppda_ul_cle_s_y{aco`
socaeefaarofppdaulclesyaco