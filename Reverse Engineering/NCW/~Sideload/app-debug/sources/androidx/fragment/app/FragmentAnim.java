package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.R;

/* loaded from: classes.dex */
class FragmentAnim {
    private FragmentAnim() {
    }

    static AnimationOrAnimator loadAnimation(Context context, Fragment fragment, boolean enter, boolean isPop) {
        int transit = fragment.getNextTransition();
        int nextAnim = getNextAnim(fragment, enter, isPop);
        fragment.setAnimations(0, 0, 0, 0);
        if (fragment.mContainer != null && fragment.mContainer.getTag(R.id.visible_removing_fragment_view_tag) != null) {
            fragment.mContainer.setTag(R.id.visible_removing_fragment_view_tag, null);
        }
        if (fragment.mContainer != null && fragment.mContainer.getLayoutTransition() != null) {
            return null;
        }
        Animation animation = fragment.onCreateAnimation(transit, enter, nextAnim);
        if (animation != null) {
            return new AnimationOrAnimator(animation);
        }
        Animator animator = fragment.onCreateAnimator(transit, enter, nextAnim);
        if (animator != null) {
            return new AnimationOrAnimator(animator);
        }
        if (nextAnim == 0 && transit != 0) {
            nextAnim = transitToAnimResourceId(context, transit, enter);
        }
        if (nextAnim != 0) {
            String dir = context.getResources().getResourceTypeName(nextAnim);
            boolean isAnim = "anim".equals(dir);
            boolean successfulLoad = false;
            if (isAnim) {
                try {
                    Animation animation2 = AnimationUtils.loadAnimation(context, nextAnim);
                    if (animation2 != null) {
                        return new AnimationOrAnimator(animation2);
                    }
                    successfulLoad = true;
                } catch (Resources.NotFoundException e) {
                    throw e;
                } catch (RuntimeException e2) {
                }
            }
            if (!successfulLoad) {
                try {
                    Animator animator2 = AnimatorInflater.loadAnimator(context, nextAnim);
                    if (animator2 != null) {
                        return new AnimationOrAnimator(animator2);
                    }
                } catch (RuntimeException e3) {
                    if (isAnim) {
                        throw e3;
                    }
                    Animation animation3 = AnimationUtils.loadAnimation(context, nextAnim);
                    if (animation3 != null) {
                        return new AnimationOrAnimator(animation3);
                    }
                }
            }
        }
        return null;
    }

    private static int getNextAnim(Fragment fragment, boolean enter, boolean isPop) {
        if (isPop) {
            if (enter) {
                return fragment.getPopEnterAnim();
            }
            return fragment.getPopExitAnim();
        }
        if (enter) {
            return fragment.getEnterAnim();
        }
        return fragment.getExitAnim();
    }

    private static int transitToAnimResourceId(Context context, int transit, boolean enter) {
        int activityTransitResId;
        int activityTransitResId2;
        switch (transit) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /* 4097 */:
                int animAttr = enter ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
                return animAttr;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                int animAttr2 = enter ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit;
                return animAttr2;
            case FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN /* 4100 */:
                if (enter) {
                    activityTransitResId = toActivityTransitResId(context, android.R.attr.activityOpenEnterAnimation);
                } else {
                    activityTransitResId = toActivityTransitResId(context, android.R.attr.activityOpenExitAnimation);
                }
                int animAttr3 = activityTransitResId;
                return animAttr3;
            case 8194:
                int animAttr4 = enter ? R.animator.fragment_close_enter : R.animator.fragment_close_exit;
                return animAttr4;
            case FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_CLOSE /* 8197 */:
                if (enter) {
                    activityTransitResId2 = toActivityTransitResId(context, android.R.attr.activityCloseEnterAnimation);
                } else {
                    activityTransitResId2 = toActivityTransitResId(context, android.R.attr.activityCloseExitAnimation);
                }
                int animAttr5 = activityTransitResId2;
                return animAttr5;
            default:
                return -1;
        }
    }

    private static int toActivityTransitResId(Context context, int attrInt) {
        TypedArray typedArray = context.obtainStyledAttributes(android.R.style.Animation.Activity, new int[]{attrInt});
        int resId = typedArray.getResourceId(0, -1);
        typedArray.recycle();
        return resId;
    }

    static class AnimationOrAnimator {
        public final Animation animation;
        public final Animator animator;

        AnimationOrAnimator(Animation animation) {
            this.animation = animation;
            this.animator = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        AnimationOrAnimator(Animator animator) {
            this.animation = null;
            this.animator = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    static class EndViewTransitionAnimation extends AnimationSet implements Runnable {
        private boolean mAnimating;
        private final View mChild;
        private boolean mEnded;
        private final ViewGroup mParent;
        private boolean mTransitionEnded;

        EndViewTransitionAnimation(Animation animation, ViewGroup parent, View child) {
            super(false);
            this.mAnimating = true;
            this.mParent = parent;
            this.mChild = child;
            addAnimation(animation);
            parent.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long currentTime, Transformation t) {
            this.mAnimating = true;
            if (this.mEnded) {
                return true ^ this.mTransitionEnded;
            }
            boolean more = super.getTransformation(currentTime, t);
            if (!more) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long currentTime, Transformation outTransformation, float scale) {
            this.mAnimating = true;
            if (this.mEnded) {
                return true ^ this.mTransitionEnded;
            }
            boolean more = super.getTransformation(currentTime, outTransformation, scale);
            if (!more) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mEnded && this.mAnimating) {
                this.mAnimating = false;
                this.mParent.post(this);
            } else {
                this.mParent.endViewTransition(this.mChild);
                this.mTransitionEnded = true;
            }
        }
    }
}
