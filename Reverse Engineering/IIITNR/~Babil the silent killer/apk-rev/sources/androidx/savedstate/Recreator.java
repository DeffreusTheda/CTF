package androidx.savedstate;

import android.annotation.SuppressLint;
import androidx.lifecycle.c;
import androidx.lifecycle.d;
import androidx.lifecycle.f;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
final class Recreator implements d {

    /* renamed from: a, reason: collision with root package name */
    private final b f76a;

    @Override // androidx.lifecycle.d
    public void g(f fVar, c.a aVar) {
        if (aVar != c.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        fVar.d().b(this);
        this.f76a.j();
        throw null;
    }
}
