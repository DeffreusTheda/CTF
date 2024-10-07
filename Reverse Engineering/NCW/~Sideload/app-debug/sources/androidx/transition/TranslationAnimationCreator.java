package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.util.Property;
import android.view.View;
import androidx.transition.Transition;

/* loaded from: classes.dex */
class TranslationAnimationCreator {
    static Animator createAnimation(View view, TransitionValues values, int viewPosX, int viewPosY, float startX, float startY, float endX, float endY, TimeInterpolator interpolator, Transition transition) {
        float startX2;
        float startY2;
        float terminalX = view.getTranslationX();
        float terminalY = view.getTranslationY();
        int[] startPosition = (int[]) values.view.getTag(R.id.transition_position);
        if (startPosition == null) {
            startX2 = startX;
            startY2 = startY;
        } else {
            startX2 = (startPosition[0] - viewPosX) + terminalX;
            startY2 = (startPosition[1] - viewPosY) + terminalY;
        }
        view.setTranslationX(startX2);
        view.setTranslationY(startY2);
        if (startX2 == endX && startY2 == endY) {
            return null;
        }
        ObjectAnimator anim = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, startX2, endX), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, startY2, endY));
        TransitionPositionListener listener = new TransitionPositionListener(view, values.view, terminalX, terminalY);
        transition.addListener(listener);
        anim.addListener(listener);
        anim.setInterpolator(interpolator);
        return anim;
    }

    private static class TransitionPositionListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private boolean mIsTransitionCanceled;
        private final View mMovingView;
        private float mPausedX;
        private float mPausedY;
        private final float mTerminalX;
        private final float mTerminalY;
        private int[] mTransitionPosition;
        private final View mViewInHierarchy;

        TransitionPositionListener(View movingView, View viewInHierarchy, float terminalX, float terminalY) {
            this.mMovingView = movingView;
            this.mViewInHierarchy = viewInHierarchy;
            this.mTerminalX = terminalX;
            this.mTerminalY = terminalY;
            int[] iArr = (int[]) viewInHierarchy.getTag(R.id.transition_position);
            this.mTransitionPosition = iArr;
            if (iArr != null) {
                viewInHierarchy.setTag(R.id.transition_position, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            this.mIsTransitionCanceled = true;
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation, boolean isReverse) {
            if (!isReverse) {
                this.mMovingView.setTranslationX(this.mTerminalX);
                this.mMovingView.setTranslationY(this.mTerminalY);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            onAnimationEnd(animation, false);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition, boolean isReverse) {
            if (!this.mIsTransitionCanceled) {
                this.mViewInHierarchy.setTag(R.id.transition_position, null);
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            onTransitionEnd(transition, false);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
            this.mIsTransitionCanceled = true;
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
            setInterruptedPosition();
            this.mPausedX = this.mMovingView.getTranslationX();
            this.mPausedY = this.mMovingView.getTranslationY();
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
            this.mMovingView.setTranslationX(this.mPausedX);
            this.mMovingView.setTranslationY(this.mPausedY);
        }

        private void setInterruptedPosition() {
            if (this.mTransitionPosition == null) {
                this.mTransitionPosition = new int[2];
            }
            this.mMovingView.getLocationOnScreen(this.mTransitionPosition);
            this.mViewInHierarchy.setTag(R.id.transition_position, this.mTransitionPosition);
        }
    }

    private TranslationAnimationCreator() {
    }
}
