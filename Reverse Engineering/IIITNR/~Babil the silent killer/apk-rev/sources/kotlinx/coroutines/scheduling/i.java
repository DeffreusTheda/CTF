package kotlinx.coroutines.scheduling;

/* loaded from: classes.dex */
public abstract class i implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    public long f899d;

    /* renamed from: e, reason: collision with root package name */
    public j f900e;

    public i() {
        this(0L, g.f897d);
    }

    public i(long j2, j jVar) {
        this.f899d = j2;
        this.f900e = jVar;
    }
}
