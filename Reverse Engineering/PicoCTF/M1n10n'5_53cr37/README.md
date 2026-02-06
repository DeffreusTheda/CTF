Author: Prince Niyonshuti N.

Get ready for a mischievous adventure with your favorite Minions! 🕵️‍♂️💥 They’ve been up to their old tricks, and this time, they've hidden the flag in a devious way within the Android source code. Your task is to channel your inner Minion and dive into the disassembled or decompiled code. Watch out, because these little troublemakers have hidden the flag in multiple sneaky spots or maybe even pulled a fast one and concealed it in the same location! Put on your overalls, grab your magnifying glass, and get cracking. The Minions have left clues, and it's up to you to follow their trail and uncover the flag. Can you outwit these playful pranksters and find their secret? Let the Minion mischief begin! Find the android apk here Minions Mobile Application and try to get the flag.

## Solution

```
 $ jadx minions.apk
INFO  - loading ...
INFO  - processing ...
ERROR - finished with errors, count: 19                      
 $ cd minions/
 $ bat resources/AndroidManifest.xml
```

```xml
  17 │     <application
     │         <!-- SNIP -->
  29 │         <activity
  30 │             android:name="com.example.picoctfimage.MainActivity"
  31 │             android:exported="true">
  32 │             <intent-filter>
  33 │                 <action android:name="android.intent.action.MAIN"/>
  34 │                 <category android:name="android.intent.category.LAUNCHER"/>
  35 │             </intent-filter>
  36 │         </activity>
     │         <!-- SNIP -->
  70 │     </application>
```

The main file is `./minions/sources/com/example/picoctfimage/MainActivity.java`
There's nothing interesting in there.

Fortunately, my instinct of looking for the string 'picoctf' is correct.
Though `rg -uuu picoctf` yields nothing, looking at `./minions/resources/res/values/strings.xml` gives:

```xml
   1 │ <?xml version="1.0" encoding="utf-8"?>
   2 │ <resources>
   3 │     <string name="Banana">OBUWG32DKRDHWMLUL53TI43OG5PWQNDSMRPXK3TSGR3DG3BRNY4V65DIGNPW2MDCGFWDGX3DGBSDG7I=</string>
   4 │     <string name="abc_action_bar_home_description">Navigate home</string>
   5 │     <string name="abc_action_bar_up_description">Navigate up</string>
   6 │     <string name="abc_action_menu_overflow_description">More options</string>```
     │     <!-- SNIP -->
```

That's a base32 encoded string, and [decoding it](https://gchq.github.io/CyberChef/#recipe=From_Base32('A-Z2-7%3D',false)&input=T0JVV0czMkRLUkRIV01MVUw1M1RJNDNPRzVQV1FORFNNUlBYSzNUU0dSM0RHM0JSTlk0VjY1RElHTlBXMk1EQ0dGV0RHWDNER0JTREc3ST0) gives the flag!
