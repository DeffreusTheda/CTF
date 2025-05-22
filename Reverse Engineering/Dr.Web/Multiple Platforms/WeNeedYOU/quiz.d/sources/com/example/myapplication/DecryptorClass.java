package com.example.myapplication;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class DecryptorClass {
    public static void ShmiperPipper(String[] strArr) {
        new DecryptorClass().qwerty1234(strArr);
    }

    private void qwerty1234(String[] strArr) {
        System.out.println(zxcvbn4321(asdfgh5678(strArr)));
    }

    private byte[] asdfgh5678(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ghijkl9012());
        arrayList.add(mnopqr3456());
        arrayList.add(stuvwx7890(ghijkl9012()));
        arrayList.add(abcdef6789());
        arrayList.add(ghijkl9012());
        arrayList.add(stuvwx7890(mnopqr3456()));
        return lmnopq9876(arrayList);
    }

    private byte[] lmnopq9876(List<byte[]> list) {
        Iterator<byte[]> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().length;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (byte[] bArr2 : list) {
            System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
            i2 += bArr2.length;
        }
        return bArr;
    }

    private byte[] ghijkl9012() {
        return opqrst6543(new int[]{72, TypedValues.TYPE_TARGET, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, 111});
    }

    private byte[] mnopqr3456() {
        return opqrst6543(new int[]{87, 111, 114, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, 100});
    }

    private byte[] abcdef6789() {
        return opqrst6543(new int[]{67, LocationRequestCompat.QUALITY_LOW_POWER, 97, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, TypedValues.TYPE_TARGET, 110, 103, TypedValues.TYPE_TARGET});
    }

    private byte[] stuvwx7890(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = (byte) (bArr[i] ^ 170);
        }
        return bArr2;
    }

    private String zxcvbn4321(byte[] bArr) {
        return uvwxyz1234(bArr);
    }

    private String uvwxyz1234(byte[] bArr) {
        try {
            Method declaredMethod = Class.forName("java.lang.String").getDeclaredMethod("new", byte[].class, String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, bArr, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] opqrst6543(int[] iArr) {
        byte[] bArr = new byte[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            bArr[i] = (byte) iArr[i];
        }
        return uvwxyz1234(bArr).getBytes(StandardCharsets.UTF_8);
    }
}
