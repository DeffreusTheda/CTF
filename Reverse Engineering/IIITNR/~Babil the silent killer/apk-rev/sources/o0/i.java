package o0;

import j0.l;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class i<T, R> implements b<R> {

    /* renamed from: a, reason: collision with root package name */
    private final b<T> f972a;

    /* renamed from: b, reason: collision with root package name */
    private final l<T, R> f973b;

    public static final class a implements Iterator<R> {

        /* renamed from: d, reason: collision with root package name */
        private final Iterator<T> f974d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ i<T, R> f975e;

        a(i<T, R> iVar) {
            this.f975e = iVar;
            this.f974d = ((i) iVar).f972a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f974d.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) ((i) this.f975e).f973b.invoke(this.f974d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(b<? extends T> sequence, l<? super T, ? extends R> transformer) {
        kotlin.jvm.internal.i.e(sequence, "sequence");
        kotlin.jvm.internal.i.e(transformer, "transformer");
        this.f972a = sequence;
        this.f973b = transformer;
    }

    @Override // o0.b
    public Iterator<R> iterator() {
        return new a(this);
    }
}
