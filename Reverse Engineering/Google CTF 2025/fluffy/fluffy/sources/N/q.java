package n;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import f.AbstractFutureC0036g;
import f.C0037h;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final C0037h f1082a = new C0037h();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f1083b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static B.b f1084c = null;

    public static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? o.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static B.b b() {
        B.b bVar = new B.b(11);
        f1084c = bVar;
        C0037h c0037h = f1082a;
        c0037h.getClass();
        if (AbstractFutureC0036g.f503f.d(c0037h, null, bVar)) {
            AbstractFutureC0036g.b(c0037h);
        }
        return f1084c;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:14|(1:79)(1:18)|19|(1:78)(1:23)|24|25|26|(2:64|65)(1:28)|29|(8:36|(1:40)|(1:59)(1:47)|48|(2:55|56)|52|53|54)|(1:63)|(1:40)|(1:42)|59|48|(1:50)|55|56|52|53|54) */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009d, code lost:
    
        r4 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(android.content.Context r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.q.c(android.content.Context, boolean):void");
    }
}
