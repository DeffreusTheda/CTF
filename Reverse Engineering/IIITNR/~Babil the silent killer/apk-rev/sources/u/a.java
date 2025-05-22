package u;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.view.d;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class a implements io.flutter.view.d {

    /* renamed from: a, reason: collision with root package name */
    private final FlutterJNI f1135a;

    /* renamed from: c, reason: collision with root package name */
    private Surface f1137c;

    /* renamed from: g, reason: collision with root package name */
    private final u.b f1141g;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicLong f1136b = new AtomicLong(0);

    /* renamed from: d, reason: collision with root package name */
    private boolean f1138d = false;

    /* renamed from: e, reason: collision with root package name */
    private Handler f1139e = new Handler();

    /* renamed from: f, reason: collision with root package name */
    private final Set<WeakReference<d.b>> f1140f = new HashSet();

    /* renamed from: u.a$a, reason: collision with other inner class name */
    class C0028a implements u.b {
        C0028a() {
        }

        @Override // u.b
        public void c() {
            a.this.f1138d = true;
        }

        @Override // u.b
        public void e() {
            a.this.f1138d = false;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Rect f1143a;

        /* renamed from: b, reason: collision with root package name */
        public final d f1144b;

        /* renamed from: c, reason: collision with root package name */
        public final c f1145c;

        public b(Rect rect, d dVar) {
            this.f1143a = rect;
            this.f1144b = dVar;
            this.f1145c = c.UNKNOWN;
        }

        public b(Rect rect, d dVar, c cVar) {
            this.f1143a = rect;
            this.f1144b = dVar;
            this.f1145c = cVar;
        }
    }

    public enum c {
        UNKNOWN(0),
        POSTURE_FLAT(1),
        POSTURE_HALF_OPENED(2);


        /* renamed from: d, reason: collision with root package name */
        public final int f1150d;

        c(int i2) {
            this.f1150d = i2;
        }
    }

    public enum d {
        UNKNOWN(0),
        FOLD(1),
        HINGE(2),
        CUTOUT(3);


        /* renamed from: d, reason: collision with root package name */
        public final int f1156d;

        d(int i2) {
            this.f1156d = i2;
        }
    }

    static final class e implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final long f1157d;

        /* renamed from: e, reason: collision with root package name */
        private final FlutterJNI f1158e;

        e(long j2, FlutterJNI flutterJNI) {
            this.f1157d = j2;
            this.f1158e = flutterJNI;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1158e.isAttached()) {
                j.b.f("FlutterRenderer", "Releasing a SurfaceTexture (" + this.f1157d + ").");
                this.f1158e.unregisterTexture(this.f1157d);
            }
        }
    }

    final class f implements d.c, d.b {

        /* renamed from: a, reason: collision with root package name */
        private final long f1159a;

        /* renamed from: b, reason: collision with root package name */
        private final SurfaceTextureWrapper f1160b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f1161c;

        /* renamed from: d, reason: collision with root package name */
        private d.b f1162d;

        /* renamed from: e, reason: collision with root package name */
        private d.a f1163e;

        /* renamed from: f, reason: collision with root package name */
        private final Runnable f1164f;

        /* renamed from: g, reason: collision with root package name */
        private SurfaceTexture.OnFrameAvailableListener f1165g;

        /* renamed from: u.a$f$a, reason: collision with other inner class name */
        class RunnableC0029a implements Runnable {
            RunnableC0029a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (f.this.f1163e != null) {
                    f.this.f1163e.a();
                }
            }
        }

        class b implements SurfaceTexture.OnFrameAvailableListener {
            b() {
            }

            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                if (f.this.f1161c || !a.this.f1135a.isAttached()) {
                    return;
                }
                f fVar = f.this;
                a.this.l(fVar.f1159a);
            }
        }

        f(long j2, SurfaceTexture surfaceTexture) {
            RunnableC0029a runnableC0029a = new RunnableC0029a();
            this.f1164f = runnableC0029a;
            this.f1165g = new b();
            this.f1159a = j2;
            this.f1160b = new SurfaceTextureWrapper(surfaceTexture, runnableC0029a);
            if (Build.VERSION.SDK_INT >= 21) {
                d().setOnFrameAvailableListener(this.f1165g, new Handler());
            } else {
                d().setOnFrameAvailableListener(this.f1165g);
            }
        }

        @Override // io.flutter.view.d.c
        public void a(d.b bVar) {
            this.f1162d = bVar;
        }

        @Override // io.flutter.view.d.c
        public long b() {
            return this.f1159a;
        }

        @Override // io.flutter.view.d.c
        public void c(d.a aVar) {
            this.f1163e = aVar;
        }

        @Override // io.flutter.view.d.c
        public SurfaceTexture d() {
            return this.f1160b.surfaceTexture();
        }

        protected void finalize() {
            try {
                if (this.f1161c) {
                    return;
                }
                a.this.f1139e.post(new e(this.f1159a, a.this.f1135a));
            } finally {
                super.finalize();
            }
        }

        public SurfaceTextureWrapper h() {
            return this.f1160b;
        }

        @Override // io.flutter.view.d.b
        public void onTrimMemory(int i2) {
            d.b bVar = this.f1162d;
            if (bVar != null) {
                bVar.onTrimMemory(i2);
            }
        }
    }

    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public float f1169a = 1.0f;

        /* renamed from: b, reason: collision with root package name */
        public int f1170b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f1171c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f1172d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f1173e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f1174f = 0;

        /* renamed from: g, reason: collision with root package name */
        public int f1175g = 0;

        /* renamed from: h, reason: collision with root package name */
        public int f1176h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f1177i = 0;

        /* renamed from: j, reason: collision with root package name */
        public int f1178j = 0;

        /* renamed from: k, reason: collision with root package name */
        public int f1179k = 0;

        /* renamed from: l, reason: collision with root package name */
        public int f1180l = 0;

        /* renamed from: m, reason: collision with root package name */
        public int f1181m = 0;

        /* renamed from: n, reason: collision with root package name */
        public int f1182n = 0;

        /* renamed from: o, reason: collision with root package name */
        public int f1183o = 0;

        /* renamed from: p, reason: collision with root package name */
        public int f1184p = -1;

        /* renamed from: q, reason: collision with root package name */
        public List<b> f1185q = new ArrayList();

        boolean a() {
            return this.f1170b > 0 && this.f1171c > 0 && this.f1169a > 0.0f;
        }
    }

    public a(FlutterJNI flutterJNI) {
        C0028a c0028a = new C0028a();
        this.f1141g = c0028a;
        this.f1135a = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(c0028a);
    }

    private void h() {
        Iterator<WeakReference<d.b>> it = this.f1140f.iterator();
        while (it.hasNext()) {
            if (it.next().get() == null) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(long j2) {
        this.f1135a.markTextureFrameAvailable(j2);
    }

    private void o(long j2, SurfaceTextureWrapper surfaceTextureWrapper) {
        this.f1135a.registerTexture(j2, surfaceTextureWrapper);
    }

    @Override // io.flutter.view.d
    public d.c a() {
        j.b.f("FlutterRenderer", "Creating a SurfaceTexture.");
        return n(new SurfaceTexture(0));
    }

    public void f(u.b bVar) {
        this.f1135a.addIsDisplayingFlutterUiListener(bVar);
        if (this.f1138d) {
            bVar.c();
        }
    }

    void g(d.b bVar) {
        h();
        this.f1140f.add(new WeakReference<>(bVar));
    }

    public void i(ByteBuffer byteBuffer, int i2) {
        this.f1135a.dispatchPointerDataPacket(byteBuffer, i2);
    }

    public boolean j() {
        return this.f1138d;
    }

    public boolean k() {
        return this.f1135a.getIsSoftwareRenderingEnabled();
    }

    public void m(int i2) {
        Iterator<WeakReference<d.b>> it = this.f1140f.iterator();
        while (it.hasNext()) {
            d.b bVar = it.next().get();
            if (bVar != null) {
                bVar.onTrimMemory(i2);
            } else {
                it.remove();
            }
        }
    }

    public d.c n(SurfaceTexture surfaceTexture) {
        surfaceTexture.detachFromGLContext();
        f fVar = new f(this.f1136b.getAndIncrement(), surfaceTexture);
        j.b.f("FlutterRenderer", "New SurfaceTexture ID: " + fVar.b());
        o(fVar.b(), fVar.h());
        g(fVar);
        return fVar;
    }

    public void p(u.b bVar) {
        this.f1135a.removeIsDisplayingFlutterUiListener(bVar);
    }

    public void q(boolean z2) {
        this.f1135a.setSemanticsEnabled(z2);
    }

    public void r(g gVar) {
        if (gVar.a()) {
            j.b.f("FlutterRenderer", "Setting viewport metrics\nSize: " + gVar.f1170b + " x " + gVar.f1171c + "\nPadding - L: " + gVar.f1175g + ", T: " + gVar.f1172d + ", R: " + gVar.f1173e + ", B: " + gVar.f1174f + "\nInsets - L: " + gVar.f1179k + ", T: " + gVar.f1176h + ", R: " + gVar.f1177i + ", B: " + gVar.f1178j + "\nSystem Gesture Insets - L: " + gVar.f1183o + ", T: " + gVar.f1180l + ", R: " + gVar.f1181m + ", B: " + gVar.f1181m + "\nDisplay Features: " + gVar.f1185q.size());
            int[] iArr = new int[gVar.f1185q.size() * 4];
            int[] iArr2 = new int[gVar.f1185q.size()];
            int[] iArr3 = new int[gVar.f1185q.size()];
            for (int i2 = 0; i2 < gVar.f1185q.size(); i2++) {
                b bVar = gVar.f1185q.get(i2);
                int i3 = i2 * 4;
                Rect rect = bVar.f1143a;
                iArr[i3] = rect.left;
                iArr[i3 + 1] = rect.top;
                iArr[i3 + 2] = rect.right;
                iArr[i3 + 3] = rect.bottom;
                iArr2[i2] = bVar.f1144b.f1156d;
                iArr3[i2] = bVar.f1145c.f1150d;
            }
            this.f1135a.setViewportMetrics(gVar.f1169a, gVar.f1170b, gVar.f1171c, gVar.f1172d, gVar.f1173e, gVar.f1174f, gVar.f1175g, gVar.f1176h, gVar.f1177i, gVar.f1178j, gVar.f1179k, gVar.f1180l, gVar.f1181m, gVar.f1182n, gVar.f1183o, gVar.f1184p, iArr, iArr2, iArr3);
        }
    }

    public void s(Surface surface, boolean z2) {
        if (this.f1137c != null && !z2) {
            t();
        }
        this.f1137c = surface;
        this.f1135a.onSurfaceCreated(surface);
    }

    public void t() {
        this.f1135a.onSurfaceDestroyed();
        this.f1137c = null;
        if (this.f1138d) {
            this.f1141g.e();
        }
        this.f1138d = false;
    }

    public void u(int i2, int i3) {
        this.f1135a.onSurfaceChanged(i2, i3);
    }

    public void v(Surface surface) {
        this.f1137c = surface;
        this.f1135a.onSurfaceWindowChanged(surface);
    }
}
