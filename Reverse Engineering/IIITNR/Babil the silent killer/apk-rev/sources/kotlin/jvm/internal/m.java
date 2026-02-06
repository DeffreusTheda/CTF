package kotlin.jvm.internal;

/* loaded from: classes.dex */
public class m {
    public n0.e a(g gVar) {
        return gVar;
    }

    public n0.c b(Class cls) {
        return new c(cls);
    }

    public n0.d c(Class cls, String str) {
        return new k(cls, str);
    }

    public String d(f fVar) {
        String obj = fVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    public String e(j jVar) {
        return d(jVar);
    }
}
