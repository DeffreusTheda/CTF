package androidx.lifecycle;

import android.os.Looper;
import c.C0019a;
import d.C0020a;
import d.C0022c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class n extends h {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f410a;

    /* renamed from: b, reason: collision with root package name */
    public C0020a f411b;

    /* renamed from: c, reason: collision with root package name */
    public g f412c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakReference f413d;

    /* renamed from: e, reason: collision with root package name */
    public int f414e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f415f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f416g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f417h;

    /* renamed from: i, reason: collision with root package name */
    public final k0.g f418i;

    public n(l lVar) {
        new AtomicReference();
        this.f410a = true;
        this.f411b = new C0020a();
        g gVar = g.f402c;
        this.f412c = gVar;
        this.f417h = new ArrayList();
        this.f413d = new WeakReference(lVar);
        this.f418i = new k0.g(gVar);
    }

    public final g a(io.flutter.embedding.engine.renderer.b bVar) {
        HashMap hashMap = this.f411b.f448f;
        C0022c c0022c = hashMap.containsKey(bVar) ? ((C0022c) hashMap.get(bVar)).f455d : null;
        g gVar = c0022c != null ? c0022c.f453b.f408a : null;
        ArrayList arrayList = this.f417h;
        g gVar2 = arrayList.isEmpty() ? null : (g) arrayList.get(arrayList.size() - 1);
        g gVar3 = this.f412c;
        a0.h.e(gVar3, "state1");
        if (gVar == null || gVar.compareTo(gVar3) >= 0) {
            gVar = gVar3;
        }
        return (gVar2 == null || gVar2.compareTo(gVar) >= 0) ? gVar : gVar2;
    }

    public final void b(String str) {
        C0019a c0019a;
        if (this.f410a) {
            if (C0019a.f441f != null) {
                c0019a = C0019a.f441f;
            } else {
                synchronized (C0019a.class) {
                    try {
                        if (C0019a.f441f == null) {
                            C0019a.f441f = new C0019a(0);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                c0019a = C0019a.f441f;
            }
            ((C0019a) c0019a.f442e).getClass();
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                return;
            }
            throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
        }
    }

    public final void c(f fVar) {
        a0.h.e(fVar, "event");
        b("handleLifecycleEvent");
        g a2 = fVar.a();
        g gVar = this.f412c;
        if (gVar == a2) {
            return;
        }
        g gVar2 = g.f402c;
        g gVar3 = g.f401b;
        if (gVar == gVar2 && a2 == gVar3) {
            throw new IllegalStateException(("no event down from " + this.f412c + " in component " + this.f413d.get()).toString());
        }
        this.f412c = a2;
        if (this.f415f || this.f414e != 0) {
            this.f416g = true;
            return;
        }
        this.f415f = true;
        d();
        this.f415f = false;
        if (this.f412c == gVar3) {
            this.f411b = new C0020a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002c, code lost:
    
        r7.f416g = false;
        r7.f418i.d(r7.f412c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.n.d():void");
    }
}
