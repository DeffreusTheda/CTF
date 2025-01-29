package B;

import D.AbstractC0009j;
import D.G;
import D.H;
import D.I;
import D.K;
import D.M;
import D.v;
import K.f;
import K.g;
import K.k;
import K.m;
import L.i;
import L.j;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v.h;

/* loaded from: classes.dex */
public final class a implements K, i, L.b, L.c, h {

    /* renamed from: e, reason: collision with root package name */
    public static a f0e;

    /* renamed from: f, reason: collision with root package name */
    public static a f1f;

    /* renamed from: g, reason: collision with root package name */
    public static M f2g;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3b;

    /* renamed from: c, reason: collision with root package name */
    public Object f4c;

    /* renamed from: d, reason: collision with root package name */
    public Object f5d;

    public /* synthetic */ a(int i2, Object obj, Object obj2) {
        this.f3b = i2;
        this.f5d = obj;
        this.f4c = obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0085 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0094 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int e(B.a r11, org.json.JSONArray r12) {
        /*
            r11.getClass()
            r11 = 0
            r0 = 0
            r1 = 0
            r2 = 0
        L7:
            int r3 = r12.length()
            r4 = 2
            r5 = 4
            r6 = 1
            if (r0 >= r3) goto L73
            java.lang.String r3 = r12.getString(r0)
            int[] r5 = n.e.b(r5)
            int r7 = r5.length
            r8 = 0
        L1a:
            if (r8 >= r7) goto L5f
            r9 = r5[r8]
            r10 = 1
            if (r9 == r10) goto L35
            r10 = 2
            if (r9 == r10) goto L32
            r10 = 3
            if (r9 == r10) goto L2f
            r10 = 4
            if (r9 != r10) goto L2d
            java.lang.String r10 = "DeviceOrientation.landscapeRight"
            goto L37
        L2d:
            r11 = 0
            throw r11
        L2f:
            java.lang.String r10 = "DeviceOrientation.landscapeLeft"
            goto L37
        L32:
            java.lang.String r10 = "DeviceOrientation.portraitDown"
            goto L37
        L35:
            java.lang.String r10 = "DeviceOrientation.portraitUp"
        L37:
            boolean r10 = r10.equals(r3)
            if (r10 == 0) goto L5c
            int r3 = n.e.a(r9)
            if (r3 == 0) goto L54
            if (r3 == r6) goto L51
            if (r3 == r4) goto L4e
            r4 = 3
            if (r3 == r4) goto L4b
            goto L56
        L4b:
            r1 = r1 | 8
            goto L56
        L4e:
            r1 = r1 | 2
            goto L56
        L51:
            r1 = r1 | 4
            goto L56
        L54:
            r1 = r1 | 1
        L56:
            if (r2 != 0) goto L59
            r2 = r1
        L59:
            int r0 = r0 + 1
            goto L7
        L5c:
            int r8 = r8 + 1
            goto L1a
        L5f:
            java.lang.NoSuchFieldException r11 = new java.lang.NoSuchFieldException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "No such DeviceOrientation: "
            r12.<init>(r0)
            r12.append(r3)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L73:
            if (r1 == 0) goto L96
            r12 = 8
            r0 = 9
            switch(r1) {
                case 2: goto L97;
                case 3: goto L8e;
                case 4: goto L8b;
                case 5: goto L88;
                case 6: goto L8e;
                case 7: goto L8e;
                case 8: goto L85;
                case 9: goto L8e;
                case 10: goto L82;
                case 11: goto L80;
                case 12: goto L8e;
                case 13: goto L8e;
                case 14: goto L8e;
                case 15: goto L7d;
                default: goto L7c;
            }
        L7c:
            goto L94
        L7d:
            r11 = 13
            goto L97
        L80:
            r11 = 2
            goto L97
        L82:
            r11 = 11
            goto L97
        L85:
            r11 = 8
            goto L97
        L88:
            r11 = 12
            goto L97
        L8b:
            r11 = 9
            goto L97
        L8e:
            if (r2 == r4) goto L97
            if (r2 == r5) goto L8b
            if (r2 == r12) goto L85
        L94:
            r11 = 1
            goto L97
        L96:
            r11 = -1
        L97:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: B.a.e(B.a, org.json.JSONArray):int");
    }

    public static ArrayList f(a aVar, JSONArray jSONArray) {
        aVar.getClass();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String string = jSONArray.getString(i2);
            for (g gVar : g.values()) {
                if (gVar.f241b.equals(string)) {
                    int ordinal = gVar.ordinal();
                    if (ordinal == 0) {
                        arrayList.add(g.TOP_OVERLAYS);
                    } else if (ordinal == 1) {
                        arrayList.add(g.BOTTOM_OVERLAYS);
                    }
                }
            }
            throw new NoSuchFieldException("No such SystemUiOverlay: " + string);
        }
        return arrayList;
    }

    public static int g(a aVar, String str) {
        String str2;
        aVar.getClass();
        for (int i2 : n.e.b(4)) {
            if (i2 == 1) {
                str2 = "SystemUiMode.leanBack";
            } else if (i2 == 2) {
                str2 = "SystemUiMode.immersive";
            } else if (i2 == 3) {
                str2 = "SystemUiMode.immersiveSticky";
            } else {
                if (i2 != 4) {
                    throw null;
                }
                str2 = "SystemUiMode.edgeToEdge";
            }
            if (str2.equals(str)) {
                int a2 = n.e.a(i2);
                if (a2 == 0) {
                    return 1;
                }
                if (a2 != 1) {
                    return a2 != 2 ? 4 : 3;
                }
                return 2;
            }
        }
        throw new NoSuchFieldException("No such SystemUiMode: " + str);
    }

    public static f h(a aVar, JSONObject jSONObject) {
        aVar.getClass();
        return new f(!jSONObject.isNull("statusBarColor") ? Integer.valueOf(jSONObject.getInt("statusBarColor")) : null, !jSONObject.isNull("statusBarIconBrightness") ? AbstractC0009j.a(jSONObject.getString("statusBarIconBrightness")) : 0, !jSONObject.isNull("systemStatusBarContrastEnforced") ? Boolean.valueOf(jSONObject.getBoolean("systemStatusBarContrastEnforced")) : null, !jSONObject.isNull("systemNavigationBarColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarColor")) : null, !jSONObject.isNull("systemNavigationBarIconBrightness") ? AbstractC0009j.a(jSONObject.getString("systemNavigationBarIconBrightness")) : 0, !jSONObject.isNull("systemNavigationBarDividerColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor")) : null, jSONObject.isNull("systemNavigationBarContrastEnforced") ? null : Boolean.valueOf(jSONObject.getBoolean("systemNavigationBarContrastEnforced")));
    }

    public static HashMap i(String str, int i2, int i3, int i4, int i5) {
        HashMap hashMap = new HashMap();
        hashMap.put("text", str);
        hashMap.put("selectionBase", Integer.valueOf(i2));
        hashMap.put("selectionExtent", Integer.valueOf(i3));
        hashMap.put("composingBase", Integer.valueOf(i4));
        hashMap.put("composingExtent", Integer.valueOf(i5));
        return hashMap;
    }

    public static a j() {
        if (f0e == null) {
            b bVar = new b(2);
            C.a aVar = new C.a();
            aVar.f11a = 0;
            ExecutorService newCachedThreadPool = Executors.newCachedThreadPool(aVar);
            FlutterJNI flutterJNI = new FlutterJNI();
            H.f fVar = new H.f();
            fVar.f216a = false;
            fVar.f220e = flutterJNI;
            fVar.f221f = newCachedThreadPool;
            a aVar2 = new a(1, false);
            aVar2.f4c = fVar;
            aVar2.f5d = bVar;
            f0e = aVar2;
        }
        return f0e;
    }

    @Override // D.K
    public void a(KeyEvent keyEvent, final I i2) {
        int action = keyEvent.getAction();
        if (action != 0 && action != 1) {
            i2.a(false);
            return;
        }
        Character a2 = ((H) this.f5d).a(keyEvent.getUnicodeChar());
        boolean z2 = action != 0;
        final L.b bVar = new L.b() { // from class: D.C
            @Override // L.b
            public void d(Object obj) {
                boolean z3 = false;
                if (obj != null) {
                    try {
                        z3 = ((JSONObject) obj).getBoolean("handled");
                    } catch (JSONException e2) {
                        Log.e("KeyEventChannel", "Unable to unpack JSON message: " + e2);
                    }
                }
                ((I) i2).a(z3);
            }
        };
        K.c cVar = (K.c) this.f4c;
        HashMap hashMap = new HashMap();
        hashMap.put("type", z2 ? "keyup" : "keydown");
        hashMap.put("keymap", "android");
        hashMap.put("flags", Integer.valueOf(keyEvent.getFlags()));
        hashMap.put("plainCodePoint", Integer.valueOf(keyEvent.getUnicodeChar(0)));
        hashMap.put("codePoint", Integer.valueOf(keyEvent.getUnicodeChar()));
        hashMap.put("keyCode", Integer.valueOf(keyEvent.getKeyCode()));
        hashMap.put("scanCode", Integer.valueOf(keyEvent.getScanCode()));
        hashMap.put("metaState", Integer.valueOf(keyEvent.getMetaState()));
        hashMap.put("character", a2.toString());
        hashMap.put("source", Integer.valueOf(keyEvent.getSource()));
        hashMap.put("deviceId", Integer.valueOf(keyEvent.getDeviceId()));
        hashMap.put("repeatCount", Integer.valueOf(keyEvent.getRepeatCount()));
        cVar.f224a.j(hashMap, new L.b() { // from class: D.C
            @Override // L.b
            public void d(Object obj) {
                boolean z3 = false;
                if (obj != null) {
                    try {
                        z3 = ((JSONObject) obj).getBoolean("handled");
                    } catch (JSONException e2) {
                        Log.e("KeyEventChannel", "Unable to unpack JSON message: " + e2);
                    }
                }
                ((I) bVar).a(z3);
            }
        });
    }

    @Override // L.c
    public void b(ByteBuffer byteBuffer, F.f fVar) {
        switch (this.f3b) {
            case 11:
                e eVar = (e) this.f5d;
                try {
                    ((v) this.f4c).m(((L.h) eVar.f10c).b(byteBuffer), new a(10, this, fVar));
                    break;
                } catch (RuntimeException e2) {
                    Log.e("BasicMessageChannel#".concat((String) eVar.f9b), "Failed to handle message", e2);
                    fVar.a(null);
                    return;
                }
            default:
                e eVar2 = (e) this.f5d;
                try {
                    ((i) this.f4c).c(((j) eVar2.f10c).g(byteBuffer), new k(1, this, fVar));
                    break;
                } catch (RuntimeException e3) {
                    Log.e("MethodChannel#".concat((String) eVar2.f9b), "Failed to handle method call", e3);
                    fVar.a(((j) eVar2.f10c).a(e3.getMessage(), Log.getStackTraceString(e3)));
                }
        }
    }

    @Override // L.i
    public void c(a aVar, k kVar) {
        v vVar = (v) this.f5d;
        if (((e) vVar.f94c) == null) {
            kVar.c((Map) this.f4c);
            return;
        }
        String str = (String) aVar.f4c;
        str.getClass();
        if (!str.equals("getKeyboardState")) {
            kVar.b();
            return;
        }
        try {
            this.f4c = Collections.unmodifiableMap(((G) ((K[]) ((e) vVar.f94c).f9b)[0]).f27c);
        } catch (IllegalStateException e2) {
            kVar.a("error", e2.getMessage(), null);
        }
        kVar.c((Map) this.f4c);
    }

    @Override // L.b
    public void d(Object obj) {
        switch (this.f3b) {
            case 8:
                e eVar = (e) this.f5d;
                ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) eVar.f8a;
                m mVar = (m) this.f4c;
                concurrentLinkedQueue.remove(mVar);
                if (!((ConcurrentLinkedQueue) eVar.f8a).isEmpty()) {
                    Log.e("SettingsChannel", "The queue becomes empty after removing config generation " + String.valueOf(mVar.f273a));
                    break;
                }
                break;
            default:
                ((F.f) this.f4c).a(((L.h) ((e) ((a) this.f5d).f5d).f10c).c(obj));
                break;
        }
    }

    public /* synthetic */ a(int i2, boolean z2) {
        this.f3b = i2;
    }

    public a(N.a aVar, v vVar) {
        this.f3b = 14;
        this.f4c = aVar;
        this.f5d = vVar;
        vVar.f94c = new v(24, this);
    }

    public a(K.c cVar) {
        this.f3b = 2;
        this.f5d = new H();
        this.f4c = cVar;
    }

    public a(v vVar) {
        this.f3b = 4;
        this.f5d = vVar;
        this.f4c = new HashMap();
    }

    public a(View view, InputMethodManager inputMethodManager, v vVar) {
        this.f3b = 15;
        if (Build.VERSION.SDK_INT >= 33) {
            view.setAutoHandwritingEnabled(false);
        }
        this.f5d = view;
        this.f4c = inputMethodManager;
        vVar.f94c = this;
    }

    public a(Object obj, String str) {
        this.f3b = 12;
        this.f4c = str;
        this.f5d = obj;
    }

    public a(v.b bVar) {
        this.f3b = 17;
        a aVar = new a(16);
        this.f4c = bVar;
        this.f5d = aVar;
    }

    public a(int i2) {
        this.f3b = i2;
        switch (i2) {
            case 16:
                this.f4c = new ReentrantLock();
                this.f5d = new LinkedHashMap();
                break;
            default:
                this.f4c = new LongSparseArray();
                this.f5d = new PriorityQueue();
                break;
        }
    }

    public a(F.b bVar, int i2) {
        this.f3b = i2;
        switch (i2) {
            case 6:
                v vVar = new v(11, this);
                e eVar = new e(bVar, "flutter/platform", L.g.f307b);
                this.f4c = eVar;
                eVar.k(vVar);
                break;
            case 9:
                v vVar2 = new v(22, this);
                e eVar2 = new e(bVar, "flutter/textinput", L.g.f307b);
                this.f4c = eVar2;
                eVar2.k(vVar2);
                break;
            default:
                v vVar3 = new v(8, this);
                e eVar3 = new e(bVar, "flutter/localization", L.g.f307b);
                this.f4c = eVar3;
                eVar3.k(vVar3);
                break;
        }
    }

    public a(F.b bVar, PackageManager packageManager) {
        this.f3b = 7;
        v vVar = new v(16, this);
        this.f4c = packageManager;
        new e(bVar, "flutter/processtext", L.m.f311a).k(vVar);
    }
}
