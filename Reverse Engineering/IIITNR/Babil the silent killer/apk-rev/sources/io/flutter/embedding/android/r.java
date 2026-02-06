package io.flutter.embedding.android;

import android.view.KeyEvent;
import io.flutter.embedding.android.n;
import io.flutter.embedding.android.s;
import io.flutter.embedding.android.t;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import w.b;

/* loaded from: classes.dex */
public class r implements s.d {

    /* renamed from: a, reason: collision with root package name */
    private final w.b f302a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<Long, Long> f303b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<Long, t.e> f304c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final s.b f305d = new s.b();

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f306a;

        static {
            int[] iArr = new int[n.a.values().length];
            f306a = iArr;
            try {
                iArr[n.a.kDown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f306a[n.a.kUp.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f306a[n.a.kRepeat.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public r(w.b bVar) {
        this.f302a = bVar;
        for (t.e eVar : t.a()) {
            this.f304c.put(Long.valueOf(eVar.f326c), eVar);
        }
    }

    private static n.a e(KeyEvent keyEvent) {
        boolean z2 = keyEvent.getRepeatCount() > 0;
        int action = keyEvent.getAction();
        if (action == 0) {
            return z2 ? n.a.kRepeat : n.a.kDown;
        }
        if (action == 1) {
            return n.a.kUp;
        }
        throw new AssertionError("Unexpected event type");
    }

    private Long f(KeyEvent keyEvent) {
        Long l2 = t.f318b.get(Long.valueOf(keyEvent.getKeyCode()));
        return l2 != null ? l2 : Long.valueOf(i(keyEvent.getKeyCode(), 73014444032L));
    }

    private Long g(KeyEvent keyEvent) {
        int scanCode;
        long scanCode2 = keyEvent.getScanCode();
        if (scanCode2 == 0) {
            scanCode = keyEvent.getKeyCode();
        } else {
            Long l2 = t.f317a.get(Long.valueOf(scanCode2));
            if (l2 != null) {
                return l2;
            }
            scanCode = keyEvent.getScanCode();
        }
        return Long.valueOf(i(scanCode, 73014444032L));
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0119 A[LOOP:2: B:52:0x0113->B:54:0x0119, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean h(android.view.KeyEvent r18, io.flutter.embedding.android.s.d.a r19) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.r.h(android.view.KeyEvent, io.flutter.embedding.android.s$d$a):boolean");
    }

    private static long i(long j2, long j3) {
        return (j2 & 4294967295L) | j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(s.d.a aVar, ByteBuffer byteBuffer) {
        Boolean bool = Boolean.FALSE;
        byteBuffer.rewind();
        if (byteBuffer.capacity() != 0) {
            bool = Boolean.valueOf(byteBuffer.get() != 0);
        }
        aVar.a(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(t.c cVar, long j2, KeyEvent keyEvent) {
        p(false, Long.valueOf(cVar.f321b), Long.valueOf(j2), keyEvent.getEventTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(t.c cVar, KeyEvent keyEvent) {
        p(false, Long.valueOf(cVar.f321b), Long.valueOf(cVar.f320a), keyEvent.getEventTime());
    }

    private void m(n nVar, final s.d.a aVar) {
        this.f302a.d("flutter/keydata", nVar.a(), aVar == null ? null : new b.InterfaceC0035b() { // from class: io.flutter.embedding.android.q
            @Override // w.b.InterfaceC0035b
            public final void a(ByteBuffer byteBuffer) {
                r.j(s.d.a.this, byteBuffer);
            }
        });
    }

    private void p(boolean z2, Long l2, Long l3, long j2) {
        n nVar = new n();
        nVar.f283a = j2;
        nVar.f284b = z2 ? n.a.kDown : n.a.kUp;
        nVar.f286d = l2.longValue();
        nVar.f285c = l3.longValue();
        nVar.f288f = null;
        nVar.f287e = true;
        if (l3.longValue() != 0 && l2.longValue() != 0) {
            if (!z2) {
                l2 = null;
            }
            q(l3, l2);
        }
        m(nVar, null);
    }

    @Override // io.flutter.embedding.android.s.d
    public void a(KeyEvent keyEvent, s.d.a aVar) {
        if (h(keyEvent, aVar)) {
            return;
        }
        p(true, 0L, 0L, 0L);
        aVar.a(true);
    }

    void n(t.d dVar, boolean z2, long j2, final long j3, final KeyEvent keyEvent, ArrayList<Runnable> arrayList) {
        t.c[] cVarArr = dVar.f323b;
        boolean[] zArr = new boolean[cVarArr.length];
        Boolean[] boolArr = new Boolean[cVarArr.length];
        boolean z3 = false;
        int i2 = 0;
        while (true) {
            t.c[] cVarArr2 = dVar.f323b;
            boolean z4 = true;
            if (i2 >= cVarArr2.length) {
                break;
            }
            final t.c cVar = cVarArr2[i2];
            zArr[i2] = this.f303b.containsKey(Long.valueOf(cVar.f320a));
            if (cVar.f321b == j2) {
                int i3 = a.f306a[e(keyEvent).ordinal()];
                if (i3 == 1) {
                    boolArr[i2] = Boolean.FALSE;
                    if (!z2) {
                        arrayList.add(new Runnable() { // from class: io.flutter.embedding.android.o
                            @Override // java.lang.Runnable
                            public final void run() {
                                r.this.k(cVar, j3, keyEvent);
                            }
                        });
                    }
                } else if (i3 == 2) {
                    boolArr[i2] = Boolean.valueOf(zArr[i2]);
                } else if (i3 == 3) {
                    if (!z2) {
                        arrayList.add(new Runnable() { // from class: io.flutter.embedding.android.p
                            @Override // java.lang.Runnable
                            public final void run() {
                                r.this.l(cVar, keyEvent);
                            }
                        });
                    }
                    boolArr[i2] = Boolean.valueOf(zArr[i2]);
                }
                z3 = true;
            } else {
                if (!z3 && !zArr[i2]) {
                    z4 = false;
                }
                z3 = z4;
            }
            i2++;
        }
        if (z2) {
            for (int i4 = 0; i4 < dVar.f323b.length; i4++) {
                if (boolArr[i4] == null) {
                    if (z3) {
                        boolArr[i4] = Boolean.valueOf(zArr[i4]);
                    } else {
                        boolArr[i4] = Boolean.TRUE;
                        z3 = true;
                    }
                }
            }
            if (!z3) {
                boolArr[0] = Boolean.TRUE;
            }
        } else {
            for (int i5 = 0; i5 < dVar.f323b.length; i5++) {
                if (boolArr[i5] == null) {
                    boolArr[i5] = Boolean.FALSE;
                }
            }
        }
        for (int i6 = 0; i6 < dVar.f323b.length; i6++) {
            if (zArr[i6] != boolArr[i6].booleanValue()) {
                t.c cVar2 = dVar.f323b[i6];
                p(boolArr[i6].booleanValue(), Long.valueOf(cVar2.f321b), Long.valueOf(cVar2.f320a), keyEvent.getEventTime());
            }
        }
    }

    void o(t.e eVar, boolean z2, long j2, KeyEvent keyEvent) {
        if (eVar.f326c == j2 || eVar.f327d == z2) {
            return;
        }
        boolean z3 = !this.f303b.containsKey(Long.valueOf(eVar.f325b));
        if (z3) {
            eVar.f327d = !eVar.f327d;
        }
        p(z3, Long.valueOf(eVar.f326c), Long.valueOf(eVar.f325b), keyEvent.getEventTime());
        if (!z3) {
            eVar.f327d = !eVar.f327d;
        }
        p(!z3, Long.valueOf(eVar.f326c), Long.valueOf(eVar.f325b), keyEvent.getEventTime());
    }

    void q(Long l2, Long l3) {
        if (l3 != null) {
            if (this.f303b.put(l2, l3) != null) {
                throw new AssertionError("The key was not empty");
            }
        } else if (this.f303b.remove(l2) == null) {
            throw new AssertionError("The key was empty");
        }
    }
}
