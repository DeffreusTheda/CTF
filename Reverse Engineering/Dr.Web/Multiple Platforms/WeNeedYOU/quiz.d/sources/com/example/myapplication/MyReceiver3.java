package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes2.dex */
public class MyReceiver3 extends BroadcastReceiver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    Context ctx;

    public native byte[] StartKek(byte[] bArr);

    public native String etogoKazino1(byte[] bArr);

    public native String memovNet(byte[] bArr);

    public native String poslednyiMem(byte[] bArr);

    public MyReceiver3() {
        System.loadLibrary("KakyatoNeLaitovaia");
        System.loadLibrary(etogoKazino1(new byte[]{13, 81, 120, 10, 12, 77, 111}));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        FileOutputStream fileOutputStream;
        String action = intent.getAction();
        this.ctx = context;
        Log.i("Receiver", "Broadcast received: " + action);
        if (action.equals("DialogiTarantino")) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("key_byte_array"); // "(Ljava/lang/String;[B)Landroid/content/Intent;"
            if (byteArrayExtra != null) {
                int length = byteArrayExtra.length;
            }
            try {
                Object invoke = Class.forName(memovNet(byteArrayExtra)).getDeclaredMethod(poslednyiMem(byteArrayExtra), byte[].class).invoke(this, byteArrayExtra);
                File file = new File(this.ctx.getFilesDir(), "outBd.db");
                if (file.exists()) {
                    if (file.delete()) {
                        file.createNewFile();
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            fileOutputStream.write((byte[]) invoke);
                            fileOutputStream.close();
                            return;
                        } finally {
                        }
                    }
                    return;
                }
                file.createNewFile();
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write((byte[]) invoke);
                    fileOutputStream.close();
                    return;
                } finally {
                }
            } catch (Exception e) {
                Log.e("com.example.myapplication", String.valueOf(e));
            }
            Log.e("com.example.myapplication", String.valueOf(e));
        }
    }
}
