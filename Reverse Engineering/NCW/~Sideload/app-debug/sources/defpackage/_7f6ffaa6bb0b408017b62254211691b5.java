package defpackage;

import androidx.core.internal.view.SupportMenu;

/* loaded from: assets/7f6ffaa6bb0b408017b62254211691b5.dex */
public class _7f6ffaa6bb0b408017b62254211691b5 {
    public static boolean check(String str) {
        int i = new int[]{65487}[0] ^ SupportMenu.USER_MASK;
        int i2 = (((((i << 8) | ((i & SupportMenu.USER_MASK) >> 8)) & SupportMenu.USER_MASK) - 54664) + 0) - 45251;
        int i3 = ((((i2 & SupportMenu.USER_MASK) >> 8) | (i2 << 8)) & SupportMenu.USER_MASK) - 0;
        int i4 = (((i3 << 1) | ((i3 & SupportMenu.USER_MASK) >> 15)) & SupportMenu.USER_MASK) - 1;
        int i5 = ((((i4 & SupportMenu.USER_MASK) >> 11) | (i4 << 5)) & SupportMenu.USER_MASK) + 1;
        int i6 = ((((((i5 & SupportMenu.USER_MASK) >> 2) | (i5 << 14)) & SupportMenu.USER_MASK) ^ 19011) ^ 0) - 1;
        int i7 = (((i6 << 3) | ((i6 & SupportMenu.USER_MASK) >> 13)) & SupportMenu.USER_MASK) - 38333;
        int i8 = ((((((i7 << 12) | ((i7 & SupportMenu.USER_MASK) >> 4)) & SupportMenu.USER_MASK) + 0) + 1) ^ 0) - 1;
        int i9 = (((((i8 << 10) | ((i8 & SupportMenu.USER_MASK) >> 6)) & SupportMenu.USER_MASK) - 316) ^ 0) + 0;
        int i10 = (((((i9 << 1) | ((i9 & SupportMenu.USER_MASK) >> 15)) & SupportMenu.USER_MASK) - 1) + 0) ^ 26141;
        int i11 = ((((((i10 << 3) | ((i10 & SupportMenu.USER_MASK) >> 13)) & SupportMenu.USER_MASK) ^ 0) - 48993) ^ 30507) - 57565;
        int i12 = (((((((i11 << 5) | ((i11 & SupportMenu.USER_MASK) >> 11)) & SupportMenu.USER_MASK) - 0) ^ SupportMenu.USER_MASK) + 40281) ^ 0) + 53438;
        int i13 = ((((i12 & SupportMenu.USER_MASK) >> 13) | (i12 << 3)) & SupportMenu.USER_MASK) ^ 5179;
        return str.equals("" + ((char) ((((((((((i13 << 6) | ((i13 & SupportMenu.USER_MASK) >> 10)) & SupportMenu.USER_MASK) - 0) ^ SupportMenu.USER_MASK) - 29164) ^ 64879) + 1937) ^ 887) & SupportMenu.USER_MASK)));
    }
}
