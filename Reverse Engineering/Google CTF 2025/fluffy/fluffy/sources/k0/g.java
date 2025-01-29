package k0;

import h0.C0045e;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class g extends l0.a implements c, d {

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f940f = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_state");
    private volatile Object _state;

    /* renamed from: e, reason: collision with root package name */
    public int f941e;

    public g(Object obj) {
        this._state = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ea, code lost:
    
        if (r0.equals(r4) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0152, code lost:
    
        if (r5 != r3) goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d6 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:13:0x003a, B:16:0x00ce, B:18:0x00d6, B:21:0x00dd, B:22:0x00e3, B:26:0x00e6, B:28:0x0107, B:31:0x011a, B:32:0x0132, B:39:0x0146, B:34:0x013d, B:38:0x0143, B:47:0x00ec, B:50:0x00f3, B:58:0x0055, B:60:0x0060, B:61:0x00be), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x011a A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:13:0x003a, B:16:0x00ce, B:18:0x00d6, B:21:0x00dd, B:22:0x00e3, B:26:0x00e6, B:28:0x0107, B:31:0x011a, B:32:0x0132, B:39:0x0146, B:34:0x013d, B:38:0x0143, B:47:0x00ec, B:50:0x00f3, B:58:0x0055, B:60:0x0060, B:61:0x00be), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0105 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0119 -> B:16:0x00ce). Please report as a decompilation issue!!! */
    @Override // k0.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(k0.d r17, S.d r18) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.g.a(k0.d, S.d):java.lang.Object");
    }

    @Override // k0.d
    public final Object b(Object obj, U.b bVar) {
        d(obj);
        return Q.g.f327a;
    }

    public final void d(Object obj) {
        int i2;
        l0.b[] bVarArr;
        io.flutter.plugin.platform.i iVar;
        if (obj == null) {
            obj = l0.e.f986a;
        }
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f940f;
            if (a0.h.a(atomicReferenceFieldUpdater.get(this), obj)) {
                return;
            }
            atomicReferenceFieldUpdater.set(this, obj);
            int i3 = this.f941e;
            if ((i3 & 1) != 0) {
                this.f941e = i3 + 2;
                return;
            }
            int i4 = i3 + 1;
            this.f941e = i4;
            l0.b[] bVarArr2 = this.f976b;
            while (true) {
                i[] iVarArr = (i[]) bVarArr2;
                if (iVarArr != null) {
                    for (i iVar2 : iVarArr) {
                        if (iVar2 != null) {
                            while (true) {
                                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = i.f944a;
                                Object obj2 = atomicReferenceFieldUpdater2.get(iVar2);
                                if (obj2 != null && obj2 != (iVar = h.f943b)) {
                                    io.flutter.plugin.platform.i iVar3 = h.f942a;
                                    if (obj2 != iVar3) {
                                        while (!atomicReferenceFieldUpdater2.compareAndSet(iVar2, obj2, iVar3)) {
                                            if (atomicReferenceFieldUpdater2.get(iVar2) != obj2) {
                                                break;
                                            }
                                        }
                                        ((C0045e) obj2).c(Q.g.f327a);
                                        break;
                                    }
                                    while (!atomicReferenceFieldUpdater2.compareAndSet(iVar2, obj2, iVar)) {
                                        if (atomicReferenceFieldUpdater2.get(iVar2) != obj2) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                synchronized (this) {
                    i2 = this.f941e;
                    if (i2 == i4) {
                        this.f941e = i4 + 1;
                        return;
                    }
                    bVarArr = this.f976b;
                }
                bVarArr2 = bVarArr;
                i4 = i2;
            }
        }
    }
}
