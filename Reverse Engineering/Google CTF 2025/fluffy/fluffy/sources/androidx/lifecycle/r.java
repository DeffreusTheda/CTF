package androidx.lifecycle;

import D.v;
import android.os.Handler;

/* loaded from: classes.dex */
public final class r implements l {

    /* renamed from: i, reason: collision with root package name */
    public static final r f420i = new r();

    /* renamed from: a, reason: collision with root package name */
    public int f421a;

    /* renamed from: b, reason: collision with root package name */
    public int f422b;

    /* renamed from: e, reason: collision with root package name */
    public Handler f425e;

    /* renamed from: c, reason: collision with root package name */
    public boolean f423c = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f424d = true;

    /* renamed from: f, reason: collision with root package name */
    public final n f426f = new n(this);

    /* renamed from: g, reason: collision with root package name */
    public final H.c f427g = new H.c(1, this);

    /* renamed from: h, reason: collision with root package name */
    public final v f428h = new v(25, this);

    @Override // androidx.lifecycle.l
    public final n a() {
        return this.f426f;
    }

    public final void b() {
        int i2 = this.f422b + 1;
        this.f422b = i2;
        if (i2 == 1) {
            if (this.f423c) {
                this.f426f.c(f.ON_RESUME);
                this.f423c = false;
            } else {
                Handler handler = this.f425e;
                a0.h.b(handler);
                handler.removeCallbacks(this.f427g);
            }
        }
    }
}
