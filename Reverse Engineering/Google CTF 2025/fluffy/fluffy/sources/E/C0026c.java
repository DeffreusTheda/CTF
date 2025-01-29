package e;

import K.o;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: e.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0026c implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final int f476a;

    /* renamed from: b, reason: collision with root package name */
    public int f477b;

    /* renamed from: c, reason: collision with root package name */
    public int f478c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f479d = false;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o f480e;

    public C0026c(o oVar, int i2) {
        this.f480e = oVar;
        this.f476a = i2;
        this.f477b = ((C0024a) oVar.f280d).f472d;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f478c < this.f477b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object a2 = this.f480e.a(this.f478c, this.f476a);
        this.f478c++;
        this.f479d = true;
        return a2;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f479d) {
            throw new IllegalStateException();
        }
        int i2 = this.f478c - 1;
        this.f478c = i2;
        this.f477b--;
        this.f479d = false;
        this.f480e.b(i2);
    }
}
