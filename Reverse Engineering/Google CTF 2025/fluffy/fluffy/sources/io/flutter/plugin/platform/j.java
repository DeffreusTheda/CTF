package io.flutter.plugin.platform;

import D.v;
import D.y;
import android.app.Activity;
import android.util.SparseArray;
import android.view.Surface;
import android.view.SurfaceControl;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class j implements h {

    /* renamed from: a, reason: collision with root package name */
    public E.i f706a;

    /* renamed from: b, reason: collision with root package name */
    public Activity f707b;

    /* renamed from: c, reason: collision with root package name */
    public y f708c;

    /* renamed from: e, reason: collision with root package name */
    public v f710e;

    /* renamed from: d, reason: collision with root package name */
    public FlutterJNI f709d = null;

    /* renamed from: k, reason: collision with root package name */
    public Surface f716k = null;

    /* renamed from: l, reason: collision with root package name */
    public SurfaceControl f717l = null;
    public final i m = new i(0, this);

    /* renamed from: f, reason: collision with root package name */
    public final a f711f = new a();

    /* renamed from: g, reason: collision with root package name */
    public final SparseArray f712g = new SparseArray();

    /* renamed from: h, reason: collision with root package name */
    public final SparseArray f713h = new SparseArray();

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f714i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f715j = new ArrayList();

    public j() {
        if (B.a.f1f == null) {
            B.a.f1f = new B.a(3);
        }
    }

    @Override // io.flutter.plugin.platform.h
    public final void a() {
        this.f711f.f693a = null;
    }

    @Override // io.flutter.plugin.platform.h
    public final void b(io.flutter.view.l lVar) {
        this.f711f.f693a = lVar;
    }

    @Override // io.flutter.plugin.platform.h
    public final void c(int i2) {
        if (this.f712g.get(i2) != null) {
            throw new ClassCastException();
        }
    }

    @Override // io.flutter.plugin.platform.h
    public final boolean d(int i2) {
        return false;
    }
}
