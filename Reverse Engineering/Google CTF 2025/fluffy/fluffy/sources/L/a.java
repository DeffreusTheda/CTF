package L;

import android.util.Log;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f301a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f302b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f303c;

    public /* synthetic */ a(int i2, Object obj, Object obj2) {
        this.f301a = i2;
        this.f303c = obj;
        this.f302b = obj2;
    }

    @Override // L.d
    public final void a(ByteBuffer byteBuffer) {
        switch (this.f301a) {
            case 0:
                B.e eVar = (B.e) this.f303c;
                try {
                    ((b) this.f302b).d(((h) eVar.f10c).b(byteBuffer));
                    break;
                } catch (RuntimeException e2) {
                    Log.e("BasicMessageChannel#".concat((String) eVar.f9b), "Failed to handle message reply", e2);
                    return;
                }
            default:
                B.e eVar2 = (B.e) this.f303c;
                K.k kVar = (K.k) this.f302b;
                try {
                    if (byteBuffer == null) {
                        kVar.getClass();
                    } else {
                        try {
                            kVar.c(((j) eVar2.f10c).h(byteBuffer));
                        } catch (f e3) {
                            kVar.a(e3.f304b, e3.getMessage(), e3.f305c);
                        }
                    }
                    break;
                } catch (RuntimeException e4) {
                    Log.e("MethodChannel#".concat((String) eVar2.f9b), "Failed to handle method call result", e4);
                    return;
                }
        }
    }
}
