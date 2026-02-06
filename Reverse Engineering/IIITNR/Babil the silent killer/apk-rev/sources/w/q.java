package w;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class q implements g<String> {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f1415a = Charset.forName("UTF8");

    /* renamed from: b, reason: collision with root package name */
    public static final q f1416b = new q();

    private q() {
    }

    @Override // w.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String a(ByteBuffer byteBuffer) {
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
        return new String(bArr, i2, remaining, f1415a);
    }

    @Override // w.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ByteBuffer b(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(f1415a);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bytes.length);
        allocateDirect.put(bytes);
        return allocateDirect;
    }
}
