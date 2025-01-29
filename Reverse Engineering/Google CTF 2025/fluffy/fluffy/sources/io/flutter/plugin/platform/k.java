package io.flutter.plugin.platform;

import D.C0012m;
import D.v;
import D.y;
import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class k implements h {

    /* renamed from: b, reason: collision with root package name */
    public Activity f719b;

    /* renamed from: c, reason: collision with root package name */
    public y f720c;

    /* renamed from: d, reason: collision with root package name */
    public io.flutter.embedding.engine.renderer.j f721d;

    /* renamed from: e, reason: collision with root package name */
    public io.flutter.plugin.editing.k f722e;

    /* renamed from: f, reason: collision with root package name */
    public v f723f;

    /* renamed from: s, reason: collision with root package name */
    public final B.a f735s;

    /* renamed from: n, reason: collision with root package name */
    public int f730n = 0;

    /* renamed from: o, reason: collision with root package name */
    public boolean f731o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f732p = true;

    /* renamed from: t, reason: collision with root package name */
    public final v f736t = new v(29, this);

    /* renamed from: a, reason: collision with root package name */
    public final E.i f718a = new E.i(2);

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f725h = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final a f724g = new a();

    /* renamed from: i, reason: collision with root package name */
    public final HashMap f726i = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    public final SparseArray f729l = new SparseArray();

    /* renamed from: q, reason: collision with root package name */
    public final HashSet f733q = new HashSet();

    /* renamed from: r, reason: collision with root package name */
    public final HashSet f734r = new HashSet();
    public final SparseArray m = new SparseArray();

    /* renamed from: j, reason: collision with root package name */
    public final SparseArray f727j = new SparseArray();

    /* renamed from: k, reason: collision with root package name */
    public final SparseArray f728k = new SparseArray();

    public k() {
        if (B.a.f1f == null) {
            B.a.f1f = new B.a(3);
        }
        this.f735s = B.a.f1f;
    }

    @Override // io.flutter.plugin.platform.h
    public final void a() {
        this.f724g.f693a = null;
    }

    @Override // io.flutter.plugin.platform.h
    public final void b(io.flutter.view.l lVar) {
        this.f724g.f693a = lVar;
    }

    @Override // io.flutter.plugin.platform.h
    public final void c(int i2) {
        if (d(i2)) {
            ((q) this.f725h.get(Integer.valueOf(i2))).getClass();
        } else if (this.f727j.get(i2) != null) {
            throw new ClassCastException();
        }
    }

    @Override // io.flutter.plugin.platform.h
    public final boolean d(int i2) {
        return this.f725h.containsKey(Integer.valueOf(i2));
    }

    public final void e() {
        int i2 = 0;
        while (true) {
            SparseArray sparseArray = this.f729l;
            if (i2 >= sparseArray.size()) {
                return;
            }
            b bVar = (b) sparseArray.valueAt(i2);
            bVar.d();
            bVar.f75a.close();
            i2++;
        }
    }

    public final void f(boolean z2) {
        int i2 = 0;
        while (true) {
            SparseArray sparseArray = this.f729l;
            if (i2 >= sparseArray.size()) {
                break;
            }
            int keyAt = sparseArray.keyAt(i2);
            b bVar = (b) sparseArray.valueAt(i2);
            if (this.f733q.contains(Integer.valueOf(keyAt))) {
                E.c cVar = this.f720c.f107h;
                if (cVar != null) {
                    bVar.a(cVar.f126b);
                }
                z2 &= bVar.e();
            } else {
                if (!this.f731o) {
                    bVar.d();
                }
                bVar.setVisibility(8);
                this.f720c.removeView(bVar);
            }
            i2++;
        }
        int i3 = 0;
        while (true) {
            SparseArray sparseArray2 = this.f728k;
            if (i3 >= sparseArray2.size()) {
                return;
            }
            int keyAt2 = sparseArray2.keyAt(i3);
            View view = (View) sparseArray2.get(keyAt2);
            if (!this.f734r.contains(Integer.valueOf(keyAt2)) || (!z2 && this.f732p)) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            i3++;
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View, io.flutter.embedding.engine.renderer.l] */
    public final void g() {
        if (!this.f732p || this.f731o) {
            return;
        }
        y yVar = this.f720c;
        yVar.f103d.c();
        C0012m c0012m = yVar.f102c;
        if (c0012m == null) {
            C0012m c0012m2 = new C0012m(yVar.getContext(), yVar.getWidth(), yVar.getHeight(), 1);
            yVar.f102c = c0012m2;
            yVar.addView(c0012m2);
        } else {
            c0012m.g(yVar.getWidth(), yVar.getHeight());
        }
        yVar.f104e = yVar.f103d;
        C0012m c0012m3 = yVar.f102c;
        yVar.f103d = c0012m3;
        E.c cVar = yVar.f107h;
        if (cVar != null) {
            c0012m3.a(cVar.f126b);
        }
        this.f731o = true;
    }

    public final int h(double d2) {
        return (int) Math.round(d2 * this.f719b.getResources().getDisplayMetrics().density);
    }
}
