package v;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public final w.a<Object> f1325a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final w.a<Object> f1326a;

        /* renamed from: b, reason: collision with root package name */
        private Map<String, Object> f1327b = new HashMap();

        a(w.a<Object> aVar) {
            this.f1326a = aVar;
        }

        public void a() {
            j.b.f("SettingsChannel", "Sending message: \ntextScaleFactor: " + this.f1327b.get("textScaleFactor") + "\nalwaysUse24HourFormat: " + this.f1327b.get("alwaysUse24HourFormat") + "\nplatformBrightness: " + this.f1327b.get("platformBrightness"));
            this.f1326a.c(this.f1327b);
        }

        public a b(boolean z2) {
            this.f1327b.put("brieflyShowPassword", Boolean.valueOf(z2));
            return this;
        }

        public a c(boolean z2) {
            this.f1327b.put("nativeSpellCheckServiceDefined", Boolean.valueOf(z2));
            return this;
        }

        public a d(b bVar) {
            this.f1327b.put("platformBrightness", bVar.f1331d);
            return this;
        }

        public a e(float f2) {
            this.f1327b.put("textScaleFactor", Float.valueOf(f2));
            return this;
        }

        public a f(boolean z2) {
            this.f1327b.put("alwaysUse24HourFormat", Boolean.valueOf(z2));
            return this;
        }
    }

    public enum b {
        light("light"),
        dark("dark");


        /* renamed from: d, reason: collision with root package name */
        public String f1331d;

        b(String str) {
            this.f1331d = str;
        }
    }

    public m(k.a aVar) {
        this.f1325a = new w.a<>(aVar, "flutter/settings", w.d.f1396a);
    }

    public a a() {
        return new a(this.f1325a);
    }
}
