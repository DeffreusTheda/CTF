package v;

import w.q;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final w.a<String> f1214a;

    public e(k.a aVar) {
        this.f1214a = new w.a<>(aVar, "flutter/lifecycle", q.f1416b);
    }

    public void a() {
        j.b.f("LifecycleChannel", "Sending AppLifecycleState.detached message.");
        this.f1214a.c("AppLifecycleState.detached");
    }

    public void b() {
        j.b.f("LifecycleChannel", "Sending AppLifecycleState.inactive message.");
        this.f1214a.c("AppLifecycleState.inactive");
    }

    public void c() {
        j.b.f("LifecycleChannel", "Sending AppLifecycleState.paused message.");
        this.f1214a.c("AppLifecycleState.paused");
    }

    public void d() {
        j.b.f("LifecycleChannel", "Sending AppLifecycleState.resumed message.");
        this.f1214a.c("AppLifecycleState.resumed");
    }
}
