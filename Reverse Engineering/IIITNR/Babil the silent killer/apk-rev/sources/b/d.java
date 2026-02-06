package b;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class d<K, V> {

    /* renamed from: g, reason: collision with root package name */
    static Object[] f122g;

    /* renamed from: h, reason: collision with root package name */
    static int f123h;

    /* renamed from: i, reason: collision with root package name */
    static Object[] f124i;

    /* renamed from: j, reason: collision with root package name */
    static int f125j;

    /* renamed from: d, reason: collision with root package name */
    int[] f126d = b.f104a;

    /* renamed from: e, reason: collision with root package name */
    Object[] f127e = b.f106c;

    /* renamed from: f, reason: collision with root package name */
    int f128f = 0;

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (d.class) {
                Object[] objArr = f124i;
                if (objArr != null) {
                    this.f127e = objArr;
                    f124i = (Object[]) objArr[0];
                    this.f126d = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f125j--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (d.class) {
                Object[] objArr2 = f122g;
                if (objArr2 != null) {
                    this.f127e = objArr2;
                    f122g = (Object[]) objArr2[0];
                    this.f126d = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f123h--;
                    return;
                }
            }
        }
        this.f126d = new int[i2];
        this.f127e = new Object[i2 << 1];
    }

    private static int b(int[] iArr, int i2, int i3) {
        try {
            return b.a(iArr, i2, i3);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (d.class) {
                if (f125j < 10) {
                    objArr[0] = f124i;
                    objArr[1] = iArr;
                    for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f124i = objArr;
                    f125j++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (d.class) {
                if (f123h < 10) {
                    objArr[0] = f122g;
                    objArr[1] = iArr;
                    for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f122g = objArr;
                    f123h++;
                }
            }
        }
    }

    public void c(int i2) {
        int i3 = this.f128f;
        int[] iArr = this.f126d;
        if (iArr.length < i2) {
            Object[] objArr = this.f127e;
            a(i2);
            if (this.f128f > 0) {
                System.arraycopy(iArr, 0, this.f126d, 0, i3);
                System.arraycopy(objArr, 0, this.f127e, 0, i3 << 1);
            }
            d(iArr, objArr, i3);
        }
        if (this.f128f != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i2 = this.f128f;
        if (i2 > 0) {
            int[] iArr = this.f126d;
            Object[] objArr = this.f127e;
            this.f126d = b.f104a;
            this.f127e = b.f106c;
            this.f128f = 0;
            d(iArr, objArr, i2);
        }
        if (this.f128f > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    int e(Object obj, int i2) {
        int i3 = this.f128f;
        if (i3 == 0) {
            return -1;
        }
        int b2 = b(this.f126d, i3, i2);
        if (b2 < 0 || obj.equals(this.f127e[b2 << 1])) {
            return b2;
        }
        int i4 = b2 + 1;
        while (i4 < i3 && this.f126d[i4] == i2) {
            if (obj.equals(this.f127e[i4 << 1])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = b2 - 1; i5 >= 0 && this.f126d[i5] == i2; i5--) {
            if (obj.equals(this.f127e[i5 << 1])) {
                return i5;
            }
        }
        return i4 ^ (-1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (size() != dVar.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f128f; i2++) {
                try {
                    K i3 = i(i2);
                    V l2 = l(i2);
                    Object obj2 = dVar.get(i3);
                    if (l2 == null) {
                        if (obj2 != null || !dVar.containsKey(i3)) {
                            return false;
                        }
                    } else if (!l2.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i4 = 0; i4 < this.f128f; i4++) {
                try {
                    K i5 = i(i4);
                    V l3 = l(i4);
                    Object obj3 = map.get(i5);
                    if (l3 == null) {
                        if (obj3 != null || !map.containsKey(i5)) {
                            return false;
                        }
                    } else if (!l3.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    int g() {
        int i2 = this.f128f;
        if (i2 == 0) {
            return -1;
        }
        int b2 = b(this.f126d, i2, 0);
        if (b2 < 0 || this.f127e[b2 << 1] == null) {
            return b2;
        }
        int i3 = b2 + 1;
        while (i3 < i2 && this.f126d[i3] == 0) {
            if (this.f127e[i3 << 1] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = b2 - 1; i4 >= 0 && this.f126d[i4] == 0; i4--) {
            if (this.f127e[i4 << 1] == null) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v2) {
        int f2 = f(obj);
        return f2 >= 0 ? (V) this.f127e[(f2 << 1) + 1] : v2;
    }

    int h(Object obj) {
        int i2 = this.f128f * 2;
        Object[] objArr = this.f127e;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.f126d;
        Object[] objArr = this.f127e;
        int i2 = this.f128f;
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            i5 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
            i4++;
            i3 += 2;
        }
        return i5;
    }

    public K i(int i2) {
        return (K) this.f127e[i2 << 1];
    }

    public boolean isEmpty() {
        return this.f128f <= 0;
    }

    public V j(int i2) {
        Object[] objArr = this.f127e;
        int i3 = i2 << 1;
        V v2 = (V) objArr[i3 + 1];
        int i4 = this.f128f;
        int i5 = 0;
        if (i4 <= 1) {
            d(this.f126d, objArr, i4);
            this.f126d = b.f104a;
            this.f127e = b.f106c;
        } else {
            int i6 = i4 - 1;
            int[] iArr = this.f126d;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i2 < i6) {
                    int i7 = i2 + 1;
                    int i8 = i6 - i2;
                    System.arraycopy(iArr, i7, iArr, i2, i8);
                    Object[] objArr2 = this.f127e;
                    System.arraycopy(objArr2, i7 << 1, objArr2, i3, i8 << 1);
                }
                Object[] objArr3 = this.f127e;
                int i9 = i6 << 1;
                objArr3[i9] = null;
                objArr3[i9 + 1] = null;
            } else {
                a(i4 > 8 ? i4 + (i4 >> 1) : 8);
                if (i4 != this.f128f) {
                    throw new ConcurrentModificationException();
                }
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.f126d, 0, i2);
                    System.arraycopy(objArr, 0, this.f127e, 0, i3);
                }
                if (i2 < i6) {
                    int i10 = i2 + 1;
                    int i11 = i6 - i2;
                    System.arraycopy(iArr, i10, this.f126d, i2, i11);
                    System.arraycopy(objArr, i10 << 1, this.f127e, i3, i11 << 1);
                }
            }
            i5 = i6;
        }
        if (i4 != this.f128f) {
            throw new ConcurrentModificationException();
        }
        this.f128f = i5;
        return v2;
    }

    public V k(int i2, V v2) {
        int i3 = (i2 << 1) + 1;
        Object[] objArr = this.f127e;
        V v3 = (V) objArr[i3];
        objArr[i3] = v2;
        return v3;
    }

    public V l(int i2) {
        return (V) this.f127e[(i2 << 1) + 1];
    }

    public V put(K k2, V v2) {
        int i2;
        int e2;
        int i3 = this.f128f;
        if (k2 == null) {
            e2 = g();
            i2 = 0;
        } else {
            int hashCode = k2.hashCode();
            i2 = hashCode;
            e2 = e(k2, hashCode);
        }
        if (e2 >= 0) {
            int i4 = (e2 << 1) + 1;
            Object[] objArr = this.f127e;
            V v3 = (V) objArr[i4];
            objArr[i4] = v2;
            return v3;
        }
        int i5 = e2 ^ (-1);
        int[] iArr = this.f126d;
        if (i3 >= iArr.length) {
            int i6 = 4;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i6 = 8;
            }
            Object[] objArr2 = this.f127e;
            a(i6);
            if (i3 != this.f128f) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f126d;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f127e, 0, objArr2.length);
            }
            d(iArr, objArr2, i3);
        }
        if (i5 < i3) {
            int[] iArr3 = this.f126d;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr3 = this.f127e;
            System.arraycopy(objArr3, i5 << 1, objArr3, i7 << 1, (this.f128f - i5) << 1);
        }
        int i8 = this.f128f;
        if (i3 == i8) {
            int[] iArr4 = this.f126d;
            if (i5 < iArr4.length) {
                iArr4[i5] = i2;
                Object[] objArr4 = this.f127e;
                int i9 = i5 << 1;
                objArr4[i9] = k2;
                objArr4[i9 + 1] = v2;
                this.f128f = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k2, V v2) {
        V v3 = get(k2);
        return v3 == null ? put(k2, v2) : v3;
    }

    public V remove(Object obj) {
        int f2 = f(obj);
        if (f2 >= 0) {
            return j(f2);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int f2 = f(obj);
        if (f2 < 0) {
            return false;
        }
        V l2 = l(f2);
        if (obj2 != l2 && (obj2 == null || !obj2.equals(l2))) {
            return false;
        }
        j(f2);
        return true;
    }

    public V replace(K k2, V v2) {
        int f2 = f(k2);
        if (f2 >= 0) {
            return k(f2, v2);
        }
        return null;
    }

    public boolean replace(K k2, V v2, V v3) {
        int f2 = f(k2);
        if (f2 < 0) {
            return false;
        }
        V l2 = l(f2);
        if (l2 != v2 && (v2 == null || !v2.equals(l2))) {
            return false;
        }
        k(f2, v3);
        return true;
    }

    public int size() {
        return this.f128f;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f128f * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f128f; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            K i3 = i(i2);
            if (i3 != this) {
                sb.append(i3);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V l2 = l(i2);
            if (l2 != this) {
                sb.append(l2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
