package defpackage;

import androidx.core.internal.view.SupportMenu;

/* loaded from: assets/812b4ba287f5ee0bc9d43bbf5bbe87fb.dex */
public class _812b4ba287f5ee0bc9d43bbf5bbe87fb {
    public static boolean check(String str) {
        int i = ((new int[]{783}[0] ^ 0) - 64631) ^ SupportMenu.USER_MASK;
        int i2 = ((((i & SupportMenu.USER_MASK) >> 13) | (i << 3)) & SupportMenu.USER_MASK) ^ 0;
        int i3 = ((((((((((((i2 << 8) | ((i2 & SupportMenu.USER_MASK) >> 8)) & SupportMenu.USER_MASK) ^ 0) - 1) ^ 48446) + 51617) + 0) + 1) - 0) + 62502) + 0) ^ SupportMenu.USER_MASK;
        int i4 = ((((((((((((i3 & SupportMenu.USER_MASK) >> 7) | (i3 << 9)) & SupportMenu.USER_MASK) + 6003) ^ 0) + 35452) ^ 64559) - 1) + 0) ^ 2549) - 1) ^ 0;
        int i5 = ((((((((i4 & SupportMenu.USER_MASK) >> 9) | (i4 << 7)) & SupportMenu.USER_MASK) + 0) + 64128) - 0) - 1) ^ 0;
        int i6 = ((((i5 & SupportMenu.USER_MASK) >> 5) | (i5 << 11)) & SupportMenu.USER_MASK) - 0;
        int i7 = (((((((i6 & SupportMenu.USER_MASK) >> 10) | (i6 << 6)) & SupportMenu.USER_MASK) ^ SupportMenu.USER_MASK) ^ 0) + 1) ^ 54080;
        return str.equals("" + ((char) (((((((((((((((i7 & SupportMenu.USER_MASK) >> 6) | (i7 << 10)) & SupportMenu.USER_MASK) + 31633) - 0) + 1) ^ SupportMenu.USER_MASK) ^ 0) + 1) ^ 27189) + 32765) ^ 0) + 1) & SupportMenu.USER_MASK)));
    }
}
