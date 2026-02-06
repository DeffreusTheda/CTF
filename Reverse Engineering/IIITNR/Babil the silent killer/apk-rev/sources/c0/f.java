package c0;

import a0.k;
import a0.q;
import j0.p;
import kotlin.jvm.internal.i;

/* loaded from: classes.dex */
public final class f {
    public static final <R, T> void a(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r2, d<? super T> completion) {
        d a2;
        d b2;
        i.e(pVar, "<this>");
        i.e(completion, "completion");
        a2 = d0.c.a(pVar, r2, completion);
        b2 = d0.c.b(a2);
        k.a aVar = k.f16d;
        b2.resumeWith(k.a(q.f22a));
    }
}
