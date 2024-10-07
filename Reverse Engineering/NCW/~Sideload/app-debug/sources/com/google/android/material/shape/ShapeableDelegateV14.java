package com.google.android.material.shape;

import android.view.View;

/* loaded from: classes.dex */
class ShapeableDelegateV14 extends ShapeableDelegate {
    ShapeableDelegateV14() {
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    boolean shouldUseCompatClipping() {
        return true;
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    void invalidateClippingMethod(View view) {
        if (this.shapeAppearanceModel != null && !this.maskBounds.isEmpty() && shouldUseCompatClipping()) {
            view.invalidate();
        }
    }
}
