Author: Prince Niyonshuti N.

The SOC team discovered a suspiciously large log file after a recent breach. When they opened it, they found an enormous block of encoded text instead of typical logs. Could there be something hidden within? Your mission is to inspect the resulting file and reveal the real purpose of it. The team is relying on your skills to uncover any concealed information within this unusual log. Download the encoded data here: Logs Data. Be prepared—the file is large, and examining it thoroughly is crucial .

 ## Solution

```
 $ cat logs.txt | base64 -d >log.txt
 $ file log.txt
log.txt: PNG image data, 896 x 1152, 8-bit/color RGB, non-interlaced
 $ mv log.txt log.png
 $ mcat log.png
```

It shows an AI-generated image with a hexbyte string at the bottom:
`7069636F4354467B666F72656E736963735F616E616C797369735F69735F616D617A696E675F35636363376362307D`

```
 $ pbpaste | xxd -r -p
picoCTF{forensics_analysis_is_amazing_5ccc7cb0}
```
