package K;

import android.util.Log;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f263a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f264b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f265c;

    public /* synthetic */ k(int i2, Object obj, Object obj2) {
        this.f263a = i2;
        this.f265c = obj;
        this.f264b = obj2;
    }

    public final void a(String str, String str2, Object obj) {
        switch (this.f263a) {
            case 0:
                Log.e("RestorationChannel", "Error " + str + " while sending restoration data to framework: " + str2);
                break;
            default:
                ((F.f) this.f264b).a(((L.j) ((B.e) ((B.a) this.f265c).f5d).f10c).d(str, str2, obj));
                break;
        }
    }

    public void b() {
        ((F.f) this.f264b).a(null);
    }

    public final void c(Object obj) {
        switch (this.f263a) {
            case 0:
                ((l) this.f265c).f267b = (byte[]) this.f264b;
                break;
            default:
                ((F.f) this.f264b).a(((L.j) ((B.e) ((B.a) this.f265c).f5d).f10c).e(obj));
                break;
        }
    }
}
