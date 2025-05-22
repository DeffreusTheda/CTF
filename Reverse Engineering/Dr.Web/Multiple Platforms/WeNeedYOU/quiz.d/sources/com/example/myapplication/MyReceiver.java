package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import kotlin.UByte;

/* loaded from: classes2.dex */
public class MyReceiver extends BroadcastReceiver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    Context ctx;

    private void dumaeteIvasNePereigrayu(byte[] bArr) {
    }

    private void viDumaeteChto(byte[] bArr) {
    }

    public native void dumaeteChto(byte[] bArr);

    public void dumaeteIvasNePereigrayu1(byte[] bArr) {
    }

    public native String etogoKazino(byte[] bArr);

    public native String getThisClsName_();

    public native String get_dumaeteIvasNePereigrayu_Name();

    public native void vseyKuchke(byte[] bArr);

    public MyReceiver() {
        System.loadLibrary("KakyatoNeLaitovaia");
        System.loadLibrary(etogoKazino(new byte[]{87, 28, 120, 42, 11, 77}));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int i;
        String action = intent.getAction();
        this.ctx = context;
        Log.i("Receiver", "Broadcast received: " + action);
        if (action.equals("PrybilGodzhiSatoru")) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("key_byte_array");
            int length = byteArrayExtra != null ? byteArrayExtra.length : 0;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                byte b = byteArrayExtra[i2];
                if (b < 0) {
                    byteArrayExtra[i2] = (byte) (b % UByte.MIN_VALUE);
                }
            }
            int i3 = 0;
            while (true) {
                i = length / 2;
                if (i3 >= i) {
                    break;
                }
                bArr[i + i3] = byteArrayExtra[(length - 1) - i3];
                i3++;
            }
            for (int i4 = 0; i4 < i; i4++) {
                bArr[i4] = byteArrayExtra[(i - 1) - i4];
            }
            try {
                Class.forName(getThisClsName_()).getDeclaredMethod(get_dumaeteIvasNePereigrayu_Name(), byte[].class).invoke(this, bArr);
            } catch (Exception e) {
                Log.e("com.example.myapplication", String.valueOf(e));
            }
        }
    }
}
