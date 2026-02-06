package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
abstract class SheetDelegate {
    abstract int calculateInnerMargin(ViewGroup.MarginLayoutParams marginLayoutParams);

    abstract float calculateSlideOffset(int i);

    abstract int getCoplanarSiblingAdjacentMargin(ViewGroup.MarginLayoutParams marginLayoutParams);

    abstract int getExpandedOffset();

    abstract int getHiddenOffset();

    abstract int getMaxViewPositionHorizontal();

    abstract int getMinViewPositionHorizontal();

    abstract <V extends View> int getOuterEdge(V v);

    abstract int getParentInnerEdge(CoordinatorLayout coordinatorLayout);

    abstract int getSheetEdge();

    abstract boolean isExpandingOutwards(float f);

    abstract boolean isReleasedCloseToInnerEdge(View view);

    abstract boolean isSwipeSignificant(float f, float f2);

    abstract boolean shouldHide(View view, float f);

    abstract void updateCoplanarSiblingAdjacentMargin(ViewGroup.MarginLayoutParams marginLayoutParams, int i);

    abstract void updateCoplanarSiblingLayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2);

    SheetDelegate() {
    }
}
