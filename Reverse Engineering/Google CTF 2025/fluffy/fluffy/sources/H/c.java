package H;

import a0.h;
import androidx.lifecycle.n;
import androidx.lifecycle.r;
import io.flutter.plugin.platform.k;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f210b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f211c;

    public /* synthetic */ c(int i2, Object obj) {
        this.f210b = i2;
        this.f211c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f210b) {
            case 0:
                ((d) this.f211c).f213b.f220e.prefetchDefaultFontManager();
                break;
            case 1:
                r rVar = (r) this.f211c;
                h.e(rVar, "this$0");
                int i2 = rVar.f422b;
                n nVar = rVar.f426f;
                if (i2 == 0) {
                    rVar.f423c = true;
                    nVar.c(androidx.lifecycle.f.ON_PAUSE);
                }
                if (rVar.f421a == 0 && rVar.f423c) {
                    nVar.c(androidx.lifecycle.f.ON_STOP);
                    rVar.f424d = true;
                    break;
                }
                break;
            default:
                ((k) this.f211c).f(false);
                break;
        }
    }
}
