package D;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Trace;
import android.util.Log;
import android.util.SparseArray;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: D.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0008i {

    /* renamed from: a, reason: collision with root package name */
    public AbstractActivityC0005f f64a;

    /* renamed from: b, reason: collision with root package name */
    public E.c f65b;

    /* renamed from: c, reason: collision with root package name */
    public y f66c;

    /* renamed from: d, reason: collision with root package name */
    public io.flutter.plugin.platform.e f67d;

    /* renamed from: e, reason: collision with root package name */
    public ViewTreeObserverOnPreDrawListenerC0007h f68e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f69f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f70g;

    /* renamed from: i, reason: collision with root package name */
    public boolean f72i;

    /* renamed from: j, reason: collision with root package name */
    public Integer f73j;

    /* renamed from: k, reason: collision with root package name */
    public final C0006g f74k = new C0006g(0, this);

    /* renamed from: h, reason: collision with root package name */
    public boolean f71h = false;

    public C0008i(AbstractActivityC0005f abstractActivityC0005f) {
        this.f64a = abstractActivityC0005f;
    }

    public final void a(E.g gVar) {
        String b2 = this.f64a.b();
        if (b2 == null || b2.isEmpty()) {
            b2 = ((H.f) B.a.j().f4c).f219d.f206b;
        }
        F.a aVar = new F.a(b2, this.f64a.e());
        String f2 = this.f64a.f();
        if (f2 == null) {
            AbstractActivityC0005f abstractActivityC0005f = this.f64a;
            abstractActivityC0005f.getClass();
            f2 = d(abstractActivityC0005f.getIntent());
            if (f2 == null) {
                f2 = "/";
            }
        }
        gVar.f160b = aVar;
        gVar.f161c = f2;
        gVar.f162d = (List) this.f64a.getIntent().getSerializableExtra("dart_entrypoint_args");
    }

    public final void b() {
        if (this.f64a.i()) {
            throw new AssertionError("The internal FlutterEngine created by " + this.f64a + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
        }
        AbstractActivityC0005f abstractActivityC0005f = this.f64a;
        abstractActivityC0005f.getClass();
        Log.w("FlutterActivity", "FlutterActivity " + abstractActivityC0005f + " connection to the engine " + abstractActivityC0005f.f57b.f65b + " evicted by another attaching activity");
        C0008i c0008i = abstractActivityC0005f.f57b;
        if (c0008i != null) {
            c0008i.e();
            abstractActivityC0005f.f57b.f();
        }
    }

    public final void c() {
        if (this.f64a == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }

    public final String d(Intent intent) {
        boolean z2;
        Uri data;
        AbstractActivityC0005f abstractActivityC0005f = this.f64a;
        abstractActivityC0005f.getClass();
        try {
            Bundle g2 = abstractActivityC0005f.g();
            z2 = (g2 == null || !g2.containsKey("flutter_deeplinking_enabled")) ? true : g2.getBoolean("flutter_deeplinking_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            z2 = false;
        }
        if (!z2 || (data = intent.getData()) == null) {
            return null;
        }
        return data.toString();
    }

    public final void e() {
        c();
        if (this.f68e != null) {
            this.f66c.getViewTreeObserver().removeOnPreDrawListener(this.f68e);
            this.f68e = null;
        }
        y yVar = this.f66c;
        if (yVar != null) {
            yVar.a();
            y yVar2 = this.f66c;
            yVar2.f105f.remove(this.f74k);
        }
    }

    public final void f() {
        if (this.f72i) {
            c();
            this.f64a.getClass();
            this.f64a.getClass();
            AbstractActivityC0005f abstractActivityC0005f = this.f64a;
            abstractActivityC0005f.getClass();
            if (abstractActivityC0005f.isChangingConfigurations()) {
                E.e eVar = this.f65b.f128d;
                if (eVar.e()) {
                    P.a.b("FlutterEngineConnectionRegistry#detachFromActivityForConfigChanges");
                    try {
                        eVar.f156f = true;
                        for (O.a aVar : eVar.f153c.values()) {
                            aVar.f317b.f147c.remove(aVar);
                            aVar.f317b = null;
                        }
                        eVar.c();
                        Trace.endSection();
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    Log.e("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
                }
            } else {
                this.f65b.f128d.b();
            }
            io.flutter.plugin.platform.e eVar2 = this.f67d;
            if (eVar2 != null) {
                eVar2.f700b.f5d = null;
                this.f67d = null;
            }
            this.f64a.getClass();
            E.c cVar = this.f65b;
            if (cVar != null) {
                K.d dVar = cVar.f131g;
                dVar.a(1, dVar.f227c);
            }
            if (this.f64a.i()) {
                E.c cVar2 = this.f65b;
                Iterator it = cVar2.f143t.iterator();
                while (it.hasNext()) {
                    ((E.b) it.next()).b();
                }
                E.e eVar3 = cVar2.f128d;
                eVar3.d();
                HashMap hashMap = eVar3.f151a;
                Iterator it2 = new HashSet(hashMap.keySet()).iterator();
                while (it2.hasNext()) {
                    Class cls = (Class) it2.next();
                    O.a aVar2 = (O.a) hashMap.get(cls);
                    if (aVar2 != null) {
                        P.a.b("FlutterEngineConnectionRegistry#remove ".concat(cls.getSimpleName()));
                        try {
                            if (eVar3.e()) {
                                aVar2.f317b.f147c.remove(aVar2);
                                aVar2.f317b = null;
                            }
                            eVar3.f153c.remove(cls);
                            hashMap.remove(cls);
                            Trace.endSection();
                        } finally {
                            try {
                                Trace.endSection();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                    }
                }
                hashMap.clear();
                while (true) {
                    io.flutter.plugin.platform.k kVar = cVar2.f141r;
                    SparseArray sparseArray = kVar.f727j;
                    if (sparseArray.size() <= 0) {
                        break;
                    }
                    kVar.f736t.h(sparseArray.keyAt(0));
                }
                while (true) {
                    io.flutter.plugin.platform.j jVar = cVar2.f142s;
                    SparseArray sparseArray2 = jVar.f712g;
                    if (sparseArray2.size() <= 0) {
                        break;
                    }
                    jVar.m.c(sparseArray2.keyAt(0));
                }
                cVar2.f127c.f173b.setPlatformMessageHandler(null);
                FlutterJNI flutterJNI = cVar2.f125a;
                flutterJNI.removeEngineLifecycleListener(cVar2.f144v);
                flutterJNI.setDeferredComponentManager(null);
                flutterJNI.detachFromNativeAndReleaseResources();
                B.a.j().getClass();
                E.c.f124x.remove(Long.valueOf(cVar2.u));
                if (this.f64a.d() != null) {
                    if (E.i.f167c == null) {
                        E.i.f167c = new E.i(1);
                    }
                    E.i iVar = E.i.f167c;
                    iVar.f168a.remove(this.f64a.d());
                }
                this.f65b = null;
            }
            this.f72i = false;
        }
    }
}
