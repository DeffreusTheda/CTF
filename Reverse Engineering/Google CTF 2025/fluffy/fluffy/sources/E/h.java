package E;

import D.AbstractActivityC0005f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f165a = new ArrayList();

    public h(AbstractActivityC0005f abstractActivityC0005f, String[] strArr) {
        H.f fVar = (H.f) B.a.j().f4c;
        if (fVar.f216a) {
            return;
        }
        fVar.b(abstractActivityC0005f.getApplicationContext());
        fVar.a(abstractActivityC0005f.getApplicationContext(), strArr);
    }

    public final c a(g gVar) {
        F.a aVar;
        c cVar;
        AbstractActivityC0005f abstractActivityC0005f = gVar.f159a;
        F.a aVar2 = gVar.f160b;
        String str = gVar.f161c;
        List<String> list = gVar.f162d;
        io.flutter.plugin.platform.k kVar = new io.flutter.plugin.platform.k();
        boolean z2 = gVar.f163e;
        boolean z3 = gVar.f164f;
        if (aVar2 == null) {
            H.f fVar = (H.f) B.a.j().f4c;
            if (!fVar.f216a) {
                throw new AssertionError("DartEntrypoints can only be created once a FlutterEngine is created.");
            }
            aVar = new F.a(fVar.f219d.f206b, "main");
        } else {
            aVar = aVar2;
        }
        ArrayList arrayList = this.f165a;
        if (arrayList.size() == 0) {
            cVar = new c(abstractActivityC0005f, null, kVar, z2, z3);
            if (str != null) {
                cVar.f133i.f223a.f("setInitialRoute", str, null);
            }
            cVar.f127c.b(aVar, list);
        } else {
            c cVar2 = (c) arrayList.get(0);
            if (!cVar2.f125a.isAttached()) {
                throw new IllegalStateException("Spawn can only be called on a fully constructed FlutterEngine");
            }
            long j2 = c.f123w;
            cVar = new c(abstractActivityC0005f, cVar2.f125a.spawn(aVar.f172c, aVar.f171b, str, list, j2), kVar, z2, z3);
        }
        arrayList.add(cVar);
        cVar.f143t.add(new f(this, cVar));
        return cVar;
    }
}
