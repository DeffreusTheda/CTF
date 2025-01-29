package n;

import android.view.Choreographer;

/* loaded from: classes.dex */
public abstract class l {
    public static void a(final Runnable runnable) {
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: n.k
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j2) {
                runnable.run();
            }
        });
    }
}
