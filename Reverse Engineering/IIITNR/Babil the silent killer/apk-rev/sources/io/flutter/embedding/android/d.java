package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.window.OnBackInvokedCallback;
import androidx.lifecycle.c;
import io.flutter.embedding.android.e;
import java.util.List;

/* loaded from: classes.dex */
public class d extends Activity implements e.c, androidx.lifecycle.f {

    /* renamed from: d, reason: collision with root package name */
    public static final int f196d = z.h.d(61938);

    /* renamed from: a, reason: collision with root package name */
    protected e f197a;

    /* renamed from: b, reason: collision with root package name */
    private androidx.lifecycle.g f198b;

    /* renamed from: c, reason: collision with root package name */
    private final OnBackInvokedCallback f199c;

    class a implements OnBackInvokedCallback {
        a() {
        }

        @Override // android.window.OnBackInvokedCallback
        public void onBackInvoked() {
            d.this.onBackPressed();
        }
    }

    public d() {
        this.f199c = Build.VERSION.SDK_INT >= 33 ? new a() : null;
        this.f198b = new androidx.lifecycle.g(this);
    }

    private void D() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(1073741824);
            window.getDecorView().setSystemUiVisibility(1280);
        }
    }

    private void E() {
        if (G() == f.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    private View F() {
        return this.f197a.r(null, null, null, f196d, o() == v.surface);
    }

    private Drawable J() {
        try {
            Bundle I = I();
            int i2 = I != null ? I.getInt("io.flutter.embedding.android.SplashScreenDrawable") : 0;
            if (i2 != 0) {
                return c.a.a(getResources(), i2, getTheme());
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        } catch (Resources.NotFoundException e2) {
            j.b.b("FlutterActivity", "Splash screen not found. Ensure the drawable exists and that it's valid.");
            throw e2;
        }
    }

    private boolean K() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    private boolean N(String str) {
        StringBuilder sb;
        String str2;
        e eVar = this.f197a;
        if (eVar == null) {
            sb = new StringBuilder();
            sb.append("FlutterActivity ");
            sb.append(hashCode());
            sb.append(" ");
            sb.append(str);
            str2 = " called after release.";
        } else {
            if (eVar.l()) {
                return true;
            }
            sb = new StringBuilder();
            sb.append("FlutterActivity ");
            sb.append(hashCode());
            sb.append(" ");
            sb.append(str);
            str2 = " called after detach.";
        }
        sb.append(str2);
        j.b.g("FlutterActivity", sb.toString());
        return false;
    }

    private void O() {
        try {
            Bundle I = I();
            if (I != null) {
                int i2 = I.getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (i2 != -1) {
                    setTheme(i2);
                }
            } else {
                j.b.f("FlutterActivity", "Using the launch theme as normal theme.");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            j.b.b("FlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
        }
    }

    @Override // io.flutter.embedding.android.e.c
    public String A() {
        try {
            Bundle I = I();
            if (I != null) {
                return I.getString("io.flutter.EntrypointUri");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // io.flutter.embedding.android.e.c
    public io.flutter.plugin.platform.c B(Activity activity, io.flutter.embedding.engine.a aVar) {
        return new io.flutter.plugin.platform.c(f(), aVar.m(), this);
    }

    @Override // io.flutter.embedding.android.e.c
    public void C(h hVar) {
    }

    protected f G() {
        return getIntent().hasExtra("background_mode") ? f.valueOf(getIntent().getStringExtra("background_mode")) : f.opaque;
    }

    protected io.flutter.embedding.engine.a H() {
        return this.f197a.k();
    }

    protected Bundle I() {
        return getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    }

    public void L() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.f199c);
        }
    }

    public void M() {
        P();
        e eVar = this.f197a;
        if (eVar != null) {
            eVar.F();
            this.f197a = null;
        }
    }

    public void P() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.f199c);
        }
    }

    @Override // io.flutter.embedding.android.e.c
    public void a() {
        j.b.g("FlutterActivity", "FlutterActivity " + this + " connection to the engine " + H() + " evicted by another attaching activity");
        e eVar = this.f197a;
        if (eVar != null) {
            eVar.s();
            this.f197a.t();
        }
    }

    @Override // io.flutter.plugin.platform.c.d
    public boolean b() {
        return false;
    }

    @Override // io.flutter.embedding.android.e.c
    public void c() {
        if (Build.VERSION.SDK_INT >= 29) {
            reportFullyDrawn();
        }
    }

    @Override // io.flutter.embedding.android.e.c, androidx.lifecycle.f
    public androidx.lifecycle.c d() {
        return this.f198b;
    }

    @Override // io.flutter.embedding.android.e.c
    public void e() {
    }

    @Override // io.flutter.embedding.android.e.c
    public Activity f() {
        return this;
    }

    @Override // io.flutter.embedding.android.e.c
    public String g() {
        if (getIntent().hasExtra("route")) {
            return getIntent().getStringExtra("route");
        }
        try {
            Bundle I = I();
            if (I != null) {
                return I.getString("io.flutter.InitialRoute");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // io.flutter.embedding.android.e.c
    public Context getContext() {
        return this;
    }

    @Override // io.flutter.embedding.android.e.c
    public io.flutter.embedding.engine.e h() {
        return io.flutter.embedding.engine.e.a(getIntent());
    }

    @Override // io.flutter.embedding.android.e.c
    public String k() {
        String dataString;
        if (K() && "android.intent.action.RUN".equals(getIntent().getAction()) && (dataString = getIntent().getDataString()) != null) {
            return dataString;
        }
        return null;
    }

    @Override // io.flutter.embedding.android.e.c
    public List<String> l() {
        return (List) getIntent().getSerializableExtra("dart_entrypoint_args");
    }

    @Override // io.flutter.embedding.android.e.c
    public io.flutter.embedding.engine.a m(Context context) {
        return null;
    }

    @Override // io.flutter.embedding.android.e.c
    public boolean n() {
        return true;
    }

    @Override // io.flutter.embedding.android.e.c
    public v o() {
        return G() == f.opaque ? v.surface : v.texture;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        if (N("onActivityResult")) {
            this.f197a.o(i2, i3, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (N("onBackPressed")) {
            this.f197a.q();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        O();
        super.onCreate(bundle);
        e eVar = new e(this);
        this.f197a = eVar;
        eVar.p(this);
        this.f197a.y(bundle);
        this.f198b.g(c.a.ON_CREATE);
        L();
        E();
        setContentView(F());
        D();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (N("onDestroy")) {
            this.f197a.s();
            this.f197a.t();
        }
        M();
        this.f198b.g(c.a.ON_DESTROY);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (N("onNewIntent")) {
            this.f197a.u(intent);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (N("onPause")) {
            this.f197a.v();
        }
        this.f198b.g(c.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        if (N("onPostResume")) {
            this.f197a.w();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (N("onRequestPermissionsResult")) {
            this.f197a.x(i2, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f198b.g(c.a.ON_RESUME);
        if (N("onResume")) {
            this.f197a.z();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (N("onSaveInstanceState")) {
            this.f197a.A(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f198b.g(c.a.ON_START);
        if (N("onStart")) {
            this.f197a.B();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (N("onStop")) {
            this.f197a.C();
        }
        this.f198b.g(c.a.ON_STOP);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        if (N("onTrimMemory")) {
            this.f197a.D(i2);
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        if (N("onUserLeaveHint")) {
            this.f197a.E();
        }
    }

    @Override // io.flutter.embedding.android.e.c
    public boolean p() {
        boolean booleanExtra = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
        return (u() != null || this.f197a.m()) ? booleanExtra : getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    }

    @Override // io.flutter.embedding.android.e.c
    public boolean q() {
        try {
            Bundle I = I();
            if (I != null) {
                return I.getBoolean("flutter_deeplinking_enabled");
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // io.flutter.embedding.android.e.c
    public y r() {
        return G() == f.opaque ? y.opaque : y.transparent;
    }

    @Override // io.flutter.embedding.android.e.c
    public boolean s() {
        return true;
    }

    @Override // io.flutter.embedding.android.e.c
    public void t(i iVar) {
    }

    @Override // io.flutter.embedding.android.e.c
    public String u() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    @Override // io.flutter.embedding.android.e.c
    public void v(io.flutter.embedding.engine.a aVar) {
        if (this.f197a.m()) {
            return;
        }
        t.a.a(aVar);
    }

    @Override // io.flutter.embedding.android.e.c
    public boolean w() {
        return getIntent().hasExtra("enable_state_restoration") ? getIntent().getBooleanExtra("enable_state_restoration", false) : u() == null;
    }

    @Override // io.flutter.embedding.android.e.c
    public String x() {
        try {
            Bundle I = I();
            String string = I != null ? I.getString("io.flutter.Entrypoint") : null;
            return string != null ? string : "main";
        } catch (PackageManager.NameNotFoundException unused) {
            return "main";
        }
    }

    @Override // io.flutter.embedding.android.e.c
    public void y(io.flutter.embedding.engine.a aVar) {
    }

    @Override // io.flutter.embedding.android.e.c
    public x z() {
        Drawable J = J();
        if (J != null) {
            return new b(J);
        }
        return null;
    }
}
