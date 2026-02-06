package a;

import a.b;
import java.util.HashMap;

/* loaded from: classes.dex */
public class a<K, V> extends b<K, V> {

    /* renamed from: h, reason: collision with root package name */
    private HashMap<K, b.c<K, V>> f0h = new HashMap<>();

    @Override // a.b
    protected b.c<K, V> c(K k2) {
        return this.f0h.get(k2);
    }

    public boolean contains(K k2) {
        return this.f0h.containsKey(k2);
    }

    @Override // a.b
    public V f(K k2) {
        V v2 = (V) super.f(k2);
        this.f0h.remove(k2);
        return v2;
    }
}
