package K;

import android.window.BackEvent;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final B.e f223a;

    public b(F.b bVar, int i2) {
        switch (i2) {
            case 1:
                B.b bVar2 = new B.b(7);
                B.e eVar = new B.e(bVar, "flutter/navigation", L.g.f307b);
                this.f223a = eVar;
                eVar.k(bVar2);
                break;
            default:
                B.b bVar3 = new B.b(5);
                B.e eVar2 = new B.e(bVar, "flutter/backgesture", L.m.f311a);
                this.f223a = eVar2;
                eVar2.k(bVar3);
                break;
        }
    }

    public static HashMap a(BackEvent backEvent) {
        float touchX;
        float touchY;
        float progress;
        int swipeEdge;
        HashMap hashMap = new HashMap(3);
        touchX = backEvent.getTouchX();
        touchY = backEvent.getTouchY();
        hashMap.put("touchOffset", (Float.isNaN(touchX) || Float.isNaN(touchY)) ? null : Arrays.asList(Float.valueOf(touchX), Float.valueOf(touchY)));
        progress = backEvent.getProgress();
        hashMap.put("progress", Float.valueOf(progress));
        swipeEdge = backEvent.getSwipeEdge();
        hashMap.put("swipeEdge", Integer.valueOf(swipeEdge));
        return hashMap;
    }
}
