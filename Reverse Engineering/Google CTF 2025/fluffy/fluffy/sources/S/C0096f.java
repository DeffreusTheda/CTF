package s;

import D.AbstractC0009j;
import R.m;
import Z.l;
import android.util.Log;
import java.util.ArrayList;

/* renamed from: s.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0096f extends AbstractC0097g {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1159a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1160b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1161c;

    /* renamed from: d, reason: collision with root package name */
    public final C0100j f1162d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [R.m] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList] */
    public C0096f(Object obj, String str, C0091a c0091a, int i2) {
        a0.h.e(obj, "value");
        AbstractC0009j.f("verificationMode", i2);
        this.f1159a = obj;
        this.f1160b = str;
        this.f1161c = i2;
        String b2 = AbstractC0097g.b(obj, str);
        a0.h.e(b2, "message");
        C0100j c0100j = new C0100j(b2);
        StackTraceElement[] stackTrace = c0100j.getStackTrace();
        a0.h.d(stackTrace, "stackTrace");
        int length = stackTrace.length - 2;
        length = length < 0 ? 0 : length;
        if (length < 0) {
            throw new IllegalArgumentException(("Requested element count " + length + " is less than zero.").toString());
        }
        ?? r0 = m.f335b;
        if (length != 0) {
            int length2 = stackTrace.length;
            if (length >= length2) {
                int length3 = stackTrace.length;
                if (length3 != 0) {
                    r0 = length3 != 1 ? new ArrayList(new R.b(stackTrace, false)) : a.a.n(stackTrace[0]);
                }
            } else if (length == 1) {
                r0 = a.a.n(stackTrace[length2 - 1]);
            } else {
                r0 = new ArrayList(length);
                for (int i3 = length2 - length; i3 < length2; i3++) {
                    r0.add(stackTrace[i3]);
                }
            }
        }
        c0100j.setStackTrace((StackTraceElement[]) r0.toArray(new StackTraceElement[0]));
        this.f1162d = c0100j;
    }

    @Override // s.AbstractC0097g
    public final Object a() {
        int a2 = n.e.a(this.f1161c);
        if (a2 == 0) {
            throw this.f1162d;
        }
        if (a2 != 1) {
            if (a2 == 2) {
                return null;
            }
            throw new B.c();
        }
        String b2 = AbstractC0097g.b(this.f1159a, this.f1160b);
        a0.h.e(b2, "message");
        Log.d("f", b2);
        return null;
    }

    @Override // s.AbstractC0097g
    public final AbstractC0097g d(String str, l lVar) {
        return this;
    }
}
