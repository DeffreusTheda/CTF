package E;

import D.AbstractActivityC0005f;
import android.content.Intent;
import androidx.lifecycle.n;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractActivityC0005f f145a;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f146b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f147c = new HashSet();

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f148d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f149e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public final HashSet f150f;

    public d(AbstractActivityC0005f abstractActivityC0005f, n nVar) {
        new HashSet();
        this.f150f = new HashSet();
        this.f145a = abstractActivityC0005f;
        new HiddenLifecycleReference(nVar);
    }

    public final boolean a(int i2, int i3, Intent intent) {
        Iterator it = new HashSet(this.f147c).iterator();
        while (true) {
            boolean z2 = false;
            while (it.hasNext()) {
                HashMap hashMap = ((O.a) it.next()).f319d;
                if (hashMap.containsKey(Integer.valueOf(i2))) {
                    ((K.k) hashMap.remove(Integer.valueOf(i2))).c(i3 == -1 ? intent.getStringExtra("android.intent.extra.PROCESS_TEXT") : null);
                } else if (z2) {
                }
                z2 = true;
            }
            return z2;
        }
    }
}
