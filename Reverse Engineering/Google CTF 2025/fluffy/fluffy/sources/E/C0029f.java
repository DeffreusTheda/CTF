package e;

import K.o;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: e.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0029f implements Collection {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f487b;

    public C0029f(o oVar) {
        this.f487b = oVar;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        ((C0024a) this.f487b.f280d).clear();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return ((C0024a) this.f487b.f280d).g(obj) >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return ((C0024a) this.f487b.f280d).f472d == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new C0026c(this.f487b, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        o oVar = this.f487b;
        int g2 = ((C0024a) oVar.f280d).g(obj);
        if (g2 < 0) {
            return false;
        }
        oVar.b(g2);
        return true;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        o oVar = this.f487b;
        int i2 = ((C0024a) oVar.f280d).f472d;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < i2) {
            if (collection.contains(oVar.a(i3, 1))) {
                oVar.b(i3);
                i3--;
                i2--;
                z2 = true;
            }
            i3++;
        }
        return z2;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        o oVar = this.f487b;
        int i2 = ((C0024a) oVar.f280d).f472d;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < i2) {
            if (!collection.contains(oVar.a(i3, 1))) {
                oVar.b(i3);
                i3--;
                i2--;
                z2 = true;
            }
            i3++;
        }
        return z2;
    }

    @Override // java.util.Collection
    public final int size() {
        return ((C0024a) this.f487b.f280d).f472d;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        o oVar = this.f487b;
        int i2 = ((C0024a) oVar.f280d).f472d;
        Object[] objArr = new Object[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = oVar.a(i3, 1);
        }
        return objArr;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return this.f487b.d(objArr, 1);
    }
}
