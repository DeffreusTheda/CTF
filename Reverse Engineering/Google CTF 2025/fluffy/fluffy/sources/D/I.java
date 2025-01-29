package D;

/* loaded from: classes.dex */
public final class I {

    /* renamed from: a, reason: collision with root package name */
    public boolean f31a = false;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ J f32b;

    public I(J j2) {
        this.f32b = j2;
    }

    public final void a(boolean z2) {
        if (this.f31a) {
            throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
        }
        this.f31a = true;
        J j2 = this.f32b;
        int i2 = j2.f34b - 1;
        j2.f34b = i2;
        boolean z3 = z2 | j2.f35c;
        j2.f35c = z3;
        if (i2 != 0 || z3) {
            return;
        }
        j2.f36d.h(j2.f33a);
    }
}
