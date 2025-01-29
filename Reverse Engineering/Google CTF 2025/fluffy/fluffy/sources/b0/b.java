package b0;

import java.util.Random;

/* loaded from: classes.dex */
public final class b extends ThreadLocal {
    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        return new Random();
    }
}
