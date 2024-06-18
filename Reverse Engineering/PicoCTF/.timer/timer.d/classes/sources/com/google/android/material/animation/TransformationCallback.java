package com.google.android.material.animation;

import android.view.View;

/* loaded from: /home/vinnie/CTF/Reverse Engineering/PicoCTF/timer/timer.d/classes.dex */
public interface TransformationCallback<T extends View> {
    void onScaleChanged(T t);

    void onTranslationChanged(T t);
}
