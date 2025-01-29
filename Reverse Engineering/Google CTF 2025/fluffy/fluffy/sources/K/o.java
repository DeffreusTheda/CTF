package K;

import e.C0024a;
import java.lang.reflect.Array;
import java.util.Set;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public Object f277a;

    /* renamed from: b, reason: collision with root package name */
    public Object f278b;

    /* renamed from: c, reason: collision with root package name */
    public Object f279c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f280d;

    public o(C0024a c0024a) {
        this.f280d = c0024a;
    }

    public static boolean c(Set set, Object obj) {
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

    public Object a(int i2, int i3) {
        return ((C0024a) this.f280d).f471c[(i2 << 1) + i3];
    }

    public void b(int i2) {
        ((C0024a) this.f280d).h(i2);
    }

    public Object[] d(Object[] objArr, int i2) {
        int i3 = ((C0024a) this.f280d).f472d;
        if (objArr.length < i3) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i3);
        }
        for (int i4 = 0; i4 < i3; i4++) {
            objArr[i4] = a(i4, i2);
        }
        if (objArr.length > i3) {
            objArr[i3] = null;
        }
        return objArr;
    }

    public o(String str, String[] strArr, String str2, r rVar) {
        this.f277a = str;
        this.f279c = strArr;
        this.f278b = str2;
        this.f280d = rVar;
    }
}
