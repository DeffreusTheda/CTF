package h;

import android.os.Trace;

/* loaded from: classes.dex */
final class c {
    public static void a(String str, int i2) {
        Trace.beginAsyncSection(str, i2);
    }

    public static void b(String str, int i2) {
        Trace.endAsyncSection(str, i2);
    }
}
