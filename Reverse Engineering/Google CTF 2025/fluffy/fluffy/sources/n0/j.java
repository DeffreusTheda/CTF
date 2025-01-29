package n0;

import D.H;
import java.util.concurrent.TimeUnit;
import m0.AbstractC0081a;
import m0.x;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1116a;

    /* renamed from: b, reason: collision with root package name */
    public static final long f1117b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f1118c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f1119d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f1120e;

    /* renamed from: f, reason: collision with root package name */
    public static final f f1121f;

    /* renamed from: g, reason: collision with root package name */
    public static final H f1122g;

    /* renamed from: h, reason: collision with root package name */
    public static final H f1123h;

    static {
        String str;
        int i2 = x.f1036a;
        try {
            str = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str == null) {
            str = "DefaultDispatcher";
        }
        f1116a = str;
        f1117b = AbstractC0081a.j("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, Long.MAX_VALUE);
        int i3 = x.f1036a;
        if (i3 < 2) {
            i3 = 2;
        }
        f1118c = AbstractC0081a.k("kotlinx.coroutines.scheduler.core.pool.size", i3, 1, 0, 8);
        f1119d = AbstractC0081a.k("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4);
        f1120e = TimeUnit.SECONDS.toNanos(AbstractC0081a.j("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        f1121f = f.f1111a;
        f1122g = new H(0);
        f1123h = new H(1);
    }
}
