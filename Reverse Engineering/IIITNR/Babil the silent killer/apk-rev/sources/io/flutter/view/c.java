package io.flutter.view;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LocaleSpan;
import android.text.style.TtsSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import io.flutter.view.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import v.a;

/* loaded from: classes.dex */
public class c extends AccessibilityNodeProvider {

    /* renamed from: a, reason: collision with root package name */
    private final View f579a;

    /* renamed from: b, reason: collision with root package name */
    private final v.a f580b;

    /* renamed from: c, reason: collision with root package name */
    private final AccessibilityManager f581c;

    /* renamed from: d, reason: collision with root package name */
    private final AccessibilityViewEmbedder f582d;

    /* renamed from: e, reason: collision with root package name */
    private final io.flutter.plugin.platform.j f583e;

    /* renamed from: f, reason: collision with root package name */
    private final ContentResolver f584f;

    /* renamed from: g, reason: collision with root package name */
    private final Map<Integer, l> f585g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<Integer, h> f586h;

    /* renamed from: i, reason: collision with root package name */
    private l f587i;

    /* renamed from: j, reason: collision with root package name */
    private Integer f588j;

    /* renamed from: k, reason: collision with root package name */
    private Integer f589k;

    /* renamed from: l, reason: collision with root package name */
    private int f590l;

    /* renamed from: m, reason: collision with root package name */
    private l f591m;

    /* renamed from: n, reason: collision with root package name */
    private l f592n;

    /* renamed from: o, reason: collision with root package name */
    private l f593o;

    /* renamed from: p, reason: collision with root package name */
    private final List<Integer> f594p;

    /* renamed from: q, reason: collision with root package name */
    private int f595q;

    /* renamed from: r, reason: collision with root package name */
    private Integer f596r;

    /* renamed from: s, reason: collision with root package name */
    private k f597s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f598t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f599u;

    /* renamed from: v, reason: collision with root package name */
    private final a.b f600v;

    /* renamed from: w, reason: collision with root package name */
    private final AccessibilityManager.AccessibilityStateChangeListener f601w;

    /* renamed from: x, reason: collision with root package name */
    @TargetApi(19)
    private final AccessibilityManager.TouchExplorationStateChangeListener f602x;

    /* renamed from: y, reason: collision with root package name */
    private final ContentObserver f603y;

    /* renamed from: z, reason: collision with root package name */
    private static final int f578z = ((g.SCROLL_RIGHT.f641d | g.SCROLL_LEFT.f641d) | g.SCROLL_UP.f641d) | g.SCROLL_DOWN.f641d;
    private static final int A = ((((((((((i.HAS_CHECKED_STATE.f669d | i.IS_CHECKED.f669d) | i.IS_SELECTED.f669d) | i.IS_TEXT_FIELD.f669d) | i.IS_FOCUSED.f669d) | i.HAS_ENABLED_STATE.f669d) | i.IS_ENABLED.f669d) | i.IS_IN_MUTUALLY_EXCLUSIVE_GROUP.f669d) | i.HAS_TOGGLED_STATE.f669d) | i.IS_TOGGLED.f669d) | i.IS_FOCUSABLE.f669d) | i.IS_SLIDER.f669d;
    private static int B = 267386881;

    class a implements a.b {
        a() {
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.a
        public void a(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            for (ByteBuffer byteBuffer2 : byteBufferArr) {
                byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
            }
            c.this.b0(byteBuffer, strArr, byteBufferArr);
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.a
        public void b(ByteBuffer byteBuffer, String[] strArr) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            c.this.a0(byteBuffer, strArr);
        }

        @Override // v.a.b
        public void c(String str) {
            if (Build.VERSION.SDK_INT >= 28) {
                return;
            }
            AccessibilityEvent H = c.this.H(0, 32);
            H.getText().add(str);
            c.this.S(H);
        }

        @Override // v.a.b
        public void d(int i2) {
            c.this.R(i2, 2);
        }

        @Override // v.a.b
        public void e(int i2) {
            c.this.R(i2, 1);
        }

        @Override // v.a.b
        public void f(String str) {
            c.this.f579a.announceForAccessibility(str);
        }
    }

    class b implements AccessibilityManager.AccessibilityStateChangeListener {
        b() {
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean z2) {
            if (c.this.f599u) {
                return;
            }
            c cVar = c.this;
            if (z2) {
                cVar.f580b.g(c.this.f600v);
                c.this.f580b.e();
            } else {
                cVar.W(false);
                c.this.f580b.g(null);
                c.this.f580b.d();
            }
            if (c.this.f597s != null) {
                c.this.f597s.a(z2, c.this.f581c.isTouchExplorationEnabled());
            }
        }
    }

    /* renamed from: io.flutter.view.c$c, reason: collision with other inner class name */
    class C0014c extends ContentObserver {
        C0014c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z2) {
            onChange(z2, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z2, Uri uri) {
            if (c.this.f599u) {
                return;
            }
            String string = Build.VERSION.SDK_INT < 17 ? null : Settings.Global.getString(c.this.f584f, "transition_animation_scale");
            if (string != null && string.equals("0")) {
                c.g(c.this, f.DISABLE_ANIMATIONS.f618d);
            } else {
                c.f(c.this, f.DISABLE_ANIMATIONS.f618d ^ (-1));
            }
            c.this.T();
        }
    }

    class d implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AccessibilityManager f607a;

        d(AccessibilityManager accessibilityManager) {
            this.f607a = accessibilityManager;
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z2) {
            if (c.this.f599u) {
                return;
            }
            if (!z2) {
                c.this.W(false);
                c.this.L();
            }
            if (c.this.f597s != null) {
                c.this.f597s.a(this.f607a.isEnabled(), z2);
            }
        }
    }

    static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f609a;

        static {
            int[] iArr = new int[o.values().length];
            f609a = iArr;
            try {
                iArr[o.SPELLOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f609a[o.LOCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private enum f {
        ACCESSIBLE_NAVIGATION(1),
        INVERT_COLORS(2),
        DISABLE_ANIMATIONS(4),
        BOLD_TEXT(8),
        REDUCE_MOTION(16),
        HIGH_CONTRAST(32),
        ON_OFF_SWITCH_LABELS(64);


        /* renamed from: d, reason: collision with root package name */
        final int f618d;

        f(int i2) {
            this.f618d = i2;
        }
    }

    public enum g {
        TAP(1),
        LONG_PRESS(2),
        SCROLL_LEFT(4),
        SCROLL_RIGHT(8),
        SCROLL_UP(16),
        SCROLL_DOWN(32),
        INCREASE(64),
        DECREASE(128),
        SHOW_ON_SCREEN(256),
        MOVE_CURSOR_FORWARD_BY_CHARACTER(512),
        MOVE_CURSOR_BACKWARD_BY_CHARACTER(1024),
        SET_SELECTION(2048),
        COPY(4096),
        CUT(8192),
        PASTE(16384),
        DID_GAIN_ACCESSIBILITY_FOCUS(32768),
        DID_LOSE_ACCESSIBILITY_FOCUS(65536),
        CUSTOM_ACTION(131072),
        DISMISS(262144),
        MOVE_CURSOR_FORWARD_BY_WORD(524288),
        MOVE_CURSOR_BACKWARD_BY_WORD(1048576),
        SET_TEXT(2097152);


        /* renamed from: d, reason: collision with root package name */
        public final int f641d;

        g(int i2) {
            this.f641d = i2;
        }
    }

    private static class h {

        /* renamed from: a, reason: collision with root package name */
        private int f642a = -1;

        /* renamed from: b, reason: collision with root package name */
        private int f643b = -1;

        /* renamed from: c, reason: collision with root package name */
        private int f644c = -1;

        /* renamed from: d, reason: collision with root package name */
        private String f645d;

        /* renamed from: e, reason: collision with root package name */
        private String f646e;

        h() {
        }
    }

    enum i {
        HAS_CHECKED_STATE(1),
        IS_CHECKED(2),
        IS_SELECTED(4),
        IS_BUTTON(8),
        IS_TEXT_FIELD(16),
        IS_FOCUSED(32),
        HAS_ENABLED_STATE(64),
        IS_ENABLED(128),
        IS_IN_MUTUALLY_EXCLUSIVE_GROUP(256),
        IS_HEADER(512),
        IS_OBSCURED(1024),
        SCOPES_ROUTE(2048),
        NAMES_ROUTE(4096),
        IS_HIDDEN(8192),
        IS_IMAGE(16384),
        IS_LIVE_REGION(32768),
        HAS_TOGGLED_STATE(65536),
        IS_TOGGLED(131072),
        HAS_IMPLICIT_SCROLLING(262144),
        IS_MULTILINE(524288),
        IS_READ_ONLY(1048576),
        IS_FOCUSABLE(2097152),
        IS_LINK(4194304),
        IS_SLIDER(8388608),
        IS_KEYBOARD_KEY(16777216),
        IS_CHECK_STATE_MIXED(33554432);


        /* renamed from: d, reason: collision with root package name */
        final int f669d;

        i(int i2) {
            this.f669d = i2;
        }
    }

    private static class j extends n {

        /* renamed from: d, reason: collision with root package name */
        String f670d;

        private j() {
            super(null);
        }

        /* synthetic */ j(a aVar) {
            this();
        }
    }

    public interface k {
        void a(boolean z2, boolean z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class l {
        private p A;
        private int C;
        private int D;
        private int E;
        private int F;
        private float G;
        private float H;
        private float I;
        private String J;
        private String K;
        private float L;
        private float M;
        private float N;
        private float O;
        private float[] P;
        private l Q;
        private List<h> T;
        private h U;
        private h V;
        private float[] X;
        private float[] Z;

        /* renamed from: a, reason: collision with root package name */
        final c f671a;

        /* renamed from: a0, reason: collision with root package name */
        private Rect f672a0;

        /* renamed from: c, reason: collision with root package name */
        private int f674c;

        /* renamed from: d, reason: collision with root package name */
        private int f675d;

        /* renamed from: e, reason: collision with root package name */
        private int f676e;

        /* renamed from: f, reason: collision with root package name */
        private int f677f;

        /* renamed from: g, reason: collision with root package name */
        private int f678g;

        /* renamed from: h, reason: collision with root package name */
        private int f679h;

        /* renamed from: i, reason: collision with root package name */
        private int f680i;

        /* renamed from: j, reason: collision with root package name */
        private int f681j;

        /* renamed from: k, reason: collision with root package name */
        private int f682k;

        /* renamed from: l, reason: collision with root package name */
        private float f683l;

        /* renamed from: m, reason: collision with root package name */
        private float f684m;

        /* renamed from: n, reason: collision with root package name */
        private float f685n;

        /* renamed from: o, reason: collision with root package name */
        private String f686o;

        /* renamed from: p, reason: collision with root package name */
        private List<n> f687p;

        /* renamed from: q, reason: collision with root package name */
        private String f688q;

        /* renamed from: r, reason: collision with root package name */
        private List<n> f689r;

        /* renamed from: s, reason: collision with root package name */
        private String f690s;

        /* renamed from: t, reason: collision with root package name */
        private List<n> f691t;

        /* renamed from: u, reason: collision with root package name */
        private String f692u;

        /* renamed from: v, reason: collision with root package name */
        private List<n> f693v;

        /* renamed from: w, reason: collision with root package name */
        private String f694w;

        /* renamed from: x, reason: collision with root package name */
        private List<n> f695x;

        /* renamed from: y, reason: collision with root package name */
        private String f696y;

        /* renamed from: b, reason: collision with root package name */
        private int f673b = -1;

        /* renamed from: z, reason: collision with root package name */
        private int f697z = -1;
        private boolean B = false;
        private List<l> R = new ArrayList();
        private List<l> S = new ArrayList();
        private boolean W = true;
        private boolean Y = true;

        l(c cVar) {
            this.f671a = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean A0(l lVar, z.d<l> dVar) {
            return (lVar == null || lVar.j0(dVar) == null) ? false : true;
        }

        private void B0(float[] fArr, float[] fArr2, float[] fArr3) {
            Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
            float f2 = fArr[3];
            fArr[0] = fArr[0] / f2;
            fArr[1] = fArr[1] / f2;
            fArr[2] = fArr[2] / f2;
            fArr[3] = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C0(float[] fArr, Set<l> set, boolean z2) {
            set.add(this);
            if (this.Y) {
                z2 = true;
            }
            if (z2) {
                if (this.Z == null) {
                    this.Z = new float[16];
                }
                if (this.P == null) {
                    this.P = new float[16];
                }
                Matrix.multiplyMM(this.Z, 0, fArr, 0, this.P, 0);
                float[] fArr2 = {this.L, this.M, 0.0f, 1.0f};
                float[] fArr3 = new float[4];
                float[] fArr4 = new float[4];
                float[] fArr5 = new float[4];
                float[] fArr6 = new float[4];
                B0(fArr3, this.Z, fArr2);
                fArr2[0] = this.N;
                fArr2[1] = this.M;
                B0(fArr4, this.Z, fArr2);
                fArr2[0] = this.N;
                fArr2[1] = this.O;
                B0(fArr5, this.Z, fArr2);
                fArr2[0] = this.L;
                fArr2[1] = this.O;
                B0(fArr6, this.Z, fArr2);
                if (this.f672a0 == null) {
                    this.f672a0 = new Rect();
                }
                this.f672a0.set(Math.round(z0(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(z0(fArr3[1], fArr4[1], fArr5[1], fArr6[1])), Math.round(y0(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(y0(fArr3[1], fArr4[1], fArr5[1], fArr6[1])));
                this.Y = false;
            }
            int i2 = -1;
            for (l lVar : this.R) {
                lVar.f697z = i2;
                i2 = lVar.f673b;
                lVar.C0(this.Z, set, z2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D0(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
            this.B = true;
            this.J = this.f688q;
            this.K = this.f686o;
            this.C = this.f674c;
            this.D = this.f675d;
            this.E = this.f678g;
            this.F = this.f679h;
            this.G = this.f683l;
            this.H = this.f684m;
            this.I = this.f685n;
            this.f674c = byteBuffer.getInt();
            this.f675d = byteBuffer.getInt();
            this.f676e = byteBuffer.getInt();
            this.f677f = byteBuffer.getInt();
            this.f678g = byteBuffer.getInt();
            this.f679h = byteBuffer.getInt();
            this.f680i = byteBuffer.getInt();
            this.f681j = byteBuffer.getInt();
            this.f682k = byteBuffer.getInt();
            this.f683l = byteBuffer.getFloat();
            this.f684m = byteBuffer.getFloat();
            this.f685n = byteBuffer.getFloat();
            int i2 = byteBuffer.getInt();
            this.f686o = i2 == -1 ? null : strArr[i2];
            this.f687p = o0(byteBuffer, byteBufferArr);
            int i3 = byteBuffer.getInt();
            this.f688q = i3 == -1 ? null : strArr[i3];
            this.f689r = o0(byteBuffer, byteBufferArr);
            int i4 = byteBuffer.getInt();
            this.f690s = i4 == -1 ? null : strArr[i4];
            this.f691t = o0(byteBuffer, byteBufferArr);
            int i5 = byteBuffer.getInt();
            this.f692u = i5 == -1 ? null : strArr[i5];
            this.f693v = o0(byteBuffer, byteBufferArr);
            int i6 = byteBuffer.getInt();
            this.f694w = i6 == -1 ? null : strArr[i6];
            this.f695x = o0(byteBuffer, byteBufferArr);
            int i7 = byteBuffer.getInt();
            this.f696y = i7 == -1 ? null : strArr[i7];
            this.A = p.a(byteBuffer.getInt());
            this.L = byteBuffer.getFloat();
            this.M = byteBuffer.getFloat();
            this.N = byteBuffer.getFloat();
            this.O = byteBuffer.getFloat();
            if (this.P == null) {
                this.P = new float[16];
            }
            for (int i8 = 0; i8 < 16; i8++) {
                this.P[i8] = byteBuffer.getFloat();
            }
            this.W = true;
            this.Y = true;
            int i9 = byteBuffer.getInt();
            this.R.clear();
            this.S.clear();
            for (int i10 = 0; i10 < i9; i10++) {
                l A = this.f671a.A(byteBuffer.getInt());
                A.Q = this;
                this.R.add(A);
            }
            for (int i11 = 0; i11 < i9; i11++) {
                l A2 = this.f671a.A(byteBuffer.getInt());
                A2.Q = this;
                this.S.add(A2);
            }
            int i12 = byteBuffer.getInt();
            if (i12 == 0) {
                this.T = null;
                return;
            }
            List<h> list = this.T;
            if (list == null) {
                this.T = new ArrayList(i12);
            } else {
                list.clear();
            }
            for (int i13 = 0; i13 < i12; i13++) {
                h z2 = this.f671a.z(byteBuffer.getInt());
                if (z2.f644c == g.TAP.f641d) {
                    this.U = z2;
                } else if (z2.f644c == g.LONG_PRESS.f641d) {
                    this.V = z2;
                } else {
                    this.T.add(z2);
                }
                this.T.add(z2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e0(List<l> list) {
            if (v0(i.SCOPES_ROUTE)) {
                list.add(this);
            }
            Iterator<l> it = this.R.iterator();
            while (it.hasNext()) {
                it.next().e0(list);
            }
        }

        @TargetApi(21)
        private SpannableString f0(String str, List<n> list) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            if (list != null) {
                for (n nVar : list) {
                    int i2 = e.f609a[nVar.f700c.ordinal()];
                    if (i2 == 1) {
                        spannableString.setSpan(new TtsSpan.Builder("android.type.verbatim").build(), nVar.f698a, nVar.f699b, 0);
                    } else if (i2 == 2) {
                        spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag(((j) nVar).f670d)), nVar.f698a, nVar.f699b, 0);
                    }
                }
            }
            return spannableString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean g0() {
            String str;
            String str2 = this.f686o;
            if (str2 == null && this.K == null) {
                return false;
            }
            return str2 == null || (str = this.K) == null || !str2.equals(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean h0() {
            return (Float.isNaN(this.f683l) || Float.isNaN(this.G) || this.G == this.f683l) ? false : true;
        }

        private void i0() {
            if (this.W) {
                this.W = false;
                if (this.X == null) {
                    this.X = new float[16];
                }
                if (Matrix.invertM(this.X, 0, this.P, 0)) {
                    return;
                }
                Arrays.fill(this.X, 0.0f);
            }
        }

        private l j0(z.d<l> dVar) {
            for (l lVar = this.Q; lVar != null; lVar = lVar.Q) {
                if (dVar.test(lVar)) {
                    return lVar;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Rect k0() {
            return this.f672a0;
        }

        private CharSequence l0() {
            return Build.VERSION.SDK_INT < 21 ? this.f694w : f0(this.f694w, this.f695x);
        }

        static /* synthetic */ int m(l lVar, int i2) {
            int i3 = lVar.f679h + i2;
            lVar.f679h = i3;
            return i3;
        }

        private CharSequence m0() {
            return Build.VERSION.SDK_INT < 21 ? this.f686o : f0(this.f686o, this.f687p);
        }

        static /* synthetic */ int n(l lVar, int i2) {
            int i3 = lVar.f679h - i2;
            lVar.f679h = i3;
            return i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String n0() {
            String str;
            if (v0(i.NAMES_ROUTE) && (str = this.f686o) != null && !str.isEmpty()) {
                return this.f686o;
            }
            Iterator<l> it = this.R.iterator();
            while (it.hasNext()) {
                String n02 = it.next().n0();
                if (n02 != null && !n02.isEmpty()) {
                    return n02;
                }
            }
            return null;
        }

        private List<n> o0(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
            int i2 = byteBuffer.getInt();
            a aVar = null;
            if (i2 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = byteBuffer.getInt();
                int i5 = byteBuffer.getInt();
                o oVar = o.values()[byteBuffer.getInt()];
                int i6 = e.f609a[oVar.ordinal()];
                if (i6 == 1) {
                    byteBuffer.getInt();
                    m mVar = new m(aVar);
                    mVar.f698a = i4;
                    mVar.f699b = i5;
                    mVar.f700c = oVar;
                    arrayList.add(mVar);
                } else if (i6 == 2) {
                    ByteBuffer byteBuffer2 = byteBufferArr[byteBuffer.getInt()];
                    j jVar = new j(aVar);
                    jVar.f698a = i4;
                    jVar.f699b = i5;
                    jVar.f700c = oVar;
                    jVar.f670d = Charset.forName("UTF-8").decode(byteBuffer2).toString();
                    arrayList.add(jVar);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence p0() {
            CharSequence[] charSequenceArr = {m0(), l0()};
            CharSequence charSequence = null;
            for (int i2 = 0; i2 < 2; i2++) {
                CharSequence charSequence2 = charSequenceArr[i2];
                if (charSequence2 != null && charSequence2.length() > 0) {
                    charSequence = (charSequence == null || charSequence.length() == 0) ? charSequence2 : TextUtils.concat(charSequence, ", ", charSequence2);
                }
            }
            return charSequence;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence q0() {
            return Build.VERSION.SDK_INT < 21 ? this.f688q : f0(this.f688q, this.f689r);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence r0() {
            CharSequence[] charSequenceArr = {q0(), m0(), l0()};
            CharSequence charSequence = null;
            for (int i2 = 0; i2 < 3; i2++) {
                CharSequence charSequence2 = charSequenceArr[i2];
                if (charSequence2 != null && charSequence2.length() > 0) {
                    charSequence = (charSequence == null || charSequence.length() == 0) ? charSequence2 : TextUtils.concat(charSequence, ", ", charSequence2);
                }
            }
            return charSequence;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean s0(g gVar) {
            return (gVar.f641d & this.D) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean t0(i iVar) {
            return (iVar.f669d & this.C) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean u0(g gVar) {
            return (gVar.f641d & this.f675d) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean v0(i iVar) {
            return (iVar.f669d & this.f674c) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public l w0(float[] fArr, boolean z2) {
            float f2 = fArr[3];
            boolean z3 = false;
            float f3 = fArr[0] / f2;
            float f4 = fArr[1] / f2;
            if (f3 < this.L || f3 >= this.N || f4 < this.M || f4 >= this.O) {
                return null;
            }
            float[] fArr2 = new float[4];
            for (l lVar : this.S) {
                if (!lVar.v0(i.IS_HIDDEN)) {
                    lVar.i0();
                    Matrix.multiplyMV(fArr2, 0, lVar.X, 0, fArr, 0);
                    l w0 = lVar.w0(fArr2, z2);
                    if (w0 != null) {
                        return w0;
                    }
                }
            }
            if (z2 && this.f680i != -1) {
                z3 = true;
            }
            if (x0() || z3) {
                return this;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean x0() {
            String str;
            String str2;
            String str3;
            if (v0(i.SCOPES_ROUTE)) {
                return false;
            }
            return (!v0(i.IS_FOCUSABLE) && (this.f675d & (c.f578z ^ (-1))) == 0 && (this.f674c & c.A) == 0 && ((str = this.f686o) == null || str.isEmpty()) && (((str2 = this.f688q) == null || str2.isEmpty()) && ((str3 = this.f694w) == null || str3.isEmpty()))) ? false : true;
        }

        private float y0(float f2, float f3, float f4, float f5) {
            return Math.max(f2, Math.max(f3, Math.max(f4, f5)));
        }

        private float z0(float f2, float f3, float f4, float f5) {
            return Math.min(f2, Math.min(f3, Math.min(f4, f5)));
        }
    }

    private static class m extends n {
        private m() {
            super(null);
        }

        /* synthetic */ m(a aVar) {
            this();
        }
    }

    private static class n {

        /* renamed from: a, reason: collision with root package name */
        int f698a;

        /* renamed from: b, reason: collision with root package name */
        int f699b;

        /* renamed from: c, reason: collision with root package name */
        o f700c;

        private n() {
        }

        /* synthetic */ n(a aVar) {
            this();
        }
    }

    private enum o {
        SPELLOUT,
        LOCALE
    }

    private enum p {
        UNKNOWN,
        LTR,
        RTL;

        public static p a(int i2) {
            return i2 != 1 ? i2 != 2 ? UNKNOWN : LTR : RTL;
        }
    }

    public c(View view, v.a aVar, AccessibilityManager accessibilityManager, ContentResolver contentResolver, io.flutter.plugin.platform.j jVar) {
        this(view, aVar, accessibilityManager, contentResolver, new AccessibilityViewEmbedder(view, 65536), jVar);
    }

    public c(View view, v.a aVar, AccessibilityManager accessibilityManager, ContentResolver contentResolver, AccessibilityViewEmbedder accessibilityViewEmbedder, io.flutter.plugin.platform.j jVar) {
        this.f585g = new HashMap();
        this.f586h = new HashMap();
        this.f590l = 0;
        this.f594p = new ArrayList();
        this.f595q = 0;
        this.f596r = 0;
        this.f598t = false;
        this.f599u = false;
        this.f600v = new a();
        b bVar = new b();
        this.f601w = bVar;
        C0014c c0014c = new C0014c(new Handler());
        this.f603y = c0014c;
        this.f579a = view;
        this.f580b = aVar;
        this.f581c = accessibilityManager;
        this.f584f = contentResolver;
        this.f582d = accessibilityViewEmbedder;
        this.f583e = jVar;
        bVar.onAccessibilityStateChanged(accessibilityManager.isEnabled());
        accessibilityManager.addAccessibilityStateChangeListener(bVar);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            d dVar = new d(accessibilityManager);
            this.f602x = dVar;
            dVar.onTouchExplorationStateChanged(accessibilityManager.isTouchExplorationEnabled());
            accessibilityManager.addTouchExplorationStateChangeListener(dVar);
        } else {
            this.f602x = null;
        }
        if (i2 >= 17) {
            c0014c.onChange(false);
            contentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, c0014c);
        }
        if (i2 >= 31) {
            X();
        }
        jVar.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l A(int i2) {
        l lVar = this.f585g.get(Integer.valueOf(i2));
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this);
        lVar2.f673b = i2;
        this.f585g.put(Integer.valueOf(i2), lVar2);
        return lVar2;
    }

    private l B() {
        return this.f585g.get(0);
    }

    private void C(float f2, float f3, boolean z2) {
        l w0;
        if (this.f585g.isEmpty() || (w0 = B().w0(new float[]{f2, f3, 0.0f, 1.0f}, z2)) == this.f593o) {
            return;
        }
        if (w0 != null) {
            R(w0.f673b, 128);
        }
        l lVar = this.f593o;
        if (lVar != null) {
            R(lVar.f673b, 256);
        }
        this.f593o = w0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean F(l lVar, l lVar2) {
        return lVar2 == lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean G(l lVar) {
        return lVar.v0(i.HAS_IMPLICIT_SCROLLING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AccessibilityEvent H(int i2, int i3) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
        obtain.setPackageName(this.f579a.getContext().getPackageName());
        obtain.setSource(this.f579a, i2);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        l lVar = this.f593o;
        if (lVar != null) {
            R(lVar.f673b, 256);
            this.f593o = null;
        }
    }

    private void M(l lVar) {
        String n02 = lVar.n0();
        if (n02 == null) {
            n02 = " ";
        }
        if (Build.VERSION.SDK_INT >= 28) {
            V(n02);
            return;
        }
        AccessibilityEvent H = H(lVar.f673b, 32);
        H.getText().add(n02);
        S(H);
    }

    @TargetApi(18)
    private boolean N(l lVar, int i2, Bundle bundle, boolean z2) {
        int i3 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        boolean z3 = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        int i4 = lVar.f678g;
        int i5 = lVar.f679h;
        P(lVar, i3, z2, z3);
        if (i4 != lVar.f678g || i5 != lVar.f679h) {
            String str = lVar.f688q != null ? lVar.f688q : "";
            AccessibilityEvent H = H(lVar.f673b, 8192);
            H.getText().add(str);
            H.setFromIndex(lVar.f678g);
            H.setToIndex(lVar.f679h);
            H.setItemCount(str.length());
            S(H);
        }
        if (i3 == 1) {
            if (z2) {
                g gVar = g.MOVE_CURSOR_FORWARD_BY_CHARACTER;
                if (lVar.u0(gVar)) {
                    this.f580b.c(i2, gVar, Boolean.valueOf(z3));
                    return true;
                }
            }
            if (z2) {
                return false;
            }
            g gVar2 = g.MOVE_CURSOR_BACKWARD_BY_CHARACTER;
            if (!lVar.u0(gVar2)) {
                return false;
            }
            this.f580b.c(i2, gVar2, Boolean.valueOf(z3));
            return true;
        }
        if (i3 != 2) {
            return i3 == 4 || i3 == 8 || i3 == 16;
        }
        if (z2) {
            g gVar3 = g.MOVE_CURSOR_FORWARD_BY_WORD;
            if (lVar.u0(gVar3)) {
                this.f580b.c(i2, gVar3, Boolean.valueOf(z3));
                return true;
            }
        }
        if (z2) {
            return false;
        }
        g gVar4 = g.MOVE_CURSOR_BACKWARD_BY_WORD;
        if (!lVar.u0(gVar4)) {
            return false;
        }
        this.f580b.c(i2, gVar4, Boolean.valueOf(z3));
        return true;
    }

    @TargetApi(21)
    private boolean O(l lVar, int i2, Bundle bundle) {
        String string = (bundle == null || !bundle.containsKey("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE")) ? "" : bundle.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
        this.f580b.c(i2, g.SET_TEXT, string);
        lVar.f688q = string;
        lVar.f689r = null;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0022, code lost:
    
        if (r6 != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0024, code lost:
    
        r5 = r4.f688q.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002c, code lost:
    
        r4.f679h = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0031, code lost:
    
        r4.f679h = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
    
        if (r5.find() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        io.flutter.view.c.l.m(r4, r5.start(1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008d, code lost:
    
        if (r5.find() != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008f, code lost:
    
        r5 = r5.start(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c1, code lost:
    
        if (r5.find() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e6, code lost:
    
        if (r5.find() != false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void P(io.flutter.view.c.l r4, int r5, boolean r6, boolean r7) {
        /*
            r3 = this;
            int r0 = io.flutter.view.c.l.k(r4)
            if (r0 < 0) goto L111
            int r0 = io.flutter.view.c.l.i(r4)
            if (r0 >= 0) goto Le
            goto L111
        Le:
            r0 = 1
            if (r5 == r0) goto Le9
            r1 = 2
            r2 = 0
            if (r5 == r1) goto L94
            r1 = 4
            if (r5 == r1) goto L36
            r0 = 8
            if (r5 == r0) goto L22
            r0 = 16
            if (r5 == r0) goto L22
            goto L108
        L22:
            if (r6 == 0) goto L31
        L24:
            java.lang.String r5 = io.flutter.view.c.l.q(r4)
            int r5 = r5.length()
        L2c:
            io.flutter.view.c.l.l(r4, r5)
            goto L108
        L31:
            io.flutter.view.c.l.l(r4, r2)
            goto L108
        L36:
            if (r6 == 0) goto L6b
            int r5 = io.flutter.view.c.l.k(r4)
            java.lang.String r1 = io.flutter.view.c.l.q(r4)
            int r1 = r1.length()
            if (r5 >= r1) goto L6b
            java.lang.String r5 = "(?!^)(\\n)"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = io.flutter.view.c.l.q(r4)
            int r1 = io.flutter.view.c.l.k(r4)
            java.lang.String r6 = r6.substring(r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            boolean r6 = r5.find()
            if (r6 == 0) goto L24
        L62:
            int r5 = r5.start(r0)
            io.flutter.view.c.l.m(r4, r5)
            goto L108
        L6b:
            if (r6 != 0) goto L108
            int r5 = io.flutter.view.c.l.k(r4)
            if (r5 <= 0) goto L108
            java.lang.String r5 = "(?s:.*)(\\n)"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = io.flutter.view.c.l.q(r4)
            int r1 = io.flutter.view.c.l.k(r4)
            java.lang.String r6 = r6.substring(r2, r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            boolean r6 = r5.find()
            if (r6 == 0) goto L31
        L8f:
            int r5 = r5.start(r0)
            goto L2c
        L94:
            if (r6 == 0) goto Lc4
            int r5 = io.flutter.view.c.l.k(r4)
            java.lang.String r1 = io.flutter.view.c.l.q(r4)
            int r1 = r1.length()
            if (r5 >= r1) goto Lc4
            java.lang.String r5 = "\\p{L}(\\b)"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = io.flutter.view.c.l.q(r4)
            int r1 = io.flutter.view.c.l.k(r4)
            java.lang.String r6 = r6.substring(r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            r5.find()
            boolean r6 = r5.find()
            if (r6 == 0) goto L24
            goto L62
        Lc4:
            if (r6 != 0) goto L108
            int r5 = io.flutter.view.c.l.k(r4)
            if (r5 <= 0) goto L108
            java.lang.String r5 = "(?s:.*)(\\b)\\p{L}"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = io.flutter.view.c.l.q(r4)
            int r1 = io.flutter.view.c.l.k(r4)
            java.lang.String r6 = r6.substring(r2, r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            boolean r6 = r5.find()
            if (r6 == 0) goto L108
            goto L8f
        Le9:
            if (r6 == 0) goto Lfd
            int r5 = io.flutter.view.c.l.k(r4)
            java.lang.String r1 = io.flutter.view.c.l.q(r4)
            int r1 = r1.length()
            if (r5 >= r1) goto Lfd
            io.flutter.view.c.l.m(r4, r0)
            goto L108
        Lfd:
            if (r6 != 0) goto L108
            int r5 = io.flutter.view.c.l.k(r4)
            if (r5 <= 0) goto L108
            io.flutter.view.c.l.n(r4, r0)
        L108:
            if (r7 != 0) goto L111
            int r5 = io.flutter.view.c.l.k(r4)
            io.flutter.view.c.l.j(r4, r5)
        L111:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.c.P(io.flutter.view.c$l, int, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i2, int i3) {
        if (this.f581c.isEnabled()) {
            S(H(i2, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(AccessibilityEvent accessibilityEvent) {
        if (this.f581c.isEnabled()) {
            this.f579a.getParent().requestSendAccessibilityEvent(this.f579a, accessibilityEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        this.f580b.f(this.f590l);
    }

    private void U(int i2) {
        AccessibilityEvent H = H(i2, 2048);
        if (Build.VERSION.SDK_INT >= 19) {
            H.setContentChangeTypes(1);
        }
        S(H);
    }

    @TargetApi(28)
    private void V(String str) {
        this.f579a.setAccessibilityPaneTitle(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(boolean z2) {
        if (this.f598t == z2) {
            return;
        }
        this.f598t = z2;
        this.f590l = z2 ? this.f590l | f.ACCESSIBLE_NAVIGATION.f618d : this.f590l & (f.ACCESSIBLE_NAVIGATION.f618d ^ (-1));
        T();
    }

    @TargetApi(31)
    private void X() {
        View view = this.f579a;
        if (view == null || view.getResources() == null) {
            return;
        }
        int i2 = this.f579a.getResources().getConfiguration().fontWeightAdjustment;
        this.f590l = i2 != Integer.MAX_VALUE && i2 >= 300 ? this.f590l | f.BOLD_TEXT.f618d : this.f590l & f.BOLD_TEXT.f618d;
        T();
    }

    private boolean Z(final l lVar) {
        return lVar.f681j > 0 && (l.A0(this.f587i, new z.d() { // from class: io.flutter.view.a
            @Override // z.d
            public final boolean test(Object obj) {
                boolean F;
                F = c.F(c.l.this, (c.l) obj);
                return F;
            }
        }) || !l.A0(this.f587i, new z.d() { // from class: io.flutter.view.b
            @Override // z.d
            public final boolean test(Object obj) {
                boolean G;
                G = c.G((c.l) obj);
                return G;
            }
        }));
    }

    @TargetApi(19)
    private void c0(l lVar) {
        View c2;
        Integer num;
        lVar.Q = null;
        if (lVar.f680i != -1 && (num = this.f588j) != null && this.f582d.platformViewOfNode(num.intValue()) == this.f583e.c(lVar.f680i)) {
            R(this.f588j.intValue(), 65536);
            this.f588j = null;
        }
        if (lVar.f680i != -1 && (c2 = this.f583e.c(lVar.f680i)) != null) {
            c2.setImportantForAccessibility(4);
        }
        l lVar2 = this.f587i;
        if (lVar2 == lVar) {
            R(lVar2.f673b, 65536);
            this.f587i = null;
        }
        if (this.f591m == lVar) {
            this.f591m = null;
        }
        if (this.f593o == lVar) {
            this.f593o = null;
        }
    }

    static /* synthetic */ int f(c cVar, int i2) {
        int i3 = i2 & cVar.f590l;
        cVar.f590l = i3;
        return i3;
    }

    static /* synthetic */ int g(c cVar, int i2) {
        int i3 = i2 | cVar.f590l;
        cVar.f590l = i3;
        return i3;
    }

    private AccessibilityEvent v(int i2, String str, String str2) {
        AccessibilityEvent H = H(i2, 16);
        H.setBeforeText(str);
        H.getText().add(str2);
        int i3 = 0;
        while (i3 < str.length() && i3 < str2.length() && str.charAt(i3) == str2.charAt(i3)) {
            i3++;
        }
        if (i3 >= str.length() && i3 >= str2.length()) {
            return null;
        }
        H.setFromIndex(i3);
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        while (length >= i3 && length2 >= i3 && str.charAt(length) == str2.charAt(length2)) {
            length--;
            length2--;
        }
        H.setRemovedCount((length - i3) + 1);
        H.setAddedCount((length2 - i3) + 1);
        return H;
    }

    @TargetApi(28)
    private boolean w() {
        Activity e2 = z.h.e(this.f579a.getContext());
        if (e2 == null || e2.getWindow() == null) {
            return false;
        }
        int i2 = e2.getWindow().getAttributes().layoutInDisplayCutoutMode;
        return i2 == 2 || i2 == 0;
    }

    private Rect y(Rect rect) {
        Rect rect2 = new Rect(rect);
        int[] iArr = new int[2];
        this.f579a.getLocationOnScreen(iArr);
        rect2.offset(iArr[0], iArr[1]);
        return rect2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h z(int i2) {
        h hVar = this.f586h.get(Integer.valueOf(i2));
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h();
        hVar2.f643b = i2;
        hVar2.f642a = B + i2;
        this.f586h.put(Integer.valueOf(i2), hVar2);
        return hVar2;
    }

    public boolean D() {
        return this.f581c.isEnabled();
    }

    public boolean E() {
        return this.f581c.isTouchExplorationEnabled();
    }

    public AccessibilityNodeInfo I(View view, int i2) {
        return AccessibilityNodeInfo.obtain(view, i2);
    }

    public boolean J(MotionEvent motionEvent) {
        return K(motionEvent, false);
    }

    public boolean K(MotionEvent motionEvent, boolean z2) {
        if (!this.f581c.isTouchExplorationEnabled() || this.f585g.isEmpty()) {
            return false;
        }
        l w0 = B().w0(new float[]{motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f}, z2);
        if (w0 != null && w0.f680i != -1) {
            if (z2) {
                return false;
            }
            return this.f582d.onAccessibilityHoverEvent(w0.f673b, motionEvent);
        }
        if (motionEvent.getAction() == 9 || motionEvent.getAction() == 7) {
            C(motionEvent.getX(), motionEvent.getY(), z2);
        } else {
            if (motionEvent.getAction() != 10) {
                j.b.a("flutter", "unexpected accessibility hover event: " + motionEvent);
                return false;
            }
            L();
        }
        return true;
    }

    public void Q() {
        this.f599u = true;
        this.f583e.a();
        Y(null);
        this.f581c.removeAccessibilityStateChangeListener(this.f601w);
        if (Build.VERSION.SDK_INT >= 19) {
            this.f581c.removeTouchExplorationStateChangeListener(this.f602x);
        }
        this.f584f.unregisterContentObserver(this.f603y);
        this.f580b.g(null);
    }

    public void Y(k kVar) {
        this.f597s = kVar;
    }

    void a0(ByteBuffer byteBuffer, String[] strArr) {
        while (byteBuffer.hasRemaining()) {
            h z2 = z(byteBuffer.getInt());
            z2.f644c = byteBuffer.getInt();
            int i2 = byteBuffer.getInt();
            String str = null;
            z2.f645d = i2 == -1 ? null : strArr[i2];
            int i3 = byteBuffer.getInt();
            if (i3 != -1) {
                str = strArr[i3];
            }
            z2.f646e = str;
        }
    }

    void b0(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
        l lVar;
        l lVar2;
        float f2;
        float f3;
        WindowInsets rootWindowInsets;
        View c2;
        ArrayList arrayList = new ArrayList();
        while (byteBuffer.hasRemaining()) {
            l A2 = A(byteBuffer.getInt());
            A2.D0(byteBuffer, strArr, byteBufferArr);
            if (!A2.v0(i.IS_HIDDEN)) {
                if (A2.v0(i.IS_FOCUSED)) {
                    this.f591m = A2;
                }
                if (A2.B) {
                    arrayList.add(A2);
                }
                if (A2.f680i != -1 && !this.f583e.d(A2.f680i) && (c2 = this.f583e.c(A2.f680i)) != null) {
                    c2.setImportantForAccessibility(0);
                }
            }
        }
        HashSet hashSet = new HashSet();
        l B2 = B();
        ArrayList<l> arrayList2 = new ArrayList();
        if (B2 != null) {
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                if ((i2 >= 28 ? w() : true) && (rootWindowInsets = this.f579a.getRootWindowInsets()) != null) {
                    if (!this.f596r.equals(Integer.valueOf(rootWindowInsets.getSystemWindowInsetLeft()))) {
                        B2.Y = true;
                        B2.W = true;
                    }
                    this.f596r = Integer.valueOf(rootWindowInsets.getSystemWindowInsetLeft());
                    Matrix.translateM(fArr, 0, r4.intValue(), 0.0f, 0.0f);
                }
            }
            B2.C0(fArr, hashSet, false);
            B2.e0(arrayList2);
        }
        l lVar3 = null;
        for (l lVar4 : arrayList2) {
            if (!this.f594p.contains(Integer.valueOf(lVar4.f673b))) {
                lVar3 = lVar4;
            }
        }
        if (lVar3 == null && arrayList2.size() > 0) {
            lVar3 = (l) arrayList2.get(arrayList2.size() - 1);
        }
        if (lVar3 != null && (lVar3.f673b != this.f595q || arrayList2.size() != this.f594p.size())) {
            this.f595q = lVar3.f673b;
            M(lVar3);
        }
        this.f594p.clear();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            this.f594p.add(Integer.valueOf(((l) it.next()).f673b));
        }
        Iterator<Map.Entry<Integer, l>> it2 = this.f585g.entrySet().iterator();
        while (it2.hasNext()) {
            l value = it2.next().getValue();
            if (!hashSet.contains(value)) {
                c0(value);
                it2.remove();
            }
        }
        U(0);
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            l lVar5 = (l) it3.next();
            if (lVar5.h0()) {
                AccessibilityEvent H = H(lVar5.f673b, 4096);
                float f4 = lVar5.f683l;
                float f5 = lVar5.f684m;
                if (Float.isInfinite(lVar5.f684m)) {
                    if (f4 > 70000.0f) {
                        f4 = 70000.0f;
                    }
                    f5 = 100000.0f;
                }
                if (Float.isInfinite(lVar5.f685n)) {
                    f2 = f5 + 100000.0f;
                    if (f4 < -70000.0f) {
                        f4 = -70000.0f;
                    }
                    f3 = f4 + 100000.0f;
                } else {
                    f2 = f5 - lVar5.f685n;
                    f3 = f4 - lVar5.f685n;
                }
                if (lVar5.s0(g.SCROLL_UP) || lVar5.s0(g.SCROLL_DOWN)) {
                    H.setScrollY((int) f3);
                    H.setMaxScrollY((int) f2);
                } else if (lVar5.s0(g.SCROLL_LEFT) || lVar5.s0(g.SCROLL_RIGHT)) {
                    H.setScrollX((int) f3);
                    H.setMaxScrollX((int) f2);
                }
                if (lVar5.f681j > 0) {
                    H.setItemCount(lVar5.f681j);
                    H.setFromIndex(lVar5.f682k);
                    Iterator it4 = lVar5.S.iterator();
                    int i3 = 0;
                    while (it4.hasNext()) {
                        if (!((l) it4.next()).v0(i.IS_HIDDEN)) {
                            i3++;
                        }
                    }
                    H.setToIndex((lVar5.f682k + i3) - 1);
                }
                S(H);
            }
            if (lVar5.v0(i.IS_LIVE_REGION) && lVar5.g0()) {
                U(lVar5.f673b);
            }
            l lVar6 = this.f587i;
            if (lVar6 != null && lVar6.f673b == lVar5.f673b) {
                i iVar = i.IS_SELECTED;
                if (!lVar5.t0(iVar) && lVar5.v0(iVar)) {
                    AccessibilityEvent H2 = H(lVar5.f673b, 4);
                    H2.getText().add(lVar5.f686o);
                    S(H2);
                }
            }
            l lVar7 = this.f591m;
            if (lVar7 != null && lVar7.f673b == lVar5.f673b && ((lVar2 = this.f592n) == null || lVar2.f673b != this.f591m.f673b)) {
                this.f592n = this.f591m;
                S(H(lVar5.f673b, 8));
            } else if (this.f591m == null) {
                this.f592n = null;
            }
            l lVar8 = this.f591m;
            if (lVar8 != null && lVar8.f673b == lVar5.f673b) {
                i iVar2 = i.IS_TEXT_FIELD;
                if (lVar5.t0(iVar2) && lVar5.v0(iVar2) && ((lVar = this.f587i) == null || lVar.f673b == this.f591m.f673b)) {
                    String str = lVar5.J != null ? lVar5.J : "";
                    String str2 = lVar5.f688q != null ? lVar5.f688q : "";
                    AccessibilityEvent v2 = v(lVar5.f673b, str, str2);
                    if (v2 != null) {
                        S(v2);
                    }
                    if (lVar5.E != lVar5.f678g || lVar5.F != lVar5.f679h) {
                        AccessibilityEvent H3 = H(lVar5.f673b, 8192);
                        H3.getText().add(str2);
                        H3.setFromIndex(lVar5.f678g);
                        H3.setToIndex(lVar5.f679h);
                        H3.setItemCount(str2.length());
                        S(H3);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:180:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0462 A[LOOP:0: B:191:0x045c->B:193:0x0462, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0487  */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.accessibility.AccessibilityNodeInfo createAccessibilityNodeInfo(int r17) {
        /*
            Method dump skipped, instructions count: 1217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.c.createAccessibilityNodeInfo(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0016, code lost:
    
        if (r2 != null) goto L14;
     */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.accessibility.AccessibilityNodeInfo findFocus(int r2) {
        /*
            r1 = this;
            r0 = 1
            if (r2 == r0) goto L7
            r0 = 2
            if (r2 == r0) goto L1d
            goto L27
        L7:
            io.flutter.view.c$l r2 = r1.f591m
            if (r2 == 0) goto L14
        Lb:
            int r2 = io.flutter.view.c.l.a(r2)
        Lf:
            android.view.accessibility.AccessibilityNodeInfo r2 = r1.createAccessibilityNodeInfo(r2)
            return r2
        L14:
            java.lang.Integer r2 = r1.f589k
            if (r2 == 0) goto L1d
        L18:
            int r2 = r2.intValue()
            goto Lf
        L1d:
            io.flutter.view.c$l r2 = r1.f587i
            if (r2 == 0) goto L22
            goto Lb
        L22:
            java.lang.Integer r2 = r1.f588j
            if (r2 == 0) goto L27
            goto L18
        L27:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.c.findFocus(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i2, int i3, Bundle bundle) {
        int i4;
        if (i2 >= 65536) {
            boolean performAction = this.f582d.performAction(i2, i3, bundle);
            if (performAction && i3 == 128) {
                this.f588j = null;
            }
            return performAction;
        }
        l lVar = this.f585g.get(Integer.valueOf(i2));
        boolean z2 = false;
        if (lVar == null) {
            return false;
        }
        switch (i3) {
            case 16:
                this.f580b.b(i2, g.TAP);
                return true;
            case 32:
                this.f580b.b(i2, g.LONG_PRESS);
                return true;
            case 64:
                if (this.f587i == null) {
                    this.f579a.invalidate();
                }
                this.f587i = lVar;
                this.f580b.b(i2, g.DID_GAIN_ACCESSIBILITY_FOCUS);
                R(i2, 32768);
                if (lVar.u0(g.INCREASE) || lVar.u0(g.DECREASE)) {
                    R(i2, 4);
                }
                return true;
            case 128:
                l lVar2 = this.f587i;
                if (lVar2 != null && lVar2.f673b == i2) {
                    this.f587i = null;
                }
                Integer num = this.f588j;
                if (num != null && num.intValue() == i2) {
                    this.f588j = null;
                }
                this.f580b.b(i2, g.DID_LOSE_ACCESSIBILITY_FOCUS);
                R(i2, 65536);
                return true;
            case 256:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                return N(lVar, i2, bundle, true);
            case 512:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                return N(lVar, i2, bundle, false);
            case 4096:
                g gVar = g.SCROLL_UP;
                if (!lVar.u0(gVar)) {
                    gVar = g.SCROLL_LEFT;
                    if (!lVar.u0(gVar)) {
                        gVar = g.INCREASE;
                        if (!lVar.u0(gVar)) {
                            return false;
                        }
                        lVar.f688q = lVar.f690s;
                        lVar.f689r = lVar.f691t;
                        R(i2, 4);
                    }
                }
                this.f580b.b(i2, gVar);
                return true;
            case 8192:
                g gVar2 = g.SCROLL_DOWN;
                if (!lVar.u0(gVar2)) {
                    gVar2 = g.SCROLL_RIGHT;
                    if (!lVar.u0(gVar2)) {
                        gVar2 = g.DECREASE;
                        if (!lVar.u0(gVar2)) {
                            return false;
                        }
                        lVar.f688q = lVar.f692u;
                        lVar.f689r = lVar.f693v;
                        R(i2, 4);
                    }
                }
                this.f580b.b(i2, gVar2);
                return true;
            case 16384:
                this.f580b.b(i2, g.COPY);
                return true;
            case 32768:
                this.f580b.b(i2, g.PASTE);
                return true;
            case 65536:
                this.f580b.b(i2, g.CUT);
                return true;
            case 131072:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                HashMap hashMap = new HashMap();
                if (bundle != null && bundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT") && bundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
                    z2 = true;
                }
                if (z2) {
                    hashMap.put("base", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
                    i4 = bundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT");
                } else {
                    hashMap.put("base", Integer.valueOf(lVar.f679h));
                    i4 = lVar.f679h;
                }
                hashMap.put("extent", Integer.valueOf(i4));
                this.f580b.c(i2, g.SET_SELECTION, hashMap);
                l lVar3 = this.f585g.get(Integer.valueOf(i2));
                lVar3.f678g = ((Integer) hashMap.get("base")).intValue();
                lVar3.f679h = ((Integer) hashMap.get("extent")).intValue();
                return true;
            case 1048576:
                this.f580b.b(i2, g.DISMISS);
                return true;
            case 2097152:
                if (Build.VERSION.SDK_INT < 21) {
                    return false;
                }
                return O(lVar, i2, bundle);
            case R.id.accessibilityActionShowOnScreen:
                this.f580b.b(i2, g.SHOW_ON_SCREEN);
                return true;
            default:
                h hVar = this.f586h.get(Integer.valueOf(i3 - B));
                if (hVar == null) {
                    return false;
                }
                this.f580b.c(i2, g.CUSTOM_ACTION, Integer.valueOf(hVar.f643b));
                return true;
        }
    }

    @SuppressLint({"SwitchIntDef"})
    public boolean x(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        if (!this.f582d.requestSendAccessibilityEvent(view, view2, accessibilityEvent) || (recordFlutterId = this.f582d.getRecordFlutterId(view, accessibilityEvent)) == null) {
            return false;
        }
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 8) {
            this.f589k = recordFlutterId;
            this.f591m = null;
            return true;
        }
        if (eventType == 128) {
            this.f593o = null;
            return true;
        }
        if (eventType == 32768) {
            this.f588j = recordFlutterId;
            this.f587i = null;
            return true;
        }
        if (eventType != 65536) {
            return true;
        }
        this.f589k = null;
        this.f588j = null;
        return true;
    }
}
