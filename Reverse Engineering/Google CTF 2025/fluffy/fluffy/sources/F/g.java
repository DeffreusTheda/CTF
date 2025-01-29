package F;

import D.v;
import android.os.Build;
import android.os.Handler;
import android.os.Trace;
import android.util.Log;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import p.AbstractC0084a;

/* loaded from: classes.dex */
public final class g implements L.e, h {

    /* renamed from: b, reason: collision with root package name */
    public final FlutterJNI f193b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f194c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f195d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f196e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f197f;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f198g;

    /* renamed from: h, reason: collision with root package name */
    public int f199h;

    /* renamed from: i, reason: collision with root package name */
    public final v f200i;

    public g(FlutterJNI flutterJNI) {
        B.a.j().getClass();
        this.f194c = new HashMap();
        this.f195d = new HashMap();
        this.f196e = new Object();
        this.f197f = new AtomicBoolean(false);
        this.f198g = new HashMap();
        this.f199h = 1;
        this.f200i = new v();
        new WeakHashMap();
        this.f193b = flutterJNI;
    }

    @Override // L.e
    public final void a(String str, ByteBuffer byteBuffer, L.d dVar) {
        P.a.b("DartMessenger#send on ".concat(str));
        try {
            int i2 = this.f199h;
            this.f199h = i2 + 1;
            if (dVar != null) {
                this.f198g.put(Integer.valueOf(i2), dVar);
            }
            FlutterJNI flutterJNI = this.f193b;
            if (byteBuffer == null) {
                flutterJNI.dispatchEmptyPlatformMessage(str, i2);
            } else {
                flutterJNI.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i2);
            }
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void b(final String str, final e eVar, final ByteBuffer byteBuffer, final int i2, final long j2) {
        v vVar = eVar != null ? eVar.f189b : null;
        String a2 = P.a.a("PlatformChannel ScheduleHandler on " + str);
        if (Build.VERSION.SDK_INT >= 29) {
            AbstractC0084a.a(a.a.y(a2), i2);
        } else {
            String y2 = a.a.y(a2);
            try {
                if (a.a.f358c == null) {
                    a.a.f358c = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
                }
                a.a.f358c.invoke(null, Long.valueOf(a.a.f356a), y2, Integer.valueOf(i2));
            } catch (Exception e2) {
                a.a.l("asyncTraceBegin", e2);
            }
        }
        Runnable runnable = new Runnable() { // from class: F.c
            @Override // java.lang.Runnable
            public final void run() {
                long j3 = j2;
                FlutterJNI flutterJNI = g.this.f193b;
                StringBuilder sb = new StringBuilder("PlatformChannel ScheduleHandler on ");
                String str2 = str;
                sb.append(str2);
                String a3 = P.a.a(sb.toString());
                int i3 = Build.VERSION.SDK_INT;
                int i4 = i2;
                if (i3 >= 29) {
                    AbstractC0084a.b(a.a.y(a3), i4);
                } else {
                    String y3 = a.a.y(a3);
                    try {
                        if (a.a.f359d == null) {
                            a.a.f359d = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
                        }
                        a.a.f359d.invoke(null, Long.valueOf(a.a.f356a), y3, Integer.valueOf(i4));
                    } catch (Exception e3) {
                        a.a.l("asyncTraceEnd", e3);
                    }
                }
                try {
                    P.a.b("DartMessenger#handleMessageFromDart on " + str2);
                    e eVar2 = eVar;
                    ByteBuffer byteBuffer2 = byteBuffer;
                    try {
                        if (eVar2 != null) {
                            try {
                                try {
                                    eVar2.f188a.b(byteBuffer2, new f(flutterJNI, i4));
                                } catch (Error e4) {
                                    Thread currentThread = Thread.currentThread();
                                    if (currentThread.getUncaughtExceptionHandler() == null) {
                                        throw e4;
                                    }
                                    currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, e4);
                                }
                            } catch (Exception e5) {
                                Log.e("DartMessenger", "Uncaught exception in binary message listener", e5);
                                flutterJNI.invokePlatformMessageEmptyResponseCallback(i4);
                            }
                        } else {
                            flutterJNI.invokePlatformMessageEmptyResponseCallback(i4);
                        }
                        if (byteBuffer2 != null && byteBuffer2.isDirect()) {
                            byteBuffer2.limit(0);
                        }
                        Trace.endSection();
                    } finally {
                    }
                } finally {
                    flutterJNI.cleanupMessageData(j3);
                }
            }
        };
        if (vVar == null) {
            vVar = this.f200i;
        }
        ((Handler) vVar.f94c).post(runnable);
    }

    public final void c(String str, L.c cVar) {
        if (cVar == null) {
            synchronized (this.f196e) {
                this.f194c.remove(str);
            }
            return;
        }
        synchronized (this.f196e) {
            try {
                this.f194c.put(str, new e(cVar, null));
                List<d> list = (List) this.f195d.remove(str);
                if (list == null) {
                    return;
                }
                for (d dVar : list) {
                    b(str, (e) this.f194c.get(str), dVar.f185a, dVar.f186b, dVar.f187c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // L.e
    public final void d(String str, L.c cVar) {
        c(str, cVar);
    }
}
