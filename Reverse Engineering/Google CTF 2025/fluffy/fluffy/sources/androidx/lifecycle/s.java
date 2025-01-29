package androidx.lifecycle;

import android.app.Activity;

/* loaded from: classes.dex */
public abstract class s {
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Activity activity, f fVar) {
        a0.h.e(activity, "activity");
        a0.h.e(fVar, "event");
        if (activity instanceof l) {
            n a2 = ((l) activity).a();
            if (a2 instanceof n) {
                a2.c(fVar);
            }
        }
    }
}
