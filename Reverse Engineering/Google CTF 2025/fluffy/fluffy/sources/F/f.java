package F;

import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class f implements L.d {

    /* renamed from: a, reason: collision with root package name */
    public final FlutterJNI f190a;

    /* renamed from: b, reason: collision with root package name */
    public final int f191b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f192c = new AtomicBoolean(false);

    public f(FlutterJNI flutterJNI, int i2) {
        this.f190a = flutterJNI;
        this.f191b = i2;
    }

    @Override // L.d
    public final void a(ByteBuffer byteBuffer) {
        if (this.f192c.getAndSet(true)) {
            throw new IllegalStateException("Reply already submitted");
        }
        int i2 = this.f191b;
        FlutterJNI flutterJNI = this.f190a;
        if (byteBuffer == null) {
            flutterJNI.invokePlatformMessageEmptyResponseCallback(i2);
        } else {
            flutterJNI.invokePlatformMessageResponseCallback(i2, byteBuffer, byteBuffer.position());
        }
    }
}
