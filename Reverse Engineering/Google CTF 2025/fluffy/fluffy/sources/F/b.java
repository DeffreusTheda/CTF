package F;

import D.v;
import android.content.res.AssetManager;
import android.os.Trace;
import android.util.Log;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class b implements L.e {

    /* renamed from: b, reason: collision with root package name */
    public final FlutterJNI f173b;

    /* renamed from: c, reason: collision with root package name */
    public final AssetManager f174c;

    /* renamed from: d, reason: collision with root package name */
    public final long f175d;

    /* renamed from: e, reason: collision with root package name */
    public final g f176e;

    /* renamed from: f, reason: collision with root package name */
    public final v f177f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f178g;

    public b(FlutterJNI flutterJNI, AssetManager assetManager, long j2) {
        this.f178g = false;
        v vVar = new v(2, this);
        this.f173b = flutterJNI;
        this.f174c = assetManager;
        this.f175d = j2;
        g gVar = new g(flutterJNI);
        this.f176e = gVar;
        gVar.c("flutter/isolate", vVar);
        this.f177f = new v(3, gVar);
        if (flutterJNI.isAttached()) {
            this.f178g = true;
        }
    }

    @Override // L.e
    public final void a(String str, ByteBuffer byteBuffer, L.d dVar) {
        this.f177f.a(str, byteBuffer, dVar);
    }

    public final void b(a aVar, List list) {
        if (this.f178g) {
            Log.w("DartExecutor", "Attempted to run a DartExecutor that is already running.");
            return;
        }
        P.a.b("DartExecutor#executeDartEntrypoint");
        try {
            Objects.toString(aVar);
            this.f173b.runBundleAndSnapshotFromLibrary(aVar.f170a, aVar.f172c, aVar.f171b, this.f174c, list, this.f175d);
            this.f178g = true;
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // L.e
    public final void d(String str, L.c cVar) {
        this.f177f.d(str, cVar);
    }
}
