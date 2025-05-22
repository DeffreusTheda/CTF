package com.google.android.material.carousel;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
abstract class CarouselOrientationHelper {
    final int orientation;

    abstract void containMaskWithinBounds(RectF rectF, RectF rectF2, RectF rectF3);

    abstract int getDecoratedCrossAxisMeasurement(View view);

    abstract float getMaskMargins(RecyclerView.LayoutParams layoutParams);

    abstract RectF getMaskRect(float f, float f2, float f3, float f4);

    abstract int getParentBottom();

    abstract int getParentEnd();

    abstract int getParentLeft();

    abstract int getParentRight();

    abstract int getParentStart();

    abstract int getParentTop();

    abstract void layoutDecoratedWithMargins(View view, int i, int i2);

    abstract void moveMaskOnEdgeOutsideBounds(RectF rectF, RectF rectF2, RectF rectF3);

    abstract void offsetChild(View view, Rect rect, float f, float f2);

    private CarouselOrientationHelper(int orientation) {
        this.orientation = orientation;
    }

    static CarouselOrientationHelper createOrientationHelper(CarouselLayoutManager layoutManager, int orientation) {
        switch (orientation) {
            case 0:
                return createHorizontalHelper(layoutManager);
            case 1:
                return createVerticalHelper(layoutManager);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    private static CarouselOrientationHelper createVerticalHelper(final CarouselLayoutManager carouselLayoutManager) {
        return new CarouselOrientationHelper(1) { // from class: com.google.android.material.carousel.CarouselOrientationHelper.1
            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentLeft() {
                return carouselLayoutManager.getPaddingLeft();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentStart() {
                return getParentTop();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentRight() {
                return carouselLayoutManager.getWidth() - carouselLayoutManager.getPaddingRight();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentEnd() {
                return getParentBottom();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentTop() {
                return 0;
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentBottom() {
                return carouselLayoutManager.getHeight();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getDecoratedCrossAxisMeasurement(View child) {
                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
                return carouselLayoutManager.getDecoratedMeasuredWidth(child) + params.leftMargin + params.rightMargin;
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void layoutDecoratedWithMargins(View child, int head, int tail) {
                int left = getParentLeft();
                int right = left + getDecoratedCrossAxisMeasurement(child);
                carouselLayoutManager.layoutDecoratedWithMargins(child, left, head, right, tail);
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public float getMaskMargins(RecyclerView.LayoutParams layoutParams) {
                return layoutParams.topMargin + layoutParams.bottomMargin;
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public RectF getMaskRect(float childHeight, float childWidth, float maskHeight, float maskWidth) {
                return new RectF(0.0f, maskHeight, childWidth, childHeight - maskHeight);
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void containMaskWithinBounds(RectF maskRect, RectF offsetMaskRect, RectF boundsRect) {
                if (offsetMaskRect.top < boundsRect.top && offsetMaskRect.bottom > boundsRect.top) {
                    float diff = boundsRect.top - offsetMaskRect.top;
                    maskRect.top += diff;
                    boundsRect.top += diff;
                }
                if (offsetMaskRect.bottom > boundsRect.bottom && offsetMaskRect.top < boundsRect.bottom) {
                    float diff2 = offsetMaskRect.bottom - boundsRect.bottom;
                    maskRect.bottom = Math.max(maskRect.bottom - diff2, maskRect.top);
                    offsetMaskRect.bottom = Math.max(offsetMaskRect.bottom - diff2, offsetMaskRect.top);
                }
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void moveMaskOnEdgeOutsideBounds(RectF maskRect, RectF offsetMaskRect, RectF parentBoundsRect) {
                if (offsetMaskRect.bottom <= parentBoundsRect.top) {
                    maskRect.bottom = ((float) Math.floor(maskRect.bottom)) - 1.0f;
                    maskRect.top = Math.min(maskRect.top, maskRect.bottom);
                }
                if (offsetMaskRect.top >= parentBoundsRect.bottom) {
                    maskRect.top = ((float) Math.ceil(maskRect.top)) + 1.0f;
                    maskRect.bottom = Math.max(maskRect.top, maskRect.bottom);
                }
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void offsetChild(View child, Rect boundsRect, float halfItemSize, float offsetCenter) {
                float actualCy = boundsRect.top + halfItemSize;
                child.offsetTopAndBottom((int) (offsetCenter - actualCy));
            }
        };
    }

    private static CarouselOrientationHelper createHorizontalHelper(final CarouselLayoutManager carouselLayoutManager) {
        return new CarouselOrientationHelper(0) { // from class: com.google.android.material.carousel.CarouselOrientationHelper.2
            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentLeft() {
                return 0;
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentStart() {
                return carouselLayoutManager.isLayoutRtl() ? getParentRight() : getParentLeft();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentRight() {
                return carouselLayoutManager.getWidth();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentEnd() {
                return carouselLayoutManager.isLayoutRtl() ? getParentLeft() : getParentRight();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentTop() {
                return carouselLayoutManager.getPaddingTop();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentBottom() {
                return carouselLayoutManager.getHeight() - carouselLayoutManager.getPaddingBottom();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getDecoratedCrossAxisMeasurement(View child) {
                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
                return carouselLayoutManager.getDecoratedMeasuredHeight(child) + params.topMargin + params.bottomMargin;
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void layoutDecoratedWithMargins(View child, int head, int tail) {
                int top = getParentTop();
                int bottom = top + getDecoratedCrossAxisMeasurement(child);
                carouselLayoutManager.layoutDecoratedWithMargins(child, head, top, tail, bottom);
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public float getMaskMargins(RecyclerView.LayoutParams layoutParams) {
                return layoutParams.rightMargin + layoutParams.leftMargin;
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public RectF getMaskRect(float childHeight, float childWidth, float maskHeight, float maskWidth) {
                return new RectF(maskWidth, 0.0f, childWidth - maskWidth, childHeight);
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void containMaskWithinBounds(RectF maskRect, RectF offsetMaskRect, RectF boundsRect) {
                if (offsetMaskRect.left < boundsRect.left && offsetMaskRect.right > boundsRect.left) {
                    float diff = boundsRect.left - offsetMaskRect.left;
                    maskRect.left += diff;
                    offsetMaskRect.left += diff;
                }
                if (offsetMaskRect.right > boundsRect.right && offsetMaskRect.left < boundsRect.right) {
                    float diff2 = offsetMaskRect.right - boundsRect.right;
                    maskRect.right = Math.max(maskRect.right - diff2, maskRect.left);
                    offsetMaskRect.right = Math.max(offsetMaskRect.right - diff2, offsetMaskRect.left);
                }
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void moveMaskOnEdgeOutsideBounds(RectF maskRect, RectF offsetMaskRect, RectF parentBoundsRect) {
                if (offsetMaskRect.right <= parentBoundsRect.left) {
                    maskRect.right = ((float) Math.floor(maskRect.right)) - 1.0f;
                    maskRect.left = Math.min(maskRect.left, maskRect.right);
                }
                if (offsetMaskRect.left >= parentBoundsRect.right) {
                    maskRect.left = ((float) Math.ceil(maskRect.left)) + 1.0f;
                    maskRect.right = Math.max(maskRect.left, maskRect.right);
                }
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void offsetChild(View child, Rect boundsRect, float halfItemSize, float offsetCenter) {
                float actualCx = boundsRect.left + halfItemSize;
                child.offsetLeftAndRight((int) (offsetCenter - actualCx));
            }
        };
    }
}
