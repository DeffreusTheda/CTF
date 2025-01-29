package l;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* renamed from: l.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0073g {

    /* renamed from: a, reason: collision with root package name */
    public static final Field f949a;

    /* renamed from: b, reason: collision with root package name */
    public static final Field f950b;

    /* renamed from: c, reason: collision with root package name */
    public static final Field f951c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f952d;

    static {
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            f949a = declaredField;
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            Field declaredField2 = cls.getDeclaredField("mStableInsets");
            f950b = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mContentInsets");
            f951c = declaredField3;
            declaredField3.setAccessible(true);
            f952d = true;
        } catch (ReflectiveOperationException e2) {
            Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e2.getMessage(), e2);
        }
    }
}
