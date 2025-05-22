package kotlin.coroutines.jvm.internal;

import c0.g;

/* loaded from: classes.dex */
public abstract class d extends a {
    private final c0.g _context;
    private transient c0.d<Object> intercepted;

    public d(c0.d<Object> dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }

    public d(c0.d<Object> dVar, c0.g gVar) {
        super(dVar);
        this._context = gVar;
    }

    @Override // c0.d
    public c0.g getContext() {
        c0.g gVar = this._context;
        kotlin.jvm.internal.i.b(gVar);
        return gVar;
    }

    public final c0.d<Object> intercepted() {
        c0.d<Object> dVar = this.intercepted;
        if (dVar == null) {
            c0.e eVar = (c0.e) getContext().get(c0.e.f141a);
            if (eVar == null || (dVar = eVar.i(this)) == null) {
                dVar = this;
            }
            this.intercepted = dVar;
        }
        return dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    protected void releaseIntercepted() {
        c0.d<?> dVar = this.intercepted;
        if (dVar != null && dVar != this) {
            g.b bVar = getContext().get(c0.e.f141a);
            kotlin.jvm.internal.i.b(bVar);
            ((c0.e) bVar).d(dVar);
        }
        this.intercepted = c.f773d;
    }
}
