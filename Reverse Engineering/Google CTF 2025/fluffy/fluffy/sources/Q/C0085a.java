package q;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;

/* renamed from: q.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0085a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new ParcelImpl(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i2) {
        return new ParcelImpl[i2];
    }
}
