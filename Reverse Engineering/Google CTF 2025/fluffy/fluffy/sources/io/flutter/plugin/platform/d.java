package io.flutter.plugin.platform;

import android.view.View;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class d implements View.OnSystemUiVisibilityChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f697a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f698b;

    public d(e eVar, View view) {
        this.f698b = eVar;
        this.f697a = view;
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public final void onSystemUiVisibilityChange(final int i2) {
        this.f697a.post(new Runnable() { // from class: io.flutter.plugin.platform.c
            @Override // java.lang.Runnable
            public final void run() {
                int i3 = i2 & 4;
                e eVar = d.this.f698b;
                if (i3 == 0) {
                    B.a aVar = eVar.f700b;
                    aVar.getClass();
                    ((B.e) aVar.f4c).f("SystemChrome.systemUIChange", Arrays.asList(Boolean.TRUE), null);
                } else {
                    B.a aVar2 = eVar.f700b;
                    aVar2.getClass();
                    ((B.e) aVar2.f4c).f("SystemChrome.systemUIChange", Arrays.asList(Boolean.FALSE), null);
                }
            }
        });
    }
}
