package n;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
