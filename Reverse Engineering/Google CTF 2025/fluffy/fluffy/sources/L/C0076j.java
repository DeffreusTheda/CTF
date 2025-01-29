package l;

import android.view.WindowInsets;
import h.C0040b;

/* renamed from: l.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0076j extends AbstractC0078l {

    /* renamed from: a, reason: collision with root package name */
    public final WindowInsets.Builder f959a = AbstractC0075i.a();

    @Override // l.AbstractC0078l
    public s b() {
        WindowInsets build;
        a();
        build = this.f959a.build();
        s a2 = s.a(build, null);
        a2.f972a.j(null);
        return a2;
    }

    @Override // l.AbstractC0078l
    public void c(C0040b c0040b) {
        this.f959a.setStableInsets(c0040b.b());
    }

    @Override // l.AbstractC0078l
    public void d(C0040b c0040b) {
        this.f959a.setSystemWindowInsets(c0040b.b());
    }
}
