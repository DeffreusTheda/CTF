package x;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import v.f;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final f f1417a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f1418b;

    /* renamed from: c, reason: collision with root package name */
    @SuppressLint({"AppBundleLocaleChanges", "DiscouragedApi"})
    final f.b f1419c;

    /* renamed from: x.a$a, reason: collision with other inner class name */
    class C0037a implements f.b {
        C0037a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0061  */
        @Override // v.f.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String a(java.lang.String r8, java.lang.String r9) {
            /*
                r7 = this;
                x.a r0 = x.a.this
                android.content.Context r0 = x.a.a(r0)
                r1 = 17
                r2 = 0
                if (r9 == 0) goto L4a
                java.util.Locale r3 = x.a.b(r9)
                int r4 = android.os.Build.VERSION.SDK_INT
                if (r4 < r1) goto L34
                android.content.res.Configuration r0 = new android.content.res.Configuration
                x.a r4 = x.a.this
                android.content.Context r4 = x.a.a(r4)
                android.content.res.Resources r4 = r4.getResources()
                android.content.res.Configuration r4 = r4.getConfiguration()
                r0.<init>(r4)
                r0.setLocale(r3)
                x.a r3 = x.a.this
                android.content.Context r3 = x.a.a(r3)
                android.content.Context r0 = r3.createConfigurationContext(r0)
                goto L4a
            L34:
                x.a r4 = x.a.this
                android.content.Context r4 = x.a.a(r4)
                android.content.res.Resources r4 = r4.getResources()
                android.content.res.Configuration r5 = r4.getConfiguration()
                java.util.Locale r6 = r5.locale
                r5.locale = r3
                r4.updateConfiguration(r5, r2)
                goto L4b
            L4a:
                r6 = r2
            L4b:
                x.a r3 = x.a.this
                android.content.Context r3 = x.a.a(r3)
                java.lang.String r3 = r3.getPackageName()
                android.content.res.Resources r4 = r0.getResources()
                java.lang.String r5 = "string"
                int r8 = r4.getIdentifier(r8, r5, r3)
                if (r8 == 0) goto L6a
                android.content.res.Resources r0 = r0.getResources()
                java.lang.String r8 = r0.getString(r8)
                goto L6b
            L6a:
                r8 = r2
            L6b:
                if (r9 == 0) goto L84
                int r9 = android.os.Build.VERSION.SDK_INT
                if (r9 >= r1) goto L84
                x.a r9 = x.a.this
                android.content.Context r9 = x.a.a(r9)
                android.content.res.Resources r9 = r9.getResources()
                android.content.res.Configuration r0 = r9.getConfiguration()
                r0.locale = r6
                r9.updateConfiguration(r0, r2)
            L84:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: x.a.C0037a.a(java.lang.String, java.lang.String):java.lang.String");
        }
    }

    public a(Context context, f fVar) {
        C0037a c0037a = new C0037a();
        this.f1419c = c0037a;
        this.f1418b = context;
        this.f1417a = fVar;
        fVar.c(c0037a);
    }

    public static Locale b(String str) {
        String str2;
        String[] split = str.replace('_', '-').split("-", -1);
        String str3 = split[0];
        String str4 = "";
        int i2 = 1;
        if (split.length <= 1 || split[1].length() != 4) {
            str2 = "";
        } else {
            str2 = split[1];
            i2 = 2;
        }
        if (split.length > i2 && split[i2].length() >= 2 && split[i2].length() <= 3) {
            str4 = split[i2];
        }
        return new Locale(str3, str4, str2);
    }

    public Locale c(List<Locale> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            ArrayList arrayList = new ArrayList();
            LocaleList locales = this.f1418b.getResources().getConfiguration().getLocales();
            int size = locales.size();
            for (int i3 = 0; i3 < size; i3++) {
                Locale locale = locales.get(i3);
                String language = locale.getLanguage();
                if (!locale.getScript().isEmpty()) {
                    language = language + "-" + locale.getScript();
                }
                if (!locale.getCountry().isEmpty()) {
                    language = language + "-" + locale.getCountry();
                }
                arrayList.add(new Locale.LanguageRange(language));
                arrayList.add(new Locale.LanguageRange(locale.getLanguage()));
                arrayList.add(new Locale.LanguageRange(locale.getLanguage() + "-*"));
            }
            Locale lookup = Locale.lookup(arrayList, list);
            if (lookup != null) {
                return lookup;
            }
        } else if (i2 >= 24) {
            LocaleList locales2 = this.f1418b.getResources().getConfiguration().getLocales();
            for (int i4 = 0; i4 < locales2.size(); i4++) {
                Locale locale2 = locales2.get(i4);
                for (Locale locale3 : list) {
                    if (locale2.equals(locale3)) {
                        return locale3;
                    }
                }
                for (Locale locale4 : list) {
                    if (locale2.getLanguage().equals(locale4.toLanguageTag())) {
                        return locale4;
                    }
                }
                for (Locale locale5 : list) {
                    if (locale2.getLanguage().equals(locale5.getLanguage())) {
                        return locale5;
                    }
                }
            }
        } else {
            Locale locale6 = this.f1418b.getResources().getConfiguration().locale;
            if (locale6 != null) {
                for (Locale locale7 : list) {
                    if (locale6.equals(locale7)) {
                        return locale7;
                    }
                }
                for (Locale locale8 : list) {
                    if (locale6.getLanguage().equals(locale8.toString())) {
                        return locale8;
                    }
                }
            }
        }
        return list.get(0);
    }

    public void d(Configuration configuration) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList locales = configuration.getLocales();
            int size = locales.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(locales.get(i2));
            }
        } else {
            arrayList.add(configuration.locale);
        }
        this.f1417a.b(arrayList);
    }
}
