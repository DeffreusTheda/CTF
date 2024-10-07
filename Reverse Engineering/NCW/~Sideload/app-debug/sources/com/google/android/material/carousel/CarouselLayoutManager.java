package com.google.android.material.carousel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.KeylineState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CarouselLayoutManager extends RecyclerView.LayoutManager implements Carousel, RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final int ALIGNMENT_CENTER = 1;
    public static final int ALIGNMENT_START = 0;
    public static final int HORIZONTAL = 0;
    private static final String TAG = "CarouselLayoutManager";
    public static final int VERTICAL = 1;
    private int carouselAlignment;
    private CarouselStrategy carouselStrategy;
    private int currentEstimatedPosition;
    private int currentFillStartPosition;
    private KeylineState currentKeylineState;
    private final DebugItemDecoration debugItemDecoration;
    private boolean isDebuggingEnabled;
    private KeylineStateList keylineStateList;
    private Map<Integer, KeylineState> keylineStatePositionMap;
    private int lastItemCount;
    int maxScroll;
    int minScroll;
    private CarouselOrientationHelper orientationHelper;
    private final View.OnLayoutChangeListener recyclerViewSizeChangeListener;
    int scrollOffset;

    /* renamed from: lambda$new$0$com-google-android-material-carousel-CarouselLayoutManager, reason: not valid java name */
    /* synthetic */ void m70x2ff337cb(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        if (left != oldLeft || top != oldTop || right != oldRight || bottom != oldBottom) {
            v.post(new Runnable() { // from class: com.google.android.material.carousel.CarouselLayoutManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CarouselLayoutManager.this.refreshKeylineState();
                }
            });
        }
    }

    private static final class ChildCalculations {
        final float center;
        final View child;
        final float offsetCenter;
        final KeylineRange range;

        ChildCalculations(View child, float center, float offsetCenter, KeylineRange range) {
            this.child = child;
            this.center = center;
            this.offsetCenter = offsetCenter;
            this.range = range;
        }
    }

    public CarouselLayoutManager() {
        this(new MultiBrowseCarouselStrategy());
    }

    public CarouselLayoutManager(CarouselStrategy strategy) {
        this(strategy, 0);
    }

    public CarouselLayoutManager(CarouselStrategy strategy, int orientation) {
        this.isDebuggingEnabled = false;
        this.debugItemDecoration = new DebugItemDecoration();
        this.currentFillStartPosition = 0;
        this.recyclerViewSizeChangeListener = new View.OnLayoutChangeListener() { // from class: com.google.android.material.carousel.CarouselLayoutManager$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                CarouselLayoutManager.this.m70x2ff337cb(view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        };
        this.currentEstimatedPosition = -1;
        this.carouselAlignment = 0;
        setCarouselStrategy(strategy);
        setOrientation(orientation);
    }

    public CarouselLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.isDebuggingEnabled = false;
        this.debugItemDecoration = new DebugItemDecoration();
        this.currentFillStartPosition = 0;
        this.recyclerViewSizeChangeListener = new View.OnLayoutChangeListener() { // from class: com.google.android.material.carousel.CarouselLayoutManager$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                CarouselLayoutManager.this.m70x2ff337cb(view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        };
        this.currentEstimatedPosition = -1;
        this.carouselAlignment = 0;
        setCarouselStrategy(new MultiBrowseCarouselStrategy());
        setCarouselAttributes(context, attrs);
    }

    private void setCarouselAttributes(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Carousel);
            setCarouselAlignment(a.getInt(R.styleable.Carousel_carousel_alignment, 0));
            setOrientation(a.getInt(R.styleable.RecyclerView_android_orientation, 0));
            a.recycle();
        }
    }

    public void setCarouselAlignment(int alignment) {
        this.carouselAlignment = alignment;
        refreshKeylineState();
    }

    @Override // com.google.android.material.carousel.Carousel
    public int getCarouselAlignment() {
        return this.carouselAlignment;
    }

    private int getLeftOrTopPaddingForKeylineShift() {
        if (getClipToPadding() || !this.carouselStrategy.isContained()) {
            return 0;
        }
        if (getOrientation() == 1) {
            return getPaddingTop();
        }
        return getPaddingLeft();
    }

    private int getRightOrBottomPaddingForKeylineShift() {
        if (getClipToPadding() || !this.carouselStrategy.isContained()) {
            return 0;
        }
        if (getOrientation() == 1) {
            return getPaddingBottom();
        }
        return getPaddingRight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public void setCarouselStrategy(CarouselStrategy carouselStrategy) {
        this.carouselStrategy = carouselStrategy;
        refreshKeylineState();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView view) {
        super.onAttachedToWindow(view);
        this.carouselStrategy.initialize(view.getContext());
        refreshKeylineState();
        view.addOnLayoutChangeListener(this.recyclerViewSizeChangeListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView view, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(view, recycler);
        view.removeOnLayoutChangeListener(this.recyclerViewSizeChangeListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.getItemCount() <= 0 || getContainerSize() <= 0.0f) {
            removeAndRecycleAllViews(recycler);
            this.currentFillStartPosition = 0;
            return;
        }
        boolean isRtl = isLayoutRtl();
        boolean isInitialLoad = this.keylineStateList == null;
        if (isInitialLoad) {
            recalculateKeylineStateList(recycler);
        }
        int startScroll = calculateStartScroll(this.keylineStateList);
        int endScroll = calculateEndScroll(state, this.keylineStateList);
        this.minScroll = isRtl ? endScroll : startScroll;
        this.maxScroll = isRtl ? startScroll : endScroll;
        if (isInitialLoad) {
            this.scrollOffset = startScroll;
            this.keylineStatePositionMap = this.keylineStateList.getKeylineStateForPositionMap(getItemCount(), this.minScroll, this.maxScroll, isLayoutRtl());
            int i = this.currentEstimatedPosition;
            if (i != -1) {
                this.scrollOffset = getScrollOffsetForPosition(i, getKeylineStateForPosition(i));
            }
        }
        int i2 = this.scrollOffset;
        this.scrollOffset = i2 + calculateShouldScrollBy(0, i2, this.minScroll, this.maxScroll);
        this.currentFillStartPosition = MathUtils.clamp(this.currentFillStartPosition, 0, state.getItemCount());
        updateCurrentKeylineStateForScrollOffset(this.keylineStateList);
        detachAndScrapAttachedViews(recycler);
        fill(recycler, state);
        this.lastItemCount = getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    private void recalculateKeylineStateList(RecyclerView.Recycler recycler) {
        View firstChild = recycler.getViewForPosition(0);
        measureChildWithMargins(firstChild, 0, 0);
        KeylineState keylineState = this.carouselStrategy.onFirstChildMeasuredWithMargins(this, firstChild);
        this.keylineStateList = KeylineStateList.from(this, isLayoutRtl() ? KeylineState.reverse(keylineState, getContainerSize()) : keylineState, getItemMargins(), getLeftOrTopPaddingForKeylineShift(), getRightOrBottomPaddingForKeylineShift());
    }

    private int getItemMargins() {
        if (getChildCount() <= 0) {
            return 0;
        }
        RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) getChildAt(0).getLayoutParams();
        if (this.orientationHelper.orientation == 0) {
            return lp.leftMargin + lp.rightMargin;
        }
        return lp.topMargin + lp.bottomMargin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshKeylineState() {
        this.keylineStateList = null;
        requestLayout();
    }

    private void fill(RecyclerView.Recycler recycler, RecyclerView.State state) {
        removeAndRecycleOutOfBoundsViews(recycler);
        if (getChildCount() == 0) {
            addViewsStart(recycler, this.currentFillStartPosition - 1);
            addViewsEnd(recycler, state, this.currentFillStartPosition);
        } else {
            int firstPosition = getPosition(getChildAt(0));
            int lastPosition = getPosition(getChildAt(getChildCount() - 1));
            addViewsStart(recycler, firstPosition - 1);
            addViewsEnd(recycler, state, lastPosition + 1);
        }
        validateChildOrderIfDebugging();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        if (getChildCount() == 0) {
            this.currentFillStartPosition = 0;
        } else {
            this.currentFillStartPosition = getPosition(getChildAt(0));
        }
        validateChildOrderIfDebugging();
    }

    private void addViewsStart(RecyclerView.Recycler recycler, int startPosition) {
        float start = calculateChildStartForFill(startPosition);
        for (int i = startPosition; i >= 0; i--) {
            ChildCalculations calculations = makeChildCalculations(recycler, start, i);
            if (!isLocOffsetOutOfFillBoundsStart(calculations.offsetCenter, calculations.range)) {
                start = addStart(start, this.currentKeylineState.getItemSize());
                if (!isLocOffsetOutOfFillBoundsEnd(calculations.offsetCenter, calculations.range)) {
                    addAndLayoutView(calculations.child, 0, calculations);
                }
            } else {
                return;
            }
        }
    }

    private void addViewAtPosition(RecyclerView.Recycler recycler, int startPosition, int childIndex) {
        if (startPosition < 0 || startPosition >= getItemCount()) {
            return;
        }
        float start = calculateChildStartForFill(startPosition);
        ChildCalculations calculations = makeChildCalculations(recycler, start, startPosition);
        addAndLayoutView(calculations.child, childIndex, calculations);
    }

    private void addViewsEnd(RecyclerView.Recycler recycler, RecyclerView.State state, int startPosition) {
        float start = calculateChildStartForFill(startPosition);
        for (int i = startPosition; i < state.getItemCount(); i++) {
            ChildCalculations calculations = makeChildCalculations(recycler, start, i);
            if (!isLocOffsetOutOfFillBoundsEnd(calculations.offsetCenter, calculations.range)) {
                start = addEnd(start, this.currentKeylineState.getItemSize());
                if (!isLocOffsetOutOfFillBoundsStart(calculations.offsetCenter, calculations.range)) {
                    addAndLayoutView(calculations.child, -1, calculations);
                }
            } else {
                return;
            }
        }
    }

    private void logChildrenIfDebugging() {
        if (this.isDebuggingEnabled && Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "internal representation of views on the screen");
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                float center = getDecoratedCenterWithMargins(child);
                Log.d(TAG, "item position " + getPosition(child) + ", center:" + center + ", child index:" + i);
            }
            Log.d(TAG, "==============");
        }
    }

    private void validateChildOrderIfDebugging() {
        if (!this.isDebuggingEnabled || getChildCount() < 1) {
            return;
        }
        for (int i = 0; i < getChildCount() - 1; i++) {
            int currPos = getPosition(getChildAt(i));
            int nextPos = getPosition(getChildAt(i + 1));
            if (currPos > nextPos) {
                logChildrenIfDebugging();
                throw new IllegalStateException("Detected invalid child order. Child at index [" + i + "] had adapter position [" + currPos + "] and child at index [" + (i + 1) + "] had adapter position [" + nextPos + "].");
            }
        }
    }

    private ChildCalculations makeChildCalculations(RecyclerView.Recycler recycler, float start, int position) {
        View child = recycler.getViewForPosition(position);
        measureChildWithMargins(child, 0, 0);
        float center = addEnd(start, this.currentKeylineState.getItemSize() / 2.0f);
        KeylineRange range = getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), center, false);
        float offsetCenter = calculateChildOffsetCenterForLocation(child, center, range);
        return new ChildCalculations(child, center, offsetCenter, range);
    }

    private void addAndLayoutView(View child, int index, ChildCalculations calculations) {
        float halfItemSize = this.currentKeylineState.getItemSize() / 2.0f;
        addView(child, index);
        int start = (int) (calculations.offsetCenter - halfItemSize);
        int end = (int) (calculations.offsetCenter + halfItemSize);
        this.orientationHelper.layoutDecoratedWithMargins(child, start, end);
        updateChildMaskForLocation(child, calculations.center, calculations.range);
    }

    private boolean isLocOffsetOutOfFillBoundsStart(float locOffset, KeylineRange range) {
        float maskedSize = getMaskedItemSizeForLocOffset(locOffset, range);
        float maskedEnd = addEnd(locOffset, maskedSize / 2.0f);
        if (isLayoutRtl()) {
            if (maskedEnd > getContainerSize()) {
                return true;
            }
        } else if (maskedEnd < 0.0f) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.carousel.Carousel
    public boolean isHorizontal() {
        return this.orientationHelper.orientation == 0;
    }

    private boolean isLocOffsetOutOfFillBoundsEnd(float locOffset, KeylineRange range) {
        float maskedSize = getMaskedItemSizeForLocOffset(locOffset, range);
        float maskedStart = addStart(locOffset, maskedSize / 2.0f);
        if (isLayoutRtl()) {
            if (maskedStart < 0.0f) {
                return true;
            }
        } else if (maskedStart > getContainerSize()) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void getDecoratedBoundsWithMargins(View view, Rect outBounds) {
        super.getDecoratedBoundsWithMargins(view, outBounds);
        float center = outBounds.centerY();
        if (isHorizontal()) {
            center = outBounds.centerX();
        }
        float maskedSize = getMaskedItemSizeForLocOffset(center, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), center, true));
        float deltaX = isHorizontal() ? (outBounds.width() - maskedSize) / 2.0f : 0.0f;
        float deltaY = isHorizontal() ? 0.0f : (outBounds.height() - maskedSize) / 2.0f;
        outBounds.set((int) (outBounds.left + deltaX), (int) (outBounds.top + deltaY), (int) (outBounds.right - deltaX), (int) (outBounds.bottom - deltaY));
    }

    private float getDecoratedCenterWithMargins(View child) {
        Rect bounds = new Rect();
        super.getDecoratedBoundsWithMargins(child, bounds);
        if (isHorizontal()) {
            return bounds.centerX();
        }
        return bounds.centerY();
    }

    private void removeAndRecycleOutOfBoundsViews(RecyclerView.Recycler recycler) {
        while (getChildCount() > 0) {
            View child = getChildAt(0);
            float center = getDecoratedCenterWithMargins(child);
            KeylineRange range = getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), center, true);
            if (!isLocOffsetOutOfFillBoundsStart(center, range)) {
                break;
            } else {
                removeAndRecycleView(child, recycler);
            }
        }
        while (getChildCount() - 1 >= 0) {
            View child2 = getChildAt(getChildCount() - 1);
            float center2 = getDecoratedCenterWithMargins(child2);
            KeylineRange range2 = getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), center2, true);
            if (isLocOffsetOutOfFillBoundsEnd(center2, range2)) {
                removeAndRecycleView(child2, recycler);
            } else {
                return;
            }
        }
    }

    private static KeylineRange getSurroundingKeylineRange(List<KeylineState.Keyline> keylines, float location, boolean isOffset) {
        int startMinDistanceIndex = -1;
        float startMinDistance = Float.MAX_VALUE;
        int startMostIndex = -1;
        float startMostX = Float.MAX_VALUE;
        int endMinDistanceIndex = -1;
        float endMinDistance = Float.MAX_VALUE;
        int endMostIndex = -1;
        float endMostX = -3.4028235E38f;
        for (int i = 0; i < keylines.size(); i++) {
            KeylineState.Keyline keyline = keylines.get(i);
            float currentLoc = isOffset ? keyline.locOffset : keyline.loc;
            float delta = Math.abs(currentLoc - location);
            if (currentLoc <= location && delta <= startMinDistance) {
                startMinDistance = delta;
                startMinDistanceIndex = i;
            }
            if (currentLoc > location && delta <= endMinDistance) {
                endMinDistance = delta;
                endMinDistanceIndex = i;
            }
            if (currentLoc <= startMostX) {
                startMostIndex = i;
                startMostX = currentLoc;
            }
            if (currentLoc > endMostX) {
                endMostIndex = i;
                endMostX = currentLoc;
            }
        }
        if (startMinDistanceIndex == -1) {
            startMinDistanceIndex = startMostIndex;
        }
        if (endMinDistanceIndex == -1) {
            endMinDistanceIndex = endMostIndex;
        }
        return new KeylineRange(keylines.get(startMinDistanceIndex), keylines.get(endMinDistanceIndex));
    }

    private void updateCurrentKeylineStateForScrollOffset(KeylineStateList keylineStateList) {
        int i = this.maxScroll;
        int i2 = this.minScroll;
        if (i <= i2) {
            this.currentKeylineState = isLayoutRtl() ? keylineStateList.getEndState() : keylineStateList.getStartState();
        } else {
            this.currentKeylineState = keylineStateList.getShiftedState(this.scrollOffset, i2, i);
        }
        this.debugItemDecoration.setKeylines(this.currentKeylineState.getKeylines());
    }

    private static int calculateShouldScrollBy(int delta, int currentScroll, int minScroll, int maxScroll) {
        int targetScroll = currentScroll + delta;
        if (targetScroll < minScroll) {
            return minScroll - currentScroll;
        }
        if (targetScroll > maxScroll) {
            return maxScroll - currentScroll;
        }
        return delta;
    }

    private int calculateStartScroll(KeylineStateList stateList) {
        boolean isRtl = isLayoutRtl();
        KeylineState startState = isRtl ? stateList.getEndState() : stateList.getStartState();
        KeylineState.Keyline startFocalKeyline = isRtl ? startState.getLastFocalKeyline() : startState.getFirstFocalKeyline();
        float firstItemStart = addStart(startFocalKeyline.loc, startState.getItemSize() / 2.0f);
        return (int) (getParentStart() - firstItemStart);
    }

    private int calculateEndScroll(RecyclerView.State state, KeylineStateList stateList) {
        boolean isRtl = isLayoutRtl();
        KeylineState endState = isRtl ? stateList.getStartState() : stateList.getEndState();
        KeylineState.Keyline endFocalKeyline = isRtl ? endState.getFirstFocalKeyline() : endState.getLastFocalKeyline();
        float lastItemDistanceFromFirstItem = (state.getItemCount() - 1) * endState.getItemSize() * (isRtl ? -1.0f : 1.0f);
        float endPadding = isRtl ? -endFocalKeyline.leftOrTopPaddingShift : endFocalKeyline.rightOrBottomPaddingShift;
        float endFocalLocDistanceFromStart = endFocalKeyline.loc - getParentStart();
        float endFocalLocDistanceFromEnd = getParentEnd() - endFocalKeyline.loc;
        int endScroll = (int) ((lastItemDistanceFromFirstItem - endFocalLocDistanceFromStart) + endFocalLocDistanceFromEnd + endPadding);
        return isRtl ? Math.min(0, endScroll) : Math.max(0, endScroll);
    }

    private float calculateChildStartForFill(int startPosition) {
        float childScrollOffset = getParentStart() - this.scrollOffset;
        float positionOffset = this.currentKeylineState.getItemSize() * startPosition;
        return addEnd(childScrollOffset, positionOffset);
    }

    private float calculateChildOffsetCenterForLocation(View child, float childCenterLocation, KeylineRange range) {
        float offsetCenter = AnimationUtils.lerp(range.leftOrTop.locOffset, range.rightOrBottom.locOffset, range.leftOrTop.loc, range.rightOrBottom.loc, childCenterLocation);
        if (range.rightOrBottom == this.currentKeylineState.getFirstKeyline() || range.leftOrTop == this.currentKeylineState.getLastKeyline()) {
            RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) child.getLayoutParams();
            float marginMask = this.orientationHelper.getMaskMargins(lp) / this.currentKeylineState.getItemSize();
            float outOfBoundOffset = (childCenterLocation - range.rightOrBottom.loc) * ((1.0f - range.rightOrBottom.mask) + marginMask);
            return offsetCenter + outOfBoundOffset;
        }
        return offsetCenter;
    }

    private float getMaskedItemSizeForLocOffset(float locOffset, KeylineRange range) {
        return AnimationUtils.lerp(range.leftOrTop.maskedItemSize, range.rightOrBottom.maskedItemSize, range.leftOrTop.locOffset, range.rightOrBottom.locOffset, locOffset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateChildMaskForLocation(View view, float childCenterLocation, KeylineRange range) {
        if (!(view instanceof Maskable)) {
            return;
        }
        float maskProgress = AnimationUtils.lerp(range.leftOrTop.mask, range.rightOrBottom.mask, range.leftOrTop.loc, range.rightOrBottom.loc, childCenterLocation);
        float childHeight = view.getHeight();
        float childWidth = view.getWidth();
        float maskWidth = AnimationUtils.lerp(0.0f, childWidth / 2.0f, 0.0f, 1.0f, maskProgress);
        float maskHeight = AnimationUtils.lerp(0.0f, childHeight / 2.0f, 0.0f, 1.0f, maskProgress);
        RectF maskRect = this.orientationHelper.getMaskRect(childHeight, childWidth, maskHeight, maskWidth);
        float offsetCenter = calculateChildOffsetCenterForLocation(view, childCenterLocation, range);
        float maskedTop = offsetCenter - (maskRect.height() / 2.0f);
        float maskedBottom = (maskRect.height() / 2.0f) + offsetCenter;
        float maskedLeft = offsetCenter - (maskRect.width() / 2.0f);
        float maskedRight = (maskRect.width() / 2.0f) + offsetCenter;
        RectF offsetMaskRect = new RectF(maskedLeft, maskedTop, maskedRight, maskedBottom);
        RectF parentBoundsRect = new RectF(getParentLeft(), getParentTop(), getParentRight(), getParentBottom());
        if (this.carouselStrategy.isContained()) {
            this.orientationHelper.containMaskWithinBounds(maskRect, offsetMaskRect, parentBoundsRect);
        }
        this.orientationHelper.moveMaskOnEdgeOutsideBounds(maskRect, offsetMaskRect, parentBoundsRect);
        ((Maskable) view).setMaskRectF(maskRect);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void measureChildWithMargins(View child, int widthUsed, int heightUsed) {
        float childWidthDimension;
        float childHeightDimension;
        if (!(child instanceof Maskable)) {
            throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        }
        RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) child.getLayoutParams();
        Rect insets = new Rect();
        calculateItemDecorationsForChild(child, insets);
        int widthUsed2 = widthUsed + insets.left + insets.right;
        int heightUsed2 = heightUsed + insets.top + insets.bottom;
        if (this.keylineStateList != null && this.orientationHelper.orientation == 0) {
            childWidthDimension = this.keylineStateList.getDefaultState().getItemSize();
        } else {
            childWidthDimension = lp.width;
        }
        if (this.keylineStateList != null && this.orientationHelper.orientation == 1) {
            childHeightDimension = this.keylineStateList.getDefaultState().getItemSize();
        } else {
            childHeightDimension = lp.height;
        }
        int widthSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + lp.leftMargin + lp.rightMargin + widthUsed2, (int) childWidthDimension, canScrollHorizontally());
        int heightSpec = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + lp.topMargin + lp.bottomMargin + heightUsed2, (int) childHeightDimension, canScrollVertically());
        child.measure(widthSpec, heightSpec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getParentLeft() {
        return this.orientationHelper.getParentLeft();
    }

    private int getParentStart() {
        return this.orientationHelper.getParentStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getParentRight() {
        return this.orientationHelper.getParentRight();
    }

    private int getParentEnd() {
        return this.orientationHelper.getParentEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getParentTop() {
        return this.orientationHelper.getParentTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getParentBottom() {
        return this.orientationHelper.getParentBottom();
    }

    @Override // com.google.android.material.carousel.Carousel
    public int getContainerWidth() {
        return getWidth();
    }

    @Override // com.google.android.material.carousel.Carousel
    public int getContainerHeight() {
        return getHeight();
    }

    private int getContainerSize() {
        if (isHorizontal()) {
            return getContainerWidth();
        }
        return getContainerHeight();
    }

    boolean isLayoutRtl() {
        return isHorizontal() && getLayoutDirection() == 1;
    }

    private float addStart(float value, float amount) {
        return isLayoutRtl() ? value + amount : value - amount;
    }

    private float addEnd(float value, float amount) {
        return isLayoutRtl() ? value - amount : value + amount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        if (getChildCount() > 0) {
            event.setFromIndex(getPosition(getChildAt(0)));
            event.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        }
    }

    private int getScrollOffsetForPosition(int position, KeylineState keylineState) {
        if (isLayoutRtl()) {
            return (int) (((getContainerSize() - keylineState.getLastFocalKeyline().loc) - (position * keylineState.getItemSize())) - (keylineState.getItemSize() / 2.0f));
        }
        return (int) (((position * keylineState.getItemSize()) - keylineState.getFirstFocalKeyline().loc) + (keylineState.getItemSize() / 2.0f));
    }

    private int getSmallestScrollOffsetToFocalKeyline(int position, KeylineState keylineState) {
        int positionOffsetDistanceFromKeyline;
        int smallestScrollOffset = Integer.MAX_VALUE;
        for (KeylineState.Keyline keyline : keylineState.getFocalKeylines()) {
            float offsetWithoutKeylines = position * keylineState.getItemSize();
            float halfFocalKeylineSize = keylineState.getItemSize() / 2.0f;
            float offsetWithKeylines = offsetWithoutKeylines + halfFocalKeylineSize;
            if (isLayoutRtl()) {
                positionOffsetDistanceFromKeyline = (int) ((getContainerSize() - keyline.loc) - offsetWithKeylines);
            } else {
                positionOffsetDistanceFromKeyline = (int) (offsetWithKeylines - keyline.loc);
            }
            int positionOffsetDistanceFromKeyline2 = positionOffsetDistanceFromKeyline - this.scrollOffset;
            if (Math.abs(smallestScrollOffset) > Math.abs(positionOffsetDistanceFromKeyline2)) {
                smallestScrollOffset = positionOffsetDistanceFromKeyline2;
            }
        }
        return smallestScrollOffset;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int targetPosition) {
        if (this.keylineStateList == null) {
            return null;
        }
        KeylineState keylineForScroll = getKeylineStateForPosition(targetPosition);
        int offset = getOffsetToScrollToPosition(targetPosition, keylineForScroll);
        if (isHorizontal()) {
            return new PointF(offset, 0.0f);
        }
        return new PointF(0.0f, offset);
    }

    int getOffsetToScrollToPosition(int position, KeylineState keylineState) {
        int targetScrollOffset = getScrollOffsetForPosition(position, keylineState);
        return targetScrollOffset - this.scrollOffset;
    }

    int getOffsetToScrollToPositionForSnap(int position, boolean partialSnap) {
        KeylineState targetKeylineStateForSnap = this.keylineStateList.getShiftedState(this.scrollOffset, this.minScroll, this.maxScroll, true);
        int targetSnapOffset = getOffsetToScrollToPosition(position, targetKeylineStateForSnap);
        int positionOffset = targetSnapOffset;
        if (this.keylineStatePositionMap != null) {
            positionOffset = getOffsetToScrollToPosition(position, getKeylineStateForPosition(position));
        }
        if (partialSnap) {
            if (Math.abs(positionOffset) < Math.abs(targetSnapOffset)) {
                return positionOffset;
            }
            return targetSnapOffset;
        }
        return targetSnapOffset;
    }

    private KeylineState getKeylineStateForPosition(int position) {
        KeylineState keylineState;
        Map<Integer, KeylineState> map = this.keylineStatePositionMap;
        if (map != null && (keylineState = map.get(Integer.valueOf(MathUtils.clamp(position, 0, Math.max(0, getItemCount() - 1))))) != null) {
            return keylineState;
        }
        return this.keylineStateList.getDefaultState();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int position) {
        this.currentEstimatedPosition = position;
        if (this.keylineStateList == null) {
            return;
        }
        this.scrollOffset = getScrollOffsetForPosition(position, getKeylineStateForPosition(position));
        this.currentFillStartPosition = MathUtils.clamp(position, 0, Math.max(0, getItemCount() - 1));
        updateCurrentKeylineStateForScrollOffset(this.keylineStateList);
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.google.android.material.carousel.CarouselLayoutManager.1
            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF computeScrollVectorForPosition(int targetPosition) {
                return CarouselLayoutManager.this.computeScrollVectorForPosition(targetPosition);
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int calculateDxToMakeVisible(View view, int snapPreference) {
                if (CarouselLayoutManager.this.keylineStateList == null || !CarouselLayoutManager.this.isHorizontal()) {
                    return 0;
                }
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                return carouselLayoutManager.calculateScrollDeltaToMakePositionVisible(carouselLayoutManager.getPosition(view));
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int calculateDyToMakeVisible(View view, int snapPreference) {
                if (CarouselLayoutManager.this.keylineStateList == null || CarouselLayoutManager.this.isHorizontal()) {
                    return 0;
                }
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                return carouselLayoutManager.calculateScrollDeltaToMakePositionVisible(carouselLayoutManager.getPosition(view));
            }
        };
        linearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(linearSmoothScroller);
    }

    int calculateScrollDeltaToMakePositionVisible(int position) {
        KeylineState scrollToKeyline = getKeylineStateForPosition(position);
        float targetScrollOffset = getScrollOffsetForPosition(position, scrollToKeyline);
        return (int) (this.scrollOffset - targetScrollOffset);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return isHorizontal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollHorizontally()) {
            return scrollBy(dx, recycler, state);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return !isHorizontal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollVertically()) {
            return scrollBy(dy, recycler, state);
        }
        return 0;
    }

    private static class LayoutDirection {
        private static final int INVALID_LAYOUT = Integer.MIN_VALUE;
        private static final int LAYOUT_END = 1;
        private static final int LAYOUT_START = -1;

        private LayoutDirection() {
        }
    }

    private int convertFocusDirectionToLayoutDirection(int focusDirection) {
        int orientation = getOrientation();
        switch (focusDirection) {
            case 1:
                return -1;
            case 2:
                return 1;
            case 17:
                if (orientation == 0) {
                    return isLayoutRtl() ? 1 : -1;
                }
                return Integer.MIN_VALUE;
            case 33:
                return orientation == 1 ? -1 : Integer.MIN_VALUE;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                if (orientation == 0) {
                    return isLayoutRtl() ? -1 : 1;
                }
                return Integer.MIN_VALUE;
            case 130:
                return orientation == 1 ? 1 : Integer.MIN_VALUE;
            default:
                Log.d(TAG, "Unknown focus request:" + focusDirection);
                return Integer.MIN_VALUE;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View focused, int focusDirection, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int layoutDir;
        if (getChildCount() == 0 || (layoutDir = convertFocusDirectionToLayoutDirection(focusDirection)) == Integer.MIN_VALUE) {
            return null;
        }
        if (layoutDir == -1) {
            if (getPosition(focused) == 0) {
                return null;
            }
            int firstPosition = getPosition(getChildAt(0));
            addViewAtPosition(recycler, firstPosition - 1, 0);
            View nextFocus = getChildClosestToStart();
            return nextFocus;
        }
        if (getPosition(focused) == getItemCount() - 1) {
            return null;
        }
        int lastPosition = getPosition(getChildAt(getChildCount() - 1));
        addViewAtPosition(recycler, lastPosition + 1, -1);
        View nextFocus2 = getChildClosestToEnd();
        return nextFocus2;
    }

    private View getChildClosestToStart() {
        return getChildAt(isLayoutRtl() ? getChildCount() - 1 : 0);
    }

    private View getChildClosestToEnd() {
        return getChildAt(isLayoutRtl() ? 0 : getChildCount() - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean requestChildRectangleOnScreen(RecyclerView parent, View child, Rect rect, boolean immediate, boolean focusedChildVisible) {
        int delta;
        if (this.keylineStateList == null || (delta = getSmallestScrollOffsetToFocalKeyline(getPosition(child), getKeylineStateForPosition(getPosition(child)))) == 0) {
            return false;
        }
        int realDelta = calculateShouldScrollBy(delta, this.scrollOffset, this.minScroll, this.maxScroll);
        KeylineState scrolledKeylineState = this.keylineStateList.getShiftedState(this.scrollOffset + realDelta, this.minScroll, this.maxScroll);
        scrollBy(parent, getSmallestScrollOffsetToFocalKeyline(getPosition(child), scrolledKeylineState));
        return true;
    }

    private void scrollBy(RecyclerView recyclerView, int delta) {
        if (isHorizontal()) {
            recyclerView.scrollBy(delta, 0);
        } else {
            recyclerView.scrollBy(0, delta);
        }
    }

    private int scrollBy(int distance, RecyclerView.Recycler recycler, RecyclerView.State state) {
        float firstFocalKeylineLoc;
        if (getChildCount() == 0 || distance == 0) {
            return 0;
        }
        if (this.keylineStateList == null) {
            recalculateKeylineStateList(recycler);
        }
        int scrolledBy = calculateShouldScrollBy(distance, this.scrollOffset, this.minScroll, this.maxScroll);
        this.scrollOffset += scrolledBy;
        updateCurrentKeylineStateForScrollOffset(this.keylineStateList);
        float halfItemSize = this.currentKeylineState.getItemSize() / 2.0f;
        int startPosition = getPosition(getChildAt(0));
        float start = calculateChildStartForFill(startPosition);
        Rect boundsRect = new Rect();
        if (isLayoutRtl()) {
            firstFocalKeylineLoc = this.currentKeylineState.getLastFocalKeyline().locOffset;
        } else {
            firstFocalKeylineLoc = this.currentKeylineState.getFirstFocalKeyline().locOffset;
        }
        float absDistanceToFirstFocal = Float.MAX_VALUE;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            float offsetCenter = offsetChild(child, start, halfItemSize, boundsRect);
            float distanceToFirstFocal = Math.abs(firstFocalKeylineLoc - offsetCenter);
            if (child != null && distanceToFirstFocal < absDistanceToFirstFocal) {
                absDistanceToFirstFocal = distanceToFirstFocal;
                this.currentEstimatedPosition = getPosition(child);
            }
            start = addEnd(start, this.currentKeylineState.getItemSize());
        }
        fill(recycler, state);
        return scrolledBy;
    }

    private float offsetChild(View child, float startOffset, float halfItemSize, Rect boundsRect) {
        float center = addEnd(startOffset, halfItemSize);
        KeylineRange range = getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), center, false);
        float offsetCenter = calculateChildOffsetCenterForLocation(child, center, range);
        super.getDecoratedBoundsWithMargins(child, boundsRect);
        updateChildMaskForLocation(child, center, range);
        this.orientationHelper.offsetChild(child, boundsRect, halfItemSize, offsetCenter);
        return offsetCenter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return this.scrollOffset;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0 || this.keylineStateList == null || getItemCount() <= 1) {
            return 0;
        }
        float itemRatio = this.keylineStateList.getDefaultState().getItemSize() / computeHorizontalScrollRange(state);
        return (int) (getWidth() * itemRatio);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return this.maxScroll - this.minScroll;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return this.scrollOffset;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0 || this.keylineStateList == null || getItemCount() <= 1) {
            return 0;
        }
        float itemRatio = this.keylineStateList.getDefaultState().getItemSize() / computeVerticalScrollRange(state);
        return (int) (getHeight() * itemRatio);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return this.maxScroll - this.minScroll;
    }

    public int getOrientation() {
        return this.orientationHelper.orientation;
    }

    public void setOrientation(int orientation) {
        if (orientation != 0 && orientation != 1) {
            throw new IllegalArgumentException("invalid orientation:" + orientation);
        }
        assertNotInLayoutOrScroll(null);
        CarouselOrientationHelper carouselOrientationHelper = this.orientationHelper;
        if (carouselOrientationHelper == null || orientation != carouselOrientationHelper.orientation) {
            this.orientationHelper = CarouselOrientationHelper.createOrientationHelper(this, orientation);
            refreshKeylineState();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsAdded(recyclerView, positionStart, itemCount);
        updateItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsRemoved(recyclerView, positionStart, itemCount);
        updateItemCount();
    }

    private void updateItemCount() {
        int newItemCount = getItemCount();
        int i = this.lastItemCount;
        if (newItemCount == i || this.keylineStateList == null) {
            return;
        }
        if (this.carouselStrategy.shouldRefreshKeylineState(this, i)) {
            refreshKeylineState();
        }
        this.lastItemCount = newItemCount;
    }

    public void setDebuggingEnabled(RecyclerView recyclerView, boolean enabled) {
        this.isDebuggingEnabled = enabled;
        recyclerView.removeItemDecoration(this.debugItemDecoration);
        if (enabled) {
            recyclerView.addItemDecoration(this.debugItemDecoration);
        }
        recyclerView.invalidateItemDecorations();
    }

    private static class KeylineRange {
        final KeylineState.Keyline leftOrTop;
        final KeylineState.Keyline rightOrBottom;

        KeylineRange(KeylineState.Keyline leftOrTop, KeylineState.Keyline rightOrBottom) {
            Preconditions.checkArgument(leftOrTop.loc <= rightOrBottom.loc);
            this.leftOrTop = leftOrTop;
            this.rightOrBottom = rightOrBottom;
        }
    }

    private static class DebugItemDecoration extends RecyclerView.ItemDecoration {
        private List<KeylineState.Keyline> keylines;
        private final Paint linePaint;

        DebugItemDecoration() {
            Paint paint = new Paint();
            this.linePaint = paint;
            this.keylines = Collections.unmodifiableList(new ArrayList());
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        void setKeylines(List<KeylineState.Keyline> keylines) {
            this.keylines = Collections.unmodifiableList(keylines);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            super.onDrawOver(c, parent, state);
            this.linePaint.setStrokeWidth(parent.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width));
            for (KeylineState.Keyline keyline : this.keylines) {
                this.linePaint.setColor(ColorUtils.blendARGB(-65281, -16776961, keyline.mask));
                if (((CarouselLayoutManager) parent.getLayoutManager()).isHorizontal()) {
                    c.drawLine(keyline.locOffset, ((CarouselLayoutManager) parent.getLayoutManager()).getParentTop(), keyline.locOffset, ((CarouselLayoutManager) parent.getLayoutManager()).getParentBottom(), this.linePaint);
                } else {
                    c.drawLine(((CarouselLayoutManager) parent.getLayoutManager()).getParentLeft(), keyline.locOffset, ((CarouselLayoutManager) parent.getLayoutManager()).getParentRight(), keyline.locOffset, this.linePaint);
                }
            }
        }
    }
}
