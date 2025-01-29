package n;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public abstract class n {
    public static Handler a(Looper looper) {
        Handler createAsync;
        createAsync = Handler.createAsync(looper);
        return createAsync;
    }
}
