package d;

import android.os.Handler;
import e.b;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d.a$a, reason: collision with other inner class name */
    private static class ExecutorC0005a implements Executor {

        /* renamed from: d, reason: collision with root package name */
        private final Handler f145d;

        ExecutorC0005a(Handler handler) {
            this.f145d = (Handler) b.a(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f145d.post((Runnable) b.a(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f145d + " is shutting down");
        }
    }

    public static Executor a(Handler handler) {
        return new ExecutorC0005a(handler);
    }
}
