Author: Yahaya Meddy
Description
You’re given a seemingly ordinary JPG image. Something is tucked away out of sight inside the file. Your task is to discover the hidden payload and extract the flag. Download the jpg image here.

## Solution

```
 $ steghide extract -sf img.jpg -p pAzzword
wrote extracted data to "flag.txt".
```