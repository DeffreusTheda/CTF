package i0;

import S.i;
import a0.h;
import android.os.Handler;
import android.os.Looper;
import h0.AbstractC0056p;
import h0.AbstractC0064y;
import h0.C0057q;
import h0.InterfaceC0062w;
import h0.K;
import java.util.concurrent.CancellationException;
import m0.p;

/* loaded from: classes.dex */
public final class c extends AbstractC0056p implements InterfaceC0062w {
    private volatile c _immediate;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f591d;

    /* renamed from: e, reason: collision with root package name */
    public final String f592e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f593f;

    /* renamed from: g, reason: collision with root package name */
    public final c f594g;

    public c(Handler handler, String str, boolean z2) {
        this.f591d = handler;
        this.f592e = str;
        this.f593f = z2;
        this._immediate = z2 ? this : null;
        c cVar = this._immediate;
        if (cVar == null) {
            cVar = new c(handler, str, true);
            this._immediate = cVar;
        }
        this.f594g = cVar;
    }

    @Override // h0.AbstractC0056p
    public final void c(i iVar, Runnable runnable) {
        if (this.f591d.post(runnable)) {
            return;
        }
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        K k2 = (K) iVar.f(C0057q.f575c);
        if (k2 != null) {
            k2.a(cancellationException);
        }
        AbstractC0064y.f590b.c(iVar, runnable);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof c) && ((c) obj).f591d == this.f591d;
    }

    @Override // h0.AbstractC0056p
    public final boolean g() {
        return (this.f593f && h.a(Looper.myLooper(), this.f591d.getLooper())) ? false : true;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f591d);
    }

    @Override // h0.AbstractC0056p
    public final String toString() {
        c cVar;
        String str;
        n0.d dVar = AbstractC0064y.f589a;
        c cVar2 = p.f1027a;
        if (this == cVar2) {
            str = "Dispatchers.Main";
        } else {
            try {
                cVar = cVar2.f594g;
            } catch (UnsupportedOperationException unused) {
                cVar = null;
            }
            str = this == cVar ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String str2 = this.f592e;
        if (str2 == null) {
            str2 = this.f591d.toString();
        }
        if (!this.f593f) {
            return str2;
        }
        return str2 + ".immediate";
    }

    public c(Handler handler) {
        this(handler, null, false);
    }
}
