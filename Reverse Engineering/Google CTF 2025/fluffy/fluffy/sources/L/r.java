package l;

import android.os.Build;
import android.view.View;
import h.C0040b;
import java.util.Objects;

/* loaded from: classes.dex */
public class r {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f970b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final s f971a;

    static {
        int i2 = Build.VERSION.SDK_INT;
        (i2 >= 30 ? new C0077k() : i2 >= 29 ? new C0076j() : new C0074h()).b().f972a.a().f972a.b().f972a.c();
    }

    public r(s sVar) {
        this.f971a = sVar;
    }

    public s a() {
        return this.f971a;
    }

    public s b() {
        return this.f971a;
    }

    public s c() {
        return this.f971a;
    }

    public C0067a e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return i() == rVar.i() && h() == rVar.h() && Objects.equals(g(), rVar.g()) && Objects.equals(f(), rVar.f()) && Objects.equals(e(), rVar.e());
    }

    public C0040b f() {
        return C0040b.f510e;
    }

    public C0040b g() {
        return C0040b.f510e;
    }

    public boolean h() {
        return false;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(i()), Boolean.valueOf(h()), g(), f(), e());
    }

    public boolean i() {
        return false;
    }

    public void d(View view) {
    }

    public void j(C0040b[] c0040bArr) {
    }

    public void k(s sVar) {
    }

    public void l(C0040b c0040b) {
    }
}
