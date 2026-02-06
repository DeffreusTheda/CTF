package m0;

import b0.v;

/* loaded from: classes.dex */
public class a implements Iterable<Integer> {

    /* renamed from: g, reason: collision with root package name */
    public static final C0021a f938g = new C0021a(null);

    /* renamed from: d, reason: collision with root package name */
    private final int f939d;

    /* renamed from: e, reason: collision with root package name */
    private final int f940e;

    /* renamed from: f, reason: collision with root package name */
    private final int f941f;

    /* renamed from: m0.a$a, reason: collision with other inner class name */
    public static final class C0021a {
        private C0021a() {
        }

        public /* synthetic */ C0021a(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final a a(int i2, int i3, int i4) {
            return new a(i2, i3, i4);
        }
    }

    public a(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f939d = i2;
        this.f940e = e0.c.b(i2, i3, i4);
        this.f941f = i4;
    }

    public final int a() {
        return this.f939d;
    }

    public final int b() {
        return this.f940e;
    }

    public final int c() {
        return this.f941f;
    }

    @Override // java.lang.Iterable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public v iterator() {
        return new b(this.f939d, this.f940e, this.f941f);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f939d != aVar.f939d || this.f940e != aVar.f940e || this.f941f != aVar.f941f) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f939d * 31) + this.f940e) * 31) + this.f941f;
    }

    public boolean isEmpty() {
        if (this.f941f > 0) {
            if (this.f939d > this.f940e) {
                return true;
            }
        } else if (this.f939d < this.f940e) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f941f > 0) {
            sb = new StringBuilder();
            sb.append(this.f939d);
            sb.append("..");
            sb.append(this.f940e);
            sb.append(" step ");
            i2 = this.f941f;
        } else {
            sb = new StringBuilder();
            sb.append(this.f939d);
            sb.append(" downTo ");
            sb.append(this.f940e);
            sb.append(" step ");
            i2 = -this.f941f;
        }
        sb.append(i2);
        return sb.toString();
    }
}
