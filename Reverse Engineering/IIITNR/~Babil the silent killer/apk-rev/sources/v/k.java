package v;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import v.k;
import w.i;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final w.i f1277a;

    /* renamed from: b, reason: collision with root package name */
    private g f1278b;

    /* renamed from: c, reason: collision with root package name */
    private final i.c f1279c;

    class a implements i.c {
        a() {
        }

        private void c(w.h hVar, i.d dVar) {
            try {
                k.this.f1278b.a(((Integer) hVar.a()).intValue());
                dVar.b(null);
            } catch (IllegalStateException e2) {
                dVar.a("error", k.c(e2), null);
            }
        }

        private void d(w.h hVar, i.d dVar) {
            Map map = (Map) hVar.a();
            boolean z2 = true;
            boolean z3 = map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue();
            ByteBuffer wrap = map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null;
            try {
                if (z3) {
                    k.this.f1278b.i(new d(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), 0.0d, 0.0d, 0.0d, 0.0d, ((Integer) map.get("direction")).intValue(), d.a.HYBRID_ONLY, wrap));
                } else {
                    if (!map.containsKey("hybridFallback") || !((Boolean) map.get("hybridFallback")).booleanValue()) {
                        z2 = false;
                    }
                    long g2 = k.this.f1278b.g(new d(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), map.containsKey("top") ? ((Double) map.get("top")).doubleValue() : 0.0d, map.containsKey("left") ? ((Double) map.get("left")).doubleValue() : 0.0d, ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue(), ((Integer) map.get("direction")).intValue(), z2 ? d.a.TEXTURE_WITH_HYBRID_FALLBACK : d.a.TEXTURE_WITH_VIRTUAL_FALLBACK, wrap));
                    if (g2 != -2) {
                        dVar.b(Long.valueOf(g2));
                        return;
                    } else if (!z2) {
                        throw new AssertionError("Platform view attempted to fall back to hybrid mode when not requested.");
                    }
                }
                dVar.b(null);
            } catch (IllegalStateException e2) {
                dVar.a("error", k.c(e2), null);
            }
        }

        private void e(w.h hVar, i.d dVar) {
            try {
                k.this.f1278b.d(((Integer) ((Map) hVar.a()).get("id")).intValue());
                dVar.b(null);
            } catch (IllegalStateException e2) {
                dVar.a("error", k.c(e2), null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f(i.d dVar, c cVar) {
            if (cVar == null) {
                dVar.a("error", "Failed to resize the platform view", null);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("width", Double.valueOf(cVar.f1281a));
            hashMap.put("height", Double.valueOf(cVar.f1282b));
            dVar.b(hashMap);
        }

        private void g(w.h hVar, i.d dVar) {
            Map map = (Map) hVar.a();
            try {
                k.this.f1278b.f(((Integer) map.get("id")).intValue(), ((Double) map.get("top")).doubleValue(), ((Double) map.get("left")).doubleValue());
                dVar.b(null);
            } catch (IllegalStateException e2) {
                dVar.a("error", k.c(e2), null);
            }
        }

        private void h(w.h hVar, final i.d dVar) {
            Map map = (Map) hVar.a();
            try {
                k.this.f1278b.c(new e(((Integer) map.get("id")).intValue(), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue()), new b() { // from class: v.j
                    @Override // v.k.b
                    public final void a(k.c cVar) {
                        k.a.f(i.d.this, cVar);
                    }
                });
            } catch (IllegalStateException e2) {
                dVar.a("error", k.c(e2), null);
            }
        }

        private void i(w.h hVar, i.d dVar) {
            Map map = (Map) hVar.a();
            try {
                k.this.f1278b.h(((Integer) map.get("id")).intValue(), ((Integer) map.get("direction")).intValue());
                dVar.b(null);
            } catch (IllegalStateException e2) {
                dVar.a("error", k.c(e2), null);
            }
        }

        private void j(w.h hVar, i.d dVar) {
            try {
                k.this.f1278b.e(((Boolean) hVar.a()).booleanValue());
                dVar.b(null);
            } catch (IllegalStateException e2) {
                dVar.a("error", k.c(e2), null);
            }
        }

        private void k(w.h hVar, i.d dVar) {
            i.d dVar2;
            List list = (List) hVar.a();
            try {
                k.this.f1278b.b(new f(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                dVar2 = dVar;
            } catch (IllegalStateException e2) {
                e = e2;
                dVar2 = dVar;
            }
            try {
                dVar2.b(null);
            } catch (IllegalStateException e3) {
                e = e3;
                dVar2.a("error", k.c(e), null);
            }
        }

        @Override // w.i.c
        public void a(w.h hVar, i.d dVar) {
            if (k.this.f1278b == null) {
            }
            j.b.f("PlatformViewsChannel", "Received '" + hVar.f1398a + "' message.");
            String str = hVar.f1398a;
            str.hashCode();
            switch (str) {
                case "create":
                    d(hVar, dVar);
                    break;
                case "offset":
                    g(hVar, dVar);
                    break;
                case "resize":
                    h(hVar, dVar);
                    break;
                case "clearFocus":
                    c(hVar, dVar);
                    break;
                case "synchronizeToNativeViewHierarchy":
                    j(hVar, dVar);
                    break;
                case "touch":
                    k(hVar, dVar);
                    break;
                case "setDirection":
                    i(hVar, dVar);
                    break;
                case "dispose":
                    e(hVar, dVar);
                    break;
                default:
                    dVar.c();
                    break;
            }
        }
    }

    public interface b {
        void a(c cVar);
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f1281a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1282b;

        public c(int i2, int i3) {
            this.f1281a = i2;
            this.f1282b = i3;
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f1283a;

        /* renamed from: b, reason: collision with root package name */
        public final String f1284b;

        /* renamed from: c, reason: collision with root package name */
        public final double f1285c;

        /* renamed from: d, reason: collision with root package name */
        public final double f1286d;

        /* renamed from: e, reason: collision with root package name */
        public final double f1287e;

        /* renamed from: f, reason: collision with root package name */
        public final double f1288f;

        /* renamed from: g, reason: collision with root package name */
        public final int f1289g;

        /* renamed from: h, reason: collision with root package name */
        public final a f1290h;

        /* renamed from: i, reason: collision with root package name */
        public final ByteBuffer f1291i;

        public enum a {
            TEXTURE_WITH_VIRTUAL_FALLBACK,
            TEXTURE_WITH_HYBRID_FALLBACK,
            HYBRID_ONLY
        }

        public d(int i2, String str, double d2, double d3, double d4, double d5, int i3, a aVar, ByteBuffer byteBuffer) {
            this.f1283a = i2;
            this.f1284b = str;
            this.f1287e = d2;
            this.f1288f = d3;
            this.f1285c = d4;
            this.f1286d = d5;
            this.f1289g = i3;
            this.f1290h = aVar;
            this.f1291i = byteBuffer;
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final int f1296a;

        /* renamed from: b, reason: collision with root package name */
        public final double f1297b;

        /* renamed from: c, reason: collision with root package name */
        public final double f1298c;

        public e(int i2, double d2, double d3) {
            this.f1296a = i2;
            this.f1297b = d2;
            this.f1298c = d3;
        }
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final int f1299a;

        /* renamed from: b, reason: collision with root package name */
        public final Number f1300b;

        /* renamed from: c, reason: collision with root package name */
        public final Number f1301c;

        /* renamed from: d, reason: collision with root package name */
        public final int f1302d;

        /* renamed from: e, reason: collision with root package name */
        public final int f1303e;

        /* renamed from: f, reason: collision with root package name */
        public final Object f1304f;

        /* renamed from: g, reason: collision with root package name */
        public final Object f1305g;

        /* renamed from: h, reason: collision with root package name */
        public final int f1306h;

        /* renamed from: i, reason: collision with root package name */
        public final int f1307i;

        /* renamed from: j, reason: collision with root package name */
        public final float f1308j;

        /* renamed from: k, reason: collision with root package name */
        public final float f1309k;

        /* renamed from: l, reason: collision with root package name */
        public final int f1310l;

        /* renamed from: m, reason: collision with root package name */
        public final int f1311m;

        /* renamed from: n, reason: collision with root package name */
        public final int f1312n;

        /* renamed from: o, reason: collision with root package name */
        public final int f1313o;

        /* renamed from: p, reason: collision with root package name */
        public final long f1314p;

        public f(int i2, Number number, Number number2, int i3, int i4, Object obj, Object obj2, int i5, int i6, float f2, float f3, int i7, int i8, int i9, int i10, long j2) {
            this.f1299a = i2;
            this.f1300b = number;
            this.f1301c = number2;
            this.f1302d = i3;
            this.f1303e = i4;
            this.f1304f = obj;
            this.f1305g = obj2;
            this.f1306h = i5;
            this.f1307i = i6;
            this.f1308j = f2;
            this.f1309k = f3;
            this.f1310l = i7;
            this.f1311m = i8;
            this.f1312n = i9;
            this.f1313o = i10;
            this.f1314p = j2;
        }
    }

    public interface g {
        void a(int i2);

        void b(f fVar);

        void c(e eVar, b bVar);

        void d(int i2);

        void e(boolean z2);

        void f(int i2, double d2, double d3);

        long g(d dVar);

        void h(int i2, int i3);

        void i(d dVar);
    }

    public k(k.a aVar) {
        a aVar2 = new a();
        this.f1279c = aVar2;
        w.i iVar = new w.i(aVar, "flutter/platform_views", w.p.f1413b);
        this.f1277a = iVar;
        iVar.e(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(Exception exc) {
        return j.b.d(exc);
    }

    public void d(int i2) {
        w.i iVar = this.f1277a;
        if (iVar == null) {
            return;
        }
        iVar.c("viewFocused", Integer.valueOf(i2));
    }

    public void e(g gVar) {
        this.f1278b = gVar;
    }
}
