package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ViewUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public class MaterialCheckBox extends AppCompatCheckBox {
    public static final int STATE_CHECKED = 1;
    public static final int STATE_INDETERMINATE = 2;
    public static final int STATE_UNCHECKED = 0;
    private boolean broadcasting;
    private Drawable buttonDrawable;
    private Drawable buttonIconDrawable;
    ColorStateList buttonIconTintList;
    private PorterDuff.Mode buttonIconTintMode;
    ColorStateList buttonTintList;
    private boolean centerIfNoTextEnabled;
    private int checkedState;
    private int[] currentStateChecked;
    private CharSequence customStateDescription;
    private CharSequence errorAccessibilityLabel;
    private boolean errorShown;
    private ColorStateList materialThemeColorsTintList;
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
    private final LinkedHashSet<OnCheckedStateChangedListener> onCheckedStateChangedListeners;
    private final LinkedHashSet<OnErrorChangedListener> onErrorChangedListeners;
    private final AnimatedVectorDrawableCompat transitionToUnchecked;
    private final Animatable2Compat.AnimationCallback transitionToUncheckedCallback;
    private boolean useMaterialThemeColors;
    private boolean usingMaterialButtonDrawable;
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_CompoundButton_CheckBox;
    private static final int[] INDETERMINATE_STATE_SET = {R.attr.state_indeterminate};
    private static final int[] ERROR_STATE_SET = {R.attr.state_error};
    private static final int[][] CHECKBOX_STATES = {new int[]{android.R.attr.state_enabled, R.attr.state_error}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
    private static final int FRAMEWORK_BUTTON_DRAWABLE_RES_ID = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");

    @Retention(RetentionPolicy.SOURCE)
    public @interface CheckedState {
    }

    public interface OnCheckedStateChangedListener {
        void onCheckedStateChangedListener(MaterialCheckBox materialCheckBox, int i);
    }

    public interface OnErrorChangedListener {
        void onErrorChanged(MaterialCheckBox materialCheckBox, boolean z);
    }

    public MaterialCheckBox(Context context) {
        this(context, null);
    }

    public MaterialCheckBox(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.checkboxStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialCheckBox(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r4 = com.google.android.material.checkbox.MaterialCheckBox.DEF_STYLE_RES
            android.content.Context r0 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r9, r10, r11, r4)
            r8.<init>(r0, r10, r11)
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            r8.onErrorChangedListeners = r0
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            r8.onCheckedStateChangedListeners = r0
            android.content.Context r0 = r8.getContext()
            int r1 = com.google.android.material.R.drawable.mtrl_checkbox_button_checked_unchecked
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat r0 = androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.create(r0, r1)
            r8.transitionToUnchecked = r0
            com.google.android.material.checkbox.MaterialCheckBox$1 r0 = new com.google.android.material.checkbox.MaterialCheckBox$1
            r0.<init>()
            r8.transitionToUncheckedCallback = r0
            android.content.Context r9 = r8.getContext()
            android.graphics.drawable.Drawable r0 = androidx.core.widget.CompoundButtonCompat.getButtonDrawable(r8)
            r8.buttonDrawable = r0
            android.content.res.ColorStateList r0 = r8.getSuperButtonTintList()
            r8.buttonTintList = r0
            r6 = 0
            r8.setSupportButtonTintList(r6)
            int[] r2 = com.google.android.material.R.styleable.MaterialCheckBox
            r7 = 0
            int[] r5 = new int[r7]
            r0 = r9
            r1 = r10
            r3 = r11
            androidx.appcompat.widget.TintTypedArray r0 = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R.styleable.MaterialCheckBox_buttonIcon
            android.graphics.drawable.Drawable r1 = r0.getDrawable(r1)
            r8.buttonIconDrawable = r1
            android.graphics.drawable.Drawable r1 = r8.buttonDrawable
            r2 = 1
            if (r1 == 0) goto L7d
            boolean r1 = com.google.android.material.internal.ThemeEnforcement.isMaterial3Theme(r9)
            if (r1 == 0) goto L7d
            boolean r1 = r8.isButtonDrawableLegacy(r0)
            if (r1 == 0) goto L7d
            super.setButtonDrawable(r6)
            int r1 = com.google.android.material.R.drawable.mtrl_checkbox_button
            android.graphics.drawable.Drawable r1 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r9, r1)
            r8.buttonDrawable = r1
            r8.usingMaterialButtonDrawable = r2
            android.graphics.drawable.Drawable r1 = r8.buttonIconDrawable
            if (r1 != 0) goto L7d
            int r1 = com.google.android.material.R.drawable.mtrl_checkbox_button_icon
            android.graphics.drawable.Drawable r1 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r9, r1)
            r8.buttonIconDrawable = r1
        L7d:
            int r1 = com.google.android.material.R.styleable.MaterialCheckBox_buttonIconTint
            android.content.res.ColorStateList r1 = com.google.android.material.resources.MaterialResources.getColorStateList(r9, r0, r1)
            r8.buttonIconTintList = r1
            int r1 = com.google.android.material.R.styleable.MaterialCheckBox_buttonIconTintMode
            r3 = -1
            int r1 = r0.getInt(r1, r3)
            android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r1 = com.google.android.material.internal.ViewUtils.parseTintMode(r1, r3)
            r8.buttonIconTintMode = r1
            int r1 = com.google.android.material.R.styleable.MaterialCheckBox_useMaterialThemeColors
            boolean r1 = r0.getBoolean(r1, r7)
            r8.useMaterialThemeColors = r1
            int r1 = com.google.android.material.R.styleable.MaterialCheckBox_centerIfNoTextEnabled
            boolean r1 = r0.getBoolean(r1, r2)
            r8.centerIfNoTextEnabled = r1
            int r1 = com.google.android.material.R.styleable.MaterialCheckBox_errorShown
            boolean r1 = r0.getBoolean(r1, r7)
            r8.errorShown = r1
            int r1 = com.google.android.material.R.styleable.MaterialCheckBox_errorAccessibilityLabel
            java.lang.CharSequence r1 = r0.getText(r1)
            r8.errorAccessibilityLabel = r1
            int r1 = com.google.android.material.R.styleable.MaterialCheckBox_checkedState
            boolean r1 = r0.hasValue(r1)
            if (r1 == 0) goto Lc5
            int r1 = com.google.android.material.R.styleable.MaterialCheckBox_checkedState
            int r1 = r0.getInt(r1, r7)
            r8.setCheckedState(r1)
        Lc5:
            r0.recycle()
            r8.refreshButtonDrawable()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.checkbox.MaterialCheckBox.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* renamed from: lambda$new$0$com-google-android-material-checkbox-MaterialCheckBox, reason: not valid java name */
    /* synthetic */ void m72xdf87d0bf() {
        this.buttonIconDrawable.jumpToCurrentState();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        if (this.centerIfNoTextEnabled && TextUtils.isEmpty(getText()) && (drawable = CompoundButtonCompat.getButtonDrawable(this)) != null) {
            int direction = ViewUtils.isLayoutRtl(this) ? -1 : 1;
            int dx = ((getWidth() - drawable.getIntrinsicWidth()) / 2) * direction;
            int saveCount = canvas.save();
            canvas.translate(dx, 0.0f);
            super.onDraw(canvas);
            canvas.restoreToCount(saveCount);
            if (getBackground() != null) {
                Rect bounds = drawable.getBounds();
                DrawableCompat.setHotspotBounds(getBackground(), bounds.left + dx, bounds.top, bounds.right + dx, bounds.bottom);
                return;
            }
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors && this.buttonTintList == null && this.buttonIconTintList == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int extraSpace) {
        int[] drawableStates = super.onCreateDrawableState(extraSpace + 2);
        if (getCheckedState() == 2) {
            mergeDrawableStates(drawableStates, INDETERMINATE_STATE_SET);
        }
        if (isErrorShown()) {
            mergeDrawableStates(drawableStates, ERROR_STATE_SET);
        }
        this.currentStateChecked = DrawableUtils.getCheckedState(drawableStates);
        updateIconTintIfNeeded();
        return drawableStates;
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        updateIconTintIfNeeded();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        setCheckedState(z ? 1 : 0);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.checkedState == 1;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener listener) {
        this.onCheckedChangeListener = listener;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        if (info != null && isErrorShown()) {
            info.setText(((Object) info.getText()) + ", " + ((Object) this.errorAccessibilityLabel));
        }
    }

    public void setCheckedState(int checkedState) {
        AutofillManager autofillManager;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.checkedState != checkedState) {
            this.checkedState = checkedState;
            super.setChecked(checkedState == 1);
            refreshDrawableState();
            setDefaultStateDescription();
            if (this.broadcasting) {
                return;
            }
            this.broadcasting = true;
            LinkedHashSet<OnCheckedStateChangedListener> linkedHashSet = this.onCheckedStateChangedListeners;
            if (linkedHashSet != null) {
                Iterator<OnCheckedStateChangedListener> it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    OnCheckedStateChangedListener listener = it.next();
                    listener.onCheckedStateChangedListener(this, this.checkedState);
                }
            }
            if (this.checkedState != 2 && (onCheckedChangeListener = this.onCheckedChangeListener) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            if (Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class)) != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.broadcasting = false;
        }
    }

    public int getCheckedState() {
        return this.checkedState;
    }

    public void addOnCheckedStateChangedListener(OnCheckedStateChangedListener listener) {
        this.onCheckedStateChangedListeners.add(listener);
    }

    public void removeOnCheckedStateChangedListener(OnCheckedStateChangedListener listener) {
        this.onCheckedStateChangedListeners.remove(listener);
    }

    public void clearOnCheckedStateChangedListeners() {
        this.onCheckedStateChangedListeners.clear();
    }

    public void setErrorShown(boolean errorShown) {
        if (this.errorShown == errorShown) {
            return;
        }
        this.errorShown = errorShown;
        refreshDrawableState();
        Iterator<OnErrorChangedListener> it = this.onErrorChangedListeners.iterator();
        while (it.hasNext()) {
            OnErrorChangedListener listener = it.next();
            listener.onErrorChanged(this, this.errorShown);
        }
    }

    public boolean isErrorShown() {
        return this.errorShown;
    }

    public void setErrorAccessibilityLabelResource(int resId) {
        setErrorAccessibilityLabel(resId != 0 ? getResources().getText(resId) : null);
    }

    public void setErrorAccessibilityLabel(CharSequence errorAccessibilityLabel) {
        this.errorAccessibilityLabel = errorAccessibilityLabel;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.errorAccessibilityLabel;
    }

    public void addOnErrorChangedListener(OnErrorChangedListener listener) {
        this.onErrorChangedListeners.add(listener);
    }

    public void removeOnErrorChangedListener(OnErrorChangedListener listener) {
        this.onErrorChangedListeners.remove(listener);
    }

    public void clearOnErrorChangedListeners() {
        this.onErrorChangedListeners.clear();
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(int resId) {
        setButtonDrawable(AppCompatResources.getDrawable(getContext(), resId));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.buttonDrawable = drawable;
        this.usingMaterialButtonDrawable = false;
        refreshButtonDrawable();
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.buttonDrawable;
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList tintList) {
        if (this.buttonTintList == tintList) {
            return;
        }
        this.buttonTintList = tintList;
        refreshButtonDrawable();
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.buttonTintList;
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode tintMode) {
        setSupportButtonTintMode(tintMode);
        refreshButtonDrawable();
    }

    public void setButtonIconDrawableResource(int resId) {
        setButtonIconDrawable(AppCompatResources.getDrawable(getContext(), resId));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.buttonIconDrawable = drawable;
        refreshButtonDrawable();
    }

    public Drawable getButtonIconDrawable() {
        return this.buttonIconDrawable;
    }

    public void setButtonIconTintList(ColorStateList tintList) {
        if (this.buttonIconTintList == tintList) {
            return;
        }
        this.buttonIconTintList = tintList;
        refreshButtonDrawable();
    }

    public ColorStateList getButtonIconTintList() {
        return this.buttonIconTintList;
    }

    public void setButtonIconTintMode(PorterDuff.Mode tintMode) {
        if (this.buttonIconTintMode == tintMode) {
            return;
        }
        this.buttonIconTintMode = tintMode;
        refreshButtonDrawable();
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.buttonIconTintMode;
    }

    public void setUseMaterialThemeColors(boolean useMaterialThemeColors) {
        this.useMaterialThemeColors = useMaterialThemeColors;
        if (useMaterialThemeColors) {
            CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.setButtonTintList(this, null);
        }
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    public void setCenterIfNoTextEnabled(boolean centerIfNoTextEnabled) {
        this.centerIfNoTextEnabled = centerIfNoTextEnabled;
    }

    public boolean isCenterIfNoTextEnabled() {
        return this.centerIfNoTextEnabled;
    }

    private void refreshButtonDrawable() {
        this.buttonDrawable = DrawableUtils.createTintableMutatedDrawableIfNeeded(this.buttonDrawable, this.buttonTintList, CompoundButtonCompat.getButtonTintMode(this));
        this.buttonIconDrawable = DrawableUtils.createTintableMutatedDrawableIfNeeded(this.buttonIconDrawable, this.buttonIconTintList, this.buttonIconTintMode);
        setUpDefaultButtonDrawableAnimationIfNeeded();
        updateButtonTints();
        super.setButtonDrawable(DrawableUtils.compositeTwoLayeredDrawable(this.buttonDrawable, this.buttonIconDrawable));
        refreshDrawableState();
    }

    private void setUpDefaultButtonDrawableAnimationIfNeeded() {
        if (!this.usingMaterialButtonDrawable) {
            return;
        }
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.transitionToUnchecked;
        if (animatedVectorDrawableCompat != null) {
            animatedVectorDrawableCompat.unregisterAnimationCallback(this.transitionToUncheckedCallback);
            this.transitionToUnchecked.registerAnimationCallback(this.transitionToUncheckedCallback);
        }
        Drawable drawable = this.buttonDrawable;
        if ((drawable instanceof AnimatedStateListDrawable) && this.transitionToUnchecked != null) {
            ((AnimatedStateListDrawable) drawable).addTransition(R.id.checked, R.id.unchecked, this.transitionToUnchecked, false);
            ((AnimatedStateListDrawable) this.buttonDrawable).addTransition(R.id.indeterminate, R.id.unchecked, this.transitionToUnchecked, false);
        }
    }

    private void updateButtonTints() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable = this.buttonDrawable;
        if (drawable != null && (colorStateList2 = this.buttonTintList) != null) {
            DrawableCompat.setTintList(drawable, colorStateList2);
        }
        Drawable drawable2 = this.buttonIconDrawable;
        if (drawable2 != null && (colorStateList = this.buttonIconTintList) != null) {
            DrawableCompat.setTintList(drawable2, colorStateList);
        }
    }

    private void updateIconTintIfNeeded() {
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence stateDescription) {
        this.customStateDescription = stateDescription;
        if (stateDescription == null) {
            setDefaultStateDescription();
        } else {
            super.setStateDescription(stateDescription);
        }
    }

    private void setDefaultStateDescription() {
        if (Build.VERSION.SDK_INT >= 30 && this.customStateDescription == null) {
            super.setStateDescription(getButtonStateDescription());
        }
    }

    private String getButtonStateDescription() {
        int i = this.checkedState;
        if (i == 1) {
            return getResources().getString(R.string.mtrl_checkbox_state_description_checked);
        }
        if (i == 0) {
            return getResources().getString(R.string.mtrl_checkbox_state_description_unchecked);
        }
        return getResources().getString(R.string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.buttonTintList;
        if (colorStateList != null) {
            return colorStateList;
        }
        if (super.getButtonTintList() != null) {
            return super.getButtonTintList();
        }
        return getSupportButtonTintList();
    }

    private boolean isButtonDrawableLegacy(TintTypedArray attributes) {
        int buttonResourceId = attributes.getResourceId(R.styleable.MaterialCheckBox_android_button, 0);
        int buttonCompatResourceId = attributes.getResourceId(R.styleable.MaterialCheckBox_buttonCompat, 0);
        return buttonResourceId == FRAMEWORK_BUTTON_DRAWABLE_RES_ID && buttonCompatResourceId == 0;
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.materialThemeColorsTintList == null) {
            int[][] iArr = CHECKBOX_STATES;
            int[] checkBoxColorsList = new int[iArr.length];
            int colorControlActivated = MaterialColors.getColor(this, R.attr.colorControlActivated);
            int colorError = MaterialColors.getColor(this, R.attr.colorError);
            int colorSurface = MaterialColors.getColor(this, R.attr.colorSurface);
            int colorOnSurface = MaterialColors.getColor(this, R.attr.colorOnSurface);
            checkBoxColorsList[0] = MaterialColors.layer(colorSurface, colorError, 1.0f);
            checkBoxColorsList[1] = MaterialColors.layer(colorSurface, colorControlActivated, 1.0f);
            checkBoxColorsList[2] = MaterialColors.layer(colorSurface, colorOnSurface, 0.54f);
            checkBoxColorsList[3] = MaterialColors.layer(colorSurface, colorOnSurface, 0.38f);
            checkBoxColorsList[4] = MaterialColors.layer(colorSurface, colorOnSurface, 0.38f);
            this.materialThemeColorsTintList = new ColorStateList(iArr, checkBoxColorsList);
        }
        return this.materialThemeColorsTintList;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.checkedState = getCheckedState();
        return ss;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setCheckedState(ss.checkedState);
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.material.checkbox.MaterialCheckBox.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        int checkedState;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.checkedState = ((Integer) in.readValue(getClass().getClassLoader())).intValue();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeValue(Integer.valueOf(this.checkedState));
        }

        public String toString() {
            return "MaterialCheckBox.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " CheckedState=" + getCheckedStateString() + "}";
        }

        private String getCheckedStateString() {
            switch (this.checkedState) {
                case 1:
                    return "checked";
                case 2:
                    return "indeterminate";
                default:
                    return "unchecked";
            }
        }
    }
}
