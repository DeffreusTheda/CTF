package com.google.android.material.materialswitch;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;

/* loaded from: classes.dex */
public class MaterialSwitch extends SwitchCompat {
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_CompoundButton_MaterialSwitch;
    private static final int[] STATE_SET_WITH_ICON = {R.attr.state_with_icon};
    private int[] currentStateChecked;
    private int[] currentStateUnchecked;
    private Drawable thumbDrawable;
    private Drawable thumbIconDrawable;
    private int thumbIconSize;
    private ColorStateList thumbIconTintList;
    private PorterDuff.Mode thumbIconTintMode;
    private ColorStateList thumbTintList;
    private Drawable trackDecorationDrawable;
    private ColorStateList trackDecorationTintList;
    private PorterDuff.Mode trackDecorationTintMode;
    private Drawable trackDrawable;
    private ColorStateList trackTintList;

    public MaterialSwitch(Context context) {
        this(context, null);
    }

    public MaterialSwitch(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.materialSwitchStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialSwitch(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r4 = com.google.android.material.materialswitch.MaterialSwitch.DEF_STYLE_RES
            android.content.Context r0 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r9, r10, r11, r4)
            r8.<init>(r0, r10, r11)
            r6 = -1
            r8.thumbIconSize = r6
            android.content.Context r9 = r8.getContext()
            android.graphics.drawable.Drawable r0 = super.getThumbDrawable()
            r8.thumbDrawable = r0
            android.content.res.ColorStateList r0 = super.getThumbTintList()
            r8.thumbTintList = r0
            r0 = 0
            super.setThumbTintList(r0)
            android.graphics.drawable.Drawable r1 = super.getTrackDrawable()
            r8.trackDrawable = r1
            android.content.res.ColorStateList r1 = super.getTrackTintList()
            r8.trackTintList = r1
            super.setTrackTintList(r0)
            int[] r2 = com.google.android.material.R.styleable.MaterialSwitch
            r7 = 0
            int[] r5 = new int[r7]
            r0 = r9
            r1 = r10
            r3 = r11
            androidx.appcompat.widget.TintTypedArray r0 = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R.styleable.MaterialSwitch_thumbIcon
            android.graphics.drawable.Drawable r1 = r0.getDrawable(r1)
            r8.thumbIconDrawable = r1
            int r1 = com.google.android.material.R.styleable.MaterialSwitch_thumbIconSize
            int r1 = r0.getDimensionPixelSize(r1, r6)
            r8.thumbIconSize = r1
            int r1 = com.google.android.material.R.styleable.MaterialSwitch_thumbIconTint
            android.content.res.ColorStateList r1 = r0.getColorStateList(r1)
            r8.thumbIconTintList = r1
            int r1 = com.google.android.material.R.styleable.MaterialSwitch_thumbIconTintMode
            int r1 = r0.getInt(r1, r6)
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r1 = com.google.android.material.internal.ViewUtils.parseTintMode(r1, r2)
            r8.thumbIconTintMode = r1
            int r1 = com.google.android.material.R.styleable.MaterialSwitch_trackDecoration
            android.graphics.drawable.Drawable r1 = r0.getDrawable(r1)
            r8.trackDecorationDrawable = r1
            int r1 = com.google.android.material.R.styleable.MaterialSwitch_trackDecorationTint
            android.content.res.ColorStateList r1 = r0.getColorStateList(r1)
            r8.trackDecorationTintList = r1
            int r1 = com.google.android.material.R.styleable.MaterialSwitch_trackDecorationTintMode
            int r1 = r0.getInt(r1, r6)
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r1 = com.google.android.material.internal.ViewUtils.parseTintMode(r1, r2)
            r8.trackDecorationTintMode = r1
            r0.recycle()
            r8.setEnforceSwitchWidth(r7)
            r8.refreshThumbDrawable()
            r8.refreshTrackDrawable()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.materialswitch.MaterialSwitch.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.view.View
    public void invalidate() {
        updateDrawableTints();
        super.invalidate();
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int extraSpace) {
        int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (this.thumbIconDrawable != null) {
            mergeDrawableStates(drawableState, STATE_SET_WITH_ICON);
        }
        this.currentStateUnchecked = DrawableUtils.getUncheckedState(drawableState);
        this.currentStateChecked = DrawableUtils.getCheckedState(drawableState);
        return drawableState;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbDrawable(Drawable drawable) {
        this.thumbDrawable = drawable;
        refreshThumbDrawable();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public Drawable getThumbDrawable() {
        return this.thumbDrawable;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintList(ColorStateList tintList) {
        this.thumbTintList = tintList;
        refreshThumbDrawable();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public ColorStateList getThumbTintList() {
        return this.thumbTintList;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintMode(PorterDuff.Mode tintMode) {
        super.setThumbTintMode(tintMode);
        refreshThumbDrawable();
    }

    public void setThumbIconResource(int resId) {
        setThumbIconDrawable(AppCompatResources.getDrawable(getContext(), resId));
    }

    public void setThumbIconDrawable(Drawable icon) {
        this.thumbIconDrawable = icon;
        refreshThumbDrawable();
    }

    public Drawable getThumbIconDrawable() {
        return this.thumbIconDrawable;
    }

    public void setThumbIconSize(int size) {
        if (this.thumbIconSize != size) {
            this.thumbIconSize = size;
            refreshThumbDrawable();
        }
    }

    public int getThumbIconSize() {
        return this.thumbIconSize;
    }

    public void setThumbIconTintList(ColorStateList tintList) {
        this.thumbIconTintList = tintList;
        refreshThumbDrawable();
    }

    public ColorStateList getThumbIconTintList() {
        return this.thumbIconTintList;
    }

    public void setThumbIconTintMode(PorterDuff.Mode tintMode) {
        this.thumbIconTintMode = tintMode;
        refreshThumbDrawable();
    }

    public PorterDuff.Mode getThumbIconTintMode() {
        return this.thumbIconTintMode;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackDrawable(Drawable track) {
        this.trackDrawable = track;
        refreshTrackDrawable();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public Drawable getTrackDrawable() {
        return this.trackDrawable;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintList(ColorStateList tintList) {
        this.trackTintList = tintList;
        refreshTrackDrawable();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public ColorStateList getTrackTintList() {
        return this.trackTintList;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintMode(PorterDuff.Mode tintMode) {
        super.setTrackTintMode(tintMode);
        refreshTrackDrawable();
    }

    public void setTrackDecorationResource(int resId) {
        setTrackDecorationDrawable(AppCompatResources.getDrawable(getContext(), resId));
    }

    public void setTrackDecorationDrawable(Drawable trackDecoration) {
        this.trackDecorationDrawable = trackDecoration;
        refreshTrackDrawable();
    }

    public Drawable getTrackDecorationDrawable() {
        return this.trackDecorationDrawable;
    }

    public void setTrackDecorationTintList(ColorStateList tintList) {
        this.trackDecorationTintList = tintList;
        refreshTrackDrawable();
    }

    public ColorStateList getTrackDecorationTintList() {
        return this.trackDecorationTintList;
    }

    public void setTrackDecorationTintMode(PorterDuff.Mode tintMode) {
        this.trackDecorationTintMode = tintMode;
        refreshTrackDrawable();
    }

    public PorterDuff.Mode getTrackDecorationTintMode() {
        return this.trackDecorationTintMode;
    }

    private void refreshThumbDrawable() {
        this.thumbDrawable = DrawableUtils.createTintableDrawableIfNeeded(this.thumbDrawable, this.thumbTintList, getThumbTintMode());
        this.thumbIconDrawable = DrawableUtils.createTintableDrawableIfNeeded(this.thumbIconDrawable, this.thumbIconTintList, this.thumbIconTintMode);
        updateDrawableTints();
        Drawable drawable = this.thumbDrawable;
        Drawable drawable2 = this.thumbIconDrawable;
        int i = this.thumbIconSize;
        super.setThumbDrawable(DrawableUtils.compositeTwoLayeredDrawable(drawable, drawable2, i, i));
        refreshDrawableState();
    }

    private void refreshTrackDrawable() {
        Drawable finalTrackDrawable;
        this.trackDrawable = DrawableUtils.createTintableDrawableIfNeeded(this.trackDrawable, this.trackTintList, getTrackTintMode());
        this.trackDecorationDrawable = DrawableUtils.createTintableDrawableIfNeeded(this.trackDecorationDrawable, this.trackDecorationTintList, this.trackDecorationTintMode);
        updateDrawableTints();
        Drawable finalTrackDrawable2 = this.trackDrawable;
        if (finalTrackDrawable2 != null && this.trackDecorationDrawable != null) {
            finalTrackDrawable = new LayerDrawable(new Drawable[]{this.trackDrawable, this.trackDecorationDrawable});
        } else if (finalTrackDrawable2 != null) {
            finalTrackDrawable = this.trackDrawable;
        } else {
            finalTrackDrawable = this.trackDecorationDrawable;
        }
        if (finalTrackDrawable != null) {
            setSwitchMinWidth(finalTrackDrawable.getIntrinsicWidth());
        }
        super.setTrackDrawable(finalTrackDrawable);
    }

    private void updateDrawableTints() {
        if (this.thumbTintList == null && this.thumbIconTintList == null && this.trackTintList == null && this.trackDecorationTintList == null) {
            return;
        }
        float thumbPosition = getThumbPosition();
        ColorStateList colorStateList = this.thumbTintList;
        if (colorStateList != null) {
            setInterpolatedDrawableTintIfPossible(this.thumbDrawable, colorStateList, this.currentStateUnchecked, this.currentStateChecked, thumbPosition);
        }
        ColorStateList colorStateList2 = this.thumbIconTintList;
        if (colorStateList2 != null) {
            setInterpolatedDrawableTintIfPossible(this.thumbIconDrawable, colorStateList2, this.currentStateUnchecked, this.currentStateChecked, thumbPosition);
        }
        ColorStateList colorStateList3 = this.trackTintList;
        if (colorStateList3 != null) {
            setInterpolatedDrawableTintIfPossible(this.trackDrawable, colorStateList3, this.currentStateUnchecked, this.currentStateChecked, thumbPosition);
        }
        ColorStateList colorStateList4 = this.trackDecorationTintList;
        if (colorStateList4 != null) {
            setInterpolatedDrawableTintIfPossible(this.trackDecorationDrawable, colorStateList4, this.currentStateUnchecked, this.currentStateChecked, thumbPosition);
        }
    }

    private static void setInterpolatedDrawableTintIfPossible(Drawable drawable, ColorStateList tint, int[] stateUnchecked, int[] stateChecked, float thumbPosition) {
        if (drawable == null || tint == null) {
            return;
        }
        DrawableCompat.setTint(drawable, ColorUtils.blendARGB(tint.getColorForState(stateUnchecked, 0), tint.getColorForState(stateChecked, 0), thumbPosition));
    }
}
