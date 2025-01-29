package S;

import Z.p;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class c implements i, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public final i f340b;

    /* renamed from: c, reason: collision with root package name */
    public final g f341c;

    public c(g gVar, i iVar) {
        a0.h.e(iVar, "left");
        this.f340b = iVar;
        this.f341c = gVar;
    }

    @Override // S.i
    public final i d(h hVar) {
        a0.h.e(hVar, "key");
        g gVar = this.f341c;
        g f2 = gVar.f(hVar);
        i iVar = this.f340b;
        if (f2 != null) {
            return iVar;
        }
        i d2 = iVar.d(hVar);
        return d2 == iVar ? this : d2 == j.f343b ? gVar : new c(gVar, d2);
    }

    @Override // S.i
    public final i e(i iVar) {
        return a.a.r(this, iVar);
    }

    public final boolean equals(Object obj) {
        boolean z2;
        if (this != obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            cVar.getClass();
            int i2 = 2;
            c cVar2 = cVar;
            int i3 = 2;
            while (true) {
                i iVar = cVar2.f340b;
                cVar2 = iVar instanceof c ? (c) iVar : null;
                if (cVar2 == null) {
                    break;
                }
                i3++;
            }
            c cVar3 = this;
            while (true) {
                i iVar2 = cVar3.f340b;
                cVar3 = iVar2 instanceof c ? (c) iVar2 : null;
                if (cVar3 == null) {
                    break;
                }
                i2++;
            }
            if (i3 != i2) {
                return false;
            }
            c cVar4 = this;
            while (true) {
                g gVar = cVar4.f341c;
                if (!a0.h.a(cVar.f(gVar.getKey()), gVar)) {
                    z2 = false;
                    break;
                }
                i iVar3 = cVar4.f340b;
                if (!(iVar3 instanceof c)) {
                    a0.h.c(iVar3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                    g gVar2 = (g) iVar3;
                    z2 = a0.h.a(cVar.f(gVar2.getKey()), gVar2);
                    break;
                }
                cVar4 = (c) iVar3;
            }
            if (!z2) {
                return false;
            }
        }
        return true;
    }

    @Override // S.i
    public final g f(h hVar) {
        a0.h.e(hVar, "key");
        c cVar = this;
        while (true) {
            g f2 = cVar.f341c.f(hVar);
            if (f2 != null) {
                return f2;
            }
            i iVar = cVar.f340b;
            if (!(iVar instanceof c)) {
                return iVar.f(hVar);
            }
            cVar = (c) iVar;
        }
    }

    @Override // S.i
    public final Object h(Object obj, p pVar) {
        return pVar.d(this.f340b.h(obj, pVar), this.f341c);
    }

    public final int hashCode() {
        return this.f341c.hashCode() + this.f340b.hashCode();
    }

    public final String toString() {
        return "[" + ((String) h("", new b(0))) + ']';
    }
}
