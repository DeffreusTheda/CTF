package com.google.android.material.shape;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* loaded from: classes.dex */
class ShapeableDelegateV22 extends ShapeableDelegate {
    private boolean canUseViewOutline = false;
    private float cornerRadius = 0.0f;

    ShapeableDelegateV22(View view) {
        initMaskOutlineProvider(view);
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    boolean shouldUseCompatClipping() {
        return !this.canUseViewOutline || this.forceCompatClippingEnabled;
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    void invalidateClippingMethod(View view) {
        this.cornerRadius = getDefaultCornerRadius();
        this.canUseViewOutline = isShapeRoundRect() || offsetZeroCornerEdgeBoundsIfPossible();
        view.setClipToOutline(!shouldUseCompatClipping());
        if (shouldUseCompatClipping()) {
            view.invalidate();
        } else {
            view.invalidateOutline();
        }
    }

    private float getDefaultCornerRadius() {
        if (this.shapeAppearanceModel == null || this.maskBounds == null) {
            return 0.0f;
        }
        return this.shapeAppearanceModel.topRightCornerSize.getCornerSize(this.maskBounds);
    }

    private boolean isShapeRoundRect() {
        if (this.maskBounds.isEmpty() || this.shapeAppearanceModel == null) {
            return false;
        }
        return this.shapeAppearanceModel.isRoundRect(this.maskBounds);
    }

    private boolean offsetZeroCornerEdgeBoundsIfPossible() {
        if (this.maskBounds.isEmpty() || this.shapeAppearanceModel == null || !this.offsetZeroCornerEdgeBoundsEnabled || this.shapeAppearanceModel.isRoundRect(this.maskBounds) || !shapeUsesAllRoundedCornerTreatments(this.shapeAppearanceModel)) {
            return false;
        }
        float topLeft = this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.maskBounds);
        float topRight = this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.maskBounds);
        float bottomLeft = this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.maskBounds);
        float bottomRight = this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.maskBounds);
        if (topLeft == 0.0f && bottomLeft == 0.0f && topRight == bottomRight) {
            this.maskBounds.set(this.maskBounds.left - topRight, this.maskBounds.top, this.maskBounds.right, this.maskBounds.bottom);
            this.cornerRadius = topRight;
            return true;
        }
        if (topLeft == 0.0f && topRight == 0.0f && bottomLeft == bottomRight) {
            this.maskBounds.set(this.maskBounds.left, this.maskBounds.top - bottomLeft, this.maskBounds.right, this.maskBounds.bottom);
            this.cornerRadius = bottomLeft;
            return true;
        }
        if (topRight == 0.0f && bottomRight == 0.0f && topLeft == bottomLeft) {
            this.maskBounds.set(this.maskBounds.left, this.maskBounds.top, this.maskBounds.right + topLeft, this.maskBounds.bottom);
            this.cornerRadius = topLeft;
            return true;
        }
        if (bottomLeft != 0.0f || bottomRight != 0.0f || topLeft != topRight) {
            return false;
        }
        this.maskBounds.set(this.maskBounds.left, this.maskBounds.top, this.maskBounds.right, this.maskBounds.bottom + topLeft);
        this.cornerRadius = topLeft;
        return true;
    }

    float getCornerRadius() {
        return this.cornerRadius;
    }

    private static boolean shapeUsesAllRoundedCornerTreatments(ShapeAppearanceModel model) {
        return (model.getTopLeftCorner() instanceof RoundedCornerTreatment) && (model.getTopRightCorner() instanceof RoundedCornerTreatment) && (model.getBottomLeftCorner() instanceof RoundedCornerTreatment) && (model.getBottomRightCorner() instanceof RoundedCornerTreatment);
    }

    private void initMaskOutlineProvider(View view) {
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.google.android.material.shape.ShapeableDelegateV22.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                if (ShapeableDelegateV22.this.shapeAppearanceModel != null && !ShapeableDelegateV22.this.maskBounds.isEmpty()) {
                    outline.setRoundRect((int) ShapeableDelegateV22.this.maskBounds.left, (int) ShapeableDelegateV22.this.maskBounds.top, (int) ShapeableDelegateV22.this.maskBounds.right, (int) ShapeableDelegateV22.this.maskBounds.bottom, ShapeableDelegateV22.this.cornerRadius);
                }
            }
        });
    }
}
