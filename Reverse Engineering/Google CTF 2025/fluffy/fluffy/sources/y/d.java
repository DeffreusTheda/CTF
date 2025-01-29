package y;

import Z.l;
import androidx.window.sidecar.SidecarDisplayFeature;

/* loaded from: classes.dex */
public final class d extends a0.i implements l {

    /* renamed from: c, reason: collision with root package name */
    public static final d f1226c = new d(1);

    @Override // Z.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Boolean h(SidecarDisplayFeature sidecarDisplayFeature) {
        a0.h.e(sidecarDisplayFeature, "$this$require");
        boolean z2 = true;
        if (sidecarDisplayFeature.getType() == 1 && sidecarDisplayFeature.getRect().width() != 0 && sidecarDisplayFeature.getRect().height() != 0) {
            z2 = false;
        }
        return Boolean.valueOf(z2);
    }
}
