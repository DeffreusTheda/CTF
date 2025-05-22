package u0;

import a0.k;
import a0.q;
import c0.g;
import c0.h;
import j0.p;
import kotlin.jvm.internal.j;
import p0.f;
import q0.n1;

/* loaded from: classes.dex */
public final class c<T> extends kotlin.coroutines.jvm.internal.d implements t0.c<T> {

    /* renamed from: d, reason: collision with root package name */
    public final t0.c<T> f1191d;

    /* renamed from: e, reason: collision with root package name */
    public final g f1192e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1193f;

    /* renamed from: g, reason: collision with root package name */
    private g f1194g;

    /* renamed from: h, reason: collision with root package name */
    private c0.d<? super q> f1195h;

    static final class a extends j implements p<Integer, g.b, Integer> {

        /* renamed from: d, reason: collision with root package name */
        public static final a f1196d = new a();

        a() {
            super(2);
        }

        public final Integer a(int i2, g.b bVar) {
            return Integer.valueOf(i2 + 1);
        }

        @Override // j0.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, g.b bVar) {
            return a(num.intValue(), bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(t0.c<? super T> cVar, g gVar) {
        super(b.f1189d, h.f144d);
        this.f1191d = cVar;
        this.f1192e = gVar;
        this.f1193f = ((Number) gVar.fold(0, a.f1196d)).intValue();
    }

    private final void a(g gVar, g gVar2, T t2) {
        if (gVar2 instanceof u0.a) {
            c((u0.a) gVar2, t2);
        }
        e.a(this, gVar);
        this.f1194g = gVar;
    }

    private final Object b(c0.d<? super q> dVar, T t2) {
        j0.q qVar;
        g context = dVar.getContext();
        n1.d(context);
        g gVar = this.f1194g;
        if (gVar != context) {
            a(context, gVar, t2);
        }
        this.f1195h = dVar;
        qVar = d.f1197a;
        return qVar.f(this.f1191d, t2, this);
    }

    private final void c(u0.a aVar, Object obj) {
        String e2;
        e2 = f.e("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + aVar.f1187d + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
        throw new IllegalStateException(e2.toString());
    }

    @Override // t0.c
    public Object emit(T t2, c0.d<? super q> dVar) {
        Object c2;
        Object c3;
        try {
            Object b2 = b(dVar, t2);
            c2 = d0.d.c();
            if (b2 == c2) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            c3 = d0.d.c();
            return b2 == c3 ? b2 : q.f22a;
        } catch (Throwable th) {
            this.f1194g = new u0.a(th);
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.a, kotlin.coroutines.jvm.internal.e
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        c0.d<? super q> dVar = this.f1195h;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.d, c0.d
    public g getContext() {
        c0.d<? super q> dVar = this.f1195h;
        g context = dVar == null ? null : dVar.getContext();
        return context == null ? h.f144d : context;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public Object invokeSuspend(Object obj) {
        Object c2;
        Throwable b2 = k.b(obj);
        if (b2 != null) {
            this.f1194g = new u0.a(b2);
        }
        c0.d<? super q> dVar = this.f1195h;
        if (dVar != null) {
            dVar.resumeWith(obj);
        }
        c2 = d0.d.c();
        return c2;
    }

    @Override // kotlin.coroutines.jvm.internal.d, kotlin.coroutines.jvm.internal.a
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
