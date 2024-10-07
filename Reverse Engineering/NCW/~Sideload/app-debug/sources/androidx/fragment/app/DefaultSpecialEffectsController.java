package androidx.fragment.app;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class DefaultSpecialEffectsController extends SpecialEffectsController {
    DefaultSpecialEffectsController(ViewGroup container) {
        super(container);
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    void executeOperations(List<SpecialEffectsController.Operation> operations, boolean isPop) {
        SpecialEffectsController.Operation firstOut = null;
        SpecialEffectsController.Operation lastIn = null;
        for (SpecialEffectsController.Operation operation : operations) {
            SpecialEffectsController.Operation.State currentState = SpecialEffectsController.Operation.State.from(operation.getFragment().mView);
            switch (AnonymousClass10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[operation.getFinalState().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    if (currentState == SpecialEffectsController.Operation.State.VISIBLE && firstOut == null) {
                        firstOut = operation;
                        break;
                    }
                    break;
                case 4:
                    if (currentState != SpecialEffectsController.Operation.State.VISIBLE) {
                        lastIn = operation;
                        break;
                    } else {
                        break;
                    }
            }
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Executing operations from " + firstOut + " to " + lastIn);
        }
        List<AnimationInfo> animations = new ArrayList<>();
        List<TransitionInfo> transitions = new ArrayList<>();
        final List<SpecialEffectsController.Operation> awaitingContainerChanges = new ArrayList<>(operations);
        syncAnimations(operations);
        Iterator<SpecialEffectsController.Operation> it = operations.iterator();
        while (it.hasNext()) {
            final SpecialEffectsController.Operation operation2 = it.next();
            CancellationSignal animCancellationSignal = new CancellationSignal();
            operation2.markStartedSpecialEffect(animCancellationSignal);
            animations.add(new AnimationInfo(operation2, animCancellationSignal, isPop));
            CancellationSignal transitionCancellationSignal = new CancellationSignal();
            operation2.markStartedSpecialEffect(transitionCancellationSignal);
            transitions.add(new TransitionInfo(operation2, transitionCancellationSignal, isPop, !isPop ? operation2 != lastIn : operation2 != firstOut));
            operation2.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                @Override // java.lang.Runnable
                public void run() {
                    if (awaitingContainerChanges.contains(operation2)) {
                        awaitingContainerChanges.remove(operation2);
                        DefaultSpecialEffectsController.this.applyContainerChanges(operation2);
                    }
                }
            });
        }
        Map<SpecialEffectsController.Operation, Boolean> startedTransitions = startTransitions(transitions, awaitingContainerChanges, isPop, firstOut, lastIn);
        boolean startedAnyTransition = startedTransitions.containsValue(true);
        startAnimations(animations, awaitingContainerChanges, startedAnyTransition, startedTransitions);
        Iterator<SpecialEffectsController.Operation> it2 = awaitingContainerChanges.iterator();
        while (it2.hasNext()) {
            applyContainerChanges(it2.next());
        }
        awaitingContainerChanges.clear();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Completed executing operations from " + firstOut + " to " + lastIn);
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10, reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

        static {
            int[] iArr = new int[SpecialEffectsController.Operation.State.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = iArr;
            try {
                iArr[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private void syncAnimations(List<SpecialEffectsController.Operation> operations) {
        Fragment lastOpFragment = operations.get(operations.size() - 1).getFragment();
        for (SpecialEffectsController.Operation operation : operations) {
            operation.getFragment().mAnimationInfo.mEnterAnim = lastOpFragment.mAnimationInfo.mEnterAnim;
            operation.getFragment().mAnimationInfo.mExitAnim = lastOpFragment.mAnimationInfo.mExitAnim;
            operation.getFragment().mAnimationInfo.mPopEnterAnim = lastOpFragment.mAnimationInfo.mPopEnterAnim;
            operation.getFragment().mAnimationInfo.mPopExitAnim = lastOpFragment.mAnimationInfo.mPopExitAnim;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x001d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void startAnimations(java.util.List<androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo> r24, java.util.List<androidx.fragment.app.SpecialEffectsController.Operation> r25, boolean r26, java.util.Map<androidx.fragment.app.SpecialEffectsController.Operation, java.lang.Boolean> r27) {
        /*
            Method dump skipped, instructions count: 511
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.startAnimations(java.util.List, java.util.List, boolean, java.util.Map):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:201:0x05a3, code lost:
    
        if (r13 == r42) goto L170;
     */
    /* JADX WARN: Removed duplicated region for block: B:211:0x05c3  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x05fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.Map<androidx.fragment.app.SpecialEffectsController.Operation, java.lang.Boolean> startTransitions(java.util.List<androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo> r38, java.util.List<androidx.fragment.app.SpecialEffectsController.Operation> r39, final boolean r40, final androidx.fragment.app.SpecialEffectsController.Operation r41, final androidx.fragment.app.SpecialEffectsController.Operation r42) {
        /*
            Method dump skipped, instructions count: 1744
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.startTransitions(java.util.List, java.util.List, boolean, androidx.fragment.app.SpecialEffectsController$Operation, androidx.fragment.app.SpecialEffectsController$Operation):java.util.Map");
    }

    void retainMatchingViews(ArrayMap<String, View> sharedElementViews, Collection<String> transitionNames) {
        Iterator<Map.Entry<String, View>> iterator = sharedElementViews.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, View> entry = iterator.next();
            if (!transitionNames.contains(ViewCompat.getTransitionName(entry.getValue()))) {
                iterator.remove();
            }
        }
    }

    void captureTransitioningViews(ArrayList<View> transitioningViews, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
                if (!transitioningViews.contains(view)) {
                    transitioningViews.add(viewGroup);
                    return;
                }
                return;
            }
            int count = viewGroup.getChildCount();
            for (int i = 0; i < count; i++) {
                View child = viewGroup.getChildAt(i);
                if (child.getVisibility() == 0) {
                    captureTransitioningViews(transitioningViews, child);
                }
            }
            return;
        }
        if (!transitioningViews.contains(view)) {
            transitioningViews.add(view);
        }
    }

    void findNamedViews(Map<String, View> namedViews, View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            namedViews.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int count = viewGroup.getChildCount();
            for (int i = 0; i < count; i++) {
                View child = viewGroup.getChildAt(i);
                if (child.getVisibility() == 0) {
                    findNamedViews(namedViews, child);
                }
            }
        }
    }

    void applyContainerChanges(SpecialEffectsController.Operation operation) {
        View view = operation.getFragment().mView;
        operation.getFinalState().applyState(view);
    }

    private static class SpecialEffectsInfo {
        private final SpecialEffectsController.Operation mOperation;
        private final CancellationSignal mSignal;

        SpecialEffectsInfo(SpecialEffectsController.Operation operation, CancellationSignal signal) {
            this.mOperation = operation;
            this.mSignal = signal;
        }

        SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        CancellationSignal getSignal() {
            return this.mSignal;
        }

        boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State currentState = SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            SpecialEffectsController.Operation.State finalState = this.mOperation.getFinalState();
            return currentState == finalState || !(currentState == SpecialEffectsController.Operation.State.VISIBLE || finalState == SpecialEffectsController.Operation.State.VISIBLE);
        }

        void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }
    }

    private static class AnimationInfo extends SpecialEffectsInfo {
        private FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim;

        AnimationInfo(SpecialEffectsController.Operation operation, CancellationSignal signal, boolean isPop) {
            super(operation, signal);
            this.mLoadedAnim = false;
            this.mIsPop = isPop;
        }

        FragmentAnim.AnimationOrAnimator getAnimation(Context context) {
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            FragmentAnim.AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE, this.mIsPop);
            this.mAnimation = loadAnimation;
            this.mLoadedAnim = true;
            return loadAnimation;
        }
    }

    private static class TransitionInfo extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;
        private final Object mSharedElementTransition;
        private final Object mTransition;

        TransitionInfo(SpecialEffectsController.Operation operation, CancellationSignal signal, boolean isPop, boolean providesSharedElementTransition) {
            super(operation, signal);
            Object exitTransition;
            Object enterTransition;
            boolean allowEnterTransitionOverlap;
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                if (isPop) {
                    enterTransition = operation.getFragment().getReenterTransition();
                } else {
                    enterTransition = operation.getFragment().getEnterTransition();
                }
                this.mTransition = enterTransition;
                if (isPop) {
                    allowEnterTransitionOverlap = operation.getFragment().getAllowReturnTransitionOverlap();
                } else {
                    allowEnterTransitionOverlap = operation.getFragment().getAllowEnterTransitionOverlap();
                }
                this.mOverlapAllowed = allowEnterTransitionOverlap;
            } else {
                if (isPop) {
                    exitTransition = operation.getFragment().getReturnTransition();
                } else {
                    exitTransition = operation.getFragment().getExitTransition();
                }
                this.mTransition = exitTransition;
                this.mOverlapAllowed = true;
            }
            if (providesSharedElementTransition) {
                if (isPop) {
                    this.mSharedElementTransition = operation.getFragment().getSharedElementReturnTransition();
                    return;
                } else {
                    this.mSharedElementTransition = operation.getFragment().getSharedElementEnterTransition();
                    return;
                }
            }
            this.mSharedElementTransition = null;
        }

        Object getTransition() {
            return this.mTransition;
        }

        boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }

        public boolean hasSharedElementTransition() {
            return this.mSharedElementTransition != null;
        }

        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl transitionImpl = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl sharedElementTransitionImpl = getHandlingImpl(this.mSharedElementTransition);
            if (transitionImpl == null || sharedElementTransitionImpl == null || transitionImpl == sharedElementTransitionImpl) {
                return transitionImpl != null ? transitionImpl : sharedElementTransitionImpl;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.mTransition + " which uses a different Transition  type than its shared element transition " + this.mSharedElementTransition);
        }

        private FragmentTransitionImpl getHandlingImpl(Object transition) {
            if (transition == null) {
                return null;
            }
            if (FragmentTransition.PLATFORM_IMPL != null && FragmentTransition.PLATFORM_IMPL.canHandle(transition)) {
                return FragmentTransition.PLATFORM_IMPL;
            }
            if (FragmentTransition.SUPPORT_IMPL != null && FragmentTransition.SUPPORT_IMPL.canHandle(transition)) {
                return FragmentTransition.SUPPORT_IMPL;
            }
            throw new IllegalArgumentException("Transition " + transition + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}
