package d;

import java.util.Iterator;

/* renamed from: d.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0021b extends a.a implements Iterator {

    /* renamed from: e, reason: collision with root package name */
    public final C0022c f449e;

    /* renamed from: f, reason: collision with root package name */
    public C0022c f450f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f451g;

    public C0021b(C0022c c0022c, C0022c c0022c2, int i2) {
        this.f451g = i2;
        this.f449e = c0022c2;
        this.f450f = c0022c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f450f != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        C0022c c0022c;
        C0022c c0022c2 = this.f450f;
        C0022c c0022c3 = this.f449e;
        if (c0022c2 != c0022c3 && c0022c3 != null) {
            switch (this.f451g) {
                case 0:
                    c0022c = c0022c2.f454c;
                    break;
                default:
                    c0022c = c0022c2.f455d;
                    break;
            }
        } else {
            c0022c = null;
        }
        this.f450f = c0022c;
        return c0022c2;
    }
}
