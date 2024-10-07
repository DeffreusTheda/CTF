package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* loaded from: classes.dex */
abstract class DrawingDelegate<S extends BaseProgressIndicatorSpec> {
    S spec;

    abstract void adjustCanvas(Canvas canvas, Rect rect, float f, boolean z, boolean z2);

    abstract void drawStopIndicator(Canvas canvas, Paint paint, int i, int i2);

    abstract void fillIndicator(Canvas canvas, Paint paint, ActiveIndicator activeIndicator, int i);

    abstract void fillTrack(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3);

    abstract int getPreferredHeight();

    abstract int getPreferredWidth();

    public DrawingDelegate(S spec) {
        this.spec = spec;
    }

    void validateSpecAndAdjustCanvas(Canvas canvas, Rect bounds, float trackThicknessFraction, boolean isShowing, boolean isHiding) {
        this.spec.validateSpec();
        adjustCanvas(canvas, bounds, trackThicknessFraction, isShowing, isHiding);
    }

    protected static class ActiveIndicator {
        int color;
        float endFraction;
        int gapSize;
        float startFraction;

        protected ActiveIndicator() {
        }
    }
}
