package j;

import io.flutter.embedding.engine.FlutterJNI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import m.d;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    private static a f719e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f720f;

    /* renamed from: a, reason: collision with root package name */
    private d f721a;

    /* renamed from: b, reason: collision with root package name */
    private l.a f722b;

    /* renamed from: c, reason: collision with root package name */
    private FlutterJNI.c f723c;

    /* renamed from: d, reason: collision with root package name */
    private ExecutorService f724d;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private d f725a;

        /* renamed from: b, reason: collision with root package name */
        private l.a f726b;

        /* renamed from: c, reason: collision with root package name */
        private FlutterJNI.c f727c;

        /* renamed from: d, reason: collision with root package name */
        private ExecutorService f728d;

        /* renamed from: j.a$b$a, reason: collision with other inner class name */
        private class ThreadFactoryC0016a implements ThreadFactory {

            /* renamed from: a, reason: collision with root package name */
            private int f729a;

            private ThreadFactoryC0016a() {
                this.f729a = 0;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                StringBuilder sb = new StringBuilder();
                sb.append("flutter-worker-");
                int i2 = this.f729a;
                this.f729a = i2 + 1;
                sb.append(i2);
                thread.setName(sb.toString());
                return thread;
            }
        }

        private void b() {
            if (this.f727c == null) {
                this.f727c = new FlutterJNI.c();
            }
            if (this.f728d == null) {
                this.f728d = Executors.newCachedThreadPool(new ThreadFactoryC0016a());
            }
            if (this.f725a == null) {
                this.f725a = new d(this.f727c.a(), this.f728d);
            }
        }

        public a a() {
            b();
            return new a(this.f725a, this.f726b, this.f727c, this.f728d);
        }
    }

    private a(d dVar, l.a aVar, FlutterJNI.c cVar, ExecutorService executorService) {
        this.f721a = dVar;
        this.f722b = aVar;
        this.f723c = cVar;
        this.f724d = executorService;
    }

    public static a e() {
        f720f = true;
        if (f719e == null) {
            f719e = new b().a();
        }
        return f719e;
    }

    public l.a a() {
        return this.f722b;
    }

    public ExecutorService b() {
        return this.f724d;
    }

    public d c() {
        return this.f721a;
    }

    public FlutterJNI.c d() {
        return this.f723c;
    }
}
