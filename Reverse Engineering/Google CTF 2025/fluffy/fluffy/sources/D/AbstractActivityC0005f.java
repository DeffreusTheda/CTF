package D;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/* renamed from: D.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractActivityC0005f extends Activity implements androidx.lifecycle.l {

    /* renamed from: e, reason: collision with root package name */
    public static final int f55e = View.generateViewId();

    /* renamed from: a, reason: collision with root package name */
    public boolean f56a = false;

    /* renamed from: b, reason: collision with root package name */
    public C0008i f57b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.lifecycle.n f58c;

    /* renamed from: d, reason: collision with root package name */
    public final OnBackInvokedCallback f59d;

    public AbstractActivityC0005f() {
        int i2 = Build.VERSION.SDK_INT;
        this.f59d = i2 < 33 ? null : i2 >= 34 ? new C0004e(this) : new OnBackInvokedCallback() { // from class: D.d
            @Override // android.window.OnBackInvokedCallback
            public final void onBackInvoked() {
                AbstractActivityC0005f.this.onBackPressed();
            }
        };
        this.f58c = new androidx.lifecycle.n(this);
    }

    @Override // androidx.lifecycle.l
    public final androidx.lifecycle.n a() {
        return this.f58c;
    }

    public final String b() {
        String dataString;
        if ((getApplicationInfo().flags & 2) == 0 || !"android.intent.action.RUN".equals(getIntent().getAction()) || (dataString = getIntent().getDataString()) == null) {
            return null;
        }
        return dataString;
    }

    public final int c() {
        if (!getIntent().hasExtra("background_mode")) {
            return 1;
        }
        String stringExtra = getIntent().getStringExtra("background_mode");
        if (stringExtra == null) {
            throw new NullPointerException("Name is null");
        }
        if (stringExtra.equals("opaque")) {
            return 1;
        }
        if (stringExtra.equals("transparent")) {
            return 2;
        }
        throw new IllegalArgumentException("No enum constant io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode.".concat(stringExtra));
    }

    public final String d() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    public final String e() {
        if (getIntent().hasExtra("dart_entrypoint")) {
            return getIntent().getStringExtra("dart_entrypoint");
        }
        try {
            Bundle g2 = g();
            String string = g2 != null ? g2.getString("io.flutter.Entrypoint") : null;
            return string != null ? string : "main";
        } catch (PackageManager.NameNotFoundException unused) {
            return "main";
        }
    }

    public final String f() {
        if (getIntent().hasExtra("route")) {
            return getIntent().getStringExtra("route");
        }
        try {
            Bundle g2 = g();
            if (g2 != null) {
                return g2.getString("io.flutter.InitialRoute");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final Bundle g() {
        return getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    }

    public final void h(boolean z2) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedDispatcher onBackInvokedDispatcher2;
        if (z2 && !this.f56a) {
            if (Build.VERSION.SDK_INT >= 33) {
                onBackInvokedDispatcher2 = getOnBackInvokedDispatcher();
                onBackInvokedDispatcher2.registerOnBackInvokedCallback(0, this.f59d);
                this.f56a = true;
                return;
            }
            return;
        }
        if (z2 || !this.f56a || Build.VERSION.SDK_INT < 33) {
            return;
        }
        onBackInvokedDispatcher = getOnBackInvokedDispatcher();
        onBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.f59d);
        this.f56a = false;
    }

    public final boolean i() {
        boolean booleanExtra = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
        return (d() != null || this.f57b.f69f) ? booleanExtra : getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    }

    public final boolean j() {
        return getIntent().hasExtra("enable_state_restoration") ? getIntent().getBooleanExtra("enable_state_restoration", false) : d() == null;
    }

    public final boolean k(String str) {
        C0008i c0008i = this.f57b;
        if (c0008i == null) {
            Log.w("FlutterActivity", "FlutterActivity " + hashCode() + " " + str + " called after release.");
            return false;
        }
        if (c0008i.f72i) {
            return true;
        }
        Log.w("FlutterActivity", "FlutterActivity " + hashCode() + " " + str + " called after detach.");
        return false;
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (k("onActivityResult")) {
            C0008i c0008i = this.f57b;
            c0008i.c();
            if (c0008i.f65b == null) {
                Log.w("FlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
                return;
            }
            Objects.toString(intent);
            E.e eVar = c0008i.f65b.f128d;
            if (!eVar.e()) {
                Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
                return;
            }
            P.a.b("FlutterEngineConnectionRegistry#onActivityResult");
            try {
                eVar.f155e.a(i2, i3, intent);
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

    @Override // android.app.Activity
    public final void onBackPressed() {
        if (k("onBackPressed")) {
            C0008i c0008i = this.f57b;
            c0008i.c();
            E.c cVar = c0008i.f65b;
            if (cVar != null) {
                cVar.f133i.f223a.f("popRoute", null, null);
            } else {
                Log.w("FlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(44:0|1|2|(1:6)|8|(1:10)|11|(2:13|(4:15|(1:17)|18|(2:20|21))(2:23|(4:25|(3:27|93|34)|40|(1:42)(2:43|44))(41:45|(1:47)|48|(1:50)|51|(1:53)(2:109|(1:111))|54|(1:56)|57|(1:59)|60|(1:62)|63|(1:65)|66|(1:68)|69|(1:71)|72|(1:74)|75|(1:77)|78|(1:80)|81|(1:83)|84|(2:86|(1:88)(1:89))|90|(1:92)|93|(1:95)|96|(1:98)|99|(1:101)|102|(1:104)|105|(1:107)|108)))|112|113|114|(1:116)|117|118|(1:120)|121|(1:123)(1:250)|124|(2:126|(1:128)(2:129|(1:131)(1:132)))|133|(4:135|136|137|(1:139)(2:237|(1:239)(2:240|241)))(1:249)|140|(1:142)|143|(1:145)|(1:147)(1:236)|148|(3:150|(1:152)(1:230)|153)(3:231|(1:233)(1:235)|234)|154|(6:156|(1:158)|159|(2:161|(3:163|(1:165)|166)(2:167|168))|169|170)|171|(1:173)|174|(1:176)|177|178|179|180|(2:(1:226)(1:184)|185)(1:227)|186|(2:187|(1:189)(1:190))|191|(2:192|(2:194|(1:196)(3:197|198|199))(3:200|201|(2:203|(2:204|(2:206|(1:208)(3:209|210|211))(3:212|213|(2:215|(2:217|(1:219))(2:220|221))(2:222|223))))(2:224|225)))|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0477, code lost:
    
        android.util.Log.e("FlutterView", "TextServicesManager not supported by device, spell check disabled.");
     */
    /* JADX WARN: Type inference failed for: r6v7, types: [android.view.View, io.flutter.embedding.engine.renderer.l] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r15) {
        /*
            Method dump skipped, instructions count: 1591
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D.AbstractActivityC0005f.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        super.onDestroy();
        if (k("onDestroy")) {
            this.f57b.e();
            this.f57b.f();
        }
        if (Build.VERSION.SDK_INT >= 33) {
            onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            onBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.f59d);
            this.f56a = false;
        }
        C0008i c0008i = this.f57b;
        if (c0008i != null) {
            c0008i.f64a = null;
            c0008i.f65b = null;
            c0008i.f66c = null;
            c0008i.f67d = null;
            this.f57b = null;
        }
        this.f58c.c(androidx.lifecycle.f.ON_DESTROY);
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (k("onNewIntent")) {
            C0008i c0008i = this.f57b;
            c0008i.c();
            E.c cVar = c0008i.f65b;
            if (cVar == null) {
                Log.w("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
                return;
            }
            E.e eVar = cVar.f128d;
            if (eVar.e()) {
                P.a.b("FlutterEngineConnectionRegistry#onNewIntent");
                try {
                    Iterator it = eVar.f155e.f148d.iterator();
                    if (it.hasNext()) {
                        if (it.next() != null) {
                            throw new ClassCastException();
                        }
                        throw null;
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
            } else {
                Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
            }
            String d2 = c0008i.d(intent);
            if (d2 == null || d2.isEmpty()) {
                return;
            }
            K.b bVar = c0008i.f65b.f133i;
            bVar.getClass();
            HashMap hashMap = new HashMap();
            hashMap.put("location", d2);
            bVar.f223a.f("pushRouteInformation", hashMap, null);
        }
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        if (k("onPause")) {
            C0008i c0008i = this.f57b;
            c0008i.c();
            c0008i.f64a.getClass();
            E.c cVar = c0008i.f65b;
            if (cVar != null) {
                K.d dVar = cVar.f131g;
                dVar.a(3, dVar.f227c);
            }
        }
        this.f58c.c(androidx.lifecycle.f.ON_PAUSE);
    }

    @Override // android.app.Activity
    public final void onPostResume() {
        super.onPostResume();
        if (k("onPostResume")) {
            C0008i c0008i = this.f57b;
            c0008i.c();
            if (c0008i.f65b == null) {
                Log.w("FlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.");
                return;
            }
            io.flutter.plugin.platform.e eVar = c0008i.f67d;
            if (eVar != null) {
                eVar.b();
            }
            Iterator it = c0008i.f65b.f141r.f725h.values().iterator();
            if (it.hasNext()) {
                ((io.flutter.plugin.platform.q) it.next()).getClass();
                throw null;
            }
        }
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (k("onRequestPermissionsResult")) {
            C0008i c0008i = this.f57b;
            c0008i.c();
            if (c0008i.f65b == null) {
                Log.w("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
                return;
            }
            Arrays.toString(strArr);
            Arrays.toString(iArr);
            E.e eVar = c0008i.f65b.f128d;
            if (!eVar.e()) {
                Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
                return;
            }
            P.a.b("FlutterEngineConnectionRegistry#onRequestPermissionsResult");
            try {
                Iterator it = eVar.f155e.f146b.iterator();
                if (!it.hasNext()) {
                    Trace.endSection();
                } else {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
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

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        this.f58c.c(androidx.lifecycle.f.ON_RESUME);
        if (k("onResume")) {
            C0008i c0008i = this.f57b;
            c0008i.c();
            c0008i.f64a.getClass();
            E.c cVar = c0008i.f65b;
            if (cVar != null) {
                K.d dVar = cVar.f131g;
                dVar.a(2, dVar.f227c);
            }
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (k("onSaveInstanceState")) {
            C0008i c0008i = this.f57b;
            c0008i.c();
            if (c0008i.f64a.j()) {
                bundle.putByteArray("framework", c0008i.f65b.f135k.f267b);
            }
            c0008i.f64a.getClass();
            Bundle bundle2 = new Bundle();
            E.e eVar = c0008i.f65b.f128d;
            if (eVar.e()) {
                P.a.b("FlutterEngineConnectionRegistry#onSaveInstanceState");
                try {
                    Iterator it = eVar.f155e.f150f.iterator();
                    if (it.hasNext()) {
                        if (it.next() != null) {
                            throw new ClassCastException();
                        }
                        throw null;
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
            } else {
                Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
            }
            bundle.putBundle("plugins", bundle2);
            if (c0008i.f64a.d() == null || c0008i.f64a.i()) {
                return;
            }
            bundle.putBoolean("enableOnBackInvokedCallbackState", c0008i.f64a.f56a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0090  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onStart() {
        /*
            r6 = this;
            super.onStart()
            androidx.lifecycle.n r0 = r6.f58c
            androidx.lifecycle.f r1 = androidx.lifecycle.f.ON_START
            r0.c(r1)
            java.lang.String r0 = "onStart"
            boolean r0 = r6.k(r0)
            if (r0 == 0) goto Lbe
            D.i r0 = r6.f57b
            r0.c()
            D.f r1 = r0.f64a
            java.lang.String r1 = r1.d()
            if (r1 == 0) goto L21
            goto Lb1
        L21:
            E.c r1 = r0.f65b
            F.b r1 = r1.f127c
            boolean r1 = r1.f178g
            if (r1 == 0) goto L2b
            goto Lb1
        L2b:
            D.f r1 = r0.f64a
            java.lang.String r1 = r1.f()
            if (r1 != 0) goto L44
            D.f r1 = r0.f64a
            r1.getClass()
            android.content.Intent r1 = r1.getIntent()
            java.lang.String r1 = r0.d(r1)
            if (r1 != 0) goto L44
            java.lang.String r1 = "/"
        L44:
            D.f r2 = r0.f64a
            r2.getClass()
            r3 = 0
            android.os.Bundle r2 = r2.g()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L57
            if (r2 == 0) goto L57
            java.lang.String r4 = "io.flutter.EntrypointUri"
            java.lang.String r2 = r2.getString(r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L57
            goto L58
        L57:
            r2 = r3
        L58:
            D.f r4 = r0.f64a
            r4.e()
            E.c r4 = r0.f65b
            K.b r4 = r4.f133i
            B.e r4 = r4.f223a
            java.lang.String r5 = "setInitialRoute"
            r4.f(r5, r1, r3)
            D.f r1 = r0.f64a
            java.lang.String r1 = r1.b()
            if (r1 == 0) goto L76
            boolean r3 = r1.isEmpty()
            if (r3 == 0) goto L82
        L76:
            B.a r1 = B.a.j()
            java.lang.Object r1 = r1.f4c
            H.f r1 = (H.f) r1
            H.b r1 = r1.f219d
            java.lang.String r1 = r1.f206b
        L82:
            if (r2 != 0) goto L90
            F.a r2 = new F.a
            D.f r3 = r0.f64a
            java.lang.String r3 = r3.e()
            r2.<init>(r1, r3)
            goto L9c
        L90:
            F.a r3 = new F.a
            D.f r4 = r0.f64a
            java.lang.String r4 = r4.e()
            r3.<init>(r1, r2, r4)
            r2 = r3
        L9c:
            E.c r1 = r0.f65b
            F.b r1 = r1.f127c
            D.f r3 = r0.f64a
            android.content.Intent r3 = r3.getIntent()
            java.lang.String r4 = "dart_entrypoint_args"
            java.io.Serializable r3 = r3.getSerializableExtra(r4)
            java.util.List r3 = (java.util.List) r3
            r1.b(r2, r3)
        Lb1:
            java.lang.Integer r1 = r0.f73j
            if (r1 == 0) goto Lbe
            D.y r0 = r0.f66c
            int r1 = r1.intValue()
            r0.setVisibility(r1)
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: D.AbstractActivityC0005f.onStart():void");
    }

    @Override // android.app.Activity
    public final void onStop() {
        super.onStop();
        if (k("onStop")) {
            C0008i c0008i = this.f57b;
            c0008i.c();
            c0008i.f64a.getClass();
            E.c cVar = c0008i.f65b;
            if (cVar != null) {
                K.d dVar = cVar.f131g;
                dVar.a(5, dVar.f227c);
            }
            c0008i.f73j = Integer.valueOf(c0008i.f66c.getVisibility());
            c0008i.f66c.setVisibility(8);
            E.c cVar2 = c0008i.f65b;
            if (cVar2 != null) {
                cVar2.f126b.a(40);
            }
        }
        this.f58c.c(androidx.lifecycle.f.ON_STOP);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        if (k("onTrimMemory")) {
            C0008i c0008i = this.f57b;
            c0008i.c();
            E.c cVar = c0008i.f65b;
            if (cVar != null) {
                if (c0008i.f71h && i2 >= 10) {
                    FlutterJNI flutterJNI = cVar.f127c.f173b;
                    if (flutterJNI.isAttached()) {
                        flutterJNI.notifyLowMemoryWarning();
                    }
                    K.c cVar2 = c0008i.f65b.f139p;
                    cVar2.getClass();
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("type", "memoryPressure");
                    cVar2.f224a.j(hashMap, null);
                }
                c0008i.f65b.f126b.a(i2);
                io.flutter.plugin.platform.k kVar = c0008i.f65b.f141r;
                if (i2 < 40) {
                    kVar.getClass();
                    return;
                }
                Iterator it = kVar.f725h.values().iterator();
                if (it.hasNext()) {
                    ((io.flutter.plugin.platform.q) it.next()).getClass();
                    throw null;
                }
            }
        }
    }

    @Override // android.app.Activity
    public final void onUserLeaveHint() {
        if (k("onUserLeaveHint")) {
            C0008i c0008i = this.f57b;
            c0008i.c();
            E.c cVar = c0008i.f65b;
            if (cVar == null) {
                Log.w("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
                return;
            }
            E.e eVar = cVar.f128d;
            if (!eVar.e()) {
                Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
                return;
            }
            P.a.b("FlutterEngineConnectionRegistry#onUserLeaveHint");
            try {
                Iterator it = eVar.f155e.f149e.iterator();
                if (!it.hasNext()) {
                    Trace.endSection();
                } else {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
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

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (k("onWindowFocusChanged")) {
            C0008i c0008i = this.f57b;
            c0008i.c();
            c0008i.f64a.getClass();
            E.c cVar = c0008i.f65b;
            if (cVar != null) {
                K.d dVar = cVar.f131g;
                if (z2) {
                    dVar.a(dVar.f225a, true);
                } else {
                    dVar.a(dVar.f225a, false);
                }
            }
        }
    }
}
