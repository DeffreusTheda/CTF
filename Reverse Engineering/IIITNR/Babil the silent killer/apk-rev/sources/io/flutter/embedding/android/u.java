package io.flutter.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: c, reason: collision with root package name */
    private static u f328c;

    /* renamed from: a, reason: collision with root package name */
    private final LongSparseArray<MotionEvent> f329a = new LongSparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private final PriorityQueue<Long> f330b = new PriorityQueue<>();

    public static class a {

        /* renamed from: b, reason: collision with root package name */
        private static final AtomicLong f331b = new AtomicLong(0);

        /* renamed from: a, reason: collision with root package name */
        private final long f332a;

        private a(long j2) {
            this.f332a = j2;
        }

        public static a b() {
            return c(f331b.incrementAndGet());
        }

        public static a c(long j2) {
            return new a(j2);
        }

        public long d() {
            return this.f332a;
        }
    }

    private u() {
    }

    public static u a() {
        if (f328c == null) {
            f328c = new u();
        }
        return f328c;
    }

    public MotionEvent b(a aVar) {
        while (!this.f330b.isEmpty() && this.f330b.peek().longValue() < aVar.f332a) {
            this.f329a.remove(this.f330b.poll().longValue());
        }
        if (!this.f330b.isEmpty() && this.f330b.peek().longValue() == aVar.f332a) {
            this.f330b.poll();
        }
        MotionEvent motionEvent = this.f329a.get(aVar.f332a);
        this.f329a.remove(aVar.f332a);
        return motionEvent;
    }

    public a c(MotionEvent motionEvent) {
        a b2 = a.b();
        this.f329a.put(b2.f332a, MotionEvent.obtain(motionEvent));
        this.f330b.add(Long.valueOf(b2.f332a));
        return b2;
    }
}
