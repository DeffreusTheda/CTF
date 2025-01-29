package s;

import a0.l;
import a0.n;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: s.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0093c implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public final a0.e f1154a;

    /* renamed from: b, reason: collision with root package name */
    public final x.b f1155b;

    public C0093c(a0.e eVar, x.b bVar) {
        this.f1154a = eVar;
        this.f1155b = bVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        boolean isInstance;
        String str;
        a0.h.e(obj, "obj");
        a0.h.e(method, "method");
        boolean a2 = a0.h.a(method.getName(), "accept");
        x.b bVar = this.f1155b;
        r2 = null;
        r2 = null;
        r2 = null;
        String str2 = null;
        if (!a2 || objArr == null || objArr.length != 1) {
            if (a0.h.a(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1) {
                return Boolean.valueOf(obj == (objArr != null ? objArr[0] : null));
            }
            if (a0.h.a(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null) {
                return Integer.valueOf(bVar.hashCode());
            }
            if (a0.h.a(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null) {
                return bVar.toString();
            }
            throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
        }
        Object obj2 = objArr[0];
        Class cls = this.f1154a.f372a;
        a0.h.e(cls, "jClass");
        Map map = a0.e.f369b;
        a0.h.c(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            isInstance = n.b(num.intValue(), obj2);
        } else {
            isInstance = (cls.isPrimitive() ? a.a.k(l.a(cls)) : cls).isInstance(obj2);
        }
        if (isInstance) {
            a0.h.c(obj2, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
            bVar.h(obj2);
            return Q.g.f327a;
        }
        StringBuilder sb = new StringBuilder("Value cannot be cast to ");
        if (!cls.isAnonymousClass() && !cls.isLocalClass()) {
            boolean isArray = cls.isArray();
            HashMap hashMap = a0.e.f370c;
            if (isArray) {
                Class<?> componentType = cls.getComponentType();
                if (componentType.isPrimitive() && (str = (String) hashMap.get(componentType.getName())) != null) {
                    str2 = str.concat("Array");
                }
                if (str2 == null) {
                    str2 = "kotlin.Array";
                }
            } else {
                str2 = (String) hashMap.get(cls.getName());
                if (str2 == null) {
                    str2 = cls.getCanonicalName();
                }
            }
        }
        sb.append(str2);
        throw new ClassCastException(sb.toString());
    }
}
