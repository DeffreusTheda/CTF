package kotlinx.coroutines.scheduling;

import java.util.concurrent.RejectedExecutionException;
import q0.a1;
import q0.m0;

/* loaded from: classes.dex */
public class c extends a1 {

    /* renamed from: f, reason: collision with root package name */
    private final int f885f;

    /* renamed from: g, reason: collision with root package name */
    private final int f886g;

    /* renamed from: h, reason: collision with root package name */
    private final long f887h;

    /* renamed from: i, reason: collision with root package name */
    private final String f888i;

    /* renamed from: j, reason: collision with root package name */
    private a f889j;

    public c(int i2, int i3, long j2, String str) {
        this.f885f = i2;
        this.f886g = i3;
        this.f887h = j2;
        this.f888i = str;
        this.f889j = p();
    }

    public c(int i2, int i3, String str) {
        this(i2, i3, l.f906e, str);
    }

    public /* synthetic */ c(int i2, int i3, String str, int i4, kotlin.jvm.internal.e eVar) {
        this((i4 & 1) != 0 ? l.f904c : i2, (i4 & 2) != 0 ? l.f905d : i3, (i4 & 4) != 0 ? "DefaultDispatcher" : str);
    }

    private final a p() {
        return new a(this.f885f, this.f886g, this.f887h, this.f888i);
    }

    @Override // q0.e0
    public void k(c0.g gVar, Runnable runnable) {
        try {
            a.f(this.f889j, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            m0.f1030j.k(gVar, runnable);
        }
    }

    public final void r(Runnable runnable, j jVar, boolean z2) {
        try {
            this.f889j.e(runnable, jVar, z2);
        } catch (RejectedExecutionException unused) {
            m0.f1030j.G(this.f889j.c(runnable, jVar));
        }
    }
}
