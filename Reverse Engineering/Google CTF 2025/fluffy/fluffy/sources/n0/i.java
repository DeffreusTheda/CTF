package n0;

import D.H;
import h0.AbstractC0059t;

/* loaded from: classes.dex */
public final class i extends h {

    /* renamed from: d, reason: collision with root package name */
    public final Runnable f1115d;

    public i(Runnable runnable, long j2, H h2) {
        super(j2, h2);
        this.f1115d = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f1115d.run();
        } finally {
            this.f1114c.getClass();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.f1115d;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(AbstractC0059t.a(runnable));
        sb.append(", ");
        sb.append(this.f1113b);
        sb.append(", ");
        sb.append(this.f1114c);
        sb.append(']');
        return sb.toString();
    }
}
