package q0;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes.dex */
public final class m0 extends v0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: j, reason: collision with root package name */
    public static final m0 f1030j;

    /* renamed from: k, reason: collision with root package name */
    private static final long f1031k;

    static {
        Long l2;
        m0 m0Var = new m0();
        f1030j = m0Var;
        u0.v(m0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l2 = 1000L;
        }
        f1031k = timeUnit.toNanos(l2.longValue());
    }

    private m0() {
    }

    private final synchronized void R() {
        if (T()) {
            debugStatus = 3;
            M();
            notifyAll();
        }
    }

    private final synchronized Thread S() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean T() {
        int i2 = debugStatus;
        return i2 == 2 || i2 == 3;
    }

    private final synchronized boolean U() {
        if (T()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    @Override // q0.w0
    protected Thread A() {
        Thread thread = _thread;
        return thread == null ? S() : thread;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean J;
        a2.f994a.c(this);
        c.a();
        try {
            if (!U()) {
                if (J) {
                    return;
                } else {
                    return;
                }
            }
            long j2 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long K = K();
                if (K == Long.MAX_VALUE) {
                    c.a();
                    long nanoTime = System.nanoTime();
                    if (j2 == Long.MAX_VALUE) {
                        j2 = f1031k + nanoTime;
                    }
                    long j3 = j2 - nanoTime;
                    if (j3 <= 0) {
                        _thread = null;
                        R();
                        c.a();
                        if (J()) {
                            return;
                        }
                        A();
                        return;
                    }
                    K = m0.f.d(K, j3);
                } else {
                    j2 = Long.MAX_VALUE;
                }
                if (K > 0) {
                    if (T()) {
                        _thread = null;
                        R();
                        c.a();
                        if (J()) {
                            return;
                        }
                        A();
                        return;
                    }
                    c.a();
                    LockSupport.parkNanos(this, K);
                }
            }
        } finally {
            _thread = null;
            R();
            c.a();
            if (!J()) {
                A();
            }
        }
    }
}
