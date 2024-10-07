package com.google.android.material.motion;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.activity.BackEventCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.google.android.material.R;

/* loaded from: classes.dex */
public abstract class MaterialBackAnimationHelper<V extends View> {
    private static final int CANCEL_DURATION_DEFAULT = 100;
    private static final int HIDE_DURATION_MAX_DEFAULT = 300;
    private static final int HIDE_DURATION_MIN_DEFAULT = 150;
    private static final String TAG = "MaterialBackHelper";
    private BackEventCompat backEvent;
    protected final int cancelDuration;
    protected final int hideDurationMax;
    protected final int hideDurationMin;
    private final TimeInterpolator progressInterpolator;
    protected final V view;

    public MaterialBackAnimationHelper(V view) {
        this.view = view;
        Context context = view.getContext();
        this.progressInterpolator = MotionUtils.resolveThemeInterpolator(context, R.attr.motionEasingStandardDecelerateInterpolator, PathInterpolatorCompat.create(0.0f, 0.0f, 0.0f, 1.0f));
        this.hideDurationMax = MotionUtils.resolveThemeDuration(context, R.attr.motionDurationMedium2, 300);
        this.hideDurationMin = MotionUtils.resolveThemeDuration(context, R.attr.motionDurationShort3, HIDE_DURATION_MIN_DEFAULT);
        this.cancelDuration = MotionUtils.resolveThemeDuration(context, R.attr.motionDurationShort2, 100);
    }

    public float interpolateProgress(float progress) {
        return this.progressInterpolator.getInterpolation(progress);
    }

    protected void onStartBackProgress(BackEventCompat backEvent) {
        this.backEvent = backEvent;
    }

    protected BackEventCompat onUpdateBackProgress(BackEventCompat backEvent) {
        if (this.backEvent == null) {
            Log.w(TAG, "Must call startBackProgress() before updateBackProgress()");
        }
        BackEventCompat finalBackEvent = this.backEvent;
        this.backEvent = backEvent;
        return finalBackEvent;
    }

    public BackEventCompat onHandleBackInvoked() {
        BackEventCompat finalBackEvent = this.backEvent;
        this.backEvent = null;
        return finalBackEvent;
    }

    protected BackEventCompat onCancelBackProgress() {
        if (this.backEvent == null) {
            Log.w(TAG, "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        BackEventCompat finalBackEvent = this.backEvent;
        this.backEvent = null;
        return finalBackEvent;
    }
}
