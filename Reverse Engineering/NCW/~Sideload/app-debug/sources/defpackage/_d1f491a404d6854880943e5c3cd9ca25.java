package defpackage;

import androidx.core.internal.view.SupportMenu;

/* loaded from: assets/d1f491a404d6854880943e5c3cd9ca25.dex */
public class _d1f491a404d6854880943e5c3cd9ca25 {
    public static boolean check(String str) {
        int i = (((new int[]{13837}[0] - 1) ^ SupportMenu.USER_MASK) + 1) ^ 61869;
        int i2 = ((((i & SupportMenu.USER_MASK) >> 10) | (i << 6)) & SupportMenu.USER_MASK) - 0;
        int i3 = ((((((((i2 << 10) | ((i2 & SupportMenu.USER_MASK) >> 6)) & SupportMenu.USER_MASK) + 56745) - 0) + 8458) ^ 0) - 58075) - 0;
        int i4 = (((((i3 & SupportMenu.USER_MASK) >> 10) | (i3 << 6)) & SupportMenu.USER_MASK) + 25833) ^ 46859;
        int i5 = (((((i4 << 10) | ((i4 & SupportMenu.USER_MASK) >> 6)) & SupportMenu.USER_MASK) - 1) + 0) - 1;
        int i6 = ((((i5 & SupportMenu.USER_MASK) >> 13) | (i5 << 3)) & SupportMenu.USER_MASK) - 16818;
        int i7 = ((((i6 & SupportMenu.USER_MASK) >> 15) | (i6 << 1)) & SupportMenu.USER_MASK) - 16332;
        int i8 = (((i7 << 1) | ((i7 & SupportMenu.USER_MASK) >> 15)) & SupportMenu.USER_MASK) + 1;
        int i9 = (((i8 << 4) | ((i8 & SupportMenu.USER_MASK) >> 12)) & SupportMenu.USER_MASK) ^ 53171;
        int i10 = (((((((i9 << 3) | ((i9 & SupportMenu.USER_MASK) >> 13)) & SupportMenu.USER_MASK) - 43811) - 0) ^ SupportMenu.USER_MASK) - 31246) ^ 24201;
        int i11 = ((((((((i10 & SupportMenu.USER_MASK) >> 1) | (i10 << 15)) & SupportMenu.USER_MASK) + 18219) ^ SupportMenu.USER_MASK) ^ 25656) - 49041) ^ SupportMenu.USER_MASK;
        int i12 = ((((i11 << 5) | ((i11 & SupportMenu.USER_MASK) >> 11)) & SupportMenu.USER_MASK) ^ 0) + 1;
        int i13 = (((((i12 << 14) | ((i12 & SupportMenu.USER_MASK) >> 2)) & SupportMenu.USER_MASK) ^ 0) ^ 34585) - 38696;
        return str.equals("" + ((char) ((((((i13 << 15) | ((i13 & SupportMenu.USER_MASK) >> 1)) & SupportMenu.USER_MASK) + 1) ^ SupportMenu.USER_MASK) & SupportMenu.USER_MASK)));
    }
}
