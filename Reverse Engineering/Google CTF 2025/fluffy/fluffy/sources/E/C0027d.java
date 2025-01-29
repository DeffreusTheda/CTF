package e;

import K.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: e.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0027d implements Set {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f481b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f482c;

    public /* synthetic */ C0027d(o oVar, int i2) {
        this.f481b = i2;
        this.f482c = oVar;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.f481b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.f481b) {
            case 0:
                o oVar = this.f482c;
                int i2 = ((C0024a) oVar.f280d).f472d;
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    ((C0024a) oVar.f280d).put(entry.getKey(), entry.getValue());
                }
                return i2 != ((C0024a) oVar.f280d).f472d;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        switch (this.f481b) {
            case 0:
                ((C0024a) this.f482c.f280d).clear();
                break;
            default:
                ((C0024a) this.f482c.f280d).clear();
                break;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f481b) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    o oVar = this.f482c;
                    int e2 = ((C0024a) oVar.f280d).e(key);
                    if (e2 >= 0) {
                        Object a2 = oVar.a(e2, 1);
                        Object value = entry.getValue();
                        if (a2 == value || (a2 != null && a2.equals(value))) {
                        }
                    }
                }
                break;
            default:
                if (((C0024a) this.f482c.f280d).e(obj) >= 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        switch (this.f481b) {
            case 0:
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    if (!contains(it.next())) {
                        break;
                    }
                }
                break;
            default:
                C0024a c0024a = (C0024a) this.f482c.f280d;
                Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    if (!c0024a.containsKey(it2.next())) {
                        break;
                    }
                }
                break;
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        switch (this.f481b) {
        }
        return o.c(this, obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        switch (this.f481b) {
            case 0:
                o oVar = this.f482c;
                int i2 = 0;
                for (int i3 = ((C0024a) oVar.f280d).f472d - 1; i3 >= 0; i3--) {
                    Object a2 = oVar.a(i3, 0);
                    Object a3 = oVar.a(i3, 1);
                    i2 += (a2 == null ? 0 : a2.hashCode()) ^ (a3 == null ? 0 : a3.hashCode());
                }
                return i2;
            default:
                o oVar2 = this.f482c;
                int i4 = 0;
                for (int i5 = ((C0024a) oVar2.f280d).f472d - 1; i5 >= 0; i5--) {
                    Object a4 = oVar2.a(i5, 0);
                    i4 += a4 == null ? 0 : a4.hashCode();
                }
                return i4;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        switch (this.f481b) {
            case 0:
                if (((C0024a) this.f482c.f280d).f472d == 0) {
                }
                break;
            default:
                if (((C0024a) this.f482c.f280d).f472d == 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f481b) {
            case 0:
                return new C0028e(this.f482c);
            default:
                return new C0026c(this.f482c, 0);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        switch (this.f481b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                o oVar = this.f482c;
                int e2 = ((C0024a) oVar.f280d).e(obj);
                if (e2 < 0) {
                    return false;
                }
                oVar.b(e2);
                return true;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.f481b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                C0024a c0024a = (C0024a) this.f482c.f280d;
                int size = c0024a.size();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    c0024a.remove(it.next());
                }
                return size != c0024a.size();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.f481b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                C0024a c0024a = (C0024a) this.f482c.f280d;
                int size = c0024a.size();
                Iterator it = c0024a.keySet().iterator();
                while (it.hasNext()) {
                    if (!collection.contains(it.next())) {
                        it.remove();
                    }
                }
                return size != c0024a.size();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        switch (this.f481b) {
        }
        return ((C0024a) this.f482c.f280d).f472d;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        switch (this.f481b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                o oVar = this.f482c;
                int i2 = ((C0024a) oVar.f280d).f472d;
                Object[] objArr = new Object[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    objArr[i3] = oVar.a(i3, 0);
                }
                return objArr;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.f481b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                return this.f482c.d(objArr, 0);
        }
    }
}
