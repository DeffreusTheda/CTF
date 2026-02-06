###### KeKoa_M

Little Timmy decided to simplify the flag printing, and has deployed an update to the ESPs. Once again Timmy has lost the source, can you get him the flag again?
Note: this is intended as a pt2 of RISCy Business, but the challenges are not interdependent

[capture.pcapng](./capture.pcapng)

## Solution

[claude](https://claude.ai/share/b4febe16-8ab5-4b96-957d-73f4230563af) helped me.

for the wireshark regex match, [here](https://osqa-ask.wireshark.org/questions/22376/filtering-with-a-regular-expression/).

this is ZigBee.
i added the default zigbee key; i got resources from these:
- [Jing Loon](https://medium.com/csg-govtech/a-quick-look-into-zigbee-security-is-anyone-in-bee-tween-567f36c401f6)
- [Nordic](https://docs.nordicsemi.com/bundle/ug_sniffer_802154/page/UG/sniffer_802154/configuring_sniffer_802154_zigbee.html)

now we can see decrypted.
as claude said, we need to look at `ZCL OTA: Image Block Response`.
just `tshark -r capture.pcapng -Y '(!(_ws.col.info == "Ack")) && (_ws.col.info matches "ZCL OTA: Image Block Response, Seq: *")' -T fields -e 'zbee_zcl_general.ota.image.data'` it!!
go to cyberchef, and find the flag, apparently.
thought it was an elf file.
