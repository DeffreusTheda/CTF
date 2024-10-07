package kotlin.ranges;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: ULongRange.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B \u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0096\u0002J\u0016\u0010\f\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\b\u001a\u00020\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u00020\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0005\u001a\u00020\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u000f"}, d2 = {"Lkotlin/ranges/ULongProgressionIterator;", "", "Lkotlin/ULong;", "first", "last", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "J", "hasNext", "", "next", "next-s-VKNKU", "()J", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class ULongProgressionIterator implements Iterator<ULong>, KMappedMarker {
    private final long finalElement;
    private boolean hasNext;
    private long next;
    private final long step;

    public /* synthetic */ ULongProgressionIterator(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:
    
        if (r0 >= 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0011, code lost:
    
        if (r0 <= 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001b, code lost:
    
        r1 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private ULongProgressionIterator(long r4, long r6, long r8) {
        /*
            r3 = this;
            r3.<init>()
            r3.finalElement = r6
            r0 = 0
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L14
            int r0 = kotlin.UByte$$ExternalSyntheticBackport4.m(r4, r6)
            if (r0 > 0) goto L1b
            goto L1a
        L14:
            int r0 = kotlin.UByte$$ExternalSyntheticBackport4.m(r4, r6)
            if (r0 < 0) goto L1b
        L1a:
            goto L1c
        L1b:
            r1 = r2
        L1c:
            r3.hasNext = r1
            long r0 = kotlin.ULong.m337constructorimpl(r8)
            r3.step = r0
            boolean r0 = r3.hasNext
            if (r0 == 0) goto L2a
            r0 = r4
            goto L2b
        L2a:
            r0 = r6
        L2b:
            r3.next = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.ULongProgressionIterator.<init>(long, long, long):void");
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ ULong next() {
        return ULong.m331boximpl(m1410nextsVKNKU());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    /* renamed from: next-s-VKNKU, reason: not valid java name */
    public long m1410nextsVKNKU() {
        long value = this.next;
        if (value == this.finalElement) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.next = ULong.m337constructorimpl(this.next + this.step);
        }
        return value;
    }
}
