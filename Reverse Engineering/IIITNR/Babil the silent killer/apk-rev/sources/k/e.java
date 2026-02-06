package k;

import android.os.Handler;
import android.os.Looper;
import k.c;

/* loaded from: classes.dex */
public class e implements c.b {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f769a = z.a.a(Looper.getMainLooper());

    @Override // k.c.b
    public void a(Runnable runnable) {
        this.f769a.post(runnable);
    }
}
