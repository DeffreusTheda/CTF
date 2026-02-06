package v;

import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import w.i;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final w.i f1215a;

    /* renamed from: b, reason: collision with root package name */
    private b f1216b;

    /* renamed from: c, reason: collision with root package name */
    public final i.c f1217c;

    class a implements i.c {
        a() {
        }

        @Override // w.i.c
        public void a(w.h hVar, i.d dVar) {
            if (f.this.f1216b == null) {
                return;
            }
            String str = hVar.f1398a;
            str.hashCode();
            if (!str.equals("Localization.getStringResource")) {
                dVar.c();
                return;
            }
            JSONObject jSONObject = (JSONObject) hVar.a();
            try {
                dVar.b(f.this.f1216b.a(jSONObject.getString("key"), jSONObject.has("locale") ? jSONObject.getString("locale") : null));
            } catch (JSONException e2) {
                dVar.a("error", e2.getMessage(), null);
            }
        }
    }

    public interface b {
        String a(String str, String str2);
    }

    public f(k.a aVar) {
        a aVar2 = new a();
        this.f1217c = aVar2;
        w.i iVar = new w.i(aVar, "flutter/localization", w.e.f1397a);
        this.f1215a = iVar;
        iVar.e(aVar2);
    }

    public void b(List<Locale> list) {
        j.b.f("LocalizationChannel", "Sending Locales to Flutter.");
        ArrayList arrayList = new ArrayList();
        for (Locale locale : list) {
            j.b.f("LocalizationChannel", "Locale (Language: " + locale.getLanguage() + ", Country: " + locale.getCountry() + ", Variant: " + locale.getVariant() + ")");
            arrayList.add(locale.getLanguage());
            arrayList.add(locale.getCountry());
            arrayList.add(Build.VERSION.SDK_INT >= 21 ? locale.getScript() : "");
            arrayList.add(locale.getVariant());
        }
        this.f1215a.c("setLocale", arrayList);
    }

    public void c(b bVar) {
        this.f1216b = bVar;
    }
}
