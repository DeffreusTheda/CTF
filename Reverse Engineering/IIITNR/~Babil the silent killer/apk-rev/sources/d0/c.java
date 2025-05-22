package d0;

import a0.l;
import a0.q;
import c0.g;
import j0.p;
import kotlin.coroutines.jvm.internal.h;
import kotlin.coroutines.jvm.internal.j;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {

    public static final class a extends j {

        /* renamed from: d, reason: collision with root package name */
        private int f150d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ p f151e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f152f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c0.d dVar, p pVar, Object obj) {
            super(dVar);
            this.f151e = pVar;
            this.f152f = obj;
            i.c(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.a
        protected Object invokeSuspend(Object obj) {
            int i2 = this.f150d;
            if (i2 == 0) {
                this.f150d = 1;
                l.b(obj);
                i.c(this.f151e, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda-1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda-1>, kotlin.Any?>");
                return ((p) n.a(this.f151e, 2)).invoke(this.f152f, this);
            }
            if (i2 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f150d = 2;
            l.b(obj);
            return obj;
        }
    }

    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: d, reason: collision with root package name */
        private int f153d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ p f154e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f155f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c0.d dVar, g gVar, p pVar, Object obj) {
            super(dVar, gVar);
            this.f154e = pVar;
            this.f155f = obj;
            i.c(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.a
        protected Object invokeSuspend(Object obj) {
            int i2 = this.f153d;
            if (i2 == 0) {
                this.f153d = 1;
                l.b(obj);
                i.c(this.f154e, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda-1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda-1>, kotlin.Any?>");
                return ((p) n.a(this.f154e, 2)).invoke(this.f155f, this);
            }
            if (i2 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f153d = 2;
            l.b(obj);
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, T> c0.d<q> a(p<? super R, ? super c0.d<? super T>, ? extends Object> pVar, R r2, c0.d<? super T> completion) {
        i.e(pVar, "<this>");
        i.e(completion, "completion");
        c0.d<?> a2 = h.a(completion);
        if (pVar instanceof kotlin.coroutines.jvm.internal.a) {
            return ((kotlin.coroutines.jvm.internal.a) pVar).create(r2, a2);
        }
        g context = a2.getContext();
        return context == c0.h.f144d ? new a(a2, pVar, r2) : new b(a2, context, pVar, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> c0.d<T> b(c0.d<? super T> dVar) {
        c0.d<T> dVar2;
        i.e(dVar, "<this>");
        kotlin.coroutines.jvm.internal.d dVar3 = dVar instanceof kotlin.coroutines.jvm.internal.d ? (kotlin.coroutines.jvm.internal.d) dVar : null;
        return (dVar3 == null || (dVar2 = (c0.d<T>) dVar3.intercepted()) == null) ? dVar : dVar2;
    }
}
