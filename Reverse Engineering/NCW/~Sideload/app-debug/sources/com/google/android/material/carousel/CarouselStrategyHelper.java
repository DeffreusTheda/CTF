package com.google.android.material.carousel;

import android.content.Context;
import com.google.android.material.R;
import com.google.android.material.carousel.KeylineState;

/* loaded from: classes.dex */
final class CarouselStrategyHelper {
    private CarouselStrategyHelper() {
    }

    static float getExtraSmallSize(Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_gone_size);
    }

    static float getSmallSizeMin(Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
    }

    static float getSmallSizeMax(Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
    }

    static KeylineState createKeylineState(Context context, float childMargins, float availableSpace, Arrangement arrangement, int alignment) {
        if (alignment == 1) {
            return createCenterAlignedKeylineState(context, childMargins, availableSpace, arrangement);
        }
        return createLeftAlignedKeylineState(context, childMargins, availableSpace, arrangement);
    }

    static KeylineState createLeftAlignedKeylineState(Context context, float childHorizontalMargins, float availableSpace, Arrangement arrangement) {
        float extraSmallChildWidth = Math.min(getExtraSmallSize(context) + childHorizontalMargins, arrangement.largeSize);
        float extraSmallHeadCenterX = 0.0f - (extraSmallChildWidth / 2.0f);
        float largeStartCenterX = addStart(0.0f, arrangement.largeSize, arrangement.largeCount);
        float largeEndCenterX = addEnd(largeStartCenterX, arrangement.largeSize, arrangement.largeCount);
        float start = updateCurPosition(0.0f, largeEndCenterX, arrangement.largeSize, arrangement.largeCount);
        float mediumCenterX = addStart(start, arrangement.mediumSize, arrangement.mediumCount);
        float smallStartCenterX = addStart(updateCurPosition(start, mediumCenterX, arrangement.mediumSize, arrangement.mediumCount), arrangement.smallSize, arrangement.smallCount);
        float extraSmallTailCenterX = (extraSmallChildWidth / 2.0f) + availableSpace;
        float extraSmallMask = CarouselStrategy.getChildMaskPercentage(extraSmallChildWidth, arrangement.largeSize, childHorizontalMargins);
        float smallMask = CarouselStrategy.getChildMaskPercentage(arrangement.smallSize, arrangement.largeSize, childHorizontalMargins);
        float mediumMask = CarouselStrategy.getChildMaskPercentage(arrangement.mediumSize, arrangement.largeSize, childHorizontalMargins);
        KeylineState.Builder builder = new KeylineState.Builder(arrangement.largeSize, availableSpace).addAnchorKeyline(extraSmallHeadCenterX, extraSmallMask, extraSmallChildWidth).addKeylineRange(largeStartCenterX, 0.0f, arrangement.largeSize, arrangement.largeCount, true);
        if (arrangement.mediumCount > 0) {
            builder.addKeyline(mediumCenterX, mediumMask, arrangement.mediumSize);
        }
        if (arrangement.smallCount > 0) {
            builder.addKeylineRange(smallStartCenterX, smallMask, arrangement.smallSize, arrangement.smallCount);
        }
        builder.addAnchorKeyline(extraSmallTailCenterX, extraSmallMask, extraSmallChildWidth);
        return builder.build();
    }

    static KeylineState createCenterAlignedKeylineState(Context context, float childHorizontalMargins, float availableSpace, Arrangement arrangement) {
        float extraSmallMask;
        float extraSmallChildWidth = Math.min(getExtraSmallSize(context) + childHorizontalMargins, arrangement.largeSize);
        float extraSmallHeadCenterX = 0.0f - (extraSmallChildWidth / 2.0f);
        float halfSmallStartCenterX = addStart(0.0f, arrangement.smallSize, arrangement.smallCount);
        float halfSmallEndCenterX = addEnd(halfSmallStartCenterX, arrangement.smallSize, (int) Math.floor(arrangement.smallCount / 2.0f));
        float start = updateCurPosition(0.0f, halfSmallEndCenterX, arrangement.smallSize, arrangement.smallCount);
        float halfMediumStartCenterX = addStart(start, arrangement.mediumSize, arrangement.mediumCount);
        float halfMediumEndCenterX = addEnd(halfMediumStartCenterX, arrangement.mediumSize, (int) Math.floor(arrangement.mediumCount / 2.0f));
        float start2 = updateCurPosition(start, halfMediumEndCenterX, arrangement.mediumSize, arrangement.mediumCount);
        float largeStartCenterX = addStart(start2, arrangement.largeSize, arrangement.largeCount);
        float largeEndCenterX = addEnd(largeStartCenterX, arrangement.largeSize, arrangement.largeCount);
        float start3 = updateCurPosition(start2, largeEndCenterX, arrangement.largeSize, arrangement.largeCount);
        float secondHalfMediumStartCenterX = addStart(start3, arrangement.mediumSize, arrangement.mediumCount);
        float secondHalfMediumEndCenterX = addEnd(secondHalfMediumStartCenterX, arrangement.mediumSize, (int) Math.ceil(arrangement.mediumCount / 2.0f));
        float secondHalfSmallStartCenterX = addStart(updateCurPosition(start3, secondHalfMediumEndCenterX, arrangement.mediumSize, arrangement.mediumCount), arrangement.smallSize, arrangement.smallCount);
        float extraSmallTailCenterX = (extraSmallChildWidth / 2.0f) + availableSpace;
        float extraSmallMask2 = CarouselStrategy.getChildMaskPercentage(extraSmallChildWidth, arrangement.largeSize, childHorizontalMargins);
        float start4 = arrangement.smallSize;
        float secondHalfMediumEndCenterX2 = arrangement.largeSize;
        float smallMask = CarouselStrategy.getChildMaskPercentage(start4, secondHalfMediumEndCenterX2, childHorizontalMargins);
        float f = arrangement.mediumSize;
        float halfSmallEndCenterX2 = arrangement.largeSize;
        float mediumMask = CarouselStrategy.getChildMaskPercentage(f, halfSmallEndCenterX2, childHorizontalMargins);
        float halfMediumEndCenterX2 = arrangement.largeSize;
        KeylineState.Builder builder = new KeylineState.Builder(halfMediumEndCenterX2, availableSpace).addAnchorKeyline(extraSmallHeadCenterX, extraSmallMask2, extraSmallChildWidth);
        if (arrangement.smallCount > 0) {
            extraSmallMask = extraSmallMask2;
            builder.addKeylineRange(halfSmallStartCenterX, smallMask, arrangement.smallSize, (int) Math.floor(arrangement.smallCount / 2.0f));
        } else {
            extraSmallMask = extraSmallMask2;
        }
        if (arrangement.mediumCount > 0) {
            builder.addKeylineRange(halfMediumStartCenterX, mediumMask, arrangement.mediumSize, (int) Math.floor(arrangement.mediumCount / 2.0f));
        }
        float extraSmallMask3 = extraSmallMask;
        builder.addKeylineRange(largeStartCenterX, 0.0f, arrangement.largeSize, arrangement.largeCount, true);
        if (arrangement.mediumCount > 0) {
            builder.addKeylineRange(secondHalfMediumStartCenterX, mediumMask, arrangement.mediumSize, (int) Math.ceil(arrangement.mediumCount / 2.0f));
        }
        if (arrangement.smallCount > 0) {
            builder.addKeylineRange(secondHalfSmallStartCenterX, smallMask, arrangement.smallSize, (int) Math.ceil(arrangement.smallCount / 2.0f));
        }
        builder.addAnchorKeyline(extraSmallTailCenterX, extraSmallMask3, extraSmallChildWidth);
        return builder.build();
    }

    static int maxValue(int[] array) {
        int largest = Integer.MIN_VALUE;
        for (int j : array) {
            if (j > largest) {
                largest = j;
            }
        }
        return largest;
    }

    static float addStart(float start, float itemSize, int count) {
        if (count > 0) {
            return (itemSize / 2.0f) + start;
        }
        return start;
    }

    static float addEnd(float startKeylinePos, float itemSize, int count) {
        return (Math.max(0, count - 1) * itemSize) + startKeylinePos;
    }

    static float updateCurPosition(float curPosition, float lastEndKeyline, float itemSize, int count) {
        if (count > 0) {
            return (itemSize / 2.0f) + lastEndKeyline;
        }
        return curPosition;
    }
}
