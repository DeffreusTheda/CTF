package w;

import java.nio.ByteBuffer;
import w.b;

/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final w.b f1384a;

    /* renamed from: b, reason: collision with root package name */
    private final String f1385b;

    /* renamed from: c, reason: collision with root package name */
    private final g<T> f1386c;

    /* renamed from: d, reason: collision with root package name */
    private final b.c f1387d;

    private final class b implements b.a {

        /* renamed from: a, reason: collision with root package name */
        private final d<T> f1388a;

        /* renamed from: w.a$b$a, reason: collision with other inner class name */
        class C0034a implements e<T> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b.InterfaceC0035b f1390a;

            C0034a(b.InterfaceC0035b interfaceC0035b) {
                this.f1390a = interfaceC0035b;
            }

            @Override // w.a.e
            public void a(T t2) {
                this.f1390a.a(a.this.f1386c.b(t2));
            }
        }

        private b(d<T> dVar) {
            this.f1388a = dVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // w.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0035b interfaceC0035b) {
            try {
                this.f1388a.a(a.this.f1386c.a(byteBuffer), new C0034a(interfaceC0035b));
            } catch (RuntimeException e2) {
                j.b.c("BasicMessageChannel#" + a.this.f1385b, "Failed to handle message", e2);
                interfaceC0035b.a(null);
            }
        }
    }

    private final class c implements b.InterfaceC0035b {

        /* renamed from: a, reason: collision with root package name */
        private final e<T> f1392a;

        private c(e<T> eVar) {
            this.f1392a = eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // w.b.InterfaceC0035b
        public void a(ByteBuffer byteBuffer) {
            try {
                this.f1392a.a(a.this.f1386c.a(byteBuffer));
            } catch (RuntimeException e2) {
                j.b.c("BasicMessageChannel#" + a.this.f1385b, "Failed to handle message reply", e2);
            }
        }
    }

    public interface d<T> {
        void a(T t2, e<T> eVar);
    }

    public interface e<T> {
        void a(T t2);
    }

    public a(w.b bVar, String str, g<T> gVar) {
        this(bVar, str, gVar, null);
    }

    public a(w.b bVar, String str, g<T> gVar, b.c cVar) {
        this.f1384a = bVar;
        this.f1385b = str;
        this.f1386c = gVar;
        this.f1387d = cVar;
    }

    public void c(T t2) {
        d(t2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void d(T t2, e<T> eVar) {
        this.f1384a.d(this.f1385b, this.f1386c.b(t2), eVar != null ? new c(eVar) : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [w.b] */
    /* JADX WARN: Type inference failed for: r1v0, types: [w.a$a] */
    /* JADX WARN: Type inference failed for: r1v1, types: [w.b$a] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public void e(d<T> dVar) {
        if (this.f1387d != null) {
            this.f1384a.b(this.f1385b, dVar != null ? new b(dVar) : null, this.f1387d);
        } else {
            this.f1384a.c(this.f1385b, dVar != null ? new b(dVar) : 0);
        }
    }
}
