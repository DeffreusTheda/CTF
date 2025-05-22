# droids0 - PicoCTF 2019

###### Author: Jason

Where do droid logs go. Check out this [file](https://jupiter.challenges.picoctf.org/static/02bcd73e630f50ef0b12bcdad9d84e0d/zero.apk).

<details><summary>Hint 1</summary>
Try using an emulator or device
</details>

<details><summary>Hint 2</summary>
https://developer.android.com/studio
</details>

## Files

I got an `.apk` file,
well guess what,
`jadx` good at that.

```sh
> jadx zero.apk
INFO  - loading ...
INFO  - processing ...
ERROR - finished with errors, count: 3
```

The implemented logic of the app seems to be in `sources/com/hellocmu/picoctf`.
There's `MainActivity.java` where the 'main' of the app is.

```java
package com.hellocmu.picoctf;  
  
import android.content.Context;  
import android.os.Bundle;  
import android.view.View;  
import android.widget.Button;  
import android.widget.EditText;  
import android.widget.TextView;  
import androidx.appcompat.app.AppCompatActivity;  
  
/* loaded from: classes.dex */  
public class MainActivity extends AppCompatActivity {  
    Button button;  
    Context ctx;  
    TextView text_bottom;  
    EditText text_input;  
    TextView text_top;  
  
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        this.text_top = (TextView) findViewById(R.id.text_top);  
        this.text_bottom = (TextView) findViewById(R.id.text_bottom);  
        this.text_input = (EditText) findViewById(R.id.text_input);  
        this.ctx = getApplicationContext();  
        System.loadLibrary("hellojni");  
        this.text_top.setText(R.string.hint);  
    }  
  
    public void buttonClick(View view) {  
        String content = this.text_input.getText().toString();  
        this.text_bottom.setText(FlagstaffHill.getFlag(content, this.ctx));  
    }  
}
```

Seems like the app just asks for the flag,
and tell us if it's correct or not,
I think?
What's interesting is `buttonClick`,
probably the submit flag button.
Following `FlagstaffHill.getFlag`,

```java
public class FlagstaffHill {  
    public static native String paprika(String str);  
  
    public static String getFlag(String input, Context ctx) {  
        Log.i("PICO", paprika(input));  
        return "Not Today...";  
    }  
}
```

Our input got passed to `paprika`?
[`Log.i`](https://developer.android.com/reference/android/util/Log#i(java.lang.String,%20java.lang.String)) is from android library,
so nothing of interest there.

So a native functions is involved...
that's something that's not bytecode :/
We see earlier the a call to load the library `hellojni`.
I ripgrep'ed all files for the string `paprika`,

```sh
> rg -u paprika
sources/com/hellocmu/picoctf/FlagstaffHill.java
8:    public static native String paprika(String str);
11:        Log.i("PICO", paprika(input));

resources/lib/x86_64/libhellojni.so: binary file matches (found "\0" byte around offset 7)

resources/lib/arm64-v8a/libhellojni.so: binary file matches (found "\0" byte around offset 7)

resources/lib/x86/libhellojni.so: binary file matches (found "\0" byte around offset 7)

resources/lib/armeabi-v7a/libhellojni.so: binary file matches (found "\0" byte around offset 7)

resources/classes.dex: binary file matches (found "\0" byte around offset 7)
```

So I guess I need to reverse this `.so` library now.
I goes with the x86_64,
because that's what I'm most comfortable with :>

## Reversing

I auto-analyze the binary and searching for `paprika` in the Symbol Tree got me to this:

![[Reverse Engineering/PicoCTF/droids0/Screenshot 2025-01-01 at 20.26.45.png]]

I REALLY DON'T KNOW what `param_1` is.
It seems like it's something akin to a base pointer to a function array.

Confused, I searched the `.rodata` for any interesting strings,

![[Reverse Engineering/PicoCTF/droids0/Screenshot 2025-01-01 at 20.35.06.png]]

Is that the flag?
No, submitting it to the server grants a failure message :<

Whatever, but it seems like the _true_ path for the `if` is failure,
and consequently `else` code block is for success,
so I look into `marjoram` to see what it does.

![[Reverse Engineering/PicoCTF/droids0/Screenshot 2025-01-01 at 20.29.26.png]]

`unscramble`?
`0x101a1a` points to the memory region in the read-only data section `.rodata`.
What's there is nothing alike ASCII.
I immediately assume `notexist` is the key for this.
`unscramble` looks like this:

![[Reverse Engineering/PicoCTF/droids0/Screenshot 2025-01-01 at 20.31.37.png]]

It just xors the data at `0x101a1a` with bytes from the key!
What's interesting is the result of this,
so as we already have all the data needed,
we can unscramble it ourself!

```Python
marjoram = [0x1E, 0x06, 0x17, 0x0A, 0x3B, 0x3D, 0x35, 0x0F, 0x0F, 0x41, 0x19, 0x0A, 0x17, 0x1A, 0x16, 0x5A, 0x01, 0x01, 0x17, 0x00, 0x56, 0x0B, 0x1A, 0x00, 0x40, 0x02, 0x0D, 0x4B, 0x0B, 0x00, 0x00, 0x00, 0x0B, 0x1D, 0x09, 0x00]
key = b"notexist"
key_len = len(key)

for i in range(0x23):
    print(chr(marjoram[i] ^ key[i % key_len]), end='')
print()
```

```sh
> python3 solve.py
picoCTF{a.moose.once.bit.my.sister}
```

I didn't expect this to be the actual flag,
but I guess this is it!

Flag: `picoCTF{a.moose.once.bit.my.sister}`