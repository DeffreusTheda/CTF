package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textservice.SpellCheckerInfo;
import android.view.textservice.TextServicesManager;
import android.widget.FrameLayout;
import androidx.window.java.layout.WindowInfoTrackerCallbackAdapter;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import io.flutter.embedding.android.g;
import io.flutter.embedding.android.s;
import io.flutter.view.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import u.a;
import y.a;

/* loaded from: classes.dex */
public class k extends FrameLayout implements a.c, s.e {

    /* renamed from: a, reason: collision with root package name */
    private h f245a;

    /* renamed from: b, reason: collision with root package name */
    private i f246b;

    /* renamed from: c, reason: collision with root package name */
    private io.flutter.embedding.android.g f247c;

    /* renamed from: d, reason: collision with root package name */
    u.c f248d;

    /* renamed from: e, reason: collision with root package name */
    private u.c f249e;

    /* renamed from: f, reason: collision with root package name */
    private final Set<u.b> f250f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f251g;

    /* renamed from: h, reason: collision with root package name */
    private io.flutter.embedding.engine.a f252h;

    /* renamed from: i, reason: collision with root package name */
    private final Set<f> f253i;

    /* renamed from: j, reason: collision with root package name */
    private y.a f254j;

    /* renamed from: k, reason: collision with root package name */
    private io.flutter.plugin.editing.f f255k;

    /* renamed from: l, reason: collision with root package name */
    private io.flutter.plugin.editing.d f256l;

    /* renamed from: m, reason: collision with root package name */
    private x.a f257m;

    /* renamed from: n, reason: collision with root package name */
    private s f258n;

    /* renamed from: o, reason: collision with root package name */
    private io.flutter.embedding.android.a f259o;

    /* renamed from: p, reason: collision with root package name */
    private io.flutter.view.c f260p;

    /* renamed from: q, reason: collision with root package name */
    private TextServicesManager f261q;

    /* renamed from: r, reason: collision with root package name */
    private z f262r;

    /* renamed from: s, reason: collision with root package name */
    private final a.g f263s;

    /* renamed from: t, reason: collision with root package name */
    private final c.k f264t;

    /* renamed from: u, reason: collision with root package name */
    private final ContentObserver f265u;

    /* renamed from: v, reason: collision with root package name */
    private final u.b f266v;

    /* renamed from: w, reason: collision with root package name */
    private final e.a<WindowLayoutInfo> f267w;

    class a implements c.k {
        a() {
        }

        @Override // io.flutter.view.c.k
        public void a(boolean z2, boolean z3) {
            k.this.A(z2, z3);
        }
    }

    class b extends ContentObserver {
        b(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z2) {
            super.onChange(z2);
            if (k.this.f252h == null) {
                return;
            }
            j.b.f("FlutterView", "System settings changed. Sending user settings to Flutter.");
            k.this.C();
        }
    }

    class c implements u.b {
        c() {
        }

        @Override // u.b
        public void c() {
            k.this.f251g = true;
            Iterator it = k.this.f250f.iterator();
            while (it.hasNext()) {
                ((u.b) it.next()).c();
            }
        }

        @Override // u.b
        public void e() {
            k.this.f251g = false;
            Iterator it = k.this.f250f.iterator();
            while (it.hasNext()) {
                ((u.b) it.next()).e();
            }
        }
    }

    class d implements e.a<WindowLayoutInfo> {
        d() {
        }

        @Override // e.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(WindowLayoutInfo windowLayoutInfo) {
            k.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
        }
    }

    class e implements u.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u.a f272a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f273b;

        e(u.a aVar, Runnable runnable) {
            this.f272a = aVar;
            this.f273b = runnable;
        }

        @Override // u.b
        public void c() {
            this.f272a.p(this);
            this.f273b.run();
            k kVar = k.this;
            if ((kVar.f248d instanceof io.flutter.embedding.android.g) || kVar.f247c == null) {
                return;
            }
            k.this.f247c.c();
        }

        @Override // u.b
        public void e() {
        }
    }

    public interface f {
        void a(io.flutter.embedding.engine.a aVar);

        void b();
    }

    private enum g {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    private k(Context context, AttributeSet attributeSet, h hVar) {
        super(context, attributeSet);
        this.f250f = new HashSet();
        this.f253i = new HashSet();
        this.f263s = new a.g();
        this.f264t = new a();
        this.f265u = new b(new Handler(Looper.getMainLooper()));
        this.f266v = new c();
        this.f267w = new d();
        this.f245a = hVar;
        this.f248d = hVar;
        v();
    }

    private k(Context context, AttributeSet attributeSet, i iVar) {
        super(context, attributeSet);
        this.f250f = new HashSet();
        this.f253i = new HashSet();
        this.f263s = new a.g();
        this.f264t = new a();
        this.f265u = new b(new Handler(Looper.getMainLooper()));
        this.f266v = new c();
        this.f267w = new d();
        this.f246b = iVar;
        this.f248d = iVar;
        v();
    }

    public k(Context context, h hVar) {
        this(context, (AttributeSet) null, hVar);
    }

    public k(Context context, i iVar) {
        this(context, (AttributeSet) null, iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z2, boolean z3) {
        boolean z4 = false;
        if (!this.f252h.o().k() && !z2 && !z3) {
            z4 = true;
        }
        setWillNotDraw(z4);
    }

    private void D() {
        if (!w()) {
            j.b.g("FlutterView", "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.f263s.f1169a = getResources().getDisplayMetrics().density;
        this.f263s.f1184p = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f252h.o().r(this.f263s);
    }

    private g o() {
        Context context = getContext();
        int i2 = context.getResources().getConfiguration().orientation;
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (i2 == 2) {
            if (rotation == 1) {
                return g.RIGHT;
            }
            if (rotation == 3) {
                return Build.VERSION.SDK_INT >= 23 ? g.LEFT : g.RIGHT;
            }
            if (rotation == 0 || rotation == 2) {
                return g.BOTH;
            }
        }
        return g.NONE;
    }

    @TargetApi(20)
    private int t(WindowInsets windowInsets) {
        int height = getRootView().getHeight();
        double systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
        double d2 = height;
        Double.isNaN(d2);
        if (systemWindowInsetBottom < d2 * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    private void v() {
        View view;
        j.b.f("FlutterView", "Initializing FlutterView");
        if (this.f245a != null) {
            j.b.f("FlutterView", "Internally using a FlutterSurfaceView.");
            view = this.f245a;
        } else if (this.f246b != null) {
            j.b.f("FlutterView", "Internally using a FlutterTextureView.");
            view = this.f246b;
        } else {
            j.b.f("FlutterView", "Internally using a FlutterImageView.");
            view = this.f247c;
        }
        addView(view);
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean x(SpellCheckerInfo spellCheckerInfo) {
        return spellCheckerInfo.getPackageName().equals("com.google.android.inputmethod.latin");
    }

    public void B(Runnable runnable) {
        io.flutter.embedding.android.g gVar = this.f247c;
        if (gVar == null) {
            j.b.f("FlutterView", "Tried to revert the image view, but no image view is used.");
            return;
        }
        u.c cVar = this.f249e;
        if (cVar == null) {
            j.b.f("FlutterView", "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        this.f248d = cVar;
        this.f249e = null;
        io.flutter.embedding.engine.a aVar = this.f252h;
        if (aVar == null) {
            gVar.c();
            runnable.run();
            return;
        }
        u.a o2 = aVar.o();
        if (o2 == null) {
            this.f247c.c();
            runnable.run();
        } else {
            this.f248d.a(o2);
            o2.f(new e(o2, runnable));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
    
        if (r3 != false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void C() {
        /*
            r6 = this;
            android.content.res.Resources r0 = r6.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.uiMode
            r0 = r0 & 48
            r1 = 0
            r2 = 1
            r3 = 32
            if (r0 != r3) goto L14
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            if (r0 == 0) goto L1a
            v.m$b r0 = v.m.b.dark
            goto L1c
        L1a:
            v.m$b r0 = v.m.b.light
        L1c:
            android.view.textservice.TextServicesManager r3 = r6.f261q
            if (r3 == 0) goto L40
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 31
            if (r4 < r5) goto L3e
            java.util.List r3 = r3.getEnabledSpellCheckerInfos()
            java.util.stream.Stream r3 = r3.stream()
            io.flutter.embedding.android.j r4 = new java.util.function.Predicate() { // from class: io.flutter.embedding.android.j
                static {
                    /*
                        io.flutter.embedding.android.j r0 = new io.flutter.embedding.android.j
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:io.flutter.embedding.android.j) io.flutter.embedding.android.j.a io.flutter.embedding.android.j
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.j.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.j.<init>():void");
                }

                @Override // java.util.function.Predicate
                public final boolean test(java.lang.Object r1) {
                    /*
                        r0 = this;
                        android.view.textservice.SpellCheckerInfo r1 = (android.view.textservice.SpellCheckerInfo) r1
                        boolean r1 = io.flutter.embedding.android.k.d(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.j.test(java.lang.Object):boolean");
                }
            }
            boolean r3 = r3.anyMatch(r4)
            android.view.textservice.TextServicesManager r4 = r6.f261q
            boolean r4 = r4.isSpellCheckerEnabled()
            if (r4 == 0) goto L40
            if (r3 == 0) goto L40
        L3e:
            r3 = 1
            goto L41
        L40:
            r3 = 0
        L41:
            io.flutter.embedding.engine.a r4 = r6.f252h
            v.m r4 = r4.q()
            v.m$a r4 = r4.a()
            android.content.res.Resources r5 = r6.getResources()
            android.content.res.Configuration r5 = r5.getConfiguration()
            float r5 = r5.fontScale
            v.m$a r4 = r4.e(r5)
            v.m$a r3 = r4.c(r3)
            android.content.Context r4 = r6.getContext()
            android.content.ContentResolver r4 = r4.getContentResolver()
            java.lang.String r5 = "show_password"
            int r4 = android.provider.Settings.System.getInt(r4, r5, r2)
            if (r4 != r2) goto L6e
            r1 = 1
        L6e:
            v.m$a r1 = r3.b(r1)
            android.content.Context r2 = r6.getContext()
            boolean r2 = android.text.format.DateFormat.is24HourFormat(r2)
            v.m$a r1 = r1.f(r2)
            v.m$a r0 = r1.d(r0)
            r0.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.k.C():void");
    }

    @Override // io.flutter.embedding.android.s.e
    public boolean a(KeyEvent keyEvent) {
        return this.f255k.r(keyEvent);
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> sparseArray) {
        this.f255k.j(sparseArray);
    }

    @Override // y.a.c
    @TargetApi(24)
    public PointerIcon b(int i2) {
        return PointerIcon.getSystemIcon(getContext(), i2);
    }

    @Override // io.flutter.embedding.android.s.e
    public void c(KeyEvent keyEvent) {
        getRootView().dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        io.flutter.embedding.engine.a aVar = this.f252h;
        return aVar != null ? aVar.n().F(view) : super.checkInputConnectionProxy(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        return (w() && this.f258n.a(keyEvent)) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT > 19) {
            return super.fitSystemWindows(rect);
        }
        a.g gVar = this.f263s;
        gVar.f1172d = rect.top;
        gVar.f1173e = rect.right;
        gVar.f1174f = 0;
        gVar.f1175g = rect.left;
        gVar.f1176h = 0;
        gVar.f1177i = 0;
        gVar.f1178j = rect.bottom;
        gVar.f1179k = 0;
        j.b.f("FlutterView", "Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: " + this.f263s.f1172d + ", Left: " + this.f263s.f1175g + ", Right: " + this.f263s.f1173e + "\nKeyboard insets: Bottom: " + this.f263s.f1178j + ", Left: " + this.f263s.f1179k + ", Right: " + this.f263s.f1177i);
        D();
        return true;
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        io.flutter.view.c cVar = this.f260p;
        if (cVar == null || !cVar.D()) {
            return null;
        }
        return this.f260p;
    }

    public io.flutter.embedding.engine.a getAttachedFlutterEngine() {
        return this.f252h;
    }

    @Override // io.flutter.embedding.android.s.e
    public w.b getBinaryMessenger() {
        return this.f252h.h();
    }

    public io.flutter.embedding.android.g getCurrentImageSurface() {
        return this.f247c;
    }

    public boolean j() {
        io.flutter.embedding.android.g gVar = this.f247c;
        if (gVar != null) {
            return gVar.d();
        }
        return false;
    }

    public void k(f fVar) {
        this.f253i.add(fVar);
    }

    public void l(u.b bVar) {
        this.f250f.add(bVar);
    }

    public void m(io.flutter.embedding.android.g gVar) {
        io.flutter.embedding.engine.a aVar = this.f252h;
        if (aVar != null) {
            gVar.a(aVar.o());
        }
    }

    public void n(io.flutter.embedding.engine.a aVar) {
        j.b.f("FlutterView", "Attaching to a FlutterEngine: " + aVar);
        if (w()) {
            if (aVar == this.f252h) {
                j.b.f("FlutterView", "Already attached to this engine. Doing nothing.");
                return;
            } else {
                j.b.f("FlutterView", "Currently attached to a different engine. Detaching and then attaching to new engine.");
                s();
            }
        }
        this.f252h = aVar;
        u.a o2 = aVar.o();
        this.f251g = o2.j();
        this.f248d.a(o2);
        o2.f(this.f266v);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f254j = new y.a(this, this.f252h.k());
        }
        this.f255k = new io.flutter.plugin.editing.f(this, this.f252h.t(), this.f252h.n());
        try {
            TextServicesManager textServicesManager = (TextServicesManager) getContext().getSystemService("textservices");
            this.f261q = textServicesManager;
            this.f256l = new io.flutter.plugin.editing.d(textServicesManager, this.f252h.r());
        } catch (Exception unused) {
            j.b.b("FlutterView", "TextServicesManager not supported by device, spell check disabled.");
        }
        this.f257m = this.f252h.j();
        this.f258n = new s(this);
        this.f259o = new io.flutter.embedding.android.a(this.f252h.o(), false);
        io.flutter.view.c cVar = new io.flutter.view.c(this, aVar.f(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.f252h.n());
        this.f260p = cVar;
        cVar.Y(this.f264t);
        A(this.f260p.D(), this.f260p.E());
        this.f252h.n().b(this.f260p);
        this.f252h.n().D(this.f252h.o());
        this.f255k.q().restartInput(this);
        C();
        getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor("show_password"), false, this.f265u);
        D();
        aVar.n().E(this);
        Iterator<f> it = this.f253i.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
        if (this.f251g) {
            this.f266v.c();
        }
    }

    @Override // android.view.View
    @SuppressLint({"InlinedApi", "NewApi"})
    @TargetApi(20)
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 29) {
            Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
            a.g gVar = this.f263s;
            gVar.f1180l = systemGestureInsets.top;
            gVar.f1181m = systemGestureInsets.right;
            gVar.f1182n = systemGestureInsets.bottom;
            gVar.f1183o = systemGestureInsets.left;
        }
        boolean z2 = (getWindowSystemUiVisibility() & 4) == 0;
        boolean z3 = (getWindowSystemUiVisibility() & 2) == 0;
        if (i2 >= 30) {
            int navigationBars = z3 ? 0 | WindowInsets.Type.navigationBars() : 0;
            if (z2) {
                navigationBars |= WindowInsets.Type.statusBars();
            }
            Insets insets = windowInsets.getInsets(navigationBars);
            a.g gVar2 = this.f263s;
            gVar2.f1172d = insets.top;
            gVar2.f1173e = insets.right;
            gVar2.f1174f = insets.bottom;
            gVar2.f1175g = insets.left;
            Insets insets2 = windowInsets.getInsets(WindowInsets.Type.ime());
            a.g gVar3 = this.f263s;
            gVar3.f1176h = insets2.top;
            gVar3.f1177i = insets2.right;
            gVar3.f1178j = insets2.bottom;
            gVar3.f1179k = insets2.left;
            Insets insets3 = windowInsets.getInsets(WindowInsets.Type.systemGestures());
            a.g gVar4 = this.f263s;
            gVar4.f1180l = insets3.top;
            gVar4.f1181m = insets3.right;
            gVar4.f1182n = insets3.bottom;
            gVar4.f1183o = insets3.left;
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                Insets waterfallInsets = displayCutout.getWaterfallInsets();
                a.g gVar5 = this.f263s;
                gVar5.f1172d = Math.max(Math.max(gVar5.f1172d, waterfallInsets.top), displayCutout.getSafeInsetTop());
                a.g gVar6 = this.f263s;
                gVar6.f1173e = Math.max(Math.max(gVar6.f1173e, waterfallInsets.right), displayCutout.getSafeInsetRight());
                a.g gVar7 = this.f263s;
                gVar7.f1174f = Math.max(Math.max(gVar7.f1174f, waterfallInsets.bottom), displayCutout.getSafeInsetBottom());
                a.g gVar8 = this.f263s;
                gVar8.f1175g = Math.max(Math.max(gVar8.f1175g, waterfallInsets.left), displayCutout.getSafeInsetLeft());
            }
        } else {
            g gVar9 = g.NONE;
            if (!z3) {
                gVar9 = o();
            }
            this.f263s.f1172d = z2 ? windowInsets.getSystemWindowInsetTop() : 0;
            this.f263s.f1173e = (gVar9 == g.RIGHT || gVar9 == g.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.f263s.f1174f = (z3 && t(windowInsets) == 0) ? windowInsets.getSystemWindowInsetBottom() : 0;
            this.f263s.f1175g = (gVar9 == g.LEFT || gVar9 == g.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            a.g gVar10 = this.f263s;
            gVar10.f1176h = 0;
            gVar10.f1177i = 0;
            gVar10.f1178j = t(windowInsets);
            this.f263s.f1179k = 0;
        }
        j.b.f("FlutterView", "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.f263s.f1172d + ", Left: " + this.f263s.f1175g + ", Right: " + this.f263s.f1173e + "\nKeyboard insets: Bottom: " + this.f263s.f1178j + ", Left: " + this.f263s.f1179k + ", Right: " + this.f263s.f1177i + "System Gesture Insets - Left: " + this.f263s.f1183o + ", Top: " + this.f263s.f1180l + ", Right: " + this.f263s.f1181m + ", Bottom: " + this.f263s.f1178j);
        D();
        return onApplyWindowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f262r = r();
        Activity e2 = z.h.e(getContext());
        z zVar = this.f262r;
        if (zVar == null || e2 == null) {
            return;
        }
        zVar.a(e2, androidx.core.content.a.a(getContext()), this.f267w);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f252h != null) {
            j.b.f("FlutterView", "Configuration changed. Sending locales and user settings to Flutter.");
            this.f257m.d(configuration);
            C();
        }
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return !w() ? super.onCreateInputConnection(editorInfo) : this.f255k.o(this, this.f258n, editorInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        z zVar = this.f262r;
        if (zVar != null) {
            zVar.b(this.f267w);
        }
        this.f262r = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (w() && this.f259o.e(motionEvent)) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        return !w() ? super.onHoverEvent(motionEvent) : this.f260p.J(motionEvent);
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i2) {
        super.onProvideAutofillVirtualStructure(viewStructure, i2);
        this.f255k.z(viewStructure, i2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        j.b.f("FlutterView", "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i4 + " x " + i5 + ", it is now " + i2 + " x " + i3);
        a.g gVar = this.f263s;
        gVar.f1170b = i2;
        gVar.f1171c = i3;
        D();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!w()) {
            return super.onTouchEvent(motionEvent);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            requestUnbufferedDispatch(motionEvent);
        }
        return this.f259o.f(motionEvent);
    }

    public void p() {
        this.f248d.b();
        io.flutter.embedding.android.g gVar = this.f247c;
        if (gVar == null) {
            io.flutter.embedding.android.g q2 = q();
            this.f247c = q2;
            addView(q2);
        } else {
            gVar.j(getWidth(), getHeight());
        }
        this.f249e = this.f248d;
        io.flutter.embedding.android.g gVar2 = this.f247c;
        this.f248d = gVar2;
        io.flutter.embedding.engine.a aVar = this.f252h;
        if (aVar != null) {
            gVar2.a(aVar.o());
        }
    }

    public io.flutter.embedding.android.g q() {
        return new io.flutter.embedding.android.g(getContext(), getWidth(), getHeight(), g.b.background);
    }

    protected z r() {
        try {
            return new z(new WindowInfoTrackerCallbackAdapter(WindowInfoTracker.Companion.getOrCreate(getContext())));
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    public void s() {
        j.b.f("FlutterView", "Detaching from a FlutterEngine: " + this.f252h);
        if (!w()) {
            j.b.f("FlutterView", "FlutterView not attached to an engine. Not detaching.");
            return;
        }
        Iterator<f> it = this.f253i.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        getContext().getContentResolver().unregisterContentObserver(this.f265u);
        this.f252h.n().K();
        this.f252h.n().a();
        this.f260p.Q();
        this.f260p = null;
        this.f255k.q().restartInput(this);
        this.f255k.p();
        this.f258n.c();
        io.flutter.plugin.editing.d dVar = this.f256l;
        if (dVar != null) {
            dVar.b();
        }
        y.a aVar = this.f254j;
        if (aVar != null) {
            aVar.c();
        }
        u.a o2 = this.f252h.o();
        this.f251g = false;
        o2.p(this.f266v);
        o2.t();
        o2.q(false);
        u.c cVar = this.f249e;
        if (cVar != null && this.f248d == this.f247c) {
            this.f248d = cVar;
        }
        this.f248d.c();
        io.flutter.embedding.android.g gVar = this.f247c;
        if (gVar != null) {
            gVar.f();
            removeView(this.f247c);
            this.f247c = null;
        }
        this.f249e = null;
        this.f252h = null;
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        u.c cVar = this.f248d;
        if (cVar instanceof h) {
            ((h) cVar).setVisibility(i2);
        }
    }

    @TargetApi(28)
    protected void setWindowInfoListenerDisplayFeatures(WindowLayoutInfo windowLayoutInfo) {
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        List<DisplayFeature> displayFeatures = windowLayoutInfo.getDisplayFeatures();
        ArrayList arrayList = new ArrayList();
        for (DisplayFeature displayFeature : displayFeatures) {
            j.b.f("FlutterView", "WindowInfoTracker Display Feature reported with bounds = " + displayFeature.getBounds().toString() + " and type = " + displayFeature.getClass().getSimpleName());
            if (displayFeature instanceof FoldingFeature) {
                FoldingFeature foldingFeature = (FoldingFeature) displayFeature;
                arrayList.add(new a.b(displayFeature.getBounds(), foldingFeature.getOcclusionType() == FoldingFeature.OcclusionType.FULL ? a.d.HINGE : a.d.FOLD, foldingFeature.getState() == FoldingFeature.State.FLAT ? a.c.POSTURE_FLAT : foldingFeature.getState() == FoldingFeature.State.HALF_OPENED ? a.c.POSTURE_HALF_OPENED : a.c.UNKNOWN));
            } else {
                arrayList.add(new a.b(displayFeature.getBounds(), a.d.UNKNOWN, a.c.UNKNOWN));
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && (rootWindowInsets = getRootWindowInsets()) != null && (displayCutout = rootWindowInsets.getDisplayCutout()) != null) {
            for (Rect rect : displayCutout.getBoundingRects()) {
                j.b.f("FlutterView", "DisplayCutout area reported with bounds = " + rect.toString());
                arrayList.add(new a.b(rect, a.d.CUTOUT));
            }
        }
        this.f263s.f1185q = arrayList;
        D();
    }

    public boolean u() {
        return this.f251g;
    }

    public boolean w() {
        io.flutter.embedding.engine.a aVar = this.f252h;
        return aVar != null && aVar.o() == this.f248d.getAttachedRenderer();
    }

    public void y(f fVar) {
        this.f253i.remove(fVar);
    }

    public void z(u.b bVar) {
        this.f250f.remove(bVar);
    }
}
