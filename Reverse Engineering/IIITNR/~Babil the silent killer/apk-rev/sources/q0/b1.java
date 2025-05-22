package q0;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final class b1 extends a1 {

    /* renamed from: f, reason: collision with root package name */
    private final Executor f996f;

    public b1(Executor executor) {
        this.f996f = executor;
        kotlinx.coroutines.internal.e.a(r());
    }

    private final void p(c0.g gVar, RejectedExecutionException rejectedExecutionException) {
        n1.c(gVar, z0.a("The task was rejected", rejectedExecutionException));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor r2 = r();
        ExecutorService executorService = r2 instanceof ExecutorService ? (ExecutorService) r2 : null;
        if (executorService == null) {
            return;
        }
        executorService.shutdown();
    }

    public boolean equals(Object obj) {
        return (obj instanceof b1) && ((b1) obj).r() == r();
    }

    public int hashCode() {
        return System.identityHashCode(r());
    }

    @Override // q0.e0
    public void k(c0.g gVar, Runnable runnable) {
        try {
            Executor r2 = r();
            c.a();
            r2.execute(runnable);
        } catch (RejectedExecutionException e2) {
            c.a();
            p(gVar, e2);
            r0.b().k(gVar, runnable);
        }
    }

    public Executor r() {
        return this.f996f;
    }

    @Override // q0.e0
    public String toString() {
        return r().toString();
    }
}
