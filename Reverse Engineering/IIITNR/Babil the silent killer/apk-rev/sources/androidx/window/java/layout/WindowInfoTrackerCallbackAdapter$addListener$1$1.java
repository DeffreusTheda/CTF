package androidx.window.java.layout;

import a0.l;
import a0.q;
import c0.d;
import e.a;
import j0.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.k;
import q0.h0;
import t0.b;
import t0.c;

@f(c = "androidx.window.java.layout.WindowInfoTrackerCallbackAdapter$addListener$1$1", f = "WindowInfoTrackerCallbackAdapter.kt", l = {96}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class WindowInfoTrackerCallbackAdapter$addListener$1$1 extends k implements p<h0, d<? super q>, Object> {
    final /* synthetic */ a<T> $consumer;
    final /* synthetic */ b<T> $flow;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    WindowInfoTrackerCallbackAdapter$addListener$1$1(b<? extends T> bVar, a<T> aVar, d<? super WindowInfoTrackerCallbackAdapter$addListener$1$1> dVar) {
        super(2, dVar);
        this.$flow = bVar;
        this.$consumer = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d<q> create(Object obj, d<?> dVar) {
        return new WindowInfoTrackerCallbackAdapter$addListener$1$1(this.$flow, this.$consumer, dVar);
    }

    @Override // j0.p
    public final Object invoke(h0 h0Var, d<? super q> dVar) {
        return ((WindowInfoTrackerCallbackAdapter$addListener$1$1) create(h0Var, dVar)).invokeSuspend(q.f22a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object c2;
        c2 = d0.d.c();
        int i2 = this.label;
        if (i2 == 0) {
            l.b(obj);
            b<T> bVar = this.$flow;
            final a<T> aVar = this.$consumer;
            Object obj2 = new c<T>() { // from class: androidx.window.java.layout.WindowInfoTrackerCallbackAdapter$addListener$1$1$invokeSuspend$$inlined$collect$1
                @Override // t0.c
                public Object emit(T t2, d<? super q> dVar) {
                    a.this.accept(t2);
                    return q.f22a;
                }
            };
            this.label = 1;
            if (bVar.a(obj2, this) == c2) {
                return c2;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.b(obj);
        }
        return q.f22a;
    }
}
