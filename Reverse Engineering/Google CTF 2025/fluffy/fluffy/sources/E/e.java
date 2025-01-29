package E;

import D.AbstractActivityC0005f;
import D.C0008i;
import D.v;
import android.os.Trace;
import android.util.Log;
import android.view.Surface;
import androidx.lifecycle.n;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public final c f152b;

    /* renamed from: d, reason: collision with root package name */
    public C0008i f154d;

    /* renamed from: e, reason: collision with root package name */
    public d f155e;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f151a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f153c = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public boolean f156f = false;

    public e(c cVar) {
        new HashMap();
        new HashMap();
        new HashMap();
        this.f152b = cVar;
        F.b bVar = cVar.f127c;
        i iVar = cVar.f141r.f718a;
    }

    public final void a(AbstractActivityC0005f abstractActivityC0005f, n nVar) {
        this.f155e = new d(abstractActivityC0005f, nVar);
        if (abstractActivityC0005f.getIntent() != null) {
            abstractActivityC0005f.getIntent().getBooleanExtra("enable-software-rendering", false);
        }
        c cVar = this.f152b;
        io.flutter.plugin.platform.k kVar = cVar.f141r;
        kVar.getClass();
        if (kVar.f719b != null) {
            throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
        }
        kVar.f719b = abstractActivityC0005f;
        kVar.f721d = cVar.f126b;
        F.b bVar = cVar.f127c;
        v vVar = new v(bVar, 15);
        kVar.f723f = vVar;
        vVar.f94c = kVar.f736t;
        io.flutter.plugin.platform.j jVar = cVar.f142s;
        if (jVar.f707b != null) {
            throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
        }
        jVar.f707b = abstractActivityC0005f;
        v vVar2 = new v(bVar, 14);
        jVar.f710e = vVar2;
        vVar2.f94c = jVar.m;
        for (O.a aVar : this.f153c.values()) {
            if (this.f156f) {
                d dVar = this.f155e;
                aVar.f317b = dVar;
                dVar.f147c.add(aVar);
            } else {
                d dVar2 = this.f155e;
                aVar.f317b = dVar2;
                dVar2.f147c.add(aVar);
            }
        }
        this.f156f = false;
    }

    public final void b() {
        if (!e()) {
            Log.e("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            return;
        }
        P.a.b("FlutterEngineConnectionRegistry#detachFromActivity");
        try {
            for (O.a aVar : this.f153c.values()) {
                aVar.f317b.f147c.remove(aVar);
                aVar.f317b = null;
            }
            c();
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void c() {
        c cVar = this.f152b;
        io.flutter.plugin.platform.k kVar = cVar.f141r;
        v vVar = kVar.f723f;
        if (vVar != null) {
            vVar.f94c = null;
        }
        kVar.e();
        kVar.f723f = null;
        kVar.f719b = null;
        kVar.f721d = null;
        io.flutter.plugin.platform.j jVar = cVar.f142s;
        v vVar2 = jVar.f710e;
        if (vVar2 != null) {
            vVar2.f94c = null;
        }
        Surface surface = jVar.f716k;
        if (surface != null) {
            surface.release();
            jVar.f716k = null;
            jVar.f717l = null;
        }
        jVar.f710e = null;
        jVar.f707b = null;
        this.f154d = null;
        this.f155e = null;
    }

    public final void d() {
        if (e()) {
            b();
        }
    }

    public final boolean e() {
        return this.f154d != null;
    }
}
