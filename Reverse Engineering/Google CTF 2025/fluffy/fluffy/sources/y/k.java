package y;

import D.u;
import R.m;
import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.Window;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import w.InterfaceC0103a;

/* loaded from: classes.dex */
public final class k implements InterfaceC0103a {

    /* renamed from: c, reason: collision with root package name */
    public static volatile k f1239c;

    /* renamed from: d, reason: collision with root package name */
    public static final ReentrantLock f1240d = new ReentrantLock();

    /* renamed from: a, reason: collision with root package name */
    public final i f1241a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f1242b = new CopyOnWriteArrayList();

    public k(i iVar) {
        this.f1241a = iVar;
        if (iVar != null) {
            iVar.h(new io.flutter.plugin.platform.i(4, this));
        }
    }

    @Override // w.InterfaceC0103a
    public final void a(Context context, n.f fVar, u uVar) {
        Object obj;
        WindowManager.LayoutParams attributes;
        Q.g gVar = null;
        r1 = null;
        IBinder iBinder = null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        m mVar = m.f335b;
        if (activity != null) {
            ReentrantLock reentrantLock = f1240d;
            reentrantLock.lock();
            try {
                i iVar = this.f1241a;
                if (iVar == null) {
                    uVar.accept(new v.k(mVar));
                    return;
                }
                CopyOnWriteArrayList copyOnWriteArrayList = this.f1242b;
                boolean z2 = false;
                if (!(copyOnWriteArrayList instanceof Collection) || !copyOnWriteArrayList.isEmpty()) {
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (((j) it.next()).f1236a.equals(activity)) {
                            z2 = true;
                            break;
                        }
                    }
                }
                j jVar = new j(activity, fVar, uVar);
                copyOnWriteArrayList.add(jVar);
                if (z2) {
                    Iterator it2 = copyOnWriteArrayList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        } else {
                            obj = it2.next();
                            if (activity.equals(((j) obj).f1236a)) {
                                break;
                            }
                        }
                    }
                    j jVar2 = (j) obj;
                    v.k kVar = jVar2 != null ? jVar2.f1238c : null;
                    if (kVar != null) {
                        jVar.f1238c = kVar;
                        jVar.f1237b.accept(kVar);
                    }
                } else {
                    Window window = activity.getWindow();
                    if (window != null && (attributes = window.getAttributes()) != null) {
                        iBinder = attributes.token;
                    }
                    if (iBinder != null) {
                        iVar.g(iBinder, activity);
                    } else {
                        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new h(iVar, activity));
                    }
                }
                reentrantLock.unlock();
                gVar = Q.g.f327a;
            } finally {
                reentrantLock.unlock();
            }
        }
        if (gVar == null) {
            uVar.accept(new v.k(mVar));
        }
    }

    @Override // w.InterfaceC0103a
    public final void b(u uVar) {
        synchronized (f1240d) {
            try {
                if (this.f1241a == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = this.f1242b.iterator();
                while (it.hasNext()) {
                    j jVar = (j) it.next();
                    if (jVar.f1237b == uVar) {
                        arrayList.add(jVar);
                    }
                }
                this.f1242b.removeAll(arrayList);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    Activity activity = ((j) it2.next()).f1236a;
                    CopyOnWriteArrayList copyOnWriteArrayList = this.f1242b;
                    if (!(copyOnWriteArrayList instanceof Collection) || !copyOnWriteArrayList.isEmpty()) {
                        Iterator it3 = copyOnWriteArrayList.iterator();
                        while (it3.hasNext()) {
                            if (((j) it3.next()).f1236a.equals(activity)) {
                                break;
                            }
                        }
                    }
                    i iVar = this.f1241a;
                    if (iVar != null) {
                        iVar.f(activity);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
