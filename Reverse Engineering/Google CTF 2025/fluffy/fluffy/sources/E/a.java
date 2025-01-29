package E;

import android.util.SparseArray;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f122a;

    public a(c cVar) {
        this.f122a = cVar;
    }

    @Override // E.b
    public final void a() {
        c cVar = this.f122a;
        Iterator it = cVar.f143t.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a();
        }
        while (true) {
            io.flutter.plugin.platform.k kVar = cVar.f141r;
            SparseArray sparseArray = kVar.f727j;
            if (sparseArray.size() <= 0) {
                break;
            }
            kVar.f736t.h(sparseArray.keyAt(0));
        }
        while (true) {
            io.flutter.plugin.platform.j jVar = cVar.f142s;
            SparseArray sparseArray2 = jVar.f712g;
            if (sparseArray2.size() <= 0) {
                cVar.f135k.f267b = null;
                return;
            } else {
                jVar.m.c(sparseArray2.keyAt(0));
            }
        }
    }

    @Override // E.b
    public final void b() {
    }
}
