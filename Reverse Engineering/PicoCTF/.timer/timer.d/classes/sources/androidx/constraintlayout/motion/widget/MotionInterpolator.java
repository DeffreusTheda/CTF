package androidx.constraintlayout.motion.widget;

import android.view.animation.Interpolator;

/* loaded from: /home/vinnie/CTF/Reverse Engineering/PicoCTF/timer/timer.d/classes.dex */
public abstract class MotionInterpolator implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public abstract float getInterpolation(float v);

    public abstract float getVelocity();
}
