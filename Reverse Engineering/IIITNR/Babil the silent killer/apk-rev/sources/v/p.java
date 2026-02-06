package v;

import android.os.Bundle;
import androidx.window.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w.i;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public final w.i f1337a;

    /* renamed from: b, reason: collision with root package name */
    private f f1338b;

    /* renamed from: c, reason: collision with root package name */
    final i.c f1339c;

    class a implements i.c {
        a() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // w.i.c
        public void a(w.h hVar, i.d dVar) {
            String message;
            Bundle bundle;
            if (p.this.f1338b == null) {
            }
            String str = hVar.f1398a;
            Object obj = hVar.f1399b;
            j.b.f("TextInputChannel", "Received '" + str + "' message.");
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1779068172:
                    if (str.equals("TextInput.setPlatformViewClient")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1015421462:
                    if (str.equals("TextInput.setEditingState")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -37561188:
                    if (str.equals("TextInput.setClient")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 270476819:
                    if (str.equals("TextInput.hide")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 270803918:
                    if (str.equals("TextInput.show")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 649192816:
                    if (str.equals("TextInput.sendAppPrivateCommand")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1204752139:
                    if (str.equals("TextInput.setEditableSizeAndTransform")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1727570905:
                    if (str.equals("TextInput.finishAutofillContext")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 1904427655:
                    if (str.equals("TextInput.clearClient")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 2113369584:
                    if (str.equals("TextInput.requestAutofill")) {
                        c2 = '\t';
                        break;
                    }
                    break;
            }
            try {
                switch (c2) {
                    case 0:
                        JSONObject jSONObject = (JSONObject) obj;
                        p.this.f1338b.g(jSONObject.getInt("platformViewId"), jSONObject.optBoolean("usesVirtualDisplay", false));
                        dVar.b(null);
                        break;
                    case 1:
                        p.this.f1338b.b(e.a((JSONObject) obj));
                        dVar.b(null);
                        break;
                    case 2:
                        try {
                            JSONArray jSONArray = (JSONArray) obj;
                            p.this.f1338b.f(jSONArray.getInt(0), b.a(jSONArray.getJSONObject(1)));
                            dVar.b(null);
                            break;
                        } catch (NoSuchFieldException | JSONException e2) {
                            message = e2.getMessage();
                            dVar.a("error", message, null);
                            return;
                        }
                    case 3:
                        p.this.f1338b.j();
                        dVar.b(null);
                        break;
                    case 4:
                        p.this.f1338b.e();
                        dVar.b(null);
                        break;
                    case R.styleable.SplitPairRule_splitMinWidth /* 5 */:
                        JSONObject jSONObject2 = (JSONObject) obj;
                        String string = jSONObject2.getString("action");
                        String string2 = jSONObject2.getString("data");
                        if (string2 == null || string2.isEmpty()) {
                            bundle = null;
                        } else {
                            bundle = new Bundle();
                            bundle.putString("data", string2);
                        }
                        p.this.f1338b.a(string, bundle);
                        dVar.b(null);
                        break;
                    case R.styleable.SplitPairRule_splitRatio /* 6 */:
                        JSONObject jSONObject3 = (JSONObject) obj;
                        double d2 = jSONObject3.getDouble("width");
                        double d3 = jSONObject3.getDouble("height");
                        JSONArray jSONArray2 = jSONObject3.getJSONArray("transform");
                        double[] dArr = new double[16];
                        for (int i2 = 0; i2 < 16; i2++) {
                            dArr[i2] = jSONArray2.getDouble(i2);
                        }
                        p.this.f1338b.h(d2, d3, dArr);
                        dVar.b(null);
                        break;
                    case 7:
                        p.this.f1338b.i(((Boolean) obj).booleanValue());
                        dVar.b(null);
                        break;
                    case '\b':
                        p.this.f1338b.d();
                        dVar.b(null);
                        break;
                    case '\t':
                        p.this.f1338b.c();
                        dVar.b(null);
                        break;
                    default:
                        dVar.c();
                        break;
                }
            } catch (JSONException e3) {
                message = e3.getMessage();
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f1341a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f1342b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f1343c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f1344d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f1345e;

        /* renamed from: f, reason: collision with root package name */
        public final d f1346f;

        /* renamed from: g, reason: collision with root package name */
        public final c f1347g;

        /* renamed from: h, reason: collision with root package name */
        public final Integer f1348h;

        /* renamed from: i, reason: collision with root package name */
        public final String f1349i;

        /* renamed from: j, reason: collision with root package name */
        public final a f1350j;

        /* renamed from: k, reason: collision with root package name */
        public final String[] f1351k;

        /* renamed from: l, reason: collision with root package name */
        public final b[] f1352l;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public final String f1353a;

            /* renamed from: b, reason: collision with root package name */
            public final String[] f1354b;

            /* renamed from: c, reason: collision with root package name */
            public final e f1355c;

            /* renamed from: d, reason: collision with root package name */
            public final String f1356d;

            public a(String str, String[] strArr, String str2, e eVar) {
                this.f1353a = str;
                this.f1354b = strArr;
                this.f1356d = str2;
                this.f1355c = eVar;
            }

            public static a a(JSONObject jSONObject) {
                String string = jSONObject.getString("uniqueIdentifier");
                JSONArray jSONArray = jSONObject.getJSONArray("hints");
                String string2 = jSONObject.isNull("hintText") ? null : jSONObject.getString("hintText");
                JSONObject jSONObject2 = jSONObject.getJSONObject("editingValue");
                String[] strArr = new String[jSONArray.length()];
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    strArr[i2] = b(jSONArray.getString(i2));
                }
                return new a(string, strArr, string2, e.a(jSONObject2));
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:74:0x00a3, code lost:
            
                if (r16.equals("familyName") == false) goto L7;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            private static java.lang.String b(java.lang.String r16) {
                /*
                    Method dump skipped, instructions count: 802
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: v.p.b.a.b(java.lang.String):java.lang.String");
            }
        }

        public b(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, d dVar, c cVar, Integer num, String str, a aVar, String[] strArr, b[] bVarArr) {
            this.f1341a = z2;
            this.f1342b = z3;
            this.f1343c = z4;
            this.f1344d = z5;
            this.f1345e = z6;
            this.f1346f = dVar;
            this.f1347g = cVar;
            this.f1348h = num;
            this.f1349i = str;
            this.f1350j = aVar;
            this.f1351k = strArr;
            this.f1352l = bVarArr;
        }

        public static b a(JSONObject jSONObject) {
            b[] bVarArr;
            String string = jSONObject.getString("inputAction");
            if (string == null) {
                throw new JSONException("Configuration JSON missing 'inputAction' property.");
            }
            if (jSONObject.isNull("fields")) {
                bVarArr = null;
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray("fields");
                int length = jSONArray.length();
                b[] bVarArr2 = new b[length];
                for (int i2 = 0; i2 < length; i2++) {
                    bVarArr2[i2] = a(jSONArray.getJSONObject(i2));
                }
                bVarArr = bVarArr2;
            }
            Integer b2 = b(string);
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = jSONObject.isNull("contentCommitMimeTypes") ? null : jSONObject.getJSONArray("contentCommitMimeTypes");
            if (jSONArray2 != null) {
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    arrayList.add(jSONArray2.optString(i3));
                }
            }
            return new b(jSONObject.optBoolean("obscureText"), jSONObject.optBoolean("autocorrect", true), jSONObject.optBoolean("enableSuggestions"), jSONObject.optBoolean("enableIMEPersonalizedLearning"), jSONObject.optBoolean("enableDeltaModel"), d.a(jSONObject.getString("textCapitalization")), c.a(jSONObject.getJSONObject("inputType")), b2, jSONObject.isNull("actionLabel") ? null : jSONObject.getString("actionLabel"), jSONObject.isNull("autofill") ? null : a.a(jSONObject.getJSONObject("autofill")), (String[]) arrayList.toArray(new String[arrayList.size()]), bVarArr);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0072, code lost:
        
            if (r12.equals("TextInputAction.done") == false) goto L4;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static java.lang.Integer b(java.lang.String r12) {
            /*
                r12.hashCode()
                int r0 = r12.hashCode()
                r1 = 7
                r2 = 6
                r3 = 5
                r4 = 4
                r5 = 3
                r6 = 2
                r7 = 1
                java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
                r9 = 0
                java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
                r11 = -1
                switch(r0) {
                    case -810971940: goto L75;
                    case -737377923: goto L6c;
                    case -737089298: goto L61;
                    case -737080013: goto L56;
                    case -736940669: goto L4b;
                    case 469250275: goto L40;
                    case 1241689507: goto L35;
                    case 1539450297: goto L2a;
                    case 2110497650: goto L1e;
                    default: goto L1b;
                }
            L1b:
                r7 = -1
                goto L7f
            L1e:
                java.lang.String r0 = "TextInputAction.previous"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L27
                goto L1b
            L27:
                r7 = 8
                goto L7f
            L2a:
                java.lang.String r0 = "TextInputAction.newline"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L33
                goto L1b
            L33:
                r7 = 7
                goto L7f
            L35:
                java.lang.String r0 = "TextInputAction.go"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L3e
                goto L1b
            L3e:
                r7 = 6
                goto L7f
            L40:
                java.lang.String r0 = "TextInputAction.search"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L49
                goto L1b
            L49:
                r7 = 5
                goto L7f
            L4b:
                java.lang.String r0 = "TextInputAction.send"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L54
                goto L1b
            L54:
                r7 = 4
                goto L7f
            L56:
                java.lang.String r0 = "TextInputAction.none"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L5f
                goto L1b
            L5f:
                r7 = 3
                goto L7f
            L61:
                java.lang.String r0 = "TextInputAction.next"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L6a
                goto L1b
            L6a:
                r7 = 2
                goto L7f
            L6c:
                java.lang.String r0 = "TextInputAction.done"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L7f
                goto L1b
            L75:
                java.lang.String r0 = "TextInputAction.unspecified"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L7e
                goto L1b
            L7e:
                r7 = 0
            L7f:
                switch(r7) {
                    case 0: goto La3;
                    case 1: goto L9e;
                    case 2: goto L99;
                    case 3: goto L98;
                    case 4: goto L93;
                    case 5: goto L8e;
                    case 6: goto L89;
                    case 7: goto L88;
                    case 8: goto L83;
                    default: goto L82;
                }
            L82:
                return r10
            L83:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
                return r12
            L88:
                return r8
            L89:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
                return r12
            L8e:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r5)
                return r12
            L93:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r4)
                return r12
            L98:
                return r8
            L99:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r3)
                return r12
            L9e:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r2)
                return r12
            La3:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: v.p.b.b(java.lang.String):java.lang.Integer");
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final g f1357a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f1358b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f1359c;

        public c(g gVar, boolean z2, boolean z3) {
            this.f1357a = gVar;
            this.f1358b = z2;
            this.f1359c = z3;
        }

        public static c a(JSONObject jSONObject) {
            return new c(g.a(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean("decimal", false));
        }
    }

    public enum d {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");


        /* renamed from: d, reason: collision with root package name */
        private final String f1365d;

        d(String str) {
            this.f1365d = str;
        }

        static d a(String str) {
            for (d dVar : values()) {
                if (dVar.f1365d.equals(str)) {
                    return dVar;
                }
            }
            throw new NoSuchFieldException("No such TextCapitalization: " + str);
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final String f1366a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1367b;

        /* renamed from: c, reason: collision with root package name */
        public final int f1368c;

        /* renamed from: d, reason: collision with root package name */
        public final int f1369d;

        /* renamed from: e, reason: collision with root package name */
        public final int f1370e;

        public e(String str, int i2, int i3, int i4, int i5) {
            if (!(i2 == -1 && i3 == -1) && (i2 < 0 || i3 < 0)) {
                throw new IndexOutOfBoundsException("invalid selection: (" + String.valueOf(i2) + ", " + String.valueOf(i3) + ")");
            }
            if (!(i4 == -1 && i5 == -1) && (i4 < 0 || i4 > i5)) {
                throw new IndexOutOfBoundsException("invalid composing range: (" + String.valueOf(i4) + ", " + String.valueOf(i5) + ")");
            }
            if (i5 > str.length()) {
                throw new IndexOutOfBoundsException("invalid composing start: " + String.valueOf(i4));
            }
            if (i2 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection start: " + String.valueOf(i2));
            }
            if (i3 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection end: " + String.valueOf(i3));
            }
            this.f1366a = str;
            this.f1367b = i2;
            this.f1368c = i3;
            this.f1369d = i4;
            this.f1370e = i5;
        }

        public static e a(JSONObject jSONObject) {
            return new e(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
        }

        public boolean b() {
            int i2 = this.f1369d;
            return i2 >= 0 && this.f1370e > i2;
        }

        public boolean c() {
            return this.f1367b >= 0;
        }
    }

    public interface f {
        void a(String str, Bundle bundle);

        void b(e eVar);

        void c();

        void d();

        void e();

        void f(int i2, b bVar);

        void g(int i2, boolean z2);

        void h(double d2, double d3, double[] dArr);

        void i(boolean z2);

        void j();
    }

    public enum g {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NAME("TextInputType.name"),
        POSTAL_ADDRESS("TextInputType.address"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword"),
        NONE("TextInputType.none");


        /* renamed from: d, reason: collision with root package name */
        private final String f1383d;

        g(String str) {
            this.f1383d = str;
        }

        static g a(String str) {
            for (g gVar : values()) {
                if (gVar.f1383d.equals(str)) {
                    return gVar;
                }
            }
            throw new NoSuchFieldException("No such TextInputType: " + str);
        }
    }

    public p(k.a aVar) {
        a aVar2 = new a();
        this.f1339c = aVar2;
        w.i iVar = new w.i(aVar, "flutter/textinput", w.e.f1397a);
        this.f1337a = iVar;
        iVar.e(aVar2);
    }

    private static HashMap<Object, Object> c(ArrayList<io.flutter.plugin.editing.e> arrayList) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        JSONArray jSONArray = new JSONArray();
        Iterator<io.flutter.plugin.editing.e> it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().b());
        }
        hashMap.put("deltas", jSONArray);
        return hashMap;
    }

    private static HashMap<Object, Object> d(String str, int i2, int i3, int i4, int i5) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("text", str);
        hashMap.put("selectionBase", Integer.valueOf(i2));
        hashMap.put("selectionExtent", Integer.valueOf(i3));
        hashMap.put("composingBase", Integer.valueOf(i4));
        hashMap.put("composingExtent", Integer.valueOf(i5));
        return hashMap;
    }

    public void b(int i2, Map<String, Object> map) {
        j.b.f("TextInputChannel", "Sending 'commitContent' message.");
        this.f1337a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.commitContent", map));
    }

    public void e(int i2) {
        j.b.f("TextInputChannel", "Sending 'done' message.");
        this.f1337a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.done"));
    }

    public void f(int i2) {
        j.b.f("TextInputChannel", "Sending 'go' message.");
        this.f1337a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.go"));
    }

    public void g(int i2) {
        j.b.f("TextInputChannel", "Sending 'newline' message.");
        this.f1337a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.newline"));
    }

    public void h(int i2) {
        j.b.f("TextInputChannel", "Sending 'next' message.");
        this.f1337a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.next"));
    }

    public void i(int i2, String str, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put("action", str);
        if (bundle != null) {
            HashMap hashMap2 = new HashMap();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj instanceof byte[]) {
                    hashMap2.put(str2, bundle.getByteArray(str2));
                } else if (obj instanceof Byte) {
                    hashMap2.put(str2, Byte.valueOf(bundle.getByte(str2)));
                } else if (obj instanceof char[]) {
                    hashMap2.put(str2, bundle.getCharArray(str2));
                } else if (obj instanceof Character) {
                    hashMap2.put(str2, Character.valueOf(bundle.getChar(str2)));
                } else if (obj instanceof CharSequence[]) {
                    hashMap2.put(str2, bundle.getCharSequenceArray(str2));
                } else if (obj instanceof CharSequence) {
                    hashMap2.put(str2, bundle.getCharSequence(str2));
                } else if (obj instanceof float[]) {
                    hashMap2.put(str2, bundle.getFloatArray(str2));
                } else if (obj instanceof Float) {
                    hashMap2.put(str2, Float.valueOf(bundle.getFloat(str2)));
                }
            }
            hashMap.put("data", hashMap2);
        }
        this.f1337a.c("TextInputClient.performPrivateCommand", Arrays.asList(Integer.valueOf(i2), hashMap));
    }

    public void j(int i2) {
        j.b.f("TextInputChannel", "Sending 'previous' message.");
        this.f1337a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.previous"));
    }

    public void k() {
        this.f1337a.c("TextInputClient.requestExistingInputState", null);
    }

    public void l(int i2) {
        j.b.f("TextInputChannel", "Sending 'search' message.");
        this.f1337a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.search"));
    }

    public void m(int i2) {
        j.b.f("TextInputChannel", "Sending 'send' message.");
        this.f1337a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.send"));
    }

    public void n(f fVar) {
        this.f1338b = fVar;
    }

    public void o(int i2) {
        j.b.f("TextInputChannel", "Sending 'unspecified' message.");
        this.f1337a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.unspecified"));
    }

    public void p(int i2, String str, int i3, int i4, int i5, int i6) {
        j.b.f("TextInputChannel", "Sending message to update editing state: \nText: " + str + "\nSelection start: " + i3 + "\nSelection end: " + i4 + "\nComposing start: " + i5 + "\nComposing end: " + i6);
        this.f1337a.c("TextInputClient.updateEditingState", Arrays.asList(Integer.valueOf(i2), d(str, i3, i4, i5, i6)));
    }

    public void q(int i2, ArrayList<io.flutter.plugin.editing.e> arrayList) {
        j.b.f("TextInputChannel", "Sending message to update editing state with deltas: \nNumber of deltas: " + arrayList.size());
        this.f1337a.c("TextInputClient.updateEditingStateWithDeltas", Arrays.asList(Integer.valueOf(i2), c(arrayList)));
    }

    public void r(int i2, HashMap<String, e> hashMap) {
        j.b.f("TextInputChannel", "Sending message to update editing state for " + String.valueOf(hashMap.size()) + " field(s).");
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, e> entry : hashMap.entrySet()) {
            e value = entry.getValue();
            hashMap2.put(entry.getKey(), d(value.f1366a, value.f1367b, value.f1368c, -1, -1));
        }
        this.f1337a.c("TextInputClient.updateEditingStateWithTag", Arrays.asList(Integer.valueOf(i2), hashMap2));
    }
}
