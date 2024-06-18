package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* loaded from: /home/vinnie/CTF/Reverse Engineering/PicoCTF/timer/timer.d/classes.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context context) {
        this(context, null);
    }

    public MaterialTextView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.textViewStyle);
    }

    public MaterialTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public MaterialTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(MaterialThemeOverlay.wrap(context, attrs, defStyleAttr, defStyleRes), attrs, defStyleAttr);
        int resId;
        Context context2 = getContext();
        if (canApplyTextAppearanceLineHeight(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (!viewAttrsHasLineHeight(context2, theme, attrs, defStyleAttr, defStyleRes) && (resId = findViewAppearanceResourceId(theme, attrs, defStyleAttr, defStyleRes)) != -1) {
                applyLineHeightFromViewAppearance(theme, resId);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(Context context, int resId) {
        super.setTextAppearance(context, resId);
        if (canApplyTextAppearanceLineHeight(context)) {
            applyLineHeightFromViewAppearance(context.getTheme(), resId);
        }
    }

    private void applyLineHeightFromViewAppearance(Resources.Theme theme, int resId) {
        TypedArray attributes = theme.obtainStyledAttributes(resId, com.google.android.material.R.styleable.MaterialTextAppearance);
        int lineHeight = readFirstAvailableDimension(getContext(), attributes, com.google.android.material.R.styleable.MaterialTextAppearance_android_lineHeight, com.google.android.material.R.styleable.MaterialTextAppearance_lineHeight);
        attributes.recycle();
        if (lineHeight >= 0) {
            setLineHeight(lineHeight);
        }
    }

    private static boolean canApplyTextAppearanceLineHeight(Context context) {
        return MaterialAttributes.resolveBoolean(context, com.google.android.material.R.attr.textAppearanceLineHeightEnabled, true);
    }

    private static int readFirstAvailableDimension(Context context, TypedArray attributes, int... indices) {
        int lineHeight = -1;
        for (int index = 0; index < indices.length && lineHeight < 0; index++) {
            lineHeight = MaterialResources.getDimensionPixelSize(context, attributes, indices[index], -1);
        }
        return lineHeight;
    }

    private static boolean viewAttrsHasLineHeight(Context context, Resources.Theme theme, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray attributes = theme.obtainStyledAttributes(attrs, com.google.android.material.R.styleable.MaterialTextView, defStyleAttr, defStyleRes);
        int lineHeight = readFirstAvailableDimension(context, attributes, com.google.android.material.R.styleable.MaterialTextView_android_lineHeight, com.google.android.material.R.styleable.MaterialTextView_lineHeight);
        attributes.recycle();
        return lineHeight != -1;
    }

    private static int findViewAppearanceResourceId(Resources.Theme theme, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray attributes = theme.obtainStyledAttributes(attrs, com.google.android.material.R.styleable.MaterialTextView, defStyleAttr, defStyleRes);
        int appearanceAttrId = attributes.getResourceId(com.google.android.material.R.styleable.MaterialTextView_android_textAppearance, -1);
        attributes.recycle();
        return appearanceAttrId;
    }
}
