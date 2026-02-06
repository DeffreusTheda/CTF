package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;

/* loaded from: classes.dex */
public abstract class CarouselStrategy {
    private float smallSizeMax;
    private float smallSizeMin;

    abstract KeylineState onFirstChildMeasuredWithMargins(Carousel carousel, View view);

    void initialize(Context context) {
        float f = this.smallSizeMin;
        if (f <= 0.0f) {
            f = CarouselStrategyHelper.getSmallSizeMin(context);
        }
        this.smallSizeMin = f;
        float f2 = this.smallSizeMax;
        if (f2 <= 0.0f) {
            f2 = CarouselStrategyHelper.getSmallSizeMax(context);
        }
        this.smallSizeMax = f2;
    }

    static float getChildMaskPercentage(float maskedSize, float unmaskedSize, float childMargins) {
        return 1.0f - ((maskedSize - childMargins) / (unmaskedSize - childMargins));
    }

    static int[] doubleCounts(int[] count) {
        int[] doubledCount = new int[count.length];
        for (int i = 0; i < doubledCount.length; i++) {
            doubledCount[i] = count[i] * 2;
        }
        return doubledCount;
    }

    boolean isContained() {
        return true;
    }

    boolean shouldRefreshKeylineState(Carousel carousel, int oldItemCount) {
        return false;
    }

    public void setSmallItemSizeMin(float minSmallItemSize) {
        this.smallSizeMin = minSmallItemSize;
    }

    public void setSmallItemSizeMax(float maxSmallItemSize) {
        this.smallSizeMax = maxSmallItemSize;
    }

    public float getSmallItemSizeMin() {
        return this.smallSizeMin;
    }

    public float getSmallItemSizeMax() {
        return this.smallSizeMax;
    }
}
