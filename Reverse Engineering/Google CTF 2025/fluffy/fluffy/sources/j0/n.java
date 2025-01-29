package j0;

import h0.d0;

/* loaded from: classes.dex */
public final class n extends c {
    public final int m;

    public n(int i2, int i3, Z.l lVar) {
        super(i2, lVar);
        this.m = i3;
        if (i3 == 1) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + a0.l.a(c.class).b() + " instead").toString());
        }
        if (i2 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i2 + " was specified").toString());
    }

    @Override // j0.c, j0.t
    public final Object j(Object obj) {
        k kVar;
        Q.g gVar = Q.g.f327a;
        if (this.m == 3) {
            Object j2 = super.j(obj);
            return (!(j2 instanceof i) || (j2 instanceof h)) ? j2 : gVar;
        }
        n.g gVar2 = e.f889d;
        k kVar2 = (k) c.f878h.get(this);
        while (true) {
            long andIncrement = c.f874d.getAndIncrement(this);
            long j3 = andIncrement & 1152921504606846975L;
            boolean o2 = o(andIncrement, false);
            int i2 = e.f887b;
            long j4 = i2;
            long j5 = j3 / j4;
            int i3 = (int) (j3 % j4);
            if (kVar2.f1034c != j5) {
                k b2 = c.b(this, j5, kVar2);
                if (b2 != null) {
                    kVar = b2;
                } else if (o2) {
                    return new h(l());
                }
            } else {
                kVar = kVar2;
            }
            int c2 = c.c(this, kVar, i3, obj, j3, gVar2, o2);
            if (c2 == 0) {
                kVar.a();
                return gVar;
            }
            if (c2 == 1) {
                return gVar;
            }
            if (c2 == 2) {
                if (o2) {
                    kVar.h();
                    return new h(l());
                }
                d0 d0Var = gVar2 instanceof d0 ? (d0) gVar2 : null;
                if (d0Var != null) {
                    d0Var.a(kVar, i3 + i2);
                }
                g((kVar.f1034c * j4) + i3);
                return gVar;
            }
            if (c2 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (c2 == 4) {
                if (j3 < c.f875e.get(this)) {
                    kVar.a();
                }
                return new h(l());
            }
            if (c2 == 5) {
                kVar.a();
            }
            kVar2 = kVar;
        }
    }

    @Override // j0.c
    public final boolean q() {
        return this.m == 2;
    }
}
