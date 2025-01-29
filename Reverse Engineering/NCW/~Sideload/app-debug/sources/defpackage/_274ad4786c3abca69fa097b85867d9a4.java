package defpackage;

import androidx.core.internal.view.SupportMenu;

/* loaded from: assets/274ad4786c3abca69fa097b85867d9a4.dex */
public class _274ad4786c3abca69fa097b85867d9a4 {
    public static boolean check(String str) {
        int i = new int[]{41660}[0] ^ SupportMenu.USER_MASK;
        int i2 = ((((((i << 12) | ((i & SupportMenu.USER_MASK) >> 4)) & SupportMenu.USER_MASK) ^ SupportMenu.USER_MASK) - 13725) + 0) - 1;
        int i3 = ((((((i2 << 15) | ((i2 & SupportMenu.USER_MASK) >> 1)) & SupportMenu.USER_MASK) ^ SupportMenu.USER_MASK) + 0) + 1) ^ 63351;
        int i4 = (((((((((i3 & SupportMenu.USER_MASK) >> 9) | (i3 << 7)) & SupportMenu.USER_MASK) + 16032) ^ 0) - 5435) ^ 51240) - 0) - 1;
        int i5 = (((((((((i4 << 6) | ((i4 & SupportMenu.USER_MASK) >> 10)) & SupportMenu.USER_MASK) - 0) - 61898) - 0) + 65314) ^ 24266) + 1) - 0;
        int i6 = (((((i5 << 13) | ((i5 & SupportMenu.USER_MASK) >> 3)) & SupportMenu.USER_MASK) - 1) ^ SupportMenu.USER_MASK) + 8687;
        int i7 = ((((((((i6 & SupportMenu.USER_MASK) >> 5) | (i6 << 11)) & SupportMenu.USER_MASK) - 1) ^ 0) - 0) ^ 0) + 0;
        int i8 = (((i7 << 9) | ((i7 & SupportMenu.USER_MASK) >> 7)) & SupportMenu.USER_MASK) + 1;
        int i9 = ((((i8 & SupportMenu.USER_MASK) >> 7) | (i8 << 9)) & SupportMenu.USER_MASK) + 6042;
        int i10 = (((((i9 & SupportMenu.USER_MASK) >> 14) | (i9 << 2)) & SupportMenu.USER_MASK) - 0) + 50350;
        int i11 = ((((((i10 & SupportMenu.USER_MASK) >> 14) | (i10 << 2)) & SupportMenu.USER_MASK) - 0) + 1) ^ 4868;
        int i12 = ((((i11 & SupportMenu.USER_MASK) >> 15) | (i11 << 1)) & SupportMenu.USER_MASK) - 1;
        return str.equals("" + ((char) (((i12 << 13) | ((i12 & SupportMenu.USER_MASK) >> 3)) & SupportMenu.USER_MASK & SupportMenu.USER_MASK)));
    }
}
