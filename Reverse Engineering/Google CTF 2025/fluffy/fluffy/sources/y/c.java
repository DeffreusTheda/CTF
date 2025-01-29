package y;

import Z.l;
import androidx.window.sidecar.SidecarDisplayFeature;

/* loaded from: classes.dex */
public final class c extends a0.i implements l {

    /* renamed from: c, reason: collision with root package name */
    public static final c f1225c = new c(1);

    @Override // Z.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Boolean h(SidecarDisplayFeature sidecarDisplayFeature) {
        a0.h.e(sidecarDisplayFeature, "$this$require");
        return Boolean.valueOf((sidecarDisplayFeature.getRect().width() == 0 && sidecarDisplayFeature.getRect().height() == 0) ? false : true);
    }
}
