package androidx.core.provider;

import android.os.Handler;
import android.os.Looper;

/* loaded from: /home/vinnie/CTF/Reverse Engineering/PicoCTF/timer/timer.d/classes.dex */
class CalleeHandler {
    private CalleeHandler() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Handler create() {
        if (Looper.myLooper() == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            return handler;
        }
        Handler handler2 = new Handler();
        return handler2;
    }
}
