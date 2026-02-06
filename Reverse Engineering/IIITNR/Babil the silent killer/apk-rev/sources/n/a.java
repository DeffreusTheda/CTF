package n;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import java.util.Iterator;
import z.h;

@TargetApi(19)
/* loaded from: classes.dex */
public class a extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private FlutterMutatorsStack f948a;

    /* renamed from: b, reason: collision with root package name */
    private float f949b;

    /* renamed from: c, reason: collision with root package name */
    private int f950c;

    /* renamed from: d, reason: collision with root package name */
    private int f951d;

    /* renamed from: e, reason: collision with root package name */
    private int f952e;

    /* renamed from: f, reason: collision with root package name */
    private int f953f;

    /* renamed from: g, reason: collision with root package name */
    private final io.flutter.embedding.android.a f954g;

    /* renamed from: h, reason: collision with root package name */
    ViewTreeObserver.OnGlobalFocusChangeListener f955h;

    /* renamed from: n.a$a, reason: collision with other inner class name */
    class ViewTreeObserverOnGlobalFocusChangeListenerC0022a implements ViewTreeObserver.OnGlobalFocusChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View.OnFocusChangeListener f956a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f957b;

        ViewTreeObserverOnGlobalFocusChangeListenerC0022a(View.OnFocusChangeListener onFocusChangeListener, View view) {
            this.f956a = onFocusChangeListener;
            this.f957b = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public void onGlobalFocusChanged(View view, View view2) {
            View.OnFocusChangeListener onFocusChangeListener = this.f956a;
            View view3 = this.f957b;
            onFocusChangeListener.onFocusChange(view3, h.c(view3));
        }
    }

    public a(Context context, float f2, io.flutter.embedding.android.a aVar) {
        super(context, null);
        this.f949b = f2;
        this.f954g = aVar;
    }

    private Matrix getPlatformViewMatrix() {
        Matrix matrix = new Matrix(this.f948a.getFinalMatrix());
        float f2 = this.f949b;
        matrix.preScale(1.0f / f2, 1.0f / f2);
        matrix.postTranslate(-this.f950c, -this.f951d);
        return matrix;
    }

    public void a(FlutterMutatorsStack flutterMutatorsStack, int i2, int i3, int i4, int i5) {
        this.f948a = flutterMutatorsStack;
        this.f950c = i2;
        this.f951d = i3;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i5);
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = i3;
        setLayoutParams(layoutParams);
        setWillNotDraw(false);
    }

    public void b() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive() || (onGlobalFocusChangeListener = this.f955h) == null) {
            return;
        }
        this.f955h = null;
        viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.save();
        Iterator<Path> it = this.f948a.getFinalClippingPaths().iterator();
        while (it.hasNext()) {
            Path path = new Path(it.next());
            path.offset(-this.f950c, -this.f951d);
            canvas.clipPath(path);
        }
        super.draw(canvas);
        canvas.restore();
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
        if (this.f954g == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i3 = this.f950c;
            this.f952e = i3;
            i2 = this.f951d;
            this.f953f = i2;
            f2 = i3;
        } else {
            if (action == 2) {
                matrix.postTranslate(this.f952e, this.f953f);
                this.f952e = this.f950c;
                this.f953f = this.f951d;
                return this.f954g.g(motionEvent, matrix);
            }
            f2 = this.f950c;
            i2 = this.f951d;
        }
        matrix.postTranslate(f2, i2);
        return this.f954g.g(motionEvent, matrix);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getImportantForAccessibility() != 4) {
            return super.requestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        b();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.f955h == null) {
            ViewTreeObserverOnGlobalFocusChangeListenerC0022a viewTreeObserverOnGlobalFocusChangeListenerC0022a = new ViewTreeObserverOnGlobalFocusChangeListenerC0022a(onFocusChangeListener, this);
            this.f955h = viewTreeObserverOnGlobalFocusChangeListenerC0022a;
            viewTreeObserver.addOnGlobalFocusChangeListener(viewTreeObserverOnGlobalFocusChangeListenerC0022a);
        }
    }
}
