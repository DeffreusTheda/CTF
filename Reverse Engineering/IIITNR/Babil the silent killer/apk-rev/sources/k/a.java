package k;

import android.content.res.AssetManager;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.List;
import w.b;
import w.q;

/* loaded from: classes.dex */
public class a implements w.b {

    /* renamed from: a, reason: collision with root package name */
    private final FlutterJNI f731a;

    /* renamed from: b, reason: collision with root package name */
    private final AssetManager f732b;

    /* renamed from: c, reason: collision with root package name */
    private final k.c f733c;

    /* renamed from: d, reason: collision with root package name */
    private final w.b f734d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f735e;

    /* renamed from: f, reason: collision with root package name */
    private String f736f;

    /* renamed from: g, reason: collision with root package name */
    private d f737g;

    /* renamed from: h, reason: collision with root package name */
    private final b.a f738h;

    /* renamed from: k.a$a, reason: collision with other inner class name */
    class C0017a implements b.a {
        C0017a() {
        }

        @Override // w.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0035b interfaceC0035b) {
            a.this.f736f = q.f1416b.a(byteBuffer);
            if (a.this.f737g != null) {
                a.this.f737g.a(a.this.f736f);
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f740a;

        /* renamed from: b, reason: collision with root package name */
        public final String f741b;

        /* renamed from: c, reason: collision with root package name */
        public final String f742c;

        public b(String str, String str2) {
            this.f740a = str;
            this.f741b = null;
            this.f742c = str2;
        }

        public b(String str, String str2, String str3) {
            this.f740a = str;
            this.f741b = str2;
            this.f742c = str3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f740a.equals(bVar.f740a)) {
                return this.f742c.equals(bVar.f742c);
            }
            return false;
        }

        public int hashCode() {
            return (this.f740a.hashCode() * 31) + this.f742c.hashCode();
        }

        public String toString() {
            return "DartEntrypoint( bundle path: " + this.f740a + ", function: " + this.f742c + " )";
        }
    }

    private static class c implements w.b {

        /* renamed from: a, reason: collision with root package name */
        private final k.c f743a;

        private c(k.c cVar) {
            this.f743a = cVar;
        }

        /* synthetic */ c(k.c cVar, C0017a c0017a) {
            this(cVar);
        }

        @Override // w.b
        public void b(String str, b.a aVar, b.c cVar) {
            this.f743a.b(str, aVar, cVar);
        }

        @Override // w.b
        public void c(String str, b.a aVar) {
            this.f743a.c(str, aVar);
        }

        @Override // w.b
        public void d(String str, ByteBuffer byteBuffer, b.InterfaceC0035b interfaceC0035b) {
            this.f743a.d(str, byteBuffer, interfaceC0035b);
        }
    }

    public interface d {
        void a(String str);
    }

    public a(FlutterJNI flutterJNI, AssetManager assetManager) {
        this.f735e = false;
        C0017a c0017a = new C0017a();
        this.f738h = c0017a;
        this.f731a = flutterJNI;
        this.f732b = assetManager;
        k.c cVar = new k.c(flutterJNI);
        this.f733c = cVar;
        cVar.c("flutter/isolate", c0017a);
        this.f734d = new c(cVar, null);
        if (flutterJNI.isAttached()) {
            this.f735e = true;
        }
    }

    @Override // w.b
    @Deprecated
    public void b(String str, b.a aVar, b.c cVar) {
        this.f734d.b(str, aVar, cVar);
    }

    @Override // w.b
    @Deprecated
    public void c(String str, b.a aVar) {
        this.f734d.c(str, aVar);
    }

    @Override // w.b
    @Deprecated
    public void d(String str, ByteBuffer byteBuffer, b.InterfaceC0035b interfaceC0035b) {
        this.f734d.d(str, byteBuffer, interfaceC0035b);
    }

    public void g(b bVar, List<String> list) {
        if (this.f735e) {
            j.b.g("DartExecutor", "Attempted to run a DartExecutor that is already running.");
            return;
        }
        z.e.a("DartExecutor#executeDartEntrypoint");
        try {
            j.b.f("DartExecutor", "Executing Dart entrypoint: " + bVar);
            this.f731a.runBundleAndSnapshotFromLibrary(bVar.f740a, bVar.f742c, bVar.f741b, this.f732b, list);
            this.f735e = true;
        } finally {
            z.e.d();
        }
    }

    public String h() {
        return this.f736f;
    }

    public boolean i() {
        return this.f735e;
    }

    public void j() {
        if (this.f731a.isAttached()) {
            this.f731a.notifyLowMemoryWarning();
        }
    }

    public void k() {
        j.b.f("DartExecutor", "Attached to JNI. Registering the platform message handler for this Dart execution context.");
        this.f731a.setPlatformMessageHandler(this.f733c);
    }

    public void l() {
        j.b.f("DartExecutor", "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
        this.f731a.setPlatformMessageHandler(null);
    }
}
