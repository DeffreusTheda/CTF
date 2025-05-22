package io.flutter.embedding.android;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    long f283a;

    /* renamed from: b, reason: collision with root package name */
    a f284b;

    /* renamed from: c, reason: collision with root package name */
    long f285c;

    /* renamed from: d, reason: collision with root package name */
    long f286d;

    /* renamed from: e, reason: collision with root package name */
    boolean f287e;

    /* renamed from: f, reason: collision with root package name */
    String f288f;

    public enum a {
        kDown(0),
        kUp(1),
        kRepeat(2);


        /* renamed from: d, reason: collision with root package name */
        private long f293d;

        a(long j2) {
            this.f293d = j2;
        }

        public long a() {
            return this.f293d;
        }
    }

    ByteBuffer a() {
        try {
            String str = this.f288f;
            byte[] bytes = str == null ? null : str.getBytes("UTF-8");
            int length = bytes == null ? 0 : bytes.length;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(length + 48);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            allocateDirect.putLong(length);
            allocateDirect.putLong(this.f283a);
            allocateDirect.putLong(this.f284b.a());
            allocateDirect.putLong(this.f285c);
            allocateDirect.putLong(this.f286d);
            allocateDirect.putLong(this.f287e ? 1L : 0L);
            if (bytes != null) {
                allocateDirect.put(bytes);
            }
            return allocateDirect;
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError("UTF-8 not supported");
        }
    }
}
