Author: amek

Temenku tadi ngechat, katanya akhir-akhir ini dia kebanyakan scroll TikTok. Terus, tiba-tiba dia ngirimin aku lagu yang katanya lagi sering muncul di sana. Nggak tau kenapa, tapi rasanya kayak dia mau nyampein sesuatu, cuma nggak secara langsung.

Selain itu, dia juga ngirimin foto kucing.. kucingnya sih lucu banget, tapi aku ngerasa ada yang aneh. Kayak ada sesuatu yang diselipin di tempat yang nggak terlalu mencolok. Aku coba otak-atik, siapa tau ada sesuatu yang kecil tapi sebenarnya penting. Soalnya, kadang hal-hal yang kelihatan biasa aja justru nyimpan sesuatu di dalamnya.

Mungkin perlu lebih jeli buat nemuin apa yang dia sembunyikan. Bantuin gue cari tahu, yuk?"

## SOLUTION

```
>binwalk -e the .docx
>open extractions/tolong\ gw.docx.extracted/0/word/media/.kucinggpuasa.jpg
>there's the fake flag
>apparently, it's the key for steghide, so guessy!
>steghide extract extractions/tolong\ gw.docx.extracted/0/word/media/.kucinggpuasa.jpg
>input password
>get flag!
```
