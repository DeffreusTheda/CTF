package io.flutter.plugin.editing;

import D.AbstractC0000a;
import D.v;
import K.o;
import K.p;
import K.r;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.InputMethodManager;

/* loaded from: classes.dex */
public final class k implements e {

    /* renamed from: a, reason: collision with root package name */
    public final View f678a;

    /* renamed from: b, reason: collision with root package name */
    public final InputMethodManager f679b;

    /* renamed from: c, reason: collision with root package name */
    public final AutofillManager f680c;

    /* renamed from: d, reason: collision with root package name */
    public final B.a f681d;

    /* renamed from: e, reason: collision with root package name */
    public j f682e = new j(1, 0);

    /* renamed from: f, reason: collision with root package name */
    public p f683f;

    /* renamed from: g, reason: collision with root package name */
    public SparseArray f684g;

    /* renamed from: h, reason: collision with root package name */
    public f f685h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f686i;

    /* renamed from: j, reason: collision with root package name */
    public c f687j;

    /* renamed from: k, reason: collision with root package name */
    public final io.flutter.plugin.platform.k f688k;

    /* renamed from: l, reason: collision with root package name */
    public final io.flutter.plugin.platform.j f689l;
    public Rect m;

    /* renamed from: n, reason: collision with root package name */
    public final ImeSyncDeferringInsetsCallback f690n;

    /* renamed from: o, reason: collision with root package name */
    public r f691o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f692p;

    public k(View view, B.a aVar, v vVar, io.flutter.plugin.platform.k kVar, io.flutter.plugin.platform.j jVar) {
        Object systemService;
        this.f678a = view;
        this.f685h = new f(null, view);
        this.f679b = (InputMethodManager) view.getContext().getSystemService("input_method");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            systemService = view.getContext().getSystemService((Class<Object>) AbstractC0000a.j());
            this.f680c = AbstractC0000a.d(systemService);
        } else {
            this.f680c = null;
        }
        if (i2 >= 30) {
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = new ImeSyncDeferringInsetsCallback(view);
            this.f690n = imeSyncDeferringInsetsCallback;
            imeSyncDeferringInsetsCallback.install();
        }
        this.f681d = aVar;
        aVar.f5d = new v(27, this);
        ((B.e) aVar.f4c).f("TextInputClient.requestExistingInputState", null, null);
        this.f688k = kVar;
        kVar.f722e = this;
        this.f689l = jVar;
        jVar.getClass();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0086, code lost:
    
        if (r10 == r0.f300e) goto L38;
     */
    @Override // io.flutter.plugin.editing.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(boolean r17) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.k.a(boolean):void");
    }

    public final void b() {
        this.f688k.f722e = null;
        this.f689l.getClass();
        this.f681d.f5d = null;
        c();
        this.f685h.e(this);
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.f690n;
        if (imeSyncDeferringInsetsCallback != null) {
            imeSyncDeferringInsetsCallback.remove();
        }
    }

    public final void c() {
        AutofillManager autofillManager;
        p pVar;
        o oVar;
        if (Build.VERSION.SDK_INT < 26 || (autofillManager = this.f680c) == null || (pVar = this.f683f) == null || (oVar = pVar.f290j) == null || this.f684g == null) {
            return;
        }
        autofillManager.notifyViewExited(this.f678a, ((String) oVar.f277a).hashCode());
    }

    public final void d(p pVar) {
        o oVar;
        AutofillValue forText;
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (pVar == null || (oVar = pVar.f290j) == null) {
            this.f684g = null;
            return;
        }
        SparseArray sparseArray = new SparseArray();
        this.f684g = sparseArray;
        p[] pVarArr = pVar.f292l;
        if (pVarArr == null) {
            sparseArray.put(((String) oVar.f277a).hashCode(), pVar);
            return;
        }
        for (p pVar2 : pVarArr) {
            o oVar2 = pVar2.f290j;
            if (oVar2 != null) {
                SparseArray sparseArray2 = this.f684g;
                String str = (String) oVar2.f277a;
                sparseArray2.put(str.hashCode(), pVar2);
                AutofillManager autofillManager = this.f680c;
                int hashCode = str.hashCode();
                forText = AutofillValue.forText(((r) oVar2.f280d).f296a);
                autofillManager.notifyValueChanged(this.f678a, hashCode, forText);
            }
        }
    }
}
