package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewTreeObserver;
import io.flutter.plugin.platform.SingleViewPresentation;
import io.flutter.view.d;

@TargetApi(20)
/* loaded from: classes.dex */
class q {

    /* renamed from: a, reason: collision with root package name */
    SingleViewPresentation f551a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f552b;

    /* renamed from: c, reason: collision with root package name */
    private final io.flutter.plugin.platform.a f553c;

    /* renamed from: d, reason: collision with root package name */
    private final int f554d;

    /* renamed from: e, reason: collision with root package name */
    private final d.c f555e;

    /* renamed from: f, reason: collision with root package name */
    private final View.OnFocusChangeListener f556f;

    /* renamed from: g, reason: collision with root package name */
    private final Surface f557g;

    /* renamed from: h, reason: collision with root package name */
    private VirtualDisplay f558h;

    /* renamed from: i, reason: collision with root package name */
    private int f559i;

    /* renamed from: j, reason: collision with root package name */
    private int f560j;

    class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f561a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f562b;

        /* renamed from: io.flutter.plugin.platform.q$a$a, reason: collision with other inner class name */
        class RunnableC0013a implements Runnable {
            RunnableC0013a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.f561a.postDelayed(aVar.f562b, 128L);
            }
        }

        a(View view, Runnable runnable) {
            this.f561a = view;
            this.f562b = runnable;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b.a(this.f561a, new RunnableC0013a());
            this.f561a.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static class b implements ViewTreeObserver.OnDrawListener {

        /* renamed from: a, reason: collision with root package name */
        final View f565a;

        /* renamed from: b, reason: collision with root package name */
        Runnable f566b;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f565a.getViewTreeObserver().removeOnDrawListener(b.this);
            }
        }

        b(View view, Runnable runnable) {
            this.f565a = view;
            this.f566b = runnable;
        }

        static void a(View view, Runnable runnable) {
            view.getViewTreeObserver().addOnDrawListener(new b(view, runnable));
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f566b;
            if (runnable == null) {
                return;
            }
            runnable.run();
            this.f566b = null;
            this.f565a.post(new a());
        }
    }

    private q(Context context, io.flutter.plugin.platform.a aVar, VirtualDisplay virtualDisplay, e eVar, Surface surface, d.c cVar, View.OnFocusChangeListener onFocusChangeListener, int i2, Object obj) {
        this.f552b = context;
        this.f553c = aVar;
        this.f555e = cVar;
        this.f556f = onFocusChangeListener;
        this.f557g = surface;
        this.f558h = virtualDisplay;
        this.f554d = context.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(context, this.f558h.getDisplay(), eVar, aVar, i2, onFocusChangeListener);
        this.f551a = singleViewPresentation;
        singleViewPresentation.show();
    }

    public static q a(Context context, io.flutter.plugin.platform.a aVar, e eVar, d.c cVar, int i2, int i3, int i4, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        context.getResources().getDisplayMetrics();
        if (i2 == 0 || i3 == 0) {
            return null;
        }
        cVar.d().setDefaultBufferSize(i2, i3);
        Surface surface = new Surface(cVar.d());
        VirtualDisplay createVirtualDisplay = ((DisplayManager) context.getSystemService("display")).createVirtualDisplay("flutter-vd", i2, i3, context.getResources().getDisplayMetrics().densityDpi, surface, 0);
        if (createVirtualDisplay == null) {
            return null;
        }
        q qVar = new q(context, aVar, createVirtualDisplay, eVar, surface, cVar, onFocusChangeListener, i4, obj);
        qVar.f559i = i2;
        qVar.f560j = i3;
        return qVar;
    }

    public void b(MotionEvent motionEvent) {
        SingleViewPresentation singleViewPresentation = this.f551a;
        if (singleViewPresentation == null) {
            return;
        }
        singleViewPresentation.dispatchTouchEvent(motionEvent);
    }

    public int c() {
        return this.f560j;
    }

    public int d() {
        return this.f559i;
    }

    public View e() {
        SingleViewPresentation singleViewPresentation = this.f551a;
        if (singleViewPresentation == null) {
            return null;
        }
        return singleViewPresentation.getView().g();
    }

    void f(View view) {
        SingleViewPresentation singleViewPresentation = this.f551a;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.f551a.getView().e(view);
    }

    void g() {
        SingleViewPresentation singleViewPresentation = this.f551a;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.f551a.getView().d();
    }

    void h() {
        SingleViewPresentation singleViewPresentation = this.f551a;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.f551a.getView().c();
    }

    public void i(int i2, int i3, Runnable runnable) {
        boolean isFocused = e().isFocused();
        SingleViewPresentation.e detachState = this.f551a.detachState();
        this.f558h.setSurface(null);
        this.f558h.release();
        this.f559i = i2;
        this.f560j = i3;
        this.f555e.d().setDefaultBufferSize(i2, i3);
        this.f558h = ((DisplayManager) this.f552b.getSystemService("display")).createVirtualDisplay("flutter-vd", i2, i3, this.f554d, this.f557g, 0);
        View e2 = e();
        e2.addOnAttachStateChangeListener(new a(e2, runnable));
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.f552b, this.f558h.getDisplay(), this.f553c, detachState, this.f556f, isFocused);
        singleViewPresentation.show();
        this.f551a.cancel();
        this.f551a = singleViewPresentation;
    }
}
