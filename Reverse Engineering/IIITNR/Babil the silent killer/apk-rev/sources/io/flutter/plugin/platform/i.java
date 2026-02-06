package io.flutter.plugin.platform;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import io.flutter.view.d;
import java.util.concurrent.atomic.AtomicLong;

@TargetApi(23)
/* loaded from: classes.dex */
class i extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private int f498a;

    /* renamed from: b, reason: collision with root package name */
    private int f499b;

    /* renamed from: c, reason: collision with root package name */
    private int f500c;

    /* renamed from: d, reason: collision with root package name */
    private int f501d;

    /* renamed from: e, reason: collision with root package name */
    private int f502e;

    /* renamed from: f, reason: collision with root package name */
    private int f503f;

    /* renamed from: g, reason: collision with root package name */
    private SurfaceTexture f504g;

    /* renamed from: h, reason: collision with root package name */
    private Surface f505h;

    /* renamed from: i, reason: collision with root package name */
    private io.flutter.embedding.android.a f506i;

    /* renamed from: j, reason: collision with root package name */
    ViewTreeObserver.OnGlobalFocusChangeListener f507j;

    /* renamed from: k, reason: collision with root package name */
    private final AtomicLong f508k;

    /* renamed from: l, reason: collision with root package name */
    private final d.a f509l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f510m;

    /* renamed from: n, reason: collision with root package name */
    private final d.b f511n;

    class a implements d.a {
        a() {
        }

        @Override // io.flutter.view.d.a
        public void a() {
            if (Build.VERSION.SDK_INT == 29) {
                i.this.f508k.decrementAndGet();
            }
        }
    }

    class b implements d.b {
        b() {
        }

        @Override // io.flutter.view.d.b
        public void onTrimMemory(int i2) {
            if (i2 != 80 || Build.VERSION.SDK_INT < 29) {
                return;
            }
            i.this.f510m = true;
        }
    }

    class c implements ViewTreeObserver.OnGlobalFocusChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View.OnFocusChangeListener f514a;

        c(View.OnFocusChangeListener onFocusChangeListener) {
            this.f514a = onFocusChangeListener;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public void onGlobalFocusChanged(View view, View view2) {
            View.OnFocusChangeListener onFocusChangeListener = this.f514a;
            i iVar = i.this;
            onFocusChangeListener.onFocusChange(iVar, z.h.c(iVar));
        }
    }

    public i(Context context) {
        super(context);
        this.f508k = new AtomicLong(0L);
        this.f509l = new a();
        this.f510m = false;
        this.f511n = new b();
        setWillNotDraw(false);
    }

    public i(Context context, d.c cVar) {
        this(context);
        cVar.c(this.f509l);
        cVar.a(this.f511n);
        l(cVar.d());
    }

    private void f() {
        if (Build.VERSION.SDK_INT == 29) {
            this.f508k.incrementAndGet();
        }
    }

    private void g() {
        if (this.f510m) {
            Surface surface = this.f505h;
            if (surface != null) {
                surface.release();
            }
            this.f505h = c(this.f504g);
            this.f510m = false;
        }
    }

    private boolean n() {
        return Build.VERSION.SDK_INT != 29 || this.f508k.get() <= 0;
    }

    protected Surface c(SurfaceTexture surfaceTexture) {
        return new Surface(surfaceTexture);
    }

    public int d() {
        return this.f503f;
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void draw(Canvas canvas) {
        String str;
        Surface surface = this.f505h;
        if (surface == null) {
            super.draw(canvas);
            str = "Platform view cannot be composed without a surface.";
        } else if (surface.isValid()) {
            SurfaceTexture surfaceTexture = this.f504g;
            if (surfaceTexture != null && !surfaceTexture.isReleased()) {
                if (!n()) {
                    invalidate();
                    return;
                }
                g();
                Canvas lockHardwareCanvas = this.f505h.lockHardwareCanvas();
                try {
                    lockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    super.draw(lockHardwareCanvas);
                    f();
                    return;
                } finally {
                    this.f505h.unlockCanvasAndPost(lockHardwareCanvas);
                }
            }
            str = "Invalid texture. The platform view cannot be displayed.";
        } else {
            str = "Invalid surface. The platform view cannot be displayed.";
        }
        j.b.b("PlatformViewWrapper", str);
    }

    public int e() {
        return this.f502e;
    }

    public void h() {
        this.f504g = null;
        Surface surface = this.f505h;
        if (surface != null) {
            surface.release();
            this.f505h = null;
        }
    }

    public void i(int i2, int i3) {
        this.f502e = i2;
        this.f503f = i3;
        SurfaceTexture surfaceTexture = this.f504g;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(i2, i3);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        invalidate();
        return super.invalidateChildInParent(iArr, rect);
    }

    public void j(FrameLayout.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.f500c = layoutParams.leftMargin;
        this.f501d = layoutParams.topMargin;
    }

    public void k(View.OnFocusChangeListener onFocusChangeListener) {
        o();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.f507j == null) {
            c cVar = new c(onFocusChangeListener);
            this.f507j = cVar;
            viewTreeObserver.addOnGlobalFocusChangeListener(cVar);
        }
    }

    @SuppressLint({"NewApi"})
    public void l(SurfaceTexture surfaceTexture) {
        int i2;
        if (Build.VERSION.SDK_INT < 23) {
            j.b.b("PlatformViewWrapper", "Platform views cannot be displayed below API level 23. You can prevent this issue by setting `minSdkVersion: 23` in build.gradle.");
            return;
        }
        this.f504g = surfaceTexture;
        int i3 = this.f502e;
        if (i3 > 0 && (i2 = this.f503f) > 0) {
            surfaceTexture.setDefaultBufferSize(i3, i2);
        }
        Surface surface = this.f505h;
        if (surface != null) {
            surface.release();
        }
        Surface c2 = c(surfaceTexture);
        this.f505h = c2;
        Canvas lockHardwareCanvas = c2.lockHardwareCanvas();
        try {
            lockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            f();
        } finally {
            this.f505h.unlockCanvasAndPost(lockHardwareCanvas);
        }
    }

    public void m(io.flutter.embedding.android.a aVar) {
        this.f506i = aVar;
    }

    public void o() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive() || (onGlobalFocusChangeListener = this.f507j) == null) {
            return;
        }
        this.f507j = null;
        viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    @SuppressLint({"NewApi"})
    public void onDescendantInvalidated(View view, View view2) {
        super.onDescendantInvalidated(view, view2);
        invalidate();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        float f2;
        if (this.f506i == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i3 = this.f500c;
            this.f498a = i3;
            i2 = this.f501d;
            this.f499b = i2;
            f2 = i3;
        } else {
            if (action == 2) {
                matrix.postTranslate(this.f498a, this.f499b);
                this.f498a = this.f500c;
                this.f499b = this.f501d;
                return this.f506i.g(motionEvent, matrix);
            }
            f2 = this.f500c;
            i2 = this.f501d;
        }
        matrix.postTranslate(f2, i2);
        return this.f506i.g(motionEvent, matrix);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getImportantForAccessibility() != 4) {
            return super.requestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }
}
