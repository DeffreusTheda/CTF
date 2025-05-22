package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.time.Duration;

/* compiled from: longSaturatedMath.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\"\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\"\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\n\u001a \u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a \u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\r\u0010\u0016\u001a\u00020\u0017*\u00020\u0001H\u0082\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"checkInfiniteSumDefined", "", "longNs", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "durationNs", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "saturatingAdd", "saturatingAdd-pTJri5U", "(JJ)J", "saturatingAddInHalves", "saturatingAddInHalves-pTJri5U", "saturatingDiff", "valueNs", "originNs", "saturatingFiniteDiff", "value1Ns", "value2Ns", "saturatingOriginsDiff", "origin1Ns", "origin2Ns", "isSaturated", "", "kotlin-stdlib"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LongSaturatedMathKt {
    /* renamed from: saturatingAdd-pTJri5U, reason: not valid java name */
    public static final long m1617saturatingAddpTJri5U(long longNs, long duration) {
        long durationNs = Duration.m1509getInWholeNanosecondsimpl(duration);
        if (((longNs - 1) | 1) == Long.MAX_VALUE) {
            return m1616checkInfiniteSumDefinedPjuGub4(longNs, duration, durationNs);
        }
        if ((1 | (durationNs - 1)) == Long.MAX_VALUE) {
            return m1618saturatingAddInHalvespTJri5U(longNs, duration);
        }
        long result = longNs + durationNs;
        if (((longNs ^ result) & (durationNs ^ result)) < 0) {
            return longNs < 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        return result;
    }

    /* renamed from: checkInfiniteSumDefined-PjuGub4, reason: not valid java name */
    private static final long m1616checkInfiniteSumDefinedPjuGub4(long longNs, long duration, long durationNs) {
        if (!Duration.m1521isInfiniteimpl(duration) || (longNs ^ durationNs) >= 0) {
            return longNs;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    /* renamed from: saturatingAddInHalves-pTJri5U, reason: not valid java name */
    private static final long m1618saturatingAddInHalvespTJri5U(long longNs, long duration) {
        long half = Duration.m1492divUwyO8pc(duration, 2);
        long $this$isSaturated$iv = Duration.m1509getInWholeNanosecondsimpl(half);
        if ((1 | ($this$isSaturated$iv - 1)) == Long.MAX_VALUE) {
            return (long) (longNs + Duration.m1532toDoubleimpl(duration, DurationUnit.NANOSECONDS));
        }
        return m1617saturatingAddpTJri5U(m1617saturatingAddpTJri5U(longNs, half), Duration.m1524minusLRDsOJo(duration, half));
    }

    public static final long saturatingDiff(long valueNs, long originNs) {
        if ((1 | (originNs - 1)) == Long.MAX_VALUE) {
            return Duration.m1541unaryMinusUwyO8pc(DurationKt.toDuration(originNs, DurationUnit.DAYS));
        }
        return saturatingFiniteDiff(valueNs, originNs);
    }

    public static final long saturatingOriginsDiff(long origin1Ns, long origin2Ns) {
        if (((origin2Ns - 1) | 1) == Long.MAX_VALUE) {
            return origin1Ns == origin2Ns ? Duration.INSTANCE.m1591getZEROUwyO8pc() : Duration.m1541unaryMinusUwyO8pc(DurationKt.toDuration(origin2Ns, DurationUnit.DAYS));
        }
        if ((1 | (origin1Ns - 1)) == Long.MAX_VALUE) {
            return DurationKt.toDuration(origin1Ns, DurationUnit.DAYS);
        }
        return saturatingFiniteDiff(origin1Ns, origin2Ns);
    }

    private static final long saturatingFiniteDiff(long value1Ns, long value2Ns) {
        long result = value1Ns - value2Ns;
        if (((result ^ value1Ns) & (~(result ^ value2Ns))) < 0) {
            long j = DurationKt.NANOS_IN_MILLIS;
            long resultMs = (value1Ns / j) - (value2Ns / j);
            long resultNs = (value1Ns % j) - (value2Ns % j);
            Duration.Companion companion = Duration.INSTANCE;
            long duration = DurationKt.toDuration(resultMs, DurationUnit.MILLISECONDS);
            Duration.Companion companion2 = Duration.INSTANCE;
            return Duration.m1525plusLRDsOJo(duration, DurationKt.toDuration(resultNs, DurationUnit.NANOSECONDS));
        }
        Duration.Companion companion3 = Duration.INSTANCE;
        return DurationKt.toDuration(result, DurationUnit.NANOSECONDS);
    }

    private static final boolean isSaturated(long $this$isSaturated) {
        return (1 | ($this$isSaturated - 1)) == Long.MAX_VALUE;
    }
}
