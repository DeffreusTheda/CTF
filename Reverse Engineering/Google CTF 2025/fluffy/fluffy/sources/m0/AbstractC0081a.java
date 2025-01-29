package m0;

import D.AbstractC0009j;
import h0.AbstractC0056p;
import h0.AbstractC0059t;
import h0.C0051k;
import h0.C0052l;
import h0.C0057q;
import h0.D;
import h0.K;
import h0.T;
import h0.Z;
import h0.a0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: m0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0081a {

    /* renamed from: c, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f991c;

    /* renamed from: d, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f992d;

    /* renamed from: a, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f989a = new io.flutter.plugin.platform.i(1, "NO_DECISION");

    /* renamed from: b, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f990b = new io.flutter.plugin.platform.i(1, "CLOSED");

    /* renamed from: e, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f993e = new io.flutter.plugin.platform.i(1, "CONDITION_FALSE");

    /* renamed from: f, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f994f = new io.flutter.plugin.platform.i(1, "NO_THREAD_ELEMENTS");

    static {
        int i2 = 1;
        f991c = new io.flutter.plugin.platform.i(i2, "UNDEFINED");
        f992d = new io.flutter.plugin.platform.i(i2, "REUSABLE_CLAIMED");
    }

    public static final void a(Z.l lVar, Object obj, S.i iVar) {
        B.c b2 = b(lVar, obj, null);
        if (b2 != null) {
            AbstractC0059t.c(iVar, b2);
        }
    }

    public static final B.c b(Z.l lVar, Object obj, B.c cVar) {
        try {
            lVar.h(obj);
        } catch (Throwable th) {
            if (cVar == null || cVar.getCause() == th) {
                return new B.c("Exception in undelivered element handler for " + obj, th);
            }
            a.a.a(cVar, th);
        }
        return cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, m0.v] */
    /* JADX WARN: Type inference failed for: r3v4, types: [m0.v] */
    public static final Object c(long j2, j0.k kVar) {
        j0.d dVar = j0.d.f885j;
        while (true) {
            long j3 = kVar.f1034c;
            if (j3 >= j2 && !kVar.c()) {
                return kVar;
            }
            Object obj = d.f997a.get(kVar);
            io.flutter.plugin.platform.i iVar = f990b;
            if (obj == iVar) {
                return iVar;
            }
            ?? r3 = (v) ((d) obj);
            if (r3 != 0) {
                kVar = r3;
            } else {
                ?? r1 = (v) dVar.d(Long.valueOf(j3 + 1), kVar);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d.f997a;
                    if (atomicReferenceFieldUpdater.compareAndSet(kVar, null, r1)) {
                        if (kVar.c()) {
                            kVar.d();
                        }
                        kVar = r1;
                    } else if (atomicReferenceFieldUpdater.get(kVar) != null) {
                        break;
                    }
                }
            }
        }
    }

    public static final v d(Object obj) {
        if (obj == f990b) {
            throw new IllegalStateException("Does not contain segment");
        }
        a0.h.c(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (v) obj;
    }

    public static final void e(S.i iVar, Throwable th) {
        Throwable runtimeException;
        Iterator it = f.f1000a.iterator();
        while (it.hasNext()) {
            try {
                ((i0.b) it.next()).c(iVar, th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    a.a.a(runtimeException, th);
                }
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, runtimeException);
            }
        }
        try {
            a.a.a(th, new g(iVar));
        } catch (Throwable unused) {
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }

    public static final boolean f(Object obj) {
        return obj == f990b;
    }

    public static final Object g(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static final void h(S.i iVar, Object obj) {
        if (obj == f994f) {
            return;
        }
        if (!(obj instanceof A)) {
            a0.h.c(iVar.h(null, y.f1038e), "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            throw new ClassCastException();
        }
        A a2 = (A) obj;
        Z[] zArr = a2.f988b;
        int length = zArr.length - 1;
        if (length < 0) {
            return;
        }
        Z z2 = zArr[length];
        a0.h.b(null);
        Object obj2 = a2.f987a[length];
        throw null;
    }

    public static final void i(S.d dVar, Object obj, Z.l lVar) {
        if (!(dVar instanceof h)) {
            dVar.c(obj);
            return;
        }
        h hVar = (h) dVar;
        Throwable a2 = Q.d.a(obj);
        Object c0052l = a2 == null ? lVar != null ? new C0052l(obj, lVar) : obj : new C0051k(a2, false);
        U.b bVar = hVar.f1004f;
        bVar.i();
        AbstractC0056p abstractC0056p = hVar.f1003e;
        boolean g2 = abstractC0056p.g();
        S.i iVar = bVar.f348c;
        if (g2) {
            hVar.f1005g = c0052l;
            hVar.f588d = 1;
            a0.h.b(iVar);
            abstractC0056p.c(iVar, hVar);
            return;
        }
        D a3 = a0.a();
        if (a3.f519d >= 4294967296L) {
            hVar.f1005g = c0052l;
            hVar.f588d = 1;
            R.c cVar = a3.f521f;
            if (cVar == null) {
                cVar = new R.c();
                a3.f521f = cVar;
            }
            cVar.addLast(hVar);
            return;
        }
        a3.k(true);
        try {
            a0.h.b(iVar);
            K k2 = (K) iVar.f(C0057q.f575c);
            if (k2 == null || k2.b()) {
                Object obj2 = hVar.f1006h;
                a0.h.b(iVar);
                Object m = m(iVar, obj2);
                if (m != f994f) {
                    AbstractC0059t.i(bVar, iVar);
                }
                try {
                    bVar.c(obj);
                } finally {
                    h(iVar, m);
                }
            } else {
                CancellationException v2 = ((T) k2).v();
                hVar.b(c0052l, v2);
                hVar.c(a.a.f(v2));
            }
            while (a3.l()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long j(java.lang.String r23, long r24, long r26, long r28) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m0.AbstractC0081a.j(java.lang.String, long, long, long):long");
    }

    public static int k(String str, int i2, int i3, int i4, int i5) {
        if ((i5 & 4) != 0) {
            i3 = 1;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return (int) j(str, i2, i3, i4);
    }

    public static final Object l(S.i iVar) {
        Object h2 = iVar.h(0, y.f1037d);
        a0.h.b(h2);
        return h2;
    }

    public static final Object m(S.i iVar, Object obj) {
        if (obj == null) {
            obj = l(iVar);
        }
        if (obj == 0) {
            return f994f;
        }
        if (obj instanceof Integer) {
            return iVar.h(new A(((Number) obj).intValue(), iVar), y.f1039f);
        }
        AbstractC0009j.e(obj);
        throw null;
    }
}
