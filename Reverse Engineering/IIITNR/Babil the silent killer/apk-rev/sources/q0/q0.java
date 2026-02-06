package q0;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class q0 implements Executor {

    /* renamed from: d, reason: collision with root package name */
    public final e0 f1038d;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f1038d.k(c0.h.f144d, runnable);
    }

    public String toString() {
        return this.f1038d.toString();
    }
}
