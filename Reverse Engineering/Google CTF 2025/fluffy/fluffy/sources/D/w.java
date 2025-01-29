package D;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import io.flutter.embedding.engine.FlutterJNI;

/* loaded from: classes.dex */
public final class w extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f95a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f96b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(Object obj, Handler handler, int i2) {
        super(handler);
        this.f95a = i2;
        this.f96b = obj;
    }

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        switch (this.f95a) {
            case 0:
                return true;
            default:
                return super.deliverSelfNotifications();
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z2, Uri uri) {
        switch (this.f95a) {
            case 1:
                io.flutter.view.l lVar = (io.flutter.view.l) this.f96b;
                if (!lVar.f848t) {
                    if (Settings.Global.getFloat(lVar.f835f, "transition_animation_scale", 1.0f) == 0.0f) {
                        lVar.f840k |= 4;
                    } else {
                        lVar.f840k &= -5;
                    }
                    ((FlutterJNI) lVar.f831b.f9b).setAccessibilityFeatures(lVar.f840k);
                    break;
                }
                break;
            default:
                super.onChange(z2, uri);
                break;
        }
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z2) {
        switch (this.f95a) {
            case 0:
                super.onChange(z2);
                y yVar = (y) this.f96b;
                if (yVar.f107h != null) {
                    yVar.d();
                    break;
                }
                break;
            default:
                onChange(z2, null);
                break;
        }
    }
}
