package defpackage;

import androidx.core.internal.view.SupportMenu;

/* loaded from: assets/8f85517967795eeef66c225f7883bdcb.dex */
public class _8f85517967795eeef66c225f7883bdcb {
    public static boolean check(String str) {
        int i = new int[]{16072}[0];
        int i2 = ((((((i & SupportMenu.USER_MASK) >> 13) | (i << 3)) & SupportMenu.USER_MASK) + 1) ^ SupportMenu.USER_MASK) - 51466;
        int i3 = (((((i2 << 1) | ((i2 & SupportMenu.USER_MASK) >> 15)) & SupportMenu.USER_MASK) ^ SupportMenu.USER_MASK) - 1) ^ 0;
        int i4 = (((((((i3 << 8) | ((i3 & SupportMenu.USER_MASK) >> 8)) & SupportMenu.USER_MASK) ^ SupportMenu.USER_MASK) - 1) - 0) - 1) ^ 0;
        int i5 = (((((((((i4 << 15) | ((i4 & SupportMenu.USER_MASK) >> 1)) & SupportMenu.USER_MASK) - 0) ^ 0) + 1) ^ 0) - 0) - 42965) - 0;
        int i6 = ((((((((i5 & SupportMenu.USER_MASK) >> 4) | (i5 << 12)) & SupportMenu.USER_MASK) ^ SupportMenu.USER_MASK) + 0) ^ SupportMenu.USER_MASK) ^ 41009) ^ 0;
        int i7 = ((((i6 & SupportMenu.USER_MASK) >> 5) | (i6 << 11)) & SupportMenu.USER_MASK) - 1;
        int i8 = (((((i7 << 15) | ((i7 & SupportMenu.USER_MASK) >> 1)) & SupportMenu.USER_MASK) - 42178) ^ 51600) + 1;
        int i9 = (((i8 << 8) | ((i8 & SupportMenu.USER_MASK) >> 8)) & SupportMenu.USER_MASK) - 1;
        int i10 = ((((i9 << 15) | ((i9 & SupportMenu.USER_MASK) >> 1)) & SupportMenu.USER_MASK) + 1) ^ 0;
        int i11 = (((((((i10 & SupportMenu.USER_MASK) >> 3) | (i10 << 13)) & SupportMenu.USER_MASK) ^ 7250) - 1) ^ SupportMenu.USER_MASK) + 30148;
        int i12 = ((((i11 << 15) | ((i11 & SupportMenu.USER_MASK) >> 1)) & SupportMenu.USER_MASK) - 1) ^ 0;
        return str.equals("" + ((char) ((((((i12 << 4) | ((i12 & SupportMenu.USER_MASK) >> 12)) & SupportMenu.USER_MASK) ^ 37706) ^ 0) & SupportMenu.USER_MASK)));
    }
}
