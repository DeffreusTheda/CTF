package io.flutter.embedding.android;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import io.flutter.embedding.android.k;

/* loaded from: classes.dex */
final class FlutterSplashView extends FrameLayout {

    /* renamed from: j, reason: collision with root package name */
    private static String f172j = "FlutterSplashView";

    /* renamed from: a, reason: collision with root package name */
    private x f173a;

    /* renamed from: b, reason: collision with root package name */
    private k f174b;

    /* renamed from: c, reason: collision with root package name */
    private View f175c;

    /* renamed from: d, reason: collision with root package name */
    Bundle f176d;

    /* renamed from: e, reason: collision with root package name */
    private String f177e;

    /* renamed from: f, reason: collision with root package name */
    private String f178f;

    /* renamed from: g, reason: collision with root package name */
    private final k.f f179g;

    /* renamed from: h, reason: collision with root package name */
    private final u.b f180h;

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f181i;

    @Keep
    public static class SavedState extends View.BaseSavedState {
        public static Parcelable.Creator<SavedState> CREATOR = new a();
        private String previousCompletedSplashIsolate;
        private Bundle splashScreenState;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.previousCompletedSplashIsolate = parcel.readString();
            this.splashScreenState = parcel.readBundle(getClass().getClassLoader());
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.previousCompletedSplashIsolate);
            parcel.writeBundle(this.splashScreenState);
        }
    }

    class a implements k.f {
        a() {
        }

        @Override // io.flutter.embedding.android.k.f
        public void a(io.flutter.embedding.engine.a aVar) {
            FlutterSplashView.this.f174b.y(this);
            FlutterSplashView flutterSplashView = FlutterSplashView.this;
            flutterSplashView.g(flutterSplashView.f174b, FlutterSplashView.this.f173a);
        }

        @Override // io.flutter.embedding.android.k.f
        public void b() {
        }
    }

    class b implements u.b {
        b() {
        }

        @Override // u.b
        public void c() {
            if (FlutterSplashView.this.f173a != null) {
                FlutterSplashView.this.k();
            }
        }

        @Override // u.b
        public void e() {
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FlutterSplashView flutterSplashView = FlutterSplashView.this;
            flutterSplashView.removeView(flutterSplashView.f175c);
            FlutterSplashView flutterSplashView2 = FlutterSplashView.this;
            flutterSplashView2.f178f = flutterSplashView2.f177e;
        }
    }

    public FlutterSplashView(Context context) {
        this(context, null, 0);
    }

    public FlutterSplashView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f179g = new a();
        this.f180h = new b();
        this.f181i = new c();
        setSaveEnabled(true);
    }

    private boolean h() {
        k kVar = this.f174b;
        if (kVar == null) {
            throw new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
        }
        if (kVar.w()) {
            return this.f174b.getAttachedFlutterEngine().h().h() != null && this.f174b.getAttachedFlutterEngine().h().h().equals(this.f178f);
        }
        throw new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
    }

    private boolean i() {
        k kVar = this.f174b;
        return (kVar == null || !kVar.w() || this.f174b.u() || h()) ? false : true;
    }

    private boolean j() {
        x xVar;
        k kVar = this.f174b;
        return kVar != null && kVar.w() && (xVar = this.f173a) != null && xVar.b() && l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f177e = this.f174b.getAttachedFlutterEngine().h().h();
        j.b.f(f172j, "Transitioning splash screen to a Flutter UI. Isolate: " + this.f177e);
        this.f173a.a(this.f181i);
    }

    private boolean l() {
        k kVar = this.f174b;
        if (kVar == null) {
            throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterView is set.");
        }
        if (kVar.w()) {
            return this.f174b.u() && !h();
        }
        throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
    }

    public void g(k kVar, x xVar) {
        k kVar2 = this.f174b;
        if (kVar2 != null) {
            kVar2.z(this.f180h);
            removeView(this.f174b);
        }
        View view = this.f175c;
        if (view != null) {
            removeView(view);
        }
        this.f174b = kVar;
        addView(kVar);
        this.f173a = xVar;
        if (xVar != null) {
            if (i()) {
                j.b.f(f172j, "Showing splash screen UI.");
                View c2 = xVar.c(getContext(), this.f176d);
                this.f175c = c2;
                addView(c2);
                kVar.l(this.f180h);
                return;
            }
            if (!j()) {
                if (kVar.w()) {
                    return;
                }
                j.b.f(f172j, "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.");
                kVar.k(this.f179g);
                return;
            }
            j.b.f(f172j, "Showing an immediate splash transition to Flutter due to previously interrupted transition.");
            View c3 = xVar.c(getContext(), this.f176d);
            this.f175c = c3;
            addView(c3);
            k();
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f178f = savedState.previousCompletedSplashIsolate;
        this.f176d = savedState.splashScreenState;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.previousCompletedSplashIsolate = this.f178f;
        x xVar = this.f173a;
        savedState.splashScreenState = xVar != null ? xVar.d() : null;
        return savedState;
    }
}
