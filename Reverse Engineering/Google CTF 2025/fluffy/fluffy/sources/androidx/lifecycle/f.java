package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class f {
    private static final /* synthetic */ f[] $VALUES;
    public static final d Companion;
    public static final f ON_ANY;
    public static final f ON_CREATE;
    public static final f ON_DESTROY;
    public static final f ON_PAUSE;
    public static final f ON_RESUME;
    public static final f ON_START;
    public static final f ON_STOP;

    static {
        f fVar = new f("ON_CREATE", 0);
        ON_CREATE = fVar;
        f fVar2 = new f("ON_START", 1);
        ON_START = fVar2;
        f fVar3 = new f("ON_RESUME", 2);
        ON_RESUME = fVar3;
        f fVar4 = new f("ON_PAUSE", 3);
        ON_PAUSE = fVar4;
        f fVar5 = new f("ON_STOP", 4);
        ON_STOP = fVar5;
        f fVar6 = new f("ON_DESTROY", 5);
        ON_DESTROY = fVar6;
        f fVar7 = new f("ON_ANY", 6);
        ON_ANY = fVar7;
        $VALUES = new f[]{fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7};
        Companion = new d();
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) $VALUES.clone();
    }

    public final g a() {
        switch (e.f400a[ordinal()]) {
            case 1:
            case 2:
                return g.f403d;
            case 3:
            case 4:
                return g.f404e;
            case 5:
                return g.f405f;
            case 6:
                return g.f401b;
            default:
                throw new IllegalArgumentException(this + " has no target state");
        }
    }
}
