package a0;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class j<A, B> implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    private final A f14d;

    /* renamed from: e, reason: collision with root package name */
    private final B f15e;

    public j(A a2, B b2) {
        this.f14d = a2;
        this.f15e = b2;
    }

    public final A a() {
        return this.f14d;
    }

    public final B b() {
        return this.f15e;
    }

    public final A c() {
        return this.f14d;
    }

    public final B d() {
        return this.f15e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return kotlin.jvm.internal.i.a(this.f14d, jVar.f14d) && kotlin.jvm.internal.i.a(this.f15e, jVar.f15e);
    }

    public int hashCode() {
        A a2 = this.f14d;
        int hashCode = (a2 == null ? 0 : a2.hashCode()) * 31;
        B b2 = this.f15e;
        return hashCode + (b2 != null ? b2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f14d + ", " + this.f15e + ')';
    }
}
