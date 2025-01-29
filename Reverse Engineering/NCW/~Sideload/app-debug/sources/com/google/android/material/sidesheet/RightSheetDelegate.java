package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
final class RightSheetDelegate extends SheetDelegate {
    final SideSheetBehavior<? extends View> sheetBehavior;

    RightSheetDelegate(SideSheetBehavior<? extends View> sheetBehavior) {
        this.sheetBehavior = sheetBehavior;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getSheetEdge() {
        return 0;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getHiddenOffset() {
        return this.sheetBehavior.getParentWidth();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getExpandedOffset() {
        return Math.max(0, (getHiddenOffset() - this.sheetBehavior.getChildWidth()) - this.sheetBehavior.getInnerMargin());
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean isReleasedCloseToInnerEdge(View releasedChild) {
        return releasedChild.getLeft() > (getHiddenOffset() + getExpandedOffset()) / 2;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean isSwipeSignificant(float xVelocity, float yVelocity) {
        return SheetUtils.isSwipeMostlyHorizontal(xVelocity, yVelocity) && Math.abs(xVelocity) > ((float) this.sheetBehavior.getSignificantVelocityThreshold());
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean shouldHide(View child, float velocity) {
        float newRight = child.getRight() + (this.sheetBehavior.getHideFriction() * velocity);
        return Math.abs(newRight) > this.sheetBehavior.getHideThreshold();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    <V extends View> int getOuterEdge(V child) {
        return child.getLeft() - this.sheetBehavior.getInnerMargin();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    float calculateSlideOffset(int left) {
        float hiddenOffset = getHiddenOffset();
        float sheetWidth = hiddenOffset - getExpandedOffset();
        return (hiddenOffset - left) / sheetWidth;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    void updateCoplanarSiblingLayoutParams(ViewGroup.MarginLayoutParams coplanarSiblingLayoutParams, int sheetLeft, int sheetRight) {
        int parentWidth = this.sheetBehavior.getParentWidth();
        if (sheetLeft <= parentWidth) {
            coplanarSiblingLayoutParams.rightMargin = parentWidth - sheetLeft;
        }
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    void updateCoplanarSiblingAdjacentMargin(ViewGroup.MarginLayoutParams coplanarSiblingLayoutParams, int coplanarSiblingAdjacentMargin) {
        coplanarSiblingLayoutParams.rightMargin = coplanarSiblingAdjacentMargin;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getCoplanarSiblingAdjacentMargin(ViewGroup.MarginLayoutParams coplanarSiblingLayoutParams) {
        return coplanarSiblingLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public int getParentInnerEdge(CoordinatorLayout parent) {
        return parent.getRight();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int calculateInnerMargin(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getMinViewPositionHorizontal() {
        return getExpandedOffset();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getMaxViewPositionHorizontal() {
        return this.sheetBehavior.getParentWidth();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean isExpandingOutwards(float xVelocity) {
        return xVelocity < 0.0f;
    }
}
