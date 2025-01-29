package j0;

import h0.AbstractC0059t;
import h0.C0045e;
import h0.C0050j;
import h0.InterfaceC0044d;
import h0.W;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import m0.AbstractC0081a;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final k f886a = new k(-1, null, null, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final int f887b = AbstractC0081a.k("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12);

    /* renamed from: c, reason: collision with root package name */
    public static final int f888c = AbstractC0081a.k("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12);

    /* renamed from: d, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f889d = new io.flutter.plugin.platform.i(1, "BUFFERED");

    /* renamed from: e, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f890e = new io.flutter.plugin.platform.i(1, "SHOULD_BUFFER");

    /* renamed from: f, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f891f = new io.flutter.plugin.platform.i(1, "S_RESUMING_BY_RCV");

    /* renamed from: g, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f892g = new io.flutter.plugin.platform.i(1, "RESUMING_BY_EB");

    /* renamed from: h, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f893h = new io.flutter.plugin.platform.i(1, "POISONED");

    /* renamed from: i, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f894i = new io.flutter.plugin.platform.i(1, "DONE_RCV");

    /* renamed from: j, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f895j = new io.flutter.plugin.platform.i(1, "INTERRUPTED_SEND");

    /* renamed from: k, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f896k = new io.flutter.plugin.platform.i(1, "INTERRUPTED_RCV");

    /* renamed from: l, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f897l = new io.flutter.plugin.platform.i(1, "CHANNEL_CLOSED");
    public static final io.flutter.plugin.platform.i m = new io.flutter.plugin.platform.i(1, "SUSPEND");

    /* renamed from: n, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f898n = new io.flutter.plugin.platform.i(1, "SUSPEND_NO_WAITER");

    /* renamed from: o, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f899o = new io.flutter.plugin.platform.i(1, "FAILED");

    /* renamed from: p, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f900p = new io.flutter.plugin.platform.i(1, "NO_RECEIVE_RESULT");

    /* renamed from: q, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f901q = new io.flutter.plugin.platform.i(1, "CLOSE_HANDLER_CLOSED");

    /* renamed from: r, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f902r = new io.flutter.plugin.platform.i(1, "CLOSE_HANDLER_INVOKED");

    /* renamed from: s, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f903s = new io.flutter.plugin.platform.i(1, "NO_CLOSE_CAUSE");

    public static final boolean a(InterfaceC0044d interfaceC0044d, Object obj, Z.l lVar) {
        io.flutter.plugin.platform.i iVar;
        C0045e c0045e = (C0045e) interfaceC0044d;
        c0045e.getClass();
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C0045e.f552h;
            Object obj2 = atomicReferenceFieldUpdater.get(c0045e);
            boolean z2 = obj2 instanceof W;
            iVar = AbstractC0059t.f576a;
            if (!z2) {
                boolean z3 = obj2 instanceof C0050j;
                iVar = null;
                break;
            }
            Object w2 = C0045e.w(obj, c0045e.f588d, lVar);
            while (!atomicReferenceFieldUpdater.compareAndSet(c0045e, obj2, w2)) {
                if (atomicReferenceFieldUpdater.get(c0045e) != obj2) {
                    break;
                }
            }
            if (!c0045e.s()) {
                c0045e.n();
            }
        }
        if (iVar == null) {
            return false;
        }
        c0045e.o(c0045e.f588d);
        return true;
    }
}
