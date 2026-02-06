package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import o.a;
import p.c;
import w.k;
import w.l;
import w.m;
import w.n;

/* loaded from: classes.dex */
class c implements p.b {

    /* renamed from: b, reason: collision with root package name */
    private final io.flutter.embedding.engine.a f365b;

    /* renamed from: c, reason: collision with root package name */
    private final a.b f366c;

    /* renamed from: e, reason: collision with root package name */
    private io.flutter.embedding.android.c<Activity> f368e;

    /* renamed from: f, reason: collision with root package name */
    private C0011c f369f;

    /* renamed from: i, reason: collision with root package name */
    private Service f372i;

    /* renamed from: k, reason: collision with root package name */
    private BroadcastReceiver f374k;

    /* renamed from: m, reason: collision with root package name */
    private ContentProvider f376m;

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<? extends o.a>, o.a> f364a = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map<Class<? extends o.a>, p.a> f367d = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private boolean f370g = false;

    /* renamed from: h, reason: collision with root package name */
    private final Map<Class<? extends o.a>, s.a> f371h = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private final Map<Class<? extends o.a>, q.a> f373j = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    private final Map<Class<? extends o.a>, r.a> f375l = new HashMap();

    private static class b implements a.InterfaceC0023a {

        /* renamed from: a, reason: collision with root package name */
        final m.d f377a;

        private b(m.d dVar) {
            this.f377a = dVar;
        }
    }

    /* renamed from: io.flutter.embedding.engine.c$c, reason: collision with other inner class name */
    private static class C0011c implements p.c {

        /* renamed from: a, reason: collision with root package name */
        private final Activity f378a;

        /* renamed from: b, reason: collision with root package name */
        private final HiddenLifecycleReference f379b;

        /* renamed from: c, reason: collision with root package name */
        private final Set<m> f380c = new HashSet();

        /* renamed from: d, reason: collision with root package name */
        private final Set<k> f381d = new HashSet();

        /* renamed from: e, reason: collision with root package name */
        private final Set<l> f382e = new HashSet();

        /* renamed from: f, reason: collision with root package name */
        private final Set<n> f383f = new HashSet();

        /* renamed from: g, reason: collision with root package name */
        private final Set<c.a> f384g = new HashSet();

        public C0011c(Activity activity, androidx.lifecycle.c cVar) {
            this.f378a = activity;
            this.f379b = new HiddenLifecycleReference(cVar);
        }

        boolean a(int i2, int i3, Intent intent) {
            boolean z2;
            Iterator it = new HashSet(this.f381d).iterator();
            while (true) {
                while (it.hasNext()) {
                    z2 = ((k) it.next()).c(i2, i3, intent) || z2;
                }
                return z2;
            }
        }

        void b(Intent intent) {
            Iterator<l> it = this.f382e.iterator();
            while (it.hasNext()) {
                it.next().d(intent);
            }
        }

        boolean c(int i2, String[] strArr, int[] iArr) {
            boolean z2;
            Iterator<m> it = this.f380c.iterator();
            while (true) {
                while (it.hasNext()) {
                    z2 = it.next().b(i2, strArr, iArr) || z2;
                }
                return z2;
            }
        }

        void d(Bundle bundle) {
            Iterator<c.a> it = this.f384g.iterator();
            while (it.hasNext()) {
                it.next().a(bundle);
            }
        }

        void e(Bundle bundle) {
            Iterator<c.a> it = this.f384g.iterator();
            while (it.hasNext()) {
                it.next().e(bundle);
            }
        }

        void f() {
            Iterator<n> it = this.f383f.iterator();
            while (it.hasNext()) {
                it.next().f();
            }
        }
    }

    c(Context context, io.flutter.embedding.engine.a aVar, m.d dVar) {
        this.f365b = aVar;
        this.f366c = new a.b(context, aVar, aVar.h(), aVar.o(), aVar.n().P(), new b(dVar));
    }

    private void j(Activity activity, androidx.lifecycle.c cVar) {
        this.f369f = new C0011c(activity, cVar);
        this.f365b.n().h0(activity.getIntent() != null ? activity.getIntent().getBooleanExtra("enable-software-rendering", false) : false);
        this.f365b.n().B(activity, this.f365b.o(), this.f365b.h());
        for (p.a aVar : this.f367d.values()) {
            if (this.f370g) {
                aVar.b(this.f369f);
            } else {
                aVar.c(this.f369f);
            }
        }
        this.f370g = false;
    }

    private void l() {
        this.f365b.n().J();
        this.f368e = null;
        this.f369f = null;
    }

    private void m() {
        if (q()) {
            h();
            return;
        }
        if (t()) {
            p();
        } else if (r()) {
            n();
        } else if (s()) {
            o();
        }
    }

    private boolean q() {
        return this.f368e != null;
    }

    private boolean r() {
        return this.f374k != null;
    }

    private boolean s() {
        return this.f376m != null;
    }

    private boolean t() {
        return this.f372i != null;
    }

    @Override // p.b
    public void a(Bundle bundle) {
        if (!q()) {
            j.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRestoreInstanceState, but no Activity was attached.");
            return;
        }
        z.e.a("FlutterEngineConnectionRegistry#onRestoreInstanceState");
        try {
            this.f369f.d(bundle);
        } finally {
            z.e.d();
        }
    }

    @Override // p.b
    public boolean b(int i2, String[] strArr, int[] iArr) {
        if (!q()) {
            j.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
            return false;
        }
        z.e.a("FlutterEngineConnectionRegistry#onRequestPermissionsResult");
        try {
            return this.f369f.c(i2, strArr, iArr);
        } finally {
            z.e.d();
        }
    }

    @Override // p.b
    public boolean c(int i2, int i3, Intent intent) {
        if (!q()) {
            j.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
            return false;
        }
        z.e.a("FlutterEngineConnectionRegistry#onActivityResult");
        try {
            return this.f369f.a(i2, i3, intent);
        } finally {
            z.e.d();
        }
    }

    @Override // p.b
    public void d(Intent intent) {
        if (!q()) {
            j.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
            return;
        }
        z.e.a("FlutterEngineConnectionRegistry#onNewIntent");
        try {
            this.f369f.b(intent);
        } finally {
            z.e.d();
        }
    }

    @Override // p.b
    public void e(Bundle bundle) {
        if (!q()) {
            j.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
            return;
        }
        z.e.a("FlutterEngineConnectionRegistry#onSaveInstanceState");
        try {
            this.f369f.e(bundle);
        } finally {
            z.e.d();
        }
    }

    @Override // p.b
    public void f() {
        if (!q()) {
            j.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
            return;
        }
        z.e.a("FlutterEngineConnectionRegistry#onUserLeaveHint");
        try {
            this.f369f.f();
        } finally {
            z.e.d();
        }
    }

    @Override // p.b
    public void g(io.flutter.embedding.android.c<Activity> cVar, androidx.lifecycle.c cVar2) {
        z.e.a("FlutterEngineConnectionRegistry#attachToActivity");
        try {
            io.flutter.embedding.android.c<Activity> cVar3 = this.f368e;
            if (cVar3 != null) {
                cVar3.a();
            }
            m();
            this.f368e = cVar;
            j(cVar.b(), cVar2);
        } finally {
            z.e.d();
        }
    }

    @Override // p.b
    public void h() {
        if (!q()) {
            j.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            return;
        }
        z.e.a("FlutterEngineConnectionRegistry#detachFromActivity");
        try {
            Iterator<p.a> it = this.f367d.values().iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            l();
        } finally {
            z.e.d();
        }
    }

    @Override // p.b
    public void i() {
        if (!q()) {
            j.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            return;
        }
        z.e.a("FlutterEngineConnectionRegistry#detachFromActivityForConfigChanges");
        try {
            this.f370g = true;
            Iterator<p.a> it = this.f367d.values().iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            l();
        } finally {
            z.e.d();
        }
    }

    public void k() {
        j.b.f("FlutterEngineCxnRegstry", "Destroying.");
        m();
        w();
    }

    public void n() {
        if (!r()) {
            j.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a BroadcastReceiver when no BroadcastReceiver was attached.");
            return;
        }
        z.e.a("FlutterEngineConnectionRegistry#detachFromBroadcastReceiver");
        try {
            Iterator<q.a> it = this.f373j.values().iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        } finally {
            z.e.d();
        }
    }

    public void o() {
        if (!s()) {
            j.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a ContentProvider when no ContentProvider was attached.");
            return;
        }
        z.e.a("FlutterEngineConnectionRegistry#detachFromContentProvider");
        try {
            Iterator<r.a> it = this.f375l.values().iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        } finally {
            z.e.d();
        }
    }

    public void p() {
        if (!t()) {
            j.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a Service when no Service was attached.");
            return;
        }
        z.e.a("FlutterEngineConnectionRegistry#detachFromService");
        try {
            Iterator<s.a> it = this.f371h.values().iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f372i = null;
        } finally {
            z.e.d();
        }
    }

    public void u(Class<? extends o.a> cls) {
        o.a aVar = this.f364a.get(cls);
        if (aVar == null) {
            return;
        }
        z.e.a("FlutterEngineConnectionRegistry#remove " + cls.getSimpleName());
        try {
            if (aVar instanceof p.a) {
                if (q()) {
                    ((p.a) aVar).a();
                }
                this.f367d.remove(cls);
            }
            if (aVar instanceof s.a) {
                if (t()) {
                    ((s.a) aVar).a();
                }
                this.f371h.remove(cls);
            }
            if (aVar instanceof q.a) {
                if (r()) {
                    ((q.a) aVar).a();
                }
                this.f373j.remove(cls);
            }
            if (aVar instanceof r.a) {
                if (s()) {
                    ((r.a) aVar).a();
                }
                this.f375l.remove(cls);
            }
            aVar.a(this.f366c);
            this.f364a.remove(cls);
        } finally {
            z.e.d();
        }
    }

    public void v(Set<Class<? extends o.a>> set) {
        Iterator<Class<? extends o.a>> it = set.iterator();
        while (it.hasNext()) {
            u(it.next());
        }
    }

    public void w() {
        v(new HashSet(this.f364a.keySet()));
        this.f364a.clear();
    }
}
