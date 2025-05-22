package io.flutter.plugin.editing;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.android.s;
import io.flutter.plugin.editing.c;
import java.util.HashMap;
import v.p;

/* loaded from: classes.dex */
public class f implements c.b {

    /* renamed from: a, reason: collision with root package name */
    private final View f440a;

    /* renamed from: b, reason: collision with root package name */
    private final InputMethodManager f441b;

    /* renamed from: c, reason: collision with root package name */
    private final AutofillManager f442c;

    /* renamed from: d, reason: collision with root package name */
    private final p f443d;

    /* renamed from: e, reason: collision with root package name */
    private c f444e = new c(c.a.NO_TARGET, 0);

    /* renamed from: f, reason: collision with root package name */
    private p.b f445f;

    /* renamed from: g, reason: collision with root package name */
    private SparseArray<p.b> f446g;

    /* renamed from: h, reason: collision with root package name */
    private io.flutter.plugin.editing.c f447h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f448i;

    /* renamed from: j, reason: collision with root package name */
    private InputConnection f449j;

    /* renamed from: k, reason: collision with root package name */
    private io.flutter.plugin.platform.p f450k;

    /* renamed from: l, reason: collision with root package name */
    private Rect f451l;

    /* renamed from: m, reason: collision with root package name */
    private ImeSyncDeferringInsetsCallback f452m;

    /* renamed from: n, reason: collision with root package name */
    private p.e f453n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f454o;

    class a implements p.f {
        a() {
        }

        @Override // v.p.f
        public void a(String str, Bundle bundle) {
            f.this.B(str, bundle);
        }

        @Override // v.p.f
        public void b(p.e eVar) {
            f fVar = f.this;
            fVar.E(fVar.f440a, eVar);
        }

        @Override // v.p.f
        public void c() {
            f.this.x();
        }

        @Override // v.p.f
        public void d() {
            f.this.m();
        }

        @Override // v.p.f
        public void e() {
            f fVar = f.this;
            fVar.F(fVar.f440a);
        }

        @Override // v.p.f
        public void f(int i2, p.b bVar) {
            f.this.D(i2, bVar);
        }

        @Override // v.p.f
        public void g(int i2, boolean z2) {
            f.this.C(i2, z2);
        }

        @Override // v.p.f
        public void h(double d2, double d3, double[] dArr) {
            f.this.A(d2, d3, dArr);
        }

        @Override // v.p.f
        public void i(boolean z2) {
            if (Build.VERSION.SDK_INT < 26 || f.this.f442c == null) {
                return;
            }
            if (z2) {
                f.this.f442c.commit();
            } else {
                f.this.f442c.cancel();
            }
        }

        @Override // v.p.f
        public void j() {
            if (f.this.f444e.f460a == c.a.PHYSICAL_DISPLAY_PLATFORM_VIEW) {
                f.this.y();
            } else {
                f fVar = f.this;
                fVar.s(fVar.f440a);
            }
        }
    }

    class b implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f456a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ double[] f457b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ double[] f458c;

        b(boolean z2, double[] dArr, double[] dArr2) {
            this.f456a = z2;
            this.f457b = dArr;
            this.f458c = dArr2;
        }

        @Override // io.flutter.plugin.editing.f.d
        public void a(double d2, double d3) {
            double d4 = 1.0d;
            if (!this.f456a) {
                double[] dArr = this.f457b;
                d4 = 1.0d / (((dArr[3] * d2) + (dArr[7] * d3)) + dArr[15]);
            }
            double[] dArr2 = this.f457b;
            double d5 = ((dArr2[0] * d2) + (dArr2[4] * d3) + dArr2[12]) * d4;
            double d6 = ((dArr2[1] * d2) + (dArr2[5] * d3) + dArr2[13]) * d4;
            double[] dArr3 = this.f458c;
            if (d5 < dArr3[0]) {
                dArr3[0] = d5;
            } else if (d5 > dArr3[1]) {
                dArr3[1] = d5;
            }
            if (d6 < dArr3[2]) {
                dArr3[2] = d6;
            } else if (d6 > dArr3[3]) {
                dArr3[3] = d6;
            }
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        a f460a;

        /* renamed from: b, reason: collision with root package name */
        int f461b;

        enum a {
            NO_TARGET,
            FRAMEWORK_CLIENT,
            VIRTUAL_DISPLAY_PLATFORM_VIEW,
            PHYSICAL_DISPLAY_PLATFORM_VIEW
        }

        public c(a aVar, int i2) {
            this.f460a = aVar;
            this.f461b = i2;
        }
    }

    private interface d {
        void a(double d2, double d3);
    }

    @SuppressLint({"NewApi"})
    public f(View view, p pVar, io.flutter.plugin.platform.p pVar2) {
        this.f440a = view;
        this.f447h = new io.flutter.plugin.editing.c(null, view);
        this.f441b = (InputMethodManager) view.getContext().getSystemService("input_method");
        int i2 = Build.VERSION.SDK_INT;
        this.f442c = i2 >= 26 ? (AutofillManager) view.getContext().getSystemService(AutofillManager.class) : null;
        if (i2 >= 30) {
            int navigationBars = (view.getWindowSystemUiVisibility() & 2) == 0 ? 0 | WindowInsets.Type.navigationBars() : 0;
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = new ImeSyncDeferringInsetsCallback(view, (view.getWindowSystemUiVisibility() & 4) == 0 ? navigationBars | WindowInsets.Type.statusBars() : navigationBars, WindowInsets.Type.ime());
            this.f452m = imeSyncDeferringInsetsCallback;
            imeSyncDeferringInsetsCallback.install();
        }
        this.f443d = pVar;
        pVar.n(new a());
        pVar.k();
        this.f450k = pVar2;
        pVar2.C(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(double d2, double d3, double[] dArr) {
        double[] dArr2 = new double[4];
        boolean z2 = dArr[3] == 0.0d && dArr[7] == 0.0d && dArr[15] == 1.0d;
        double d4 = dArr[12] / dArr[15];
        dArr2[1] = d4;
        dArr2[0] = d4;
        double d5 = dArr[13] / dArr[15];
        dArr2[3] = d5;
        dArr2[2] = d5;
        b bVar = new b(z2, dArr, dArr2);
        bVar.a(d2, 0.0d);
        bVar.a(d2, d3);
        bVar.a(0.0d, d3);
        Float valueOf = Float.valueOf(this.f440a.getContext().getResources().getDisplayMetrics().density);
        double d6 = dArr2[0];
        double floatValue = valueOf.floatValue();
        Double.isNaN(floatValue);
        double d7 = dArr2[2];
        double floatValue2 = valueOf.floatValue();
        Double.isNaN(floatValue2);
        int i2 = (int) (d7 * floatValue2);
        double d8 = dArr2[1];
        double floatValue3 = valueOf.floatValue();
        Double.isNaN(floatValue3);
        int ceil = (int) Math.ceil(d8 * floatValue3);
        double d9 = dArr2[3];
        double floatValue4 = valueOf.floatValue();
        Double.isNaN(floatValue4);
        this.f451l = new Rect((int) (d6 * floatValue), i2, ceil, (int) Math.ceil(d9 * floatValue4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(int i2, boolean z2) {
        if (!z2) {
            this.f444e = new c(c.a.PHYSICAL_DISPLAY_PLATFORM_VIEW, i2);
            this.f449j = null;
        } else {
            this.f440a.requestFocus();
            this.f444e = new c(c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW, i2);
            this.f441b.restartInput(this.f440a);
            this.f448i = false;
        }
    }

    private void H(p.b bVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (bVar == null || bVar.f1350j == null) {
            this.f446g = null;
            return;
        }
        p.b[] bVarArr = bVar.f1352l;
        SparseArray<p.b> sparseArray = new SparseArray<>();
        this.f446g = sparseArray;
        if (bVarArr == null) {
            sparseArray.put(bVar.f1350j.f1353a.hashCode(), bVar);
            return;
        }
        for (p.b bVar2 : bVarArr) {
            p.b.a aVar = bVar2.f1350j;
            if (aVar != null) {
                this.f446g.put(aVar.f1353a.hashCode(), bVar2);
                this.f442c.notifyValueChanged(this.f440a, aVar.f1353a.hashCode(), AutofillValue.forText(aVar.f1355c.f1366a));
            }
        }
    }

    private boolean k() {
        p.c cVar;
        p.b bVar = this.f445f;
        return bVar == null || (cVar = bVar.f1347g) == null || cVar.f1357a != p.g.NONE;
    }

    private static boolean n(p.e eVar, p.e eVar2) {
        int i2 = eVar.f1370e - eVar.f1369d;
        if (i2 != eVar2.f1370e - eVar2.f1369d) {
            return true;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (eVar.f1366a.charAt(eVar.f1369d + i3) != eVar2.f1366a.charAt(eVar2.f1369d + i3)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(View view) {
        y();
        this.f441b.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    private static int t(p.c cVar, boolean z2, boolean z3, boolean z4, boolean z5, p.d dVar) {
        p.g gVar = cVar.f1357a;
        if (gVar == p.g.DATETIME) {
            return 4;
        }
        if (gVar == p.g.NUMBER) {
            int i2 = cVar.f1358b ? 4098 : 2;
            return cVar.f1359c ? i2 | 8192 : i2;
        }
        if (gVar == p.g.PHONE) {
            return 3;
        }
        if (gVar == p.g.NONE) {
            return 0;
        }
        int i3 = 1;
        if (gVar == p.g.MULTILINE) {
            i3 = 131073;
        } else if (gVar == p.g.EMAIL_ADDRESS) {
            i3 = 33;
        } else if (gVar == p.g.URL) {
            i3 = 17;
        } else if (gVar == p.g.VISIBLE_PASSWORD) {
            i3 = 145;
        } else if (gVar == p.g.NAME) {
            i3 = 97;
        } else if (gVar == p.g.POSTAL_ADDRESS) {
            i3 = 113;
        }
        if (z2) {
            i3 = i3 | 524288 | 128;
        } else {
            if (z3) {
                i3 |= 32768;
            }
            if (!z4) {
                i3 |= 524288;
            }
        }
        return dVar == p.d.CHARACTERS ? i3 | 4096 : dVar == p.d.WORDS ? i3 | 8192 : dVar == p.d.SENTENCES ? i3 | 16384 : i3;
    }

    private boolean v() {
        return this.f446g != null;
    }

    private void w(String str) {
        if (Build.VERSION.SDK_INT < 26 || this.f442c == null || !v()) {
            return;
        }
        this.f442c.notifyValueChanged(this.f440a, this.f445f.f1350j.f1353a.hashCode(), AutofillValue.forText(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (Build.VERSION.SDK_INT < 26 || this.f442c == null || !v()) {
            return;
        }
        String str = this.f445f.f1350j.f1353a;
        int[] iArr = new int[2];
        this.f440a.getLocationOnScreen(iArr);
        Rect rect = new Rect(this.f451l);
        rect.offset(iArr[0], iArr[1]);
        this.f442c.notifyViewEntered(this.f440a, str.hashCode(), rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        p.b bVar;
        if (Build.VERSION.SDK_INT < 26 || this.f442c == null || (bVar = this.f445f) == null || bVar.f1350j == null || !v()) {
            return;
        }
        this.f442c.notifyViewExited(this.f440a, this.f445f.f1350j.f1353a.hashCode());
    }

    public void B(String str, Bundle bundle) {
        this.f441b.sendAppPrivateCommand(this.f440a, str, bundle);
    }

    void D(int i2, p.b bVar) {
        y();
        this.f445f = bVar;
        this.f444e = k() ? new c(c.a.FRAMEWORK_CLIENT, i2) : new c(c.a.NO_TARGET, i2);
        this.f447h.l(this);
        p.b.a aVar = bVar.f1350j;
        this.f447h = new io.flutter.plugin.editing.c(aVar != null ? aVar.f1355c : null, this.f440a);
        H(bVar);
        this.f448i = true;
        G();
        this.f451l = null;
        this.f447h.a(this);
    }

    void E(View view, p.e eVar) {
        p.e eVar2;
        if (!this.f448i && (eVar2 = this.f453n) != null && eVar2.b()) {
            boolean n2 = n(this.f453n, eVar);
            this.f448i = n2;
            if (n2) {
                j.b.e("TextInputPlugin", "Composing region changed by the framework. Restarting the input method.");
            }
        }
        this.f453n = eVar;
        this.f447h.n(eVar);
        if (this.f448i) {
            this.f441b.restartInput(view);
            this.f448i = false;
        }
    }

    void F(View view) {
        if (!k()) {
            s(view);
        } else {
            view.requestFocus();
            this.f441b.showSoftInput(view, 0);
        }
    }

    public void G() {
        if (this.f444e.f460a == c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.f454o = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
    
        if (r7 == r1.f1370e) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac  */
    @Override // io.flutter.plugin.editing.c.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r9, boolean r10, boolean r11) {
        /*
            r8 = this;
            if (r9 == 0) goto Lb
            io.flutter.plugin.editing.c r9 = r8.f447h
            java.lang.String r9 = r9.toString()
            r8.w(r9)
        Lb:
            io.flutter.plugin.editing.c r9 = r8.f447h
            int r9 = r9.i()
            io.flutter.plugin.editing.c r10 = r8.f447h
            int r10 = r10.h()
            io.flutter.plugin.editing.c r11 = r8.f447h
            int r11 = r11.g()
            io.flutter.plugin.editing.c r0 = r8.f447h
            int r7 = r0.f()
            io.flutter.plugin.editing.c r0 = r8.f447h
            java.util.ArrayList r0 = r0.e()
            v.p$e r1 = r8.f453n
            if (r1 == 0) goto L52
            io.flutter.plugin.editing.c r1 = r8.f447h
            java.lang.String r1 = r1.toString()
            v.p$e r2 = r8.f453n
            java.lang.String r2 = r2.f1366a
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L50
            v.p$e r1 = r8.f453n
            int r2 = r1.f1367b
            if (r9 != r2) goto L50
            int r2 = r1.f1368c
            if (r10 != r2) goto L50
            int r2 = r1.f1369d
            if (r11 != r2) goto L50
            int r1 = r1.f1370e
            if (r7 != r1) goto L50
            goto L52
        L50:
            r1 = 0
            goto L53
        L52:
            r1 = 1
        L53:
            if (r1 != 0) goto Lac
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "send EditingState to flutter: "
            r1.append(r2)
            io.flutter.plugin.editing.c r2 = r8.f447h
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "TextInputPlugin"
            j.b.f(r2, r1)
            v.p$b r1 = r8.f445f
            boolean r1 = r1.f1345e
            if (r1 == 0) goto L86
            v.p r1 = r8.f443d
            io.flutter.plugin.editing.f$c r2 = r8.f444e
            int r2 = r2.f461b
            r1.q(r2, r0)
            io.flutter.plugin.editing.c r0 = r8.f447h
            r0.c()
            goto L99
        L86:
            v.p r0 = r8.f443d
            io.flutter.plugin.editing.f$c r1 = r8.f444e
            int r1 = r1.f461b
            io.flutter.plugin.editing.c r2 = r8.f447h
            java.lang.String r2 = r2.toString()
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r7
            r0.p(r1, r2, r3, r4, r5, r6)
        L99:
            v.p$e r6 = new v.p$e
            io.flutter.plugin.editing.c r0 = r8.f447h
            java.lang.String r1 = r0.toString()
            r0 = r6
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r8.f453n = r6
            goto Lb1
        Lac:
            io.flutter.plugin.editing.c r9 = r8.f447h
            r9.c()
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.f.a(boolean, boolean, boolean):void");
    }

    public void j(SparseArray<AutofillValue> sparseArray) {
        p.b bVar;
        p.b.a aVar;
        p.b.a aVar2;
        if (Build.VERSION.SDK_INT < 26 || (bVar = this.f445f) == null || this.f446g == null || (aVar = bVar.f1350j) == null) {
            return;
        }
        HashMap<String, p.e> hashMap = new HashMap<>();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            p.b bVar2 = this.f446g.get(sparseArray.keyAt(i2));
            if (bVar2 != null && (aVar2 = bVar2.f1350j) != null) {
                String charSequence = sparseArray.valueAt(i2).getTextValue().toString();
                p.e eVar = new p.e(charSequence, charSequence.length(), charSequence.length(), -1, -1);
                if (aVar2.f1353a.equals(aVar.f1353a)) {
                    this.f447h.n(eVar);
                } else {
                    hashMap.put(aVar2.f1353a, eVar);
                }
            }
        }
        this.f443d.r(this.f444e.f461b, hashMap);
    }

    public void l(int i2) {
        c cVar = this.f444e;
        c.a aVar = cVar.f460a;
        if ((aVar == c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW || aVar == c.a.PHYSICAL_DISPLAY_PLATFORM_VIEW) && cVar.f461b == i2) {
            this.f444e = new c(c.a.NO_TARGET, 0);
            y();
            this.f441b.hideSoftInputFromWindow(this.f440a.getApplicationWindowToken(), 0);
            this.f441b.restartInput(this.f440a);
            this.f448i = false;
        }
    }

    void m() {
        if (this.f444e.f460a == c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            return;
        }
        this.f447h.l(this);
        y();
        this.f445f = null;
        H(null);
        this.f444e = new c(c.a.NO_TARGET, 0);
        G();
        this.f451l = null;
    }

    public InputConnection o(View view, s sVar, EditorInfo editorInfo) {
        c cVar = this.f444e;
        c.a aVar = cVar.f460a;
        if (aVar == c.a.NO_TARGET) {
            this.f449j = null;
            return null;
        }
        if (aVar == c.a.PHYSICAL_DISPLAY_PLATFORM_VIEW) {
            return null;
        }
        if (aVar == c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            if (this.f454o) {
                return this.f449j;
            }
            InputConnection onCreateInputConnection = this.f450k.c(cVar.f461b).onCreateInputConnection(editorInfo);
            this.f449j = onCreateInputConnection;
            return onCreateInputConnection;
        }
        p.b bVar = this.f445f;
        int t2 = t(bVar.f1347g, bVar.f1341a, bVar.f1342b, bVar.f1343c, bVar.f1344d, bVar.f1346f);
        editorInfo.inputType = t2;
        editorInfo.imeOptions = 33554432;
        if (Build.VERSION.SDK_INT >= 26 && !this.f445f.f1344d) {
            editorInfo.imeOptions = 33554432 | 16777216;
        }
        Integer num = this.f445f.f1348h;
        int intValue = num == null ? (t2 & 131072) != 0 ? 1 : 6 : num.intValue();
        p.b bVar2 = this.f445f;
        String str = bVar2.f1349i;
        if (str != null) {
            editorInfo.actionLabel = str;
            editorInfo.actionId = intValue;
        }
        editorInfo.imeOptions = intValue | editorInfo.imeOptions;
        String[] strArr = bVar2.f1351k;
        if (strArr != null) {
            g.a.a(editorInfo, strArr);
        }
        io.flutter.plugin.editing.b bVar3 = new io.flutter.plugin.editing.b(view, this.f444e.f461b, this.f443d, sVar, this.f447h, editorInfo);
        editorInfo.initialSelStart = this.f447h.i();
        editorInfo.initialSelEnd = this.f447h.h();
        this.f449j = bVar3;
        return bVar3;
    }

    @SuppressLint({"NewApi"})
    public void p() {
        this.f450k.L();
        this.f443d.n(null);
        y();
        this.f447h.l(this);
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.f452m;
        if (imeSyncDeferringInsetsCallback != null) {
            imeSyncDeferringInsetsCallback.remove();
        }
    }

    public InputMethodManager q() {
        return this.f441b;
    }

    public boolean r(KeyEvent keyEvent) {
        InputConnection inputConnection;
        if (!q().isAcceptingText() || (inputConnection = this.f449j) == null) {
            return false;
        }
        return inputConnection instanceof io.flutter.plugin.editing.b ? ((io.flutter.plugin.editing.b) inputConnection).f(keyEvent) : inputConnection.sendKeyEvent(keyEvent);
    }

    public void u() {
        if (this.f444e.f460a == c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.f454o = true;
        }
    }

    public void z(ViewStructure viewStructure, int i2) {
        ViewStructure viewStructure2;
        CharSequence charSequence;
        Rect rect;
        if (Build.VERSION.SDK_INT < 26 || !v()) {
            return;
        }
        String str = this.f445f.f1350j.f1353a;
        AutofillId autofillId = viewStructure.getAutofillId();
        for (int i3 = 0; i3 < this.f446g.size(); i3++) {
            int keyAt = this.f446g.keyAt(i3);
            p.b.a aVar = this.f446g.valueAt(i3).f1350j;
            if (aVar != null) {
                viewStructure.addChildCount(1);
                ViewStructure newChild = viewStructure.newChild(i3);
                newChild.setAutofillId(autofillId, keyAt);
                String[] strArr = aVar.f1354b;
                if (strArr.length > 0) {
                    newChild.setAutofillHints(strArr);
                }
                newChild.setAutofillType(1);
                newChild.setVisibility(0);
                String str2 = aVar.f1356d;
                if (str2 != null) {
                    newChild.setHint(str2);
                }
                if (str.hashCode() != keyAt || (rect = this.f451l) == null) {
                    viewStructure2 = newChild;
                    viewStructure2.setDimens(0, 0, 0, 0, 1, 1);
                    charSequence = aVar.f1355c.f1366a;
                } else {
                    viewStructure2 = newChild;
                    newChild.setDimens(rect.left, rect.top, 0, 0, rect.width(), this.f451l.height());
                    charSequence = this.f447h;
                }
                viewStructure2.setAutofillValue(AutofillValue.forText(charSequence));
            }
        }
    }
}
