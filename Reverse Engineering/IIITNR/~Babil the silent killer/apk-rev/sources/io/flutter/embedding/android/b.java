package io.flutter.embedding.android;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

@Deprecated
/* loaded from: classes.dex */
public final class b implements x {

    /* renamed from: a, reason: collision with root package name */
    private final Drawable f190a;

    /* renamed from: b, reason: collision with root package name */
    private final ImageView.ScaleType f191b;

    /* renamed from: c, reason: collision with root package name */
    private final long f192c;

    /* renamed from: d, reason: collision with root package name */
    private C0009b f193d;

    class a implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f194a;

        a(Runnable runnable) {
            this.f194a = runnable;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f194a.run();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f194a.run();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: io.flutter.embedding.android.b$b, reason: collision with other inner class name */
    public static class C0009b extends ImageView {
        public C0009b(Context context) {
            this(context, null, 0);
        }

        public C0009b(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
        }

        public void a(Drawable drawable, ImageView.ScaleType scaleType) {
            setScaleType(scaleType);
            setImageDrawable(drawable);
        }

        public void setSplashDrawable(Drawable drawable) {
            a(drawable, ImageView.ScaleType.FIT_XY);
        }
    }

    public b(Drawable drawable) {
        this(drawable, ImageView.ScaleType.FIT_XY, 500L);
    }

    public b(Drawable drawable, ImageView.ScaleType scaleType, long j2) {
        this.f190a = drawable;
        this.f191b = scaleType;
        this.f192c = j2;
    }

    @Override // io.flutter.embedding.android.x
    public void a(Runnable runnable) {
        C0009b c0009b = this.f193d;
        if (c0009b == null) {
            runnable.run();
        } else {
            c0009b.animate().alpha(0.0f).setDuration(this.f192c).setListener(new a(runnable));
        }
    }

    @Override // io.flutter.embedding.android.x
    public /* synthetic */ boolean b() {
        return w.a(this);
    }

    @Override // io.flutter.embedding.android.x
    public View c(Context context, Bundle bundle) {
        C0009b c0009b = new C0009b(context);
        this.f193d = c0009b;
        c0009b.a(this.f190a, this.f191b);
        return this.f193d;
    }

    @Override // io.flutter.embedding.android.x
    public /* synthetic */ Bundle d() {
        return w.b(this);
    }
}
