package m0;

import b0.v;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b extends v {

    /* renamed from: d, reason: collision with root package name */
    private final int f942d;

    /* renamed from: e, reason: collision with root package name */
    private final int f943e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f944f;

    /* renamed from: g, reason: collision with root package name */
    private int f945g;

    public b(int i2, int i3, int i4) {
        this.f942d = i4;
        this.f943e = i3;
        boolean z2 = true;
        if (i4 <= 0 ? i2 < i3 : i2 > i3) {
            z2 = false;
        }
        this.f944f = z2;
        this.f945g = z2 ? i2 : i3;
    }

    @Override // b0.v
    public int a() {
        int i2 = this.f945g;
        if (i2 != this.f943e) {
            this.f945g = this.f942d + i2;
        } else {
            if (!this.f944f) {
                throw new NoSuchElementException();
            }
            this.f944f = false;
        }
        return i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f944f;
    }
}
