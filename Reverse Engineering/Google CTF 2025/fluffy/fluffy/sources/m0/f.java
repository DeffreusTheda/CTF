package m0;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final List f1000a;

    static {
        try {
            Iterator it = Arrays.asList(new i0.b()).iterator();
            a0.h.e(it, "<this>");
            f1000a = f0.c.B(new f0.a(new f0.e(it)));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
