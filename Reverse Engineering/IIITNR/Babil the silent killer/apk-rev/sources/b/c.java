package b;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
abstract class c<K, V> {

    /* renamed from: a, reason: collision with root package name */
    c<K, V>.b f107a;

    /* renamed from: b, reason: collision with root package name */
    c<K, V>.C0003c f108b;

    /* renamed from: c, reason: collision with root package name */
    c<K, V>.e f109c;

    final class a<T> implements Iterator<T> {

        /* renamed from: d, reason: collision with root package name */
        final int f110d;

        /* renamed from: e, reason: collision with root package name */
        int f111e;

        /* renamed from: f, reason: collision with root package name */
        int f112f;

        /* renamed from: g, reason: collision with root package name */
        boolean f113g = false;

        a(int i2) {
            this.f110d = i2;
            this.f111e = c.this.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f112f < this.f111e;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t2 = (T) c.this.b(this.f112f, this.f110d);
            this.f112f++;
            this.f113g = true;
            return t2;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f113g) {
                throw new IllegalStateException();
            }
            int i2 = this.f112f - 1;
            this.f112f = i2;
            this.f111e--;
            this.f113g = false;
            c.this.h(i2);
        }
    }

    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int d2 = c.this.d();
            for (Map.Entry<K, V> entry : collection) {
                c.this.g(entry.getKey(), entry.getValue());
            }
            return d2 != c.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            c.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int e2 = c.this.e(entry.getKey());
            if (e2 < 0) {
                return false;
            }
            return b.b.b(c.this.b(e2, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return c.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i2 = 0;
            for (int d2 = c.this.d() - 1; d2 >= 0; d2--) {
                Object b2 = c.this.b(d2, 0);
                Object b3 = c.this.b(d2, 1);
                i2 += (b2 == null ? 0 : b2.hashCode()) ^ (b3 == null ? 0 : b3.hashCode());
            }
            return i2;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return c.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return c.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: b.c$c, reason: collision with other inner class name */
    final class C0003c implements Set<K> {
        C0003c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            c.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return c.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return c.j(c.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return c.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i2 = 0;
            for (int d2 = c.this.d() - 1; d2 >= 0; d2--) {
                Object b2 = c.this.b(d2, 0);
                i2 += b2 == null ? 0 : b2.hashCode();
            }
            return i2;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return c.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int e2 = c.this.e(obj);
            if (e2 < 0) {
                return false;
            }
            c.this.h(e2);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return c.o(c.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return c.p(c.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return c.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return c.this.q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) c.this.r(tArr, 0);
        }
    }

    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: d, reason: collision with root package name */
        int f117d;

        /* renamed from: f, reason: collision with root package name */
        boolean f119f = false;

        /* renamed from: e, reason: collision with root package name */
        int f118e = -1;

        d() {
            this.f117d = c.this.d() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f118e++;
            this.f119f = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f119f) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b.b.b(entry.getKey(), c.this.b(this.f118e, 0)) && b.b.b(entry.getValue(), c.this.b(this.f118e, 1));
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f119f) {
                return (K) c.this.b(this.f118e, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f119f) {
                return (V) c.this.b(this.f118e, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f118e < this.f117d;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f119f) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object b2 = c.this.b(this.f118e, 0);
            Object b3 = c.this.b(this.f118e, 1);
            return (b2 == null ? 0 : b2.hashCode()) ^ (b3 != null ? b3.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f119f) {
                throw new IllegalStateException();
            }
            c.this.h(this.f118e);
            this.f118e--;
            this.f117d--;
            this.f119f = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v2) {
            if (this.f119f) {
                return (V) c.this.i(this.f118e, v2);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class e implements Collection<V> {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(V v2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            c.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return c.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return c.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int f2 = c.this.f(obj);
            if (f2 < 0) {
                return false;
            }
            c.this.h(f2);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int d2 = c.this.d();
            int i2 = 0;
            boolean z2 = false;
            while (i2 < d2) {
                if (collection.contains(c.this.b(i2, 1))) {
                    c.this.h(i2);
                    i2--;
                    d2--;
                    z2 = true;
                }
                i2++;
            }
            return z2;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int d2 = c.this.d();
            int i2 = 0;
            boolean z2 = false;
            while (i2 < d2) {
                if (!collection.contains(c.this.b(i2, 1))) {
                    c.this.h(i2);
                    i2--;
                    d2--;
                    z2 = true;
                }
                i2++;
            }
            return z2;
        }

        @Override // java.util.Collection
        public int size() {
            return c.this.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return c.this.q(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) c.this.r(tArr, 1);
        }
    }

    c() {
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean k(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract void a();

    protected abstract Object b(int i2, int i3);

    protected abstract Map<K, V> c();

    protected abstract int d();

    protected abstract int e(Object obj);

    protected abstract int f(Object obj);

    protected abstract void g(K k2, V v2);

    protected abstract void h(int i2);

    protected abstract V i(int i2, V v2);

    public Set<Map.Entry<K, V>> l() {
        if (this.f107a == null) {
            this.f107a = new b();
        }
        return this.f107a;
    }

    public Set<K> m() {
        if (this.f108b == null) {
            this.f108b = new C0003c();
        }
        return this.f108b;
    }

    public Collection<V> n() {
        if (this.f109c == null) {
            this.f109c = new e();
        }
        return this.f109c;
    }

    public Object[] q(int i2) {
        int d2 = d();
        Object[] objArr = new Object[d2];
        for (int i3 = 0; i3 < d2; i3++) {
            objArr[i3] = b(i3, i2);
        }
        return objArr;
    }

    public <T> T[] r(T[] tArr, int i2) {
        int d2 = d();
        if (tArr.length < d2) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), d2));
        }
        for (int i3 = 0; i3 < d2; i3++) {
            tArr[i3] = b(i3, i2);
        }
        if (tArr.length > d2) {
            tArr[d2] = null;
        }
        return tArr;
    }
}
