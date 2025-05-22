package q0;

import java.util.concurrent.locks.LockSupport;
import q0.v0;

/* loaded from: classes.dex */
public abstract class w0 extends u0 {
    protected abstract Thread A();

    protected final void B(long j2, v0.a aVar) {
        m0.f1030j.N(j2, aVar);
    }

    protected final void C() {
        Thread A = A();
        if (Thread.currentThread() != A) {
            c.a();
            LockSupport.unpark(A);
        }
    }
}
