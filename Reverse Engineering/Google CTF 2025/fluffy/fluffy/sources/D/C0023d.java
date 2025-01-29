package d;

import java.util.Iterator;

/* renamed from: d.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0023d extends a.a implements Iterator {

    /* renamed from: e, reason: collision with root package name */
    public C0022c f456e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f457f = true;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ C0020a f458g;

    public C0023d(C0020a c0020a) {
        this.f458g = c0020a;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f457f) {
            return this.f458g.f444b != null;
        }
        C0022c c0022c = this.f456e;
        return (c0022c == null || c0022c.f454c == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f457f) {
            this.f457f = false;
            this.f456e = this.f458g.f444b;
        } else {
            C0022c c0022c = this.f456e;
            this.f456e = c0022c != null ? c0022c.f454c : null;
        }
        return this.f456e;
    }
}
