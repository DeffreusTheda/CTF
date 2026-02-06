package io.flutter.embedding.engine;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static b f362b;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, a> f363a = new HashMap();

    b() {
    }

    public static b b() {
        if (f362b == null) {
            f362b = new b();
        }
        return f362b;
    }

    public a a(String str) {
        return this.f363a.get(str);
    }

    public void c(String str, a aVar) {
        if (aVar != null) {
            this.f363a.put(str, aVar);
        } else {
            this.f363a.remove(str);
        }
    }

    public void d(String str) {
        c(str, null);
    }
}
