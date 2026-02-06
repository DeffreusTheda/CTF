package a;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: d, reason: collision with root package name */
    c<K, V> f1d;

    /* renamed from: e, reason: collision with root package name */
    private c<K, V> f2e;

    /* renamed from: f, reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f3f = new WeakHashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private int f4g = 0;

    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // a.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f8g;
        }

        @Override // a.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f7f;
        }
    }

    /* renamed from: a.b$b, reason: collision with other inner class name */
    private static class C0000b<K, V> extends e<K, V> {
        C0000b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // a.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f7f;
        }

        @Override // a.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f8g;
        }
    }

    static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: d, reason: collision with root package name */
        final K f5d;

        /* renamed from: e, reason: collision with root package name */
        final V f6e;

        /* renamed from: f, reason: collision with root package name */
        c<K, V> f7f;

        /* renamed from: g, reason: collision with root package name */
        c<K, V> f8g;

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f5d.equals(cVar.f5d) && this.f6e.equals(cVar.f6e);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f5d;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f6e;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f5d.hashCode() ^ this.f6e.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v2) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f5d + "=" + this.f6e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: d, reason: collision with root package name */
        private c<K, V> f9d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f10e = true;

        d() {
        }

        @Override // a.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f9d;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f8g;
                this.f9d = cVar3;
                this.f10e = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar;
            if (this.f10e) {
                this.f10e = false;
                cVar = b.this.f1d;
            } else {
                c<K, V> cVar2 = this.f9d;
                cVar = cVar2 != null ? cVar2.f7f : null;
            }
            this.f9d = cVar;
            return this.f9d;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f10e) {
                return b.this.f1d != null;
            }
            c<K, V> cVar = this.f9d;
            return (cVar == null || cVar.f7f == null) ? false : true;
        }
    }

    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: d, reason: collision with root package name */
        c<K, V> f12d;

        /* renamed from: e, reason: collision with root package name */
        c<K, V> f13e;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f12d = cVar2;
            this.f13e = cVar;
        }

        private c<K, V> e() {
            c<K, V> cVar = this.f13e;
            c<K, V> cVar2 = this.f12d;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // a.b.f
        public void a(c<K, V> cVar) {
            if (this.f12d == cVar && cVar == this.f13e) {
                this.f13e = null;
                this.f12d = null;
            }
            c<K, V> cVar2 = this.f12d;
            if (cVar2 == cVar) {
                this.f12d = b(cVar2);
            }
            if (this.f13e == cVar) {
                this.f13e = e();
            }
        }

        abstract c<K, V> b(c<K, V> cVar);

        abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f13e;
            this.f13e = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13e != null;
        }
    }

    interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public Iterator<Map.Entry<K, V>> a() {
        C0000b c0000b = new C0000b(this.f2e, this.f1d);
        this.f3f.put(c0000b, Boolean.FALSE);
        return c0000b;
    }

    public Map.Entry<K, V> b() {
        return this.f1d;
    }

    protected c<K, V> c(K k2) {
        c<K, V> cVar = this.f1d;
        while (cVar != null && !cVar.f5d.equals(k2)) {
            cVar = cVar.f7f;
        }
        return cVar;
    }

    public b<K, V>.d d() {
        b<K, V>.d dVar = new d();
        this.f3f.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> e() {
        return this.f2e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public V f(K k2) {
        c<K, V> c2 = c(k2);
        if (c2 == null) {
            return null;
        }
        this.f4g--;
        if (!this.f3f.isEmpty()) {
            Iterator<f<K, V>> it = this.f3f.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(c2);
            }
        }
        c<K, V> cVar = c2.f8g;
        c<K, V> cVar2 = c2.f7f;
        if (cVar != null) {
            cVar.f7f = cVar2;
        } else {
            this.f1d = cVar2;
        }
        c<K, V> cVar3 = c2.f7f;
        if (cVar3 != null) {
            cVar3.f8g = cVar;
        } else {
            this.f2e = cVar;
        }
        c2.f7f = null;
        c2.f8g = null;
        return c2.f6e;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += it.next().hashCode();
        }
        return i2;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f1d, this.f2e);
        this.f3f.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f4g;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
