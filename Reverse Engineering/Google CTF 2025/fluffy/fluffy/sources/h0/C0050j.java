package h0;

import java.util.concurrent.CancellationException;

/* renamed from: h0.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0050j {

    /* renamed from: a, reason: collision with root package name */
    public final Object f559a;

    /* renamed from: b, reason: collision with root package name */
    public final Z.l f560b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f561c;

    /* renamed from: d, reason: collision with root package name */
    public final Throwable f562d;

    public C0050j(Object obj, Z.l lVar, Object obj2, Throwable th) {
        this.f559a = obj;
        this.f560b = lVar;
        this.f561c = obj2;
        this.f562d = th;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0050j)) {
            return false;
        }
        C0050j c0050j = (C0050j) obj;
        return a0.h.a(this.f559a, c0050j.f559a) && a0.h.a(null, null) && a0.h.a(this.f560b, c0050j.f560b) && a0.h.a(this.f561c, c0050j.f561c) && a0.h.a(this.f562d, c0050j.f562d);
    }

    public final int hashCode() {
        Object obj = this.f559a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 961;
        Z.l lVar = this.f560b;
        int hashCode2 = (hashCode + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f561c;
        int hashCode3 = (hashCode2 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f562d;
        return hashCode3 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f559a + ", cancelHandler=null, onCancellation=" + this.f560b + ", idempotentResume=" + this.f561c + ", cancelCause=" + this.f562d + ')';
    }

    public /* synthetic */ C0050j(Object obj, Z.l lVar, CancellationException cancellationException, int i2) {
        this(obj, (i2 & 4) != 0 ? null : lVar, (Object) null, (i2 & 16) != 0 ? null : cancellationException);
    }
}
