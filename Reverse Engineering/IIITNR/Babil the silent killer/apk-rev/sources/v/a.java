package v;

import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.c;
import java.util.HashMap;
import w.a;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final w.a<Object> f1200a;

    /* renamed from: b, reason: collision with root package name */
    public final FlutterJNI f1201b;

    /* renamed from: c, reason: collision with root package name */
    private b f1202c;

    /* renamed from: d, reason: collision with root package name */
    final a.d<Object> f1203d;

    /* renamed from: v.a$a, reason: collision with other inner class name */
    class C0031a implements a.d<Object> {
        C0031a() {
        }

        @Override // w.a.d
        public void a(Object obj, a.e<Object> eVar) {
            HashMap hashMap;
            HashMap hashMap2;
            if (a.this.f1202c == null) {
                eVar.a(null);
                return;
            }
            hashMap = (HashMap) obj;
            String str = (String) hashMap.get("type");
            hashMap2 = (HashMap) hashMap.get("data");
            j.b.f("AccessibilityChannel", "Received " + str + " message.");
            str.hashCode();
            switch (str) {
                case "tooltip":
                    String str2 = (String) hashMap2.get("message");
                    if (str2 != null) {
                        a.this.f1202c.c(str2);
                        break;
                    }
                    break;
                case "announce":
                    String str3 = (String) hashMap2.get("message");
                    if (str3 != null) {
                        a.this.f1202c.f(str3);
                        break;
                    }
                    break;
                case "tap":
                    Integer num = (Integer) hashMap.get("nodeId");
                    if (num != null) {
                        a.this.f1202c.e(num.intValue());
                        break;
                    }
                    break;
                case "longPress":
                    Integer num2 = (Integer) hashMap.get("nodeId");
                    if (num2 != null) {
                        a.this.f1202c.d(num2.intValue());
                        break;
                    }
                    break;
            }
            eVar.a(null);
        }
    }

    public interface b extends FlutterJNI.a {
        void c(String str);

        void d(int i2);

        void e(int i2);

        void f(String str);
    }

    public a(k.a aVar, FlutterJNI flutterJNI) {
        C0031a c0031a = new C0031a();
        this.f1203d = c0031a;
        w.a<Object> aVar2 = new w.a<>(aVar, "flutter/accessibility", w.o.f1410a);
        this.f1200a = aVar2;
        aVar2.e(c0031a);
        this.f1201b = flutterJNI;
    }

    public void b(int i2, c.g gVar) {
        this.f1201b.dispatchSemanticsAction(i2, gVar);
    }

    public void c(int i2, c.g gVar, Object obj) {
        this.f1201b.dispatchSemanticsAction(i2, gVar, obj);
    }

    public void d() {
        this.f1201b.setSemanticsEnabled(false);
    }

    public void e() {
        this.f1201b.setSemanticsEnabled(true);
    }

    public void f(int i2) {
        this.f1201b.setAccessibilityFeatures(i2);
    }

    public void g(b bVar) {
        this.f1202c = bVar;
        this.f1201b.setAccessibilityDelegate(bVar);
    }
}
