package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.MutableContextWrapper;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Keep
@TargetApi(17)
/* loaded from: classes.dex */
class SingleViewPresentation extends Presentation {
    private static final String TAG = "PlatformViewsController";
    private final io.flutter.plugin.platform.a accessibilityEventsDelegate;
    private FrameLayout container;
    private final View.OnFocusChangeListener focusChangeListener;
    private final Context outerContext;
    private a rootView;
    private boolean startFocused;
    private final e state;
    private int viewId;

    private static class a extends FrameLayout {

        /* renamed from: a, reason: collision with root package name */
        private final io.flutter.plugin.platform.a f467a;

        /* renamed from: b, reason: collision with root package name */
        private final View f468b;

        public a(Context context, io.flutter.plugin.platform.a aVar, View view) {
            super(context);
            this.f467a = aVar;
            this.f468b = view;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f467a.b(this.f468b, view, accessibilityEvent);
        }
    }

    static class b extends ViewGroup {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f469a;

        /* renamed from: b, reason: collision with root package name */
        private final Rect f470b;

        public b(Context context) {
            super(context);
            this.f469a = new Rect();
            this.f470b = new Rect();
        }

        private static int a(int i2) {
            return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), Integer.MIN_VALUE);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                View childAt = getChildAt(i6);
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) childAt.getLayoutParams();
                this.f469a.set(i2, i3, i4, i5);
                Gravity.apply(layoutParams.gravity, childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), this.f469a, layoutParams.x, layoutParams.y, this.f470b);
                Rect rect = this.f470b;
                childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
            }
        }

        @Override // android.view.View
        protected void onMeasure(int i2, int i3) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                getChildAt(i4).measure(a(i2), a(i3));
            }
            super.onMeasure(i2, i3);
        }
    }

    private static class c extends ContextWrapper {

        /* renamed from: a, reason: collision with root package name */
        private final InputMethodManager f471a;

        c(Context context) {
            this(context, null);
        }

        private c(Context context, InputMethodManager inputMethodManager) {
            super(context);
            this.f471a = inputMethodManager == null ? (InputMethodManager) context.getSystemService("input_method") : inputMethodManager;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context createDisplayContext(Display display) {
            return new c(super.createDisplayContext(display), this.f471a);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "input_method".equals(str) ? this.f471a : super.getSystemService(str);
        }
    }

    private static class d extends ContextWrapper {

        /* renamed from: a, reason: collision with root package name */
        private final f f472a;

        /* renamed from: b, reason: collision with root package name */
        private WindowManager f473b;

        /* renamed from: c, reason: collision with root package name */
        private final Context f474c;

        d(Context context, f fVar, Context context2) {
            super(context);
            this.f472a = fVar;
            this.f474c = context2;
        }

        private WindowManager a() {
            if (this.f473b == null) {
                this.f473b = this.f472a.b();
            }
            return this.f473b;
        }

        private boolean b() {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (int i2 = 0; i2 < stackTrace.length && i2 < 11; i2++) {
                if (stackTrace[i2].getClassName().equals(AlertDialog.class.getCanonicalName()) && stackTrace[i2].getMethodName().equals("<init>")) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "window".equals(str) ? b() ? this.f474c.getSystemService(str) : a() : super.getSystemService(str);
        }
    }

    static class e {

        /* renamed from: a, reason: collision with root package name */
        private io.flutter.plugin.platform.e f475a;

        /* renamed from: b, reason: collision with root package name */
        private f f476b;

        /* renamed from: c, reason: collision with root package name */
        private b f477c;

        e() {
        }
    }

    static class f implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final WindowManager f478a;

        /* renamed from: b, reason: collision with root package name */
        b f479b;

        f(WindowManager windowManager, b bVar) {
            this.f478a = windowManager;
            this.f479b = bVar;
        }

        private void a(Object[] objArr) {
            b bVar = this.f479b;
            if (bVar == null) {
                j.b.g(SingleViewPresentation.TAG, "Embedded view called addView while detached from presentation");
            } else {
                bVar.addView((View) objArr[0], (WindowManager.LayoutParams) objArr[1]);
            }
        }

        private void c(Object[] objArr) {
            b bVar = this.f479b;
            if (bVar == null) {
                j.b.g(SingleViewPresentation.TAG, "Embedded view called removeView while detached from presentation");
            } else {
                bVar.removeView((View) objArr[0]);
            }
        }

        private void d(Object[] objArr) {
            if (this.f479b == null) {
                j.b.g(SingleViewPresentation.TAG, "Embedded view called removeViewImmediate while detached from presentation");
                return;
            }
            View view = (View) objArr[0];
            view.clearAnimation();
            this.f479b.removeView(view);
        }

        private void e(Object[] objArr) {
            b bVar = this.f479b;
            if (bVar == null) {
                j.b.g(SingleViewPresentation.TAG, "Embedded view called updateViewLayout while detached from presentation");
            } else {
                bVar.updateViewLayout((View) objArr[0], (WindowManager.LayoutParams) objArr[1]);
            }
        }

        public WindowManager b() {
            return (WindowManager) Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[]{WindowManager.class}, this);
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            name.hashCode();
            switch (name) {
                case "addView":
                    a(objArr);
                    return null;
                case "removeViewImmediate":
                    d(objArr);
                    return null;
                case "updateViewLayout":
                    e(objArr);
                    return null;
                case "removeView":
                    c(objArr);
                    return null;
                default:
                    try {
                        return method.invoke(this.f478a, objArr);
                    } catch (InvocationTargetException e2) {
                        throw e2.getCause();
                    }
            }
        }
    }

    public SingleViewPresentation(Context context, Display display, io.flutter.plugin.platform.a aVar, e eVar, View.OnFocusChangeListener onFocusChangeListener, boolean z2) {
        super(new c(context), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = aVar;
        this.state = eVar;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        getWindow().setFlags(8, 8);
        this.startFocused = z2;
    }

    public SingleViewPresentation(Context context, Display display, io.flutter.plugin.platform.e eVar, io.flutter.plugin.platform.a aVar, int i2, View.OnFocusChangeListener onFocusChangeListener) {
        super(new c(context), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = aVar;
        this.viewId = i2;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        e eVar2 = new e();
        this.state = eVar2;
        eVar2.f475a = eVar;
        getWindow().setFlags(8, 8);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().setType(2030);
        }
    }

    public e detachState() {
        this.container.removeAllViews();
        this.rootView.removeAllViews();
        return this.state;
    }

    public io.flutter.plugin.platform.e getView() {
        if (this.state.f475a == null) {
            return null;
        }
        return this.state.f475a;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.state.f477c == null) {
            this.state.f477c = new b(getContext());
        }
        if (this.state.f476b == null) {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            e eVar = this.state;
            eVar.f476b = new f(windowManager, eVar.f477c);
        }
        this.container = new FrameLayout(getContext());
        d dVar = new d(getContext(), this.state.f476b, this.outerContext);
        View g2 = this.state.f475a.g();
        if (g2.getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) g2.getContext()).setBaseContext(dVar);
        } else {
            j.b.g(TAG, "Unexpected platform view context for view ID " + this.viewId + "; some functionality may not work correctly. When constructing a platform view in the factory, ensure that the view returned from PlatformViewFactory#create returns the provided context from getContext(). If you are unable to associate the view with that context, consider using Hybrid Composition instead.");
        }
        this.container.addView(g2);
        a aVar = new a(getContext(), this.accessibilityEventsDelegate, g2);
        this.rootView = aVar;
        aVar.addView(this.container);
        this.rootView.addView(this.state.f477c);
        g2.setOnFocusChangeListener(this.focusChangeListener);
        this.rootView.setFocusableInTouchMode(true);
        if (this.startFocused) {
            g2.requestFocus();
        } else {
            this.rootView.requestFocus();
        }
        setContentView(this.rootView);
    }
}
