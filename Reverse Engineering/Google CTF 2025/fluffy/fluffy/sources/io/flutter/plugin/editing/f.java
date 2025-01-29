package io.flutter.plugin.editing;

import K.r;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class f extends SpannableStringBuilder {

    /* renamed from: a, reason: collision with root package name */
    public int f649a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f650b = 0;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f651c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f652d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f653e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public String f654f;

    /* renamed from: g, reason: collision with root package name */
    public String f655g;

    /* renamed from: h, reason: collision with root package name */
    public int f656h;

    /* renamed from: i, reason: collision with root package name */
    public int f657i;

    /* renamed from: j, reason: collision with root package name */
    public int f658j;

    /* renamed from: k, reason: collision with root package name */
    public int f659k;

    /* renamed from: l, reason: collision with root package name */
    public final d f660l;

    public f(r rVar, View view) {
        this.f660l = new d(view, this);
        if (rVar != null) {
            f(rVar);
        }
    }

    public final void a(e eVar) {
        if (this.f650b > 0) {
            Log.e("ListenableEditingState", "adding a listener " + eVar.toString() + " in a listener callback");
        }
        if (this.f649a <= 0) {
            this.f651c.add(eVar);
        } else {
            Log.w("ListenableEditingState", "a listener was added to EditingState while a batch edit was in progress");
            this.f652d.add(eVar);
        }
    }

    public final void b() {
        this.f649a++;
        if (this.f650b > 0) {
            Log.e("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        if (this.f649a != 1 || this.f651c.isEmpty()) {
            return;
        }
        this.f655g = toString();
        this.f656h = Selection.getSelectionStart(this);
        this.f657i = Selection.getSelectionEnd(this);
        this.f658j = BaseInputConnection.getComposingSpanStart(this);
        this.f659k = BaseInputConnection.getComposingSpanEnd(this);
    }

    public final void c() {
        int i2 = this.f649a;
        if (i2 == 0) {
            Log.e("ListenableEditingState", "endBatchEdit called without a matching beginBatchEdit");
            return;
        }
        ArrayList arrayList = this.f651c;
        ArrayList arrayList2 = this.f652d;
        if (i2 == 1) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                this.f650b++;
                eVar.a(true);
                this.f650b--;
            }
            if (!arrayList.isEmpty()) {
                String.valueOf(arrayList.size());
                d(!toString().equals(this.f655g), (this.f656h == Selection.getSelectionStart(this) && this.f657i == Selection.getSelectionEnd(this)) ? false : true, (this.f658j == BaseInputConnection.getComposingSpanStart(this) && this.f659k == BaseInputConnection.getComposingSpanEnd(this)) ? false : true);
            }
        }
        arrayList.addAll(arrayList2);
        arrayList2.clear();
        this.f649a--;
    }

    public final void d(boolean z2, boolean z3, boolean z4) {
        if (z2 || z3 || z4) {
            Iterator it = this.f651c.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                this.f650b++;
                eVar.a(z2);
                this.f650b--;
            }
        }
    }

    public final void e(e eVar) {
        if (this.f650b > 0) {
            Log.e("ListenableEditingState", "removing a listener " + eVar.toString() + " in a listener callback");
        }
        this.f651c.remove(eVar);
        if (this.f649a > 0) {
            this.f652d.remove(eVar);
        }
    }

    public final void f(r rVar) {
        int i2;
        b();
        replace(0, length(), (CharSequence) rVar.f296a);
        int i3 = rVar.f297b;
        if (i3 >= 0) {
            Selection.setSelection(this, i3, rVar.f298c);
        } else {
            Selection.removeSelection(this);
        }
        int i4 = rVar.f299d;
        if (i4 < 0 || i4 >= (i2 = rVar.f300e)) {
            BaseInputConnection.removeComposingSpans(this);
        } else {
            this.f660l.setComposingRegion(i4, i2);
        }
        this.f653e.clear();
        c();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i2, int i3, int i4) {
        super.setSpan(obj, i2, i3, i4);
        ArrayList arrayList = this.f653e;
        String fVar = toString();
        int selectionStart = Selection.getSelectionStart(this);
        int selectionEnd = Selection.getSelectionEnd(this);
        int composingSpanStart = BaseInputConnection.getComposingSpanStart(this);
        int composingSpanEnd = BaseInputConnection.getComposingSpanEnd(this);
        h hVar = new h();
        hVar.f669e = selectionStart;
        hVar.f670f = selectionEnd;
        hVar.f671g = composingSpanStart;
        hVar.f672h = composingSpanEnd;
        hVar.f665a = fVar;
        hVar.f666b = "";
        hVar.f667c = -1;
        hVar.f668d = -1;
        arrayList.add(hVar);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final String toString() {
        String str = this.f654f;
        if (str != null) {
            return str;
        }
        String spannableStringBuilder = super.toString();
        this.f654f = spannableStringBuilder;
        return spannableStringBuilder;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i2, int i3, CharSequence charSequence, int i4, int i5) {
        if (this.f650b > 0) {
            Log.e("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        String fVar = toString();
        int i6 = i3 - i2;
        boolean z2 = i6 != i5 - i4;
        for (int i7 = 0; i7 < i6 && !z2; i7++) {
            z2 |= charAt(i2 + i7) != charSequence.charAt(i4 + i7);
        }
        if (z2) {
            this.f654f = null;
        }
        int selectionStart = Selection.getSelectionStart(this);
        int selectionEnd = Selection.getSelectionEnd(this);
        int composingSpanStart = BaseInputConnection.getComposingSpanStart(this);
        int composingSpanEnd = BaseInputConnection.getComposingSpanEnd(this);
        SpannableStringBuilder replace = super.replace(i2, i3, charSequence, i4, i5);
        ArrayList arrayList = this.f653e;
        int selectionStart2 = Selection.getSelectionStart(this);
        int selectionEnd2 = Selection.getSelectionEnd(this);
        int composingSpanStart2 = BaseInputConnection.getComposingSpanStart(this);
        int composingSpanEnd2 = BaseInputConnection.getComposingSpanEnd(this);
        h hVar = new h();
        hVar.f669e = selectionStart2;
        hVar.f670f = selectionEnd2;
        hVar.f671g = composingSpanStart2;
        hVar.f672h = composingSpanEnd2;
        String charSequence2 = charSequence.toString();
        hVar.f665a = fVar;
        hVar.f666b = charSequence2;
        hVar.f667c = i2;
        hVar.f668d = i3;
        arrayList.add(hVar);
        if (this.f649a > 0) {
            return replace;
        }
        d(z2, (Selection.getSelectionStart(this) == selectionStart && Selection.getSelectionEnd(this) == selectionEnd) ? false : true, (BaseInputConnection.getComposingSpanStart(this) == composingSpanStart && BaseInputConnection.getComposingSpanEnd(this) == composingSpanEnd) ? false : true);
        return replace;
    }
}
