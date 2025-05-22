package io.flutter.embedding.engine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import v.f;
import v.g;
import v.h;
import v.i;
import v.l;
import v.m;
import v.n;
import v.o;
import v.p;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final FlutterJNI f341a;

    /* renamed from: b, reason: collision with root package name */
    private final u.a f342b;

    /* renamed from: c, reason: collision with root package name */
    private final k.a f343c;

    /* renamed from: d, reason: collision with root package name */
    private final c f344d;

    /* renamed from: e, reason: collision with root package name */
    private final x.a f345e;

    /* renamed from: f, reason: collision with root package name */
    private final v.a f346f;

    /* renamed from: g, reason: collision with root package name */
    private final v.b f347g;

    /* renamed from: h, reason: collision with root package name */
    private final v.e f348h;

    /* renamed from: i, reason: collision with root package name */
    private final f f349i;

    /* renamed from: j, reason: collision with root package name */
    private final g f350j;

    /* renamed from: k, reason: collision with root package name */
    private final h f351k;

    /* renamed from: l, reason: collision with root package name */
    private final l f352l;

    /* renamed from: m, reason: collision with root package name */
    private final i f353m;

    /* renamed from: n, reason: collision with root package name */
    private final m f354n;

    /* renamed from: o, reason: collision with root package name */
    private final n f355o;

    /* renamed from: p, reason: collision with root package name */
    private final o f356p;

    /* renamed from: q, reason: collision with root package name */
    private final p f357q;

    /* renamed from: r, reason: collision with root package name */
    private final io.flutter.plugin.platform.p f358r;

    /* renamed from: s, reason: collision with root package name */
    private final Set<b> f359s;

    /* renamed from: t, reason: collision with root package name */
    private final b f360t;

    /* renamed from: io.flutter.embedding.engine.a$a, reason: collision with other inner class name */
    class C0010a implements b {
        C0010a() {
        }

        @Override // io.flutter.embedding.engine.a.b
        public void a() {
            j.b.f("FlutterEngine", "onPreEngineRestart()");
            Iterator it = a.this.f359s.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a();
            }
            a.this.f358r.b0();
            a.this.f352l.g();
        }

        @Override // io.flutter.embedding.engine.a.b
        public void b() {
        }
    }

    public interface b {
        void a();

        void b();
    }

    public a(Context context, m.d dVar, FlutterJNI flutterJNI, io.flutter.plugin.platform.p pVar, String[] strArr, boolean z2, boolean z3) {
        AssetManager assets;
        this.f359s = new HashSet();
        this.f360t = new C0010a();
        try {
            assets = context.createPackageContext(context.getPackageName(), 0).getAssets();
        } catch (PackageManager.NameNotFoundException unused) {
            assets = context.getAssets();
        }
        j.a e2 = j.a.e();
        flutterJNI = flutterJNI == null ? e2.d().a() : flutterJNI;
        this.f341a = flutterJNI;
        k.a aVar = new k.a(flutterJNI, assets);
        this.f343c = aVar;
        aVar.k();
        l.a a2 = j.a.e().a();
        this.f346f = new v.a(aVar, flutterJNI);
        v.b bVar = new v.b(aVar);
        this.f347g = bVar;
        this.f348h = new v.e(aVar);
        f fVar = new f(aVar);
        this.f349i = fVar;
        this.f350j = new g(aVar);
        this.f351k = new h(aVar);
        this.f353m = new i(aVar);
        this.f352l = new l(aVar, z3);
        this.f354n = new m(aVar);
        this.f355o = new n(aVar);
        this.f356p = new o(aVar);
        this.f357q = new p(aVar);
        if (a2 != null) {
            a2.f(bVar);
        }
        x.a aVar2 = new x.a(context, fVar);
        this.f345e = aVar2;
        dVar = dVar == null ? e2.c() : dVar;
        if (!flutterJNI.isAttached()) {
            dVar.i(context.getApplicationContext());
            dVar.e(context, strArr);
        }
        flutterJNI.addEngineLifecycleListener(this.f360t);
        flutterJNI.setPlatformViewsController(pVar);
        flutterJNI.setLocalizationPlugin(aVar2);
        flutterJNI.setDeferredComponentManager(e2.a());
        if (!flutterJNI.isAttached()) {
            d();
        }
        this.f342b = new u.a(flutterJNI);
        this.f358r = pVar;
        pVar.V();
        this.f344d = new c(context.getApplicationContext(), this, dVar);
        aVar2.d(context.getResources().getConfiguration());
        if (z2 && dVar.d()) {
            t.a.a(this);
        }
    }

    public a(Context context, String[] strArr, boolean z2, boolean z3) {
        this(context, null, null, new io.flutter.plugin.platform.p(), strArr, z2, z3);
    }

    private void d() {
        j.b.f("FlutterEngine", "Attaching to JNI.");
        this.f341a.attachToNative();
        if (!u()) {
            throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
        }
    }

    private boolean u() {
        return this.f341a.isAttached();
    }

    public void e() {
        j.b.f("FlutterEngine", "Destroying.");
        Iterator<b> it = this.f359s.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.f344d.k();
        this.f358r.X();
        this.f343c.l();
        this.f341a.removeEngineLifecycleListener(this.f360t);
        this.f341a.setDeferredComponentManager(null);
        this.f341a.detachFromNativeAndReleaseResources();
        if (j.a.e().a() != null) {
            j.a.e().a().d();
            this.f347g.c(null);
        }
    }

    public v.a f() {
        return this.f346f;
    }

    public p.b g() {
        return this.f344d;
    }

    public k.a h() {
        return this.f343c;
    }

    public v.e i() {
        return this.f348h;
    }

    public x.a j() {
        return this.f345e;
    }

    public g k() {
        return this.f350j;
    }

    public h l() {
        return this.f351k;
    }

    public i m() {
        return this.f353m;
    }

    public io.flutter.plugin.platform.p n() {
        return this.f358r;
    }

    public u.a o() {
        return this.f342b;
    }

    public l p() {
        return this.f352l;
    }

    public m q() {
        return this.f354n;
    }

    public n r() {
        return this.f355o;
    }

    public o s() {
        return this.f356p;
    }

    public p t() {
        return this.f357q;
    }
}
