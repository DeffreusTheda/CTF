package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import q.AbstractC0086b;
import q.C0087c;
import q.InterfaceC0088d;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(AbstractC0086b abstractC0086b) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        InterfaceC0088d interfaceC0088d = remoteActionCompat.f380a;
        if (abstractC0086b.e(1)) {
            interfaceC0088d = abstractC0086b.g();
        }
        remoteActionCompat.f380a = (IconCompat) interfaceC0088d;
        CharSequence charSequence = remoteActionCompat.f381b;
        if (abstractC0086b.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((C0087c) abstractC0086b).f1139e);
        }
        remoteActionCompat.f381b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f382c;
        if (abstractC0086b.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((C0087c) abstractC0086b).f1139e);
        }
        remoteActionCompat.f382c = charSequence2;
        remoteActionCompat.f383d = (PendingIntent) abstractC0086b.f(remoteActionCompat.f383d, 4);
        boolean z2 = remoteActionCompat.f384e;
        if (abstractC0086b.e(5)) {
            z2 = ((C0087c) abstractC0086b).f1139e.readInt() != 0;
        }
        remoteActionCompat.f384e = z2;
        boolean z3 = remoteActionCompat.f385f;
        if (abstractC0086b.e(6)) {
            z3 = ((C0087c) abstractC0086b).f1139e.readInt() != 0;
        }
        remoteActionCompat.f385f = z3;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, AbstractC0086b abstractC0086b) {
        abstractC0086b.getClass();
        IconCompat iconCompat = remoteActionCompat.f380a;
        abstractC0086b.h(1);
        abstractC0086b.i(iconCompat);
        CharSequence charSequence = remoteActionCompat.f381b;
        abstractC0086b.h(2);
        Parcel parcel = ((C0087c) abstractC0086b).f1139e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f382c;
        abstractC0086b.h(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        PendingIntent pendingIntent = remoteActionCompat.f383d;
        abstractC0086b.h(4);
        parcel.writeParcelable(pendingIntent, 0);
        boolean z2 = remoteActionCompat.f384e;
        abstractC0086b.h(5);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = remoteActionCompat.f385f;
        abstractC0086b.h(6);
        parcel.writeInt(z3 ? 1 : 0);
    }
}
