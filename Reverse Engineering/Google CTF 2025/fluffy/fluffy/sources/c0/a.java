package c0;

import a0.h;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* loaded from: classes.dex */
public final class a extends b0.a {
    @Override // b0.a
    public final Random a() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        h.d(current, "current(...)");
        return current;
    }
}
