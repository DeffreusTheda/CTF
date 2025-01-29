package io.flutter.view;

import android.view.View;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final View f858a;

    /* renamed from: b, reason: collision with root package name */
    public final int f859b;

    public n(View view, int i2) {
        this.f858a = view;
        this.f859b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f859b == nVar.f859b && this.f858a.equals(nVar.f858a);
    }

    public final int hashCode() {
        return ((this.f858a.hashCode() + 31) * 31) + this.f859b;
    }
}
