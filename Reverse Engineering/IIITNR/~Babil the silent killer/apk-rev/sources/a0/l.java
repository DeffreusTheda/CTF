package a0;

import a0.k;

/* loaded from: classes.dex */
public final class l {
    public static final Object a(Throwable exception) {
        kotlin.jvm.internal.i.e(exception, "exception");
        return new k.b(exception);
    }

    public static final void b(Object obj) {
        if (obj instanceof k.b) {
            throw ((k.b) obj).f17d;
        }
    }
}
