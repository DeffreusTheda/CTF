package defpackage;

import androidx.core.internal.view.SupportMenu;

/* loaded from: assets/eda80a3d5b344bc40f3bc04f65b7a357.dex */
public class _eda80a3d5b344bc40f3bc04f65b7a357 {
    public static boolean check(String str) {
        int i = new int[]{6360}[0];
        int i2 = (((i << 8) | ((i & SupportMenu.USER_MASK) >> 8)) & SupportMenu.USER_MASK) ^ 0;
        int i3 = ((((i2 << 11) | ((i2 & SupportMenu.USER_MASK) >> 5)) & SupportMenu.USER_MASK) - 0) + 39832;
        int i4 = (((((i3 & SupportMenu.USER_MASK) >> 10) | (i3 << 6)) & SupportMenu.USER_MASK) ^ 0) + 57972;
        int i5 = ((((((i4 << 5) | ((i4 & SupportMenu.USER_MASK) >> 11)) & SupportMenu.USER_MASK) - 1) - 0) + 15699) ^ SupportMenu.USER_MASK;
        int i6 = (((((((((((((((((((((((((i5 << 2) | ((i5 & SupportMenu.USER_MASK) >> 14)) & SupportMenu.USER_MASK) ^ 64647) - 13916) ^ SupportMenu.USER_MASK) + 0) - 38675) - 0) ^ 0) + 0) - 8922) + 0) - 1456) ^ 48880) - 49523) + 0) ^ SupportMenu.USER_MASK) - 35683) - 0) ^ SupportMenu.USER_MASK) ^ 0) ^ SupportMenu.USER_MASK) ^ 21870) - 0) ^ SupportMenu.USER_MASK;
        int i7 = (((i6 << 5) | ((i6 & SupportMenu.USER_MASK) >> 11)) & SupportMenu.USER_MASK) - 1;
        int i8 = ((((i7 << 3) | ((i7 & SupportMenu.USER_MASK) >> 13)) & SupportMenu.USER_MASK) ^ SupportMenu.USER_MASK) + 1;
        int i9 = ((((i8 & SupportMenu.USER_MASK) >> 13) | (i8 << 3)) & SupportMenu.USER_MASK) + 0;
        int i10 = (((((i9 << 9) | ((i9 & SupportMenu.USER_MASK) >> 7)) & SupportMenu.USER_MASK) - 2938) - 0) ^ 0;
        return str.equals("" + ((char) ((((((i10 & SupportMenu.USER_MASK) >> 1) | (i10 << 15)) & SupportMenu.USER_MASK) ^ SupportMenu.USER_MASK) & SupportMenu.USER_MASK)));
    }
}
