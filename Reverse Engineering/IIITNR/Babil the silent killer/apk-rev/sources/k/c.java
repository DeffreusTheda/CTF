package k;

import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import w.b;

/* loaded from: classes.dex */
class c implements w.b, k.d {

    /* renamed from: a, reason: collision with root package name */
    private final FlutterJNI f750a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, d> f751b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, List<a>> f752c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f753d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f754e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<Integer, b.InterfaceC0035b> f755f;

    /* renamed from: g, reason: collision with root package name */
    private int f756g;

    /* renamed from: h, reason: collision with root package name */
    private final b f757h;

    /* renamed from: i, reason: collision with root package name */
    private WeakHashMap<b.c, b> f758i;

    /* renamed from: j, reason: collision with root package name */
    private f f759j;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public final ByteBuffer f760a;

        /* renamed from: b, reason: collision with root package name */
        int f761b;

        /* renamed from: c, reason: collision with root package name */
        long f762c;

        a(ByteBuffer byteBuffer, int i2, long j2) {
            this.f760a = byteBuffer;
            this.f761b = i2;
            this.f762c = j2;
        }
    }

    interface b {
        void a(Runnable runnable);
    }

    /* renamed from: k.c$c, reason: collision with other inner class name */
    private static class C0018c implements f {

        /* renamed from: a, reason: collision with root package name */
        ExecutorService f763a = j.a.e().b();

        C0018c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class d {

        /* renamed from: a, reason: collision with root package name */
        public final b.a f764a;

        /* renamed from: b, reason: collision with root package name */
        public final b f765b;

        d(b.a aVar, b bVar) {
            this.f764a = aVar;
            this.f765b = bVar;
        }
    }

    static class e implements b.InterfaceC0035b {

        /* renamed from: a, reason: collision with root package name */
        private final FlutterJNI f766a;

        /* renamed from: b, reason: collision with root package name */
        private final int f767b;

        /* renamed from: c, reason: collision with root package name */
        private final AtomicBoolean f768c = new AtomicBoolean(false);

        e(FlutterJNI flutterJNI, int i2) {
            this.f766a = flutterJNI;
            this.f767b = i2;
        }

        @Override // w.b.InterfaceC0035b
        public void a(ByteBuffer byteBuffer) {
            if (this.f768c.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            }
            if (byteBuffer == null) {
                this.f766a.invokePlatformMessageEmptyResponseCallback(this.f767b);
            } else {
                this.f766a.invokePlatformMessageResponseCallback(this.f767b, byteBuffer, byteBuffer.position());
            }
        }
    }

    interface f {
    }

    c(FlutterJNI flutterJNI) {
        this(flutterJNI, new C0018c());
    }

    c(FlutterJNI flutterJNI, f fVar) {
        this.f751b = new HashMap();
        this.f752c = new HashMap();
        this.f753d = new Object();
        this.f754e = new AtomicBoolean(false);
        this.f755f = new HashMap();
        this.f756g = 1;
        this.f757h = new k.e();
        this.f758i = new WeakHashMap<>();
        this.f750a = flutterJNI;
        this.f759j = fVar;
    }

    private void g(final String str, final d dVar, final ByteBuffer byteBuffer, final int i2, final long j2) {
        b bVar = dVar != null ? dVar.f765b : null;
        z.e.b("PlatformChannel ScheduleHandler on " + str, i2);
        Runnable runnable = new Runnable() { // from class: k.b
            @Override // java.lang.Runnable
            public final void run() {
                c.this.j(str, i2, dVar, byteBuffer, j2);
            }
        };
        if (bVar == null) {
            bVar = this.f757h;
        }
        bVar.a(runnable);
    }

    private static void h(Error error) {
        Thread currentThread = Thread.currentThread();
        if (currentThread.getUncaughtExceptionHandler() == null) {
            throw error;
        }
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, error);
    }

    private void i(d dVar, ByteBuffer byteBuffer, int i2) {
        if (dVar != null) {
            try {
                j.b.f("DartMessenger", "Deferring to registered handler to process message.");
                dVar.f764a.a(byteBuffer, new e(this.f750a, i2));
                return;
            } catch (Error e2) {
                h(e2);
                return;
            } catch (Exception e3) {
                j.b.c("DartMessenger", "Uncaught exception in binary message listener", e3);
            }
        } else {
            j.b.f("DartMessenger", "No registered handler for message. Responding to Dart with empty reply message.");
        }
        this.f750a.invokePlatformMessageEmptyResponseCallback(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(String str, int i2, d dVar, ByteBuffer byteBuffer, long j2) {
        z.e.e("PlatformChannel ScheduleHandler on " + str, i2);
        z.e.a("DartMessenger#handleMessageFromDart on " + str);
        try {
            i(dVar, byteBuffer, i2);
            if (byteBuffer != null && byteBuffer.isDirect()) {
                byteBuffer.limit(0);
            }
        } finally {
            this.f750a.cleanupMessageData(j2);
            z.e.d();
        }
    }

    @Override // k.d
    public void a(String str, ByteBuffer byteBuffer, int i2, long j2) {
        d dVar;
        boolean z2;
        j.b.f("DartMessenger", "Received message from Dart over channel '" + str + "'");
        synchronized (this.f753d) {
            dVar = this.f751b.get(str);
            z2 = this.f754e.get() && dVar == null;
            if (z2) {
                if (!this.f752c.containsKey(str)) {
                    this.f752c.put(str, new LinkedList());
                }
                this.f752c.get(str).add(new a(byteBuffer, i2, j2));
            }
        }
        if (z2) {
            return;
        }
        g(str, dVar, byteBuffer, i2, j2);
    }

    @Override // w.b
    public void b(String str, b.a aVar, b.c cVar) {
        if (aVar == null) {
            j.b.f("DartMessenger", "Removing handler for channel '" + str + "'");
            synchronized (this.f753d) {
                this.f751b.remove(str);
            }
            return;
        }
        b bVar = null;
        if (cVar != null && (bVar = this.f758i.get(cVar)) == null) {
            throw new IllegalArgumentException("Unrecognized TaskQueue, use BinaryMessenger to create your TaskQueue (ex makeBackgroundTaskQueue).");
        }
        j.b.f("DartMessenger", "Setting handler for channel '" + str + "'");
        synchronized (this.f753d) {
            this.f751b.put(str, new d(aVar, bVar));
            List<a> remove = this.f752c.remove(str);
            if (remove == null) {
                return;
            }
            for (a aVar2 : remove) {
                g(str, this.f751b.get(str), aVar2.f760a, aVar2.f761b, aVar2.f762c);
            }
        }
    }

    @Override // w.b
    public void c(String str, b.a aVar) {
        b(str, aVar, null);
    }

    @Override // w.b
    public void d(String str, ByteBuffer byteBuffer, b.InterfaceC0035b interfaceC0035b) {
        z.e.a("DartMessenger#send on " + str);
        try {
            j.b.f("DartMessenger", "Sending message with callback over channel '" + str + "'");
            int i2 = this.f756g;
            this.f756g = i2 + 1;
            if (interfaceC0035b != null) {
                this.f755f.put(Integer.valueOf(i2), interfaceC0035b);
            }
            if (byteBuffer == null) {
                this.f750a.dispatchEmptyPlatformMessage(str, i2);
            } else {
                this.f750a.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i2);
            }
        } finally {
            z.e.d();
        }
    }

    @Override // k.d
    public void e(int i2, ByteBuffer byteBuffer) {
        j.b.f("DartMessenger", "Received message reply from Dart.");
        b.InterfaceC0035b remove = this.f755f.remove(Integer.valueOf(i2));
        if (remove != null) {
            try {
                j.b.f("DartMessenger", "Invoking registered callback for reply from Dart.");
                remove.a(byteBuffer);
                if (byteBuffer == null || !byteBuffer.isDirect()) {
                    return;
                }
                byteBuffer.limit(0);
            } catch (Error e2) {
                h(e2);
            } catch (Exception e3) {
                j.b.c("DartMessenger", "Uncaught exception in binary message reply handler", e3);
            }
        }
    }
}
