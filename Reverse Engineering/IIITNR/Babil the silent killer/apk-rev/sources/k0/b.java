package k0;

import java.util.Random;
import kotlin.jvm.internal.i;

/* loaded from: classes.dex */
public final class b extends k0.a {

    /* renamed from: f, reason: collision with root package name */
    private final a f770f = new a();

    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // k0.a
    public Random c() {
        Random random = this.f770f.get();
        i.d(random, "implStorage.get()");
        return random;
    }
}
