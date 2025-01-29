package U;

import S.g;
import S.i;
import a0.h;
import h0.C0045e;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import m0.AbstractC0081a;

/* loaded from: classes.dex */
public abstract class b implements S.d, c, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public final S.d f347b;

    /* renamed from: c, reason: collision with root package name */
    public final i f348c;

    /* renamed from: d, reason: collision with root package name */
    public transient S.d f349d;

    public b(S.d dVar) {
        i i2 = dVar != null ? dVar.i() : null;
        this.f347b = dVar;
        this.f348c = i2;
    }

    public S.d b(Object obj, S.d dVar) {
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    @Override // S.d
    public final void c(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        S.d dVar = this;
        while (true) {
            b bVar = (b) dVar;
            S.d dVar2 = bVar.f347b;
            h.b(dVar2);
            try {
                obj = bVar.e(obj);
                if (obj == T.a.f344b) {
                    return;
                }
            } catch (Throwable th) {
                obj = a.a.f(th);
            }
            S.d dVar3 = bVar.f349d;
            if (dVar3 != null && dVar3 != bVar) {
                i iVar = bVar.f348c;
                h.b(iVar);
                g f2 = iVar.f(S.e.f342b);
                h.b(f2);
                m0.h hVar = (m0.h) dVar3;
                do {
                    atomicReferenceFieldUpdater = m0.h.f1002i;
                } while (atomicReferenceFieldUpdater.get(hVar) == AbstractC0081a.f992d);
                Object obj2 = atomicReferenceFieldUpdater.get(hVar);
                C0045e c0045e = obj2 instanceof C0045e ? (C0045e) obj2 : null;
                if (c0045e != null) {
                    c0045e.n();
                }
            }
            bVar.f349d = a.f346b;
            if (!(dVar2 instanceof b)) {
                dVar2.c(obj);
                return;
            }
            dVar = dVar2;
        }
    }

    public abstract Object e(Object obj);

    @Override // U.c
    public final c g() {
        S.d dVar = this.f347b;
        if (dVar instanceof c) {
            return (c) dVar;
        }
        return null;
    }

    @Override // S.d
    public final i i() {
        i iVar = this.f348c;
        h.b(iVar);
        return iVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.StackTraceElement] */
    public String toString() {
        int i2;
        String str;
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        StringBuilder sb = new StringBuilder("Continuation at ");
        d dVar = (d) getClass().getAnnotation(d.class);
        String str2 = null;
        if (dVar != null) {
            int v2 = dVar.v();
            if (v2 > 1) {
                throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + v2 + ". Please update the Kotlin standard library.").toString());
            }
            try {
                Field declaredField = getClass().getDeclaredField("label");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(this);
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                i2 = (num != null ? num.intValue() : 0) - 1;
            } catch (Exception unused) {
                i2 = -1;
            }
            int i3 = i2 >= 0 ? dVar.l()[i2] : -1;
            B.e eVar = e.f351b;
            B.e eVar2 = e.f350a;
            if (eVar == null) {
                try {
                    B.e eVar3 = new B.e(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                    e.f351b = eVar3;
                    eVar = eVar3;
                } catch (Exception unused2) {
                    e.f351b = eVar2;
                    eVar = eVar2;
                }
            }
            if (eVar != eVar2 && (method = (Method) eVar.f8a) != null && (invoke = method.invoke(getClass(), null)) != null && (method2 = (Method) eVar.f9b) != null && (invoke2 = method2.invoke(invoke, null)) != null) {
                Method method3 = (Method) eVar.f10c;
                String invoke3 = method3 != null ? method3.invoke(invoke2, null) : null;
                if (invoke3 instanceof String) {
                    str2 = invoke3;
                }
            }
            if (str2 == null) {
                str = dVar.c();
            } else {
                str = str2 + '/' + dVar.c();
            }
            str2 = new StackTraceElement(str, dVar.m(), dVar.f(), i3);
        }
        if (str2 == null) {
            str2 = getClass().getName();
        }
        sb.append((Object) str2);
        return sb.toString();
    }
}
