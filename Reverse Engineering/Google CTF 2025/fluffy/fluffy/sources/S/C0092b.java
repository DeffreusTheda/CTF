package s;

import android.graphics.Rect;

/* renamed from: s.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0092b {

    /* renamed from: a, reason: collision with root package name */
    public final int f1150a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1151b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1152c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1153d;

    public C0092b(Rect rect) {
        int i2 = rect.left;
        int i3 = rect.top;
        int i4 = rect.right;
        int i5 = rect.bottom;
        this.f1150a = i2;
        this.f1151b = i3;
        this.f1152c = i4;
        this.f1153d = i5;
        if (i2 > i4) {
            throw new IllegalArgumentException(("Left must be less than or equal to right, left: " + i2 + ", right: " + i4).toString());
        }
        if (i3 <= i5) {
            return;
        }
        throw new IllegalArgumentException(("top must be less than or equal to bottom, top: " + i3 + ", bottom: " + i5).toString());
    }

    public final int a() {
        return this.f1153d - this.f1151b;
    }

    public final int b() {
        return this.f1152c - this.f1150a;
    }

    public final Rect c() {
        return new Rect(this.f1150a, this.f1151b, this.f1152c, this.f1153d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!C0092b.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        a0.h.c(obj, "null cannot be cast to non-null type androidx.window.core.Bounds");
        C0092b c0092b = (C0092b) obj;
        return this.f1150a == c0092b.f1150a && this.f1151b == c0092b.f1151b && this.f1152c == c0092b.f1152c && this.f1153d == c0092b.f1153d;
    }

    public final int hashCode() {
        return (((((this.f1150a * 31) + this.f1151b) * 31) + this.f1152c) * 31) + this.f1153d;
    }

    public final String toString() {
        return C0092b.class.getSimpleName() + " { [" + this.f1150a + ',' + this.f1151b + ',' + this.f1152c + ',' + this.f1153d + "] }";
    }
}
