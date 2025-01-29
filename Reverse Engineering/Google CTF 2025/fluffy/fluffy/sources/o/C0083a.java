package o;

import B.c;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import com.google.ctf.fluffy.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p.AbstractC0084a;

/* renamed from: o.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0083a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile C0083a f1130d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f1131e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Context f1134c;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f1133b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f1132a = new HashMap();

    public C0083a(Context context) {
        this.f1134c = context.getApplicationContext();
    }

    public static C0083a c(Context context) {
        if (f1130d == null) {
            synchronized (f1131e) {
                try {
                    if (f1130d == null) {
                        f1130d = new C0083a(context);
                    }
                } finally {
                }
            }
        }
        return f1130d;
    }

    public final void a(Bundle bundle) {
        HashSet hashSet;
        String string = this.f1134c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    hashSet = this.f1133b;
                    if (!hasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (b.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    b((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e2) {
                throw new c(e2);
            }
        }
    }

    public final void b(Class cls, HashSet hashSet) {
        boolean z2;
        boolean z3 = false;
        if (Build.VERSION.SDK_INT >= 29) {
            z2 = AbstractC0084a.c();
        } else {
            try {
                if (a.a.f357b == null) {
                    a.a.f356a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                    a.a.f357b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
                }
                z3 = ((Boolean) a.a.f357b.invoke(null, Long.valueOf(a.a.f356a))).booleanValue();
            } catch (Exception e2) {
                a.a.l("isTagEnabled", e2);
            }
            z2 = z3;
        }
        if (z2) {
            try {
                Trace.beginSection(a.a.y(cls.getSimpleName()));
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        HashMap hashMap = this.f1132a;
        if (hashMap.containsKey(cls)) {
            hashMap.get(cls);
        } else {
            hashSet.add(cls);
            try {
                b bVar = (b) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> a2 = bVar.a();
                if (!a2.isEmpty()) {
                    for (Class cls2 : a2) {
                        if (!hashMap.containsKey(cls2)) {
                            b(cls2, hashSet);
                        }
                    }
                }
                Object b2 = bVar.b(this.f1134c);
                hashSet.remove(cls);
                hashMap.put(cls, b2);
            } catch (Throwable th2) {
                throw new c(th2);
            }
        }
        Trace.endSection();
    }
}
