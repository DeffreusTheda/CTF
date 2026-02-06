package com.google.android.material.carousel;

import android.view.View;

/* loaded from: classes.dex */
public abstract class CarouselStrategy {
    static float getChildMaskPercentage(float f, float f2, float f3) {
        return 1.0f - ((f - f3) / (f2 - f3));
    }

    boolean isContained() {
        return true;
    }

    abstract KeylineState onFirstChildMeasuredWithMargins(Carousel carousel, View view);
}
