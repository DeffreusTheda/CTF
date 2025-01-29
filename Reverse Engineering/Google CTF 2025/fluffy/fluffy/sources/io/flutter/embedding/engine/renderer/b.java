package io.flutter.embedding.engine.renderer;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class b implements androidx.lifecycle.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f596a;

    public b(j jVar) {
        this.f596a = jVar;
    }

    public final void a() {
        Iterator it = this.f596a.f632f.iterator();
        while (it.hasNext()) {
            FlutterRenderer$ImageReaderSurfaceProducer.access$200((FlutterRenderer$ImageReaderSurfaceProducer) it.next());
        }
    }
}
