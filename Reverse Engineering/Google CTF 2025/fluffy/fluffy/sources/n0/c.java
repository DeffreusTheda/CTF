package n0;

import h0.AbstractC0056p;
import h0.E;
import java.util.concurrent.Executor;
import m0.AbstractC0081a;
import m0.x;

/* loaded from: classes.dex */
public final class c extends E implements Executor {

    /* renamed from: d, reason: collision with root package name */
    public static final c f1108d = new c();

    /* renamed from: e, reason: collision with root package name */
    public static final AbstractC0056p f1109e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [m0.j] */
    static {
        k kVar = k.f1124d;
        int i2 = x.f1036a;
        if (64 >= i2) {
            i2 = 64;
        }
        int k2 = AbstractC0081a.k("kotlinx.coroutines.io.parallelism", i2, 0, 0, 12);
        kVar.getClass();
        if (k2 < 1) {
            throw new IllegalArgumentException(("Expected positive parallelism level, but got " + k2).toString());
        }
        if (k2 < j.f1119d) {
            if (k2 < 1) {
                throw new IllegalArgumentException(("Expected positive parallelism level, but got " + k2).toString());
            }
            kVar = new m0.j(kVar, k2);
        }
        f1109e = kVar;
    }

    @Override // h0.AbstractC0056p
    public final void c(S.i iVar, Runnable runnable) {
        f1109e.c(iVar, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        c(S.j.f343b, runnable);
    }

    @Override // h0.AbstractC0056p
    public final String toString() {
        return "Dispatchers.IO";
    }
}
