package l;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import h.C0040b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* renamed from: l.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0074h extends AbstractC0078l {

    /* renamed from: c, reason: collision with root package name */
    public static Field f953c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f954d = false;

    /* renamed from: e, reason: collision with root package name */
    public static Constructor f955e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f956f = false;

    /* renamed from: a, reason: collision with root package name */
    public WindowInsets f957a = e();

    /* renamed from: b, reason: collision with root package name */
    public C0040b f958b;

    private static WindowInsets e() {
        if (!f954d) {
            try {
                f953c = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e2) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
            }
            f954d = true;
        }
        Field field = f953c;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e3) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
            }
        }
        if (!f956f) {
            try {
                f955e = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e4) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
            }
            f956f = true;
        }
        Constructor constructor = f955e;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e5) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
            }
        }
        return null;
    }

    @Override // l.AbstractC0078l
    public s b() {
        a();
        s a2 = s.a(this.f957a, null);
        r rVar = a2.f972a;
        rVar.j(null);
        rVar.l(this.f958b);
        return a2;
    }

    @Override // l.AbstractC0078l
    public void c(C0040b c0040b) {
        this.f958b = c0040b;
    }

    @Override // l.AbstractC0078l
    public void d(C0040b c0040b) {
        WindowInsets windowInsets = this.f957a;
        if (windowInsets != null) {
            this.f957a = windowInsets.replaceSystemWindowInsets(c0040b.f511a, c0040b.f512b, c0040b.f513c, c0040b.f514d);
        }
    }
}
