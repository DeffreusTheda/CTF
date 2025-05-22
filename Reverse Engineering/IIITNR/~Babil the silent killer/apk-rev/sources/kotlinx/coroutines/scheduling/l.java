package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.z;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final long f902a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f903b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f904c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f905d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f906e;

    /* renamed from: f, reason: collision with root package name */
    public static h f907f;

    static {
        long e2;
        int d2;
        int a2;
        int d3;
        int e3;
        int d4;
        long e4;
        e2 = b0.e("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        f902a = e2;
        d2 = b0.d("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
        f903b = d2;
        a2 = m0.f.a(z.a(), 2);
        d3 = b0.d("kotlinx.coroutines.scheduler.core.pool.size", a2, 1, 0, 8, null);
        f904c = d3;
        e3 = m0.f.e(z.a() * 128, d3, 2097150);
        d4 = b0.d("kotlinx.coroutines.scheduler.max.pool.size", e3, 0, 2097150, 4, null);
        f905d = d4;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e4 = b0.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f906e = timeUnit.toNanos(e4);
        f907f = f.f896a;
    }
}
