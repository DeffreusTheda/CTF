package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.a;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f39a = aVar.p(iconCompat.f39a, 1);
        iconCompat.f41c = aVar.j(iconCompat.f41c, 2);
        iconCompat.f42d = aVar.r(iconCompat.f42d, 3);
        iconCompat.f43e = aVar.p(iconCompat.f43e, 4);
        iconCompat.f44f = aVar.p(iconCompat.f44f, 5);
        iconCompat.f45g = (ColorStateList) aVar.r(iconCompat.f45g, 6);
        iconCompat.f47i = aVar.t(iconCompat.f47i, 7);
        iconCompat.f48j = aVar.t(iconCompat.f48j, 8);
        iconCompat.c();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.x(true, true);
        iconCompat.d(aVar.f());
        int i2 = iconCompat.f39a;
        if (-1 != i2) {
            aVar.F(i2, 1);
        }
        byte[] bArr = iconCompat.f41c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f42d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i3 = iconCompat.f43e;
        if (i3 != 0) {
            aVar.F(i3, 4);
        }
        int i4 = iconCompat.f44f;
        if (i4 != 0) {
            aVar.F(i4, 5);
        }
        ColorStateList colorStateList = iconCompat.f45g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f47i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f48j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
