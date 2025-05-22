package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlinx.coroutines.internal.e0;

/* loaded from: classes.dex */
public class d0<T extends e0 & Comparable<? super T>> {
    private volatile /* synthetic */ int _size = 0;

    /* renamed from: a, reason: collision with root package name */
    private T[] f809a;

    private final T[] f() {
        T[] tArr = this.f809a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new e0[4];
            this.f809a = tArr2;
            return tArr2;
        }
        if (c() < tArr.length) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, c() * 2);
        kotlin.jvm.internal.i.d(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((e0[]) copyOf);
        this.f809a = tArr3;
        return tArr3;
    }

    private final void j(int i2) {
        this._size = i2;
    }

    private final void k(int i2) {
        while (true) {
            int i3 = (i2 * 2) + 1;
            if (i3 >= c()) {
                return;
            }
            T[] tArr = this.f809a;
            kotlin.jvm.internal.i.b(tArr);
            int i4 = i3 + 1;
            if (i4 < c()) {
                T t2 = tArr[i4];
                kotlin.jvm.internal.i.b(t2);
                T t3 = tArr[i3];
                kotlin.jvm.internal.i.b(t3);
                if (((Comparable) t2).compareTo(t3) < 0) {
                    i3 = i4;
                }
            }
            T t4 = tArr[i2];
            kotlin.jvm.internal.i.b(t4);
            T t5 = tArr[i3];
            kotlin.jvm.internal.i.b(t5);
            if (((Comparable) t4).compareTo(t5) <= 0) {
                return;
            }
            m(i2, i3);
            i2 = i3;
        }
    }

    private final void l(int i2) {
        while (i2 > 0) {
            T[] tArr = this.f809a;
            kotlin.jvm.internal.i.b(tArr);
            int i3 = (i2 - 1) / 2;
            T t2 = tArr[i3];
            kotlin.jvm.internal.i.b(t2);
            T t3 = tArr[i2];
            kotlin.jvm.internal.i.b(t3);
            if (((Comparable) t2).compareTo(t3) <= 0) {
                return;
            }
            m(i2, i3);
            i2 = i3;
        }
    }

    private final void m(int i2, int i3) {
        T[] tArr = this.f809a;
        kotlin.jvm.internal.i.b(tArr);
        T t2 = tArr[i3];
        kotlin.jvm.internal.i.b(t2);
        T t3 = tArr[i2];
        kotlin.jvm.internal.i.b(t3);
        tArr[i2] = t2;
        tArr[i3] = t3;
        t2.c(i2);
        t3.c(i3);
    }

    public final void a(T t2) {
        t2.d(this);
        T[] f2 = f();
        int c2 = c();
        j(c2 + 1);
        f2[c2] = t2;
        t2.c(c2);
        l(c2);
    }

    public final T b() {
        T[] tArr = this.f809a;
        if (tArr == null) {
            return null;
        }
        return tArr[0];
    }

    public final int c() {
        return this._size;
    }

    public final boolean d() {
        return c() == 0;
    }

    public final T e() {
        T b2;
        synchronized (this) {
            b2 = b();
        }
        return b2;
    }

    public final boolean g(T t2) {
        boolean z2;
        synchronized (this) {
            if (t2.a() == null) {
                z2 = false;
            } else {
                h(t2.e());
                z2 = true;
            }
        }
        return z2;
    }

    public final T h(int i2) {
        T[] tArr = this.f809a;
        kotlin.jvm.internal.i.b(tArr);
        j(c() - 1);
        if (i2 < c()) {
            m(i2, c());
            int i3 = (i2 - 1) / 2;
            if (i2 > 0) {
                T t2 = tArr[i2];
                kotlin.jvm.internal.i.b(t2);
                T t3 = tArr[i3];
                kotlin.jvm.internal.i.b(t3);
                if (((Comparable) t2).compareTo(t3) < 0) {
                    m(i2, i3);
                    l(i3);
                }
            }
            k(i2);
        }
        T t4 = tArr[c()];
        kotlin.jvm.internal.i.b(t4);
        t4.d(null);
        t4.c(-1);
        tArr[c()] = null;
        return t4;
    }

    public final T i() {
        T h2;
        synchronized (this) {
            h2 = c() > 0 ? h(0) : null;
        }
        return h2;
    }
}
