package r0;

import a0.q;
import android.os.Handler;
import android.os.Looper;
import c0.g;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.i;
import q0.n1;
import q0.r0;

/* loaded from: classes.dex */
public final class a extends b {
    private volatile a _immediate;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f1088e;

    /* renamed from: f, reason: collision with root package name */
    private final String f1089f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f1090g;

    /* renamed from: h, reason: collision with root package name */
    private final a f1091h;

    public a(Handler handler, String str) {
        this(handler, str, false);
    }

    public /* synthetic */ a(Handler handler, String str, int i2, e eVar) {
        this(handler, (i2 & 2) != 0 ? null : str);
    }

    private a(Handler handler, String str, boolean z2) {
        super(null);
        this.f1088e = handler;
        this.f1089f = str;
        this.f1090g = z2;
        this._immediate = z2 ? this : null;
        a aVar = this._immediate;
        if (aVar == null) {
            aVar = new a(handler, str, true);
            this._immediate = aVar;
            q qVar = q.f22a;
        }
        this.f1091h = aVar;
    }

    private final void s(g gVar, Runnable runnable) {
        n1.c(gVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        r0.b().k(gVar, runnable);
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((a) obj).f1088e == this.f1088e;
    }

    public int hashCode() {
        return System.identityHashCode(this.f1088e);
    }

    @Override // q0.e0
    public void k(g gVar, Runnable runnable) {
        if (this.f1088e.post(runnable)) {
            return;
        }
        s(gVar, runnable);
    }

    @Override // q0.e0
    public boolean l(g gVar) {
        return (this.f1090g && i.a(Looper.myLooper(), this.f1088e.getLooper())) ? false : true;
    }

    @Override // q0.t1
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public a p() {
        return this.f1091h;
    }

    @Override // q0.t1, q0.e0
    public String toString() {
        String r2 = r();
        if (r2 != null) {
            return r2;
        }
        String str = this.f1089f;
        if (str == null) {
            str = this.f1088e.toString();
        }
        return this.f1090g ? i.j(str, ".immediate") : str;
    }
}
