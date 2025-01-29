package l;

import android.view.WindowInsets;
import h.C0040b;

/* renamed from: l.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0080n extends AbstractC0079m {

    /* renamed from: k, reason: collision with root package name */
    public C0040b f968k;

    public C0080n(s sVar, WindowInsets windowInsets) {
        super(sVar, windowInsets);
        this.f968k = null;
    }

    @Override // l.r
    public s b() {
        return s.a(this.f965c.consumeStableInsets(), null);
    }

    @Override // l.r
    public s c() {
        return s.a(this.f965c.consumeSystemWindowInsets(), null);
    }

    @Override // l.r
    public final C0040b f() {
        if (this.f968k == null) {
            WindowInsets windowInsets = this.f965c;
            this.f968k = C0040b.a(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f968k;
    }

    @Override // l.r
    public boolean h() {
        return this.f965c.isConsumed();
    }

    @Override // l.r
    public void l(C0040b c0040b) {
        this.f968k = c0040b;
    }
}
