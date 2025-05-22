package v;

import java.util.HashMap;
import java.util.Map;
import w.i;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1315a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f1316b;

    /* renamed from: c, reason: collision with root package name */
    private w.i f1317c;

    /* renamed from: d, reason: collision with root package name */
    private i.d f1318d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f1319e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1320f;

    /* renamed from: g, reason: collision with root package name */
    private final i.c f1321g;

    class a implements i.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f1322a;

        a(byte[] bArr) {
            this.f1322a = bArr;
        }

        @Override // w.i.d
        public void a(String str, String str2, Object obj) {
            j.b.b("RestorationChannel", "Error " + str + " while sending restoration data to framework: " + str2);
        }

        @Override // w.i.d
        public void b(Object obj) {
            l.this.f1316b = this.f1322a;
        }

        @Override // w.i.d
        public void c() {
        }
    }

    class b implements i.c {
        b() {
        }

        @Override // w.i.c
        public void a(w.h hVar, i.d dVar) {
            Map i2;
            String str = hVar.f1398a;
            Object obj = hVar.f1399b;
            str.hashCode();
            if (str.equals("get")) {
                l.this.f1320f = true;
                if (!l.this.f1319e) {
                    l lVar = l.this;
                    if (lVar.f1315a) {
                        lVar.f1318d = dVar;
                        return;
                    }
                }
                l lVar2 = l.this;
                i2 = lVar2.i(lVar2.f1316b);
            } else if (!str.equals("put")) {
                dVar.c();
                return;
            } else {
                l.this.f1316b = (byte[]) obj;
                i2 = null;
            }
            dVar.b(i2);
        }
    }

    public l(k.a aVar, boolean z2) {
        this(new w.i(aVar, "flutter/restoration", w.p.f1413b), z2);
    }

    l(w.i iVar, boolean z2) {
        this.f1319e = false;
        this.f1320f = false;
        b bVar = new b();
        this.f1321g = bVar;
        this.f1317c = iVar;
        this.f1315a = z2;
        iVar.e(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> i(byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("enabled", Boolean.TRUE);
        hashMap.put("data", bArr);
        return hashMap;
    }

    public void g() {
        this.f1316b = null;
    }

    public byte[] h() {
        return this.f1316b;
    }

    public void j(byte[] bArr) {
        this.f1319e = true;
        i.d dVar = this.f1318d;
        if (dVar != null) {
            dVar.b(i(bArr));
            this.f1318d = null;
        } else if (this.f1320f) {
            this.f1317c.d("push", i(bArr), new a(bArr));
            return;
        }
        this.f1316b = bArr;
    }
}
