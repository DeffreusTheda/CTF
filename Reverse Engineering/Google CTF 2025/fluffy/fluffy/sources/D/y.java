package D;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.TextServicesManager;
import android.widget.FrameLayout;
import g.AbstractC0038a;
import h0.AbstractC0041a;
import h0.AbstractC0059t;
import h0.AbstractC0064y;
import h0.C0057q;
import h0.Y;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import s.C0092b;
import t.C0101a;

/* loaded from: classes.dex */
public final class y extends FrameLayout implements N.a, L {

    /* renamed from: a, reason: collision with root package name */
    public final C0014o f100a;

    /* renamed from: b, reason: collision with root package name */
    public final C0016q f101b;

    /* renamed from: c, reason: collision with root package name */
    public C0012m f102c;

    /* renamed from: d, reason: collision with root package name */
    public View f103d;

    /* renamed from: e, reason: collision with root package name */
    public View f104e;

    /* renamed from: f, reason: collision with root package name */
    public final HashSet f105f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f106g;

    /* renamed from: h, reason: collision with root package name */
    public E.c f107h;

    /* renamed from: i, reason: collision with root package name */
    public final HashSet f108i;

    /* renamed from: j, reason: collision with root package name */
    public B.a f109j;

    /* renamed from: k, reason: collision with root package name */
    public io.flutter.plugin.editing.k f110k;

    /* renamed from: l, reason: collision with root package name */
    public io.flutter.plugin.editing.g f111l;
    public M.a m;

    /* renamed from: n, reason: collision with root package name */
    public B.e f112n;

    /* renamed from: o, reason: collision with root package name */
    public C0001b f113o;

    /* renamed from: p, reason: collision with root package name */
    public io.flutter.view.l f114p;

    /* renamed from: q, reason: collision with root package name */
    public TextServicesManager f115q;

    /* renamed from: r, reason: collision with root package name */
    public v f116r;

    /* renamed from: s, reason: collision with root package name */
    public final io.flutter.embedding.engine.renderer.i f117s;

    /* renamed from: t, reason: collision with root package name */
    public final v f118t;
    public final w u;

    /* renamed from: v, reason: collision with root package name */
    public final C0006g f119v;

    /* renamed from: w, reason: collision with root package name */
    public u f120w;

    /* renamed from: x, reason: collision with root package name */
    public B f121x;

    public y(AbstractActivityC0005f abstractActivityC0005f, C0014o c0014o) {
        super(abstractActivityC0005f, null);
        this.f105f = new HashSet();
        this.f108i = new HashSet();
        this.f117s = new io.flutter.embedding.engine.renderer.i();
        this.f118t = new v(0, this);
        this.u = new w(this, new Handler(Looper.getMainLooper()), 0);
        this.f119v = new C0006g(2, this);
        this.f121x = new B();
        this.f100a = c0014o;
        this.f103d = c0014o;
        b();
    }

    /* JADX WARN: Type inference failed for: r0v39, types: [android.view.View, io.flutter.embedding.engine.renderer.l] */
    public final void a() {
        SparseArray sparseArray;
        Objects.toString(this.f107h);
        if (!c()) {
            return;
        }
        Iterator it = this.f108i.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        getContext().getContentResolver().unregisterContentObserver(this.u);
        io.flutter.plugin.platform.k kVar = this.f107h.f141r;
        int i2 = 0;
        while (true) {
            SparseArray sparseArray2 = kVar.m;
            if (i2 >= sparseArray2.size()) {
                break;
            }
            kVar.f720c.removeView((io.flutter.plugin.platform.g) sparseArray2.valueAt(i2));
            i2++;
        }
        int i3 = 0;
        while (true) {
            SparseArray sparseArray3 = kVar.f728k;
            if (i3 >= sparseArray3.size()) {
                kVar.e();
                if (kVar.f720c == null) {
                    Log.e("PlatformViewsController", "removeOverlaySurfaces called while flutter view is null");
                } else {
                    int i4 = 0;
                    while (true) {
                        sparseArray = kVar.f729l;
                        if (i4 >= sparseArray.size()) {
                            break;
                        }
                        kVar.f720c.removeView((View) sparseArray.valueAt(i4));
                        i4++;
                    }
                    sparseArray.clear();
                }
                kVar.f720c = null;
                kVar.f731o = false;
                SparseArray sparseArray4 = kVar.f727j;
                if (sparseArray4.size() > 0) {
                    sparseArray4.valueAt(0).getClass();
                    throw new ClassCastException();
                }
                io.flutter.plugin.platform.j jVar = this.f107h.f142s;
                int i5 = 0;
                while (true) {
                    SparseArray sparseArray5 = jVar.f713h;
                    if (i5 >= sparseArray5.size()) {
                        Surface surface = jVar.f716k;
                        if (surface != null) {
                            surface.release();
                            jVar.f716k = null;
                            jVar.f717l = null;
                        }
                        jVar.f708c = null;
                        SparseArray sparseArray6 = jVar.f712g;
                        if (sparseArray6.size() > 0) {
                            sparseArray6.valueAt(0).getClass();
                            throw new ClassCastException();
                        }
                        this.f107h.f141r.a();
                        this.f107h.f142s.a();
                        io.flutter.view.l lVar = this.f114p;
                        lVar.f848t = true;
                        lVar.f834e.a();
                        lVar.f846r = null;
                        AccessibilityManager accessibilityManager = lVar.f832c;
                        accessibilityManager.removeAccessibilityStateChangeListener(lVar.f849v);
                        accessibilityManager.removeTouchExplorationStateChangeListener(lVar.f850w);
                        lVar.f835f.unregisterContentObserver(lVar.f851x);
                        B.e eVar = lVar.f831b;
                        eVar.f10c = null;
                        ((FlutterJNI) eVar.f9b).setAccessibilityDelegate(null);
                        this.f114p = null;
                        this.f110k.f679b.restartInput(this);
                        this.f110k.b();
                        int size = ((HashSet) this.f112n.f8a).size();
                        if (size > 0) {
                            Log.w("KeyboardManager", "A KeyboardManager was destroyed with " + String.valueOf(size) + " unhandled redispatch event(s).");
                        }
                        io.flutter.plugin.editing.g gVar = this.f111l;
                        if (gVar != null) {
                            gVar.f661a.f94c = null;
                            SpellCheckerSession spellCheckerSession = gVar.f663c;
                            if (spellCheckerSession != null) {
                                spellCheckerSession.close();
                            }
                        }
                        B.a aVar = this.f109j;
                        if (aVar != null) {
                            ((v) aVar.f5d).f94c = null;
                        }
                        io.flutter.embedding.engine.renderer.j jVar2 = this.f107h.f126b;
                        this.f106g = false;
                        jVar2.f627a.removeIsDisplayingFlutterUiListener(this.f119v);
                        jVar2.b();
                        jVar2.f627a.setSemanticsEnabled(false);
                        View view = this.f104e;
                        if (view != null && this.f103d == this.f102c) {
                            this.f103d = view;
                        }
                        this.f103d.d();
                        C0012m c0012m = this.f102c;
                        if (c0012m != null) {
                            c0012m.f75a.close();
                            removeView(this.f102c);
                            this.f102c = null;
                        }
                        this.f104e = null;
                        this.f107h = null;
                        return;
                    }
                    if (sparseArray5.valueAt(i5) != null) {
                        throw new ClassCastException();
                    }
                    jVar.f708c.removeView(null);
                    i5++;
                }
            } else {
                if (sparseArray3.valueAt(i3) != null) {
                    throw new ClassCastException();
                }
                kVar.f720c.removeView(null);
                i3++;
            }
        }
    }

    @Override // android.view.View
    public final void autofill(SparseArray sparseArray) {
        K.o oVar;
        K.o oVar2;
        CharSequence textValue;
        io.flutter.plugin.editing.k kVar = this.f110k;
        if (Build.VERSION.SDK_INT < 26) {
            kVar.getClass();
            return;
        }
        K.p pVar = kVar.f683f;
        if (pVar == null || kVar.f684g == null || (oVar = pVar.f290j) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            K.p pVar2 = (K.p) kVar.f684g.get(sparseArray.keyAt(i2));
            if (pVar2 != null && (oVar2 = pVar2.f290j) != null) {
                textValue = AbstractC0000a.f(sparseArray.valueAt(i2)).getTextValue();
                String charSequence = textValue.toString();
                K.r rVar = new K.r(charSequence, charSequence.length(), charSequence.length(), -1, -1);
                String str = (String) oVar2.f277a;
                if (str.equals((String) oVar.f277a)) {
                    kVar.f685h.f(rVar);
                } else {
                    hashMap.put(str, rVar);
                }
            }
        }
        int i3 = kVar.f682e.f677b;
        B.a aVar = kVar.f681d;
        aVar.getClass();
        String.valueOf(hashMap.size());
        HashMap hashMap2 = new HashMap();
        for (Map.Entry entry : hashMap.entrySet()) {
            K.r rVar2 = (K.r) entry.getValue();
            hashMap2.put((String) entry.getKey(), B.a.i(rVar2.f296a, rVar2.f297b, rVar2.f298c, -1, -1));
        }
        ((B.e) aVar.f4c).f("TextInputClient.updateEditingStateWithTag", Arrays.asList(Integer.valueOf(i3), hashMap2), null);
    }

    public final void b() {
        C0014o c0014o = this.f100a;
        if (c0014o != null) {
            addView(c0014o);
        } else {
            C0016q c0016q = this.f101b;
            if (c0016q != null) {
                addView(c0016q);
            } else {
                addView(this.f102c);
            }
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(1);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View, io.flutter.embedding.engine.renderer.l] */
    public final boolean c() {
        E.c cVar = this.f107h;
        if (cVar != null) {
            if (cVar.f126b == this.f103d.getAttachedRenderer()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final boolean checkInputConnectionProxy(View view) {
        E.c cVar = this.f107h;
        if (cVar == null) {
            return super.checkInputConnectionProxy(view);
        }
        io.flutter.plugin.platform.k kVar = cVar.f141r;
        if (view == null) {
            kVar.getClass();
            return false;
        }
        HashMap hashMap = kVar.f726i;
        if (!hashMap.containsKey(view.getContext())) {
            return false;
        }
        View view2 = (View) hashMap.get(view.getContext());
        if (view2 == view) {
            return true;
        }
        return view2.checkInputConnectionProxy(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
    
        if (r1 != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D.y.d():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        return (c() && this.f112n.e(keyEvent)) || super.dispatchKeyEvent(keyEvent);
    }

    public final void e() {
        if (!c()) {
            Log.w("FlutterView", "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        float f2 = getResources().getDisplayMetrics().density;
        io.flutter.embedding.engine.renderer.i iVar = this.f117s;
        iVar.f610a = f2;
        iVar.f624p = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        io.flutter.embedding.engine.renderer.j jVar = this.f107h.f126b;
        jVar.getClass();
        if (iVar.f611b <= 0 || iVar.f612c <= 0 || iVar.f610a <= 0.0f) {
            return;
        }
        ArrayList arrayList = iVar.f625q;
        arrayList.size();
        ArrayList arrayList2 = iVar.f626r;
        arrayList2.size();
        int size = arrayList2.size() + arrayList.size();
        int[] iArr = new int[size * 4];
        int[] iArr2 = new int[size];
        int[] iArr3 = new int[size];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            io.flutter.embedding.engine.renderer.c cVar = (io.flutter.embedding.engine.renderer.c) arrayList.get(i2);
            int i3 = i2 * 4;
            Rect rect = cVar.f597a;
            iArr[i3] = rect.left;
            iArr[i3 + 1] = rect.top;
            iArr[i3 + 2] = rect.right;
            iArr[i3 + 3] = rect.bottom;
            iArr2[i2] = n.e.a(cVar.f598b);
            iArr3[i2] = n.e.a(cVar.f599c);
        }
        int size2 = arrayList.size() * 4;
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            io.flutter.embedding.engine.renderer.c cVar2 = (io.flutter.embedding.engine.renderer.c) arrayList2.get(i4);
            int i5 = (i4 * 4) + size2;
            Rect rect2 = cVar2.f597a;
            iArr[i5] = rect2.left;
            iArr[i5 + 1] = rect2.top;
            iArr[i5 + 2] = rect2.right;
            iArr[i5 + 3] = rect2.bottom;
            iArr2[arrayList.size() + i4] = n.e.a(cVar2.f598b);
            iArr3[arrayList.size() + i4] = n.e.a(cVar2.f599c);
        }
        jVar.f627a.setViewportMetrics(iVar.f610a, iVar.f611b, iVar.f612c, iVar.f613d, iVar.f614e, iVar.f615f, iVar.f616g, iVar.f617h, iVar.f618i, iVar.f619j, iVar.f620k, iVar.f621l, iVar.m, iVar.f622n, iVar.f623o, iVar.f624p, iArr, iArr2, iArr3);
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        io.flutter.view.l lVar = this.f114p;
        if (lVar == null || !lVar.f832c.isEnabled()) {
            return null;
        }
        return this.f114p;
    }

    public E.c getAttachedFlutterEngine() {
        return this.f107h;
    }

    public L.e getBinaryMessenger() {
        return this.f107h.f127c;
    }

    public C0012m getCurrentImageSurface() {
        return this.f102c;
    }

    public io.flutter.embedding.engine.renderer.i getViewportMetrics() {
        return this.f117s;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x01b7, code lost:
    
        r1 = r16.getDisplayCutout();
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0146 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0141  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.WindowInsets onApplyWindowInsets(android.view.WindowInsets r16) {
        /*
            Method dump skipped, instructions count: 571
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D.y.onApplyWindowInsets(android.view.WindowInsets):android.view.WindowInsets");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v5, types: [S.i] */
    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        v vVar;
        S.j jVar = S.j.f343b;
        int i2 = 1;
        super.onAttachedToWindow();
        try {
            v.g gVar = v.h.f1197a;
            Context context = getContext();
            gVar.getClass();
            vVar = new v(i2, new B.a(v.g.a(context)));
        } catch (NoClassDefFoundError unused) {
            vVar = null;
        }
        this.f116r = vVar;
        Activity i3 = a.a.i(getContext());
        v vVar2 = this.f116r;
        if (vVar2 == null || i3 == null) {
            return;
        }
        this.f120w = new u(0, this);
        Context context2 = getContext();
        Executor a2 = Build.VERSION.SDK_INT >= 28 ? AbstractC0038a.a(context2) : new j.a(new Handler(context2.getMainLooper()));
        u uVar = this.f120w;
        B.a aVar = (B.a) vVar2.f94c;
        a0.h.e(a2, "executor");
        a0.h.e(uVar, "consumer");
        v.b bVar = (v.b) aVar.f4c;
        bVar.getClass();
        k0.b bVar2 = new k0.b(new v.j(bVar, i3, null), jVar, -2, 1);
        n0.d dVar = AbstractC0064y.f589a;
        i0.c cVar = m0.p.f1027a;
        if (cVar.f(C0057q.f575c) != null) {
            throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + cVar).toString());
        }
        if (!cVar.equals(jVar)) {
            S.i e2 = cVar.e(jVar);
            if (!a0.h.a(e2, jVar)) {
                bVar2 = new k0.b(bVar2.f925f, e2, -2, 1);
            }
        }
        B.a aVar2 = (B.a) aVar.f5d;
        aVar2.getClass();
        ReentrantLock reentrantLock = (ReentrantLock) aVar2.f4c;
        reentrantLock.lock();
        LinkedHashMap linkedHashMap = (LinkedHashMap) aVar2.f5d;
        try {
            if (linkedHashMap.get(uVar) == null) {
                h0.F f2 = new h0.F(a2);
                m0.e eVar = new m0.e(f2.f(C0057q.f575c) != null ? f2 : a.a.q(f2, new h0.N(null)));
                C0101a c0101a = new C0101a(bVar2, uVar, null);
                AbstractC0041a y2 = new Y(AbstractC0059t.f(eVar, jVar), true);
                y2.M(1, y2, c0101a);
                linkedHashMap.put(uVar, y2);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f107h != null) {
            this.m.b(configuration);
            d();
            a.a.b(getContext(), this.f107h);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b1  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo r11) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D.y.onCreateInputConnection(android.view.inputmethod.EditorInfo):android.view.inputmethod.InputConnection");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        u uVar;
        v vVar = this.f116r;
        if (vVar != null && (uVar = this.f120w) != null) {
            B.a aVar = (B.a) ((B.a) vVar.f94c).f5d;
            aVar.getClass();
            ReentrantLock reentrantLock = (ReentrantLock) aVar.f4c;
            reentrantLock.lock();
            LinkedHashMap linkedHashMap = (LinkedHashMap) aVar.f5d;
            try {
                h0.K k2 = (h0.K) linkedHashMap.get(uVar);
                if (k2 != null) {
                    k2.a(null);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        this.f120w = null;
        this.f116r = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (c()) {
            C0001b c0001b = this.f113o;
            Context context = getContext();
            c0001b.getClass();
            boolean isFromSource = motionEvent.isFromSource(2);
            boolean z2 = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
            if (isFromSource && z2) {
                int b2 = C0001b.b(motionEvent.getActionMasked());
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 288);
                allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
                c0001b.a(motionEvent, motionEvent.getActionIndex(), b2, 0, C0001b.f47f, allocateDirect, context);
                if (allocateDirect.position() % 288 != 0) {
                    throw new AssertionError("Packet position is not on field boundary.");
                }
                c0001b.f48a.f627a.dispatchPointerDataPacket(allocateDirect, allocateDirect.position());
                return true;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        return !c() ? super.onHoverEvent(motionEvent) : this.f114p.d(motionEvent, false);
    }

    @Override // android.view.View
    public final void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i2) {
        Rect rect;
        super.onProvideAutofillVirtualStructure(viewStructure, i2);
        io.flutter.plugin.editing.k kVar = this.f110k;
        if (Build.VERSION.SDK_INT < 26) {
            kVar.getClass();
            return;
        }
        if (kVar.f684g != null) {
            String str = (String) kVar.f683f.f290j.f277a;
            AutofillId autofillId = viewStructure.getAutofillId();
            for (int i3 = 0; i3 < kVar.f684g.size(); i3++) {
                int keyAt = kVar.f684g.keyAt(i3);
                K.o oVar = ((K.p) kVar.f684g.valueAt(i3)).f290j;
                if (oVar != null) {
                    viewStructure.addChildCount(1);
                    ViewStructure newChild = viewStructure.newChild(i3);
                    newChild.setAutofillId(autofillId, keyAt);
                    String[] strArr = (String[]) oVar.f279c;
                    if (strArr.length > 0) {
                        newChild.setAutofillHints(strArr);
                    }
                    newChild.setAutofillType(1);
                    newChild.setVisibility(0);
                    String str2 = (String) oVar.f278b;
                    if (str2 != null) {
                        newChild.setHint(str2);
                    }
                    if (str.hashCode() != keyAt || (rect = kVar.m) == null) {
                        newChild.setDimens(0, 0, 0, 0, 1, 1);
                        newChild.setAutofillValue(AutofillValue.forText(((K.r) oVar.f280d).f296a));
                    } else {
                        newChild.setDimens(rect.left, rect.top, 0, 0, rect.width(), kVar.m.height());
                        newChild.setAutofillValue(AutofillValue.forText(kVar.f685h));
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        io.flutter.embedding.engine.renderer.i iVar = this.f117s;
        iVar.f611b = i2;
        iVar.f612c = i3;
        e();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ByteBuffer byteBuffer;
        int i2;
        ByteBuffer byteBuffer2;
        if (!c()) {
            return super.onTouchEvent(motionEvent);
        }
        requestUnbufferedDispatch(motionEvent);
        C0001b c0001b = this.f113o;
        Matrix matrix = C0001b.f47f;
        c0001b.getClass();
        int actionMasked = motionEvent.getActionMasked();
        int b2 = C0001b.b(motionEvent.getActionMasked());
        char c2 = 5;
        boolean z2 = actionMasked == 0 || actionMasked == 5;
        boolean z3 = !z2 && (actionMasked == 1 || actionMasked == 6);
        int toolType = motionEvent.getToolType(motionEvent.getActionIndex());
        if (toolType == 1) {
            c2 = 0;
        } else if (toolType == 2) {
            c2 = 2;
        } else if (toolType == 3) {
            c2 = 1;
        } else if (toolType == 4) {
            c2 = 3;
        }
        int i3 = (z3 && c2 == 0) ? 1 : 0;
        int pointerCount = motionEvent.getPointerCount();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect((pointerCount + i3) * 288);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        if (z2) {
            c0001b.a(motionEvent, motionEvent.getActionIndex(), b2, 0, matrix, allocateDirect, null);
            byteBuffer = allocateDirect;
        } else if (z3) {
            int i4 = 0;
            while (i4 < pointerCount) {
                if (i4 == motionEvent.getActionIndex() || motionEvent.getToolType(i4) != 1) {
                    i2 = i4;
                    byteBuffer2 = allocateDirect;
                } else {
                    i2 = i4;
                    byteBuffer2 = allocateDirect;
                    c0001b.a(motionEvent, i4, 5, 1, matrix, allocateDirect, null);
                }
                i4 = i2 + 1;
                allocateDirect = byteBuffer2;
            }
            byteBuffer = allocateDirect;
            c0001b.a(motionEvent, motionEvent.getActionIndex(), b2, 0, matrix, byteBuffer, null);
            if (i3 != 0) {
                c0001b.a(motionEvent, motionEvent.getActionIndex(), 2, 0, matrix, byteBuffer, null);
            }
        } else {
            byteBuffer = allocateDirect;
            for (int i5 = 0; i5 < pointerCount; i5++) {
                c0001b.a(motionEvent, i5, b2, 0, matrix, byteBuffer, null);
            }
        }
        if (byteBuffer.position() % 288 != 0) {
            throw new AssertionError("Packet position is not on field boundary");
        }
        c0001b.f48a.f627a.dispatchPointerDataPacket(byteBuffer, byteBuffer.position());
        return true;
    }

    public void setDelegate(B b2) {
        this.f121x = b2;
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        View view = this.f103d;
        if (view instanceof C0014o) {
            ((C0014o) view).setVisibility(i2);
        }
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object, java.util.List] */
    public void setWindowInfoListenerDisplayFeatures(v.k kVar) {
        ?? r8 = kVar.f1204a;
        ArrayList arrayList = new ArrayList();
        for (v.c cVar : r8) {
            cVar.f1185a.c().toString();
            C0092b c0092b = cVar.f1185a;
            int b2 = c0092b.b();
            v.b bVar = v.b.f1178e;
            int i2 = 2;
            int i3 = ((b2 == 0 || c0092b.a() == 0) ? v.b.f1177d : bVar) == bVar ? 3 : 2;
            v.b bVar2 = v.b.f1179f;
            v.b bVar3 = cVar.f1187c;
            if (bVar3 != bVar2) {
                i2 = bVar3 == v.b.f1180g ? 3 : 1;
            }
            arrayList.add(new io.flutter.embedding.engine.renderer.c(c0092b.c(), i3, i2));
        }
        ArrayList arrayList2 = this.f117s.f625q;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        e();
    }

    public y(AbstractActivityC0005f abstractActivityC0005f, C0016q c0016q) {
        super(abstractActivityC0005f, null);
        this.f105f = new HashSet();
        this.f108i = new HashSet();
        this.f117s = new io.flutter.embedding.engine.renderer.i();
        this.f118t = new v(0, this);
        this.u = new w(this, new Handler(Looper.getMainLooper()), 0);
        this.f119v = new C0006g(2, this);
        this.f121x = new B();
        this.f101b = c0016q;
        this.f103d = c0016q;
        b();
    }
}
