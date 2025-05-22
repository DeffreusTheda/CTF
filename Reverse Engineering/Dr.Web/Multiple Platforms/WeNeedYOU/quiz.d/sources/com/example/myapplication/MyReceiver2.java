package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import kotlin.io.encoding.Base64;

/* loaded from: classes2.dex */
public class MyReceiver2 extends BroadcastReceiver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    Context ctx;

    public native String JohnnyDepp(byte[] bArr);

    public native String MoscowMetroLublino(byte[] bArr);

    public native String etogoKazino2(byte[] bArr);

    public native void smackThat_aLoliMou(byte[] bArr);

    public MyReceiver2() {
        System.loadLibrary("KakyatoNeLaitovaia");
        System.loadLibrary(etogoKazino2(new byte[]{19, 2, 123, 72, 13, 9, Base64.padSymbol, 6, 12, 81, 8, 30, 11, 51, 5, 122}));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int i;
        String action = intent.getAction();
        this.ctx = context;
        Log.i("Receiver", "Broadcast received: " + action);
        if (action.equals("AltushkiSgosUslug")) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("key_byte_array");
            int length = byteArrayExtra != null ? byteArrayExtra.length : 0;
            byte[] bArr = new byte[length];
            int i2 = 0;
            while (true) {
                i = length / 2;
                if (i2 >= i) {
                    break;
                }
                bArr[i + i2] = byteArrayExtra[(length - 1) - i2];
                i2++;
            }
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = byteArrayExtra[(i - 1) - i3];
            }
            try {
                Class.forName(JohnnyDepp(byteArrayExtra)).getDeclaredMethod(MoscowMetroLublino(bArr), byte[].class).invoke(this, bArr);
            } catch (Exception e) {
                Log.e("com.example.myapplication", String.valueOf(e));
            }
        }
    }
}
