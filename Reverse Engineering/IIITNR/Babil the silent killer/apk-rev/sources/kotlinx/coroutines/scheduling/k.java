package kotlinx.coroutines.scheduling;

import q0.l0;

/* loaded from: classes.dex */
public final class k extends i {

    /* renamed from: f, reason: collision with root package name */
    public final Runnable f901f;

    public k(Runnable runnable, long j2, j jVar) {
        super(j2, jVar);
        this.f901f = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f901f.run();
        } finally {
            this.f900e.g();
        }
    }

    public String toString() {
        return "Task[" + l0.a(this.f901f) + '@' + l0.b(this.f901f) + ", " + this.f899d + ", " + this.f900e + ']';
    }
}
