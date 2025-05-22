package t0;

import a0.q;
import j0.p;

/* loaded from: classes.dex */
final class f<T> extends a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final p<c<? super T>, c0.d<? super q>, Object> f1134a;

    /* JADX WARN: Multi-variable type inference failed */
    public f(p<? super c<? super T>, ? super c0.d<? super q>, ? extends Object> pVar) {
        this.f1134a = pVar;
    }

    @Override // t0.a
    public Object b(c<? super T> cVar, c0.d<? super q> dVar) {
        Object c2;
        Object invoke = this.f1134a.invoke(cVar, dVar);
        c2 = d0.d.c();
        return invoke == c2 ? invoke : q.f22a;
    }
}
