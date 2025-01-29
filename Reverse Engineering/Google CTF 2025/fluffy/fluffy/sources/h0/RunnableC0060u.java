package h0;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* renamed from: h0.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0060u extends C implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: j, reason: collision with root package name */
    public static final RunnableC0060u f585j;

    /* renamed from: k, reason: collision with root package name */
    public static final long f586k;

    static {
        Long l2;
        RunnableC0060u runnableC0060u = new RunnableC0060u();
        f585j = runnableC0060u;
        runnableC0060u.k(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l2 = 1000L;
        }
        f586k = timeUnit.toNanos(l2.longValue());
    }

    @Override // h0.D
    public final Thread j() {
        Thread thread = _thread;
        if (thread == null) {
            synchronized (this) {
                thread = _thread;
                if (thread == null) {
                    thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                    _thread = thread;
                    thread.setDaemon(true);
                    thread.start();
                }
            }
        }
        return thread;
    }

    @Override // h0.C, h0.D
    public final void m() {
        debugStatus = 4;
        super.m();
    }

    @Override // h0.C
    public final void n(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.n(runnable);
    }

    public final synchronized void r() {
        int i2 = debugStatus;
        if (i2 == 2 || i2 == 3) {
            debugStatus = 3;
            C.f516g.set(this, null);
            C.f517h.set(this, null);
            notifyAll();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean p2;
        a0.f546a.set(this);
        try {
            synchronized (this) {
                int i2 = debugStatus;
                if (i2 == 2 || i2 == 3) {
                    if (p2) {
                        return;
                    } else {
                        return;
                    }
                }
                debugStatus = 1;
                notifyAll();
                long j2 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long q2 = q();
                    if (q2 == Long.MAX_VALUE) {
                        long nanoTime = System.nanoTime();
                        if (j2 == Long.MAX_VALUE) {
                            j2 = f586k + nanoTime;
                        }
                        long j3 = j2 - nanoTime;
                        if (j3 <= 0) {
                            _thread = null;
                            r();
                            if (p()) {
                                return;
                            }
                            j();
                            return;
                        }
                        if (q2 > j3) {
                            q2 = j3;
                        }
                    } else {
                        j2 = Long.MAX_VALUE;
                    }
                    if (q2 > 0) {
                        int i3 = debugStatus;
                        if (i3 == 2 || i3 == 3) {
                            _thread = null;
                            r();
                            if (p()) {
                                return;
                            }
                            j();
                            return;
                        }
                        LockSupport.parkNanos(this, q2);
                    }
                }
            }
        } finally {
            _thread = null;
            r();
            if (!p()) {
                j();
            }
        }
    }
}
