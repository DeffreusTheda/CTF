package K;

import D.v;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f266a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f267b;

    /* renamed from: c, reason: collision with root package name */
    public final B.e f268c;

    /* renamed from: d, reason: collision with root package name */
    public k f269d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f270e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f271f;

    public l(F.b bVar, boolean z2) {
        B.e eVar = new B.e(bVar, "flutter/restoration", L.m.f311a);
        this.f270e = false;
        this.f271f = false;
        v vVar = new v(17, this);
        this.f268c = eVar;
        this.f266a = z2;
        eVar.k(vVar);
    }

    public static HashMap a(byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("enabled", Boolean.TRUE);
        hashMap.put("data", bArr);
        return hashMap;
    }
}
