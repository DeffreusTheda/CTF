package s;

import D.AbstractC0009j;
import Z.l;

/* renamed from: s.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0098h extends AbstractC0097g {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1163a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1164b;

    /* renamed from: c, reason: collision with root package name */
    public final C0091a f1165c;

    public C0098h(Object obj, int i2, C0091a c0091a) {
        a0.h.e(obj, "value");
        AbstractC0009j.f("verificationMode", i2);
        this.f1163a = obj;
        this.f1164b = i2;
        this.f1165c = c0091a;
    }

    @Override // s.AbstractC0097g
    public final Object a() {
        return this.f1163a;
    }

    @Override // s.AbstractC0097g
    public final AbstractC0097g d(String str, l lVar) {
        Object obj = this.f1163a;
        return ((Boolean) lVar.h(obj)).booleanValue() ? this : new C0096f(obj, str, this.f1165c, this.f1164b);
    }
}
