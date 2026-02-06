package f;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final e f160a;

    /* renamed from: f.a$a, reason: collision with other inner class name */
    private static class C0007a extends e {

        /* renamed from: a, reason: collision with root package name */
        protected final Window f161a;

        /* renamed from: b, reason: collision with root package name */
        private final View f162b;

        C0007a(Window window, View view) {
            this.f161a = window;
            this.f162b = view;
        }

        protected void c(int i2) {
            View decorView = this.f161a.getDecorView();
            decorView.setSystemUiVisibility(i2 | decorView.getSystemUiVisibility());
        }

        protected void d(int i2) {
            this.f161a.addFlags(i2);
        }

        protected void e(int i2) {
            View decorView = this.f161a.getDecorView();
            decorView.setSystemUiVisibility((i2 ^ (-1)) & decorView.getSystemUiVisibility());
        }

        protected void f(int i2) {
            this.f161a.clearFlags(i2);
        }
    }

    private static class b extends C0007a {
        b(Window window, View view) {
            super(window, view);
        }

        @Override // f.a.e
        public void b(boolean z2) {
            if (!z2) {
                e(8192);
                return;
            }
            f(67108864);
            d(Integer.MIN_VALUE);
            c(8192);
        }
    }

    private static class c extends b {
        c(Window window, View view) {
            super(window, view);
        }

        @Override // f.a.e
        public void a(boolean z2) {
            if (!z2) {
                e(16);
                return;
            }
            f(134217728);
            d(Integer.MIN_VALUE);
            c(16);
        }
    }

    private static class d extends e {

        /* renamed from: a, reason: collision with root package name */
        final a f163a;

        /* renamed from: b, reason: collision with root package name */
        final WindowInsetsController f164b;

        /* renamed from: c, reason: collision with root package name */
        private final b.d<Object, WindowInsetsController.OnControllableInsetsChangedListener> f165c;

        d(Window window, a aVar) {
            this(window.getInsetsController(), aVar);
        }

        d(WindowInsetsController windowInsetsController, a aVar) {
            this.f165c = new b.d<>();
            this.f164b = windowInsetsController;
            this.f163a = aVar;
        }

        @Override // f.a.e
        public void a(boolean z2) {
            if (z2) {
                this.f164b.setSystemBarsAppearance(16, 16);
            } else {
                this.f164b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // f.a.e
        public void b(boolean z2) {
            if (z2) {
                this.f164b.setSystemBarsAppearance(8, 8);
            } else {
                this.f164b.setSystemBarsAppearance(0, 8);
            }
        }
    }

    private static class e {
        e() {
        }

        public void a(boolean z2) {
        }

        public void b(boolean z2) {
        }
    }

    public a(Window window, View view) {
        e c0007a;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.f160a = new d(window, this);
            return;
        }
        if (i2 >= 26) {
            c0007a = new c(window, view);
        } else if (i2 >= 23) {
            c0007a = new b(window, view);
        } else {
            if (i2 < 20) {
                this.f160a = new e();
                return;
            }
            c0007a = new C0007a(window, view);
        }
        this.f160a = c0007a;
    }

    public void a(boolean z2) {
        this.f160a.a(z2);
    }

    public void b(boolean z2) {
        this.f160a.b(z2);
    }
}
