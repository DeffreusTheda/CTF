package io.flutter.plugin.platform;

import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;

/* loaded from: classes.dex */
public final class o extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final r f740a;

    /* renamed from: b, reason: collision with root package name */
    public r f741b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f742c;

    public o(Context context, r rVar, Context context2) {
        super(context);
        this.f740a = rVar;
        this.f742c = context2;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"window".equals(str)) {
            return super.getSystemService(str);
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i2 = 0; i2 < stackTrace.length && i2 < 11; i2++) {
            if (stackTrace[i2].getClassName().equals(AlertDialog.class.getCanonicalName()) && stackTrace[i2].getMethodName().equals("<init>")) {
                return this.f742c.getSystemService(str);
            }
        }
        if (this.f741b == null) {
            this.f741b = this.f740a;
        }
        return this.f741b;
    }
}
