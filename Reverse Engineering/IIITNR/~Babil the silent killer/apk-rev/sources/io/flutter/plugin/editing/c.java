package io.flutter.plugin.editing;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import java.util.ArrayList;
import java.util.Iterator;
import v.p;

/* loaded from: classes.dex */
class c extends SpannableStringBuilder {

    /* renamed from: d, reason: collision with root package name */
    private int f414d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f415e = 0;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<b> f416f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<b> f417g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<e> f418h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private String f419i;

    /* renamed from: j, reason: collision with root package name */
    private String f420j;

    /* renamed from: k, reason: collision with root package name */
    private int f421k;

    /* renamed from: l, reason: collision with root package name */
    private int f422l;

    /* renamed from: m, reason: collision with root package name */
    private int f423m;

    /* renamed from: n, reason: collision with root package name */
    private int f424n;

    /* renamed from: o, reason: collision with root package name */
    private BaseInputConnection f425o;

    class a extends BaseInputConnection {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Editable f426a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, boolean z2, Editable editable) {
            super(view, z2);
            this.f426a = editable;
        }

        @Override // android.view.inputmethod.BaseInputConnection
        public Editable getEditable() {
            return this.f426a;
        }
    }

    interface b {
        void a(boolean z2, boolean z3, boolean z4);
    }

    public c(p.e eVar, View view) {
        this.f425o = new a(view, true, this);
        if (eVar != null) {
            n(eVar);
        }
    }

    private void j(b bVar, boolean z2, boolean z3, boolean z4) {
        this.f415e++;
        bVar.a(z2, z3, z4);
        this.f415e--;
    }

    private void k(boolean z2, boolean z3, boolean z4) {
        if (z2 || z3 || z4) {
            Iterator<b> it = this.f416f.iterator();
            while (it.hasNext()) {
                j(it.next(), z2, z3, z4);
            }
        }
    }

    public void a(b bVar) {
        ArrayList<b> arrayList;
        if (this.f415e > 0) {
            j.b.b("ListenableEditingState", "adding a listener " + bVar.toString() + " in a listener callback");
        }
        if (this.f414d > 0) {
            j.b.g("ListenableEditingState", "a listener was added to EditingState while a batch edit was in progress");
            arrayList = this.f417g;
        } else {
            arrayList = this.f416f;
        }
        arrayList.add(bVar);
    }

    public void b() {
        this.f414d++;
        if (this.f415e > 0) {
            j.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        if (this.f414d != 1 || this.f416f.isEmpty()) {
            return;
        }
        this.f420j = toString();
        this.f421k = i();
        this.f422l = h();
        this.f423m = g();
        this.f424n = f();
    }

    public void c() {
        this.f418h.clear();
    }

    public void d() {
        int i2 = this.f414d;
        if (i2 == 0) {
            j.b.b("ListenableEditingState", "endBatchEdit called without a matching beginBatchEdit");
            return;
        }
        if (i2 == 1) {
            Iterator<b> it = this.f417g.iterator();
            while (it.hasNext()) {
                j(it.next(), true, true, true);
            }
            if (!this.f416f.isEmpty()) {
                j.b.f("ListenableEditingState", "didFinishBatchEdit with " + String.valueOf(this.f416f.size()) + " listener(s)");
                k(!toString().equals(this.f420j), (this.f421k == i() && this.f422l == h()) ? false : true, (this.f423m == g() && this.f424n == f()) ? false : true);
            }
        }
        this.f416f.addAll(this.f417g);
        this.f417g.clear();
        this.f414d--;
    }

    public ArrayList<e> e() {
        ArrayList<e> arrayList = new ArrayList<>(this.f418h);
        this.f418h.clear();
        return arrayList;
    }

    public final int f() {
        return BaseInputConnection.getComposingSpanEnd(this);
    }

    public final int g() {
        return BaseInputConnection.getComposingSpanStart(this);
    }

    public final int h() {
        return Selection.getSelectionEnd(this);
    }

    public final int i() {
        return Selection.getSelectionStart(this);
    }

    public void l(b bVar) {
        if (this.f415e > 0) {
            j.b.b("ListenableEditingState", "removing a listener " + bVar.toString() + " in a listener callback");
        }
        this.f416f.remove(bVar);
        if (this.f414d > 0) {
            this.f417g.remove(bVar);
        }
    }

    public void m(int i2, int i3) {
        if (i2 < 0 || i2 >= i3) {
            BaseInputConnection.removeComposingSpans(this);
        } else {
            this.f425o.setComposingRegion(i2, i3);
        }
    }

    public void n(p.e eVar) {
        b();
        replace(0, length(), (CharSequence) eVar.f1366a);
        if (eVar.c()) {
            Selection.setSelection(this, eVar.f1367b, eVar.f1368c);
        } else {
            Selection.removeSelection(this);
        }
        m(eVar.f1369d, eVar.f1370e);
        c();
        d();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i2, int i3, CharSequence charSequence, int i4, int i5) {
        boolean z2;
        boolean z3;
        if (this.f415e > 0) {
            j.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        String cVar = toString();
        int i6 = i3 - i2;
        boolean z4 = i6 != i5 - i4;
        for (int i7 = 0; i7 < i6 && !z4; i7++) {
            z4 |= charAt(i2 + i7) != charSequence.charAt(i4 + i7);
        }
        if (z4) {
            this.f419i = null;
        }
        int i8 = i();
        int h2 = h();
        int g2 = g();
        int f2 = f();
        SpannableStringBuilder replace = super.replace(i2, i3, charSequence, i4, i5);
        boolean z5 = z4;
        this.f418h.add(new e(cVar, i2, i3, charSequence, i(), h(), g(), f()));
        if (this.f414d > 0) {
            return replace;
        }
        boolean z6 = (i() == i8 && h() == h2) ? false : true;
        if (g() == g2 && f() == f2) {
            z2 = z5;
            z3 = false;
        } else {
            z2 = z5;
            z3 = true;
        }
        k(z2, z6, z3);
        return replace;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i2, int i3, int i4) {
        super.setSpan(obj, i2, i3, i4);
        this.f418h.add(new e(toString(), i(), h(), g(), f()));
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public String toString() {
        String str = this.f419i;
        if (str != null) {
            return str;
        }
        String spannableStringBuilder = super.toString();
        this.f419i = spannableStringBuilder;
        return spannableStringBuilder;
    }
}
