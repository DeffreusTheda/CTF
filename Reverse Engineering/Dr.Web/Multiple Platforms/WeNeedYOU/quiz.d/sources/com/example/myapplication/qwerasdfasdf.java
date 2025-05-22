package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
public class qwerasdfasdf {
    Context ctx;

    private byte m1() {
        return (byte) 64;
    }

    private byte m10() {
        return (byte) 36;
    }

    private byte m11() {
        return (byte) 41;
    }

    private byte m12() {
        return (byte) 6;
    }

    private byte m13() {
        return (byte) 70;
    }

    private byte m14() {
        return (byte) 36;
    }

    private byte m2() {
        return (byte) 106;
    }

    private byte m3() {
        return (byte) 76;
    }

    private byte m4() {
        return (byte) 113;
    }

    private byte m5() {
        return (byte) 33;
    }

    private byte m6() {
        return (byte) 124;
    }

    private byte m7() {
        return (byte) 122;
    }

    private byte m8() {
        return (byte) 29;
    }

    private byte m9() {
        return (byte) 85;
    }

    public native void Bibki(byte[] bArr);

    public native String PeppaPig(byte[] bArr);

    public native String PeppaPig1(byte[] bArr);

    public native String getBibkiName();

    public native String getThisClsName();

    private byte[] obfuscate_laitovaya_esho_String() throws Exception {
        return new byte[]{(byte) (m1() - 212), (byte) (m2() - 9), (byte) (m3() + 29), (byte) (m4() + 3), (byte) (m5() + 78), (byte) (m6() - 6), (byte) (m7() - 25), (byte) (m8() + 92), (byte) (m9() + 12), (byte) (m10() + 59), (byte) (m11() + 60), (byte) (m12() + 109), (byte) (m13() + 34), (byte) (m14() + 75)};
    }

    public String getObfuscatedStringClassName() {
        return PeppaPig(new byte[]{ByteCompanionObject.MAX_VALUE, 120, 110, 67, 53, 69, ByteCompanionObject.MAX_VALUE, 64, 118, 9, 103, 88, 85, 106, 88, 99});
    }

    public String getValueOf() {
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < 4567895; i++) {
            if (i % 8 == 0) {
                arrayList.add(Byte.valueOf((byte) ((i + 5869) % 1024)));
            } else if (i % 7 == 0) {
                arrayList.add(Byte.valueOf((byte) ((i + 7535) % 728)));
            } else if (i % 5 == 0) {
                arrayList.add(Byte.valueOf((byte) ((i + 1258) % 512)));
            } else if (i % 3 == 0) {
                arrayList.add(Byte.valueOf((byte) ((i + 4536) % 3459)));
            } else if (i % 2 == 0) {
                arrayList.add(Byte.valueOf((byte) ((i + 1578) % 123)));
            }
        }
        byte[] bArr = new byte[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            bArr[i2] = ((Byte) arrayList.get(i2)).byteValue();
        }
        return PeppaPig1(bArr);
    }

    public String getObfuscatedExceptionClassName() {
        return "decodeBytes(obfuscatedBytes)";
    }

    public static String get_KakyatoNeLaitovaia() {
        return new String("KakyatoNeLaitovaia".getBytes(), StandardCharsets.UTF_8);
    }

    qwerasdfasdf(Context context) {
        this.ctx = context;
        try {
            System.loadLibrary(get_KakyatoNeLaitovaia());
            System.loadLibrary(new String(obfuscate_laitovaya_esho_String(), StandardCharsets.UTF_8));
            Class.forName(getThisClsName()).getDeclaredMethod(getBibkiName(), byte[].class).invoke(this, new byte[]{50, 66, 10, Base64.padSymbol, 28, 120, 91, 41});
        } catch (Exception e) {
            Log.e("com.example.myapplication", String.valueOf(e));
        }
    }
}
