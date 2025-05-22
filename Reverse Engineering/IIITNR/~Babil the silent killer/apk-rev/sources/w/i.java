package w;

import java.nio.ByteBuffer;
import w.b;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private final w.b f1400a;

    /* renamed from: b, reason: collision with root package name */
    private final String f1401b;

    /* renamed from: c, reason: collision with root package name */
    private final j f1402c;

    /* renamed from: d, reason: collision with root package name */
    private final b.c f1403d;

    private final class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        private final c f1404a;

        /* renamed from: w.i$a$a, reason: collision with other inner class name */
        class C0036a implements d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b.InterfaceC0035b f1406a;

            C0036a(b.InterfaceC0035b interfaceC0035b) {
                this.f1406a = interfaceC0035b;
            }

            @Override // w.i.d
            public void a(String str, String str2, Object obj) {
                this.f1406a.a(i.this.f1402c.c(str, str2, obj));
            }

            @Override // w.i.d
            public void b(Object obj) {
                this.f1406a.a(i.this.f1402c.d(obj));
            }

            @Override // w.i.d
            public void c() {
                this.f1406a.a(null);
            }
        }

        a(c cVar) {
            this.f1404a = cVar;
        }

        @Override // w.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0035b interfaceC0035b) {
            try {
                this.f1404a.a(i.this.f1402c.e(byteBuffer), new C0036a(interfaceC0035b));
            } catch (RuntimeException e2) {
                j.b.c("MethodChannel#" + i.this.f1401b, "Failed to handle method call", e2);
                interfaceC0035b.a(i.this.f1402c.a("error", e2.getMessage(), null, j.b.d(e2)));
            }
        }
    }

    private final class b implements b.InterfaceC0035b {

        /* renamed from: a, reason: collision with root package name */
        private final d f1408a;

        b(d dVar) {
            this.f1408a = dVar;
        }

        @Override // w.b.InterfaceC0035b
        public void a(ByteBuffer byteBuffer) {
            try {
                if (byteBuffer == null) {
                    this.f1408a.c();
                } else {
                    try {
                        this.f1408a.b(i.this.f1402c.f(byteBuffer));
                    } catch (w.c e2) {
                        this.f1408a.a(e2.f1394d, e2.getMessage(), e2.f1395e);
                    }
                }
            } catch (RuntimeException e3) {
                j.b.c("MethodChannel#" + i.this.f1401b, "Failed to handle method call result", e3);
            }
        }
    }

    public interface c {
        void a(h hVar, d dVar);
    }

    public interface d {
        void a(String str, String str2, Object obj);

        void b(Object obj);

        void c();
    }

    public i(w.b bVar, String str, j jVar) {
        this(bVar, str, jVar, null);
    }

    public i(w.b bVar, String str, j jVar, b.c cVar) {
        this.f1400a = bVar;
        this.f1401b = str;
        this.f1402c = jVar;
        this.f1403d = cVar;
    }

    public void c(String str, Object obj) {
        d(str, obj, null);
    }

    public void d(String str, Object obj, d dVar) {
        this.f1400a.d(this.f1401b, this.f1402c.b(new h(str, obj)), dVar == null ? null : new b(dVar));
    }

    public void e(c cVar) {
        if (this.f1403d != null) {
            this.f1400a.b(this.f1401b, cVar != null ? new a(cVar) : null, this.f1403d);
        } else {
            this.f1400a.c(this.f1401b, cVar != null ? new a(cVar) : null);
        }
    }
}
