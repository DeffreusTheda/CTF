package defpackage;

import androidx.core.internal.view.SupportMenu;

/* loaded from: assets/3ef815416f775098fe977004015c6193.dex */
public class _3ef815416f775098fe977004015c6193 {
    public static boolean check(String str) {
        int i = new int[]{13607}[0];
        int i2 = (((i << 3) | ((i & SupportMenu.USER_MASK) >> 13)) & SupportMenu.USER_MASK) + 1;
        int i3 = (((((i2 & SupportMenu.USER_MASK) >> 8) | (i2 << 8)) & SupportMenu.USER_MASK) - 1) ^ 0;
        int i4 = ((((i3 << 14) | ((i3 & SupportMenu.USER_MASK) >> 2)) & SupportMenu.USER_MASK) ^ 0) - 1;
        int i5 = ((((i4 << 5) | ((i4 & SupportMenu.USER_MASK) >> 11)) & SupportMenu.USER_MASK) ^ 35089) - 18452;
        int i6 = (((((i5 << 11) | ((i5 & SupportMenu.USER_MASK) >> 5)) & SupportMenu.USER_MASK) ^ 0) - 0) + 31286;
        int i7 = ((((((i6 << 5) | ((i6 & SupportMenu.USER_MASK) >> 11)) & SupportMenu.USER_MASK) + 0) + 1) - 0) - 1;
        int i8 = (((((((i7 & SupportMenu.USER_MASK) >> 13) | (i7 << 3)) & SupportMenu.USER_MASK) + 16999) + 0) ^ 0) + 57237 + 0 + 54415;
        int i9 = (((((((i8 & SupportMenu.USER_MASK) >> 10) | (i8 << 6)) & SupportMenu.USER_MASK) + 1) ^ 0) ^ SupportMenu.USER_MASK) + 0 + 19362;
        int i10 = (((((i9 << 12) | ((i9 & SupportMenu.USER_MASK) >> 4)) & SupportMenu.USER_MASK) + 1) + 0) - 1;
        int i11 = ((((i10 & SupportMenu.USER_MASK) >> 13) | (i10 << 3)) & SupportMenu.USER_MASK) - 0;
        int i12 = ((((((((i11 & SupportMenu.USER_MASK) >> 2) | (i11 << 14)) & SupportMenu.USER_MASK) + 0) ^ 0) - 22065) ^ 0) + 29688;
        int i13 = ((((i12 & SupportMenu.USER_MASK) >> 15) | (i12 << 1)) & SupportMenu.USER_MASK) + 0;
        return str.equals("" + ((char) (((((((i13 & SupportMenu.USER_MASK) >> 15) | (i13 << 1)) & SupportMenu.USER_MASK) - 1) - 0) & SupportMenu.USER_MASK)));
    }
}
