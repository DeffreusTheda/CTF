package com.google.android.material.search;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;

/* loaded from: classes.dex */
public class SearchBar extends Toolbar {
    private static final int DEFAULT_SCROLL_FLAGS = 53;
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_SearchBar;
    private static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    private final AccessibilityManager accessibilityManager;
    private MaterialShapeDrawable backgroundShape;
    private View centerView;
    private final boolean defaultMarginsEnabled;
    private final Drawable defaultNavigationIcon;
    private boolean defaultScrollFlagsEnabled;
    private final boolean forceDefaultNavigationOnClickListener;
    private final boolean layoutInflated;
    private int menuResId;
    private Integer navigationIconTint;
    private Drawable originalNavigationIconBackground;
    private final SearchBarAnimationHelper searchBarAnimationHelper;
    private final TextView textView;
    private final boolean tintNavigationIcon;
    private final AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    /* renamed from: lambda$new$0$com-google-android-material-search-SearchBar, reason: not valid java name */
    /* synthetic */ void m121lambda$new$0$comgoogleandroidmaterialsearchSearchBar(boolean enabled) {
        setFocusableInTouchMode(enabled);
    }

    public SearchBar(Context context) {
        this(context, null);
    }

    public SearchBar(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.materialSearchBarStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SearchBar(android.content.Context r21, android.util.AttributeSet r22, int r23) {
        /*
            r20 = this;
            r6 = r20
            r7 = r22
            r8 = r23
            int r9 = com.google.android.material.search.SearchBar.DEF_STYLE_RES
            r0 = r21
            android.content.Context r1 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r0, r7, r8, r9)
            r6.<init>(r1, r7, r8)
            r10 = -1
            r6.menuResId = r10
            com.google.android.material.search.SearchBar$$ExternalSyntheticLambda0 r1 = new com.google.android.material.search.SearchBar$$ExternalSyntheticLambda0
            r1.<init>()
            r6.touchExplorationStateChangeListener = r1
            android.content.Context r11 = r20.getContext()
            r6.validateAttributes(r7)
            int r0 = r20.getDefaultNavigationIconResource()
            android.graphics.drawable.Drawable r0 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r11, r0)
            r6.defaultNavigationIcon = r0
            com.google.android.material.search.SearchBarAnimationHelper r0 = new com.google.android.material.search.SearchBarAnimationHelper
            r0.<init>()
            r6.searchBarAnimationHelper = r0
            int[] r2 = com.google.android.material.R.styleable.SearchBar
            r12 = 0
            int[] r5 = new int[r12]
            r0 = r11
            r1 = r22
            r3 = r23
            r4 = r9
            android.content.res.TypedArray r13 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            com.google.android.material.shape.ShapeAppearanceModel$Builder r0 = com.google.android.material.shape.ShapeAppearanceModel.builder(r11, r7, r8, r9)
            com.google.android.material.shape.ShapeAppearanceModel r9 = r0.build()
            int r0 = com.google.android.material.R.styleable.SearchBar_backgroundTint
            int r14 = r13.getColor(r0, r12)
            int r0 = com.google.android.material.R.styleable.SearchBar_elevation
            r1 = 0
            float r15 = r13.getDimension(r0, r1)
            int r0 = com.google.android.material.R.styleable.SearchBar_defaultMarginsEnabled
            r1 = 1
            boolean r0 = r13.getBoolean(r0, r1)
            r6.defaultMarginsEnabled = r0
            int r0 = com.google.android.material.R.styleable.SearchBar_defaultScrollFlagsEnabled
            boolean r0 = r13.getBoolean(r0, r1)
            r6.defaultScrollFlagsEnabled = r0
            int r0 = com.google.android.material.R.styleable.SearchBar_hideNavigationIcon
            boolean r16 = r13.getBoolean(r0, r12)
            int r0 = com.google.android.material.R.styleable.SearchBar_forceDefaultNavigationOnClickListener
            boolean r0 = r13.getBoolean(r0, r12)
            r6.forceDefaultNavigationOnClickListener = r0
            int r0 = com.google.android.material.R.styleable.SearchBar_tintNavigationIcon
            boolean r0 = r13.getBoolean(r0, r1)
            r6.tintNavigationIcon = r0
            int r0 = com.google.android.material.R.styleable.SearchBar_navigationIconTint
            boolean r0 = r13.hasValue(r0)
            if (r0 == 0) goto L94
            int r0 = com.google.android.material.R.styleable.SearchBar_navigationIconTint
            int r0 = r13.getColor(r0, r10)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6.navigationIconTint = r0
        L94:
            int r0 = com.google.android.material.R.styleable.SearchBar_android_textAppearance
            int r10 = r13.getResourceId(r0, r10)
            int r0 = com.google.android.material.R.styleable.SearchBar_android_text
            java.lang.String r5 = r13.getString(r0)
            int r0 = com.google.android.material.R.styleable.SearchBar_android_hint
            java.lang.String r4 = r13.getString(r0)
            int r0 = com.google.android.material.R.styleable.SearchBar_strokeWidth
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r17 = r13.getDimension(r0, r2)
            int r0 = com.google.android.material.R.styleable.SearchBar_strokeColor
            int r12 = r13.getColor(r0, r12)
            r13.recycle()
            if (r16 != 0) goto Lbc
            r20.initNavigationIcon()
        Lbc:
            r6.setClickable(r1)
            r6.setFocusable(r1)
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r11)
            int r2 = com.google.android.material.R.layout.mtrl_search_bar
            r0.inflate(r2, r6)
            r6.layoutInflated = r1
            int r0 = com.google.android.material.R.id.open_search_bar_text_view
            android.view.View r0 = r6.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r6.textView = r0
            androidx.core.view.ViewCompat.setElevation(r6, r15)
            r6.initTextView(r10, r5, r4)
            r0 = r20
            r1 = r9
            r2 = r14
            r3 = r15
            r18 = r4
            r4 = r17
            r19 = r5
            r5 = r12
            r0.initBackground(r1, r2, r3, r4, r5)
            android.content.Context r0 = r20.getContext()
            java.lang.String r1 = "accessibility"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.accessibility.AccessibilityManager r0 = (android.view.accessibility.AccessibilityManager) r0
            r6.accessibilityManager = r0
            r20.setupTouchExplorationStateChangeListener()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.search.SearchBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void setupTouchExplorationStateChangeListener() {
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager != null) {
            if (accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled()) {
                setFocusableInTouchMode(true);
            }
            addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.google.android.material.search.SearchBar.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View ignored) {
                    AccessibilityManagerCompat.addTouchExplorationStateChangeListener(SearchBar.this.accessibilityManager, SearchBar.this.touchExplorationStateChangeListener);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View ignored) {
                    AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(SearchBar.this.accessibilityManager, SearchBar.this.touchExplorationStateChangeListener);
                }
            });
        }
    }

    private void validateAttributes(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue(NAMESPACE_APP, "title") != null) {
            throw new UnsupportedOperationException("SearchBar does not support title. Use hint or text instead.");
        }
        if (attributeSet.getAttributeValue(NAMESPACE_APP, "subtitle") != null) {
            throw new UnsupportedOperationException("SearchBar does not support subtitle. Use hint or text instead.");
        }
    }

    private void initNavigationIcon() {
        setNavigationIcon(getNavigationIcon() == null ? this.defaultNavigationIcon : getNavigationIcon());
        setNavigationIconDecorative(true);
    }

    private void initTextView(int textAppearanceResId, String text, String hint) {
        if (textAppearanceResId != -1) {
            TextViewCompat.setTextAppearance(this.textView, textAppearanceResId);
        }
        setText(text);
        setHint(hint);
        if (getNavigationIcon() == null) {
            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.textView.getLayoutParams(), getResources().getDimensionPixelSize(R.dimen.m3_searchbar_text_margin_start_no_navigation_icon));
        }
    }

    private void initBackground(ShapeAppearanceModel shapeAppearance, int backgroundColor, float elevation, float strokeWidth, int strokeColor) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearance);
        this.backgroundShape = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(getContext());
        this.backgroundShape.setElevation(elevation);
        if (strokeWidth >= 0.0f) {
            this.backgroundShape.setStroke(strokeWidth, strokeColor);
        }
        int rippleColor = MaterialColors.getColor(this, R.attr.colorControlHighlight);
        this.backgroundShape.setFillColor(ColorStateList.valueOf(backgroundColor));
        ColorStateList valueOf = ColorStateList.valueOf(rippleColor);
        MaterialShapeDrawable materialShapeDrawable2 = this.backgroundShape;
        Drawable background = new RippleDrawable(valueOf, materialShapeDrawable2, materialShapeDrawable2);
        ViewCompat.setBackground(this, background);
    }

    private ColorStateList getCompatBackgroundColorStateList(int backgroundColor, int rippleColor) {
        int[][] states = {new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_focused}, new int[0]};
        int pressedBackgroundColor = MaterialColors.layer(backgroundColor, rippleColor);
        int[] colors = {pressedBackgroundColor, pressedBackgroundColor, backgroundColor};
        return new ColorStateList(states, colors);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (this.layoutInflated && this.centerView == null && !(child instanceof ActionMenuView)) {
            this.centerView = child;
            child.setAlpha(0.0f);
        }
        super.addView(child, index, params);
    }

    @Override // android.view.View
    public void setElevation(float elevation) {
        super.setElevation(elevation);
        MaterialShapeDrawable materialShapeDrawable = this.backgroundShape;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation(elevation);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(EditText.class.getCanonicalName());
        info.setEditable(isEnabled());
        CharSequence text = getText();
        boolean isTextEmpty = TextUtils.isEmpty(text);
        if (Build.VERSION.SDK_INT >= 26) {
            info.setHintText(getHint());
            info.setShowingHintText(isTextEmpty);
        }
        if (isTextEmpty) {
            text = getHint();
        }
        info.setText(text);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener listener) {
        if (this.forceDefaultNavigationOnClickListener) {
            return;
        }
        super.setNavigationOnClickListener(listener);
        setNavigationIconDecorative(listener == null);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable navigationIcon) {
        super.setNavigationIcon(maybeTintNavigationIcon(navigationIcon));
    }

    private Drawable maybeTintNavigationIcon(Drawable navigationIcon) {
        int navigationIconColorAttr;
        int navigationIconColorAttr2;
        if (!this.tintNavigationIcon || navigationIcon == null) {
            return navigationIcon;
        }
        Integer num = this.navigationIconTint;
        if (num != null) {
            navigationIconColorAttr2 = num.intValue();
        } else {
            if (navigationIcon == this.defaultNavigationIcon) {
                navigationIconColorAttr = R.attr.colorOnSurfaceVariant;
            } else {
                navigationIconColorAttr = R.attr.colorOnSurface;
            }
            navigationIconColorAttr2 = MaterialColors.getColor(this, navigationIconColorAttr);
        }
        Drawable wrappedNavigationIcon = DrawableCompat.wrap(navigationIcon.mutate());
        DrawableCompat.setTint(wrappedNavigationIcon, navigationIconColorAttr2);
        return wrappedNavigationIcon;
    }

    private void setNavigationIconDecorative(boolean decorative) {
        ImageButton navigationIconButton = ToolbarUtils.getNavigationIconButton(this);
        if (navigationIconButton == null) {
            return;
        }
        navigationIconButton.setClickable(!decorative);
        navigationIconButton.setFocusable(!decorative);
        Drawable navigationIconBackground = navigationIconButton.getBackground();
        if (navigationIconBackground != null) {
            this.originalNavigationIconBackground = navigationIconBackground;
        }
        navigationIconButton.setBackgroundDrawable(decorative ? null : this.originalNavigationIconBackground);
        setHandwritingBoundsInsets();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void inflateMenu(int resId) {
        Menu menu = getMenu();
        if (menu instanceof MenuBuilder) {
            ((MenuBuilder) menu).stopDispatchingItemsChanged();
        }
        super.inflateMenu(resId);
        this.menuResId = resId;
        if (menu instanceof MenuBuilder) {
            ((MenuBuilder) menu).startDispatchingItemsChanged();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureCenterView(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        layoutCenterView();
        setHandwritingBoundsInsets();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.backgroundShape);
        setDefaultMargins();
        setOrClearDefaultScrollFlags();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence title) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence subtitle) {
    }

    private void setDefaultMargins() {
        if (this.defaultMarginsEnabled && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            Resources resources = getResources();
            int marginHorizontal = resources.getDimensionPixelSize(R.dimen.m3_searchbar_margin_horizontal);
            int marginVertical = resources.getDimensionPixelSize(getDefaultMarginVerticalResource());
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) getLayoutParams();
            lp.leftMargin = defaultIfZero(lp.leftMargin, marginHorizontal);
            lp.topMargin = defaultIfZero(lp.topMargin, marginVertical);
            lp.rightMargin = defaultIfZero(lp.rightMargin, marginHorizontal);
            lp.bottomMargin = defaultIfZero(lp.bottomMargin, marginVertical);
        }
    }

    protected int getDefaultMarginVerticalResource() {
        return R.dimen.m3_searchbar_margin_vertical;
    }

    protected int getDefaultNavigationIconResource() {
        return R.drawable.ic_search_black_24;
    }

    private int defaultIfZero(int value, int defValue) {
        return value == 0 ? defValue : value;
    }

    private void setOrClearDefaultScrollFlags() {
        if (getLayoutParams() instanceof AppBarLayout.LayoutParams) {
            AppBarLayout.LayoutParams lp = (AppBarLayout.LayoutParams) getLayoutParams();
            if (this.defaultScrollFlagsEnabled) {
                if (lp.getScrollFlags() == 0) {
                    lp.setScrollFlags(53);
                }
            } else if (lp.getScrollFlags() == 53) {
                lp.setScrollFlags(0);
            }
        }
    }

    private void measureCenterView(int widthMeasureSpec, int heightMeasureSpec) {
        View view = this.centerView;
        if (view != null) {
            view.measure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    private void layoutCenterView() {
        View view = this.centerView;
        if (view == null) {
            return;
        }
        int centerViewWidth = view.getMeasuredWidth();
        int left = (getMeasuredWidth() / 2) - (centerViewWidth / 2);
        int right = left + centerViewWidth;
        int centerViewHeight = this.centerView.getMeasuredHeight();
        int top = (getMeasuredHeight() / 2) - (centerViewHeight / 2);
        int bottom = top + centerViewHeight;
        layoutChild(this.centerView, left, top, right, bottom);
    }

    private void layoutChild(View child, int left, int top, int right, int bottom) {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            child.layout(getMeasuredWidth() - right, top, getMeasuredWidth() - left, bottom);
        } else {
            child.layout(left, top, right, bottom);
        }
    }

    private void setHandwritingBoundsInsets() {
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        boolean isRtl = getLayoutDirection() == 1;
        int startInset = 0;
        View navigationIconButton = ToolbarUtils.getNavigationIconButton(this);
        if (navigationIconButton != null && navigationIconButton.isClickable()) {
            startInset = isRtl ? getWidth() - navigationIconButton.getLeft() : navigationIconButton.getRight();
        }
        int endInset = 0;
        View actionMenuView = ToolbarUtils.getActionMenuView(this);
        if (actionMenuView != null) {
            endInset = isRtl ? actionMenuView.getRight() : getWidth() - actionMenuView.getLeft();
        }
        setHandwritingBoundsOffsets(-(isRtl ? endInset : startInset), 0.0f, -(isRtl ? startInset : endInset), 0.0f);
    }

    public View getCenterView() {
        return this.centerView;
    }

    public void setCenterView(View view) {
        View view2 = this.centerView;
        if (view2 != null) {
            removeView(view2);
            this.centerView = null;
        }
        if (view != null) {
            addView(view);
        }
    }

    public TextView getTextView() {
        return this.textView;
    }

    public CharSequence getText() {
        return this.textView.getText();
    }

    public void setText(CharSequence text) {
        this.textView.setText(text);
    }

    public void setText(int textResId) {
        this.textView.setText(textResId);
    }

    public void clearText() {
        this.textView.setText("");
    }

    public CharSequence getHint() {
        return this.textView.getHint();
    }

    public void setHint(CharSequence hint) {
        this.textView.setHint(hint);
    }

    public void setHint(int hintResId) {
        this.textView.setHint(hintResId);
    }

    public int getStrokeColor() {
        return this.backgroundShape.getStrokeColor().getDefaultColor();
    }

    public void setStrokeColor(int strokeColor) {
        if (getStrokeColor() != strokeColor) {
            this.backgroundShape.setStrokeColor(ColorStateList.valueOf(strokeColor));
        }
    }

    public float getStrokeWidth() {
        return this.backgroundShape.getStrokeWidth();
    }

    public void setStrokeWidth(float strokeWidth) {
        if (getStrokeWidth() != strokeWidth) {
            this.backgroundShape.setStrokeWidth(strokeWidth);
        }
    }

    public float getCornerSize() {
        return this.backgroundShape.getTopLeftCornerResolvedSize();
    }

    public boolean isDefaultScrollFlagsEnabled() {
        return this.defaultScrollFlagsEnabled;
    }

    public void setDefaultScrollFlagsEnabled(boolean defaultScrollFlagsEnabled) {
        this.defaultScrollFlagsEnabled = defaultScrollFlagsEnabled;
        setOrClearDefaultScrollFlags();
    }

    /* renamed from: lambda$startOnLoadAnimation$1$com-google-android-material-search-SearchBar, reason: not valid java name */
    /* synthetic */ void m122x58362b63() {
        this.searchBarAnimationHelper.startOnLoadAnimation(this);
    }

    public void startOnLoadAnimation() {
        post(new Runnable() { // from class: com.google.android.material.search.SearchBar$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SearchBar.this.m122x58362b63();
            }
        });
    }

    public void stopOnLoadAnimation() {
        this.searchBarAnimationHelper.stopOnLoadAnimation(this);
    }

    public boolean isOnLoadAnimationFadeInEnabled() {
        return this.searchBarAnimationHelper.isOnLoadAnimationFadeInEnabled();
    }

    public void setOnLoadAnimationFadeInEnabled(boolean onLoadAnimationFadeInEnabled) {
        this.searchBarAnimationHelper.setOnLoadAnimationFadeInEnabled(onLoadAnimationFadeInEnabled);
    }

    public void addOnLoadAnimationCallback(OnLoadAnimationCallback onLoadAnimationCallback) {
        this.searchBarAnimationHelper.addOnLoadAnimationCallback(onLoadAnimationCallback);
    }

    public boolean removeOnLoadAnimationCallback(OnLoadAnimationCallback onLoadAnimationCallback) {
        return this.searchBarAnimationHelper.removeOnLoadAnimationCallback(onLoadAnimationCallback);
    }

    public boolean isExpanding() {
        return this.searchBarAnimationHelper.isExpanding();
    }

    public boolean expand(View expandedView) {
        return expand(expandedView, null);
    }

    public boolean expand(View expandedView, AppBarLayout appBarLayout) {
        return expand(expandedView, appBarLayout, false);
    }

    public boolean expand(View expandedView, AppBarLayout appBarLayout, boolean skipAnimation) {
        if ((expandedView.getVisibility() != 0 && !isExpanding()) || isCollapsing()) {
            this.searchBarAnimationHelper.startExpandAnimation(this, expandedView, appBarLayout, skipAnimation);
            return true;
        }
        return false;
    }

    public void addExpandAnimationListener(AnimatorListenerAdapter listener) {
        this.searchBarAnimationHelper.addExpandAnimationListener(listener);
    }

    public boolean removeExpandAnimationListener(AnimatorListenerAdapter listener) {
        return this.searchBarAnimationHelper.removeExpandAnimationListener(listener);
    }

    public boolean isCollapsing() {
        return this.searchBarAnimationHelper.isCollapsing();
    }

    public boolean collapse(View expandedView) {
        return collapse(expandedView, null);
    }

    public boolean collapse(View expandedView, AppBarLayout appBarLayout) {
        return collapse(expandedView, appBarLayout, false);
    }

    public boolean collapse(View expandedView, AppBarLayout appBarLayout, boolean skipAnimation) {
        if ((expandedView.getVisibility() == 0 && !isCollapsing()) || isExpanding()) {
            this.searchBarAnimationHelper.startCollapseAnimation(this, expandedView, appBarLayout, skipAnimation);
            return true;
        }
        return false;
    }

    public void addCollapseAnimationListener(AnimatorListenerAdapter listener) {
        this.searchBarAnimationHelper.addCollapseAnimationListener(listener);
    }

    public boolean removeCollapseAnimationListener(AnimatorListenerAdapter listener) {
        return this.searchBarAnimationHelper.removeCollapseAnimationListener(listener);
    }

    int getMenuResId() {
        return this.menuResId;
    }

    float getCompatElevation() {
        MaterialShapeDrawable materialShapeDrawable = this.backgroundShape;
        return materialShapeDrawable != null ? materialShapeDrawable.getElevation() : ViewCompat.getElevation(this);
    }

    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
        private boolean initialized;

        public ScrollingViewBehavior() {
            this.initialized = false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.initialized = false;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
            boolean changed = super.onDependentViewChanged(parent, child, dependency);
            if (!this.initialized && (dependency instanceof AppBarLayout)) {
                this.initialized = true;
                AppBarLayout appBarLayout = (AppBarLayout) dependency;
                setAppBarLayoutTransparent(appBarLayout);
            }
            return changed;
        }

        private void setAppBarLayoutTransparent(AppBarLayout appBarLayout) {
            appBarLayout.setBackgroundColor(0);
            appBarLayout.setTargetElevation(0.0f);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        protected boolean shouldHeaderOverlapScrollingChild() {
            return true;
        }
    }

    public static abstract class OnLoadAnimationCallback {
        public void onAnimationStart() {
        }

        public void onAnimationEnd() {
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        CharSequence text = getText();
        savedState.text = text == null ? null : text.toString();
        return savedState;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        setText(savedState.text);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.search.SearchBar.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel source, ClassLoader loader) {
                return new SavedState(source, loader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel source) {
                return new SavedState(source);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        String text;

        public SavedState(Parcel source) {
            this(source, null);
        }

        public SavedState(Parcel source, ClassLoader classLoader) {
            super(source, classLoader);
            this.text = source.readString();
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeString(this.text);
        }
    }
}
