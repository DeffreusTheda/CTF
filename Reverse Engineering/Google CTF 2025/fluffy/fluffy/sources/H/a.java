package H;

import android.content.res.XmlResourceParser;
import org.json.JSONArray;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f201a = f.class.getName().concat(".aot-shared-library-name");

    /* renamed from: b, reason: collision with root package name */
    public static final String f202b = f.class.getName().concat(".vm-snapshot-data");

    /* renamed from: c, reason: collision with root package name */
    public static final String f203c = f.class.getName().concat(".isolate-snapshot-data");

    /* renamed from: d, reason: collision with root package name */
    public static final String f204d = f.class.getName().concat(".flutter-assets-dir");

    /* JADX WARN: Removed duplicated region for block: B:20:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static H.b a(android.content.Context r10) {
        /*
            android.content.pm.PackageManager r0 = r10.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L99
            java.lang.String r1 = r10.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L99
            r2 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r1, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L99
            H.b r7 = new H.b
            android.os.Bundle r1 = r0.metaData
            r2 = 0
            if (r1 != 0) goto L17
            r3 = r2
            goto L1e
        L17:
            java.lang.String r3 = H.a.f201a
            java.lang.String r1 = r1.getString(r3, r2)
            r3 = r1
        L1e:
            android.os.Bundle r1 = r0.metaData
            if (r1 != 0) goto L23
            goto L28
        L23:
            java.lang.String r4 = H.a.f202b
            r1.getString(r4, r2)
        L28:
            android.os.Bundle r1 = r0.metaData
            if (r1 != 0) goto L2d
            goto L32
        L2d:
            java.lang.String r4 = H.a.f203c
            r1.getString(r4, r2)
        L32:
            android.os.Bundle r1 = r0.metaData
            if (r1 != 0) goto L38
            r4 = r2
            goto L3f
        L38:
            java.lang.String r4 = H.a.f204d
            java.lang.String r1 = r1.getString(r4, r2)
            r4 = r1
        L3f:
            android.os.Bundle r1 = r0.metaData
            r5 = 1
            if (r1 != 0) goto L46
        L44:
            r10 = r2
            goto L81
        L46:
            java.lang.String r6 = "io.flutter.network-policy"
            r8 = 0
            int r1 = r1.getInt(r6, r8)
            if (r1 > 0) goto L50
            goto L44
        L50:
            org.json.JSONArray r6 = new org.json.JSONArray
            r6.<init>()
            android.content.res.Resources r10 = r10.getResources()     // Catch: java.lang.Throwable -> L44
            android.content.res.XmlResourceParser r10 = r10.getXml(r1)     // Catch: java.lang.Throwable -> L44
            r10.next()     // Catch: java.lang.Throwable -> L44
            int r1 = r10.getEventType()     // Catch: java.lang.Throwable -> L44
        L64:
            if (r1 == r5) goto L7d
            r9 = 2
            if (r1 != r9) goto L78
            java.lang.String r1 = r10.getName()     // Catch: java.lang.Throwable -> L44
            java.lang.String r9 = "domain-config"
            boolean r1 = r1.equals(r9)     // Catch: java.lang.Throwable -> L44
            if (r1 == 0) goto L78
            b(r10, r6, r8)     // Catch: java.lang.Throwable -> L44
        L78:
            int r1 = r10.next()     // Catch: java.lang.Throwable -> L44
            goto L64
        L7d:
            java.lang.String r10 = r6.toString()
        L81:
            java.lang.String r6 = r0.nativeLibraryDir
            android.os.Bundle r0 = r0.metaData
            if (r0 != 0) goto L89
            r0 = 1
            goto L8f
        L89:
            java.lang.String r1 = "io.flutter.automatically-register-plugins"
            boolean r0 = r0.getBoolean(r1, r5)
        L8f:
            r1 = r7
            r2 = r3
            r3 = r4
            r4 = r10
            r5 = r6
            r6 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            return r7
        L99:
            r10 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: H.a.a(android.content.Context):H.b");
    }

    public static void b(XmlResourceParser xmlResourceParser, JSONArray jSONArray, boolean z2) {
        boolean attributeBooleanValue = xmlResourceParser.getAttributeBooleanValue(null, "cleartextTrafficPermitted", z2);
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 2) {
                if (xmlResourceParser.getName().equals("domain")) {
                    boolean attributeBooleanValue2 = xmlResourceParser.getAttributeBooleanValue(null, "includeSubdomains", false);
                    xmlResourceParser.next();
                    if (xmlResourceParser.getEventType() != 4) {
                        throw new IllegalStateException("Expected text");
                    }
                    String trim = xmlResourceParser.getText().trim();
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(trim);
                    jSONArray2.put(attributeBooleanValue2);
                    jSONArray2.put(attributeBooleanValue);
                    jSONArray.put(jSONArray2);
                    xmlResourceParser.next();
                    if (xmlResourceParser.getEventType() != 3) {
                        throw new IllegalStateException("Expected end of domain tag");
                    }
                } else if (xmlResourceParser.getName().equals("domain-config")) {
                    b(xmlResourceParser, jSONArray, attributeBooleanValue);
                } else {
                    String name = xmlResourceParser.getName();
                    int eventType = xmlResourceParser.getEventType();
                    while (true) {
                        if (eventType != 3 || xmlResourceParser.getName() != name) {
                            eventType = xmlResourceParser.next();
                        }
                    }
                }
            } else if (next == 3) {
                return;
            }
        }
    }
}
