package kotlin.coroutines.jvm.internal;

import a0.k;
import a0.l;
import a0.q;
import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class a implements c0.d<Object>, e, Serializable {
    private final c0.d<Object> completion;

    public a(c0.d<Object> dVar) {
        this.completion = dVar;
    }

    public c0.d<q> create(c0.d<?> completion) {
        kotlin.jvm.internal.i.e(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public c0.d<q> create(Object obj, c0.d<?> completion) {
        kotlin.jvm.internal.i.e(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public e getCallerFrame() {
        c0.d<Object> dVar = this.completion;
        if (dVar instanceof e) {
            return (e) dVar;
        }
        return null;
    }

    public final c0.d<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return g.d(this);
    }

    protected abstract Object invokeSuspend(Object obj);

    protected void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // c0.d
    public final void resumeWith(Object obj) {
        Object invokeSuspend;
        Object c2;
        c0.d dVar = this;
        while (true) {
            h.b(dVar);
            a aVar = (a) dVar;
            c0.d dVar2 = aVar.completion;
            kotlin.jvm.internal.i.b(dVar2);
            try {
                invokeSuspend = aVar.invokeSuspend(obj);
                c2 = d0.d.c();
            } catch (Throwable th) {
                k.a aVar2 = a0.k.f16d;
                obj = a0.k.a(l.a(th));
            }
            if (invokeSuspend == c2) {
                return;
            }
            k.a aVar3 = a0.k.f16d;
            obj = a0.k.a(invokeSuspend);
            aVar.releaseIntercepted();
            if (!(dVar2 instanceof a)) {
                dVar2.resumeWith(obj);
                return;
            }
            dVar = dVar2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }
}
