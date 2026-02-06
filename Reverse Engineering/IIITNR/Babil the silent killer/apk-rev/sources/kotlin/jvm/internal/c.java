package kotlin.jvm.internal;

import b0.y;
import b0.z;
import j0.o;
import j0.p;
import j0.q;
import j0.r;
import j0.s;
import j0.t;
import j0.u;
import j0.v;
import j0.w;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class c implements n0.c<Object>, b {

    /* renamed from: e, reason: collision with root package name */
    public static final a f781e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Map<Class<? extends a0.c<?>>, Integer> f782f;

    /* renamed from: g, reason: collision with root package name */
    private static final HashMap<String, String> f783g;

    /* renamed from: h, reason: collision with root package name */
    private static final HashMap<String, String> f784h;

    /* renamed from: i, reason: collision with root package name */
    private static final HashMap<String, String> f785i;

    /* renamed from: j, reason: collision with root package name */
    private static final Map<String, String> f786j;

    /* renamed from: d, reason: collision with root package name */
    private final Class<?> f787d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }

        public final String a(Class<?> jClass) {
            String str;
            String S;
            String T;
            String T2;
            i.e(jClass, "jClass");
            String str2 = null;
            if (!jClass.isAnonymousClass()) {
                if (jClass.isLocalClass()) {
                    String name = jClass.getSimpleName();
                    Method enclosingMethod = jClass.getEnclosingMethod();
                    if (enclosingMethod != null) {
                        i.d(name, "name");
                        T2 = p0.n.T(name, enclosingMethod.getName() + '$', null, 2, null);
                        if (T2 != null) {
                            return T2;
                        }
                    }
                    Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
                    i.d(name, "name");
                    if (enclosingConstructor == null) {
                        S = p0.n.S(name, '$', null, 2, null);
                        return S;
                    }
                    T = p0.n.T(name, enclosingConstructor.getName() + '$', null, 2, null);
                    return T;
                }
                if (!jClass.isArray()) {
                    String str3 = (String) c.f786j.get(jClass.getName());
                    return str3 == null ? jClass.getSimpleName() : str3;
                }
                Class<?> componentType = jClass.getComponentType();
                if (componentType.isPrimitive() && (str = (String) c.f786j.get(componentType.getName())) != null) {
                    str2 = str + "Array";
                }
                if (str2 == null) {
                    return "Array";
                }
            }
            return str2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List d2;
        int g2;
        Map<Class<? extends a0.c<?>>, Integer> g3;
        int a2;
        String V;
        String V2;
        int i2 = 0;
        d2 = b0.i.d(j0.a.class, j0.l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, j0.b.class, j0.c.class, j0.d.class, j0.e.class, j0.f.class, j0.g.class, j0.h.class, j0.i.class, j0.j.class, j0.k.class, j0.m.class, j0.n.class, o.class);
        g2 = b0.j.g(d2, 10);
        ArrayList arrayList = new ArrayList(g2);
        for (Object obj : d2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                b0.i.f();
            }
            arrayList.add(a0.n.a((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        g3 = z.g(arrayList);
        f782f = g3;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f783g = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f784h = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        i.d(values, "primitiveFqNames.values");
        for (String kotlinName : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            i.d(kotlinName, "kotlinName");
            V2 = p0.n.V(kotlinName, '.', null, 2, null);
            sb.append(V2);
            sb.append("CompanionObject");
            a0.j a3 = a0.n.a(sb.toString(), kotlinName + ".Companion");
            hashMap3.put(a3.c(), a3.d());
        }
        for (Map.Entry<Class<? extends a0.c<?>>, Integer> entry : f782f.entrySet()) {
            hashMap3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f785i = hashMap3;
        a2 = y.a(hashMap3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(a2);
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key = entry2.getKey();
            V = p0.n.V((String) entry2.getValue(), '.', null, 2, null);
            linkedHashMap.put(key, V);
        }
        f786j = linkedHashMap;
    }

    public c(Class<?> jClass) {
        i.e(jClass, "jClass");
        this.f787d = jClass;
    }

    @Override // n0.c
    public String a() {
        return f781e.a(b());
    }

    @Override // kotlin.jvm.internal.b
    public Class<?> b() {
        return this.f787d;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && i.a(i0.a.a(this), i0.a.a((n0.c) obj));
    }

    public int hashCode() {
        return i0.a.a(this).hashCode();
    }

    public String toString() {
        return b().toString() + " (Kotlin reflection is not available)";
    }
}
