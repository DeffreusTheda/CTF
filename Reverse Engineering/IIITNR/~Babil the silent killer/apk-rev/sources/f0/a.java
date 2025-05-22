package f0;

import kotlin.jvm.internal.i;

/* loaded from: classes.dex */
public class a extends e0.a {

    /* renamed from: f0.a$a, reason: collision with other inner class name */
    private static final class C0008a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0008a f166a = new C0008a();

        /* renamed from: b, reason: collision with root package name */
        public static final Integer f167b;

        /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
        static {
            /*
                f0.a$a r0 = new f0.a$a
                r0.<init>()
                f0.a.C0008a.f166a = r0
                r0 = 0
                java.lang.String r1 = "android.os.Build$VERSION"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L1f
                java.lang.String r2 = "SDK_INT"
                java.lang.reflect.Field r1 = r1.getField(r2)     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L1f
                boolean r2 = r1 instanceof java.lang.Integer     // Catch: java.lang.Throwable -> L1f
                if (r2 == 0) goto L1f
                java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L1f
                goto L20
            L1f:
                r1 = r0
            L20:
                if (r1 == 0) goto L2e
                int r2 = r1.intValue()
                if (r2 <= 0) goto L2a
                r2 = 1
                goto L2b
            L2a:
                r2 = 0
            L2b:
                if (r2 == 0) goto L2e
                r0 = r1
            L2e:
                f0.a.C0008a.f167b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: f0.a.C0008a.<clinit>():void");
        }

        private C0008a() {
        }
    }

    private final boolean c(int i2) {
        Integer num = C0008a.f167b;
        return num == null || num.intValue() >= i2;
    }

    @Override // e0.a
    public void a(Throwable cause, Throwable exception) {
        i.e(cause, "cause");
        i.e(exception, "exception");
        if (c(19)) {
            return;
        }
        super.a(cause, exception);
    }
}
