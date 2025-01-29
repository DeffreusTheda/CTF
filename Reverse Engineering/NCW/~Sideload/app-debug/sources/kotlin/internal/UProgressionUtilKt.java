package kotlin.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.UByte$$ExternalSyntheticBackport3;
import kotlin.UInt;
import kotlin.ULong;

/* compiled from: UProgressionUtil.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0006\u001a*\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class UProgressionUtilKt {
    /* renamed from: differenceModulo-WZ9TVnA, reason: not valid java name */
    private static final int m1381differenceModuloWZ9TVnA(int a, int b, int c) {
        int compare;
        int ac = UByte$$ExternalSyntheticBackport0.m(a, c);
        int bc = UByte$$ExternalSyntheticBackport0.m(b, c);
        compare = Integer.compare(ac ^ Integer.MIN_VALUE, bc ^ Integer.MIN_VALUE);
        return UInt.m258constructorimpl(compare >= 0 ? ac - bc : UInt.m258constructorimpl(ac - bc) + c);
    }

    /* renamed from: differenceModulo-sambcqE, reason: not valid java name */
    private static final long m1382differenceModulosambcqE(long a, long b, long c) {
        int compare;
        long ac = UByte$$ExternalSyntheticBackport3.m(a, c);
        long bc = UByte$$ExternalSyntheticBackport3.m(b, c);
        compare = Long.compare(ac ^ Long.MIN_VALUE, bc ^ Long.MIN_VALUE);
        return ULong.m337constructorimpl(compare >= 0 ? ac - bc : ULong.m337constructorimpl(ac - bc) + c);
    }

    /* renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m1384getProgressionLastElementNkh28Cs(int start, int end, int step) {
        int compare;
        int compare2;
        if (step > 0) {
            compare2 = Integer.compare(start ^ Integer.MIN_VALUE, end ^ Integer.MIN_VALUE);
            if (compare2 < 0) {
                return UInt.m258constructorimpl(end - m1381differenceModuloWZ9TVnA(end, start, UInt.m258constructorimpl(step)));
            }
        } else {
            if (step >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            compare = Integer.compare(start ^ Integer.MIN_VALUE, end ^ Integer.MIN_VALUE);
            if (compare > 0) {
                return UInt.m258constructorimpl(m1381differenceModuloWZ9TVnA(start, end, UInt.m258constructorimpl(-step)) + end);
            }
        }
        return end;
    }

    /* renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m1383getProgressionLastElement7ftBX0g(long start, long end, long step) {
        int compare;
        int compare2;
        if (step > 0) {
            compare2 = Long.compare(start ^ Long.MIN_VALUE, end ^ Long.MIN_VALUE);
            if (compare2 < 0) {
                return ULong.m337constructorimpl(end - m1382differenceModulosambcqE(end, start, ULong.m337constructorimpl(step)));
            }
        } else {
            if (step >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            compare = Long.compare(start ^ Long.MIN_VALUE, end ^ Long.MIN_VALUE);
            if (compare > 0) {
                return ULong.m337constructorimpl(m1382differenceModulosambcqE(start, end, ULong.m337constructorimpl(-step)) + end);
            }
        }
        return end;
    }
}
