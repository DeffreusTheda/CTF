package com.google.android.material.carousel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.ClampedCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.shape.ShapeableDelegate;

/* loaded from: classes.dex */
public class MaskableFrameLayout extends FrameLayout implements Maskable, Shapeable {
    private static final int NOT_SET = -1;
    private final RectF maskRect;
    private float maskXPercentage;
    private OnMaskChangedListener onMaskChangedListener;
    private Boolean savedForceCompatClippingEnabled;
    private ShapeAppearanceModel shapeAppearanceModel;
    private final ShapeableDelegate shapeableDelegate;

    public MaskableFrameLayout(Context context) {
        this(context, null);
    }

    public MaskableFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MaskableFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.maskXPercentage = -1.0f;
        this.maskRect = new RectF();
        this.shapeableDelegate = ShapeableDelegate.create(this);
        this.savedForceCompatClippingEnabled = null;
        setShapeAppearanceModel(ShapeAppearanceModel.builder(context, attrs, defStyleAttr, 0, 0).build());
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (this.maskXPercentage != -1.0f) {
            updateMaskRectForMaskXPercentage();
        }
    }

    @Override // android.view.View
    public void getFocusedRect(Rect r) {
        r.set((int) this.maskRect.left, (int) this.maskRect.top, (int) this.maskRect.right, (int) this.maskRect.bottom);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Boolean bool = this.savedForceCompatClippingEnabled;
        if (bool != null) {
            this.shapeableDelegate.setForceCompatClippingEnabled(this, bool.booleanValue());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.savedForceCompatClippingEnabled = Boolean.valueOf(this.shapeableDelegate.isForceCompatClippingEnabled());
        this.shapeableDelegate.setForceCompatClippingEnabled(this, true);
        super.onDetachedFromWindow();
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        ShapeAppearanceModel withTransformedCornerSizes = shapeAppearanceModel.withTransformedCornerSizes(new ShapeAppearanceModel.CornerSizeUnaryOperator() { // from class: com.google.android.material.carousel.MaskableFrameLayout$$ExternalSyntheticLambda1
            @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
            public final CornerSize apply(CornerSize cornerSize) {
                return MaskableFrameLayout.lambda$setShapeAppearanceModel$0(cornerSize);
            }
        });
        this.shapeAppearanceModel = withTransformedCornerSizes;
        this.shapeableDelegate.onShapeAppearanceChanged(this, withTransformedCornerSizes);
    }

    static /* synthetic */ CornerSize lambda$setShapeAppearanceModel$0(CornerSize cornerSize) {
        if (cornerSize instanceof AbsoluteCornerSize) {
            return ClampedCornerSize.createFromCornerSize((AbsoluteCornerSize) cornerSize);
        }
        return cornerSize;
    }

    @Override // com.google.android.material.shape.Shapeable
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @Override // com.google.android.material.carousel.Maskable
    @Deprecated
    public void setMaskXPercentage(float percentage) {
        float percentage2 = MathUtils.clamp(percentage, 0.0f, 1.0f);
        if (this.maskXPercentage != percentage2) {
            this.maskXPercentage = percentage2;
            updateMaskRectForMaskXPercentage();
        }
    }

    private void updateMaskRectForMaskXPercentage() {
        if (this.maskXPercentage != -1.0f) {
            float maskWidth = AnimationUtils.lerp(0.0f, getWidth() / 2.0f, 0.0f, 1.0f, this.maskXPercentage);
            setMaskRectF(new RectF(maskWidth, 0.0f, getWidth() - maskWidth, getHeight()));
        }
    }

    @Override // com.google.android.material.carousel.Maskable
    public void setMaskRectF(RectF maskRect) {
        this.maskRect.set(maskRect);
        onMaskChanged();
    }

    @Override // com.google.android.material.carousel.Maskable
    @Deprecated
    public float getMaskXPercentage() {
        return this.maskXPercentage;
    }

    @Override // com.google.android.material.carousel.Maskable
    public RectF getMaskRectF() {
        return this.maskRect;
    }

    @Override // com.google.android.material.carousel.Maskable
    public void setOnMaskChangedListener(OnMaskChangedListener onMaskChangedListener) {
        this.onMaskChangedListener = onMaskChangedListener;
    }

    private void onMaskChanged() {
        this.shapeableDelegate.onMaskChanged(this, this.maskRect);
        OnMaskChangedListener onMaskChangedListener = this.onMaskChangedListener;
        if (onMaskChangedListener != null) {
            onMaskChangedListener.onMaskChanged(this.maskRect);
        }
    }

    public void setForceCompatClipping(boolean forceCompatClipping) {
        this.shapeableDelegate.setForceCompatClippingEnabled(this, forceCompatClipping);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (!this.maskRect.isEmpty() && event.getAction() == 0) {
            float x = event.getX();
            float y = event.getY();
            if (!this.maskRect.contains(x, y)) {
                return false;
            }
        }
        return super.onTouchEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.shapeableDelegate.maybeClip(canvas, new CanvasCompat.CanvasOperation() { // from class: com.google.android.material.carousel.MaskableFrameLayout$$ExternalSyntheticLambda0
            @Override // com.google.android.material.canvas.CanvasCompat.CanvasOperation
            public final void run(Canvas canvas2) {
                MaskableFrameLayout.this.m71x418c47c0(canvas2);
            }
        });
    }

    /* renamed from: lambda$dispatchDraw$1$com-google-android-material-carousel-MaskableFrameLayout, reason: not valid java name */
    /* synthetic */ void m71x418c47c0(Canvas x$0) {
        super.dispatchDraw(x$0);
    }
}
