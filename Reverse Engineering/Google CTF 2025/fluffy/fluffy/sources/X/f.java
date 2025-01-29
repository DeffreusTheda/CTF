package x;

import D.u;
import a0.h;
import android.content.Context;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;
import k.InterfaceC0066a;
import v.k;

/* loaded from: classes.dex */
public final class f implements InterfaceC0066a, Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1220a;

    /* renamed from: c, reason: collision with root package name */
    public k f1222c;

    /* renamed from: b, reason: collision with root package name */
    public final ReentrantLock f1221b = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f1223d = new LinkedHashSet();

    public f(Context context) {
        this.f1220a = context;
    }

    @Override // k.InterfaceC0066a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(WindowLayoutInfo windowLayoutInfo) {
        h.e(windowLayoutInfo, "value");
        ReentrantLock reentrantLock = this.f1221b;
        reentrantLock.lock();
        try {
            this.f1222c = e.b(this.f1220a, windowLayoutInfo);
            Iterator it = this.f1223d.iterator();
            while (it.hasNext()) {
                ((InterfaceC0066a) it.next()).accept(this.f1222c);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void b(u uVar) {
        ReentrantLock reentrantLock = this.f1221b;
        reentrantLock.lock();
        try {
            k kVar = this.f1222c;
            if (kVar != null) {
                uVar.accept(kVar);
            }
            this.f1223d.add(uVar);
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean c() {
        return this.f1223d.isEmpty();
    }

    public final void d(u uVar) {
        ReentrantLock reentrantLock = this.f1221b;
        reentrantLock.lock();
        try {
            this.f1223d.remove(uVar);
        } finally {
            reentrantLock.unlock();
        }
    }
}
