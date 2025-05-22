package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.view.Window;
import io.flutter.plugin.platform.c;
import java.io.FileNotFoundException;
import java.util.List;
import v.i;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f482a;

    /* renamed from: b, reason: collision with root package name */
    private final v.i f483b;

    /* renamed from: c, reason: collision with root package name */
    private final d f484c;

    /* renamed from: d, reason: collision with root package name */
    private i.j f485d;

    /* renamed from: e, reason: collision with root package name */
    private int f486e;

    /* renamed from: f, reason: collision with root package name */
    final i.h f487f;

    class a implements i.h {
        a() {
        }

        @Override // v.i.h
        public void a() {
            c.this.v();
        }

        @Override // v.i.h
        public void b() {
            c.this.r();
        }

        @Override // v.i.h
        public void c(i.j jVar) {
            c.this.z(jVar);
        }

        @Override // v.i.h
        public void d(int i2) {
            c.this.y(i2);
        }

        @Override // v.i.h
        public CharSequence e(i.e eVar) {
            return c.this.p(eVar);
        }

        @Override // v.i.h
        public void f(i.c cVar) {
            c.this.u(cVar);
        }

        @Override // v.i.h
        public void g(List<i.l> list) {
            c.this.x(list);
        }

        @Override // v.i.h
        public void h() {
            c.this.s();
        }

        @Override // v.i.h
        public void i(String str) {
            c.this.t(str);
        }

        @Override // v.i.h
        public boolean j() {
            return c.this.n();
        }

        @Override // v.i.h
        public void k(i.k kVar) {
            c.this.w(kVar);
        }

        @Override // v.i.h
        public void l(i.g gVar) {
            c.this.B(gVar);
        }

        @Override // v.i.h
        public void m(i.EnumC0032i enumC0032i) {
            c.this.q(enumC0032i);
        }
    }

    class b implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f489a;

        b(View view) {
            this.f489a = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i2) {
            v.i iVar;
            boolean z2;
            if ((i2 & 4) == 0) {
                iVar = c.this.f483b;
                z2 = true;
            } else {
                iVar = c.this.f483b;
                z2 = false;
            }
            iVar.m(z2);
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(final int i2) {
            this.f489a.post(new Runnable() { // from class: io.flutter.plugin.platform.d
                @Override // java.lang.Runnable
                public final void run() {
                    c.b.this.b(i2);
                }
            });
        }
    }

    /* renamed from: io.flutter.plugin.platform.c$c, reason: collision with other inner class name */
    static /* synthetic */ class C0012c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f491a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f492b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f493c;

        static {
            int[] iArr = new int[i.d.values().length];
            f493c = iArr;
            try {
                iArr[i.d.DARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f493c[i.d.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[i.l.values().length];
            f492b = iArr2;
            try {
                iArr2[i.l.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f492b[i.l.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[i.g.values().length];
            f491a = iArr3;
            try {
                iArr3[i.g.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f491a[i.g.LIGHT_IMPACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f491a[i.g.MEDIUM_IMPACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f491a[i.g.HEAVY_IMPACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f491a[i.g.SELECTION_CLICK.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public interface d {
        boolean b();
    }

    public c(Activity activity, v.i iVar, d dVar) {
        a aVar = new a();
        this.f487f = aVar;
        this.f482a = activity;
        this.f483b = iVar;
        iVar.l(aVar);
        this.f484c = dVar;
        this.f486e = 1280;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        ClipDescription primaryClipDescription;
        ClipboardManager clipboardManager = (ClipboardManager) this.f482a.getSystemService("clipboard");
        if (clipboardManager.hasPrimaryClip() && (primaryClipDescription = clipboardManager.getPrimaryClipDescription()) != null) {
            return primaryClipDescription.hasMimeType("text/*");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence p(i.e eVar) {
        ClipboardManager clipboardManager = (ClipboardManager) this.f482a.getSystemService("clipboard");
        if (!clipboardManager.hasPrimaryClip()) {
            return null;
        }
        try {
            ClipData primaryClip = clipboardManager.getPrimaryClip();
            if (primaryClip == null) {
                return null;
            }
            if (eVar != null && eVar != i.e.PLAIN_TEXT) {
                return null;
            }
            ClipData.Item itemAt = primaryClip.getItemAt(0);
            if (itemAt.getUri() != null) {
                this.f482a.getContentResolver().openTypedAssetFileDescriptor(itemAt.getUri(), "text/*", null);
            }
            return itemAt.coerceToText(this.f482a);
        } catch (FileNotFoundException unused) {
            return null;
        } catch (SecurityException e2) {
            j.b.h("PlatformPlugin", "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(i.EnumC0032i enumC0032i) {
        if (enumC0032i == i.EnumC0032i.CLICK) {
            this.f482a.getWindow().getDecorView().playSoundEffect(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void r() {
        d dVar = this.f484c;
        if (dVar == null || !dVar.b()) {
            Activity activity = this.f482a;
            if (activity instanceof androidx.activity.b) {
                ((androidx.activity.b) activity).i();
                throw null;
            }
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        ((ClipboardManager) this.f482a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(i.c cVar) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            return;
        }
        if (i2 < 28 && i2 > 21) {
            this.f482a.setTaskDescription(new ActivityManager.TaskDescription(cVar.f1234b, (Bitmap) null, cVar.f1233a));
        }
        if (i2 >= 28) {
            this.f482a.setTaskDescription(new ActivityManager.TaskDescription(cVar.f1234b, 0, cVar.f1233a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        View decorView = this.f482a.getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new b(decorView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(i.k kVar) {
        int i2;
        if (kVar == i.k.LEAN_BACK) {
            i2 = 1798;
        } else if (kVar == i.k.IMMERSIVE && Build.VERSION.SDK_INT >= 19) {
            i2 = 3846;
        } else if (kVar == i.k.IMMERSIVE_STICKY && Build.VERSION.SDK_INT >= 19) {
            i2 = 5894;
        } else if (kVar != i.k.EDGE_TO_EDGE || Build.VERSION.SDK_INT < 29) {
            return;
        } else {
            i2 = 1792;
        }
        this.f486e = i2;
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(List<i.l> list) {
        int i2 = (list.size() != 0 || Build.VERSION.SDK_INT < 19) ? 1798 : 5894;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int i4 = C0012c.f492b[list.get(i3).ordinal()];
            if (i4 == 1) {
                i2 &= -5;
            } else if (i4 == 2) {
                i2 = i2 & (-513) & (-3);
            }
        }
        this.f486e = i2;
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i2) {
        this.f482a.setRequestedOrientation(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(21)
    public void z(i.j jVar) {
        Window window = this.f482a.getWindow();
        f.a aVar = new f.a(window, window.getDecorView());
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 30) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(201326592);
        }
        if (i2 >= 23) {
            i.d dVar = jVar.f1260b;
            if (dVar != null) {
                int i3 = C0012c.f493c[dVar.ordinal()];
                if (i3 == 1) {
                    aVar.b(true);
                } else if (i3 == 2) {
                    aVar.b(false);
                }
            }
            Integer num = jVar.f1259a;
            if (num != null) {
                window.setStatusBarColor(num.intValue());
            }
        }
        Boolean bool = jVar.f1261c;
        if (bool != null && i2 >= 29) {
            window.setStatusBarContrastEnforced(bool.booleanValue());
        }
        if (i2 >= 26) {
            i.d dVar2 = jVar.f1263e;
            if (dVar2 != null) {
                int i4 = C0012c.f493c[dVar2.ordinal()];
                if (i4 == 1) {
                    aVar.a(true);
                } else if (i4 == 2) {
                    aVar.a(false);
                }
            }
            Integer num2 = jVar.f1262d;
            if (num2 != null) {
                window.setNavigationBarColor(num2.intValue());
            }
        }
        Integer num3 = jVar.f1264f;
        if (num3 != null && i2 >= 28) {
            window.setNavigationBarDividerColor(num3.intValue());
        }
        Boolean bool2 = jVar.f1265g;
        if (bool2 != null && i2 >= 29) {
            window.setNavigationBarContrastEnforced(bool2.booleanValue());
        }
        this.f485d = jVar;
    }

    public void A() {
        this.f482a.getWindow().getDecorView().setSystemUiVisibility(this.f486e);
        i.j jVar = this.f485d;
        if (jVar != null) {
            z(jVar);
        }
    }

    void B(i.g gVar) {
        int i2;
        View decorView = this.f482a.getWindow().getDecorView();
        int i3 = C0012c.f491a[gVar.ordinal()];
        int i4 = 1;
        if (i3 != 1) {
            if (i3 != 2) {
                i4 = 3;
                if (i3 != 3) {
                    i4 = 4;
                    if (i3 != 4) {
                        if (i3 != 5 || Build.VERSION.SDK_INT < 21) {
                            return;
                        }
                    } else if (Build.VERSION.SDK_INT < 23) {
                        return;
                    } else {
                        i2 = 6;
                    }
                }
            }
            decorView.performHapticFeedback(i4);
            return;
        }
        i2 = 0;
        decorView.performHapticFeedback(i2);
    }

    public void o() {
        this.f483b.l(null);
    }
}
