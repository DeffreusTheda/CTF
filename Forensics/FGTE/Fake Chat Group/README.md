Sebuah file database chat WhatsApp palsu ditemukan. Ada banyak pesan, grup, dan percakapan random.

## Solution

I looked around and found a part of the flag, `FGTE{you_foun`.
A full flag I found was `FGTE{Sssst... Try_again!}`, but it's a fake one.
So I did `strings ./msgstore.db | hx` and searched, starting from the end of file.

```
628111000005@s.whatsapp.nethttps://drive.google.com/drive/folders/1yFD_28zf1a7dP8FNSUW9EiKovxJL8-54?usp=sharing
628111000005@s.whatsapp.netCek pastebin ini: https://pastebin.com/jHx0kiLv
628111000005@s.whatsapp.nethttps://drive.google.com/drive/folders/1yFD_28zf1a7dP8FNSUW9EiKovxJL8-54?usp=sharing
628111000005@s.whatsapp.nethttps://drive.google.com/drive/folders/1yFD_28zf1a7dP8FNSUW9EiKovxJL8-54?usp=sharing
628111000005@s.whatsapp.netCek pastebin ini: https://pastebin.com/jHx0kiLv
628111000005@s.whatsapp.netCek pastebin ini: https://pastebin.com/raw/def45678
628111000005@s.whatsapp.neteh, typo barusan
628111000005@s.whatsapp.netFlag ada di pesan terakhir btw.
628111000005@s.whatsapp.netCommit udh di-push, tinggal review
628111000005@s.whatsapp.net[read receipt]
Fread receiptX
628111000005@s.whatsapp.netForwarded message: ini gambar (image_01.jpg)
628111000005@s.whatsapp.netCek pastebin ini: https://pastebin.com/jHx0kiLv
628111000005@s.whatsapp.nethttps://github.com/ariafatah999/ToyStore/commit/3a8a999e08375a6f15898a9ed8a997e01b99d382
628111000005@s.whatsapp.netLink repo: https://github.com/fakeuser/fake-bug-project
628111000005@s.whatsapp.netp4ss: yT8iG5bfNC
628111000005@s.whatsapp.netCek pastebin ini: https://pastebin.com/gnnWdykp

```

This chat seems to point at something, and the `p4ss` catch my eye.
I checked `https://pastebin.com/jHx0kiLv` and found it passworded, and used the password above.
