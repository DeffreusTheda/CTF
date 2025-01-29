package f;

/* renamed from: f.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0034e extends a.a {
    @Override // a.a
    public final boolean c(AbstractFutureC0036g abstractFutureC0036g, C0032c c0032c) {
        C0032c c0032c2 = C0032c.f491b;
        synchronized (abstractFutureC0036g) {
            try {
                if (abstractFutureC0036g.f506b != c0032c) {
                    return false;
                }
                abstractFutureC0036g.f506b = c0032c2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a.a
    public final boolean d(AbstractFutureC0036g abstractFutureC0036g, Object obj, Object obj2) {
        synchronized (abstractFutureC0036g) {
            try {
                if (abstractFutureC0036g.f505a != obj) {
                    return false;
                }
                abstractFutureC0036g.f505a = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a.a
    public final boolean e(AbstractFutureC0036g abstractFutureC0036g, C0035f c0035f, C0035f c0035f2) {
        synchronized (abstractFutureC0036g) {
            try {
                if (abstractFutureC0036g.f507c != c0035f) {
                    return false;
                }
                abstractFutureC0036g.f507c = c0035f2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a.a
    public final void s(C0035f c0035f, C0035f c0035f2) {
        c0035f.f500b = c0035f2;
    }

    @Override // a.a
    public final void t(C0035f c0035f, Thread thread) {
        c0035f.f499a = thread;
    }
}
