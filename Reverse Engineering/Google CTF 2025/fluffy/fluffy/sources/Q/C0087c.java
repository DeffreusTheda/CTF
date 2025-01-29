package q;

import android.os.Parcel;
import android.util.SparseIntArray;
import e.C0024a;

/* renamed from: q.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0087c extends AbstractC0086b {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f1138d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f1139e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1140f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1141g;

    /* renamed from: h, reason: collision with root package name */
    public final String f1142h;

    /* renamed from: i, reason: collision with root package name */
    public int f1143i;

    /* renamed from: j, reason: collision with root package name */
    public int f1144j;

    /* renamed from: k, reason: collision with root package name */
    public int f1145k;

    public C0087c(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C0024a(), new C0024a(), new C0024a());
    }

    @Override // q.AbstractC0086b
    public final C0087c a() {
        Parcel parcel = this.f1139e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.f1144j;
        if (i2 == this.f1140f) {
            i2 = this.f1141g;
        }
        return new C0087c(parcel, dataPosition, i2, this.f1142h + "  ", this.f1135a, this.f1136b, this.f1137c);
    }

    @Override // q.AbstractC0086b
    public final boolean e(int i2) {
        while (this.f1144j < this.f1141g) {
            int i3 = this.f1145k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            int i4 = this.f1144j;
            Parcel parcel = this.f1139e;
            parcel.setDataPosition(i4);
            int readInt = parcel.readInt();
            this.f1145k = parcel.readInt();
            this.f1144j += readInt;
        }
        return this.f1145k == i2;
    }

    @Override // q.AbstractC0086b
    public final void h(int i2) {
        int i3 = this.f1143i;
        SparseIntArray sparseIntArray = this.f1138d;
        Parcel parcel = this.f1139e;
        if (i3 >= 0) {
            int i4 = sparseIntArray.get(i3);
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(i4);
            parcel.writeInt(dataPosition - i4);
            parcel.setDataPosition(dataPosition);
        }
        this.f1143i = i2;
        sparseIntArray.put(i2, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i2);
    }

    public C0087c(Parcel parcel, int i2, int i3, String str, C0024a c0024a, C0024a c0024a2, C0024a c0024a3) {
        super(c0024a, c0024a2, c0024a3);
        this.f1138d = new SparseIntArray();
        this.f1143i = -1;
        this.f1145k = -1;
        this.f1139e = parcel;
        this.f1140f = i2;
        this.f1141g = i3;
        this.f1144j = i2;
        this.f1142h = str;
    }
}
