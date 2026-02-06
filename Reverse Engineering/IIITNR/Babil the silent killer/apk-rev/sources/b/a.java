package b;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class a<K, V> extends d<K, V> implements Map<K, V> {

    /* renamed from: k, reason: collision with root package name */
    c<K, V> f102k;

    /* renamed from: b.a$a, reason: collision with other inner class name */
    class C0002a extends c<K, V> {
        C0002a() {
        }

        @Override // b.c
        protected void a() {
            a.this.clear();
        }

        @Override // b.c
        protected Object b(int i2, int i3) {
            return a.this.f127e[(i2 << 1) + i3];
        }

        @Override // b.c
        protected Map<K, V> c() {
            return a.this;
        }

        @Override // b.c
        protected int d() {
            return a.this.f128f;
        }

        @Override // b.c
        protected int e(Object obj) {
            return a.this.f(obj);
        }

        @Override // b.c
        protected int f(Object obj) {
            return a.this.h(obj);
        }

        @Override // b.c
        protected void g(K k2, V v2) {
            a.this.put(k2, v2);
        }

        @Override // b.c
        protected void h(int i2) {
            a.this.j(i2);
        }

        @Override // b.c
        protected V i(int i2, V v2) {
            return a.this.k(i2, v2);
        }
    }

    private c<K, V> m() {
        if (this.f102k == null) {
            this.f102k = new C0002a();
        }
        return this.f102k;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return m().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return m().m();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.f128f + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return m().n();
    }
}
