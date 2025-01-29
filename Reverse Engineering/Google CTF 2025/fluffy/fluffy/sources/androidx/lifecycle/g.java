package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final g f401b;

    /* renamed from: c, reason: collision with root package name */
    public static final g f402c;

    /* renamed from: d, reason: collision with root package name */
    public static final g f403d;

    /* renamed from: e, reason: collision with root package name */
    public static final g f404e;

    /* renamed from: f, reason: collision with root package name */
    public static final g f405f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ g[] f406g;

    static {
        g gVar = new g("DESTROYED", 0);
        f401b = gVar;
        g gVar2 = new g("INITIALIZED", 1);
        f402c = gVar2;
        g gVar3 = new g("CREATED", 2);
        f403d = gVar3;
        g gVar4 = new g("STARTED", 3);
        f404e = gVar4;
        g gVar5 = new g("RESUMED", 4);
        f405f = gVar5;
        f406g = new g[]{gVar, gVar2, gVar3, gVar4, gVar5};
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) f406g.clone();
    }
}
