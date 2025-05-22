package p0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
final class c implements o0.b<m0.c> {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f976a;

    /* renamed from: b, reason: collision with root package name */
    private final int f977b;

    /* renamed from: c, reason: collision with root package name */
    private final int f978c;

    /* renamed from: d, reason: collision with root package name */
    private final j0.p<CharSequence, Integer, a0.j<Integer, Integer>> f979d;

    public static final class a implements Iterator<m0.c> {

        /* renamed from: d, reason: collision with root package name */
        private int f980d = -1;

        /* renamed from: e, reason: collision with root package name */
        private int f981e;

        /* renamed from: f, reason: collision with root package name */
        private int f982f;

        /* renamed from: g, reason: collision with root package name */
        private m0.c f983g;

        /* renamed from: h, reason: collision with root package name */
        private int f984h;

        a() {
            int e2;
            e2 = m0.f.e(c.this.f977b, 0, c.this.f976a.length());
            this.f981e = e2;
            this.f982f = e2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        
            if (r0 < r6.f985i.f978c) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.f982f
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f980d = r1
                r0 = 0
                r6.f983g = r0
                goto L99
            Lc:
                p0.c r0 = p0.c.this
                int r0 = p0.c.c(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f984h
                int r0 = r0 + r3
                r6.f984h = r0
                p0.c r4 = p0.c.this
                int r4 = p0.c.c(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f982f
                p0.c r4 = p0.c.this
                java.lang.CharSequence r4 = p0.c.b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                m0.c r0 = new m0.c
                int r1 = r6.f981e
                p0.c r4 = p0.c.this
                java.lang.CharSequence r4 = p0.c.b(r4)
                int r4 = p0.n.u(r4)
                r0.<init>(r1, r4)
            L42:
                r6.f983g = r0
            L44:
                r6.f982f = r2
                goto L97
            L47:
                p0.c r0 = p0.c.this
                j0.p r0 = p0.c.a(r0)
                p0.c r4 = p0.c.this
                java.lang.CharSequence r4 = p0.c.b(r4)
                int r5 = r6.f982f
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                a0.j r0 = (a0.j) r0
                if (r0 != 0) goto L73
                m0.c r0 = new m0.c
                int r1 = r6.f981e
                p0.c r4 = p0.c.this
                java.lang.CharSequence r4 = p0.c.b(r4)
                int r4 = p0.n.u(r4)
                r0.<init>(r1, r4)
                goto L42
            L73:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f981e
                m0.c r4 = m0.d.g(r4, r2)
                r6.f983g = r4
                int r2 = r2 + r0
                r6.f981e = r2
                if (r0 != 0) goto L95
                r1 = 1
            L95:
                int r2 = r2 + r1
                goto L44
            L97:
                r6.f980d = r3
            L99:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p0.c.a.a():void");
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public m0.c next() {
            if (this.f980d == -1) {
                a();
            }
            if (this.f980d == 0) {
                throw new NoSuchElementException();
            }
            m0.c cVar = this.f983g;
            kotlin.jvm.internal.i.c(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f983g = null;
            this.f980d = -1;
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f980d == -1) {
                a();
            }
            return this.f980d == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(CharSequence input, int i2, int i3, j0.p<? super CharSequence, ? super Integer, a0.j<Integer, Integer>> getNextMatch) {
        kotlin.jvm.internal.i.e(input, "input");
        kotlin.jvm.internal.i.e(getNextMatch, "getNextMatch");
        this.f976a = input;
        this.f977b = i2;
        this.f978c = i3;
        this.f979d = getNextMatch;
    }

    @Override // o0.b
    public Iterator<m0.c> iterator() {
        return new a();
    }
}
