package h0;

/* renamed from: h0.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0056p extends S.a implements S.f {

    /* renamed from: c, reason: collision with root package name */
    public static final C0055o f573c = new C0055o(S.e.f342b, C0054n.f570c);

    public AbstractC0056p() {
        super(S.e.f342b);
    }

    public abstract void c(S.i iVar, Runnable runnable);

    @Override // S.a, S.i
    public final S.i d(S.h hVar) {
        a0.h.e(hVar, "key");
        boolean z2 = hVar instanceof C0055o;
        S.j jVar = S.j.f343b;
        if (z2) {
            C0055o c0055o = (C0055o) hVar;
            S.h hVar2 = this.f338b;
            if ((hVar2 == c0055o || c0055o.f572c == hVar2) && c0055o.a(this) != null) {
                return jVar;
            }
        } else if (S.e.f342b == hVar) {
            return jVar;
        }
        return this;
    }

    @Override // S.a, S.i
    public final S.g f(S.h hVar) {
        a0.h.e(hVar, "key");
        if (!(hVar instanceof C0055o)) {
            if (S.e.f342b == hVar) {
                return this;
            }
            return null;
        }
        C0055o c0055o = (C0055o) hVar;
        S.h hVar2 = this.f338b;
        if (hVar2 != c0055o && c0055o.f572c != hVar2) {
            return null;
        }
        S.g a2 = c0055o.a(this);
        if (a2 instanceof S.g) {
            return a2;
        }
        return null;
    }

    public boolean g() {
        return !(this instanceof b0);
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + AbstractC0059t.a(this);
    }
}
