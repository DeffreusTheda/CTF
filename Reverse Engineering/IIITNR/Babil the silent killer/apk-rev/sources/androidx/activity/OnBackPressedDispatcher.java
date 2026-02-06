package androidx.activity;

import androidx.lifecycle.c;
import androidx.lifecycle.d;
import androidx.lifecycle.f;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    private class LifecycleOnBackPressedCancellable implements d, a {

        /* renamed from: a, reason: collision with root package name */
        private final c f28a;

        /* renamed from: b, reason: collision with root package name */
        private a f29b;

        @Override // androidx.activity.a
        public void cancel() {
            this.f28a.b(this);
            throw null;
        }

        @Override // androidx.lifecycle.d
        public void g(f fVar, c.a aVar) {
            if (aVar == c.a.ON_START) {
                throw null;
            }
            if (aVar != c.a.ON_STOP) {
                if (aVar == c.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                a aVar2 = this.f29b;
                if (aVar2 != null) {
                    aVar2.cancel();
                }
            }
        }
    }
}
