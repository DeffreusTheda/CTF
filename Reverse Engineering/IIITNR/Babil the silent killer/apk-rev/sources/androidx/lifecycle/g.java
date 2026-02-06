package androidx.lifecycle;

import androidx.lifecycle.c;
import androidx.window.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class g extends c {

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<f> f65d;

    /* renamed from: b, reason: collision with root package name */
    private a.a<e, b> f63b = new a.a<>();

    /* renamed from: e, reason: collision with root package name */
    private int f66e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f67f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f68g = false;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<c.b> f69h = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private c.b f64c = c.b.INITIALIZED;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f70a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f71b;

        static {
            int[] iArr = new int[c.b.values().length];
            f71b = iArr;
            try {
                iArr[c.b.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f71b[c.b.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f71b[c.b.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f71b[c.b.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f71b[c.b.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[c.a.values().length];
            f70a = iArr2;
            try {
                iArr2[c.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f70a[c.a.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f70a[c.a.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f70a[c.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f70a[c.a.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f70a[c.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f70a[c.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        c.b f72a;

        /* renamed from: b, reason: collision with root package name */
        d f73b;

        void a(f fVar, c.a aVar) {
            c.b f2 = g.f(aVar);
            this.f72a = g.i(this.f72a, f2);
            this.f73b.g(fVar, aVar);
            this.f72a = f2;
        }
    }

    public g(f fVar) {
        this.f65d = new WeakReference<>(fVar);
    }

    private void c(f fVar) {
        Iterator<Map.Entry<e, b>> a2 = this.f63b.a();
        while (a2.hasNext() && !this.f68g) {
            Map.Entry<e, b> next = a2.next();
            b value = next.getValue();
            while (value.f72a.compareTo(this.f64c) > 0 && !this.f68g && this.f63b.contains(next.getKey())) {
                c.a d2 = d(value.f72a);
                l(f(d2));
                value.a(fVar, d2);
                k();
            }
        }
    }

    private static c.a d(c.b bVar) {
        int i2 = a.f71b[bVar.ordinal()];
        if (i2 == 1) {
            throw new IllegalArgumentException();
        }
        if (i2 == 2) {
            return c.a.ON_DESTROY;
        }
        if (i2 == 3) {
            return c.a.ON_STOP;
        }
        if (i2 == 4) {
            return c.a.ON_PAUSE;
        }
        if (i2 == 5) {
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException("Unexpected state value " + bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e(f fVar) {
        a.b<e, b>.d d2 = this.f63b.d();
        while (d2.hasNext() && !this.f68g) {
            Map.Entry next = d2.next();
            b bVar = (b) next.getValue();
            while (bVar.f72a.compareTo(this.f64c) < 0 && !this.f68g && this.f63b.contains(next.getKey())) {
                l(bVar.f72a);
                bVar.a(fVar, n(bVar.f72a));
                k();
            }
        }
    }

    static c.b f(c.a aVar) {
        switch (a.f70a[aVar.ordinal()]) {
            case 1:
            case 2:
                return c.b.CREATED;
            case 3:
            case 4:
                return c.b.STARTED;
            case R.styleable.SplitPairRule_splitMinWidth /* 5 */:
                return c.b.RESUMED;
            case R.styleable.SplitPairRule_splitRatio /* 6 */:
                return c.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private boolean h() {
        if (this.f63b.size() == 0) {
            return true;
        }
        c.b bVar = this.f63b.b().getValue().f72a;
        c.b bVar2 = this.f63b.e().getValue().f72a;
        return bVar == bVar2 && this.f64c == bVar2;
    }

    static c.b i(c.b bVar, c.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    private void j(c.b bVar) {
        if (this.f64c == bVar) {
            return;
        }
        this.f64c = bVar;
        if (this.f67f || this.f66e != 0) {
            this.f68g = true;
            return;
        }
        this.f67f = true;
        m();
        this.f67f = false;
    }

    private void k() {
        this.f69h.remove(r0.size() - 1);
    }

    private void l(c.b bVar) {
        this.f69h.add(bVar);
    }

    private void m() {
        f fVar = this.f65d.get();
        if (fVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            boolean h2 = h();
            this.f68g = false;
            if (h2) {
                return;
            }
            if (this.f64c.compareTo(this.f63b.b().getValue().f72a) < 0) {
                c(fVar);
            }
            Map.Entry<e, b> e2 = this.f63b.e();
            if (!this.f68g && e2 != null && this.f64c.compareTo(e2.getValue().f72a) > 0) {
                e(fVar);
            }
        }
    }

    private static c.a n(c.b bVar) {
        int i2 = a.f71b[bVar.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return c.a.ON_START;
            }
            if (i2 == 3) {
                return c.a.ON_RESUME;
            }
            if (i2 == 4) {
                throw new IllegalArgumentException();
            }
            if (i2 != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return c.a.ON_CREATE;
    }

    @Override // androidx.lifecycle.c
    public c.b a() {
        return this.f64c;
    }

    @Override // androidx.lifecycle.c
    public void b(e eVar) {
        this.f63b.f(eVar);
    }

    public void g(c.a aVar) {
        j(f(aVar));
    }
}
