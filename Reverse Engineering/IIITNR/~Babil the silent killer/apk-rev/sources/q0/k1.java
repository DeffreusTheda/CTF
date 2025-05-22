package q0;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class k1 extends CancellationException {

    /* renamed from: d, reason: collision with root package name */
    public final j1 f1023d;

    public k1(String str, Throwable th, j1 j1Var) {
        super(str);
        this.f1023d = j1Var;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof k1) {
                k1 k1Var = (k1) obj;
                if (!kotlin.jvm.internal.i.a(k1Var.getMessage(), getMessage()) || !kotlin.jvm.internal.i.a(k1Var.f1023d, this.f1023d) || !kotlin.jvm.internal.i.a(k1Var.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        kotlin.jvm.internal.i.b(message);
        int hashCode = ((message.hashCode() * 31) + this.f1023d.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause == null ? 0 : cause.hashCode());
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f1023d;
    }
}
