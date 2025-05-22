package q0;

/* loaded from: classes.dex */
final class x {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1077a;

    /* renamed from: b, reason: collision with root package name */
    public final i f1078b;

    /* renamed from: c, reason: collision with root package name */
    public final j0.l<Throwable, a0.q> f1079c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1080d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f1081e;

    /* JADX WARN: Multi-variable type inference failed */
    public x(Object obj, i iVar, j0.l<? super Throwable, a0.q> lVar, Object obj2, Throwable th) {
        this.f1077a = obj;
        this.f1078b = iVar;
        this.f1079c = lVar;
        this.f1080d = obj2;
        this.f1081e = th;
    }

    public /* synthetic */ x(Object obj, i iVar, j0.l lVar, Object obj2, Throwable th, int i2, kotlin.jvm.internal.e eVar) {
        this(obj, (i2 & 2) != 0 ? null : iVar, (i2 & 4) != 0 ? null : lVar, (i2 & 8) != 0 ? null : obj2, (i2 & 16) != 0 ? null : th);
    }

    public static /* synthetic */ x b(x xVar, Object obj, i iVar, j0.l lVar, Object obj2, Throwable th, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj = xVar.f1077a;
        }
        if ((i2 & 2) != 0) {
            iVar = xVar.f1078b;
        }
        i iVar2 = iVar;
        if ((i2 & 4) != 0) {
            lVar = xVar.f1079c;
        }
        j0.l lVar2 = lVar;
        if ((i2 & 8) != 0) {
            obj2 = xVar.f1080d;
        }
        Object obj4 = obj2;
        if ((i2 & 16) != 0) {
            th = xVar.f1081e;
        }
        return xVar.a(obj, iVar2, lVar2, obj4, th);
    }

    public final x a(Object obj, i iVar, j0.l<? super Throwable, a0.q> lVar, Object obj2, Throwable th) {
        return new x(obj, iVar, lVar, obj2, th);
    }

    public final boolean c() {
        return this.f1081e != null;
    }

    public final void d(l<?> lVar, Throwable th) {
        i iVar = this.f1078b;
        if (iVar != null) {
            lVar.m(iVar, th);
        }
        j0.l<Throwable, a0.q> lVar2 = this.f1079c;
        if (lVar2 == null) {
            return;
        }
        lVar.n(lVar2, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return kotlin.jvm.internal.i.a(this.f1077a, xVar.f1077a) && kotlin.jvm.internal.i.a(this.f1078b, xVar.f1078b) && kotlin.jvm.internal.i.a(this.f1079c, xVar.f1079c) && kotlin.jvm.internal.i.a(this.f1080d, xVar.f1080d) && kotlin.jvm.internal.i.a(this.f1081e, xVar.f1081e);
    }

    public int hashCode() {
        Object obj = this.f1077a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        i iVar = this.f1078b;
        int hashCode2 = (hashCode + (iVar == null ? 0 : iVar.hashCode())) * 31;
        j0.l<Throwable, a0.q> lVar = this.f1079c;
        int hashCode3 = (hashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f1080d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f1081e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f1077a + ", cancelHandler=" + this.f1078b + ", onCancellation=" + this.f1079c + ", idempotentResume=" + this.f1080d + ", cancelCause=" + this.f1081e + ')';
    }
}
