package D;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.LongSparseArray;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import io.flutter.embedding.engine.FlutterJNI;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;

/* loaded from: classes.dex */
public final class v implements L.c, L.e, L.i {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f93b;

    /* renamed from: c, reason: collision with root package name */
    public Object f94c;

    public /* synthetic */ v(int i2, Object obj) {
        this.f93b = i2;
        this.f94c = obj;
    }

    public static boolean k(int i2) {
        return (48 <= i2 && i2 <= 57) || i2 == 35 || i2 == 42;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0177 A[Catch: JSONException -> 0x002d, TryCatch #11 {JSONException -> 0x002d, blocks: (B:7:0x0014, B:8:0x001d, B:13:0x00d1, B:15:0x00d6, B:17:0x0105, B:20:0x0129, B:22:0x011c, B:25:0x0123, B:26:0x0138, B:28:0x015c, B:38:0x0160, B:31:0x016d, B:33:0x0177, B:35:0x0184, B:40:0x0165, B:41:0x0189, B:43:0x019d, B:45:0x01af, B:46:0x01b2, B:48:0x01d9, B:50:0x01e9, B:78:0x02cc, B:53:0x02e6, B:55:0x02f6, B:56:0x0307, B:59:0x0304, B:96:0x01d0, B:122:0x023f, B:103:0x025d, B:75:0x02a1, B:89:0x02c4, B:82:0x02de, B:61:0x030c, B:124:0x0022, B:127:0x0030, B:130:0x003b, B:133:0x0047, B:136:0x0053, B:139:0x005e, B:142:0x0069, B:145:0x0073, B:148:0x007d, B:151:0x0087, B:154:0x0091, B:157:0x009b, B:160:0x00a6, B:163:0x00b1, B:166:0x00bc, B:64:0x0266, B:66:0x0270, B:67:0x0273, B:69:0x0289, B:70:0x029b, B:73:0x0292), top: B:6:0x0014, inners: #2, #6, #7, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0184 A[Catch: JSONException -> 0x002d, TryCatch #11 {JSONException -> 0x002d, blocks: (B:7:0x0014, B:8:0x001d, B:13:0x00d1, B:15:0x00d6, B:17:0x0105, B:20:0x0129, B:22:0x011c, B:25:0x0123, B:26:0x0138, B:28:0x015c, B:38:0x0160, B:31:0x016d, B:33:0x0177, B:35:0x0184, B:40:0x0165, B:41:0x0189, B:43:0x019d, B:45:0x01af, B:46:0x01b2, B:48:0x01d9, B:50:0x01e9, B:78:0x02cc, B:53:0x02e6, B:55:0x02f6, B:56:0x0307, B:59:0x0304, B:96:0x01d0, B:122:0x023f, B:103:0x025d, B:75:0x02a1, B:89:0x02c4, B:82:0x02de, B:61:0x030c, B:124:0x0022, B:127:0x0030, B:130:0x003b, B:133:0x0047, B:136:0x0053, B:139:0x005e, B:142:0x0069, B:145:0x0073, B:148:0x007d, B:151:0x0087, B:154:0x0091, B:157:0x009b, B:160:0x00a6, B:163:0x00b1, B:166:0x00bc, B:64:0x0266, B:66:0x0270, B:67:0x0273, B:69:0x0289, B:70:0x029b, B:73:0x0292), top: B:6:0x0014, inners: #2, #6, #7, #9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void n(B.a r13, K.k r14) {
        /*
            Method dump skipped, instructions count: 906
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D.v.n(B.a, K.k):void");
    }

    private final void o(B.a aVar, K.k kVar) {
        Object obj;
        v vVar = (v) this.f94c;
        if (((io.flutter.plugin.platform.i) vVar.f94c) == null) {
            return;
        }
        String str = (String) aVar.f4c;
        str.getClass();
        obj = aVar.f5d;
        switch (str) {
            case "create":
                Map map = (Map) obj;
                if (map.containsKey("params")) {
                    ByteBuffer.wrap((byte[]) map.get("params"));
                }
                try {
                    ((Integer) map.get("id")).getClass();
                    String str2 = (String) map.get("viewType");
                    ((Integer) map.get("direction")).getClass();
                    if (((io.flutter.plugin.platform.j) ((io.flutter.plugin.platform.i) vVar.f94c).f705c).f706a.f168a.get(str2) != null) {
                        throw new ClassCastException();
                    }
                    throw new IllegalStateException("Trying to create a platform view of unregistered type: " + str2);
                } catch (IllegalStateException e2) {
                    kVar.a("error", Log.getStackTraceString(e2), null);
                    return;
                }
            case "clearFocus":
                int intValue = ((Integer) obj).intValue();
                try {
                    if (((io.flutter.plugin.platform.j) ((io.flutter.plugin.platform.i) vVar.f94c).f705c).f712g.get(intValue) != null) {
                        throw new ClassCastException();
                    }
                    Log.e("PlatformViewsController2", "Clearing focus on an unknown view with id: " + intValue);
                    kVar.c(null);
                    return;
                } catch (IllegalStateException e3) {
                    kVar.a("error", Log.getStackTraceString(e3), null);
                    return;
                }
            case "touch":
                List list = (List) obj;
                int intValue2 = ((Integer) list.get(0)).intValue();
                ((Integer) list.get(3)).getClass();
                ((Integer) list.get(4)).getClass();
                list.get(5);
                list.get(6);
                ((Integer) list.get(7)).getClass();
                ((Integer) list.get(8)).getClass();
                ((Double) list.get(9)).getClass();
                ((Double) list.get(10)).getClass();
                ((Integer) list.get(11)).getClass();
                ((Integer) list.get(12)).getClass();
                ((Integer) list.get(13)).getClass();
                ((Integer) list.get(14)).getClass();
                ((Number) list.get(15)).longValue();
                try {
                    io.flutter.plugin.platform.i iVar = (io.flutter.plugin.platform.i) vVar.f94c;
                    iVar.getClass();
                    io.flutter.plugin.platform.j jVar = (io.flutter.plugin.platform.j) iVar.f705c;
                    float f2 = jVar.f707b.getResources().getDisplayMetrics().density;
                    if (jVar.f712g.get(intValue2) != null) {
                        throw new ClassCastException();
                    }
                    Log.e("PlatformViewsController2", "Sending touch to an unknown view with id: " + intValue2);
                    kVar.c(null);
                    return;
                } catch (IllegalStateException e4) {
                    kVar.a("error", Log.getStackTraceString(e4), null);
                    return;
                }
            case "setDirection":
                Map map2 = (Map) obj;
                int intValue3 = ((Integer) map2.get("id")).intValue();
                ((Integer) map2.get("direction")).getClass();
                try {
                    if (((io.flutter.plugin.platform.j) ((io.flutter.plugin.platform.i) vVar.f94c).f705c).f712g.get(intValue3) != null) {
                        throw new ClassCastException();
                    }
                    Log.e("PlatformViewsController2", "Setting direction to an unknown view with id: " + intValue3);
                    kVar.c(null);
                    return;
                } catch (IllegalStateException e5) {
                    kVar.a("error", Log.getStackTraceString(e5), null);
                    return;
                }
            case "isSurfaceControlEnabled":
                FlutterJNI flutterJNI = ((io.flutter.plugin.platform.j) ((io.flutter.plugin.platform.i) vVar.f94c).f705c).f709d;
                kVar.c(Boolean.valueOf(flutterJNI != null ? flutterJNI.IsSurfaceControlEnabled() : false));
                return;
            case "dispose":
                try {
                    ((io.flutter.plugin.platform.i) vVar.f94c).c(((Integer) ((Map) obj).get("id")).intValue());
                    kVar.c(null);
                    return;
                } catch (IllegalStateException e6) {
                    kVar.a("error", Log.getStackTraceString(e6), null);
                    return;
                }
            default:
                kVar.b();
                return;
        }
    }

    @Override // L.e
    public void a(String str, ByteBuffer byteBuffer, L.d dVar) {
        ((F.g) this.f94c).a(str, byteBuffer, dVar);
    }

    @Override // L.c
    public void b(ByteBuffer byteBuffer, F.f fVar) {
        L.n.f313b.getClass();
        L.n.a(byteBuffer);
        ((F.b) this.f94c).getClass();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:338:0x078c A[Catch: IllegalStateException -> 0x06ed, TryCatch #22 {IllegalStateException -> 0x06ed, blocks: (B:316:0x06d8, B:318:0x06de, B:321:0x06f2, B:323:0x070e, B:324:0x071d, B:326:0x0723, B:327:0x0732, B:328:0x075c, B:332:0x075d, B:338:0x078c, B:340:0x0796, B:341:0x07a9, B:342:0x07aa, B:343:0x07af, B:344:0x07b0, B:345:0x07d0), top: B:314:0x06d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:344:0x07b0 A[Catch: IllegalStateException -> 0x06ed, TryCatch #22 {IllegalStateException -> 0x06ed, blocks: (B:316:0x06d8, B:318:0x06de, B:321:0x06f2, B:323:0x070e, B:324:0x071d, B:326:0x0723, B:327:0x0732, B:328:0x075c, B:332:0x075d, B:338:0x078c, B:340:0x0796, B:341:0x07a9, B:342:0x07aa, B:343:0x07af, B:344:0x07b0, B:345:0x07d0), top: B:314:0x06d6 }] */
    @Override // L.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(B.a r43, K.k r44) {
        /*
            Method dump skipped, instructions count: 2380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D.v.c(B.a, K.k):void");
    }

    @Override // L.e
    public void d(String str, L.c cVar) {
        ((F.g) this.f94c).c(str, cVar);
    }

    public void e(String str) {
        Object orDefault;
        PointerIcon systemIcon;
        B.a aVar = (B.a) this.f94c;
        N.a aVar2 = (N.a) aVar.f4c;
        if (B.a.f2g == null) {
            M m = new M();
            m.put("alias", 1010);
            m.put("allScroll", 1013);
            m.put("basic", 1000);
            m.put("cell", 1006);
            m.put("click", 1002);
            m.put("contextMenu", 1001);
            m.put("copy", 1011);
            m.put("forbidden", 1012);
            m.put("grab", 1020);
            m.put("grabbing", 1021);
            m.put("help", 1003);
            m.put("move", 1013);
            m.put("none", 0);
            m.put("noDrop", 1012);
            m.put("precise", 1007);
            m.put("text", 1008);
            m.put("resizeColumn", 1014);
            m.put("resizeDown", 1015);
            m.put("resizeUpLeft", 1016);
            m.put("resizeDownRight", 1017);
            m.put("resizeLeft", 1014);
            m.put("resizeLeftRight", 1014);
            m.put("resizeRight", 1014);
            m.put("resizeRow", 1015);
            m.put("resizeUp", 1015);
            m.put("resizeUpDown", 1015);
            m.put("resizeUpLeft", 1017);
            m.put("resizeUpRight", 1016);
            m.put("resizeUpLeftDownRight", 1017);
            m.put("resizeUpRightDownLeft", 1016);
            m.put("verticalText", 1009);
            m.put("wait", 1004);
            m.put("zoomIn", 1018);
            m.put("zoomOut", 1019);
            B.a.f2g = m;
        }
        orDefault = B.a.f2g.getOrDefault(str, 1000);
        systemIcon = PointerIcon.getSystemIcon(((y) ((N.a) aVar.f4c)).getContext(), ((Integer) orDefault).intValue());
        aVar2.setPointerIcon(systemIcon);
    }

    public void f(int i2) {
        io.flutter.plugin.platform.k kVar = (io.flutter.plugin.platform.k) this.f94c;
        if (kVar.d(i2)) {
            ((io.flutter.plugin.platform.q) kVar.f725h.get(Integer.valueOf(i2))).getClass();
            Log.e("PlatformViewsController", "Clearing focus on a null view with id: " + i2);
            return;
        }
        if (kVar.f727j.get(i2) != null) {
            throw new ClassCastException();
        }
        Log.e("PlatformViewsController", "Clearing focus on an unknown view with id: " + i2);
    }

    public void g(K.h hVar) {
        io.flutter.plugin.platform.k kVar = (io.flutter.plugin.platform.k) this.f94c;
        kVar.getClass();
        int i2 = hVar.f242a;
        int i3 = hVar.f244c;
        if (i3 != 0 && i3 != 1) {
            throw new IllegalStateException("Trying to create a view with unknown direction value: " + i3 + "(view id: " + i2 + ")");
        }
        if (kVar.m.get(i2) != null) {
            throw new IllegalStateException("Trying to create an already created platform view, view id: " + i2);
        }
        if (kVar.f721d == null) {
            throw new IllegalStateException("Texture registry is null. This means that platform views controller was detached, view id: " + i2);
        }
        if (kVar.f720c == null) {
            throw new IllegalStateException("Flutter view is null. This means the platform views controller doesn't have an attached view, view id: " + i2);
        }
        HashMap hashMap = kVar.f718a.f168a;
        String str = hVar.f243b;
        if (hashMap.get(str) != null) {
            throw new ClassCastException();
        }
        throw new IllegalStateException("Trying to create a platform view of unregistered type: " + str);
    }

    public void h(int i2) {
        if (((io.flutter.plugin.platform.k) this.f94c).f727j.get(i2) != null) {
            throw new ClassCastException();
        }
        Log.e("PlatformViewsController", "Disposing unknown platform view with id: " + i2);
    }

    public CharSequence i(K.e eVar) {
        AbstractActivityC0005f abstractActivityC0005f = ((io.flutter.plugin.platform.e) this.f94c).f699a;
        ClipboardManager clipboardManager = (ClipboardManager) abstractActivityC0005f.getSystemService("clipboard");
        CharSequence charSequence = null;
        if (!clipboardManager.hasPrimaryClip()) {
            return null;
        }
        try {
            try {
                ClipData primaryClip = clipboardManager.getPrimaryClip();
                if (primaryClip == null) {
                    return null;
                }
                if (eVar != null && eVar != K.e.f229b) {
                    return null;
                }
                ClipData.Item itemAt = primaryClip.getItemAt(0);
                CharSequence text = itemAt.getText();
                if (text != null) {
                    return text;
                }
                try {
                    Uri uri = itemAt.getUri();
                    if (uri == null) {
                        Log.w("PlatformPlugin", "Clipboard item contained no textual content nor a URI to retrieve it from.");
                    } else {
                        String scheme = uri.getScheme();
                        if (scheme.equals("content")) {
                            AssetFileDescriptor openTypedAssetFileDescriptor = abstractActivityC0005f.getContentResolver().openTypedAssetFileDescriptor(uri, "text/*", null);
                            CharSequence coerceToText = itemAt.coerceToText(abstractActivityC0005f);
                            if (openTypedAssetFileDescriptor != null) {
                                try {
                                    openTypedAssetFileDescriptor.close();
                                } catch (IOException e2) {
                                    charSequence = coerceToText;
                                    e = e2;
                                    Log.w("PlatformPlugin", "Failed to close AssetFileDescriptor while trying to read text from URI.", e);
                                    return charSequence;
                                }
                            }
                            charSequence = coerceToText;
                        } else {
                            Log.w("PlatformPlugin", "Clipboard item contains a Uri with scheme '" + scheme + "'that is unhandled.");
                        }
                    }
                    return charSequence;
                } catch (IOException e3) {
                    e = e3;
                    charSequence = text;
                }
            } catch (IOException e4) {
                e = e4;
            }
        } catch (FileNotFoundException unused) {
            Log.w("PlatformPlugin", "Clipboard text was unable to be received from content URI.");
            return null;
        } catch (SecurityException e5) {
            Log.w("PlatformPlugin", "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", e5);
            return null;
        }
    }

    public String j(String str, String str2) {
        M.a aVar = (M.a) this.f94c;
        Context context = aVar.f315b;
        AbstractActivityC0005f abstractActivityC0005f = aVar.f315b;
        if (str2 != null) {
            Locale a2 = M.a.a(str2);
            Configuration configuration = new Configuration(abstractActivityC0005f.getResources().getConfiguration());
            configuration.setLocale(a2);
            context = abstractActivityC0005f.createConfigurationContext(configuration);
        }
        int identifier = context.getResources().getIdentifier(str, "string", abstractActivityC0005f.getPackageName());
        if (identifier != 0) {
            return context.getResources().getString(identifier);
        }
        return null;
    }

    public void l(int i2, double d2, double d3) {
        io.flutter.plugin.platform.k kVar = (io.flutter.plugin.platform.k) this.f94c;
        if (kVar.d(i2)) {
            return;
        }
        Log.e("PlatformViewsController", "Setting offset for unknown platform view with id: " + i2);
    }

    public void m(Object obj, B.a aVar) {
        HashMap hashMap;
        HashMap hashMap2;
        B.e eVar = (B.e) this.f94c;
        if (((io.flutter.view.b) eVar.f10c) == null) {
            aVar.d(null);
            return;
        }
        hashMap = (HashMap) obj;
        String str = (String) hashMap.get("type");
        hashMap2 = (HashMap) hashMap.get("data");
        str.getClass();
        switch (str) {
            case "tooltip":
                String str2 = (String) hashMap2.get("message");
                if (str2 != null) {
                    io.flutter.view.b bVar = (io.flutter.view.b) eVar.f10c;
                    if (Build.VERSION.SDK_INT < 28) {
                        io.flutter.view.l lVar = (io.flutter.view.l) bVar.f747a;
                        AccessibilityEvent c2 = lVar.c(0, 32);
                        c2.getText().add(str2);
                        lVar.g(c2);
                        break;
                    } else {
                        bVar.getClass();
                        break;
                    }
                }
                break;
            case "announce":
                String str3 = (String) hashMap2.get("message");
                if (str3 != null) {
                    io.flutter.view.b bVar2 = (io.flutter.view.b) eVar.f10c;
                    if (Build.VERSION.SDK_INT >= 36) {
                        bVar2.getClass();
                        Log.w("AccessibilityBridge", "Using AnnounceSemanticsEvent for accessibility is deprecated on Android. Migrate to using semantic properties for a more robust and accessible user experience.\nFlutter: If you are unsure why you are seeing this bug, it might be because you are using a widget that calls this method. See https://github.com/flutter/flutter/issues/165510 for more details.\nAndroid documentation: https://developer.android.com/reference/android/view/View#announceForAccessibility(java.lang.CharSequence)");
                    }
                    ((io.flutter.view.l) bVar2.f747a).f830a.announceForAccessibility(str3);
                    break;
                }
                break;
            case "tap":
                Integer num = (Integer) hashMap.get("nodeId");
                if (num != null) {
                    io.flutter.view.b bVar3 = (io.flutter.view.b) eVar.f10c;
                    ((io.flutter.view.l) bVar3.f747a).f(num.intValue(), 1);
                    break;
                }
                break;
            case "focus":
                Integer num2 = (Integer) hashMap.get("nodeId");
                if (num2 != null) {
                    io.flutter.view.b bVar4 = (io.flutter.view.b) eVar.f10c;
                    ((io.flutter.view.l) bVar4.f747a).f(num2.intValue(), 8);
                    break;
                }
                break;
            case "longPress":
                Integer num3 = (Integer) hashMap.get("nodeId");
                if (num3 != null) {
                    io.flutter.view.b bVar5 = (io.flutter.view.b) eVar.f10c;
                    ((io.flutter.view.l) bVar5.f747a).f(num3.intValue(), 2);
                    break;
                }
                break;
        }
        aVar.d(null);
    }

    public void p(K.j jVar) {
        PriorityQueue priorityQueue;
        LongSparseArray longSparseArray;
        long j2;
        io.flutter.plugin.platform.k kVar = (io.flutter.plugin.platform.k) this.f94c;
        float f2 = kVar.f719b.getResources().getDisplayMetrics().density;
        int i2 = jVar.f248a;
        if (!kVar.d(i2)) {
            if (kVar.f727j.get(i2) != null) {
                throw new ClassCastException();
            }
            Log.e("PlatformViewsController", "Sending touch to an unknown view with id: " + i2);
            return;
        }
        io.flutter.plugin.platform.q qVar = (io.flutter.plugin.platform.q) kVar.f725h.get(Integer.valueOf(i2));
        S s2 = new S(jVar.f262p);
        while (true) {
            B.a aVar = kVar.f735s;
            priorityQueue = (PriorityQueue) aVar.f5d;
            boolean isEmpty = priorityQueue.isEmpty();
            longSparseArray = (LongSparseArray) aVar.f4c;
            j2 = s2.f46a;
            if (isEmpty || ((Long) priorityQueue.peek()).longValue() >= j2) {
                break;
            } else {
                longSparseArray.remove(((Long) priorityQueue.poll()).longValue());
            }
        }
        if (!priorityQueue.isEmpty() && ((Long) priorityQueue.peek()).longValue() == j2) {
            priorityQueue.poll();
        }
        longSparseArray.remove(j2);
        List<List> list = (List) jVar.f254g;
        ArrayList arrayList = new ArrayList();
        for (List list2 : list) {
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            pointerCoords.orientation = (float) ((Double) list2.get(0)).doubleValue();
            pointerCoords.pressure = (float) ((Double) list2.get(1)).doubleValue();
            pointerCoords.size = (float) ((Double) list2.get(2)).doubleValue();
            double d2 = f2;
            pointerCoords.toolMajor = (float) (((Double) list2.get(3)).doubleValue() * d2);
            pointerCoords.toolMinor = (float) (((Double) list2.get(4)).doubleValue() * d2);
            pointerCoords.touchMajor = (float) (((Double) list2.get(5)).doubleValue() * d2);
            pointerCoords.touchMinor = (float) (((Double) list2.get(6)).doubleValue() * d2);
            pointerCoords.x = (float) (((Double) list2.get(7)).doubleValue() * d2);
            pointerCoords.y = (float) (((Double) list2.get(8)).doubleValue() * d2);
            arrayList.add(pointerCoords);
        }
        int i3 = jVar.f252e;
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) arrayList.toArray(new MotionEvent.PointerCoords[i3]);
        List<List> list3 = (List) jVar.f253f;
        ArrayList arrayList2 = new ArrayList();
        for (List list4 : list3) {
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            pointerProperties.id = ((Integer) list4.get(0)).intValue();
            pointerProperties.toolType = ((Integer) list4.get(1)).intValue();
            arrayList2.add(pointerProperties);
        }
        MotionEvent.obtain(jVar.f249b.longValue(), jVar.f250c.longValue(), jVar.f251d, jVar.f252e, (MotionEvent.PointerProperties[]) arrayList2.toArray(new MotionEvent.PointerProperties[i3]), pointerCoordsArr, jVar.f255h, jVar.f256i, jVar.f257j, jVar.f258k, jVar.f259l, jVar.m, jVar.f260n, jVar.f261o);
        qVar.getClass();
    }

    public void q(K.i iVar) {
        io.flutter.plugin.platform.k kVar = (io.flutter.plugin.platform.k) this.f94c;
        int h2 = kVar.h(iVar.f246b);
        int h3 = kVar.h(iVar.f247c);
        int i2 = iVar.f245a;
        if (!kVar.d(i2)) {
            if (kVar.f727j.get(i2) != null) {
                throw new ClassCastException();
            }
            Log.e("PlatformViewsController", "Resizing unknown platform view with id: " + i2);
            return;
        }
        float f2 = kVar.f719b.getResources().getDisplayMetrics().density;
        io.flutter.plugin.platform.q qVar = (io.flutter.plugin.platform.q) kVar.f725h.get(Integer.valueOf(i2));
        io.flutter.plugin.editing.k kVar2 = kVar.f722e;
        if (kVar2 != null) {
            if (kVar2.f682e.f676a == 3) {
                kVar2.f692p = true;
            }
            qVar.getClass();
        }
        qVar.getClass();
        if (h2 == 0 && h3 == 0) {
            throw null;
        }
        if (Build.VERSION.SDK_INT < 31) {
            throw null;
        }
        throw null;
    }

    public void r(int i2, K.p pVar) {
        io.flutter.plugin.editing.k kVar = (io.flutter.plugin.editing.k) this.f94c;
        kVar.c();
        kVar.f683f = pVar;
        kVar.f682e = new io.flutter.plugin.editing.j(2, i2);
        kVar.f685h.e(kVar);
        K.o oVar = pVar.f290j;
        kVar.f685h = new io.flutter.plugin.editing.f(oVar != null ? (K.r) oVar.f280d : null, kVar.f678a);
        kVar.d(pVar);
        kVar.f686i = true;
        if (kVar.f682e.f676a == 3) {
            kVar.f692p = false;
        }
        kVar.m = null;
        kVar.f685h.a(kVar);
    }

    public void s(int i2, int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalStateException("Trying to set unknown direction value: " + i3 + "(view id: " + i2 + ")");
        }
        io.flutter.plugin.platform.k kVar = (io.flutter.plugin.platform.k) this.f94c;
        if (kVar.d(i2)) {
            ((io.flutter.plugin.platform.q) kVar.f725h.get(Integer.valueOf(i2))).getClass();
            Log.e("PlatformViewsController", "Setting direction to a null view with id: " + i2);
            return;
        }
        if (kVar.f727j.get(i2) != null) {
            throw new ClassCastException();
        }
        Log.e("PlatformViewsController", "Setting direction to an unknown view with id: " + i2);
    }

    public void t(double d2, double d3, double[] dArr) {
        io.flutter.plugin.editing.k kVar = (io.flutter.plugin.editing.k) this.f94c;
        kVar.getClass();
        double[] dArr2 = new double[4];
        boolean z2 = dArr[3] == 0.0d && dArr[7] == 0.0d && dArr[15] == 1.0d;
        double d4 = dArr[12];
        double d5 = dArr[15];
        double d6 = d4 / d5;
        dArr2[1] = d6;
        dArr2[0] = d6;
        double d7 = dArr[13] / d5;
        dArr2[3] = d7;
        dArr2[2] = d7;
        io.flutter.plugin.editing.i iVar = new io.flutter.plugin.editing.i(z2, dArr, dArr2);
        iVar.a(d2, 0.0d);
        iVar.a(d2, d3);
        iVar.a(0.0d, d3);
        double d8 = kVar.f678a.getContext().getResources().getDisplayMetrics().density;
        kVar.m = new Rect((int) (dArr2[0] * d8), (int) (dArr2[2] * d8), (int) Math.ceil(dArr2[1] * d8), (int) Math.ceil(dArr2[3] * d8));
    }

    public void u(K.r rVar) {
        K.r rVar2;
        int i2;
        int i3;
        io.flutter.plugin.editing.k kVar = (io.flutter.plugin.editing.k) this.f94c;
        View view = kVar.f678a;
        if (!kVar.f686i && (rVar2 = kVar.f691o) != null && (i2 = rVar2.f299d) >= 0 && (i3 = rVar2.f300e) > i2) {
            int i4 = i3 - i2;
            int i5 = rVar.f300e;
            int i6 = rVar.f299d;
            boolean z2 = true;
            if (i4 == i5 - i6) {
                int i7 = 0;
                while (true) {
                    if (i7 >= i4) {
                        z2 = false;
                        break;
                    } else if (rVar2.f296a.charAt(i7 + i2) != rVar.f296a.charAt(i7 + i6)) {
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            kVar.f686i = z2;
        }
        kVar.f691o = rVar;
        kVar.f685h.f(rVar);
        if (kVar.f686i) {
            kVar.f679b.restartInput(view);
            kVar.f686i = false;
        }
    }

    public void v(ArrayList arrayList) {
        io.flutter.plugin.platform.e eVar = (io.flutter.plugin.platform.e) this.f94c;
        eVar.getClass();
        int i2 = arrayList.size() == 0 ? 5894 : 1798;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            int ordinal = ((K.g) arrayList.get(i3)).ordinal();
            if (ordinal == 0) {
                i2 &= -5;
            } else if (ordinal == 1) {
                i2 &= -515;
            }
        }
        eVar.f703e = i2;
        eVar.b();
    }

    public void w(int i2) {
        View decorView = ((io.flutter.plugin.platform.e) this.f94c).f699a.getWindow().getDecorView();
        int a2 = n.e.a(i2);
        if (a2 == 0) {
            decorView.performHapticFeedback(0);
            return;
        }
        if (a2 == 1) {
            decorView.performHapticFeedback(1);
            return;
        }
        if (a2 == 2) {
            decorView.performHapticFeedback(3);
            return;
        }
        if (a2 != 3) {
            if (a2 != 4) {
                return;
            }
            decorView.performHapticFeedback(4);
        } else if (Build.VERSION.SDK_INT >= 23) {
            decorView.performHapticFeedback(6);
        }
    }

    public v() {
        this.f93b = 4;
        Looper mainLooper = Looper.getMainLooper();
        this.f94c = Build.VERSION.SDK_INT >= 28 ? Handler.createAsync(mainLooper) : new Handler(mainLooper);
    }

    public v(F.b bVar, int i2) {
        this.f93b = i2;
        switch (i2) {
            case 14:
                new B.e(bVar, "flutter/platform_views_2", L.m.f311a).k(new v(13, this));
                break;
            case 15:
                new B.e(bVar, "flutter/platform_views", L.m.f311a).k(new v(12, this));
                break;
            case 19:
                new B.e(bVar, "flutter/scribe", L.g.f307b).k(new v(18, this));
                break;
            case 21:
                new B.e(bVar, "flutter/spellcheck", L.m.f311a).k(new v(20, this));
                break;
            default:
                new B.e(bVar, "flutter/mousecursor", L.m.f311a).k(new v(9, this));
                break;
        }
    }

    public v(L.e eVar) {
        this.f93b = 7;
        new B.e(eVar, "flutter/keyboard", L.m.f311a).k(new B.a(this));
    }
}
