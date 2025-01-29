package s;

import java.math.BigInteger;
import r.C0089a;

/* renamed from: s.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0099i implements Comparable {

    /* renamed from: g, reason: collision with root package name */
    public static final C0099i f1166g;

    /* renamed from: b, reason: collision with root package name */
    public final int f1167b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1168c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1169d;

    /* renamed from: e, reason: collision with root package name */
    public final String f1170e;

    /* renamed from: f, reason: collision with root package name */
    public final Q.e f1171f = new Q.e(new C0089a(1, this));

    static {
        new C0099i(0, 0, 0, "");
        f1166g = new C0099i(0, 1, 0, "");
        new C0099i(1, 0, 0, "");
    }

    public C0099i(int i2, int i3, int i4, String str) {
        this.f1167b = i2;
        this.f1168c = i3;
        this.f1169d = i4;
        this.f1170e = str;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        C0099i c0099i = (C0099i) obj;
        a0.h.e(c0099i, "other");
        Object a2 = this.f1171f.a();
        a0.h.d(a2, "<get-bigInteger>(...)");
        Object a3 = c0099i.f1171f.a();
        a0.h.d(a3, "<get-bigInteger>(...)");
        return ((BigInteger) a2).compareTo((BigInteger) a3);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0099i)) {
            return false;
        }
        C0099i c0099i = (C0099i) obj;
        return this.f1167b == c0099i.f1167b && this.f1168c == c0099i.f1168c && this.f1169d == c0099i.f1169d;
    }

    public final int hashCode() {
        return ((((527 + this.f1167b) * 31) + this.f1168c) * 31) + this.f1169d;
    }

    public final String toString() {
        String str;
        String str2 = this.f1170e;
        int i2 = 0;
        while (true) {
            if (i2 >= str2.length()) {
                str = "";
                break;
            }
            char charAt = str2.charAt(i2);
            if (!Character.isWhitespace(charAt) && !Character.isSpaceChar(charAt)) {
                str = "-".concat(str2);
                break;
            }
            i2++;
        }
        return this.f1167b + '.' + this.f1168c + '.' + this.f1169d + str;
    }
}
