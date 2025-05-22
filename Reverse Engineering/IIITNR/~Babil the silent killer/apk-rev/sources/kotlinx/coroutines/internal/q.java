package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import q0.t1;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f842a;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f843b;

    /* renamed from: c, reason: collision with root package name */
    public static final t1 f844c;

    static {
        q qVar = new q();
        f842a = qVar;
        f843b = z.e("kotlinx.coroutines.fast.service.loader", true);
        f844c = qVar.a();
    }

    private q() {
    }

    private final t1 a() {
        o0.b a2;
        List<MainDispatcherFactory> e2;
        Object next;
        try {
            if (f843b) {
                e2 = i.f823a.c();
            } else {
                a2 = o0.f.a(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator());
                e2 = o0.h.e(a2);
            }
            Iterator<T> it = e2.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) next;
            return mainDispatcherFactory == null ? r.b(null, null, 3, null) : r.d(mainDispatcherFactory, e2);
        } catch (Throwable th) {
            return r.b(th, null, 2, null);
        }
    }
}
