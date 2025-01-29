package io.flutter.view;

import D.AbstractC0009j;
import android.graphics.Rect;
import android.opengl.Matrix;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LocaleSpan;
import android.text.style.TtsSpan;
import android.text.style.URLSpan;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public final class h {
    public String A;

    /* renamed from: D, reason: collision with root package name */
    public int f781D;

    /* renamed from: E, reason: collision with root package name */
    public int f782E;

    /* renamed from: F, reason: collision with root package name */
    public int f783F;

    /* renamed from: G, reason: collision with root package name */
    public int f784G;

    /* renamed from: H, reason: collision with root package name */
    public float f785H;
    public String I;
    public String J;

    /* renamed from: K, reason: collision with root package name */
    public float f786K;

    /* renamed from: L, reason: collision with root package name */
    public float f787L;

    /* renamed from: M, reason: collision with root package name */
    public float f788M;

    /* renamed from: N, reason: collision with root package name */
    public float f789N;

    /* renamed from: O, reason: collision with root package name */
    public float[] f790O;

    /* renamed from: P, reason: collision with root package name */
    public h f791P;

    /* renamed from: S, reason: collision with root package name */
    public ArrayList f794S;

    /* renamed from: T, reason: collision with root package name */
    public f f795T;

    /* renamed from: U, reason: collision with root package name */
    public f f796U;

    /* renamed from: W, reason: collision with root package name */
    public float[] f798W;
    public float[] Y;

    /* renamed from: Z, reason: collision with root package name */
    public Rect f800Z;

    /* renamed from: a, reason: collision with root package name */
    public final l f801a;

    /* renamed from: c, reason: collision with root package name */
    public int f803c;

    /* renamed from: d, reason: collision with root package name */
    public int f804d;

    /* renamed from: e, reason: collision with root package name */
    public int f805e;

    /* renamed from: f, reason: collision with root package name */
    public int f806f;

    /* renamed from: g, reason: collision with root package name */
    public int f807g;

    /* renamed from: h, reason: collision with root package name */
    public int f808h;

    /* renamed from: i, reason: collision with root package name */
    public int f809i;

    /* renamed from: j, reason: collision with root package name */
    public int f810j;

    /* renamed from: k, reason: collision with root package name */
    public int f811k;

    /* renamed from: l, reason: collision with root package name */
    public float f812l;
    public float m;

    /* renamed from: n, reason: collision with root package name */
    public float f813n;

    /* renamed from: o, reason: collision with root package name */
    public String f814o;

    /* renamed from: p, reason: collision with root package name */
    public String f815p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f816q;

    /* renamed from: r, reason: collision with root package name */
    public String f817r;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList f818s;

    /* renamed from: t, reason: collision with root package name */
    public String f819t;
    public ArrayList u;

    /* renamed from: v, reason: collision with root package name */
    public String f820v;

    /* renamed from: w, reason: collision with root package name */
    public ArrayList f821w;

    /* renamed from: x, reason: collision with root package name */
    public String f822x;

    /* renamed from: y, reason: collision with root package name */
    public ArrayList f823y;

    /* renamed from: z, reason: collision with root package name */
    public String f824z;

    /* renamed from: b, reason: collision with root package name */
    public int f802b = -1;

    /* renamed from: B, reason: collision with root package name */
    public int f779B = -1;

    /* renamed from: C, reason: collision with root package name */
    public boolean f780C = false;

    /* renamed from: Q, reason: collision with root package name */
    public final ArrayList f792Q = new ArrayList();

    /* renamed from: R, reason: collision with root package name */
    public final ArrayList f793R = new ArrayList();

    /* renamed from: V, reason: collision with root package name */
    public boolean f797V = true;

    /* renamed from: X, reason: collision with root package name */
    public boolean f799X = true;

    public h(l lVar) {
        this.f801a = lVar;
    }

    public static boolean a(h hVar, e eVar) {
        return (hVar.f804d & eVar.f772b) != 0;
    }

    public static CharSequence b(h hVar) {
        CharSequence[] charSequenceArr = {e(hVar.f817r, hVar.f818s), hVar.f(), e(hVar.f822x, hVar.f823y)};
        CharSequence charSequence = null;
        for (int i2 = 0; i2 < 3; i2++) {
            CharSequence charSequence2 = charSequenceArr[i2];
            if (charSequence2 != null && charSequence2.length() > 0) {
                charSequence = (charSequence == null || charSequence.length() == 0) ? charSequence2 : TextUtils.concat(charSequence, ", ", charSequence2);
            }
        }
        return charSequence;
    }

    public static boolean c(h hVar, e eVar) {
        return (hVar.f782E & eVar.f772b) != 0;
    }

    public static SpannableString e(String str, ArrayList arrayList) {
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                int a2 = n.e.a(jVar.f827c);
                if (a2 == 0) {
                    spannableString.setSpan(new TtsSpan.Builder("android.type.verbatim").build(), jVar.f825a, jVar.f826b, 0);
                } else if (a2 == 1) {
                    spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag(((g) jVar).f778d)), jVar.f825a, jVar.f826b, 0);
                } else if (a2 == 2) {
                    spannableString.setSpan(new URLSpan(((k) jVar).f828d), jVar.f825a, jVar.f826b, 0);
                }
            }
        }
        return spannableString;
    }

    public static ArrayList h(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
        int i2 = byteBuffer.getInt();
        if (i2 == -1) {
            return null;
        }
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = byteBuffer.getInt();
            int i5 = byteBuffer.getInt();
            int i6 = n.e.b(3)[byteBuffer.getInt()];
            int a2 = n.e.a(i6);
            if (a2 == 0) {
                byteBuffer.getInt();
                i iVar = new i();
                iVar.f825a = i4;
                iVar.f826b = i5;
                iVar.f827c = i6;
                arrayList.add(iVar);
            } else if (a2 == 1) {
                ByteBuffer byteBuffer2 = byteBufferArr[byteBuffer.getInt()];
                g gVar = new g();
                gVar.f825a = i4;
                gVar.f826b = i5;
                gVar.f827c = i6;
                gVar.f778d = Charset.forName("UTF-8").decode(byteBuffer2).toString();
                arrayList.add(gVar);
            }
        }
        return arrayList;
    }

    public static void l(float[] fArr, float[] fArr2, float[] fArr3) {
        Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
        float f2 = fArr[3];
        fArr[0] = fArr[0] / f2;
        fArr[1] = fArr[1] / f2;
        fArr[2] = fArr[2] / f2;
        fArr[3] = 0.0f;
    }

    public final void d(ArrayList arrayList) {
        if (i(12)) {
            arrayList.add(this);
        }
        Iterator it = this.f792Q.iterator();
        while (it.hasNext()) {
            ((h) it.next()).d(arrayList);
        }
    }

    public final SpannableString f() {
        ArrayList arrayList = this.f816q;
        String str = this.A;
        if (str != null && str.length() > 0) {
            arrayList = arrayList == null ? new ArrayList() : new ArrayList(arrayList);
            k kVar = new k();
            kVar.f825a = 0;
            kVar.f826b = this.f815p.length();
            kVar.f828d = this.A;
            kVar.f827c = 3;
            arrayList.add(kVar);
        }
        return e(this.f815p, arrayList);
    }

    public final String g() {
        String str;
        if (i(13) && (str = this.f815p) != null && !str.isEmpty()) {
            return this.f815p;
        }
        Iterator it = this.f792Q.iterator();
        while (it.hasNext()) {
            String g2 = ((h) it.next()).g();
            if (g2 != null && !g2.isEmpty()) {
                return g2;
            }
        }
        return null;
    }

    public final boolean i(int i2) {
        return (AbstractC0009j.d(i2) & this.f803c) != 0;
    }

    public final h j(float[] fArr, boolean z2) {
        float f2 = fArr[3];
        boolean z3 = false;
        float f3 = fArr[0] / f2;
        float f4 = fArr[1] / f2;
        if (f3 < this.f786K || f3 >= this.f788M || f4 < this.f787L || f4 >= this.f789N) {
            return null;
        }
        float[] fArr2 = new float[4];
        Iterator it = this.f793R.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (!hVar.i(14)) {
                if (hVar.f797V) {
                    hVar.f797V = false;
                    if (hVar.f798W == null) {
                        hVar.f798W = new float[16];
                    }
                    if (!Matrix.invertM(hVar.f798W, 0, hVar.f790O, 0)) {
                        Arrays.fill(hVar.f798W, 0.0f);
                    }
                }
                Matrix.multiplyMV(fArr2, 0, hVar.f798W, 0, fArr, 0);
                h j2 = hVar.j(fArr2, z2);
                if (j2 != null) {
                    return j2;
                }
            }
        }
        if (z2 && this.f809i != -1) {
            z3 = true;
        }
        if (k() || z3) {
            return this;
        }
        return null;
    }

    public final boolean k() {
        String str;
        String str2;
        String str3;
        if (i(12)) {
            return false;
        }
        if (i(22)) {
            return true;
        }
        int i2 = this.f804d;
        int i3 = l.f829y;
        return ((i2 & (-61)) == 0 && (this.f803c & 10682871) == 0 && ((str = this.f815p) == null || str.isEmpty()) && (((str2 = this.f817r) == null || str2.isEmpty()) && ((str3 = this.f822x) == null || str3.isEmpty()))) ? false : true;
    }

    public final void m(float[] fArr, HashSet hashSet, boolean z2) {
        hashSet.add(this);
        if (this.f799X) {
            z2 = true;
        }
        if (z2) {
            if (this.Y == null) {
                this.Y = new float[16];
            }
            if (this.f790O == null) {
                this.f790O = new float[16];
            }
            Matrix.multiplyMM(this.Y, 0, fArr, 0, this.f790O, 0);
            float[] fArr2 = {this.f786K, this.f787L, 0.0f, 1.0f};
            float[] fArr3 = new float[4];
            float[] fArr4 = new float[4];
            float[] fArr5 = new float[4];
            float[] fArr6 = new float[4];
            l(fArr3, this.Y, fArr2);
            fArr2[0] = this.f788M;
            fArr2[1] = this.f787L;
            l(fArr4, this.Y, fArr2);
            fArr2[0] = this.f788M;
            fArr2[1] = this.f789N;
            l(fArr5, this.Y, fArr2);
            fArr2[0] = this.f786K;
            fArr2[1] = this.f789N;
            l(fArr6, this.Y, fArr2);
            if (this.f800Z == null) {
                this.f800Z = new Rect();
            }
            this.f800Z.set(Math.round(Math.min(fArr3[0], Math.min(fArr4[0], Math.min(fArr5[0], fArr6[0])))), Math.round(Math.min(fArr3[1], Math.min(fArr4[1], Math.min(fArr5[1], fArr6[1])))), Math.round(Math.max(fArr3[0], Math.max(fArr4[0], Math.max(fArr5[0], fArr6[0])))), Math.round(Math.max(fArr3[1], Math.max(fArr4[1], Math.max(fArr5[1], fArr6[1])))));
            this.f799X = false;
        }
        Iterator it = this.f792Q.iterator();
        int i2 = -1;
        while (it.hasNext()) {
            h hVar = (h) it.next();
            hVar.f779B = i2;
            i2 = hVar.f802b;
            hVar.m(this.Y, hashSet, z2);
        }
    }
}
