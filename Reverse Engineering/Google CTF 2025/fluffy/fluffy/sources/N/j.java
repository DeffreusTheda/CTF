package n;

import android.content.Context;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1075b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f1076c;

    public /* synthetic */ j(Context context, int i2) {
        this.f1075b = i2;
        this.f1076c = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1075b) {
            case 0:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new j(this.f1076c, 1));
                break;
            default:
                h.s(this.f1076c, new f(), h.f1063a, false);
                break;
        }
    }
}
