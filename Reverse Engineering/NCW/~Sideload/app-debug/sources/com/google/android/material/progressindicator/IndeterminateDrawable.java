package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.google.android.material.R;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.DrawingDelegate;

/* loaded from: classes.dex */
public final class IndeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    private IndeterminateAnimatorDelegate<ObjectAnimator> animatorDelegate;
    private DrawingDelegate<S> drawingDelegate;
    private Drawable staticDummyDrawable;

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean hideNow() {
        return super.hideNow();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean isHiding() {
        return super.isHiding();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean isShowing() {
        return super.isShowing();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        super.registerAnimationCallback(animationCallback);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z, boolean z2, boolean z3) {
        return super.setVisible(z, z2, z3);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        return super.unregisterAnimationCallback(animationCallback);
    }

    IndeterminateDrawable(Context context, BaseProgressIndicatorSpec baseSpec, DrawingDelegate<S> drawingDelegate, IndeterminateAnimatorDelegate<ObjectAnimator> animatorDelegate) {
        super(context, baseSpec);
        setDrawingDelegate(drawingDelegate);
        setAnimatorDelegate(animatorDelegate);
    }

    public static IndeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(Context context, LinearProgressIndicatorSpec spec) {
        return createLinearDrawable(context, spec, new LinearDrawingDelegate(spec));
    }

    static IndeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(Context context, LinearProgressIndicatorSpec spec, LinearDrawingDelegate drawingDelegate) {
        IndeterminateAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate;
        if (spec.indeterminateAnimationType == 0) {
            linearIndeterminateDisjointAnimatorDelegate = new LinearIndeterminateContiguousAnimatorDelegate(spec);
        } else {
            linearIndeterminateDisjointAnimatorDelegate = new LinearIndeterminateDisjointAnimatorDelegate(context, spec);
        }
        return new IndeterminateDrawable<>(context, spec, drawingDelegate, linearIndeterminateDisjointAnimatorDelegate);
    }

    public static IndeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(Context context, CircularProgressIndicatorSpec spec) {
        return createCircularDrawable(context, spec, new CircularDrawingDelegate(spec));
    }

    static IndeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(Context context, CircularProgressIndicatorSpec spec, CircularDrawingDelegate drawingDelegate) {
        IndeterminateDrawable<CircularProgressIndicatorSpec> indeterminateDrawable = new IndeterminateDrawable<>(context, spec, drawingDelegate, new CircularIndeterminateAnimatorDelegate(spec));
        indeterminateDrawable.setStaticDummyDrawable(VectorDrawableCompat.create(context.getResources(), R.drawable.indeterminate_static, null));
        return indeterminateDrawable;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    boolean setVisibleInternal(boolean visible, boolean restart, boolean animate) {
        Drawable drawable;
        boolean changed = super.setVisibleInternal(visible, restart, animate);
        if (isSystemAnimatorDisabled() && (drawable = this.staticDummyDrawable) != null) {
            return drawable.setVisible(visible, restart);
        }
        if (!isRunning()) {
            this.animatorDelegate.cancelAnimatorImmediately();
        }
        if (visible && animate) {
            this.animatorDelegate.startAnimator();
        }
        return changed;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.drawingDelegate.getPreferredWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.drawingDelegate.getPreferredHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable;
        Rect clipBounds = new Rect();
        if (getBounds().isEmpty() || !isVisible() || !canvas.getClipBounds(clipBounds)) {
            return;
        }
        if (isSystemAnimatorDisabled() && (drawable = this.staticDummyDrawable) != null) {
            drawable.setBounds(getBounds());
            DrawableCompat.setTint(this.staticDummyDrawable, this.baseSpec.indicatorColors[0]);
            this.staticDummyDrawable.draw(canvas);
            return;
        }
        canvas.save();
        this.drawingDelegate.validateSpecAndAdjustCanvas(canvas, getBounds(), getGrowFraction(), isShowing(), isHiding());
        int gapSize = this.baseSpec.indicatorTrackGapSize;
        int trackAlpha = getAlpha();
        if (gapSize == 0) {
            this.drawingDelegate.fillTrack(canvas, this.paint, 0.0f, 1.0f, this.baseSpec.trackColor, trackAlpha, 0);
        } else {
            DrawingDelegate.ActiveIndicator firstIndicator = this.animatorDelegate.activeIndicators.get(0);
            DrawingDelegate.ActiveIndicator lastIndicator = this.animatorDelegate.activeIndicators.get(this.animatorDelegate.activeIndicators.size() - 1);
            DrawingDelegate<S> drawingDelegate = this.drawingDelegate;
            if (drawingDelegate instanceof LinearDrawingDelegate) {
                drawingDelegate.fillTrack(canvas, this.paint, 0.0f, firstIndicator.startFraction, this.baseSpec.trackColor, trackAlpha, gapSize);
                this.drawingDelegate.fillTrack(canvas, this.paint, lastIndicator.endFraction, 1.0f, this.baseSpec.trackColor, trackAlpha, gapSize);
            } else {
                trackAlpha = 0;
                drawingDelegate.fillTrack(canvas, this.paint, lastIndicator.endFraction, 1.0f + firstIndicator.startFraction, this.baseSpec.trackColor, 0, gapSize);
            }
        }
        for (int indicatorIndex = 0; indicatorIndex < this.animatorDelegate.activeIndicators.size(); indicatorIndex++) {
            DrawingDelegate.ActiveIndicator curIndicator = this.animatorDelegate.activeIndicators.get(indicatorIndex);
            this.drawingDelegate.fillIndicator(canvas, this.paint, curIndicator, getAlpha());
            if (indicatorIndex > 0 && gapSize > 0) {
                DrawingDelegate.ActiveIndicator prevIndicator = this.animatorDelegate.activeIndicators.get(indicatorIndex - 1);
                this.drawingDelegate.fillTrack(canvas, this.paint, prevIndicator.endFraction, curIndicator.startFraction, this.baseSpec.trackColor, trackAlpha, gapSize);
            }
        }
        canvas.restore();
    }

    private boolean isSystemAnimatorDisabled() {
        if (this.animatorDurationScaleProvider == null) {
            return false;
        }
        float systemAnimatorDurationScale = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        return systemAnimatorDurationScale == 0.0f;
    }

    public Drawable getStaticDummyDrawable() {
        return this.staticDummyDrawable;
    }

    public void setStaticDummyDrawable(Drawable staticDummyDrawable) {
        this.staticDummyDrawable = staticDummyDrawable;
    }

    IndeterminateAnimatorDelegate<ObjectAnimator> getAnimatorDelegate() {
        return this.animatorDelegate;
    }

    void setAnimatorDelegate(IndeterminateAnimatorDelegate<ObjectAnimator> animatorDelegate) {
        this.animatorDelegate = animatorDelegate;
        animatorDelegate.registerDrawable(this);
    }

    DrawingDelegate<S> getDrawingDelegate() {
        return this.drawingDelegate;
    }

    void setDrawingDelegate(DrawingDelegate<S> drawingDelegate) {
        this.drawingDelegate = drawingDelegate;
    }
}
