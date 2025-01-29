package v;

import android.content.Context;
import java.math.BigInteger;
import java.util.concurrent.locks.ReentrantLock;
import s.C0099i;
import w.InterfaceC0103a;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ g f1194a = new g();

    /* renamed from: b, reason: collision with root package name */
    public static final Q.e f1195b;

    /* renamed from: c, reason: collision with root package name */
    public static final C0102a f1196c;

    static {
        a0.l.a(h.class).b();
        f1195b = new Q.e(f.f1193c);
        f1196c = C0102a.f1175a;
    }

    public static b a(Context context) {
        a0.h.e(context, "context");
        InterfaceC0103a interfaceC0103a = (InterfaceC0103a) f1195b.a();
        if (interfaceC0103a == null) {
            y.k kVar = y.k.f1239c;
            if (y.k.f1239c == null) {
                ReentrantLock reentrantLock = y.k.f1240d;
                reentrantLock.lock();
                try {
                    if (y.k.f1239c == null) {
                        y.i iVar = null;
                        try {
                            C0099i c2 = y.g.c();
                            if (c2 != null) {
                                C0099i c0099i = C0099i.f1166g;
                                a0.h.e(c0099i, "other");
                                Object a2 = c2.f1171f.a();
                                a0.h.d(a2, "<get-bigInteger>(...)");
                                Object a3 = c0099i.f1171f.a();
                                a0.h.d(a3, "<get-bigInteger>(...)");
                                if (((BigInteger) a2).compareTo((BigInteger) a3) >= 0) {
                                    y.i iVar2 = new y.i(context);
                                    if (iVar2.i()) {
                                        iVar = iVar2;
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        y.k.f1239c = new y.k(iVar);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            interfaceC0103a = y.k.f1239c;
            a0.h.b(interfaceC0103a);
        }
        int i2 = o.f1209b;
        b bVar = new b(interfaceC0103a);
        f1196c.getClass();
        return bVar;
    }
}
