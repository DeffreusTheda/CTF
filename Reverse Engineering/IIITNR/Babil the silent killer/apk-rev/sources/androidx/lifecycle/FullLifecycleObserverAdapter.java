package androidx.lifecycle;

import androidx.lifecycle.c;
import androidx.window.R;

/* loaded from: classes.dex */
class FullLifecycleObserverAdapter implements d {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.lifecycle.a f50a;

    /* renamed from: b, reason: collision with root package name */
    private final d f51b;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f52a;

        static {
            int[] iArr = new int[c.a.values().length];
            f52a = iArr;
            try {
                iArr[c.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52a[c.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52a[c.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f52a[c.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f52a[c.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f52a[c.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f52a[c.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // androidx.lifecycle.d
    public void g(f fVar, c.a aVar) {
        switch (a.f52a[aVar.ordinal()]) {
            case 1:
                this.f50a.e(fVar);
                break;
            case 2:
                this.f50a.f(fVar);
                break;
            case 3:
                this.f50a.a(fVar);
                break;
            case 4:
                this.f50a.b(fVar);
                break;
            case R.styleable.SplitPairRule_splitMinWidth /* 5 */:
                this.f50a.d(fVar);
                break;
            case R.styleable.SplitPairRule_splitRatio /* 6 */:
                this.f50a.c(fVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        d dVar = this.f51b;
        if (dVar != null) {
            dVar.g(fVar, aVar);
        }
    }
}
