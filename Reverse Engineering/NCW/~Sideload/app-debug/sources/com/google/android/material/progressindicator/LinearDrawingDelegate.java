package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.core.math.MathUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.DrawingDelegate;

/* loaded from: classes.dex */
final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float displayedCornerRadius;
    private float displayedTrackThickness;
    private float totalTrackLengthFraction;
    private float trackLength;
    private boolean useStrokeCap;

    LinearDrawingDelegate(LinearProgressIndicatorSpec spec) {
        super(spec);
        this.trackLength = 300.0f;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    int getPreferredWidth() {
        return -1;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    int getPreferredHeight() {
        return ((LinearProgressIndicatorSpec) this.spec).trackThickness;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void adjustCanvas(Canvas canvas, Rect bounds, float trackThicknessFraction, boolean isShowing, boolean isHiding) {
        this.trackLength = bounds.width();
        float trackSize = ((LinearProgressIndicatorSpec) this.spec).trackThickness;
        canvas.translate(bounds.left + (bounds.width() / 2.0f), bounds.top + (bounds.height() / 2.0f) + Math.max(0.0f, (bounds.height() - trackSize) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        float halfTrackLength = this.trackLength / 2.0f;
        float halfTrackSize = trackSize / 2.0f;
        canvas.clipRect(-halfTrackLength, -halfTrackSize, halfTrackLength, halfTrackSize);
        this.useStrokeCap = ((LinearProgressIndicatorSpec) this.spec).trackThickness / 2 == ((LinearProgressIndicatorSpec) this.spec).trackCornerRadius;
        this.displayedTrackThickness = ((LinearProgressIndicatorSpec) this.spec).trackThickness * trackThicknessFraction;
        this.displayedCornerRadius = Math.min(((LinearProgressIndicatorSpec) this.spec).trackThickness / 2, ((LinearProgressIndicatorSpec) this.spec).trackCornerRadius) * trackThicknessFraction;
        if (isShowing || isHiding) {
            if ((isShowing && ((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (isHiding && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (isShowing || (isHiding && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 3)) {
                canvas.translate(0.0f, (((LinearProgressIndicatorSpec) this.spec).trackThickness * (1.0f - trackThicknessFraction)) / 2.0f);
            }
        }
        if (isHiding && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 3) {
            this.totalTrackLengthFraction = trackThicknessFraction;
        } else {
            this.totalTrackLengthFraction = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillIndicator(Canvas canvas, Paint paint, DrawingDelegate.ActiveIndicator activeIndicator, int drawableAlpha) {
        int color = MaterialColors.compositeARGBWithAlpha(activeIndicator.color, drawableAlpha);
        drawLine(canvas, paint, activeIndicator.startFraction, activeIndicator.endFraction, color, activeIndicator.gapSize, activeIndicator.gapSize);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillTrack(Canvas canvas, Paint paint, float startFraction, float endFraction, int color, int drawableAlpha, int gapSize) {
        drawLine(canvas, paint, startFraction, endFraction, MaterialColors.compositeARGBWithAlpha(color, drawableAlpha), gapSize, gapSize);
    }

    private void drawLine(Canvas canvas, Paint paint, float startFraction, float endFraction, int paintColor, int startGapSize, int endGapSize) {
        float startFraction2 = MathUtils.clamp(startFraction, 0.0f, 1.0f);
        float endFraction2 = MathUtils.clamp(endFraction, 0.0f, 1.0f);
        float startFraction3 = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, startFraction2);
        float startFraction4 = this.totalTrackLengthFraction;
        float endFraction3 = com.google.android.material.math.MathUtils.lerp(1.0f - startFraction4, 1.0f, endFraction2);
        int startGapSize2 = (int) ((startGapSize * MathUtils.clamp(startFraction3, 0.0f, 0.01f)) / 0.01f);
        int endGapSize2 = (int) ((endGapSize * (1.0f - MathUtils.clamp(endFraction3, 0.99f, 1.0f))) / 0.01f);
        float f = this.trackLength;
        int startPx = (int) ((startFraction3 * f) + startGapSize2);
        int endPx = (int) ((endFraction3 * f) - endGapSize2);
        float originX = (-f) / 2.0f;
        if (startPx <= endPx) {
            float f2 = this.displayedCornerRadius;
            float startBlockCenterX = startPx + f2;
            float endBlockCenterX = endPx - f2;
            float blockWidth = f2 * 2.0f;
            paint.setColor(paintColor);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(this.displayedTrackThickness);
            if (startBlockCenterX >= endBlockCenterX) {
                drawRoundedBlock(canvas, paint, new PointF(startBlockCenterX + originX, 0.0f), new PointF(endBlockCenterX + originX, 0.0f), blockWidth, this.displayedTrackThickness);
                return;
            }
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(this.useStrokeCap ? Paint.Cap.ROUND : Paint.Cap.BUTT);
            canvas.drawLine(startBlockCenterX + originX, 0.0f, endBlockCenterX + originX, 0.0f, paint);
            if (!this.useStrokeCap && this.displayedCornerRadius > 0.0f) {
                paint.setStyle(Paint.Style.FILL);
                if (startBlockCenterX > 0.0f) {
                    drawRoundedBlock(canvas, paint, new PointF(startBlockCenterX + originX, 0.0f), blockWidth, this.displayedTrackThickness);
                }
                if (endBlockCenterX < this.trackLength) {
                    drawRoundedBlock(canvas, paint, new PointF(endBlockCenterX + originX, 0.0f), blockWidth, this.displayedTrackThickness);
                }
            }
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void drawStopIndicator(Canvas canvas, Paint paint, int color, int drawableAlpha) {
        int paintColor = MaterialColors.compositeARGBWithAlpha(color, drawableAlpha);
        if (((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize > 0 && paintColor != 0) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(paintColor);
            drawRoundedBlock(canvas, paint, new PointF((this.trackLength / 2.0f) - (this.displayedTrackThickness / 2.0f), 0.0f), ((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize, ((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize);
        }
    }

    private void drawRoundedBlock(Canvas canvas, Paint paint, PointF center, float markWidth, float markHeight) {
        drawRoundedBlock(canvas, paint, center, null, markWidth, markHeight);
    }

    private void drawRoundedBlock(Canvas canvas, Paint paint, PointF drawCenter, PointF clipCenter, float markWidth, float markHeight) {
        float markHeight2 = Math.min(markHeight, this.displayedTrackThickness);
        float markCornerSize = Math.min(markWidth / 2.0f, (this.displayedCornerRadius * markHeight2) / this.displayedTrackThickness);
        RectF roundedBlock = new RectF((-markWidth) / 2.0f, (-markHeight2) / 2.0f, markWidth / 2.0f, markHeight2 / 2.0f);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        if (clipCenter != null) {
            canvas.translate(clipCenter.x, clipCenter.y);
            Path clipPath = new Path();
            clipPath.addRoundRect(roundedBlock, markCornerSize, markCornerSize, Path.Direction.CCW);
            canvas.clipPath(clipPath);
            canvas.translate(-clipCenter.x, -clipCenter.y);
        }
        canvas.translate(drawCenter.x, drawCenter.y);
        canvas.drawRoundRect(roundedBlock, markCornerSize, markCornerSize, paint);
        canvas.restore();
    }
}
