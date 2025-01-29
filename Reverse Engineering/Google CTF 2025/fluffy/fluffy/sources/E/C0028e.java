package e;

import K.o;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* renamed from: e.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0028e implements Iterator, Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public int f483a;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o f486d;

    /* renamed from: c, reason: collision with root package name */
    public boolean f485c = false;

    /* renamed from: b, reason: collision with root package name */
    public int f484b = -1;

    public C0028e(o oVar) {
        this.f486d = oVar;
        this.f483a = ((C0024a) oVar.f280d).f472d - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.f485c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int i2 = this.f484b;
        o oVar = this.f486d;
        Object a2 = oVar.a(i2, 0);
        if (key != a2 && (key == null || !key.equals(a2))) {
            return false;
        }
        Object value = entry.getValue();
        Object a3 = oVar.a(this.f484b, 1);
        return value == a3 || (value != null && value.equals(a3));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (!this.f485c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this.f486d.a(this.f484b, 0);
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (!this.f485c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this.f486d.a(this.f484b, 1);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f484b < this.f483a;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.f485c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        int i2 = this.f484b;
        o oVar = this.f486d;
        Object a2 = oVar.a(i2, 0);
        Object a3 = oVar.a(this.f484b, 1);
        return (a2 == null ? 0 : a2.hashCode()) ^ (a3 != null ? a3.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f484b++;
        this.f485c = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f485c) {
            throw new IllegalStateException();
        }
        this.f486d.b(this.f484b);
        this.f484b--;
        this.f483a--;
        this.f485c = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!this.f485c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        int i2 = (this.f484b << 1) + 1;
        Object[] objArr = ((C0024a) this.f486d.f280d).f471c;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
