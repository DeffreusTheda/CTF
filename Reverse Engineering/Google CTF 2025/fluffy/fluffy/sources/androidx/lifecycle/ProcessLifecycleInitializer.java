package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import java.util.List;
import o.C0083a;

/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements o.b {
    @Override // o.b
    public final List a() {
        return R.m.f335b;
    }

    @Override // o.b
    public final Object b(Context context) {
        a0.h.e(context, "context");
        C0083a c2 = C0083a.c(context);
        a0.h.d(c2, "getInstance(context)");
        if (!c2.f1133b.contains(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        if (!j.f407a.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            a0.h.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new i());
        }
        r rVar = r.f420i;
        rVar.getClass();
        rVar.f425e = new Handler();
        rVar.f426f.c(f.ON_CREATE);
        Context applicationContext2 = context.getApplicationContext();
        a0.h.c(applicationContext2, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(new q(rVar));
        return rVar;
    }
}
