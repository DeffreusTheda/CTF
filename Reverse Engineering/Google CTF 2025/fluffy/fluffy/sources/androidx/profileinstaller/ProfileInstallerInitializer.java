package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.profileinstaller.ProfileInstallerInitializer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import n.l;
import o.b;

/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements b {
    @Override // o.b
    public final List a() {
        return Collections.emptyList();
    }

    @Override // o.b
    public final Object b(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new B.b(10);
        }
        final Context applicationContext = context.getApplicationContext();
        l.a(new Runnable() { // from class: n.i
            @Override // java.lang.Runnable
            public final void run() {
                ProfileInstallerInitializer.this.getClass();
                (Build.VERSION.SDK_INT >= 28 ? n.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new j(applicationContext, 0), new Random().nextInt(Math.max(1000, 1)) + 5000);
            }
        });
        return new B.b(10);
    }
}
