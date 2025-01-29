package E;

import D.AbstractActivityC0005f;
import D.v;
import K.n;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Trace;
import android.util.Log;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class c implements P.b {

    /* renamed from: w, reason: collision with root package name */
    public static long f123w = 1;

    /* renamed from: x, reason: collision with root package name */
    public static final HashMap f124x = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final FlutterJNI f125a;

    /* renamed from: b, reason: collision with root package name */
    public final io.flutter.embedding.engine.renderer.j f126b;

    /* renamed from: c, reason: collision with root package name */
    public final F.b f127c;

    /* renamed from: d, reason: collision with root package name */
    public final e f128d;

    /* renamed from: e, reason: collision with root package name */
    public final M.a f129e;

    /* renamed from: f, reason: collision with root package name */
    public final B.e f130f;

    /* renamed from: g, reason: collision with root package name */
    public final K.d f131g;

    /* renamed from: h, reason: collision with root package name */
    public final v f132h;

    /* renamed from: i, reason: collision with root package name */
    public final K.b f133i;

    /* renamed from: j, reason: collision with root package name */
    public final K.b f134j;

    /* renamed from: k, reason: collision with root package name */
    public final K.l f135k;

    /* renamed from: l, reason: collision with root package name */
    public final B.a f136l;
    public final v m;

    /* renamed from: n, reason: collision with root package name */
    public final n f137n;

    /* renamed from: o, reason: collision with root package name */
    public final v f138o;

    /* renamed from: p, reason: collision with root package name */
    public final K.c f139p;

    /* renamed from: q, reason: collision with root package name */
    public final B.a f140q;

    /* renamed from: r, reason: collision with root package name */
    public final io.flutter.plugin.platform.k f141r;

    /* renamed from: s, reason: collision with root package name */
    public final io.flutter.plugin.platform.j f142s;
    public final long u;

    /* renamed from: t, reason: collision with root package name */
    public final HashSet f143t = new HashSet();

    /* renamed from: v, reason: collision with root package name */
    public final a f144v = new a(this);

    public c(AbstractActivityC0005f abstractActivityC0005f, FlutterJNI flutterJNI, io.flutter.plugin.platform.k kVar, boolean z2, boolean z3) {
        AssetManager assets;
        long j2 = f123w;
        f123w = 1 + j2;
        this.u = j2;
        f124x.put(Long.valueOf(j2), this);
        try {
            assets = abstractActivityC0005f.createPackageContext(abstractActivityC0005f.getPackageName(), 0).getAssets();
        } catch (PackageManager.NameNotFoundException unused) {
            assets = abstractActivityC0005f.getAssets();
        }
        B.a j3 = B.a.j();
        if (flutterJNI == null) {
            Object obj = j3.f5d;
            flutterJNI = new FlutterJNI();
        }
        this.f125a = flutterJNI;
        F.b bVar = new F.b(flutterJNI, assets, this.u);
        this.f127c = bVar;
        flutterJNI.setPlatformMessageHandler(bVar.f176e);
        B.a.j().getClass();
        this.f130f = new B.e(bVar, flutterJNI);
        new B.b(bVar);
        this.f131g = new K.d(bVar);
        B.a aVar = new B.a(bVar, 5);
        this.f132h = new v(bVar, 10);
        this.f133i = new K.b(bVar, 1);
        this.f134j = new K.b(bVar, 0);
        this.f136l = new B.a(bVar, 6);
        B.a aVar2 = new B.a(bVar, abstractActivityC0005f.getPackageManager());
        this.f135k = new K.l(bVar, z3);
        this.m = new v(bVar, 19);
        this.f137n = new n(bVar);
        this.f138o = new v(bVar, 21);
        this.f139p = new K.c(bVar);
        this.f140q = new B.a(bVar, 9);
        M.a aVar3 = new M.a(abstractActivityC0005f, aVar);
        this.f129e = aVar3;
        H.f fVar = (H.f) j3.f4c;
        if (!flutterJNI.isAttached()) {
            fVar.b(abstractActivityC0005f.getApplicationContext());
            fVar.a(abstractActivityC0005f, null);
        }
        io.flutter.plugin.platform.j jVar = new io.flutter.plugin.platform.j();
        jVar.f706a = kVar.f718a;
        jVar.f709d = flutterJNI;
        flutterJNI.addEngineLifecycleListener(this.f144v);
        flutterJNI.setPlatformViewsController(kVar);
        flutterJNI.setPlatformViewsController2(jVar);
        flutterJNI.setLocalizationPlugin(aVar3);
        j3.getClass();
        flutterJNI.setDeferredComponentManager(null);
        if (!flutterJNI.isAttached()) {
            flutterJNI.attachToNative();
            if (!flutterJNI.isAttached()) {
                throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
            }
        }
        this.f126b = new io.flutter.embedding.engine.renderer.j(flutterJNI);
        this.f141r = kVar;
        this.f142s = jVar;
        abstractActivityC0005f.getApplicationContext();
        e eVar = new e(this);
        this.f128d = eVar;
        aVar3.b(abstractActivityC0005f.getResources().getConfiguration());
        if (z2 && fVar.f219d.f209e) {
            a.a.u(this);
        }
        a.a.b(abstractActivityC0005f, this);
        O.a aVar4 = new O.a(aVar2);
        P.a.b("FlutterEngineConnectionRegistry#add ".concat(O.a.class.getSimpleName()));
        HashMap hashMap = eVar.f151a;
        try {
            if (hashMap.containsKey(O.a.class)) {
                Log.w("FlutterEngineCxnRegstry", "Attempted to register plugin (" + aVar4 + ") but it was already registered with this FlutterEngine (" + eVar.f152b + ").");
            } else {
                hashMap.put(O.a.class, aVar4);
                eVar.f153c.put(O.a.class, aVar4);
                if (eVar.e()) {
                    d dVar = eVar.f155e;
                    aVar4.f317b = dVar;
                    dVar.f147c.add(aVar4);
                }
            }
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
}
