package com.google.android.material.carousel;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

/* loaded from: classes.dex */
public class CarouselSnapHelper extends SnapHelper {
    private static final float HORIZONTAL_SNAP_SPEED = 100.0f;
    private static final float VERTICAL_SNAP_SPEED = 50.0f;
    private final boolean disableFling;
    private RecyclerView recyclerView;

    public CarouselSnapHelper() {
        this(true);
    }

    public CarouselSnapHelper(boolean disableFling) {
        this.disableFling = disableFling;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(RecyclerView recyclerView) {
        super.attachToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        return calculateDistanceToSnap(layoutManager, view, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] calculateDistanceToSnap(RecyclerView.LayoutManager layoutManager, View view, boolean partialSnap) {
        if (!(layoutManager instanceof CarouselLayoutManager)) {
            return new int[]{0, 0};
        }
        int offset = distanceToFirstFocalKeyline(view, (CarouselLayoutManager) layoutManager, partialSnap);
        if (layoutManager.canScrollHorizontally()) {
            return new int[]{offset, 0};
        }
        if (layoutManager.canScrollVertically()) {
            return new int[]{0, offset};
        }
        return new int[]{0, 0};
    }

    private int distanceToFirstFocalKeyline(View targetView, CarouselLayoutManager layoutManager, boolean partialSnap) {
        return layoutManager.getOffsetToScrollToPositionForSnap(layoutManager.getPosition(targetView), partialSnap);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        return findViewNearestFirstKeyline(layoutManager);
    }

    private View findViewNearestFirstKeyline(RecyclerView.LayoutManager layoutManager) {
        int childCount = layoutManager.getChildCount();
        if (childCount == 0 || !(layoutManager instanceof CarouselLayoutManager)) {
            return null;
        }
        View closestChild = null;
        int absClosest = Integer.MAX_VALUE;
        CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) layoutManager;
        for (int i = 0; i < childCount; i++) {
            View child = layoutManager.getChildAt(i);
            int position = layoutManager.getPosition(child);
            int offset = Math.abs(carouselLayoutManager.getOffsetToScrollToPositionForSnap(position, false));
            if (offset < absClosest) {
                absClosest = offset;
                closestChild = child;
            }
        }
        return closestChild;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
        int itemCount;
        if (!this.disableFling || (itemCount = layoutManager.getItemCount()) == 0) {
            return -1;
        }
        View closestChildBeforeKeyline = null;
        int distanceBefore = Integer.MIN_VALUE;
        View closestChildAfterKeyline = null;
        int distanceAfter = Integer.MAX_VALUE;
        int childCount = layoutManager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = layoutManager.getChildAt(i);
            if (child != null) {
                int distance = distanceToFirstFocalKeyline(child, (CarouselLayoutManager) layoutManager, false);
                if (distance <= 0 && distance > distanceBefore) {
                    distanceBefore = distance;
                    closestChildBeforeKeyline = child;
                }
                if (distance >= 0 && distance < distanceAfter) {
                    distanceAfter = distance;
                    closestChildAfterKeyline = child;
                }
            }
        }
        boolean forwardDirection = isForwardFling(layoutManager, velocityX, velocityY);
        if (forwardDirection && closestChildAfterKeyline != null) {
            return layoutManager.getPosition(closestChildAfterKeyline);
        }
        if (!forwardDirection && closestChildBeforeKeyline != null) {
            return layoutManager.getPosition(closestChildBeforeKeyline);
        }
        View visibleView = forwardDirection ? closestChildBeforeKeyline : closestChildAfterKeyline;
        if (visibleView == null) {
            return -1;
        }
        int visiblePosition = layoutManager.getPosition(visibleView);
        int snapToPosition = (isReverseLayout(layoutManager) == forwardDirection ? -1 : 1) + visiblePosition;
        if (snapToPosition < 0 || snapToPosition >= itemCount) {
            return -1;
        }
        return snapToPosition;
    }

    private boolean isForwardFling(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
        return layoutManager.canScrollHorizontally() ? velocityX > 0 : velocityY > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isReverseLayout(RecyclerView.LayoutManager layoutManager) {
        int itemCount = layoutManager.getItemCount();
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            RecyclerView.SmoothScroller.ScrollVectorProvider vectorProvider = (RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager;
            PointF vectorForEnd = vectorProvider.computeScrollVectorForPosition(itemCount - 1);
            if (vectorForEnd != null) {
                return vectorForEnd.x < 0.0f || vectorForEnd.y < 0.0f;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    protected RecyclerView.SmoothScroller createScroller(final RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new LinearSmoothScroller(this.recyclerView.getContext()) { // from class: com.google.android.material.carousel.CarouselSnapHelper.1
                @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
                protected void onTargetFound(View targetView, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                    if (CarouselSnapHelper.this.recyclerView != null) {
                        CarouselSnapHelper carouselSnapHelper = CarouselSnapHelper.this;
                        int[] snapDistances = carouselSnapHelper.calculateDistanceToSnap(carouselSnapHelper.recyclerView.getLayoutManager(), targetView, true);
                        int dx = snapDistances[0];
                        int dy = snapDistances[1];
                        int time = calculateTimeForDeceleration(Math.max(Math.abs(dx), Math.abs(dy)));
                        if (time > 0) {
                            action.update(dx, dy, time, this.mDecelerateInterpolator);
                        }
                    }
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    if (layoutManager.canScrollVertically()) {
                        return 50.0f / displayMetrics.densityDpi;
                    }
                    return CarouselSnapHelper.HORIZONTAL_SNAP_SPEED / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }
}
