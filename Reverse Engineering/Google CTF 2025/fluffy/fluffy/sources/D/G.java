package D;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class G implements K {

    /* renamed from: b, reason: collision with root package name */
    public final L.e f26b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f27c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f28d;

    /* renamed from: e, reason: collision with root package name */
    public final H f29e;

    public G(L.e eVar) {
        HashMap hashMap = new HashMap();
        this.f28d = hashMap;
        this.f29e = new H();
        this.f26b = eVar;
        M m = Q.f42a;
        P p2 = new P();
        p2.f41a = false;
        P p3 = new P[]{p2}[0];
        p3.getClass();
        hashMap.put(4294967556L, p3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02eb  */
    @Override // D.K
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(final android.view.KeyEvent r30, D.I r31) {
        /*
            Method dump skipped, instructions count: 897
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D.G.a(android.view.KeyEvent, D.I):void");
    }

    public final void b(D d2, final I i2) {
        long j2;
        long j3;
        byte[] bArr = null;
        L.d dVar = i2 == null ? null : new L.d() { // from class: D.E
            @Override // L.d
            public final void a(ByteBuffer byteBuffer) {
                Boolean bool = Boolean.FALSE;
                if (byteBuffer != null) {
                    byteBuffer.rewind();
                    if (byteBuffer.capacity() != 0) {
                        bool = Boolean.valueOf(byteBuffer.get() != 0);
                    }
                } else {
                    Log.w("KeyEmbedderResponder", "A null reply was received when sending a key event to the framework.");
                }
                I.this.a(bool.booleanValue());
            }
        };
        try {
            String str = d2.f19g;
            if (str != null) {
                bArr = str.getBytes("UTF-8");
            }
            int length = bArr == null ? 0 : bArr.length;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(length + 56);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            allocateDirect.putLong(length);
            allocateDirect.putLong(d2.f13a);
            int i3 = d2.f14b;
            if (i3 == 1) {
                j2 = 0;
            } else if (i3 == 2) {
                j2 = 1;
            } else {
                if (i3 != 3) {
                    throw null;
                }
                j2 = 2;
            }
            allocateDirect.putLong(j2);
            allocateDirect.putLong(d2.f15c);
            allocateDirect.putLong(d2.f16d);
            allocateDirect.putLong(d2.f17e ? 1L : 0L);
            int i4 = d2.f18f;
            if (i4 == 1) {
                j3 = 0;
            } else if (i4 == 2) {
                j3 = 1;
            } else if (i4 == 3) {
                j3 = 2;
            } else if (i4 == 4) {
                j3 = 3;
            } else {
                if (i4 != 5) {
                    throw null;
                }
                j3 = 4;
            }
            allocateDirect.putLong(j3);
            if (bArr != null) {
                allocateDirect.put(bArr);
            }
            this.f26b.a("flutter/keydata", allocateDirect, dVar);
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError("UTF-8 not supported");
        }
    }

    public final void c(boolean z2, Long l2, Long l3, long j2) {
        D d2 = new D();
        d2.f13a = j2;
        d2.f14b = z2 ? 1 : 2;
        d2.f16d = l2.longValue();
        d2.f15c = l3.longValue();
        d2.f19g = null;
        d2.f17e = true;
        d2.f18f = 1;
        if (l3.longValue() != 0 && l2.longValue() != 0) {
            if (!z2) {
                l2 = null;
            }
            d(l3, l2);
        }
        b(d2, null);
    }

    public final void d(Long l2, Long l3) {
        HashMap hashMap = this.f27c;
        if (l3 != null) {
            if (((Long) hashMap.put(l2, l3)) != null) {
                throw new AssertionError("The key was not empty");
            }
        } else if (((Long) hashMap.remove(l2)) == null) {
            throw new AssertionError("The key was empty");
        }
    }
}
