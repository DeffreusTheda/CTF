package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import q.AbstractC0086b;
import q.C0087c;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(AbstractC0086b abstractC0086b) {
        IconCompat iconCompat = new IconCompat();
        int i2 = iconCompat.f387a;
        if (abstractC0086b.e(1)) {
            i2 = ((C0087c) abstractC0086b).f1139e.readInt();
        }
        iconCompat.f387a = i2;
        byte[] bArr = iconCompat.f389c;
        if (abstractC0086b.e(2)) {
            Parcel parcel = ((C0087c) abstractC0086b).f1139e;
            int readInt = parcel.readInt();
            if (readInt < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[readInt];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f389c = bArr;
        iconCompat.f390d = abstractC0086b.f(iconCompat.f390d, 3);
        int i3 = iconCompat.f391e;
        if (abstractC0086b.e(4)) {
            i3 = ((C0087c) abstractC0086b).f1139e.readInt();
        }
        iconCompat.f391e = i3;
        int i4 = iconCompat.f392f;
        if (abstractC0086b.e(5)) {
            i4 = ((C0087c) abstractC0086b).f1139e.readInt();
        }
        iconCompat.f392f = i4;
        iconCompat.f393g = (ColorStateList) abstractC0086b.f(iconCompat.f393g, 6);
        String str = iconCompat.f395i;
        if (abstractC0086b.e(7)) {
            str = ((C0087c) abstractC0086b).f1139e.readString();
        }
        iconCompat.f395i = str;
        String str2 = iconCompat.f396j;
        if (abstractC0086b.e(8)) {
            str2 = ((C0087c) abstractC0086b).f1139e.readString();
        }
        iconCompat.f396j = str2;
        iconCompat.f394h = PorterDuff.Mode.valueOf(iconCompat.f395i);
        switch (iconCompat.f387a) {
            case -1:
                Parcelable parcelable = iconCompat.f390d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f388b = parcelable;
                return iconCompat;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f390d;
                if (parcelable2 != null) {
                    iconCompat.f388b = parcelable2;
                } else {
                    byte[] bArr3 = iconCompat.f389c;
                    iconCompat.f388b = bArr3;
                    iconCompat.f387a = 3;
                    iconCompat.f391e = 0;
                    iconCompat.f392f = bArr3.length;
                }
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str3 = new String(iconCompat.f389c, Charset.forName("UTF-16"));
                iconCompat.f388b = str3;
                if (iconCompat.f387a == 2 && iconCompat.f396j == null) {
                    iconCompat.f396j = str3.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f388b = iconCompat.f389c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, AbstractC0086b abstractC0086b) {
        abstractC0086b.getClass();
        iconCompat.f395i = iconCompat.f394h.name();
        switch (iconCompat.f387a) {
            case -1:
                iconCompat.f390d = (Parcelable) iconCompat.f388b;
                break;
            case 1:
            case 5:
                iconCompat.f390d = (Parcelable) iconCompat.f388b;
                break;
            case 2:
                iconCompat.f389c = ((String) iconCompat.f388b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f389c = (byte[]) iconCompat.f388b;
                break;
            case 4:
            case 6:
                iconCompat.f389c = iconCompat.f388b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i2 = iconCompat.f387a;
        if (-1 != i2) {
            abstractC0086b.h(1);
            ((C0087c) abstractC0086b).f1139e.writeInt(i2);
        }
        byte[] bArr = iconCompat.f389c;
        if (bArr != null) {
            abstractC0086b.h(2);
            int length = bArr.length;
            Parcel parcel = ((C0087c) abstractC0086b).f1139e;
            parcel.writeInt(length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f390d;
        if (parcelable != null) {
            abstractC0086b.h(3);
            ((C0087c) abstractC0086b).f1139e.writeParcelable(parcelable, 0);
        }
        int i3 = iconCompat.f391e;
        if (i3 != 0) {
            abstractC0086b.h(4);
            ((C0087c) abstractC0086b).f1139e.writeInt(i3);
        }
        int i4 = iconCompat.f392f;
        if (i4 != 0) {
            abstractC0086b.h(5);
            ((C0087c) abstractC0086b).f1139e.writeInt(i4);
        }
        ColorStateList colorStateList = iconCompat.f393g;
        if (colorStateList != null) {
            abstractC0086b.h(6);
            ((C0087c) abstractC0086b).f1139e.writeParcelable(colorStateList, 0);
        }
        String str = iconCompat.f395i;
        if (str != null) {
            abstractC0086b.h(7);
            ((C0087c) abstractC0086b).f1139e.writeString(str);
        }
        String str2 = iconCompat.f396j;
        if (str2 != null) {
            abstractC0086b.h(8);
            ((C0087c) abstractC0086b).f1139e.writeString(str2);
        }
    }
}
