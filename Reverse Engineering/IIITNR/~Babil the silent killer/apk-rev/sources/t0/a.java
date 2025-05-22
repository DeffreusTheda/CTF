package t0;

import a0.q;

/* loaded from: classes.dex */
public abstract class a<T> implements b<T> {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {212}, m = "collect")
    /* renamed from: t0.a$a, reason: collision with other inner class name */
    static final class C0027a extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: d, reason: collision with root package name */
        Object f1130d;

        /* renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f1131e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ a<T> f1132f;

        /* renamed from: g, reason: collision with root package name */
        int f1133g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0027a(a<T> aVar, c0.d<? super C0027a> dVar) {
            super(dVar);
            this.f1132f = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f1131e = obj;
            this.f1133g |= Integer.MIN_VALUE;
            return this.f1132f.a(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // t0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(t0.c<? super T> r6, c0.d<? super a0.q> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof t0.a.C0027a
            if (r0 == 0) goto L13
            r0 = r7
            t0.a$a r0 = (t0.a.C0027a) r0
            int r1 = r0.f1133g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1133g = r1
            goto L18
        L13:
            t0.a$a r0 = new t0.a$a
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f1131e
            java.lang.Object r1 = d0.b.c()
            int r2 = r0.f1133g
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r6 = r0.f1130d
            u0.c r6 = (u0.c) r6
            a0.l.b(r7)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r7 = move-exception
            goto L59
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            a0.l.b(r7)
            u0.c r7 = new u0.c
            c0.g r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.f1130d = r7     // Catch: java.lang.Throwable -> L55
            r0.f1133g = r3     // Catch: java.lang.Throwable -> L55
            java.lang.Object r6 = r5.b(r7, r0)     // Catch: java.lang.Throwable -> L55
            if (r6 != r1) goto L4e
            return r1
        L4e:
            r6 = r7
        L4f:
            r6.releaseIntercepted()
            a0.q r6 = a0.q.f22a
            return r6
        L55:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L59:
            r6.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: t0.a.a(t0.c, c0.d):java.lang.Object");
    }

    public abstract Object b(c<? super T> cVar, c0.d<? super q> dVar);
}
