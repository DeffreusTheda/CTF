package d0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final int f462a;

    /* renamed from: b, reason: collision with root package name */
    public final int f463b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f464c;

    /* renamed from: d, reason: collision with root package name */
    public int f465d;

    public b(int i2, int i3, int i4) {
        this.f462a = i4;
        this.f463b = i3;
        boolean z2 = false;
        if (i4 <= 0 ? i2 >= i3 : i2 <= i3) {
            z2 = true;
        }
        this.f464c = z2;
        this.f465d = z2 ? i2 : i3;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f464c;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i2 = this.f465d;
        if (i2 != this.f463b) {
            this.f465d = this.f462a + i2;
        } else {
            if (!this.f464c) {
                throw new NoSuchElementException();
            }
            this.f464c = false;
        }
        return Integer.valueOf(i2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
