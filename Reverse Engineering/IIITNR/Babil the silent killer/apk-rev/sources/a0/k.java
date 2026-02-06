package a0;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class k<T> implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final a f16d = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.e eVar) {
            this();
        }
    }

    public static final class b implements Serializable {

        /* renamed from: d, reason: collision with root package name */
        public final Throwable f17d;

        public b(Throwable exception) {
            kotlin.jvm.internal.i.e(exception, "exception");
            this.f17d = exception;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && kotlin.jvm.internal.i.a(this.f17d, ((b) obj).f17d);
        }

        public int hashCode() {
            return this.f17d.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f17d + ')';
        }
    }

    public static <T> Object a(Object obj) {
        return obj;
    }

    public static final Throwable b(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f17d;
        }
        return null;
    }

    public static final boolean c(Object obj) {
        return obj instanceof b;
    }

    public static final boolean d(Object obj) {
        return !(obj instanceof b);
    }
}
