package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import io.flutter.plugin.platform.c;
import java.util.Arrays;
import java.util.List;
import k.a;

/* loaded from: classes.dex */
class e implements io.flutter.embedding.android.c<Activity> {

    /* renamed from: a, reason: collision with root package name */
    private c f201a;

    /* renamed from: b, reason: collision with root package name */
    private io.flutter.embedding.engine.a f202b;

    /* renamed from: c, reason: collision with root package name */
    k f203c;

    /* renamed from: d, reason: collision with root package name */
    private io.flutter.plugin.platform.c f204d;

    /* renamed from: e, reason: collision with root package name */
    ViewTreeObserver.OnPreDrawListener f205e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f206f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f207g;

    /* renamed from: i, reason: collision with root package name */
    private boolean f209i;

    /* renamed from: j, reason: collision with root package name */
    private Integer f210j;

    /* renamed from: k, reason: collision with root package name */
    private final u.b f211k = new a();

    /* renamed from: h, reason: collision with root package name */
    private boolean f208h = false;

    class a implements u.b {
        a() {
        }

        @Override // u.b
        public void c() {
            e.this.f201a.c();
            e.this.f207g = true;
            e.this.f208h = true;
        }

        @Override // u.b
        public void e() {
            e.this.f201a.e();
            e.this.f207g = false;
        }
    }

    class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f213a;

        b(k kVar) {
            this.f213a = kVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (e.this.f207g && e.this.f205e != null) {
                this.f213a.getViewTreeObserver().removeOnPreDrawListener(this);
                e.this.f205e = null;
            }
            return e.this.f207g;
        }
    }

    interface c extends c.d {
        String A();

        io.flutter.plugin.platform.c B(Activity activity, io.flutter.embedding.engine.a aVar);

        void C(h hVar);

        void a();

        void c();

        androidx.lifecycle.c d();

        void e();

        Activity f();

        String g();

        Context getContext();

        io.flutter.embedding.engine.e h();

        String k();

        List<String> l();

        io.flutter.embedding.engine.a m(Context context);

        boolean n();

        v o();

        boolean p();

        boolean q();

        y r();

        boolean s();

        void t(i iVar);

        String u();

        void v(io.flutter.embedding.engine.a aVar);

        boolean w();

        String x();

        void y(io.flutter.embedding.engine.a aVar);

        x z();
    }

    e(c cVar) {
        this.f201a = cVar;
    }

    private void g(k kVar) {
        if (this.f201a.o() != v.surface) {
            throw new IllegalArgumentException("Cannot delay the first Android view draw when the render mode is not set to `RenderMode.surface`.");
        }
        if (this.f205e != null) {
            kVar.getViewTreeObserver().removeOnPreDrawListener(this.f205e);
        }
        this.f205e = new b(kVar);
        kVar.getViewTreeObserver().addOnPreDrawListener(this.f205e);
    }

    private void h() {
        String str;
        if (this.f201a.u() == null && !this.f202b.h().i()) {
            String g2 = this.f201a.g();
            if (g2 == null && (g2 = n(this.f201a.f().getIntent())) == null) {
                g2 = "/";
            }
            String A = this.f201a.A();
            if (("Executing Dart entrypoint: " + this.f201a.x() + ", library uri: " + A) == null) {
                str = "\"\"";
            } else {
                str = A + ", and sending initial route: " + g2;
            }
            j.b.f("FlutterActivityAndFragmentDelegate", str);
            this.f202b.l().c(g2);
            String k2 = this.f201a.k();
            if (k2 == null || k2.isEmpty()) {
                k2 = j.a.e().c().f();
            }
            this.f202b.h().g(A == null ? new a.b(k2, this.f201a.x()) : new a.b(k2, A, this.f201a.x()), this.f201a.l());
        }
    }

    private void i() {
        if (this.f201a == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }

    private String n(Intent intent) {
        Uri data;
        String path;
        if (!this.f201a.q() || (data = intent.getData()) == null || (path = data.getPath()) == null || path.isEmpty()) {
            return null;
        }
        if (data.getQuery() != null && !data.getQuery().isEmpty()) {
            path = path + "?" + data.getQuery();
        }
        if (data.getFragment() == null || data.getFragment().isEmpty()) {
            return path;
        }
        return path + "#" + data.getFragment();
    }

    void A(Bundle bundle) {
        j.b.f("FlutterActivityAndFragmentDelegate", "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
        i();
        if (this.f201a.w()) {
            bundle.putByteArray("framework", this.f202b.p().h());
        }
        if (this.f201a.n()) {
            Bundle bundle2 = new Bundle();
            this.f202b.g().e(bundle2);
            bundle.putBundle("plugins", bundle2);
        }
    }

    void B() {
        j.b.f("FlutterActivityAndFragmentDelegate", "onStart()");
        i();
        h();
        Integer num = this.f210j;
        if (num != null) {
            this.f203c.setVisibility(num.intValue());
        }
    }

    void C() {
        j.b.f("FlutterActivityAndFragmentDelegate", "onStop()");
        i();
        if (this.f201a.s()) {
            this.f202b.i().c();
        }
        this.f210j = Integer.valueOf(this.f203c.getVisibility());
        this.f203c.setVisibility(8);
    }

    void D(int i2) {
        i();
        io.flutter.embedding.engine.a aVar = this.f202b;
        if (aVar != null) {
            if (this.f208h && i2 >= 10) {
                aVar.h().j();
                this.f202b.s().a();
            }
            this.f202b.o().m(i2);
        }
    }

    void E() {
        i();
        if (this.f202b == null) {
            j.b.g("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
        } else {
            j.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.");
            this.f202b.g().f();
        }
    }

    void F() {
        this.f201a = null;
        this.f202b = null;
        this.f203c = null;
        this.f204d = null;
    }

    void G() {
        j.b.f("FlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.");
        String u2 = this.f201a.u();
        if (u2 != null) {
            io.flutter.embedding.engine.a a2 = io.flutter.embedding.engine.b.b().a(u2);
            this.f202b = a2;
            this.f206f = true;
            if (a2 != null) {
                return;
            }
            throw new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + u2 + "'");
        }
        c cVar = this.f201a;
        io.flutter.embedding.engine.a m2 = cVar.m(cVar.getContext());
        this.f202b = m2;
        if (m2 != null) {
            this.f206f = true;
            return;
        }
        j.b.f("FlutterActivityAndFragmentDelegate", "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
        this.f202b = new io.flutter.embedding.engine.a(this.f201a.getContext(), this.f201a.h().b(), false, this.f201a.w());
        this.f206f = false;
    }

    void H() {
        io.flutter.plugin.platform.c cVar = this.f204d;
        if (cVar != null) {
            cVar.A();
        }
    }

    @Override // io.flutter.embedding.android.c
    public void a() {
        if (!this.f201a.p()) {
            this.f201a.a();
            return;
        }
        throw new AssertionError("The internal FlutterEngine created by " + this.f201a + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
    }

    @Override // io.flutter.embedding.android.c
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Activity b() {
        Activity f2 = this.f201a.f();
        if (f2 != null) {
            return f2;
        }
        throw new AssertionError("FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
    }

    io.flutter.embedding.engine.a k() {
        return this.f202b;
    }

    boolean l() {
        return this.f209i;
    }

    boolean m() {
        return this.f206f;
    }

    void o(int i2, int i3, Intent intent) {
        i();
        if (this.f202b == null) {
            j.b.g("FlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        j.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i2 + "\nresultCode: " + i3 + "\ndata: " + intent);
        this.f202b.g().c(i2, i3, intent);
    }

    void p(Context context) {
        i();
        if (this.f202b == null) {
            G();
        }
        if (this.f201a.n()) {
            j.b.f("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to the Activity that owns this delegate.");
            this.f202b.g().g(this, this.f201a.d());
        }
        c cVar = this.f201a;
        this.f204d = cVar.B(cVar.f(), this.f202b);
        this.f201a.v(this.f202b);
        this.f209i = true;
    }

    void q() {
        i();
        if (this.f202b == null) {
            j.b.g("FlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
        } else {
            j.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.");
            this.f202b.l().a();
        }
    }

    View r(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, int i2, boolean z2) {
        k kVar;
        j.b.f("FlutterActivityAndFragmentDelegate", "Creating FlutterView.");
        i();
        if (this.f201a.o() == v.surface) {
            h hVar = new h(this.f201a.getContext(), this.f201a.r() == y.transparent);
            this.f201a.C(hVar);
            kVar = new k(this.f201a.getContext(), hVar);
        } else {
            i iVar = new i(this.f201a.getContext());
            iVar.setOpaque(this.f201a.r() == y.opaque);
            this.f201a.t(iVar);
            kVar = new k(this.f201a.getContext(), iVar);
        }
        this.f203c = kVar;
        this.f203c.l(this.f211k);
        j.b.f("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.");
        this.f203c.n(this.f202b);
        this.f203c.setId(i2);
        x z3 = this.f201a.z();
        if (z3 == null) {
            if (z2) {
                g(this.f203c);
            }
            return this.f203c;
        }
        j.b.g("FlutterActivityAndFragmentDelegate", "A splash screen was provided to Flutter, but this is deprecated. See flutter.dev/go/android-splash-migration for migration steps.");
        FlutterSplashView flutterSplashView = new FlutterSplashView(this.f201a.getContext());
        flutterSplashView.setId(z.h.d(486947586));
        flutterSplashView.g(this.f203c, z3);
        return flutterSplashView;
    }

    void s() {
        j.b.f("FlutterActivityAndFragmentDelegate", "onDestroyView()");
        i();
        if (this.f205e != null) {
            this.f203c.getViewTreeObserver().removeOnPreDrawListener(this.f205e);
            this.f205e = null;
        }
        this.f203c.s();
        this.f203c.z(this.f211k);
    }

    void t() {
        j.b.f("FlutterActivityAndFragmentDelegate", "onDetach()");
        i();
        this.f201a.y(this.f202b);
        if (this.f201a.n()) {
            j.b.f("FlutterActivityAndFragmentDelegate", "Detaching FlutterEngine from the Activity that owns this Fragment.");
            if (this.f201a.f().isChangingConfigurations()) {
                this.f202b.g().i();
            } else {
                this.f202b.g().h();
            }
        }
        io.flutter.plugin.platform.c cVar = this.f204d;
        if (cVar != null) {
            cVar.o();
            this.f204d = null;
        }
        if (this.f201a.s()) {
            this.f202b.i().a();
        }
        if (this.f201a.p()) {
            this.f202b.e();
            if (this.f201a.u() != null) {
                io.flutter.embedding.engine.b.b().d(this.f201a.u());
            }
            this.f202b = null;
        }
        this.f209i = false;
    }

    void u(Intent intent) {
        i();
        if (this.f202b == null) {
            j.b.g("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        j.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine and sending pushRoute message.");
        this.f202b.g().d(intent);
        String n2 = n(intent);
        if (n2 == null || n2.isEmpty()) {
            return;
        }
        this.f202b.l().b(n2);
    }

    void v() {
        j.b.f("FlutterActivityAndFragmentDelegate", "onPause()");
        i();
        if (this.f201a.s()) {
            this.f202b.i().b();
        }
    }

    void w() {
        j.b.f("FlutterActivityAndFragmentDelegate", "onPostResume()");
        i();
        if (this.f202b != null) {
            H();
        } else {
            j.b.g("FlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    void x(int i2, String[] strArr, int[] iArr) {
        i();
        if (this.f202b == null) {
            j.b.g("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        j.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i2 + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
        this.f202b.g().b(i2, strArr, iArr);
    }

    void y(Bundle bundle) {
        Bundle bundle2;
        j.b.f("FlutterActivityAndFragmentDelegate", "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
        i();
        byte[] bArr = null;
        if (bundle != null) {
            Bundle bundle3 = bundle.getBundle("plugins");
            bArr = bundle.getByteArray("framework");
            bundle2 = bundle3;
        } else {
            bundle2 = null;
        }
        if (this.f201a.w()) {
            this.f202b.p().j(bArr);
        }
        if (this.f201a.n()) {
            this.f202b.g().a(bundle2);
        }
    }

    void z() {
        j.b.f("FlutterActivityAndFragmentDelegate", "onResume()");
        i();
        if (this.f201a.s()) {
            this.f202b.i().d();
        }
    }
}
