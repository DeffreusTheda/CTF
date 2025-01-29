package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;

/* loaded from: classes.dex */
public class ChangeClipBounds extends Transition {
    private static final String PROPNAME_BOUNDS = "android:clipBounds:bounds";
    private static final String PROPNAME_CLIP = "android:clipBounds:clip";
    private static final String[] sTransitionProperties = {PROPNAME_CLIP};
    static final Rect NULL_SENTINEL = new Rect();

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public ChangeClipBounds() {
    }

    public ChangeClipBounds(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override // androidx.transition.Transition
    public boolean isSeekingSupported() {
        return true;
    }

    private void captureValues(TransitionValues values, boolean clipFromTag) {
        View view = values.view;
        if (view.getVisibility() == 8) {
            return;
        }
        Rect clip = null;
        if (clipFromTag) {
            clip = (Rect) view.getTag(R.id.transition_clip);
        }
        if (clip == null) {
            clip = view.getClipBounds();
        }
        if (clip == NULL_SENTINEL) {
            clip = null;
        }
        values.values.put(PROPNAME_CLIP, clip);
        if (clip == null) {
            Rect bounds = new Rect(0, 0, view.getWidth(), view.getHeight());
            values.values.put(PROPNAME_BOUNDS, bounds);
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues, true);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues, false);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {
        if (startValues == null || endValues == null || !startValues.values.containsKey(PROPNAME_CLIP) || !endValues.values.containsKey(PROPNAME_CLIP)) {
            return null;
        }
        Rect start = (Rect) startValues.values.get(PROPNAME_CLIP);
        Rect end = (Rect) endValues.values.get(PROPNAME_CLIP);
        if (start == null && end == null) {
            return null;
        }
        Rect startClip = start == null ? (Rect) startValues.values.get(PROPNAME_BOUNDS) : start;
        Rect endClip = end == null ? (Rect) endValues.values.get(PROPNAME_BOUNDS) : end;
        if (startClip.equals(endClip)) {
            return null;
        }
        endValues.view.setClipBounds(start);
        RectEvaluator evaluator = new RectEvaluator(new Rect());
        ObjectAnimator animator = ObjectAnimator.ofObject(endValues.view, (Property<View, V>) ViewUtils.CLIP_BOUNDS, (TypeEvaluator) evaluator, (Object[]) new Rect[]{startClip, endClip});
        View view = endValues.view;
        Listener listener = new Listener(view, start, end);
        animator.addListener(listener);
        addListener(listener);
        return animator;
    }

    private static class Listener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final Rect mEnd;
        private final Rect mStart;
        private final View mView;

        Listener(View view, Rect start, Rect end) {
            this.mView = view;
            this.mStart = start;
            this.mEnd = end;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
            Rect clipBounds = this.mView.getClipBounds();
            if (clipBounds == null) {
                clipBounds = ChangeClipBounds.NULL_SENTINEL;
            }
            this.mView.setTag(R.id.transition_clip, clipBounds);
            this.mView.setClipBounds(this.mEnd);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
            Rect clipBounds = (Rect) this.mView.getTag(R.id.transition_clip);
            this.mView.setClipBounds(clipBounds);
            this.mView.setTag(R.id.transition_clip, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            onAnimationEnd(animation, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation, boolean isReverse) {
            if (!isReverse) {
                this.mView.setClipBounds(this.mEnd);
            } else {
                this.mView.setClipBounds(this.mStart);
            }
        }
    }
}
