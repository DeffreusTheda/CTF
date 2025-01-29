package defpackage;

import androidx.core.internal.view.SupportMenu;

/* loaded from: assets/979d472a84804b9f647bc185a877a8b5.dex */
public class _979d472a84804b9f647bc185a877a8b5 {
    public static boolean check(String str) {
        int i = new int[]{9964}[0];
        int i2 = ((((i & SupportMenu.USER_MASK) >> 4) | (i << 12)) & SupportMenu.USER_MASK) + 1;
        int i3 = (((((i2 << 5) | ((i2 & SupportMenu.USER_MASK) >> 11)) & SupportMenu.USER_MASK) ^ 0) + 1) ^ SupportMenu.USER_MASK;
        int i4 = ((((i3 & SupportMenu.USER_MASK) >> 6) | (i3 << 10)) & SupportMenu.USER_MASK) + 0;
        int i5 = (((((((i4 << 7) | ((i4 & SupportMenu.USER_MASK) >> 9)) & SupportMenu.USER_MASK) + 0) ^ 62009) - 1) ^ 43600) + 1;
        int i6 = ((((i5 & SupportMenu.USER_MASK) >> 1) | (i5 << 15)) & SupportMenu.USER_MASK) + 15530;
        int i7 = ((((i6 & SupportMenu.USER_MASK) >> 5) | (i6 << 11)) & SupportMenu.USER_MASK) - 54048;
        int i8 = (((((((i7 << 6) | ((i7 & SupportMenu.USER_MASK) >> 10)) & SupportMenu.USER_MASK) ^ 7719) - 0) - 1) ^ 53006) + 1;
        int i9 = (((((((i8 & SupportMenu.USER_MASK) >> 2) | (i8 << 14)) & SupportMenu.USER_MASK) - 27012) ^ 5300) - 1) + 0;
        int i10 = (((i9 << 15) | ((i9 & SupportMenu.USER_MASK) >> 1)) & SupportMenu.USER_MASK) ^ 55651;
        int i11 = ((((i10 & SupportMenu.USER_MASK) >> 3) | (i10 << 13)) & SupportMenu.USER_MASK) + 1;
        int i12 = ((((((i11 & SupportMenu.USER_MASK) >> 14) | (i11 << 2)) & SupportMenu.USER_MASK) ^ 0) + 1) ^ 4386;
        int i13 = (((i12 << 4) | ((i12 & SupportMenu.USER_MASK) >> 12)) & SupportMenu.USER_MASK) + 26526;
        int i14 = (((((((((i13 << 4) | ((i13 & SupportMenu.USER_MASK) >> 12)) & SupportMenu.USER_MASK) + 1) + 0) ^ 53958) - 32731) + 0) ^ SupportMenu.USER_MASK) + 0;
        return str.equals("" + ((char) (((((((i14 & SupportMenu.USER_MASK) >> 2) | (i14 << 14)) & SupportMenu.USER_MASK) - 1) ^ SupportMenu.USER_MASK) & SupportMenu.USER_MASK)));
    }
}
