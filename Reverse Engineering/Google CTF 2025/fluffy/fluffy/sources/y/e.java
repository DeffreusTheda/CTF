package y;

import Z.l;
import androidx.window.sidecar.SidecarDisplayFeature;

/* loaded from: classes.dex */
public final class e extends a0.i implements l {

    /* renamed from: c, reason: collision with root package name */
    public static final e f1227c = new e(1);

    @Override // Z.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Boolean h(SidecarDisplayFeature sidecarDisplayFeature) {
        a0.h.e(sidecarDisplayFeature, "$this$require");
        return Boolean.valueOf(sidecarDisplayFeature.getRect().left == 0 || sidecarDisplayFeature.getRect().top == 0);
    }
}
