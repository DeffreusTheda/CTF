package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.z;
import q0.e0;

/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: k, reason: collision with root package name */
    public static final b f883k;

    /* renamed from: l, reason: collision with root package name */
    private static final e0 f884l;

    static {
        int a2;
        int d2;
        b bVar = new b();
        f883k = bVar;
        a2 = m0.f.a(64, z.a());
        d2 = b0.d("kotlinx.coroutines.io.parallelism", a2, 0, 0, 12, null);
        f884l = new e(bVar, d2, "Dispatchers.IO", 1);
    }

    private b() {
        super(0, 0, null, 7, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    public final e0 s() {
        return f884l;
    }

    @Override // q0.e0
    public String toString() {
        return "Dispatchers.Default";
    }
}
