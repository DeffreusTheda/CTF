package m;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.WindowManager;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import m.d;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f925a;

    /* renamed from: b, reason: collision with root package name */
    private c f926b;

    /* renamed from: c, reason: collision with root package name */
    private long f927c;

    /* renamed from: d, reason: collision with root package name */
    private m.b f928d;

    /* renamed from: e, reason: collision with root package name */
    private FlutterJNI f929e;

    /* renamed from: f, reason: collision with root package name */
    private ExecutorService f930f;

    /* renamed from: g, reason: collision with root package name */
    Future<b> f931g;

    class a implements Callable<b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f932a;

        a(Context context) {
            this.f932a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            d.this.f929e.prefetchDefaultFontManager();
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b call() {
            z.e.a("FlutterLoader initTask");
            try {
                d.a(d.this, this.f932a);
                d.this.f929e.loadLibrary();
                d.this.f929e.updateRefreshRate();
                d.this.f930f.execute(new Runnable() { // from class: m.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.a.this.c();
                    }
                });
                return new b(z.b.d(this.f932a), z.b.a(this.f932a), z.b.c(this.f932a), null);
            } finally {
                z.e.d();
            }
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        final String f934a;

        /* renamed from: b, reason: collision with root package name */
        final String f935b;

        /* renamed from: c, reason: collision with root package name */
        final String f936c;

        private b(String str, String str2, String str3) {
            this.f934a = str;
            this.f935b = str2;
            this.f936c = str3;
        }

        /* synthetic */ b(String str, String str2, String str3, a aVar) {
            this(str, str2, str3);
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private String f937a;

        public String a() {
            return this.f937a;
        }
    }

    public d() {
        this(j.a.e().d().a());
    }

    public d(FlutterJNI flutterJNI) {
        this(flutterJNI, j.a.e().b());
    }

    public d(FlutterJNI flutterJNI, ExecutorService executorService) {
        this.f925a = false;
        this.f929e = flutterJNI;
        this.f930f = executorService;
    }

    static /* synthetic */ e a(d dVar, Context context) {
        dVar.g(context);
        return null;
    }

    private e g(Context context) {
        return null;
    }

    private static boolean h(Bundle bundle) {
        if (bundle == null) {
            return true;
        }
        return bundle.getBoolean("io.flutter.embedding.android.LeakVM", true);
    }

    public boolean d() {
        return this.f928d.f923g;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0197  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(android.content.Context r10, java.lang.String[] r11) {
        /*
            Method dump skipped, instructions count: 499
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.d.e(android.content.Context, java.lang.String[]):void");
    }

    public String f() {
        return this.f928d.f920d;
    }

    public void i(Context context) {
        j(context, new c());
    }

    public void j(Context context, c cVar) {
        if (this.f926b != null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("startInitialization must be called on the main thread");
        }
        z.e.a("FlutterLoader#startInitialization");
        try {
            Context applicationContext = context.getApplicationContext();
            this.f926b = cVar;
            this.f927c = SystemClock.uptimeMillis();
            this.f928d = m.a.e(applicationContext);
            (Build.VERSION.SDK_INT >= 17 ? io.flutter.view.e.g((DisplayManager) applicationContext.getSystemService("display"), this.f929e) : io.flutter.view.e.f(((WindowManager) applicationContext.getSystemService("window")).getDefaultDisplay().getRefreshRate(), this.f929e)).h();
            this.f931g = this.f930f.submit(new a(applicationContext));
        } finally {
            z.e.d();
        }
    }
}
