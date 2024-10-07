package com.google.android.material.navigation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.animation.AnimationUtils;

/* loaded from: classes.dex */
public class DrawerLayoutUtils {
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    private static final int DEFAULT_SCRIM_ALPHA = Color.alpha(DEFAULT_SCRIM_COLOR);

    private DrawerLayoutUtils() {
    }

    public static ValueAnimator.AnimatorUpdateListener getScrimCloseAnimatorUpdateListener(final DrawerLayout drawerLayout) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.navigation.DrawerLayoutUtils$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DrawerLayoutUtils.lambda$getScrimCloseAnimatorUpdateListener$0(DrawerLayout.this, valueAnimator);
            }
        };
    }

    static /* synthetic */ void lambda$getScrimCloseAnimatorUpdateListener$0(DrawerLayout drawerLayout, ValueAnimator animation) {
        int newScrimAlpha = AnimationUtils.lerp(DEFAULT_SCRIM_ALPHA, 0, animation.getAnimatedFraction());
        drawerLayout.setScrimColor(ColorUtils.setAlphaComponent(DEFAULT_SCRIM_COLOR, newScrimAlpha));
    }

    public static Animator.AnimatorListener getScrimCloseAnimatorListener(final DrawerLayout drawerLayout, final View drawerView) {
        return new AnimatorListenerAdapter() { // from class: com.google.android.material.navigation.DrawerLayoutUtils.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                DrawerLayout.this.closeDrawer(drawerView, false);
                DrawerLayout.this.setScrimColor(DrawerLayoutUtils.DEFAULT_SCRIM_COLOR);
            }
        };
    }
}
