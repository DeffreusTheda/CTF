package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class b extends a {

    /* renamed from: d, reason: collision with root package name */
    private final SparseIntArray f81d;

    /* renamed from: e, reason: collision with root package name */
    private final Parcel f82e;

    /* renamed from: f, reason: collision with root package name */
    private final int f83f;

    /* renamed from: g, reason: collision with root package name */
    private final int f84g;

    /* renamed from: h, reason: collision with root package name */
    private final String f85h;

    /* renamed from: i, reason: collision with root package name */
    private int f86i;

    /* renamed from: j, reason: collision with root package name */
    private int f87j;

    /* renamed from: k, reason: collision with root package name */
    private int f88k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new b.a(), new b.a(), new b.a());
    }

    private b(Parcel parcel, int i2, int i3, String str, b.a<String, Method> aVar, b.a<String, Method> aVar2, b.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f81d = new SparseIntArray();
        this.f86i = -1;
        this.f88k = -1;
        this.f82e = parcel;
        this.f83f = i2;
        this.f84g = i3;
        this.f87j = i2;
        this.f85h = str;
    }

    @Override // androidx.versionedparcelable.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f82e.writeInt(-1);
        } else {
            this.f82e.writeInt(bArr.length);
            this.f82e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f82e, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void E(int i2) {
        this.f82e.writeInt(i2);
    }

    @Override // androidx.versionedparcelable.a
    public void G(Parcelable parcelable) {
        this.f82e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void I(String str) {
        this.f82e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a() {
        int i2 = this.f86i;
        if (i2 >= 0) {
            int i3 = this.f81d.get(i2);
            int dataPosition = this.f82e.dataPosition();
            this.f82e.setDataPosition(i3);
            this.f82e.writeInt(dataPosition - i3);
            this.f82e.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected a b() {
        Parcel parcel = this.f82e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.f87j;
        if (i2 == this.f83f) {
            i2 = this.f84g;
        }
        return new b(parcel, dataPosition, i2, this.f85h + "  ", this.f78a, this.f79b, this.f80c);
    }

    @Override // androidx.versionedparcelable.a
    public boolean g() {
        return this.f82e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.a
    public byte[] i() {
        int readInt = this.f82e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f82e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f82e);
    }

    @Override // androidx.versionedparcelable.a
    public boolean m(int i2) {
        while (this.f87j < this.f84g) {
            int i3 = this.f88k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f82e.setDataPosition(this.f87j);
            int readInt = this.f82e.readInt();
            this.f88k = this.f82e.readInt();
            this.f87j += readInt;
        }
        return this.f88k == i2;
    }

    @Override // androidx.versionedparcelable.a
    public int o() {
        return this.f82e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public <T extends Parcelable> T q() {
        return (T) this.f82e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public String s() {
        return this.f82e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public void w(int i2) {
        a();
        this.f86i = i2;
        this.f81d.put(i2, this.f82e.dataPosition());
        E(0);
        E(i2);
    }

    @Override // androidx.versionedparcelable.a
    public void y(boolean z2) {
        this.f82e.writeInt(z2 ? 1 : 0);
    }
}
