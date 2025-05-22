package v;

import w.i;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final w.i f1223a;

    /* renamed from: b, reason: collision with root package name */
    private final i.c f1224b;

    class a implements i.c {
        a() {
        }

        @Override // w.i.c
        public void a(w.h hVar, i.d dVar) {
            dVar.b(null);
        }
    }

    public h(k.a aVar) {
        a aVar2 = new a();
        this.f1224b = aVar2;
        w.i iVar = new w.i(aVar, "flutter/navigation", w.e.f1397a);
        this.f1223a = iVar;
        iVar.e(aVar2);
    }

    public void a() {
        j.b.f("NavigationChannel", "Sending message to pop route.");
        this.f1223a.c("popRoute", null);
    }

    public void b(String str) {
        j.b.f("NavigationChannel", "Sending message to push route '" + str + "'");
        this.f1223a.c("pushRoute", str);
    }

    public void c(String str) {
        j.b.f("NavigationChannel", "Sending message to set initial route to '" + str + "'");
        this.f1223a.c("setInitialRoute", str);
    }
}
