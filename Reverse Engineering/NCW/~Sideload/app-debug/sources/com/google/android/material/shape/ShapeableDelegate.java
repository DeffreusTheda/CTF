package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import com.google.android.material.canvas.CanvasCompat;

/* loaded from: classes.dex */
public abstract class ShapeableDelegate {
    ShapeAppearanceModel shapeAppearanceModel;
    boolean forceCompatClippingEnabled = false;
    boolean offsetZeroCornerEdgeBoundsEnabled = false;
    RectF maskBounds = new RectF();
    final Path shapePath = new Path();

    abstract void invalidateClippingMethod(View view);

    abstract boolean shouldUseCompatClipping();

    public static ShapeableDelegate create(View view) {
        if (Build.VERSION.SDK_INT >= 33) {
            return new ShapeableDelegateV33(view);
        }
        return new ShapeableDelegateV22(view);
    }

    public boolean isForceCompatClippingEnabled() {
        return this.forceCompatClippingEnabled;
    }

    public void setForceCompatClippingEnabled(View view, boolean enabled) {
        if (enabled != this.forceCompatClippingEnabled) {
            this.forceCompatClippingEnabled = enabled;
            invalidateClippingMethod(view);
        }
    }

    public void setOffsetZeroCornerEdgeBoundsEnabled(View view, boolean enabled) {
        this.offsetZeroCornerEdgeBoundsEnabled = enabled;
        invalidateClippingMethod(view);
    }

    public void onShapeAppearanceChanged(View view, ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        updateShapePath();
        invalidateClippingMethod(view);
    }

    public void onMaskChanged(View view, RectF maskBounds) {
        this.maskBounds = maskBounds;
        updateShapePath();
        invalidateClippingMethod(view);
    }

    private void updateShapePath() {
        if (isMaskBoundsValid() && this.shapeAppearanceModel != null) {
            ShapeAppearancePathProvider.getInstance().calculatePath(this.shapeAppearanceModel, 1.0f, this.maskBounds, this.shapePath);
        }
    }

    private boolean isMaskBoundsValid() {
        return this.maskBounds.left <= this.maskBounds.right && this.maskBounds.top <= this.maskBounds.bottom;
    }

    public void maybeClip(Canvas canvas, CanvasCompat.CanvasOperation op) {
        if (shouldUseCompatClipping() && !this.shapePath.isEmpty()) {
            canvas.save();
            canvas.clipPath(this.shapePath);
            op.run(canvas);
            canvas.restore();
            return;
        }
        op.run(canvas);
    }
}
