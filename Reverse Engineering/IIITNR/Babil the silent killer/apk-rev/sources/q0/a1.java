package q0;

import c0.g;
import java.io.Closeable;

/* loaded from: classes.dex */
public abstract class a1 extends e0 implements Closeable {

    /* renamed from: e, reason: collision with root package name */
    public static final a f992e = new a(null);

    public static final class a extends c0.b<e0, a1> {

        /* renamed from: q0.a1$a$a, reason: collision with other inner class name */
        static final class C0024a extends kotlin.jvm.internal.j implements j0.l<g.b, a1> {

            /* renamed from: d, reason: collision with root package name */
            public static final C0024a f993d = new C0024a();

            C0024a() {
                super(1);
            }

            @Override // j0.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final a1 invoke(g.b bVar) {
                if (bVar instanceof a1) {
                    return (a1) bVar;
                }
                return null;
            }
        }

        private a() {
            super(e0.f1004d, C0024a.f993d);
        }

        public /* synthetic */ a(kotlin.jvm.internal.e eVar) {
            this();
        }
    }
}
