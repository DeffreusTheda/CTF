package y;

import Z.l;
import androidx.window.sidecar.SidecarDisplayFeature;

/* loaded from: classes.dex */
public final class b extends a0.i implements l {

    /* renamed from: c, reason: collision with root package name */
    public static final b f1224c = new b(1);

    @Override // Z.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Boolean h(SidecarDisplayFeature sidecarDisplayFeature) {
        a0.h.e(sidecarDisplayFeature, "$this$require");
        boolean z2 = true;
        if (sidecarDisplayFeature.getType() != 1 && sidecarDisplayFeature.getType() != 2) {
            z2 = false;
        }
        return Boolean.valueOf(z2);
    }
}
