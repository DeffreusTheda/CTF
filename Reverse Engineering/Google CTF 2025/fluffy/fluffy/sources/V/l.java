package v;

import android.graphics.Rect;
import l.s;
import s.C0092b;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final C0092b f1205a;

    /* renamed from: b, reason: collision with root package name */
    public final s f1206b;

    public l(C0092b c0092b, s sVar) {
        a0.h.e(sVar, "_windowInsetsCompat");
        this.f1205a = c0092b;
        this.f1206b = sVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!l.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        a0.h.c(obj, "null cannot be cast to non-null type androidx.window.layout.WindowMetrics");
        l lVar = (l) obj;
        return a0.h.a(this.f1205a, lVar.f1205a) && a0.h.a(this.f1206b, lVar.f1206b);
    }

    public final int hashCode() {
        return this.f1206b.hashCode() + (this.f1205a.hashCode() * 31);
    }

    public final String toString() {
        return "WindowMetrics( bounds=" + this.f1205a + ", windowInsetsCompat=" + this.f1206b + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(Rect rect, s sVar) {
        this(new C0092b(rect), sVar);
        a0.h.e(sVar, "insets");
    }
}
