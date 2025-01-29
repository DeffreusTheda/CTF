package x;

import D.u;
import Q.g;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantLock;
import w.InterfaceC0103a;

/* loaded from: classes.dex */
public final class d implements InterfaceC0103a {

    /* renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f1216a;

    /* renamed from: b, reason: collision with root package name */
    public final ReentrantLock f1217b = new ReentrantLock();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f1218c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f1219d = new LinkedHashMap();

    public d(WindowLayoutComponent windowLayoutComponent) {
        this.f1216a = windowLayoutComponent;
    }

    @Override // w.InterfaceC0103a
    public final void a(Context context, n.f fVar, u uVar) {
        g gVar;
        ReentrantLock reentrantLock = this.f1217b;
        reentrantLock.lock();
        LinkedHashMap linkedHashMap = this.f1218c;
        try {
            f fVar2 = (f) linkedHashMap.get(context);
            LinkedHashMap linkedHashMap2 = this.f1219d;
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
                this.f1216a.addWindowLayoutInfoListener(context, fVar3);
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // w.InterfaceC0103a
    public final void b(u uVar) {
        ReentrantLock reentrantLock = this.f1217b;
        reentrantLock.lock();
        LinkedHashMap linkedHashMap = this.f1219d;
        try {
            Context context = (Context) linkedHashMap.get(uVar);
            if (context == null) {
                return;
            }
            LinkedHashMap linkedHashMap2 = this.f1218c;
            f fVar = (f) linkedHashMap2.get(context);
            if (fVar == null) {
                return;
            }
            fVar.d(uVar);
            linkedHashMap.remove(uVar);
            if (fVar.c()) {
                linkedHashMap2.remove(context);
                this.f1216a.removeWindowLayoutInfoListener(fVar);
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
