package com.google.android.material.drawable;

import android.graphics.drawable.Drawable;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;

/* loaded from: classes.dex */
public class ScaledDrawableWrapper extends DrawableWrapperCompat {
    private final int height;
    private final int width;

    public ScaledDrawableWrapper(Drawable drawable, int width, int height) {
        super(drawable);
        this.width = width;
        this.height = height;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.width;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.height;
    }
}
