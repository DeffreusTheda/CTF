package l0;

import a0.h;
import k0.i;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: b, reason: collision with root package name */
    public b[] f976b;

    /* renamed from: c, reason: collision with root package name */
    public int f977c;

    /* renamed from: d, reason: collision with root package name */
    public int f978d;

    public final void c(i iVar) {
        synchronized (this) {
            try {
                int i2 = this.f977c - 1;
                this.f977c = i2;
                if (i2 == 0) {
                    this.f978d = 0;
                }
                h.c(iVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                i.f944a.set(iVar, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
