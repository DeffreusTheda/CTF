package h0;

import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* loaded from: classes.dex */
public final class F extends E implements InterfaceC0062w {

    /* renamed from: d, reason: collision with root package name */
    public final Executor f522d;

    public F(Executor executor) {
        Method method;
        this.f522d = executor;
        Method method2 = m0.c.f996a;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = executor instanceof ScheduledThreadPoolExecutor ? (ScheduledThreadPoolExecutor) executor : null;
            if (scheduledThreadPoolExecutor != null && (method = m0.c.f996a) != null) {
                method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // h0.AbstractC0056p
    public final void c(S.i iVar, Runnable runnable) {
        try {
            this.f522d.execute(runnable);
        } catch (RejectedExecutionException e2) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e2);
            K k2 = (K) iVar.f(C0057q.f575c);
            if (k2 != null) {
                k2.a(cancellationException);
            }
            AbstractC0064y.f590b.c(iVar, runnable);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.f522d;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof F) && ((F) obj).f522d == this.f522d;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f522d);
    }

    @Override // h0.AbstractC0056p
    public final String toString() {
        return this.f522d.toString();
    }
}
