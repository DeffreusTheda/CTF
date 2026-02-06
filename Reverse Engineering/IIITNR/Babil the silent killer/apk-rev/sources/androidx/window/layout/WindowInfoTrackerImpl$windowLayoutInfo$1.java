package androidx.window.layout;

import a0.q;
import android.app.Activity;
import j0.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.k;
import kotlin.jvm.internal.i;

@f(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", l = {54, 55}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class WindowInfoTrackerImpl$windowLayoutInfo$1 extends k implements p<t0.c<? super WindowLayoutInfo>, c0.d<? super q>, Object> {
    final /* synthetic */ Activity $activity;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ WindowInfoTrackerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowInfoTrackerImpl$windowLayoutInfo$1(WindowInfoTrackerImpl windowInfoTrackerImpl, Activity activity, c0.d<? super WindowInfoTrackerImpl$windowLayoutInfo$1> dVar) {
        super(2, dVar);
        this.this$0 = windowInfoTrackerImpl;
        this.$activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0, reason: not valid java name */
    public static final void m7invokeSuspend$lambda0(s0.f fVar, WindowLayoutInfo info) {
        i.d(info, "info");
        fVar.a(info);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final c0.d<q> create(Object obj, c0.d<?> dVar) {
        WindowInfoTrackerImpl$windowLayoutInfo$1 windowInfoTrackerImpl$windowLayoutInfo$1 = new WindowInfoTrackerImpl$windowLayoutInfo$1(this.this$0, this.$activity, dVar);
        windowInfoTrackerImpl$windowLayoutInfo$1.L$0 = obj;
        return windowInfoTrackerImpl$windowLayoutInfo$1;
    }

    @Override // j0.p
    public final Object invoke(t0.c<? super WindowLayoutInfo> cVar, c0.d<? super q> dVar) {
        return ((WindowInfoTrackerImpl$windowLayoutInfo$1) create(cVar, dVar)).invokeSuspend(q.f22a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007b A[Catch: all -> 0x009e, TRY_LEAVE, TryCatch #1 {all -> 0x009e, blocks: (B:11:0x0061, B:16:0x0073, B:18:0x007b), top: B:10:0x0061 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0092  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0090 -> B:10:0x0061). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = d0.b.c()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L39
            if (r1 == r3) goto L27
            if (r1 != r2) goto L1f
            java.lang.Object r1 = r9.L$2
            s0.g r1 = (s0.g) r1
            java.lang.Object r4 = r9.L$1
            e.a r4 = (e.a) r4
            java.lang.Object r5 = r9.L$0
            t0.c r5 = (t0.c) r5
            a0.l.b(r10)     // Catch: java.lang.Throwable -> La0
            r10 = r5
            goto L60
        L1f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L27:
            java.lang.Object r1 = r9.L$2
            s0.g r1 = (s0.g) r1
            java.lang.Object r4 = r9.L$1
            e.a r4 = (e.a) r4
            java.lang.Object r5 = r9.L$0
            t0.c r5 = (t0.c) r5
            a0.l.b(r10)     // Catch: java.lang.Throwable -> La0
            r6 = r5
            r5 = r9
            goto L73
        L39:
            a0.l.b(r10)
            java.lang.Object r10 = r9.L$0
            t0.c r10 = (t0.c) r10
            r1 = 10
            s0.e r4 = s0.e.DROP_OLDEST
            r5 = 4
            r6 = 0
            s0.f r1 = s0.h.b(r1, r4, r6, r5, r6)
            androidx.window.layout.c r4 = new androidx.window.layout.c
            r4.<init>()
            androidx.window.layout.WindowInfoTrackerImpl r5 = r9.this$0
            androidx.window.layout.WindowBackend r5 = androidx.window.layout.WindowInfoTrackerImpl.access$getWindowBackend$p(r5)
            android.app.Activity r6 = r9.$activity
            androidx.window.layout.d r7 = new java.util.concurrent.Executor() { // from class: androidx.window.layout.d
                static {
                    /*
                        androidx.window.layout.d r0 = new androidx.window.layout.d
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.window.layout.d) androidx.window.layout.d.d androidx.window.layout.d
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.d.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.d.<init>():void");
                }

                @Override // java.util.concurrent.Executor
                public final void execute(java.lang.Runnable r1) {
                    /*
                        r0 = this;
                        r1.run()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.d.execute(java.lang.Runnable):void");
                }
            }
            r5.registerLayoutChangeCallback(r6, r7, r4)
            s0.g r1 = r1.iterator()     // Catch: java.lang.Throwable -> La0
        L60:
            r5 = r9
        L61:
            r5.L$0 = r10     // Catch: java.lang.Throwable -> L9e
            r5.L$1 = r4     // Catch: java.lang.Throwable -> L9e
            r5.L$2 = r1     // Catch: java.lang.Throwable -> L9e
            r5.label = r3     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r6 = r1.a(r5)     // Catch: java.lang.Throwable -> L9e
            if (r6 != r0) goto L70
            return r0
        L70:
            r8 = r6
            r6 = r10
            r10 = r8
        L73:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L9e
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L9e
            if (r10 == 0) goto L92
            java.lang.Object r10 = r1.next()     // Catch: java.lang.Throwable -> L9e
            androidx.window.layout.WindowLayoutInfo r10 = (androidx.window.layout.WindowLayoutInfo) r10     // Catch: java.lang.Throwable -> L9e
            r5.L$0 = r6     // Catch: java.lang.Throwable -> L9e
            r5.L$1 = r4     // Catch: java.lang.Throwable -> L9e
            r5.L$2 = r1     // Catch: java.lang.Throwable -> L9e
            r5.label = r2     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r10 = r6.emit(r10, r5)     // Catch: java.lang.Throwable -> L9e
            if (r10 != r0) goto L90
            return r0
        L90:
            r10 = r6
            goto L61
        L92:
            androidx.window.layout.WindowInfoTrackerImpl r10 = r5.this$0
            androidx.window.layout.WindowBackend r10 = androidx.window.layout.WindowInfoTrackerImpl.access$getWindowBackend$p(r10)
            r10.unregisterLayoutChangeCallback(r4)
            a0.q r10 = a0.q.f22a
            return r10
        L9e:
            r10 = move-exception
            goto La2
        La0:
            r10 = move-exception
            r5 = r9
        La2:
            androidx.window.layout.WindowInfoTrackerImpl r0 = r5.this$0
            androidx.window.layout.WindowBackend r0 = androidx.window.layout.WindowInfoTrackerImpl.access$getWindowBackend$p(r0)
            r0.unregisterLayoutChangeCallback(r4)
            goto Lad
        Lac:
            throw r10
        Lad:
            goto Lac
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
