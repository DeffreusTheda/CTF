package io.flutter.embedding.engine.renderer;

import android.os.Handler;
import android.view.Surface;
import androidx.lifecycle.m;
import androidx.lifecycle.n;
import androidx.lifecycle.o;
import androidx.lifecycle.r;
import d.C0020a;
import d.C0022c;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final FlutterJNI f627a;

    /* renamed from: b, reason: collision with root package name */
    public Surface f628b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f629c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f630d;

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f631e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f632f;

    /* renamed from: g, reason: collision with root package name */
    public final a f633g;

    public j(FlutterJNI flutterJNI) {
        androidx.lifecycle.l lVar;
        new AtomicLong(0L);
        this.f629c = false;
        this.f630d = new Handler();
        this.f631e = new HashSet();
        this.f632f = new ArrayList();
        a aVar = new a(this);
        this.f633g = aVar;
        this.f627a = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(aVar);
        n nVar = r.f420i.f426f;
        b bVar = new b(this);
        nVar.getClass();
        nVar.b("addObserver");
        androidx.lifecycle.g gVar = nVar.f412c;
        androidx.lifecycle.g gVar2 = androidx.lifecycle.g.f401b;
        gVar2 = gVar != gVar2 ? androidx.lifecycle.g.f402c : gVar2;
        m mVar = new m();
        int i2 = o.f419a;
        m mVar2 = null;
        mVar.f409b = new androidx.lifecycle.b(bVar, null);
        mVar.f408a = gVar2;
        C0020a c0020a = nVar.f411b;
        HashMap hashMap = c0020a.f448f;
        C0022c c0022c = (C0022c) hashMap.get(bVar);
        if (c0022c != null) {
            mVar2 = c0022c.f453b;
        } else {
            C0022c c0022c2 = new C0022c(bVar, mVar);
            c0020a.f447e++;
            C0022c c0022c3 = c0020a.f445c;
            if (c0022c3 == null) {
                c0020a.f444b = c0022c2;
                c0020a.f445c = c0022c2;
            } else {
                c0022c3.f454c = c0022c2;
                c0022c2.f455d = c0022c3;
                c0020a.f445c = c0022c2;
            }
            hashMap.put(bVar, c0022c2);
        }
        if (mVar2 == null && (lVar = (androidx.lifecycle.l) nVar.f413d.get()) != null) {
            boolean z2 = nVar.f414e != 0 || nVar.f415f;
            nVar.f414e++;
            for (androidx.lifecycle.g a2 = nVar.a(bVar); mVar.f408a.compareTo(a2) < 0 && nVar.f411b.f448f.containsKey(bVar); a2 = nVar.a(bVar)) {
                nVar.f417h.add(mVar.f408a);
                androidx.lifecycle.d dVar = androidx.lifecycle.f.Companion;
                androidx.lifecycle.g gVar3 = mVar.f408a;
                dVar.getClass();
                androidx.lifecycle.f a3 = androidx.lifecycle.d.a(gVar3);
                if (a3 == null) {
                    throw new IllegalStateException("no event up from " + mVar.f408a);
                }
                mVar.a(lVar, a3);
                ArrayList arrayList = nVar.f417h;
                arrayList.remove(arrayList.size() - 1);
            }
            if (!z2) {
                nVar.d();
            }
            nVar.f414e--;
        }
    }

    public final void a(int i2) {
        Iterator it = this.f631e.iterator();
        while (it.hasNext()) {
            p pVar = (p) ((WeakReference) it.next()).get();
            if (pVar != null) {
                pVar.onTrimMemory(i2);
            } else {
                it.remove();
            }
        }
    }

    public final void b() {
        if (this.f628b != null) {
            this.f627a.onSurfaceDestroyed();
            if (this.f629c) {
                this.f633g.b();
            }
            this.f629c = false;
            this.f628b = null;
        }
    }
}
