package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class a implements n0.b, Serializable {
    public static final Object NO_RECEIVER = C0019a.f780d;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient n0.b reflected;
    private final String signature;

    /* renamed from: kotlin.jvm.internal.a$a, reason: collision with other inner class name */
    private static class C0019a implements Serializable {

        /* renamed from: d, reason: collision with root package name */
        private static final C0019a f780d = new C0019a();

        private C0019a() {
        }
    }

    public a() {
        this(NO_RECEIVER);
    }

    protected a(Object obj) {
        this(obj, null, null, null, false);
    }

    protected a(Object obj, Class cls, String str, String str2, boolean z2) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z2;
    }

    @Override // n0.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // n0.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public n0.b compute() {
        n0.b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        n0.b computeReflected = computeReflected();
        this.reflected = computeReflected;
        return computeReflected;
    }

    protected abstract n0.b computeReflected();

    @Override // n0.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public n0.d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? l.c(cls) : l.b(cls);
    }

    @Override // n0.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    protected n0.b getReflected() {
        n0.b compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new i0.b();
    }

    @Override // n0.b
    public n0.f getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // n0.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // n0.b
    public n0.g getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // n0.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // n0.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // n0.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // n0.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
