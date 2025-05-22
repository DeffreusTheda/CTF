package u0;

import c0.g;
import j0.p;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.internal.w;
import q0.j1;

/* loaded from: classes.dex */
public final class e {

    static final class a extends j implements p<Integer, g.b, Integer> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c<?> f1199d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(c<?> cVar) {
            super(2);
            this.f1199d = cVar;
        }

        public final Integer a(int i2, g.b bVar) {
            g.c<?> key = bVar.getKey();
            g.b bVar2 = this.f1199d.f1192e.get(key);
            if (key != j1.f1021c) {
                return Integer.valueOf(bVar != bVar2 ? Integer.MIN_VALUE : i2 + 1);
            }
            j1 j1Var = (j1) bVar2;
            j1 b2 = e.b((j1) bVar, j1Var);
            if (b2 == j1Var) {
                if (j1Var != null) {
                    i2++;
                }
                return Integer.valueOf(i2);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + b2 + ", expected child of " + j1Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        @Override // j0.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, g.b bVar) {
            return a(num.intValue(), bVar);
        }
    }

    public static final void a(c<?> cVar, g gVar) {
        if (((Number) gVar.fold(0, new a(cVar))).intValue() == cVar.f1193f) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + cVar.f1192e + ",\n\t\tbut emission happened in " + gVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final j1 b(j1 j1Var, j1 j1Var2) {
        while (j1Var != null) {
            if (j1Var == j1Var2 || !(j1Var instanceof w)) {
                return j1Var;
            }
            j1Var = ((w) j1Var).x0();
        }
        return null;
    }
}
