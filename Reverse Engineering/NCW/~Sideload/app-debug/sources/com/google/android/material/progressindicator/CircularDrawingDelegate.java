package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.math.MathUtils;
import com.google.android.material.progressindicator.DrawingDelegate;

/* loaded from: classes.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private static final float ROUND_CAP_RAMP_DOWN_THRESHHOLD = 0.01f;
    private float adjustedRadius;
    private float displayedCornerRadius;
    private float displayedTrackThickness;
    private float totalTrackLengthFraction;
    private boolean useStrokeCap;

    CircularDrawingDelegate(CircularProgressIndicatorSpec spec) {
        super(spec);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    int getPreferredWidth() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    int getPreferredHeight() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void adjustCanvas(Canvas canvas, Rect bounds, float trackThicknessFraction, boolean isShowing, boolean isHiding) {
        float scaleX = bounds.width() / getPreferredWidth();
        float scaleY = bounds.height() / getPreferredHeight();
        float outerRadiusWithInset = (((CircularProgressIndicatorSpec) this.spec).indicatorSize / 2.0f) + ((CircularProgressIndicatorSpec) this.spec).indicatorInset;
        float scaledOuterRadiusWithInsetX = outerRadiusWithInset * scaleX;
        float scaledOuterRadiusWithInsetY = outerRadiusWithInset * scaleY;
        canvas.translate(bounds.left + scaledOuterRadiusWithInsetX, bounds.top + scaledOuterRadiusWithInsetY);
        canvas.rotate(-90.0f);
        canvas.scale(scaleX, scaleY);
        if (((CircularProgressIndicatorSpec) this.spec).indicatorDirection != 0) {
            canvas.scale(1.0f, -1.0f);
        }
        canvas.clipRect(-outerRadiusWithInset, -outerRadiusWithInset, outerRadiusWithInset, outerRadiusWithInset);
        this.useStrokeCap = ((CircularProgressIndicatorSpec) this.spec).trackThickness / 2 <= ((CircularProgressIndicatorSpec) this.spec).trackCornerRadius;
        this.displayedTrackThickness = ((CircularProgressIndicatorSpec) this.spec).trackThickness * trackThicknessFraction;
        this.displayedCornerRadius = Math.min(((CircularProgressIndicatorSpec) this.spec).trackThickness / 2, ((CircularProgressIndicatorSpec) this.spec).trackCornerRadius) * trackThicknessFraction;
        this.adjustedRadius = (((CircularProgressIndicatorSpec) this.spec).indicatorSize - ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        if (isShowing || isHiding) {
            if ((isShowing && ((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (isHiding && ((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
                this.adjustedRadius += ((1.0f - trackThicknessFraction) * ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
            } else if ((isShowing && ((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior == 1) || (isHiding && ((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 2)) {
                this.adjustedRadius -= ((1.0f - trackThicknessFraction) * ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
            }
        }
        if (isHiding && ((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 3) {
            this.totalTrackLengthFraction = trackThicknessFraction;
        } else {
            this.totalTrackLengthFraction = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillIndicator(Canvas canvas, Paint paint, DrawingDelegate.ActiveIndicator activeIndicator, int drawableAlpha) {
        int color = MaterialColors.compositeARGBWithAlpha(activeIndicator.color, drawableAlpha);
        drawArc(canvas, paint, activeIndicator.startFraction, activeIndicator.endFraction, color, activeIndicator.gapSize, activeIndicator.gapSize);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillTrack(Canvas canvas, Paint paint, float startFraction, float endFraction, int color, int drawableAlpha, int gapSize) {
        drawArc(canvas, paint, startFraction, endFraction, MaterialColors.compositeARGBWithAlpha(color, drawableAlpha), gapSize, gapSize);
    }

    private void drawArc(Canvas canvas, Paint paint, float startFraction, float endFraction, int paintColor, int startGapSize, int endGapSize) {
        float f;
        if (endFraction >= startFraction) {
            f = endFraction - startFraction;
        } else {
            f = (endFraction + 1.0f) - startFraction;
        }
        float arcFraction = f;
        float startFraction2 = startFraction % 1.0f;
        if (this.totalTrackLengthFraction >= 1.0f || startFraction2 + arcFraction <= 1.0f) {
            float displayedCornerRadiusInDegree = (float) Math.toDegrees(this.displayedCornerRadius / this.adjustedRadius);
            if (startFraction2 == 0.0f && arcFraction >= 0.99f) {
                arcFraction += ((arcFraction - 0.99f) * ((displayedCornerRadiusInDegree * 2.0f) / 360.0f)) / ROUND_CAP_RAMP_DOWN_THRESHHOLD;
            }
            float startFraction3 = MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, startFraction2);
            float arcFraction2 = MathUtils.lerp(0.0f, this.totalTrackLengthFraction, arcFraction);
            float startGapSizeInDegrees = (float) Math.toDegrees(startGapSize / this.adjustedRadius);
            float endGapSizeInDegrees = (float) Math.toDegrees(endGapSize / this.adjustedRadius);
            float arcDegree = ((arcFraction2 * 360.0f) - startGapSizeInDegrees) - endGapSizeInDegrees;
            float startDegree = (360.0f * startFraction3) + startGapSizeInDegrees;
            if (arcDegree <= 0.0f) {
                return;
            }
            paint.setAntiAlias(true);
            paint.setColor(paintColor);
            paint.setStrokeWidth(this.displayedTrackThickness);
            if (arcDegree >= displayedCornerRadiusInDegree * 2.0f) {
                float f2 = this.adjustedRadius;
                RectF arcBound = new RectF(-f2, -f2, f2, f2);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeCap(this.useStrokeCap ? Paint.Cap.ROUND : Paint.Cap.BUTT);
                canvas.drawArc(arcBound, startDegree + displayedCornerRadiusInDegree, arcDegree - (displayedCornerRadiusInDegree * 2.0f), false, paint);
                if (!this.useStrokeCap && this.displayedCornerRadius > 0.0f) {
                    paint.setStyle(Paint.Style.FILL);
                    drawRoundedBlock(canvas, paint, startDegree + displayedCornerRadiusInDegree, this.displayedCornerRadius * 2.0f, this.displayedTrackThickness);
                    drawRoundedBlock(canvas, paint, (startDegree + arcDegree) - displayedCornerRadiusInDegree, this.displayedCornerRadius * 2.0f, this.displayedTrackThickness);
                    return;
                }
                return;
            }
            float shrinkRatio = arcDegree / (displayedCornerRadiusInDegree * 2.0f);
            paint.setStyle(Paint.Style.FILL);
            drawRoundedBlock(canvas, paint, startDegree + (displayedCornerRadiusInDegree * shrinkRatio), this.displayedCornerRadius * 2.0f, this.displayedTrackThickness, shrinkRatio);
            return;
        }
        drawArc(canvas, paint, startFraction2, 1.0f, paintColor, startGapSize, 0);
        drawArc(canvas, paint, 1.0f, startFraction2 + arcFraction, paintColor, 0, endGapSize);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void drawStopIndicator(Canvas canvas, Paint paint, int color, int drawableAlpha) {
    }

    private int getSize() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorSize + (((CircularProgressIndicatorSpec) this.spec).indicatorInset * 2);
    }

    private void drawRoundedBlock(Canvas canvas, Paint paint, float positionInDeg, float markWidth, float markHeight) {
        drawRoundedBlock(canvas, paint, positionInDeg, markWidth, markHeight, 1.0f);
    }

    private void drawRoundedBlock(Canvas canvas, Paint paint, float positionInDeg, float markWidth, float markHeight, float scale) {
        float markHeight2 = (int) Math.min(markHeight, this.displayedTrackThickness);
        float markCornerSize = Math.min(markWidth / 2.0f, (this.displayedCornerRadius * markHeight2) / this.displayedTrackThickness);
        RectF roundedBlock = new RectF((-markHeight2) / 2.0f, (-markWidth) / 2.0f, markHeight2 / 2.0f, markWidth / 2.0f);
        canvas.save();
        canvas.translate((float) (this.adjustedRadius * Math.cos(Math.toRadians(positionInDeg))), (float) (this.adjustedRadius * Math.sin(Math.toRadians(positionInDeg))));
        canvas.rotate(positionInDeg);
        canvas.scale(scale, scale);
        canvas.drawRoundRect(roundedBlock, markCornerSize, markCornerSize, paint);
        canvas.restore();
    }
}
