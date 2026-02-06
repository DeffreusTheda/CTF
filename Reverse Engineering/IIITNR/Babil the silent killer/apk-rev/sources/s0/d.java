package s0;

import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.internal.y;

/* loaded from: classes.dex */
public class d<E> extends s0.a<E> {

    /* renamed from: e, reason: collision with root package name */
    private final int f1111e;

    /* renamed from: f, reason: collision with root package name */
    private final e f1112f;

    /* renamed from: g, reason: collision with root package name */
    private final ReentrantLock f1113g;

    /* renamed from: h, reason: collision with root package name */
    private Object[] f1114h;

    /* renamed from: i, reason: collision with root package name */
    private int f1115i;
    private volatile /* synthetic */ int size;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1116a;

        static {
            int[] iArr = new int[e.values().length];
            iArr[e.SUSPEND.ordinal()] = 1;
            iArr[e.DROP_LATEST.ordinal()] = 2;
            iArr[e.DROP_OLDEST.ordinal()] = 3;
            f1116a = iArr;
        }
    }

    public d(int i2, e eVar, j0.l<? super E, a0.q> lVar) {
        super(lVar);
        this.f1111e = i2;
        this.f1112f = eVar;
        if (!(i2 >= 1)) {
            throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i2 + " was specified").toString());
        }
        this.f1113g = new ReentrantLock();
        Object[] objArr = new Object[Math.min(i2, 8)];
        b0.d.e(objArr, b.f1101a, 0, 0, 6, null);
        a0.q qVar = a0.q.f22a;
        this.f1114h = objArr;
        this.size = 0;
    }

    private final void x(int i2, E e2) {
        if (i2 < this.f1111e) {
            y(i2);
            Object[] objArr = this.f1114h;
            objArr[(this.f1115i + i2) % objArr.length] = e2;
        } else {
            Object[] objArr2 = this.f1114h;
            int i3 = this.f1115i;
            objArr2[i3 % objArr2.length] = null;
            objArr2[(i2 + i3) % objArr2.length] = e2;
            this.f1115i = (i3 + 1) % objArr2.length;
        }
    }

    private final void y(int i2) {
        Object[] objArr = this.f1114h;
        if (i2 >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.f1111e);
            Object[] objArr2 = new Object[min];
            if (i2 > 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    Object[] objArr3 = this.f1114h;
                    objArr2[i3] = objArr3[(this.f1115i + i3) % objArr3.length];
                    if (i4 >= i2) {
                        break;
                    } else {
                        i3 = i4;
                    }
                }
            }
            b0.d.d(objArr2, b.f1101a, i2, min);
            this.f1114h = objArr2;
            this.f1115i = 0;
        }
    }

    private final y z(int i2) {
        if (i2 < this.f1111e) {
            this.size = i2 + 1;
            return null;
        }
        int i3 = a.f1116a[this.f1112f.ordinal()];
        if (i3 == 1) {
            return b.f1103c;
        }
        if (i3 == 2) {
            return b.f1102b;
        }
        if (i3 == 3) {
            return null;
        }
        throw new a0.i();
    }

    @Override // s0.c
    protected String c() {
        return "(buffer:capacity=" + this.f1111e + ",size=" + this.size + ')';
    }

    @Override // s0.c
    protected Object i(E e2) {
        q<E> l2;
        ReentrantLock reentrantLock = this.f1113g;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            j<?> d2 = d();
            if (d2 != null) {
                return d2;
            }
            y z2 = z(i2);
            if (z2 != null) {
                return z2;
            }
            if (i2 == 0) {
                do {
                    l2 = l();
                    if (l2 != null) {
                        if (l2 instanceof j) {
                            this.size = i2;
                            return l2;
                        }
                    }
                } while (l2.h(e2, null) == null);
                this.size = i2;
                a0.q qVar = a0.q.f22a;
                reentrantLock.unlock();
                l2.d(e2);
                return l2.e();
            }
            x(i2, e2);
            return b.f1102b;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // s0.a
    protected boolean q(o<? super E> oVar) {
        ReentrantLock reentrantLock = this.f1113g;
        reentrantLock.lock();
        try {
            return super.q(oVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // s0.a
    protected final boolean r() {
        return false;
    }

    @Override // s0.a
    protected final boolean s() {
        return this.size == 0;
    }

    @Override // s0.a
    protected Object v() {
        ReentrantLock reentrantLock = this.f1113g;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            if (i2 == 0) {
                Object d2 = d();
                if (d2 == null) {
                    d2 = b.f1104d;
                }
                return d2;
            }
            Object[] objArr = this.f1114h;
            int i3 = this.f1115i;
            Object obj = objArr[i3];
            s sVar = null;
            objArr[i3] = null;
            this.size = i2 - 1;
            Object obj2 = b.f1104d;
            boolean z2 = false;
            if (i2 == this.f1111e) {
                s sVar2 = null;
                while (true) {
                    s m2 = m();
                    if (m2 == null) {
                        sVar = sVar2;
                        break;
                    }
                    if (m2.A(null) != null) {
                        obj2 = m2.z();
                        sVar = m2;
                        z2 = true;
                        break;
                    }
                    m2.B();
                    sVar2 = m2;
                }
            }
            if (obj2 != b.f1104d && !(obj2 instanceof j)) {
                this.size = i2;
                Object[] objArr2 = this.f1114h;
                objArr2[(this.f1115i + i2) % objArr2.length] = obj2;
            }
            this.f1115i = (this.f1115i + 1) % this.f1114h.length;
            a0.q qVar = a0.q.f22a;
            if (z2) {
                kotlin.jvm.internal.i.b(sVar);
                sVar.y();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }
}
