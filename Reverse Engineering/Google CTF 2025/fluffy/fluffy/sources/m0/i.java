package m0;

import h0.AbstractC0059t;

/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public Runnable f1007b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f1008c;

    public i(j jVar, Runnable runnable) {
        this.f1008c = jVar;
        this.f1007b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar;
        int i2 = 0;
        do {
            try {
                this.f1007b.run();
            } catch (Throwable th) {
                AbstractC0059t.c(S.j.f343b, th);
            }
            jVar = this.f1008c;
            Runnable i3 = jVar.i();
            if (i3 == null) {
                return;
            }
            this.f1007b = i3;
            i2++;
        } while (i2 < 16);
        n0.k kVar = jVar.f1010d;
        kVar.getClass();
        kVar.c(jVar, this);
    }
}
