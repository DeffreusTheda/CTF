package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f30a = (IconCompat) aVar.v(remoteActionCompat.f30a, 1);
        remoteActionCompat.f31b = aVar.l(remoteActionCompat.f31b, 2);
        remoteActionCompat.f32c = aVar.l(remoteActionCompat.f32c, 3);
        remoteActionCompat.f33d = (PendingIntent) aVar.r(remoteActionCompat.f33d, 4);
        remoteActionCompat.f34e = aVar.h(remoteActionCompat.f34e, 5);
        remoteActionCompat.f35f = aVar.h(remoteActionCompat.f35f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f30a, 1);
        aVar.D(remoteActionCompat.f31b, 2);
        aVar.D(remoteActionCompat.f32c, 3);
        aVar.H(remoteActionCompat.f33d, 4);
        aVar.z(remoteActionCompat.f34e, 5);
        aVar.z(remoteActionCompat.f35f, 6);
    }
}
