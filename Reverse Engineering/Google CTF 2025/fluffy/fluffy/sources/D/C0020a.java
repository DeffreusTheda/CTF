package d;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: d.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0020a implements Iterable {

    /* renamed from: b, reason: collision with root package name */
    public C0022c f444b;

    /* renamed from: c, reason: collision with root package name */
    public C0022c f445c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakHashMap f446d = new WeakHashMap();

    /* renamed from: e, reason: collision with root package name */
    public int f447e = 0;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f448f = new HashMap();

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0048, code lost:
    
        if (r3.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0050, code lost:
    
        if (((d.C0021b) r7).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0053, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof d.C0020a
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            d.a r7 = (d.C0020a) r7
            int r1 = r6.f447e
            int r3 = r7.f447e
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            d.b r3 = (d.C0021b) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            d.b r4 = (d.C0021b) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            d.b r7 = (d.C0021b) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            goto L54
        L53:
            r0 = 0
        L54:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.C0020a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = iterator();
        int i2 = 0;
        while (true) {
            C0021b c0021b = (C0021b) it;
            if (!c0021b.hasNext()) {
                return i2;
            }
            i2 += ((Map.Entry) c0021b.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        C0021b c0021b = new C0021b(this.f444b, this.f445c, 0);
        this.f446d.put(c0021b, Boolean.FALSE);
        return c0021b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            C0021b c0021b = (C0021b) it;
            if (!c0021b.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) c0021b.next()).toString());
            if (c0021b.hasNext()) {
                sb.append(", ");
            }
        }
    }
}
