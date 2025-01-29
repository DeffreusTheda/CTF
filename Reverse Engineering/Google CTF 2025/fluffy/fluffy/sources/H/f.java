package H;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Trace;
import android.util.DisplayMetrics;
import android.util.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.u;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public boolean f216a;

    /* renamed from: b, reason: collision with root package name */
    public B.b f217b;

    /* renamed from: c, reason: collision with root package name */
    public long f218c;

    /* renamed from: d, reason: collision with root package name */
    public b f219d;

    /* renamed from: e, reason: collision with root package name */
    public FlutterJNI f220e;

    /* renamed from: f, reason: collision with root package name */
    public ExecutorService f221f;

    /* renamed from: g, reason: collision with root package name */
    public Future f222g;

    public final void a(Context context, String[] strArr) {
        if (this.f216a) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        }
        if (this.f217b == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        try {
            P.a.b("FlutterLoader#ensureInitializationComplete");
            try {
                e eVar = (e) this.f222g.get();
                ArrayList arrayList = new ArrayList();
                arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
                StringBuilder sb = new StringBuilder("--icu-native-lib-path=");
                sb.append(this.f219d.f208d);
                String str = File.separator;
                sb.append(str);
                sb.append("libflutter.so");
                arrayList.add(sb.toString());
                if (strArr != null) {
                    Collections.addAll(arrayList, strArr);
                }
                arrayList.add("--aot-shared-library-name=".concat(this.f219d.f205a));
                arrayList.add("--aot-shared-library-name=" + this.f219d.f208d + str + this.f219d.f205a);
                StringBuilder sb2 = new StringBuilder("--cache-dir-path=");
                sb2.append(eVar.f215b);
                arrayList.add(sb2.toString());
                arrayList.add("--domain-network-policy=".concat(this.f219d.f207c));
                this.f217b.getClass();
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                int i2 = bundle != null ? bundle.getInt("io.flutter.embedding.android.OldGenHeapSize") : 0;
                if (i2 == 0) {
                    ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(new ActivityManager.MemoryInfo());
                    i2 = (int) ((r11.totalMem / 1000000.0d) / 2.0d);
                }
                arrayList.add("--old-gen-heap-size=" + i2);
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                arrayList.add("--resource-cache-max-bytes-threshold=" + (displayMetrics.widthPixels * displayMetrics.heightPixels * 48));
                arrayList.add("--prefetched-default-font-manager");
                if (bundle != null) {
                    if (bundle.containsKey("io.flutter.embedding.android.EnableImpeller")) {
                        if (bundle.getBoolean("io.flutter.embedding.android.EnableImpeller")) {
                            arrayList.add("--enable-impeller=true");
                        } else {
                            arrayList.add("--enable-impeller=false");
                        }
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableVulkanValidation", false)) {
                        arrayList.add("--enable-vulkan-validation");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableOpenGLGPUTracing", false)) {
                        arrayList.add("--enable-opengl-gpu-tracing");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableVulkanGPUTracing", false)) {
                        arrayList.add("--enable-vulkan-gpu-tracing");
                    }
                    if (bundle.containsKey("io.flutter.embedding.android.DisableMergedPlatformUIThread") && bundle.getBoolean("io.flutter.embedding.android.DisableMergedPlatformUIThread")) {
                        arrayList.add("--no-enable-merged-platform-ui-thread");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableSurfaceControl", false)) {
                        arrayList.add("--enable-surface-control");
                    }
                    String string = bundle.getString("io.flutter.embedding.android.ImpellerBackend");
                    if (string != null) {
                        arrayList.add("--impeller-backend=".concat(string));
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.ImpellerLazyShaderInitialization")) {
                        arrayList.add("--impeller-lazy-shader-mode");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.ImpellerAntialiasLines")) {
                        arrayList.add("--impeller-antialias-lines");
                    }
                }
                arrayList.add("--leak-vm=".concat(bundle == null ? true : bundle.getBoolean("io.flutter.embedding.android.LeakVM", true) ? "true" : "false"));
                this.f220e.init(context, (String[]) arrayList.toArray(new String[0]), null, eVar.f214a, eVar.f215b, SystemClock.uptimeMillis() - this.f218c, Build.VERSION.SDK_INT);
                this.f216a = true;
                Trace.endSection();
            } finally {
            }
        } catch (Exception e2) {
            Log.e("FlutterLoader", "Flutter initialization failed.", e2);
            throw new RuntimeException(e2);
        }
    }

    public final void b(Context context) {
        B.b bVar = new B.b(3);
        if (this.f217b != null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("startInitialization must be called on the main thread");
        }
        P.a.b("FlutterLoader#startInitialization");
        try {
            Context applicationContext = context.getApplicationContext();
            this.f217b = bVar;
            this.f218c = SystemClock.uptimeMillis();
            this.f219d = a.a(applicationContext);
            u a2 = u.a((DisplayManager) applicationContext.getSystemService("display"), this.f220e);
            a2.f867b.setAsyncWaitForVsyncDelegate(a2.f869d);
            this.f222g = this.f221f.submit(new d(this, applicationContext));
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
