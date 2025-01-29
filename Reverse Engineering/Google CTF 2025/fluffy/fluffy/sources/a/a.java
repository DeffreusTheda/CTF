package a;

import E.c;
import P.b;
import S.f;
import S.g;
import S.i;
import S.j;
import a0.d;
import a0.e;
import a0.h;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowMetrics;
import f.AbstractFutureC0036g;
import f.C0032c;
import f.C0035f;
import h0.AbstractC0056p;
import io.flutter.plugins.GeneratedPluginRegistrant;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l.C0074h;
import l.C0076j;
import l.C0077k;
import l.s;
import org.json.JSONArray;
import org.json.JSONObject;
import v.m;
import v.n;
import v.o;
import z.C0105a;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static long f356a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f357b;

    /* renamed from: c, reason: collision with root package name */
    public static Method f358c;

    /* renamed from: d, reason: collision with root package name */
    public static Method f359d;

    public static Object A(Object obj) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject)) {
            return obj;
        }
        if (obj.equals(JSONObject.NULL)) {
            return obj;
        }
        if (obj instanceof Collection) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                jSONArray.put(A(it.next()));
            }
            return jSONArray;
        }
        if (obj.getClass().isArray()) {
            JSONArray jSONArray2 = new JSONArray();
            int length = Array.getLength(obj);
            for (int i2 = 0; i2 < length; i2++) {
                jSONArray2.put(A(Array.get(obj, i2)));
            }
            return jSONArray2;
        }
        if (obj instanceof Map) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                jSONObject.put((String) entry.getKey(), A(entry.getValue()));
            }
            return jSONObject;
        }
        if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof String)) {
            if (obj.getClass().getPackage().getName().startsWith("java.")) {
                return obj.toString();
            }
            return null;
        }
        return obj;
    }

    public static void a(Throwable th, Throwable th2) {
        h.e(th, "<this>");
        h.e(th2, "exception");
        if (th != th2) {
            Integer num = W.a.f354a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = V.a.f353a;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    public static void b(Context context, b bVar) {
        Rect rect;
        s b2;
        Object systemService;
        WindowMetrics maximumWindowMetrics;
        Activity i2 = i(context);
        if (i2 != null) {
            int i3 = m.f1207a;
            n.f1208a.getClass();
            int i4 = o.f1209b;
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 30) {
                systemService = i2.getSystemService((Class<Object>) WindowManager.class);
                maximumWindowMetrics = ((WindowManager) systemService).getMaximumWindowMetrics();
                rect = maximumWindowMetrics.getBounds();
                h.d(rect, "wm.maximumWindowMetrics.bounds");
            } else {
                Object systemService2 = i2.getSystemService("window");
                h.c(systemService2, "null cannot be cast to non-null type android.view.WindowManager");
                Display defaultDisplay = ((WindowManager) systemService2).getDefaultDisplay();
                h.d(defaultDisplay, "display");
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                rect = new Rect(0, 0, point.x, point.y);
            }
            if (i5 < 30) {
                b2 = (i5 >= 30 ? new C0077k() : i5 >= 29 ? new C0076j() : new C0074h()).b();
                h.d(b2, "{\n            WindowInse…ilder().build()\n        }");
            } else {
                if (i5 < 30) {
                    throw new Exception("Incompatible SDK version");
                }
                b2 = C0105a.f1243a.a(i2);
            }
            int i6 = rect.left;
            int i7 = rect.top;
            int i8 = rect.right;
            int i9 = rect.bottom;
            if (i6 > i8) {
                throw new IllegalArgumentException(("Left must be less than or equal to right, left: " + i6 + ", right: " + i8).toString());
            }
            if (i7 <= i9) {
                h.e(b2, "_windowInsetsCompat");
                ((c) bVar).f125a.updateDisplayMetrics(0, new Rect(i6, i7, i8, i9).width(), new Rect(i6, i7, i8, i9).height(), context.getResources().getDisplayMetrics().density);
            } else {
                throw new IllegalArgumentException(("top must be less than or equal to bottom, top: " + i7 + ", bottom: " + i9).toString());
            }
        }
    }

    public static final Q.c f(Throwable th) {
        h.e(th, "exception");
        return new Q.c(th);
    }

    public static boolean g(Method method, e eVar) {
        Class a2 = eVar.a();
        h.c(a2, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return method.getReturnType().equals(a2);
    }

    public static g h(g gVar, S.h hVar) {
        h.e(hVar, "key");
        if (h.a(gVar.getKey(), hVar)) {
            return gVar;
        }
        return null;
    }

    public static Activity i(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return i(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static String j(Context context) {
        File dataDir;
        if (Build.VERSION.SDK_INT < 24) {
            return context.getApplicationInfo().dataDir;
        }
        dataDir = context.getDataDir();
        return dataDir.getPath();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final Class k(e0.b bVar) {
        h.e(bVar, "<this>");
        Class a2 = ((d) bVar).a();
        if (!a2.isPrimitive()) {
            return a2;
        }
        String name = a2.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (!name.equals("double")) {
                }
                break;
            case 104431:
                if (!name.equals("int")) {
                }
                break;
            case 3039496:
                if (!name.equals("byte")) {
                }
                break;
            case 3052374:
                if (!name.equals("char")) {
                }
                break;
            case 3327612:
                if (!name.equals("long")) {
                }
                break;
            case 3625364:
                if (!name.equals("void")) {
                }
                break;
            case 64711720:
                if (!name.equals("boolean")) {
                }
                break;
            case 97526364:
                if (!name.equals("float")) {
                }
                break;
            case 109413500:
                if (!name.equals("short")) {
                }
                break;
        }
        return a2;
    }

    public static void l(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static S.d m(S.d dVar) {
        h.e(dVar, "<this>");
        U.b bVar = dVar instanceof U.b ? (U.b) dVar : null;
        if (bVar == null) {
            return dVar;
        }
        S.d dVar2 = bVar.f349d;
        if (dVar2 != null) {
            return dVar2;
        }
        i iVar = bVar.f348c;
        h.b(iVar);
        f fVar = (f) iVar.f(S.e.f342b);
        S.d hVar = fVar != null ? new m0.h((AbstractC0056p) fVar, bVar) : bVar;
        bVar.f349d = hVar;
        return hVar;
    }

    public static List n(Object obj) {
        List singletonList = Collections.singletonList(obj);
        h.d(singletonList, "singletonList(...)");
        return singletonList;
    }

    public static int o(int i2) {
        if (i2 < 0) {
            return i2;
        }
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((i2 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static i p(g gVar, S.h hVar) {
        h.e(hVar, "key");
        return h.a(gVar.getKey(), hVar) ? j.f343b : gVar;
    }

    public static i q(g gVar, i iVar) {
        h.e(iVar, "context");
        return r(gVar, iVar);
    }

    public static i r(i iVar, i iVar2) {
        h.e(iVar2, "context");
        return iVar2 == j.f343b ? iVar : (i) iVar2.h(iVar, new S.b(1));
    }

    public static void u(c cVar) {
        try {
            GeneratedPluginRegistrant.class.getDeclaredMethod("registerWith", c.class).invoke(null, cVar);
        } catch (Exception e2) {
            Log.e("GeneratedPluginsRegister", "Tried to automatically register plugins with FlutterEngine (" + cVar + ") but could not find or invoke the GeneratedPluginRegistrant.");
            Log.e("GeneratedPluginsRegister", "Received exception while registering", e2);
        }
    }

    public static final void x(Object obj) {
        if (obj instanceof Q.c) {
            throw ((Q.c) obj).f322b;
        }
    }

    public static String y(String str) {
        return str.length() <= 127 ? str : str.substring(0, 127);
    }

    public static final boolean z(String str, Z.a aVar) {
        try {
            boolean booleanValue = ((Boolean) aVar.a()).booleanValue();
            if (!booleanValue && str != null) {
                Log.e("ReflectionGuard", str);
            }
            return booleanValue;
        } catch (ClassNotFoundException unused) {
            if (str == null) {
                str = "";
            }
            Log.e("ReflectionGuard", "ClassNotFound: ".concat(str));
            return false;
        } catch (NoSuchMethodException unused2) {
            if (str == null) {
                str = "";
            }
            Log.e("ReflectionGuard", "NoSuchMethod: ".concat(str));
            return false;
        }
    }

    public abstract boolean c(AbstractFutureC0036g abstractFutureC0036g, C0032c c0032c);

    public abstract boolean d(AbstractFutureC0036g abstractFutureC0036g, Object obj, Object obj2);

    public abstract boolean e(AbstractFutureC0036g abstractFutureC0036g, C0035f c0035f, C0035f c0035f2);

    public abstract void s(C0035f c0035f, C0035f c0035f2);

    public abstract void t(C0035f c0035f, Thread thread);

    public void v(boolean z2) {
    }

    public void w(boolean z2) {
    }
}
