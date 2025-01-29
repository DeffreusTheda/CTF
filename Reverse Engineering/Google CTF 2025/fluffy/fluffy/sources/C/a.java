package C;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final class a implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public int f11a;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        StringBuilder sb = new StringBuilder("flutter-worker-");
        int i2 = this.f11a;
        this.f11a = i2 + 1;
        sb.append(i2);
        thread.setName(sb.toString());
        return thread;
    }
}
