package com.google.android.material.carousel;

import android.view.View;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class MultiBrowseCarouselStrategy extends CarouselStrategy {
    private int keylineCount = 0;
    private static final int[] SMALL_COUNTS = {1};
    private static final int[] MEDIUM_COUNTS = {1, 0};

    @Override // com.google.android.material.carousel.CarouselStrategy
    KeylineState onFirstChildMeasuredWithMargins(Carousel carousel, View child) {
        float childMargins;
        float measuredChildSize;
        int[] smallCounts;
        int[] mediumCounts;
        float availableSpace = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            availableSpace = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams childLayoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
        float childMargins2 = childLayoutParams.topMargin + childLayoutParams.bottomMargin;
        float measuredChildSize2 = child.getMeasuredHeight();
        if (!carousel.isHorizontal()) {
            childMargins = childMargins2;
            measuredChildSize = measuredChildSize2;
        } else {
            float childMargins3 = childLayoutParams.leftMargin + childLayoutParams.rightMargin;
            float measuredChildSize3 = child.getMeasuredWidth();
            childMargins = childMargins3;
            measuredChildSize = measuredChildSize3;
        }
        float childMargins4 = getSmallItemSizeMin();
        float smallChildSizeMin = childMargins4 + childMargins;
        float smallChildSizeMax = Math.max(getSmallItemSizeMax() + childMargins, smallChildSizeMin);
        float targetLargeChildSize = Math.min(measuredChildSize + childMargins, availableSpace);
        float targetSmallChildSize = MathUtils.clamp((measuredChildSize / 3.0f) + childMargins, smallChildSizeMin + childMargins, smallChildSizeMax + childMargins);
        float targetMediumChildSize = (targetLargeChildSize + targetSmallChildSize) / 2.0f;
        int[] smallCounts2 = SMALL_COUNTS;
        if (availableSpace < 2.0f * smallChildSizeMin) {
            smallCounts2 = new int[]{0};
        }
        int[] mediumCounts2 = MEDIUM_COUNTS;
        if (carousel.getCarouselAlignment() != 1) {
            smallCounts = smallCounts2;
            mediumCounts = mediumCounts2;
        } else {
            smallCounts = doubleCounts(smallCounts2);
            mediumCounts = doubleCounts(mediumCounts2);
        }
        float minAvailableLargeSpace = (availableSpace - (CarouselStrategyHelper.maxValue(mediumCounts) * targetMediumChildSize)) - (CarouselStrategyHelper.maxValue(smallCounts) * smallChildSizeMax);
        int largeCountMin = (int) Math.max(1.0d, Math.floor(minAvailableLargeSpace / targetLargeChildSize));
        int largeCountMax = (int) Math.ceil(availableSpace / targetLargeChildSize);
        int[] largeCounts = new int[(largeCountMax - largeCountMin) + 1];
        for (int i = 0; i < largeCounts.length; i++) {
            largeCounts[i] = largeCountMax - i;
        }
        Arrangement arrangement = Arrangement.findLowestCostArrangement(availableSpace, targetSmallChildSize, smallChildSizeMin, smallChildSizeMax, smallCounts, targetMediumChildSize, mediumCounts, targetLargeChildSize, largeCounts);
        this.keylineCount = arrangement.getItemCount();
        if (ensureArrangementFitsItemCount(arrangement, carousel.getItemCount())) {
            arrangement = Arrangement.findLowestCostArrangement(availableSpace, targetSmallChildSize, smallChildSizeMin, smallChildSizeMax, new int[]{arrangement.smallCount}, targetMediumChildSize, new int[]{arrangement.mediumCount}, targetLargeChildSize, new int[]{arrangement.largeCount});
        }
        return CarouselStrategyHelper.createKeylineState(child.getContext(), childMargins, availableSpace, arrangement, carousel.getCarouselAlignment());
    }

    boolean ensureArrangementFitsItemCount(Arrangement arrangement, int carouselItemCount) {
        int keylineSurplus = arrangement.getItemCount() - carouselItemCount;
        boolean changed = keylineSurplus > 0 && (arrangement.smallCount > 0 || arrangement.mediumCount > 1);
        while (keylineSurplus > 0) {
            if (arrangement.smallCount > 0) {
                arrangement.smallCount--;
            } else if (arrangement.mediumCount > 1) {
                arrangement.mediumCount--;
            }
            keylineSurplus--;
        }
        return changed;
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    boolean shouldRefreshKeylineState(Carousel carousel, int oldItemCount) {
        return (oldItemCount < this.keylineCount && carousel.getItemCount() >= this.keylineCount) || (oldItemCount >= this.keylineCount && carousel.getItemCount() < this.keylineCount);
    }
}
