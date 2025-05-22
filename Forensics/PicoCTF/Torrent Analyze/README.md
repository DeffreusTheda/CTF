Author: Mubarak Mikail

SOS, someone is torrenting on our network.
One of your colleagues has been using torrent to download some files on the company’s network.
Can you identify the file(s) that were downloaded?
The file name will be the flag, like `picoCTF{filename}`.
[Captured traffic](./torrent.pcap).

## Solution

`tshark -r torrent.pcap -Y "frame contains $(echo -n info_hash|xxd -p)" -T fields -e bt-dht.bencoded.string`
Search by hash for the filenames.
