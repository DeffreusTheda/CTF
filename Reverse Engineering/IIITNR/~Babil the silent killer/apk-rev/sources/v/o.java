package v;

import java.util.HashMap;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public final w.a<Object> f1336a;

    public o(k.a aVar) {
        this.f1336a = new w.a<>(aVar, "flutter/system", w.d.f1396a);
    }

    public void a() {
        j.b.f("SystemChannel", "Sending memory pressure warning to Flutter.");
        HashMap hashMap = new HashMap(1);
        hashMap.put("type", "memoryPressure");
        this.f1336a.c(hashMap);
    }
}
