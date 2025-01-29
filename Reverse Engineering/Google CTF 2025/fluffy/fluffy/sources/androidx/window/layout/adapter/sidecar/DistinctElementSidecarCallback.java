package androidx.window.layout.adapter.sidecar;

import android.os.IBinder;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.util.WeakHashMap;
import y.f;

/* loaded from: classes.dex */
public class DistinctElementSidecarCallback implements SidecarInterface.SidecarCallback {

    /* renamed from: b, reason: collision with root package name */
    public SidecarDeviceState f433b;

    /* renamed from: d, reason: collision with root package name */
    public final f f435d;

    /* renamed from: e, reason: collision with root package name */
    public final SidecarInterface.SidecarCallback f436e;

    /* renamed from: a, reason: collision with root package name */
    public final Object f432a = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final WeakHashMap f434c = new WeakHashMap();

    public DistinctElementSidecarCallback(f fVar, SidecarInterface.SidecarCallback sidecarCallback) {
        this.f435d = fVar;
        this.f436e = sidecarCallback;
    }

    public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
        if (sidecarDeviceState == null) {
            return;
        }
        synchronized (this.f432a) {
            try {
                f fVar = this.f435d;
                SidecarDeviceState sidecarDeviceState2 = this.f433b;
                fVar.getClass();
                if (f.a(sidecarDeviceState2, sidecarDeviceState)) {
                    return;
                }
                this.f433b = sidecarDeviceState;
                this.f436e.onDeviceStateChanged(sidecarDeviceState);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
        synchronized (this.f432a) {
            try {
                SidecarWindowLayoutInfo sidecarWindowLayoutInfo2 = (SidecarWindowLayoutInfo) this.f434c.get(iBinder);
                this.f435d.getClass();
                if (f.d(sidecarWindowLayoutInfo2, sidecarWindowLayoutInfo)) {
                    return;
                }
                this.f434c.put(iBinder, sidecarWindowLayoutInfo);
                this.f436e.onWindowLayoutChanged(iBinder, sidecarWindowLayoutInfo);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
