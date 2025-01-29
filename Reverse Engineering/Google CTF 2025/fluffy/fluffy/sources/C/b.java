package c;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class b implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f443a = new AtomicInteger(0);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("arch_disk_io_" + this.f443a.getAndIncrement());
        return thread;
    }
}
