package v;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import w.i;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final w.i f1205a;

    /* renamed from: b, reason: collision with root package name */
    private l.a f1206b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, List<i.d>> f1207c;

    /* renamed from: d, reason: collision with root package name */
    final i.c f1208d;

    class a implements i.c {
        a() {
        }

        @Override // w.i.c
        public void a(w.h hVar, i.d dVar) {
            int intValue;
            String str;
            String str2;
            if (b.this.f1206b == null) {
                return;
            }
            String str3 = hVar.f1398a;
            Map map = (Map) hVar.a();
            j.b.f("DeferredComponentChannel", "Received '" + str3 + "' message.");
            intValue = ((Integer) map.get("loadingUnitId")).intValue();
            str = (String) map.get("componentName");
            str3.hashCode();
            switch (str3) {
                case "uninstallDeferredComponent":
                    b.this.f1206b.c(intValue, str);
                    str2 = null;
                    break;
                case "getDeferredComponentInstallState":
                    str2 = b.this.f1206b.a(intValue, str);
                    break;
                case "installDeferredComponent":
                    b.this.f1206b.b(intValue, str);
                    if (!b.this.f1207c.containsKey(str)) {
                        b.this.f1207c.put(str, new ArrayList());
                    }
                    ((List) b.this.f1207c.get(str)).add(dVar);
                    return;
                default:
                    dVar.c();
                    return;
            }
            dVar.b(str2);
        }
    }

    public b(k.a aVar) {
        a aVar2 = new a();
        this.f1208d = aVar2;
        w.i iVar = new w.i(aVar, "flutter/deferredcomponent", w.p.f1413b);
        this.f1205a = iVar;
        iVar.e(aVar2);
        this.f1206b = j.a.e().a();
        this.f1207c = new HashMap();
    }

    public void c(l.a aVar) {
        this.f1206b = aVar;
    }
}
