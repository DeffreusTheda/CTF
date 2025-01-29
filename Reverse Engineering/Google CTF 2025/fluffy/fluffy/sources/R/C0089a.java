package r;

import a0.h;
import a0.i;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import s.C0099i;

/* renamed from: r.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0089a extends i implements Z.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1146c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1147d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0089a(int i2, Object obj) {
        super(0);
        this.f1146c = i2;
        this.f1147d = obj;
    }

    @Override // Z.a
    public final Object a() {
        switch (this.f1146c) {
            case 0:
                C0090b c0090b = (C0090b) this.f1147d;
                Class<?> loadClass = c0090b.f1148a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
                h.d(loadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
                Method declaredMethod = loadClass.getDeclaredMethod("getWindowExtensions", null);
                Class<?> loadClass2 = c0090b.f1148a.loadClass("androidx.window.extensions.WindowExtensions");
                h.d(loadClass2, "loader.loadClass(WindowE….WINDOW_EXTENSIONS_CLASS)");
                h.d(declaredMethod, "getWindowExtensionsMethod");
                return Boolean.valueOf(declaredMethod.getReturnType().equals(loadClass2) && Modifier.isPublic(declaredMethod.getModifiers()));
            default:
                C0099i c0099i = (C0099i) this.f1147d;
                return BigInteger.valueOf(c0099i.f1167b).shiftLeft(32).or(BigInteger.valueOf(c0099i.f1168c)).shiftLeft(32).or(BigInteger.valueOf(c0099i.f1169d));
        }
    }
}
