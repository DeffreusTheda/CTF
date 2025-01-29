package D;

import android.os.Build;
import java.util.Iterator;

/* renamed from: D.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0006g implements io.flutter.embedding.engine.renderer.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f60a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f61b;

    public /* synthetic */ C0006g(int i2, Object obj) {
        this.f60a = i2;
        this.f61b = obj;
    }

    @Override // io.flutter.embedding.engine.renderer.k
    public final void a() {
        switch (this.f60a) {
            case 0:
                C0008i c0008i = (C0008i) this.f61b;
                AbstractActivityC0005f abstractActivityC0005f = c0008i.f64a;
                if (Build.VERSION.SDK_INT >= 29) {
                    abstractActivityC0005f.reportFullyDrawn();
                } else {
                    abstractActivityC0005f.getClass();
                }
                c0008i.f70g = true;
                c0008i.f71h = true;
                break;
            case 1:
                C0014o c0014o = (C0014o) this.f61b;
                c0014o.setAlpha(1.0f);
                io.flutter.embedding.engine.renderer.j jVar = c0014o.f84c;
                if (jVar != null) {
                    jVar.f627a.removeIsDisplayingFlutterUiListener(this);
                    break;
                }
                break;
            default:
                y yVar = (y) this.f61b;
                yVar.f106g = true;
                Iterator it = yVar.f105f.iterator();
                while (it.hasNext()) {
                    ((io.flutter.embedding.engine.renderer.k) it.next()).a();
                }
                break;
        }
    }

    @Override // io.flutter.embedding.engine.renderer.k
    public final void b() {
        switch (this.f60a) {
            case 0:
                C0008i c0008i = (C0008i) this.f61b;
                c0008i.f64a.getClass();
                c0008i.f70g = false;
                break;
            case 1:
                break;
            default:
                y yVar = (y) this.f61b;
                yVar.f106g = false;
                Iterator it = yVar.f105f.iterator();
                while (it.hasNext()) {
                    ((io.flutter.embedding.engine.renderer.k) it.next()).b();
                }
                break;
        }
    }

    private final void c() {
    }
}
