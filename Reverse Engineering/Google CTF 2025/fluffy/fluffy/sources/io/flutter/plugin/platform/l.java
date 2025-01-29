package io.flutter.plugin.platform;

import android.content.Context;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/* loaded from: classes.dex */
public final class l extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f737a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f738b;

    public l(Context context) {
        super(context);
        this.f737a = new Rect();
        this.f738b = new Rect();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) childAt.getLayoutParams();
            this.f737a.set(i2, i3, i4, i5);
            Gravity.apply(layoutParams.gravity, childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), this.f737a, layoutParams.x, layoutParams.y, this.f738b);
            Rect rect = this.f738b;
            childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            getChildAt(i4).measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), Integer.MIN_VALUE));
        }
        super.onMeasure(i2, i3);
    }
}
