package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import q.C0085a;
import q.C0087c;
import q.InterfaceC0088d;

/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new C0085a();

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0088d f431a;

    public ParcelImpl(Parcel parcel) {
        this.f431a = new C0087c(parcel).g();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        new C0087c(parcel).i(this.f431a);
    }
}
