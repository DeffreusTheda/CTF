package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import java.util.Map;

/* loaded from: classes.dex */
public class ChangeBounds extends Transition {
    private static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY;
    private static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY;
    private static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY;
    private static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY;
    private boolean mResizeClip;
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_CLIP = "android:changeBounds:clip";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static final String[] sTransitionProperties = {PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
    private static final Property<View, PointF> POSITION_PROPERTY = new Property<View, PointF>(PointF.class, "position") { // from class: androidx.transition.ChangeBounds.5
        @Override // android.util.Property
        public void set(View view, PointF topLeft) {
            int left = Math.round(topLeft.x);
            int top = Math.round(topLeft.y);
            int right = view.getWidth() + left;
            int bottom = view.getHeight() + top;
            ViewUtils.setLeftTopRightBottom(view, left, top, right, bottom);
        }

        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }
    };
    private static final RectEvaluator sRectEvaluator = new RectEvaluator();

    static {
        String str = "topLeft";
        TOP_LEFT_PROPERTY = new Property<ViewBounds, PointF>(PointF.class, str) { // from class: androidx.transition.ChangeBounds.1
            @Override // android.util.Property
            public void set(ViewBounds viewBounds, PointF topLeft) {
                viewBounds.setTopLeft(topLeft);
            }

            @Override // android.util.Property
            public PointF get(ViewBounds viewBounds) {
                return null;
            }
        };
        String str2 = "bottomRight";
        BOTTOM_RIGHT_PROPERTY = new Property<ViewBounds, PointF>(PointF.class, str2) { // from class: androidx.transition.ChangeBounds.2
            @Override // android.util.Property
            public void set(ViewBounds viewBounds, PointF bottomRight) {
                viewBounds.setBottomRight(bottomRight);
            }

            @Override // android.util.Property
            public PointF get(ViewBounds viewBounds) {
                return null;
            }
        };
        BOTTOM_RIGHT_ONLY_PROPERTY = new Property<View, PointF>(PointF.class, str2) { // from class: androidx.transition.ChangeBounds.3
            @Override // android.util.Property
            public void set(View view, PointF bottomRight) {
                int left = view.getLeft();
                int top = view.getTop();
                int right = Math.round(bottomRight.x);
                int bottom = Math.round(bottomRight.y);
                ViewUtils.setLeftTopRightBottom(view, left, top, right, bottom);
            }

            @Override // android.util.Property
            public PointF get(View view) {
                return null;
            }
        };
        TOP_LEFT_ONLY_PROPERTY = new Property<View, PointF>(PointF.class, str) { // from class: androidx.transition.ChangeBounds.4
            @Override // android.util.Property
            public void set(View view, PointF topLeft) {
                int left = Math.round(topLeft.x);
                int top = Math.round(topLeft.y);
                int right = view.getRight();
                int bottom = view.getBottom();
                ViewUtils.setLeftTopRightBottom(view, left, top, right, bottom);
            }

            @Override // android.util.Property
            public PointF get(View view) {
                return null;
            }
        };
    }

    public ChangeBounds() {
        this.mResizeClip = false;
    }

    public ChangeBounds(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mResizeClip = false;
        TypedArray a = context.obtainStyledAttributes(attrs, Styleable.CHANGE_BOUNDS);
        boolean resizeClip = TypedArrayUtils.getNamedBoolean(a, (XmlResourceParser) attrs, "resizeClip", 0, false);
        a.recycle();
        setResizeClip(resizeClip);
    }

    @Override // androidx.transition.Transition
    public boolean isSeekingSupported() {
        return true;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setResizeClip(boolean resizeClip) {
        this.mResizeClip = resizeClip;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    private void captureValues(TransitionValues values) {
        View view = values.view;
        if (view.isLaidOut() || view.getWidth() != 0 || view.getHeight() != 0) {
            values.values.put(PROPNAME_BOUNDS, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            values.values.put(PROPNAME_PARENT, values.view.getParent());
            if (this.mResizeClip) {
                values.values.put(PROPNAME_CLIP, view.getClipBounds());
            }
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        Rect clipSize;
        captureValues(transitionValues);
        if (this.mResizeClip && (clipSize = (Rect) transitionValues.view.getTag(R.id.transition_clip)) != null) {
            transitionValues.values.put(PROPNAME_CLIP, clipSize);
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {
        View view;
        int startRight;
        int startTop;
        int endLeft;
        Rect startClip;
        Rect endClip;
        Rect endClip2;
        Rect startClip2;
        Animator anim;
        if (startValues != null && endValues != null) {
            Map<String, Object> startParentVals = startValues.values;
            Map<String, Object> endParentVals = endValues.values;
            ViewGroup startParent = (ViewGroup) startParentVals.get(PROPNAME_PARENT);
            ViewGroup endParent = (ViewGroup) endParentVals.get(PROPNAME_PARENT);
            if (startParent != null && endParent != null) {
                View view2 = endValues.view;
                Rect startBounds = (Rect) startValues.values.get(PROPNAME_BOUNDS);
                Rect endBounds = (Rect) endValues.values.get(PROPNAME_BOUNDS);
                int startLeft = startBounds.left;
                int endLeft2 = endBounds.left;
                int startTop2 = startBounds.top;
                int endTop = endBounds.top;
                int startRight2 = startBounds.right;
                int endRight = endBounds.right;
                int startBottom = startBounds.bottom;
                int endBottom = endBounds.bottom;
                int startWidth = startRight2 - startLeft;
                int startHeight = startBottom - startTop2;
                int endWidth = endRight - endLeft2;
                int endHeight = endBottom - endTop;
                Rect startClip3 = (Rect) startValues.values.get(PROPNAME_CLIP);
                Rect endClip3 = (Rect) endValues.values.get(PROPNAME_CLIP);
                if ((startWidth != 0 && startHeight != 0) || (endWidth != 0 && endHeight != 0)) {
                    numChanges = (startLeft == endLeft2 && startTop2 == endTop) ? 0 : 0 + 1;
                    if (startRight2 != endRight || startBottom != endBottom) {
                        numChanges++;
                    }
                }
                if ((startClip3 != null && !startClip3.equals(endClip3)) || (startClip3 == null && endClip3 != null)) {
                    numChanges++;
                }
                if (numChanges <= 0) {
                    return null;
                }
                if (this.mResizeClip) {
                    view = view2;
                    int maxWidth = Math.max(startWidth, endWidth);
                    int maxHeight = Math.max(startHeight, endHeight);
                    int i = startLeft + maxWidth;
                    int maxWidth2 = startTop2 + maxHeight;
                    ViewUtils.setLeftTopRightBottom(view, startLeft, startTop2, i, maxWidth2);
                    ObjectAnimator positionAnimator = null;
                    if (startLeft == endLeft2 && startTop2 == endTop) {
                        startRight = startRight2;
                        startTop = startTop2;
                        endLeft = endLeft2;
                    } else {
                        startRight = startRight2;
                        startTop = startTop2;
                        endLeft = endLeft2;
                        Path topLeftPath = getPathMotion().getPath(startLeft, startTop2, endLeft2, endTop);
                        positionAnimator = ObjectAnimatorUtils.ofPointF(view, POSITION_PROPERTY, topLeftPath);
                    }
                    boolean startClipIsNull = startClip3 == null;
                    if (startClipIsNull) {
                        startClip = new Rect(0, 0, startWidth, startHeight);
                    } else {
                        startClip = startClip3;
                    }
                    boolean endClipIsNull = endClip3 == null;
                    if (!endClipIsNull) {
                        endClip = endClip3;
                    } else {
                        endClip = new Rect(0, 0, endWidth, endHeight);
                    }
                    ObjectAnimator clipAnimator = null;
                    if (startClip.equals(endClip)) {
                        endClip2 = endClip;
                        startClip2 = startClip;
                    } else {
                        view.setClipBounds(startClip);
                        ObjectAnimator clipAnimator2 = ObjectAnimator.ofObject(view, "clipBounds", sRectEvaluator, startClip, endClip);
                        endClip2 = endClip;
                        startClip2 = startClip;
                        ClipListener listener = new ClipListener(view, startClip, startClipIsNull, endClip2, endClipIsNull, startLeft, startTop, startRight, startBottom, endLeft, endTop, endRight, endBottom);
                        clipAnimator2.addListener(listener);
                        addListener(listener);
                        clipAnimator = clipAnimator2;
                    }
                    anim = TransitionUtils.mergeAnimators(positionAnimator, clipAnimator);
                } else {
                    ViewUtils.setLeftTopRightBottom(view2, startLeft, startTop2, startRight2, startBottom);
                    if (numChanges == 2) {
                        if (startWidth != endWidth || startHeight != endHeight) {
                            ViewBounds viewBounds = new ViewBounds(view2);
                            Path topLeftPath2 = getPathMotion().getPath(startLeft, startTop2, endLeft2, endTop);
                            ObjectAnimator topLeftAnimator = ObjectAnimatorUtils.ofPointF(viewBounds, TOP_LEFT_PROPERTY, topLeftPath2);
                            Path bottomRightPath = getPathMotion().getPath(startRight2, startBottom, endRight, endBottom);
                            ObjectAnimator bottomRightAnimator = ObjectAnimatorUtils.ofPointF(viewBounds, BOTTOM_RIGHT_PROPERTY, bottomRightPath);
                            AnimatorSet set = new AnimatorSet();
                            set.playTogether(topLeftAnimator, bottomRightAnimator);
                            set.addListener(new AnimatorListenerAdapter(viewBounds) { // from class: androidx.transition.ChangeBounds.6
                                private final ViewBounds mViewBounds;
                                final /* synthetic */ ViewBounds val$viewBounds;

                                {
                                    this.val$viewBounds = viewBounds;
                                    this.mViewBounds = viewBounds;
                                }
                            });
                            anim = set;
                            view = view2;
                        } else {
                            Path topLeftPath3 = getPathMotion().getPath(startLeft, startTop2, endLeft2, endTop);
                            anim = ObjectAnimatorUtils.ofPointF(view2, POSITION_PROPERTY, topLeftPath3);
                            view = view2;
                        }
                    } else {
                        if (startLeft != endLeft2) {
                            view = view2;
                        } else if (startTop2 != endTop) {
                            view = view2;
                        } else {
                            Path bottomRight = getPathMotion().getPath(startRight2, startBottom, endRight, endBottom);
                            view = view2;
                            anim = ObjectAnimatorUtils.ofPointF(view, BOTTOM_RIGHT_ONLY_PROPERTY, bottomRight);
                        }
                        Path topLeftPath4 = getPathMotion().getPath(startLeft, startTop2, endLeft2, endTop);
                        anim = ObjectAnimatorUtils.ofPointF(view, TOP_LEFT_ONLY_PROPERTY, topLeftPath4);
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    ViewGroup parent = (ViewGroup) view.getParent();
                    ViewGroupUtils.suppressLayout(parent, true);
                    getRootTransition().addListener(new SuppressLayoutListener(parent));
                }
                return anim;
            }
            return null;
        }
        return null;
    }

    private static class ViewBounds {
        private int mBottom;
        private int mBottomRightCalls;
        private int mLeft;
        private int mRight;
        private int mTop;
        private int mTopLeftCalls;
        private final View mView;

        ViewBounds(View view) {
            this.mView = view;
        }

        void setTopLeft(PointF topLeft) {
            this.mLeft = Math.round(topLeft.x);
            this.mTop = Math.round(topLeft.y);
            int i = this.mTopLeftCalls + 1;
            this.mTopLeftCalls = i;
            if (i == this.mBottomRightCalls) {
                setLeftTopRightBottom();
            }
        }

        void setBottomRight(PointF bottomRight) {
            this.mRight = Math.round(bottomRight.x);
            this.mBottom = Math.round(bottomRight.y);
            int i = this.mBottomRightCalls + 1;
            this.mBottomRightCalls = i;
            if (this.mTopLeftCalls == i) {
                setLeftTopRightBottom();
            }
        }

        private void setLeftTopRightBottom() {
            ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }
    }

    private static class ClipListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final int mEndBottom;
        private final Rect mEndClip;
        private final boolean mEndClipIsNull;
        private final int mEndLeft;
        private final int mEndRight;
        private final int mEndTop;
        private boolean mIsCanceled;
        private final int mStartBottom;
        private final Rect mStartClip;
        private final boolean mStartClipIsNull;
        private final int mStartLeft;
        private final int mStartRight;
        private final int mStartTop;
        private final View mView;

        ClipListener(View view, Rect startClip, boolean startClipIsNull, Rect endClip, boolean endClipIsNull, int startLeft, int startTop, int startRight, int startBottom, int endLeft, int endTop, int endRight, int endBottom) {
            this.mView = view;
            this.mStartClip = startClip;
            this.mStartClipIsNull = startClipIsNull;
            this.mEndClip = endClip;
            this.mEndClipIsNull = endClipIsNull;
            this.mStartLeft = startLeft;
            this.mStartTop = startTop;
            this.mStartRight = startRight;
            this.mStartBottom = startBottom;
            this.mEndLeft = endLeft;
            this.mEndTop = endTop;
            this.mEndRight = endRight;
            this.mEndBottom = endBottom;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            onAnimationStart(animation, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            onAnimationEnd(animation, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation, boolean isReverse) {
            int maxWidth = Math.max(this.mStartRight - this.mStartLeft, this.mEndRight - this.mEndLeft);
            int maxHeight = Math.max(this.mStartBottom - this.mStartTop, this.mEndBottom - this.mEndTop);
            int left = isReverse ? this.mEndLeft : this.mStartLeft;
            int top = isReverse ? this.mEndTop : this.mStartTop;
            ViewUtils.setLeftTopRightBottom(this.mView, left, top, left + maxWidth, top + maxHeight);
            Rect clip = isReverse ? this.mEndClip : this.mStartClip;
            this.mView.setClipBounds(clip);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation, boolean isReverse) {
            if (this.mIsCanceled) {
                return;
            }
            Rect clip = null;
            if (isReverse) {
                if (!this.mStartClipIsNull) {
                    clip = this.mStartClip;
                }
            } else if (!this.mEndClipIsNull) {
                clip = this.mEndClip;
            }
            this.mView.setClipBounds(clip);
            if (isReverse) {
                ViewUtils.setLeftTopRightBottom(this.mView, this.mStartLeft, this.mStartTop, this.mStartRight, this.mStartBottom);
            } else {
                ViewUtils.setLeftTopRightBottom(this.mView, this.mEndLeft, this.mEndTop, this.mEndRight, this.mEndBottom);
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
            this.mIsCanceled = true;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
            Rect pauseClip = this.mView.getClipBounds();
            this.mView.setTag(R.id.transition_clip, pauseClip);
            Rect clip = this.mEndClipIsNull ? null : this.mEndClip;
            this.mView.setClipBounds(clip);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
            Rect pauseClip = (Rect) this.mView.getTag(R.id.transition_clip);
            this.mView.setTag(R.id.transition_clip, null);
            this.mView.setClipBounds(pauseClip);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
        }
    }

    private static class SuppressLayoutListener extends TransitionListenerAdapter {
        boolean mCanceled = false;
        final ViewGroup mParent;

        SuppressLayoutListener(ViewGroup parent) {
            this.mParent = parent;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
            ViewGroupUtils.suppressLayout(this.mParent, false);
            this.mCanceled = true;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            if (!this.mCanceled) {
                ViewGroupUtils.suppressLayout(this.mParent, false);
            }
            transition.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
            ViewGroupUtils.suppressLayout(this.mParent, false);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
            ViewGroupUtils.suppressLayout(this.mParent, true);
        }
    }
}
