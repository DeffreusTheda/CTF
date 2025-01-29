package K;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final e f229b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ e[] f230c;

    static {
        e eVar = new e("PLAIN_TEXT", 0);
        f229b = eVar;
        f230c = new e[]{eVar};
    }

    public static e a(String str) {
        for (e eVar : values()) {
            eVar.getClass();
            if ("text/plain".equals(str)) {
                return eVar;
            }
        }
        throw new NoSuchFieldException("No such ClipboardContentFormat: " + str);
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) f230c.clone();
    }
}
