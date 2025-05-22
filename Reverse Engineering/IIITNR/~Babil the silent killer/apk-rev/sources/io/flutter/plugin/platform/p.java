package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.flutter.embedding.android.u;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.plugin.platform.p;
import io.flutter.view.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import v.k;

/* loaded from: classes.dex */
public class p implements j {

    /* renamed from: w, reason: collision with root package name */
    private static Class[] f527w = {SurfaceView.class};

    /* renamed from: b, reason: collision with root package name */
    private io.flutter.embedding.android.a f529b;

    /* renamed from: c, reason: collision with root package name */
    private Context f530c;

    /* renamed from: d, reason: collision with root package name */
    private io.flutter.embedding.android.k f531d;

    /* renamed from: e, reason: collision with root package name */
    private io.flutter.view.d f532e;

    /* renamed from: f, reason: collision with root package name */
    private io.flutter.plugin.editing.f f533f;

    /* renamed from: g, reason: collision with root package name */
    private v.k f534g;

    /* renamed from: o, reason: collision with root package name */
    private int f542o = 0;

    /* renamed from: p, reason: collision with root package name */
    private boolean f543p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f544q = true;

    /* renamed from: u, reason: collision with root package name */
    private boolean f548u = false;

    /* renamed from: v, reason: collision with root package name */
    private final k.g f549v = new a();

    /* renamed from: a, reason: collision with root package name */
    private final h f528a = new h();

    /* renamed from: i, reason: collision with root package name */
    final HashMap<Integer, q> f536i = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private final io.flutter.plugin.platform.a f535h = new io.flutter.plugin.platform.a();

    /* renamed from: j, reason: collision with root package name */
    final HashMap<Context, View> f537j = new HashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private final SparseArray<b> f540m = new SparseArray<>();

    /* renamed from: r, reason: collision with root package name */
    private final HashSet<Integer> f545r = new HashSet<>();

    /* renamed from: s, reason: collision with root package name */
    private final HashSet<Integer> f546s = new HashSet<>();

    /* renamed from: n, reason: collision with root package name */
    private final SparseArray<i> f541n = new SparseArray<>();

    /* renamed from: k, reason: collision with root package name */
    private final SparseArray<e> f538k = new SparseArray<>();

    /* renamed from: l, reason: collision with root package name */
    private final SparseArray<n.a> f539l = new SparseArray<>();

    /* renamed from: t, reason: collision with root package name */
    private final u f547t = u.a();

    class a implements k.g {
        a() {
        }

        private void m(e eVar, k.d dVar) {
            j.b.e("PlatformViewsController", "Using hybrid composition for platform view: " + dVar.f1283a);
        }

        @TargetApi(23)
        private long n(e eVar, final k.d dVar) {
            i iVar;
            long j2;
            q(23);
            j.b.e("PlatformViewsController", "Hosting view in view hierarchy for platform view: " + dVar.f1283a);
            int l02 = p.this.l0(dVar.f1285c);
            int l03 = p.this.l0(dVar.f1286d);
            if (p.this.f548u) {
                iVar = new i(p.this.f530c);
                j2 = -1;
            } else {
                d.c a2 = p.this.f532e.a();
                i iVar2 = new i(p.this.f530c, a2);
                long b2 = a2.b();
                iVar = iVar2;
                j2 = b2;
            }
            iVar.m(p.this.f529b);
            iVar.i(l02, l03);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l02, l03);
            int l04 = p.this.l0(dVar.f1287e);
            int l05 = p.this.l0(dVar.f1288f);
            layoutParams.topMargin = l04;
            layoutParams.leftMargin = l05;
            iVar.j(layoutParams);
            View g2 = eVar.g();
            g2.setLayoutParams(new FrameLayout.LayoutParams(l02, l03));
            g2.setImportantForAccessibility(4);
            iVar.addView(g2);
            iVar.k(new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.m
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z2) {
                    p.a.this.s(dVar, view, z2);
                }
            });
            p.this.f531d.addView(iVar);
            p.this.f541n.append(dVar.f1283a, iVar);
            return j2;
        }

        private long o(e eVar, final k.d dVar) {
            q(20);
            j.b.e("PlatformViewsController", "Hosting view in a virtual display for platform view: " + dVar.f1283a);
            d.c a2 = p.this.f532e.a();
            q a3 = q.a(p.this.f530c, p.this.f535h, eVar, a2, p.this.l0(dVar.f1285c), p.this.l0(dVar.f1286d), dVar.f1283a, null, new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.n
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z2) {
                    p.a.this.t(dVar, view, z2);
                }
            });
            if (a3 != null) {
                if (p.this.f531d != null) {
                    a3.f(p.this.f531d);
                }
                p.this.f536i.put(Integer.valueOf(dVar.f1283a), a3);
                View g2 = eVar.g();
                p.this.f537j.put(g2.getContext(), g2);
                return a2.b();
            }
            throw new IllegalStateException("Failed creating virtual display for a " + dVar.f1284b + " with id: " + dVar.f1283a);
        }

        @TargetApi(19)
        private e p(k.d dVar, boolean z2) {
            f a2 = p.this.f528a.a(dVar.f1284b);
            if (a2 == null) {
                throw new IllegalStateException("Trying to create a platform view of unregistered type: " + dVar.f1284b);
            }
            e a3 = a2.a(z2 ? new MutableContextWrapper(p.this.f530c) : p.this.f530c, dVar.f1283a, dVar.f1291i != null ? a2.b().a(dVar.f1291i) : null);
            View g2 = a3.g();
            if (g2 == null) {
                throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
            }
            g2.setLayoutDirection(dVar.f1289g);
            p.this.f538k.put(dVar.f1283a, a3);
            return a3;
        }

        private void q(int i2) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= i2) {
                return;
            }
            throw new IllegalStateException("Trying to use platform views with API " + i3 + ", required API level is: " + i2);
        }

        private void r(k.d dVar) {
            if (p.n0(dVar.f1289g)) {
                return;
            }
            throw new IllegalStateException("Trying to create a view with unknown direction value: " + dVar.f1289g + "(view id: " + dVar.f1283a + ")");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(k.d dVar, View view, boolean z2) {
            p pVar = p.this;
            if (z2) {
                pVar.f534g.d(dVar.f1283a);
            } else if (pVar.f533f != null) {
                p.this.f533f.l(dVar.f1283a);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(k.d dVar, View view, boolean z2) {
            if (z2) {
                p.this.f534g.d(dVar.f1283a);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(q qVar, float f2, k.b bVar) {
            p.this.m0(qVar);
            if (p.this.f530c != null) {
                f2 = p.this.O();
            }
            bVar.a(new k.c(p.this.j0(qVar.d(), f2), p.this.j0(qVar.c(), f2)));
        }

        @Override // v.k.g
        public void a(int i2) {
            View g2;
            StringBuilder sb;
            String str;
            if (p.this.d(i2)) {
                g2 = p.this.f536i.get(Integer.valueOf(i2)).e();
            } else {
                e eVar = (e) p.this.f538k.get(i2);
                if (eVar == null) {
                    sb = new StringBuilder();
                    str = "Clearing focus on an unknown view with id: ";
                    sb.append(str);
                    sb.append(i2);
                    j.b.b("PlatformViewsController", sb.toString());
                }
                g2 = eVar.g();
            }
            if (g2 != null) {
                g2.clearFocus();
                return;
            }
            sb = new StringBuilder();
            str = "Clearing focus on a null view with id: ";
            sb.append(str);
            sb.append(i2);
            j.b.b("PlatformViewsController", sb.toString());
        }

        @Override // v.k.g
        public void b(k.f fVar) {
            int i2 = fVar.f1299a;
            float f2 = p.this.f530c.getResources().getDisplayMetrics().density;
            if (p.this.d(i2)) {
                p.this.f536i.get(Integer.valueOf(i2)).b(p.this.k0(f2, fVar, true));
                return;
            }
            e eVar = (e) p.this.f538k.get(i2);
            if (eVar == null) {
                j.b.b("PlatformViewsController", "Sending touch to an unknown view with id: " + i2);
                return;
            }
            View g2 = eVar.g();
            if (g2 != null) {
                g2.dispatchTouchEvent(p.this.k0(f2, fVar, false));
                return;
            }
            j.b.b("PlatformViewsController", "Sending touch to a null view with id: " + i2);
        }

        @Override // v.k.g
        public void c(k.e eVar, final k.b bVar) {
            int l02 = p.this.l0(eVar.f1297b);
            int l03 = p.this.l0(eVar.f1298c);
            int i2 = eVar.f1296a;
            if (p.this.d(i2)) {
                final float O = p.this.O();
                final q qVar = p.this.f536i.get(Integer.valueOf(i2));
                p.this.U(qVar);
                qVar.i(l02, l03, new Runnable() { // from class: io.flutter.plugin.platform.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        p.a.this.u(qVar, O, bVar);
                    }
                });
                return;
            }
            e eVar2 = (e) p.this.f538k.get(i2);
            i iVar = (i) p.this.f541n.get(i2);
            if (eVar2 == null || iVar == null) {
                j.b.b("PlatformViewsController", "Resizing unknown platform view with id: " + i2);
                return;
            }
            if (l02 > iVar.e() || l03 > iVar.d()) {
                iVar.i(l02, l03);
            }
            ViewGroup.LayoutParams layoutParams = iVar.getLayoutParams();
            layoutParams.width = l02;
            layoutParams.height = l03;
            iVar.setLayoutParams(layoutParams);
            View g2 = eVar2.g();
            if (g2 != null) {
                ViewGroup.LayoutParams layoutParams2 = g2.getLayoutParams();
                layoutParams2.width = l02;
                layoutParams2.height = l03;
                g2.setLayoutParams(layoutParams2);
            }
            bVar.a(new k.c(p.this.i0(iVar.e()), p.this.i0(iVar.d())));
        }

        @Override // v.k.g
        public void d(int i2) {
            e eVar = (e) p.this.f538k.get(i2);
            if (eVar == null) {
                j.b.b("PlatformViewsController", "Disposing unknown platform view with id: " + i2);
                return;
            }
            p.this.f538k.remove(i2);
            try {
                eVar.b();
            } catch (RuntimeException e2) {
                j.b.c("PlatformViewsController", "Disposing platform view threw an exception", e2);
            }
            if (p.this.d(i2)) {
                View e3 = p.this.f536i.get(Integer.valueOf(i2)).e();
                if (e3 != null) {
                    p.this.f537j.remove(e3.getContext());
                }
                p.this.f536i.remove(Integer.valueOf(i2));
                return;
            }
            i iVar = (i) p.this.f541n.get(i2);
            if (iVar != null) {
                iVar.removeAllViews();
                iVar.h();
                iVar.o();
                ViewGroup viewGroup = (ViewGroup) iVar.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(iVar);
                }
                p.this.f541n.remove(i2);
                return;
            }
            n.a aVar = (n.a) p.this.f539l.get(i2);
            if (aVar != null) {
                aVar.removeAllViews();
                aVar.b();
                ViewGroup viewGroup2 = (ViewGroup) aVar.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(aVar);
                }
                p.this.f539l.remove(i2);
            }
        }

        @Override // v.k.g
        public void e(boolean z2) {
            p.this.f544q = z2;
        }

        @Override // v.k.g
        public void f(int i2, double d2, double d3) {
            if (p.this.d(i2)) {
                return;
            }
            i iVar = (i) p.this.f541n.get(i2);
            if (iVar == null) {
                j.b.b("PlatformViewsController", "Setting offset for unknown platform view with id: " + i2);
                return;
            }
            int l02 = p.this.l0(d2);
            int l03 = p.this.l0(d3);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) iVar.getLayoutParams();
            layoutParams.topMargin = l02;
            layoutParams.leftMargin = l03;
            iVar.j(layoutParams);
        }

        @Override // v.k.g
        @TargetApi(20)
        public long g(k.d dVar) {
            r(dVar);
            int i2 = dVar.f1283a;
            if (p.this.f541n.get(i2) != null) {
                throw new IllegalStateException("Trying to create an already created platform view, view id: " + i2);
            }
            if (p.this.f532e == null) {
                throw new IllegalStateException("Texture registry is null. This means that platform views controller was detached, view id: " + i2);
            }
            if (p.this.f531d == null) {
                throw new IllegalStateException("Flutter view is null. This means the platform views controller doesn't have an attached view, view id: " + i2);
            }
            e p2 = p(dVar, true);
            View g2 = p2.g();
            if (g2.getParent() != null) {
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            }
            if (!(Build.VERSION.SDK_INT >= 23 && !z.h.f(g2, p.f527w))) {
                if (dVar.f1290h == k.d.a.TEXTURE_WITH_HYBRID_FALLBACK) {
                    m(p2, dVar);
                    return -2L;
                }
                if (!p.this.f548u) {
                    return o(p2, dVar);
                }
            }
            return n(p2, dVar);
        }

        @Override // v.k.g
        @TargetApi(17)
        public void h(int i2, int i3) {
            View g2;
            StringBuilder sb;
            String str;
            if (!p.n0(i3)) {
                throw new IllegalStateException("Trying to set unknown direction value: " + i3 + "(view id: " + i2 + ")");
            }
            if (p.this.d(i2)) {
                g2 = p.this.f536i.get(Integer.valueOf(i2)).e();
            } else {
                e eVar = (e) p.this.f538k.get(i2);
                if (eVar == null) {
                    sb = new StringBuilder();
                    str = "Setting direction to an unknown view with id: ";
                    sb.append(str);
                    sb.append(i2);
                    j.b.b("PlatformViewsController", sb.toString());
                }
                g2 = eVar.g();
            }
            if (g2 != null) {
                g2.setLayoutDirection(i3);
                return;
            }
            sb = new StringBuilder();
            str = "Setting direction to a null view with id: ";
            sb.append(str);
            sb.append(i2);
            j.b.b("PlatformViewsController", sb.toString());
        }

        @Override // v.k.g
        @TargetApi(19)
        public void i(k.d dVar) {
            q(19);
            r(dVar);
            m(p(dVar, false), dVar);
        }
    }

    private void M() {
        while (this.f538k.size() > 0) {
            this.f549v.d(this.f538k.keyAt(0));
        }
    }

    private void N(boolean z2) {
        for (int i2 = 0; i2 < this.f540m.size(); i2++) {
            int keyAt = this.f540m.keyAt(i2);
            b valueAt = this.f540m.valueAt(i2);
            if (this.f545r.contains(Integer.valueOf(keyAt))) {
                this.f531d.m(valueAt);
                z2 &= valueAt.d();
            } else {
                if (!this.f543p) {
                    valueAt.c();
                }
                valueAt.setVisibility(8);
            }
        }
        for (int i3 = 0; i3 < this.f539l.size(); i3++) {
            int keyAt2 = this.f539l.keyAt(i3);
            n.a aVar = this.f539l.get(keyAt2);
            if (!this.f546s.contains(Integer.valueOf(keyAt2)) || (!z2 && this.f544q)) {
                aVar.setVisibility(8);
            } else {
                aVar.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float O() {
        return this.f530c.getResources().getDisplayMetrics().density;
    }

    private void R() {
        if (!this.f544q || this.f543p) {
            return;
        }
        this.f531d.p();
        this.f543p = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(int i2, View view, boolean z2) {
        if (z2) {
            this.f534g.d(i2);
            return;
        }
        io.flutter.plugin.editing.f fVar = this.f533f;
        if (fVar != null) {
            fVar.l(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T() {
        N(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(q qVar) {
        io.flutter.plugin.editing.f fVar = this.f533f;
        if (fVar == null) {
            return;
        }
        fVar.u();
        qVar.g();
    }

    private static MotionEvent.PointerCoords c0(Object obj, float f2) {
        List list = (List) obj;
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.orientation = (float) ((Double) list.get(0)).doubleValue();
        pointerCoords.pressure = (float) ((Double) list.get(1)).doubleValue();
        pointerCoords.size = (float) ((Double) list.get(2)).doubleValue();
        pointerCoords.toolMajor = ((float) ((Double) list.get(3)).doubleValue()) * f2;
        pointerCoords.toolMinor = ((float) ((Double) list.get(4)).doubleValue()) * f2;
        pointerCoords.touchMajor = ((float) ((Double) list.get(5)).doubleValue()) * f2;
        pointerCoords.touchMinor = ((float) ((Double) list.get(6)).doubleValue()) * f2;
        pointerCoords.x = ((float) ((Double) list.get(7)).doubleValue()) * f2;
        pointerCoords.y = ((float) ((Double) list.get(8)).doubleValue()) * f2;
        return pointerCoords;
    }

    private static List<MotionEvent.PointerCoords> d0(Object obj, float f2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(c0(it.next(), f2));
        }
        return arrayList;
    }

    private static MotionEvent.PointerProperties e0(Object obj) {
        List list = (List) obj;
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = ((Integer) list.get(0)).intValue();
        pointerProperties.toolType = ((Integer) list.get(1)).intValue();
        return pointerProperties;
    }

    private static List<MotionEvent.PointerProperties> f0(Object obj) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(e0(it.next()));
        }
        return arrayList;
    }

    private void g0() {
        if (this.f531d == null) {
            j.b.b("PlatformViewsController", "removeOverlaySurfaces called while flutter view is null");
            return;
        }
        for (int i2 = 0; i2 < this.f540m.size(); i2++) {
            this.f531d.removeView(this.f540m.valueAt(i2));
        }
        this.f540m.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int i0(double d2) {
        return j0(d2, O());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int j0(double d2, float f2) {
        double d3 = f2;
        Double.isNaN(d3);
        return (int) Math.round(d2 / d3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l0(double d2) {
        double O = O();
        Double.isNaN(O);
        return (int) Math.round(d2 * O);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(q qVar) {
        io.flutter.plugin.editing.f fVar = this.f533f;
        if (fVar == null) {
            return;
        }
        fVar.G();
        qVar.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n0(int i2) {
        return i2 == 0 || i2 == 1;
    }

    public void B(Context context, io.flutter.view.d dVar, k.a aVar) {
        if (this.f530c != null) {
            throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
        }
        this.f530c = context;
        this.f532e = dVar;
        v.k kVar = new v.k(aVar);
        this.f534g = kVar;
        kVar.e(this.f549v);
    }

    public void C(io.flutter.plugin.editing.f fVar) {
        this.f533f = fVar;
    }

    public void D(u.a aVar) {
        this.f529b = new io.flutter.embedding.android.a(aVar, true);
    }

    public void E(io.flutter.embedding.android.k kVar) {
        this.f531d = kVar;
        for (int i2 = 0; i2 < this.f541n.size(); i2++) {
            this.f531d.addView(this.f541n.valueAt(i2));
        }
        for (int i3 = 0; i3 < this.f539l.size(); i3++) {
            this.f531d.addView(this.f539l.valueAt(i3));
        }
        for (int i4 = 0; i4 < this.f538k.size(); i4++) {
            this.f538k.valueAt(i4).e(this.f531d);
        }
    }

    public boolean F(View view) {
        if (view == null || !this.f537j.containsKey(view.getContext())) {
            return false;
        }
        View view2 = this.f537j.get(view.getContext());
        if (view2 == view) {
            return true;
        }
        return view2.checkInputConnectionProxy(view);
    }

    @TargetApi(19)
    public FlutterOverlaySurface G() {
        return H(new b(this.f531d.getContext(), this.f531d.getWidth(), this.f531d.getHeight(), this.f535h));
    }

    @TargetApi(19)
    public FlutterOverlaySurface H(b bVar) {
        int i2 = this.f542o;
        this.f542o = i2 + 1;
        this.f540m.put(i2, bVar);
        return new FlutterOverlaySurface(i2, bVar.getSurface());
    }

    public void I() {
        for (int i2 = 0; i2 < this.f540m.size(); i2++) {
            b valueAt = this.f540m.valueAt(i2);
            valueAt.c();
            valueAt.f();
        }
    }

    public void J() {
        v.k kVar = this.f534g;
        if (kVar != null) {
            kVar.e(null);
        }
        I();
        this.f534g = null;
        this.f530c = null;
        this.f532e = null;
    }

    public void K() {
        for (int i2 = 0; i2 < this.f541n.size(); i2++) {
            this.f531d.removeView(this.f541n.valueAt(i2));
        }
        for (int i3 = 0; i3 < this.f539l.size(); i3++) {
            this.f531d.removeView(this.f539l.valueAt(i3));
        }
        I();
        g0();
        this.f531d = null;
        this.f543p = false;
        for (int i4 = 0; i4 < this.f538k.size(); i4++) {
            this.f538k.valueAt(i4).f();
        }
    }

    public void L() {
        this.f533f = null;
    }

    public g P() {
        return this.f528a;
    }

    @TargetApi(19)
    void Q(final int i2) {
        e eVar = this.f538k.get(i2);
        if (eVar == null) {
            throw new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
        }
        if (this.f539l.get(i2) != null) {
            return;
        }
        View g2 = eVar.g();
        if (g2 == null) {
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        if (g2.getParent() != null) {
            throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
        }
        Context context = this.f530c;
        n.a aVar = new n.a(context, context.getResources().getDisplayMetrics().density, this.f529b);
        aVar.setOnDescendantFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.k
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z2) {
                p.this.S(i2, view, z2);
            }
        });
        this.f539l.put(i2, aVar);
        g2.setImportantForAccessibility(4);
        aVar.addView(g2);
        this.f531d.addView(aVar);
    }

    public void V() {
    }

    public void W() {
        this.f545r.clear();
        this.f546s.clear();
    }

    public void X() {
        M();
    }

    public void Y(int i2, int i3, int i4, int i5, int i6) {
        if (this.f540m.get(i2) == null) {
            throw new IllegalStateException("The overlay surface (id:" + i2 + ") doesn't exist");
        }
        R();
        b bVar = this.f540m.get(i2);
        if (bVar.getParent() == null) {
            this.f531d.addView(bVar);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i6);
        layoutParams.leftMargin = i3;
        layoutParams.topMargin = i4;
        bVar.setLayoutParams(layoutParams);
        bVar.setVisibility(0);
        bVar.bringToFront();
        this.f545r.add(Integer.valueOf(i2));
    }

    public void Z(int i2, int i3, int i4, int i5, int i6, int i7, int i8, FlutterMutatorsStack flutterMutatorsStack) {
        R();
        Q(i2);
        n.a aVar = this.f539l.get(i2);
        aVar.a(flutterMutatorsStack, i3, i4, i5, i6);
        aVar.setVisibility(0);
        aVar.bringToFront();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i7, i8);
        View g2 = this.f538k.get(i2).g();
        if (g2 != null) {
            g2.setLayoutParams(layoutParams);
            g2.bringToFront();
        }
        this.f546s.add(Integer.valueOf(i2));
    }

    @Override // io.flutter.plugin.platform.j
    public void a() {
        this.f535h.c(null);
    }

    public void a0() {
        boolean z2 = false;
        if (this.f543p && this.f546s.isEmpty()) {
            this.f543p = false;
            this.f531d.B(new Runnable() { // from class: io.flutter.plugin.platform.l
                @Override // java.lang.Runnable
                public final void run() {
                    p.this.T();
                }
            });
        } else {
            if (this.f543p && this.f531d.j()) {
                z2 = true;
            }
            N(z2);
        }
    }

    @Override // io.flutter.plugin.platform.j
    public void b(io.flutter.view.c cVar) {
        this.f535h.c(cVar);
    }

    public void b0() {
        M();
    }

    @Override // io.flutter.plugin.platform.j
    public View c(int i2) {
        if (d(i2)) {
            return this.f536i.get(Integer.valueOf(i2)).e();
        }
        e eVar = this.f538k.get(i2);
        if (eVar == null) {
            return null;
        }
        return eVar.g();
    }

    @Override // io.flutter.plugin.platform.j
    public boolean d(int i2) {
        return this.f536i.containsKey(Integer.valueOf(i2));
    }

    public void h0(boolean z2) {
        this.f548u = z2;
    }

    public MotionEvent k0(float f2, k.f fVar, boolean z2) {
        MotionEvent b2 = this.f547t.b(u.a.c(fVar.f1314p));
        MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) f0(fVar.f1304f).toArray(new MotionEvent.PointerProperties[fVar.f1303e]);
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) d0(fVar.f1305g, f2).toArray(new MotionEvent.PointerCoords[fVar.f1303e]);
        return (z2 || b2 == null) ? MotionEvent.obtain(fVar.f1300b.longValue(), fVar.f1301c.longValue(), fVar.f1302d, fVar.f1303e, pointerPropertiesArr, pointerCoordsArr, fVar.f1306h, fVar.f1307i, fVar.f1308j, fVar.f1309k, fVar.f1310l, fVar.f1311m, fVar.f1312n, fVar.f1313o) : MotionEvent.obtain(b2.getDownTime(), b2.getEventTime(), fVar.f1302d, fVar.f1303e, pointerPropertiesArr, pointerCoordsArr, b2.getMetaState(), b2.getButtonState(), b2.getXPrecision(), b2.getYPrecision(), b2.getDeviceId(), b2.getEdgeFlags(), b2.getSource(), b2.getFlags());
    }
}
