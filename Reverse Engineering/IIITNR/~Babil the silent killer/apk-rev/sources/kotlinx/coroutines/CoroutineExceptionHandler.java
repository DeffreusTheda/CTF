package kotlinx.coroutines;

import c0.g;

/* loaded from: classes.dex */
public interface CoroutineExceptionHandler extends g.b {

    /* renamed from: b, reason: collision with root package name */
    public static final a f793b = a.f794d;

    public static final class a implements g.c<CoroutineExceptionHandler> {

        /* renamed from: d, reason: collision with root package name */
        static final /* synthetic */ a f794d = new a();

        private a() {
        }
    }

    void handleException(g gVar, Throwable th);
}
