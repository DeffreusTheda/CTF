package x;

import D.u;
import Q.g;
import R.m;
import a0.l;
import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantLock;
import r.C0090b;
import s.C0094d;
import w.InterfaceC0103a;

/* loaded from: classes.dex */
public final class c implements InterfaceC0103a {

    /* renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f1210a;

    /* renamed from: b, reason: collision with root package name */
    public final C0090b f1211b;

    /* renamed from: c, reason: collision with root package name */
    public final ReentrantLock f1212c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f1213d = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f1214e = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f1215f = new LinkedHashMap();

    public c(WindowLayoutComponent windowLayoutComponent, C0090b c0090b) {
        this.f1210a = windowLayoutComponent;
        this.f1211b = c0090b;
    }

    @Override // w.InterfaceC0103a
    public final void a(Context context, n.f fVar, u uVar) {
        g gVar;
        ReentrantLock reentrantLock = this.f1212c;
        reentrantLock.lock();
        LinkedHashMap linkedHashMap = this.f1213d;
        try {
            f fVar2 = (f) linkedHashMap.get(context);
            LinkedHashMap linkedHashMap2 = this.f1214e;
            if (fVar2 != null) {
                fVar2.b(uVar);
                linkedHashMap2.put(uVar, context);
                gVar = g.f327a;
            } else {
                gVar = null;
            }
            if (gVar == null) {
                f fVar3 = new f(context);
                linkedHashMap.put(context, fVar3);
                linkedHashMap2.put(uVar, context);
                fVar3.b(uVar);
                if (!(context instanceof Activity)) {
                    fVar3.accept(new WindowLayoutInfo(m.f335b));
                    reentrantLock.unlock();
                    return;
                } else {
                    this.f1215f.put(fVar3, this.f1211b.a(this.f1210a, l.a(WindowLayoutInfo.class), (Activity) context, new b(fVar3)));
                }
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // w.InterfaceC0103a
    public final void b(u uVar) {
        ReentrantLock reentrantLock = this.f1212c;
        reentrantLock.lock();
        LinkedHashMap linkedHashMap = this.f1214e;
        try {
            Context context = (Context) linkedHashMap.get(uVar);
            if (context == null) {
                return;
            }
            LinkedHashMap linkedHashMap2 = this.f1213d;
            f fVar = (f) linkedHashMap2.get(context);
            if (fVar == null) {
                return;
            }
            fVar.d(uVar);
            linkedHashMap.remove(uVar);
            if (fVar.f1223d.isEmpty()) {
                linkedHashMap2.remove(context);
                C0094d c0094d = (C0094d) this.f1215f.remove(fVar);
                if (c0094d != null) {
                    c0094d.f1156a.invoke(c0094d.f1157b, c0094d.f1158c);
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
