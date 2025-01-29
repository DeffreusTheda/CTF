package a0;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class c implements e0.a, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public transient e0.a f363b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f364c;

    /* renamed from: d, reason: collision with root package name */
    public final Class f365d;

    /* renamed from: e, reason: collision with root package name */
    public final String f366e;

    /* renamed from: f, reason: collision with root package name */
    public final String f367f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f368g;

    public c(Object obj, Class cls, String str, String str2, boolean z2) {
        this.f364c = obj;
        this.f365d = cls;
        this.f366e = str;
        this.f367f = str2;
        this.f368g = z2;
    }

    public final d b() {
        Class cls = this.f365d;
        if (!this.f368g) {
            return l.a(cls);
        }
        l.f379a.getClass();
        return new j(cls);
    }
}
