package H;

import android.content.Context;
import android.os.Trace;
import io.flutter.embedding.engine.FlutterJNI;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class d implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f212a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f213b;

    public d(f fVar, Context context) {
        this.f213b = fVar;
        this.f212a = context;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str;
        Context context = this.f212a;
        f fVar = this.f213b;
        P.a.b("FlutterLoader initTask");
        try {
            fVar.getClass();
            FlutterJNI flutterJNI = fVar.f220e;
            try {
                flutterJNI.loadLibrary(context);
                flutterJNI.updateRefreshRate();
                fVar.f221f.execute(new c(0, this));
                File filesDir = context.getFilesDir();
                if (filesDir == null) {
                    filesDir = new File(a.a.j(context), "files");
                }
                String path = filesDir.getPath();
                File codeCacheDir = context.getCodeCacheDir();
                if (codeCacheDir == null) {
                    codeCacheDir = context.getCacheDir();
                }
                if (codeCacheDir == null) {
                    codeCacheDir = new File(a.a.j(context), "cache");
                }
                String path2 = codeCacheDir.getPath();
                File dir = context.getDir("flutter", 0);
                if (dir == null) {
                    dir = new File(a.a.j(context), "app_flutter");
                }
                dir.getPath();
                e eVar = new e(path, path2);
                Trace.endSection();
                return eVar;
            } catch (UnsatisfiedLinkError e2) {
                if (!e2.toString().contains("couldn't find \"libflutter.so\"") && !e2.toString().contains("dlopen failed: library \"libflutter.so\" not found")) {
                    throw e2;
                }
                String property = System.getProperty("os.arch");
                File file = new File(fVar.f219d.f208d);
                String[] list = file.list();
                StringBuilder sb = new StringBuilder("Could not load libflutter.so this is possibly because the application is running on an architecture that Flutter Android does not support (e.g. x86) see https://docs.flutter.dev/deployment/android#what-are-the-supported-target-architectures for more detail.\nApp is using cpu architecture: ");
                sb.append(property);
                sb.append(", and the native libraries directory (with path ");
                sb.append(file.getAbsolutePath());
                sb.append(") ");
                if (file.exists()) {
                    str = "contains the following files: " + Arrays.toString(list);
                } else {
                    str = "does not exist.";
                }
                sb.append(str);
                throw new UnsupportedOperationException(sb.toString(), e2);
            }
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
