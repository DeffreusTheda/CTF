package p0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    public static <T> void a(Appendable appendable, T t2, j0.l<? super T, ? extends CharSequence> lVar) {
        CharSequence valueOf;
        kotlin.jvm.internal.i.e(appendable, "<this>");
        if (lVar != null) {
            t2 = (T) lVar.invoke(t2);
        } else {
            if (!(t2 == 0 ? true : t2 instanceof CharSequence)) {
                if (t2 instanceof Character) {
                    appendable.append(((Character) t2).charValue());
                    return;
                } else {
                    valueOf = String.valueOf((Object) t2);
                    appendable.append(valueOf);
                }
            }
        }
        valueOf = (CharSequence) t2;
        appendable.append(valueOf);
    }
}
