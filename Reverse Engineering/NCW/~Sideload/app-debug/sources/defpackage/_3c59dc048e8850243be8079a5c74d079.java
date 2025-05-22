package defpackage;

import androidx.core.internal.view.SupportMenu;

/* loaded from: assets/3c59dc048e8850243be8079a5c74d079.dex */
public class _3c59dc048e8850243be8079a5c74d079 {
    public static boolean check(String str) {
        int i = ((new int[]{37434}[0] - 0) ^ SupportMenu.USER_MASK) + 15119;
        int i2 = ((((i & SupportMenu.USER_MASK) >> 1) | (i << 15)) & SupportMenu.USER_MASK) + 24498;
        int i3 = ((((((i2 & SupportMenu.USER_MASK) >> 8) | (i2 << 8)) & SupportMenu.USER_MASK) + 52152) ^ 0) - 1;
        int i4 = ((((((i3 << 11) | ((i3 & SupportMenu.USER_MASK) >> 5)) & SupportMenu.USER_MASK) ^ 0) - 0) - 19821) ^ SupportMenu.USER_MASK;
        int i5 = (((((i4 << 7) | ((i4 & SupportMenu.USER_MASK) >> 9)) & SupportMenu.USER_MASK) + 48967) ^ 0) - 1;
        int i6 = (((((((i5 & SupportMenu.USER_MASK) >> 13) | (i5 << 3)) & SupportMenu.USER_MASK) + 1) ^ 38681) ^ 0) + 35654;
        int i7 = ((((i6 & SupportMenu.USER_MASK) >> 8) | (i6 << 8)) & SupportMenu.USER_MASK) - 0;
        int i8 = (((((((((((((i7 & SupportMenu.USER_MASK) >> 3) | (i7 << 13)) & SupportMenu.USER_MASK) - 26727) - 0) ^ 0) + 35480) ^ SupportMenu.USER_MASK) + 1) - 0) - 54567) ^ SupportMenu.USER_MASK) + 0;
        int i9 = (((((i8 << 1) | ((i8 & SupportMenu.USER_MASK) >> 15)) & SupportMenu.USER_MASK) ^ 0) - 1) - 0;
        int i10 = ((((i9 << 14) | ((i9 & SupportMenu.USER_MASK) >> 2)) & SupportMenu.USER_MASK) - 1) + 0;
        int i11 = (((((((i10 << 6) | ((i10 & SupportMenu.USER_MASK) >> 10)) & SupportMenu.USER_MASK) - 49076) ^ 6242) ^ 0) - 1) ^ 0;
        return str.equals("" + ((char) ((((i11 & SupportMenu.USER_MASK) >> 4) | (i11 << 12)) & SupportMenu.USER_MASK & SupportMenu.USER_MASK)));
    }
}
