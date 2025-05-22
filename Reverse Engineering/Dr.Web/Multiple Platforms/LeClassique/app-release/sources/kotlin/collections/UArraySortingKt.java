package kotlin.collections;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UArraySorting.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0014\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0016\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0018\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class UArraySortingKt {
    /* renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m581partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte m201getw2LRezQ = UByteArray.m201getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int m201getw2LRezQ2 = UByteArray.m201getw2LRezQ(bArr, i) & UByte.MAX_VALUE;
                i3 = m201getw2LRezQ & UByte.MAX_VALUE;
                if (Intrinsics.compare(m201getw2LRezQ2, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m201getw2LRezQ(bArr, i2) & UByte.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte m201getw2LRezQ3 = UByteArray.m201getw2LRezQ(bArr, i);
                UByteArray.m206setVurrAj0(bArr, i, UByteArray.m201getw2LRezQ(bArr, i2));
                UByteArray.m206setVurrAj0(bArr, i2, m201getw2LRezQ3);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m585quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int m581partition4UcCI2c = m581partition4UcCI2c(bArr, i, i2);
        int i3 = m581partition4UcCI2c - 1;
        if (i < i3) {
            m585quickSort4UcCI2c(bArr, i, i3);
        }
        if (m581partition4UcCI2c < i2) {
            m585quickSort4UcCI2c(bArr, m581partition4UcCI2c, i2);
        }
    }

    /* renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m582partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short m464getMh2AYeg = UShortArray.m464getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int m464getMh2AYeg2 = UShortArray.m464getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = m464getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(m464getMh2AYeg2, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m464getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short m464getMh2AYeg3 = UShortArray.m464getMh2AYeg(sArr, i);
                UShortArray.m469set01HTLdE(sArr, i, UShortArray.m464getMh2AYeg(sArr, i2));
                UShortArray.m469set01HTLdE(sArr, i2, m464getMh2AYeg3);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m586quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int m582partitionAa5vz7o = m582partitionAa5vz7o(sArr, i, i2);
        int i3 = m582partitionAa5vz7o - 1;
        if (i < i3) {
            m586quickSortAa5vz7o(sArr, i, i3);
        }
        if (m582partitionAa5vz7o < i2) {
            m586quickSortAa5vz7o(sArr, m582partitionAa5vz7o, i2);
        }
    }

    /* renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m583partitionoBK06Vg(int[] iArr, int i, int i2) {
        int m280getpVg5ArA = UIntArray.m280getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (Integer.compareUnsigned(UIntArray.m280getpVg5ArA(iArr, i), m280getpVg5ArA) < 0) {
                i++;
            }
            while (Integer.compareUnsigned(UIntArray.m280getpVg5ArA(iArr, i2), m280getpVg5ArA) > 0) {
                i2--;
            }
            if (i <= i2) {
                int m280getpVg5ArA2 = UIntArray.m280getpVg5ArA(iArr, i);
                UIntArray.m285setVXSXFK8(iArr, i, UIntArray.m280getpVg5ArA(iArr, i2));
                UIntArray.m285setVXSXFK8(iArr, i2, m280getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m587quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int m583partitionoBK06Vg = m583partitionoBK06Vg(iArr, i, i2);
        int i3 = m583partitionoBK06Vg - 1;
        if (i < i3) {
            m587quickSortoBK06Vg(iArr, i, i3);
        }
        if (m583partitionoBK06Vg < i2) {
            m587quickSortoBK06Vg(iArr, m583partitionoBK06Vg, i2);
        }
    }

    /* renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m580partitionnroSd4(long[] jArr, int i, int i2) {
        long m359getsVKNKU = ULongArray.m359getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (Long.compareUnsigned(ULongArray.m359getsVKNKU(jArr, i), m359getsVKNKU) < 0) {
                i++;
            }
            while (Long.compareUnsigned(ULongArray.m359getsVKNKU(jArr, i2), m359getsVKNKU) > 0) {
                i2--;
            }
            if (i <= i2) {
                long m359getsVKNKU2 = ULongArray.m359getsVKNKU(jArr, i);
                ULongArray.m364setk8EXiF4(jArr, i, ULongArray.m359getsVKNKU(jArr, i2));
                ULongArray.m364setk8EXiF4(jArr, i2, m359getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m584quickSortnroSd4(long[] jArr, int i, int i2) {
        int m580partitionnroSd4 = m580partitionnroSd4(jArr, i, i2);
        int i3 = m580partitionnroSd4 - 1;
        if (i < i3) {
            m584quickSortnroSd4(jArr, i, i3);
        }
        if (m580partitionnroSd4 < i2) {
            m584quickSortnroSd4(jArr, m580partitionnroSd4, i2);
        }
    }

    /* renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m589sortArray4UcCI2c(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m585quickSort4UcCI2c(array, i, i2 - 1);
    }

    /* renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m590sortArrayAa5vz7o(short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m586quickSortAa5vz7o(array, i, i2 - 1);
    }

    /* renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m591sortArrayoBK06Vg(int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m587quickSortoBK06Vg(array, i, i2 - 1);
    }

    /* renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m588sortArraynroSd4(long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m584quickSortnroSd4(array, i, i2 - 1);
    }
}
