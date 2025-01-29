package h;

import android.graphics.Insets;

/* renamed from: h.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0040b {

    /* renamed from: e, reason: collision with root package name */
    public static final C0040b f510e = new C0040b(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f511a;

    /* renamed from: b, reason: collision with root package name */
    public final int f512b;

    /* renamed from: c, reason: collision with root package name */
    public final int f513c;

    /* renamed from: d, reason: collision with root package name */
    public final int f514d;

    public C0040b(int i2, int i3, int i4, int i5) {
        this.f511a = i2;
        this.f512b = i3;
        this.f513c = i4;
        this.f514d = i5;
    }

    public static C0040b a(int i2, int i3, int i4, int i5) {
        return (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) ? f510e : new C0040b(i2, i3, i4, i5);
    }

    public final Insets b() {
        return AbstractC0039a.a(this.f511a, this.f512b, this.f513c, this.f514d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0040b.class != obj.getClass()) {
            return false;
        }
        C0040b c0040b = (C0040b) obj;
        return this.f514d == c0040b.f514d && this.f511a == c0040b.f511a && this.f513c == c0040b.f513c && this.f512b == c0040b.f512b;
    }

    public final int hashCode() {
        return (((((this.f511a * 31) + this.f512b) * 31) + this.f513c) * 31) + this.f514d;
    }

    public final String toString() {
        return "Insets{left=" + this.f511a + ", top=" + this.f512b + ", right=" + this.f513c + ", bottom=" + this.f514d + '}';
    }
}
