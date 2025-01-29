package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

/* loaded from: classes.dex */
public class MaterialBottomContainerBackHelper extends MaterialBackAnimationHelper<View> {
    private final float maxScaleXDistance;
    private final float maxScaleYDistance;

    public MaterialBottomContainerBackHelper(View view) {
        super(view);
        Resources resources = view.getResources();
        this.maxScaleXDistance = resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_x_distance);
        this.maxScaleYDistance = resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_y_distance);
    }

    public void startBackProgress(BackEventCompat backEvent) {
        super.onStartBackProgress(backEvent);
    }

    public void updateBackProgress(BackEventCompat backEvent) {
        if (super.onUpdateBackProgress(backEvent) == null) {
            return;
        }
        updateBackProgress(backEvent.getProgress());
    }

    public void updateBackProgress(float progress) {
        float progress2 = interpolateProgress(progress);
        float width = this.view.getWidth();
        float height = this.view.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float maxScaleXDelta = this.maxScaleXDistance / width;
        float maxScaleYDelta = this.maxScaleYDistance / height;
        float scaleXDelta = AnimationUtils.lerp(0.0f, maxScaleXDelta, progress2);
        float scaleYDelta = AnimationUtils.lerp(0.0f, maxScaleYDelta, progress2);
        float scaleX = 1.0f - scaleXDelta;
        float scaleY = 1.0f - scaleYDelta;
        this.view.setScaleX(scaleX);
        this.view.setPivotY(height);
        this.view.setScaleY(scaleY);
        if (this.view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) this.view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childView = viewGroup.getChildAt(i);
                childView.setPivotY(-childView.getTop());
                childView.setScaleY(scaleY != 0.0f ? scaleX / scaleY : 1.0f);
            }
        }
    }

    public void finishBackProgressPersistent(BackEventCompat backEvent, Animator.AnimatorListener animatorListener) {
        Animator animator = createResetScaleAnimator();
        animator.setDuration(AnimationUtils.lerp(this.hideDurationMax, this.hideDurationMin, backEvent.getProgress()));
        if (animatorListener != null) {
            animator.addListener(animatorListener);
        }
        animator.start();
    }

    public void finishBackProgressNotPersistent(BackEventCompat backEvent, Animator.AnimatorListener animatorListener) {
        float scaledHeight = this.view.getHeight() * this.view.getScaleY();
        ObjectAnimator finishAnimator = ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.TRANSLATION_Y, scaledHeight);
        finishAnimator.setInterpolator(new FastOutSlowInInterpolator());
        finishAnimator.setDuration(AnimationUtils.lerp(this.hideDurationMax, this.hideDurationMin, backEvent.getProgress()));
        finishAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.motion.MaterialBottomContainerBackHelper.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                MaterialBottomContainerBackHelper.this.view.setTranslationY(0.0f);
                MaterialBottomContainerBackHelper.this.updateBackProgress(0.0f);
            }
        });
        if (animatorListener != null) {
            finishAnimator.addListener(animatorListener);
        }
        finishAnimator.start();
    }

    public void cancelBackProgress() {
        if (super.onCancelBackProgress() == null) {
            return;
        }
        Animator animator = createResetScaleAnimator();
        animator.setDuration(this.cancelDuration);
        animator.start();
    }

    private Animator createResetScaleAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.SCALE_Y, 1.0f));
        if (this.view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) this.view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childView = viewGroup.getChildAt(i);
                animatorSet.playTogether(ObjectAnimator.ofFloat(childView, (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setInterpolator(new FastOutSlowInInterpolator());
        return animatorSet;
    }
}
