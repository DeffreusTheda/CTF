package androidx.core.view;

import android.view.View;

/* loaded from: /home/vinnie/CTF/Reverse Engineering/PicoCTF/timer/timer.d/classes.dex */
public interface ViewPropertyAnimatorListener {
    void onAnimationCancel(View view);

    void onAnimationEnd(View view);

    void onAnimationStart(View view);
}
