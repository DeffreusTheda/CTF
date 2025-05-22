package w;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import w.o;

/* loaded from: classes.dex */
public final class p implements j {

    /* renamed from: b, reason: collision with root package name */
    public static final p f1413b = new p(o.f1410a);

    /* renamed from: a, reason: collision with root package name */
    private final o f1414a;

    public p(o oVar) {
        this.f1414a = oVar;
    }

    @Override // w.j
    public ByteBuffer a(String str, String str2, Object obj, String str3) {
        o.a aVar = new o.a();
        aVar.write(1);
        this.f1414a.p(aVar, str);
        this.f1414a.p(aVar, str2);
        if (obj instanceof Throwable) {
            this.f1414a.p(aVar, j.b.d((Throwable) obj));
        } else {
            this.f1414a.p(aVar, obj);
        }
        this.f1414a.p(aVar, str3);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // w.j
    public ByteBuffer b(h hVar) {
        o.a aVar = new o.a();
        this.f1414a.p(aVar, hVar.f1398a);
        this.f1414a.p(aVar, hVar.f1399b);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // w.j
    public ByteBuffer c(String str, String str2, Object obj) {
        o.a aVar = new o.a();
        aVar.write(1);
        this.f1414a.p(aVar, str);
        this.f1414a.p(aVar, str2);
        if (obj instanceof Throwable) {
            this.f1414a.p(aVar, j.b.d((Throwable) obj));
        } else {
            this.f1414a.p(aVar, obj);
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // w.j
    public ByteBuffer d(Object obj) {
        o.a aVar = new o.a();
        aVar.write(0);
        this.f1414a.p(aVar, obj);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // w.j
    public h e(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        Object f2 = this.f1414a.f(byteBuffer);
        Object f3 = this.f1414a.f(byteBuffer);
        if (!(f2 instanceof String) || byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Method call corrupted");
        }
        return new h((String) f2, f3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r0 == 1) goto L10;
     */
    @Override // w.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(java.nio.ByteBuffer r5) {
        /*
            r4 = this;
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            r5.order(r0)
            byte r0 = r5.get()
            if (r0 == 0) goto L11
            r1 = 1
            if (r0 != r1) goto L4a
            goto L1e
        L11:
            w.o r0 = r4.f1414a
            java.lang.Object r0 = r0.f(r5)
            boolean r1 = r5.hasRemaining()
            if (r1 != 0) goto L1e
            return r0
        L1e:
            w.o r0 = r4.f1414a
            java.lang.Object r0 = r0.f(r5)
            w.o r1 = r4.f1414a
            java.lang.Object r1 = r1.f(r5)
            w.o r2 = r4.f1414a
            java.lang.Object r2 = r2.f(r5)
            boolean r3 = r0 instanceof java.lang.String
            if (r3 == 0) goto L4a
            if (r1 == 0) goto L3a
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L4a
        L3a:
            boolean r5 = r5.hasRemaining()
            if (r5 != 0) goto L4a
            w.c r5 = new w.c
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = (java.lang.String) r1
            r5.<init>(r0, r1, r2)
            throw r5
        L4a:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Envelope corrupted"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: w.p.f(java.nio.ByteBuffer):java.lang.Object");
    }
}
