package com.google.android.material.carousel;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class FullScreenCarouselStrategy extends CarouselStrategy {
    @Override // com.google.android.material.carousel.CarouselStrategy
    KeylineState onFirstChildMeasuredWithMargins(Carousel carousel, View child) {
        float availableSpace;
        float childMargins;
        RecyclerView.LayoutParams childLayoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
        if (carousel.isHorizontal()) {
            availableSpace = carousel.getContainerWidth();
            childMargins = childLayoutParams.leftMargin + childLayoutParams.rightMargin;
        } else {
            availableSpace = carousel.getContainerHeight();
            childMargins = childLayoutParams.topMargin + childLayoutParams.bottomMargin;
        }
        float targetChildSize = Math.min(availableSpace + childMargins, availableSpace);
        Arrangement arrangement = new Arrangement(0, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0, targetChildSize, 1, availableSpace);
        return CarouselStrategyHelper.createLeftAlignedKeylineState(child.getContext(), childMargins, availableSpace, arrangement);
    }
}
