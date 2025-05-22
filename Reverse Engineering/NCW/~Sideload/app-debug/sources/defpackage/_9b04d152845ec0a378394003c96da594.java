package defpackage;

import androidx.core.internal.view.SupportMenu;

/* loaded from: assets/9b04d152845ec0a378394003c96da594.dex */
public class _9b04d152845ec0a378394003c96da594 {
    public static boolean check(String str) {
        int i = new int[]{31730}[0];
        int i2 = ((((i & SupportMenu.USER_MASK) >> 12) | (i << 4)) & SupportMenu.USER_MASK) ^ SupportMenu.USER_MASK;
        int i3 = (((i2 << 10) | ((i2 & SupportMenu.USER_MASK) >> 6)) & SupportMenu.USER_MASK) + 1;
        int i4 = (((i3 << 8) | ((i3 & SupportMenu.USER_MASK) >> 8)) & SupportMenu.USER_MASK) - 0;
        int i5 = (((((i4 << 13) | ((i4 & SupportMenu.USER_MASK) >> 3)) & SupportMenu.USER_MASK) ^ 19045) - 0) - 1;
        int i6 = ((((((i5 << 1) | ((i5 & SupportMenu.USER_MASK) >> 15)) & SupportMenu.USER_MASK) - 1) ^ 0) - 0) - 1;
        int i7 = (((((((((i6 & SupportMenu.USER_MASK) >> 15) | (i6 << 1)) & SupportMenu.USER_MASK) ^ 43615) ^ 0) - 8500) ^ SupportMenu.USER_MASK) - 0) + 1;
        int i8 = ((((i7 & SupportMenu.USER_MASK) >> 13) | (i7 << 3)) & SupportMenu.USER_MASK) + 1 + 0;
        int i9 = ((((((((((((i8 & SupportMenu.USER_MASK) >> 3) | (i8 << 13)) & SupportMenu.USER_MASK) - 5740) ^ 10423) + 1) - 0) ^ SupportMenu.USER_MASK) + 1) + 0) ^ 0) - 1;
        int i10 = (((((i9 & SupportMenu.USER_MASK) >> 7) | (i9 << 9)) & SupportMenu.USER_MASK) ^ SupportMenu.USER_MASK) + 1;
        int i11 = ((((((((i10 << 2) | ((i10 & SupportMenu.USER_MASK) >> 14)) & SupportMenu.USER_MASK) ^ SupportMenu.USER_MASK) - 0) + 27022) - 0) + 52892) - 0;
        int i12 = (((i11 << 2) | ((i11 & SupportMenu.USER_MASK) >> 14)) & SupportMenu.USER_MASK) + 17985;
        return str.equals("" + ((char) ((((((i12 << 7) | ((i12 & SupportMenu.USER_MASK) >> 9)) & SupportMenu.USER_MASK) - 63168) ^ 23299) & SupportMenu.USER_MASK)));
    }
}
