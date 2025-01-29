package y;

import B.e;
import R.m;
import a0.h;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.IBinder;
import android.util.Log;
import androidx.window.layout.adapter.sidecar.DistinctElementSidecarCallback;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import k.InterfaceC0066a;
import v.k;
import y.f;
import y.g;
import y.i;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final SidecarInterface f1231a;

    /* renamed from: b, reason: collision with root package name */
    public final f f1232b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f1233c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f1234d;

    /* renamed from: e, reason: collision with root package name */
    public B.e f1235e;

    public i(Context context) {
        a0.h.e(context, "context");
        SidecarInterface b2 = g.b(context);
        f fVar = new f();
        this.f1231a = b2;
        this.f1232b = fVar;
        this.f1233c = new LinkedHashMap();
        this.f1234d = new LinkedHashMap();
    }

    public final SidecarInterface d() {
        return this.f1231a;
    }

    public final v.k e(Activity activity) {
        SidecarDeviceState sidecarDeviceState;
        IBinder a2 = g.a(activity);
        if (a2 == null) {
            return new v.k(m.f335b);
        }
        SidecarInterface sidecarInterface = this.f1231a;
        SidecarWindowLayoutInfo windowLayoutInfo = sidecarInterface != null ? sidecarInterface.getWindowLayoutInfo(a2) : null;
        SidecarInterface sidecarInterface2 = this.f1231a;
        if (sidecarInterface2 == null || (sidecarDeviceState = sidecarInterface2.getDeviceState()) == null) {
            sidecarDeviceState = new SidecarDeviceState();
        }
        return this.f1232b.f(windowLayoutInfo, sidecarDeviceState);
    }

    public final void f(Activity activity) {
        SidecarInterface sidecarInterface;
        IBinder a2 = g.a(activity);
        if (a2 == null) {
            return;
        }
        SidecarInterface sidecarInterface2 = this.f1231a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerRemoved(a2);
        }
        LinkedHashMap linkedHashMap = this.f1234d;
        if (((InterfaceC0066a) linkedHashMap.get(activity)) != null) {
            linkedHashMap.remove(activity);
        }
        B.e eVar = this.f1235e;
        if (eVar != null) {
            eVar.a(activity);
        }
        LinkedHashMap linkedHashMap2 = this.f1233c;
        boolean z2 = linkedHashMap2.size() == 1;
        linkedHashMap2.remove(a2);
        if (!z2 || (sidecarInterface = this.f1231a) == null) {
            return;
        }
        sidecarInterface.onDeviceStateListenersChanged(true);
    }

    public final void g(IBinder iBinder, Activity activity) {
        SidecarInterface sidecarInterface;
        LinkedHashMap linkedHashMap = this.f1233c;
        linkedHashMap.put(iBinder, activity);
        SidecarInterface sidecarInterface2 = this.f1231a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(iBinder);
        }
        if (linkedHashMap.size() == 1 && (sidecarInterface = this.f1231a) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        B.e eVar = this.f1235e;
        if (eVar != null) {
            eVar.i(activity, e(activity));
        }
        this.f1234d.get(activity);
    }

    public final void h(io.flutter.plugin.platform.i iVar) {
        this.f1235e = new B.e(iVar);
        SidecarInterface sidecarInterface = this.f1231a;
        if (sidecarInterface != null) {
            sidecarInterface.setSidecarCallback(new DistinctElementSidecarCallback(this.f1232b, new SidecarInterface.SidecarCallback() { // from class: androidx.window.layout.adapter.sidecar.SidecarCompat$TranslatingCallback
                public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
                    LinkedHashMap linkedHashMap;
                    e eVar;
                    f fVar;
                    SidecarInterface d2;
                    h.e(sidecarDeviceState, "newDeviceState");
                    linkedHashMap = i.this.f1233c;
                    Collection<Activity> values = linkedHashMap.values();
                    i iVar2 = i.this;
                    for (Activity activity : values) {
                        IBinder a2 = g.a(activity);
                        SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
                        if (a2 != null && (d2 = iVar2.d()) != null) {
                            sidecarWindowLayoutInfo = d2.getWindowLayoutInfo(a2);
                        }
                        eVar = iVar2.f1235e;
                        if (eVar != null) {
                            fVar = iVar2.f1232b;
                            eVar.i(activity, fVar.f(sidecarWindowLayoutInfo, sidecarDeviceState));
                        }
                    }
                }

                public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
                    LinkedHashMap linkedHashMap;
                    f fVar;
                    SidecarDeviceState sidecarDeviceState;
                    e eVar;
                    h.e(iBinder, "windowToken");
                    h.e(sidecarWindowLayoutInfo, "newLayout");
                    linkedHashMap = i.this.f1233c;
                    Activity activity = (Activity) linkedHashMap.get(iBinder);
                    if (activity == null) {
                        Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                        return;
                    }
                    fVar = i.this.f1232b;
                    SidecarInterface d2 = i.this.d();
                    if (d2 == null || (sidecarDeviceState = d2.getDeviceState()) == null) {
                        sidecarDeviceState = new SidecarDeviceState();
                    }
                    k f2 = fVar.f(sidecarWindowLayoutInfo, sidecarDeviceState);
                    eVar = i.this.f1235e;
                    if (eVar != null) {
                        eVar.i(activity, f2);
                    }
                }
            }));
        }
    }

    public final boolean i() {
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        Class<?> cls4;
        try {
            SidecarInterface sidecarInterface = this.f1231a;
            Method method = (sidecarInterface == null || (cls4 = sidecarInterface.getClass()) == null) ? null : cls4.getMethod("setSidecarCallback", SidecarInterface.SidecarCallback.class);
            Class<?> returnType = method != null ? method.getReturnType() : null;
            Class cls5 = Void.TYPE;
            if (!a0.h.a(returnType, cls5)) {
                throw new NoSuchMethodException("Illegal return type for 'setSidecarCallback': " + returnType);
            }
            SidecarInterface sidecarInterface2 = this.f1231a;
            if (sidecarInterface2 != null) {
                sidecarInterface2.getDeviceState();
            }
            SidecarInterface sidecarInterface3 = this.f1231a;
            if (sidecarInterface3 != null) {
                sidecarInterface3.onDeviceStateListenersChanged(true);
            }
            SidecarInterface sidecarInterface4 = this.f1231a;
            Method method2 = (sidecarInterface4 == null || (cls3 = sidecarInterface4.getClass()) == null) ? null : cls3.getMethod("getWindowLayoutInfo", IBinder.class);
            Class<?> returnType2 = method2 != null ? method2.getReturnType() : null;
            if (!a0.h.a(returnType2, SidecarWindowLayoutInfo.class)) {
                throw new NoSuchMethodException("Illegal return type for 'getWindowLayoutInfo': " + returnType2);
            }
            SidecarInterface sidecarInterface5 = this.f1231a;
            Method method3 = (sidecarInterface5 == null || (cls2 = sidecarInterface5.getClass()) == null) ? null : cls2.getMethod("onWindowLayoutChangeListenerAdded", IBinder.class);
            Class<?> returnType3 = method3 != null ? method3.getReturnType() : null;
            if (!a0.h.a(returnType3, cls5)) {
                throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerAdded': " + returnType3);
            }
            SidecarInterface sidecarInterface6 = this.f1231a;
            Method method4 = (sidecarInterface6 == null || (cls = sidecarInterface6.getClass()) == null) ? null : cls.getMethod("onWindowLayoutChangeListenerRemoved", IBinder.class);
            Class<?> returnType4 = method4 != null ? method4.getReturnType() : null;
            if (!a0.h.a(returnType4, cls5)) {
                throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerRemoved': " + returnType4);
            }
            SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
            try {
                sidecarDeviceState.posture = 3;
            } catch (NoSuchFieldError unused) {
                SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, 3);
                Object invoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                a0.h.c(invoke, "null cannot be cast to non-null type kotlin.Int");
                if (((Integer) invoke).intValue() != 3) {
                    throw new Exception("Invalid device posture getter/setter");
                }
            }
            SidecarDisplayFeature sidecarDisplayFeature = new SidecarDisplayFeature();
            Rect rect = sidecarDisplayFeature.getRect();
            a0.h.d(rect, "displayFeature.rect");
            sidecarDisplayFeature.setRect(rect);
            sidecarDisplayFeature.getType();
            sidecarDisplayFeature.setType(1);
            SidecarWindowLayoutInfo sidecarWindowLayoutInfo = new SidecarWindowLayoutInfo();
            try {
                List list = sidecarWindowLayoutInfo.displayFeatures;
            } catch (NoSuchFieldError unused2) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(sidecarDisplayFeature);
                SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", List.class).invoke(sidecarWindowLayoutInfo, arrayList);
                Object invoke2 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(sidecarWindowLayoutInfo, null);
                a0.h.c(invoke2, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                if (!a0.h.a(arrayList, (List) invoke2)) {
                    throw new Exception("Invalid display feature getter/setter");
                }
            }
            return true;
        } catch (Throwable unused3) {
            return false;
        }
    }
}
