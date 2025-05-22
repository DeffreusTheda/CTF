package com.example.myapplication;

import android.content.Context;

/* loaded from: classes2.dex */
public class Helper {
    private Context ctx;

    public static void get6(String str) {
    }

    public native void get4();

    public native void get5(String str);

    public native String stringFromJNI(String str);

    Helper(Context context) {
        this.ctx = context;
        System.loadLibrary("kekovaya");
    }

    public static void get1(String str) {
        for (int i = 0; i < str.length(); i++) {
            str.charAt(i);
        }
    }

    public static String get2(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append((char) (str.charAt(i) ^ 16));
        }
        return sb.toString();
    }
}
