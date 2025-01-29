package com.tuctf;

/* loaded from: eeffoc.class */
public class Shim {
    static int ret_value = 0;

    public static void main(String[] strArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            i += i2;
        }
        ret_value = i;
    }

    public static int a() {
        return 2;
    }

    public static byte[] b() {
        return new byte[]{83, 85, 98, 73};
    }
}
