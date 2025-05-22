package l0;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.i;

/* loaded from: classes.dex */
public final class a extends k0.a {
    @Override // k0.a
    public Random c() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        i.d(current, "ThreadLocalRandom.current()");
        return current;
    }
}
