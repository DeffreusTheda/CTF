package L;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class n implements h {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f312a = Charset.forName("UTF8");

    /* renamed from: b, reason: collision with root package name */
    public static final n f313b = new n();

    public static String a(ByteBuffer byteBuffer) {
        byte[] bArr;
        int i2;
        if (byteBuffer == null) {
            return null;
        }
        int remaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            bArr = byteBuffer.array();
            i2 = byteBuffer.arrayOffset();
        } else {
            bArr = new byte[remaining];
            byteBuffer.get(bArr);
            i2 = 0;
        }
        return new String(bArr, i2, remaining, f312a);
    }

    public static ByteBuffer d(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(f312a);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bytes.length);
        allocateDirect.put(bytes);
        return allocateDirect;
    }

    @Override // L.h
    public final /* bridge */ /* synthetic */ Object b(ByteBuffer byteBuffer) {
        return a(byteBuffer);
    }

    @Override // L.h
    public final /* bridge */ /* synthetic */ ByteBuffer c(Object obj) {
        return d((String) obj);
    }
}
