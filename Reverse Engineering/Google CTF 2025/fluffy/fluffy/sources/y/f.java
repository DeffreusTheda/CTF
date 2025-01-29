package y;

import D.AbstractC0009j;
import R.m;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final int f1228a;

    public f() {
        AbstractC0009j.f("verificationMode", 3);
        this.f1228a = 3;
    }

    public static boolean a(SidecarDeviceState sidecarDeviceState, SidecarDeviceState sidecarDeviceState2) {
        if (a0.h.a(sidecarDeviceState, sidecarDeviceState2)) {
            return true;
        }
        return (sidecarDeviceState == null || sidecarDeviceState2 == null || a.b(sidecarDeviceState) != a.b(sidecarDeviceState2)) ? false : true;
    }

    public static boolean b(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (a0.h.a(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return a0.h.a(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    public static boolean c(List list, List list2) {
        if (list == list2) {
            return true;
        }
        if (list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!b((SidecarDisplayFeature) list.get(i2), (SidecarDisplayFeature) list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarWindowLayoutInfo sidecarWindowLayoutInfo2) {
        if (a0.h.a(sidecarWindowLayoutInfo, sidecarWindowLayoutInfo2)) {
            return true;
        }
        if (sidecarWindowLayoutInfo == null || sidecarWindowLayoutInfo2 == null) {
            return false;
        }
        return c(a.c(sidecarWindowLayoutInfo), a.c(sidecarWindowLayoutInfo2));
    }

    public final ArrayList e(List list, SidecarDeviceState sidecarDeviceState) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            v.c g2 = g((SidecarDisplayFeature) it.next(), sidecarDeviceState);
            if (g2 != null) {
                arrayList.add(g2);
            }
        }
        return arrayList;
    }

    public final v.k f(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState sidecarDeviceState) {
        a0.h.e(sidecarDeviceState, "state");
        if (sidecarWindowLayoutInfo == null) {
            return new v.k(m.f335b);
        }
        SidecarDeviceState sidecarDeviceState2 = new SidecarDeviceState();
        a.d(sidecarDeviceState2, a.b(sidecarDeviceState));
        return new v.k(e(a.c(sidecarWindowLayoutInfo), sidecarDeviceState2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
    
        if (r6 == 4) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final v.c g(androidx.window.sidecar.SidecarDisplayFeature r5, androidx.window.sidecar.SidecarDeviceState r6) {
        /*
            r4 = this;
            java.lang.String r0 = "feature"
            a0.h.e(r5, r0)
            int r0 = r4.f1228a
            s.h r0 = s.C0091a.a(r0, r5)
            y.b r1 = y.b.f1224c
            java.lang.String r2 = "Type must be either TYPE_FOLD or TYPE_HINGE"
            s.g r0 = r0.d(r2, r1)
            y.c r1 = y.c.f1225c
            java.lang.String r2 = "Feature bounds must not be 0"
            s.g r0 = r0.d(r2, r1)
            y.d r1 = y.d.f1226c
            java.lang.String r2 = "TYPE_FOLD must have 0 area"
            s.g r0 = r0.d(r2, r1)
            y.e r1 = y.e.f1227c
            java.lang.String r2 = "Feature be pinned to either left or top"
            s.g r0 = r0.d(r2, r1)
            java.lang.Object r0 = r0.a()
            androidx.window.sidecar.SidecarDisplayFeature r0 = (androidx.window.sidecar.SidecarDisplayFeature) r0
            r1 = 0
            if (r0 != 0) goto L35
            return r1
        L35:
            int r0 = r0.getType()
            r2 = 2
            r3 = 1
            if (r0 == r3) goto L43
            if (r0 == r2) goto L40
            return r1
        L40:
            v.b r0 = v.b.f1182i
            goto L45
        L43:
            v.b r0 = v.b.f1181h
        L45:
            int r6 = y.a.b(r6)
            if (r6 == 0) goto L6e
            if (r6 == r3) goto L6e
            if (r6 == r2) goto L58
            v.b r2 = v.b.f1179f
            r3 = 3
            if (r6 == r3) goto L5a
            r3 = 4
            if (r6 == r3) goto L6e
            goto L5a
        L58:
            v.b r2 = v.b.f1180g
        L5a:
            v.c r6 = new v.c
            s.b r1 = new s.b
            android.graphics.Rect r5 = r5.getRect()
            java.lang.String r3 = "feature.rect"
            a0.h.d(r5, r3)
            r1.<init>(r5)
            r6.<init>(r1, r0, r2)
            return r6
        L6e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: y.f.g(androidx.window.sidecar.SidecarDisplayFeature, androidx.window.sidecar.SidecarDeviceState):v.c");
    }
}
