package io.flutter.plugin.platform;

import D.u;
import android.util.Log;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class i implements n.g, k0.d {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f704b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f705c;

    public /* synthetic */ i(int i2, Object obj) {
        this.f704b = i2;
        this.f705c = obj;
    }

    @Override // n.g
    public void a(int i2, Serializable serializable) {
        String str;
        switch (i2) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i2 == 6 || i2 == 7 || i2 == 8) {
            Log.e("ProfileInstaller", str, (Throwable) serializable);
        } else {
            Log.d("ProfileInstaller", str);
        }
        ((ProfileInstallReceiver) this.f705c).setResultCode(i2);
    }

    @Override // k0.d
    public Object b(Object obj, U.b bVar) {
        ((u) this.f705c).accept(obj);
        return Q.g.f327a;
    }

    public void c(int i2) {
        if (((j) this.f705c).f712g.get(i2) != null) {
            throw new ClassCastException();
        }
        Log.e("PlatformViewsController2", "Disposing unknown platform view with id: " + i2);
    }

    @Override // n.g
    public void d() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    public String toString() {
        switch (this.f704b) {
            case 1:
                return "<" + ((String) this.f705c) + '>';
            default:
                return super.toString();
        }
    }
}
