package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import io.flutter.plugin.platform.i;
import java.io.File;
import n.f;
import n.h;

/* loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        File codeCacheDir;
        Context createDeviceProtectedStorageContext;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            h.s(context, new f(), new i(2, this), true);
            return;
        }
        if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if (!"WRITE_SKIP_FILE".equals(string)) {
                    if ("DELETE_SKIP_FILE".equals(string)) {
                        new File(context.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                        Log.d("ProfileInstaller", "RESULT_DELETE_SKIP_FILE_SUCCESS");
                        setResultCode(11);
                        return;
                    }
                    return;
                }
                i iVar = new i(2, this);
                try {
                    h.e(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                    iVar.a(10, null);
                    return;
                } catch (PackageManager.NameNotFoundException e2) {
                    iVar.a(7, e2);
                    return;
                }
            }
            return;
        }
        if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            i iVar2 = new i(2, this);
            if (Build.VERSION.SDK_INT < 24) {
                iVar2.a(13, null);
                return;
            } else {
                Process.sendSignal(Process.myPid(), 10);
                iVar2.a(12, null);
                return;
            }
        }
        if (!"androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
            return;
        }
        String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
        i iVar3 = new i(2, this);
        if (!"DROP_SHADER_CACHE".equals(string2)) {
            iVar3.a(16, null);
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            codeCacheDir = createDeviceProtectedStorageContext.getCodeCacheDir();
        } else {
            codeCacheDir = i2 >= 23 ? context.getCodeCacheDir() : context.getCacheDir();
        }
        if (h.c(codeCacheDir)) {
            iVar3.a(14, null);
        } else {
            iVar3.a(15, null);
        }
    }
}
