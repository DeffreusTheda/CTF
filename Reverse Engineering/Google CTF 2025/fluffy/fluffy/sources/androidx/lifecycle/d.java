package androidx.lifecycle;

/* loaded from: classes.dex */
public final class d {
    public static f a(g gVar) {
        a0.h.e(gVar, "state");
        int ordinal = gVar.ordinal();
        if (ordinal == 1) {
            return f.ON_CREATE;
        }
        if (ordinal == 2) {
            return f.ON_START;
        }
        if (ordinal != 3) {
            return null;
        }
        return f.ON_RESUME;
    }
}
