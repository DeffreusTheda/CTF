package L;

import android.util.Log;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class m implements j {

    /* renamed from: a, reason: collision with root package name */
    public static final m f311a;

    static {
        l lVar = l.f308a;
        f311a = new m();
    }

    @Override // L.j
    public final ByteBuffer a(String str, String str2) {
        k kVar = new k();
        kVar.write(1);
        l lVar = l.f308a;
        l.j(kVar, "error");
        l.j(kVar, str);
        kVar.write(0);
        l.j(kVar, str2);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(kVar.size());
        allocateDirect.put(kVar.a(), 0, kVar.size());
        return allocateDirect;
    }

    @Override // L.j
    public final ByteBuffer d(String str, String str2, Object obj) {
        k kVar = new k();
        kVar.write(1);
        l lVar = l.f308a;
        l.j(kVar, str);
        l.j(kVar, str2);
        if (obj instanceof Throwable) {
            l.j(kVar, Log.getStackTraceString((Throwable) obj));
        } else {
            l.j(kVar, obj);
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(kVar.size());
        allocateDirect.put(kVar.a(), 0, kVar.size());
        return allocateDirect;
    }

    @Override // L.j
    public final ByteBuffer e(Object obj) {
        k kVar = new k();
        kVar.write(0);
        l lVar = l.f308a;
        l.j(kVar, obj);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(kVar.size());
        allocateDirect.put(kVar.a(), 0, kVar.size());
        return allocateDirect;
    }

    @Override // L.j
    public final ByteBuffer f(B.a aVar) {
        k kVar = new k();
        l lVar = l.f308a;
        l.j(kVar, (String) aVar.f4c);
        l.j(kVar, aVar.f5d);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(kVar.size());
        allocateDirect.put(kVar.a(), 0, kVar.size());
        return allocateDirect;
    }

    @Override // L.j
    public final B.a g(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        l lVar = l.f308a;
        Serializable e2 = l.e(byteBuffer);
        Serializable e3 = l.e(byteBuffer);
        if (!(e2 instanceof String) || byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Method call corrupted");
        }
        return new B.a(e3, (String) e2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r0 == 1) goto L10;
     */
    @Override // L.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(java.nio.ByteBuffer r5) {
        /*
            r4 = this;
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            r5.order(r0)
            byte r0 = r5.get()
            if (r0 == 0) goto L11
            r1 = 1
            if (r0 != r1) goto L46
            goto L1e
        L11:
            L.l r0 = L.l.f308a
            java.io.Serializable r0 = L.l.e(r5)
            boolean r1 = r5.hasRemaining()
            if (r1 != 0) goto L1e
            return r0
        L1e:
            L.l r0 = L.l.f308a
            java.io.Serializable r0 = L.l.e(r5)
            java.io.Serializable r1 = L.l.e(r5)
            java.io.Serializable r2 = L.l.e(r5)
            boolean r3 = r0 instanceof java.lang.String
            if (r3 == 0) goto L46
            if (r1 == 0) goto L36
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L46
        L36:
            boolean r5 = r5.hasRemaining()
            if (r5 != 0) goto L46
            L.f r5 = new L.f
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = (java.lang.String) r1
            r5.<init>(r0, r1, r2)
            throw r5
        L46:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Envelope corrupted"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: L.m.h(java.nio.ByteBuffer):java.lang.Object");
    }
}
