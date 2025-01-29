package m0;

/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1035a = 0;

    static {
        Object f2;
        Object f3;
        Exception exc = new Exception();
        String simpleName = a.a.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        new StackTraceElement("_COROUTINE.".concat(simpleName), "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            f2 = U.b.class.getCanonicalName();
        } catch (Throwable th) {
            f2 = a.a.f(th);
        }
        if (Q.d.a(f2) != null) {
            f2 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        try {
            f3 = w.class.getCanonicalName();
        } catch (Throwable th2) {
            f3 = a.a.f(th2);
        }
        if (Q.d.a(f3) != null) {
            f3 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }
}
