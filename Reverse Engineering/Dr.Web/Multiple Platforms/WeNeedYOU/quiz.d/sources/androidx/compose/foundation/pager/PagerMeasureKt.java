package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayoutKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: PagerMeasure.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000bH\u0002\u001a@\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000bH\u0002\u001a\u0017\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0082\b\u001a\u008c\u0001\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014*\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002\u001am\u0010\n\u001a\u00020\u0004*\u00020\u00152\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\u0006\u0010 \u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103\u001aä\u0001\u00104\u001a\u000205*\u00020\u00152\u0006\u00106\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020'2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010 \u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032/\u0010?\u001a+\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\u0002\bB\u0012\u0004\u0012\u00020C0@H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bD\u0010E\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006F"}, d2 = {"DEBUG", "", "createPagesAfterList", "", "Landroidx/compose/foundation/pager/MeasuredPage;", "currentLastPage", "", "pagesCount", "beyondBoundsPageCount", "pinnedPages", "getAndMeasure", "Lkotlin/Function1;", "createPagesBeforeList", "currentFirstPage", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "calculatePagesOffsets", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "pages", "extraPagesBefore", "extraPagesAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "pagesScrollOffset", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "spaceBetweenPages", "pageAvailableSize", "index", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "pagerItemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "visualPageOffset", "Landroidx/compose/ui/unit/IntOffset;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getAndMeasure-SGf7dI0", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJLandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZI)Landroidx/compose/foundation/pager/MeasuredPage;", "measurePager", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "pageCount", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "firstVisiblePage", "firstVisiblePageOffset", "scrollToBeConsumed", "", "constraints", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measurePager-ntgEbfI", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;IIIIIIFJLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ZJIILjava/util/List;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/pager/PagerMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PagerMeasureKt {
    private static final boolean DEBUG = false;

    private static final int calculatePagesOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: measurePager-ntgEbfI, reason: not valid java name */
    public static final PagerMeasureResult m745measurePagerntgEbfI(final LazyLayoutMeasureScope measurePager, int i, final PagerLazyLayoutItemProvider pagerItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, final Orientation orientation, final Alignment.Vertical vertical, final Alignment.Horizontal horizontal, final boolean z, final long j2, final int i8, int i9, List<Integer> pinnedPages, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> layout) {
        int i10;
        int i11;
        int i12;
        int i13;
        ArrayDeque arrayDeque;
        int i14;
        int i15;
        ArrayDeque arrayDeque2;
        int i16;
        int i17;
        ArrayDeque arrayDeque3;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        MeasuredPage measuredPage;
        int i23;
        int i24;
        long j3;
        List<MeasuredPage> list;
        MeasuredPage measuredPage2;
        int i25;
        ArrayDeque arrayDeque4;
        Intrinsics.checkNotNullParameter(measurePager, "$this$measurePager");
        Intrinsics.checkNotNullParameter(pagerItemProvider, "pagerItemProvider");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(pinnedPages, "pinnedPages");
        Intrinsics.checkNotNullParameter(layout, "layout");
        if (i3 < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(i8 + i5, 0);
        if (i <= 0) {
            return new PagerMeasureResult(CollectionsKt.emptyList(), 0, i8, i5, i4, orientation, -i3, i2 + i4, false, 0.0f, null, null, 0, false, layout.invoke(Integer.valueOf(Constraints.m4963getMinWidthimpl(j)), Integer.valueOf(Constraints.m4962getMinHeightimpl(j)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }));
        }
        final long Constraints$default = ConstraintsKt.Constraints$default(0, orientation == Orientation.Vertical ? Constraints.m4961getMaxWidthimpl(j) : i8, 0, orientation != Orientation.Vertical ? Constraints.m4960getMaxHeightimpl(j) : i8, 5, null);
        int i26 = i6;
        if (i26 >= i) {
            i26 = i - 1;
            i10 = 0;
        } else {
            i10 = i7;
        }
        int roundToInt = MathKt.roundToInt(f);
        int i27 = i10 - roundToInt;
        if (i26 != 0 || i27 >= 0) {
            i11 = roundToInt;
        } else {
            i11 = roundToInt + i27;
            i27 = 0;
        }
        ArrayDeque arrayDeque5 = new ArrayDeque();
        int i28 = -i3;
        int i29 = i28 + (i5 < 0 ? i5 : 0);
        int i30 = i27 + i29;
        int i31 = 0;
        while (i30 < 0 && i26 > 0) {
            int i32 = i26 - 1;
            int i33 = coerceAtLeast;
            int i34 = i29;
            ArrayDeque arrayDeque6 = arrayDeque5;
            MeasuredPage m744getAndMeasureSGf7dI0 = m744getAndMeasureSGf7dI0(measurePager, i32, Constraints$default, pagerItemProvider, j2, orientation, horizontal, vertical, measurePager.getLayoutDirection(), z, i8);
            arrayDeque6.add(0, m744getAndMeasureSGf7dI0);
            i31 = Math.max(i31, m744getAndMeasureSGf7dI0.getCrossAxisSize());
            i30 += i33;
            coerceAtLeast = i33;
            arrayDeque5 = arrayDeque6;
            i26 = i32;
            i29 = i34;
        }
        int i35 = coerceAtLeast;
        int i36 = i29;
        ArrayDeque arrayDeque7 = arrayDeque5;
        int i37 = i30;
        if (i37 < i36) {
            i11 += i37;
            i37 = i36;
        }
        int i38 = i37 - i36;
        int i39 = i2;
        int i40 = i39 + i4;
        int coerceAtLeast2 = RangesKt.coerceAtLeast(i40, 0);
        int i41 = -i38;
        ArrayDeque arrayDeque8 = arrayDeque7;
        int size = arrayDeque8.size();
        int i42 = i26;
        for (int i43 = 0; i43 < size; i43++) {
            i42++;
            i41 += i35;
        }
        int i44 = i36;
        int i45 = i38;
        int i46 = i41;
        int i47 = i42;
        int i48 = i31;
        int i49 = i;
        int i50 = i26;
        while (true) {
            if (i47 >= i49) {
                i12 = i48;
                i13 = i47;
                arrayDeque = arrayDeque8;
                i14 = i40;
                i15 = i50;
                arrayDeque2 = arrayDeque7;
                i16 = i46;
                i17 = i2;
                break;
            }
            if (i46 >= coerceAtLeast2 && i46 > 0 && !arrayDeque7.isEmpty()) {
                i12 = i48;
                arrayDeque = arrayDeque8;
                i14 = i40;
                i17 = i39;
                i15 = i50;
                arrayDeque2 = arrayDeque7;
                i13 = i47;
                i16 = i46;
                break;
            }
            int i51 = i44;
            int i52 = i50;
            ArrayDeque arrayDeque9 = arrayDeque7;
            int i53 = i48;
            int i54 = i49;
            int i55 = i47;
            ArrayDeque arrayDeque10 = arrayDeque8;
            int i56 = coerceAtLeast2;
            int i57 = i40;
            MeasuredPage m744getAndMeasureSGf7dI02 = m744getAndMeasureSGf7dI0(measurePager, i47, Constraints$default, pagerItemProvider, j2, orientation, horizontal, vertical, measurePager.getLayoutDirection(), z, i8);
            i46 += i35;
            if (i46 <= i51) {
                i25 = i55;
                if (i25 != i54 - 1) {
                    i45 -= i35;
                    i50 = i25 + 1;
                    arrayDeque4 = arrayDeque9;
                    i48 = i53;
                    i47 = i25 + 1;
                    i39 = i2;
                    i49 = i54;
                    i44 = i51;
                    arrayDeque8 = arrayDeque10;
                    coerceAtLeast2 = i56;
                    arrayDeque7 = arrayDeque4;
                    i40 = i57;
                }
            } else {
                i25 = i55;
            }
            int max = Math.max(i53, m744getAndMeasureSGf7dI02.getCrossAxisSize());
            arrayDeque4 = arrayDeque9;
            arrayDeque4.add(m744getAndMeasureSGf7dI02);
            i50 = i52;
            i48 = max;
            i47 = i25 + 1;
            i39 = i2;
            i49 = i54;
            i44 = i51;
            arrayDeque8 = arrayDeque10;
            coerceAtLeast2 = i56;
            arrayDeque7 = arrayDeque4;
            i40 = i57;
        }
        if (i16 < i17) {
            int i58 = i17 - i16;
            i16 += i58;
            int i59 = i3;
            int i60 = i15;
            int i61 = i12;
            int i62 = i45 - i58;
            while (i62 < i59 && i60 > 0) {
                int i63 = i60 - 1;
                ArrayDeque arrayDeque11 = arrayDeque2;
                MeasuredPage m744getAndMeasureSGf7dI03 = m744getAndMeasureSGf7dI0(measurePager, i63, Constraints$default, pagerItemProvider, j2, orientation, horizontal, vertical, measurePager.getLayoutDirection(), z, i8);
                arrayDeque11.add(0, m744getAndMeasureSGf7dI03);
                i61 = Math.max(i61, m744getAndMeasureSGf7dI03.getCrossAxisSize());
                i62 += i35;
                i59 = i3;
                arrayDeque2 = arrayDeque11;
                i60 = i63;
                i13 = i13;
            }
            i20 = i61;
            int i64 = i62;
            arrayDeque3 = arrayDeque2;
            i18 = i13;
            int i65 = i11 + i58;
            if (i64 < 0) {
                i19 = i60;
                i16 += i64;
                i21 = i65 + i64;
                i22 = 0;
            } else {
                i19 = i60;
                i21 = i65;
                i22 = i64;
            }
        } else {
            arrayDeque3 = arrayDeque2;
            i18 = i13;
            i19 = i15;
            i20 = i12;
            i21 = i11;
            i22 = i45;
        }
        float f2 = (MathKt.getSign(MathKt.roundToInt(f)) != MathKt.getSign(i21) || Math.abs(MathKt.roundToInt(f)) < Math.abs(i21)) ? f : i21;
        if (i22 < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i66 = -i22;
        MeasuredPage measuredPage3 = (MeasuredPage) arrayDeque3.first();
        if (i3 > 0 || i5 < 0) {
            int size2 = arrayDeque3.size();
            int i67 = i22;
            int i68 = 0;
            while (i68 < size2 && i67 != 0) {
                int i69 = i35;
                if (i69 > i67 || i68 == CollectionsKt.getLastIndex(arrayDeque)) {
                    break;
                }
                i67 -= i69;
                i68++;
                measuredPage3 = (MeasuredPage) arrayDeque3.get(i68);
                i35 = i69;
            }
            measuredPage = measuredPage3;
            i23 = i67;
        } else {
            measuredPage = measuredPage3;
            i23 = i22;
        }
        int i70 = i20;
        MeasuredPage measuredPage4 = measuredPage;
        List<MeasuredPage> createPagesBeforeList = createPagesBeforeList(i19, i9, pinnedPages, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesBefore$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MeasuredPage invoke(int i71) {
                MeasuredPage m744getAndMeasureSGf7dI04;
                LazyLayoutMeasureScope lazyLayoutMeasureScope = LazyLayoutMeasureScope.this;
                m744getAndMeasureSGf7dI04 = PagerMeasureKt.m744getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i71, Constraints$default, pagerItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8);
                return m744getAndMeasureSGf7dI04;
            }
        });
        int size3 = createPagesBeforeList.size();
        int i71 = i70;
        for (int i72 = 0; i72 < size3; i72++) {
            i71 = Math.max(i71, createPagesBeforeList.get(i72).getCrossAxisSize());
        }
        ArrayDeque arrayDeque12 = arrayDeque3;
        int i73 = i16;
        List<MeasuredPage> createPagesAfterList = createPagesAfterList(((MeasuredPage) arrayDeque3.last()).getIndex(), i, i9, pinnedPages, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesAfter$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MeasuredPage invoke(int i74) {
                MeasuredPage m744getAndMeasureSGf7dI04;
                LazyLayoutMeasureScope lazyLayoutMeasureScope = LazyLayoutMeasureScope.this;
                m744getAndMeasureSGf7dI04 = PagerMeasureKt.m744getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i74, Constraints$default, pagerItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8);
                return m744getAndMeasureSGf7dI04;
            }
        });
        int size4 = createPagesAfterList.size();
        int i74 = i71;
        for (int i75 = 0; i75 < size4; i75++) {
            i74 = Math.max(i74, createPagesAfterList.get(i75).getCrossAxisSize());
        }
        boolean z2 = Intrinsics.areEqual(measuredPage4, arrayDeque12.first()) && createPagesBeforeList.isEmpty() && createPagesAfterList.isEmpty();
        if (orientation == Orientation.Vertical) {
            j3 = j;
            i24 = i74;
        } else {
            i24 = i73;
            j3 = j;
        }
        int m4975constrainWidthK40F9xA = ConstraintsKt.m4975constrainWidthK40F9xA(j3, i24);
        if (orientation == Orientation.Vertical) {
            i74 = i73;
        }
        int m4974constrainHeightK40F9xA = ConstraintsKt.m4974constrainHeightK40F9xA(j3, i74);
        LazyLayoutMeasureScope lazyLayoutMeasureScope = measurePager;
        int i76 = i18;
        final List<MeasuredPage> calculatePagesOffsets = calculatePagesOffsets(measurePager, arrayDeque, createPagesBeforeList, createPagesAfterList, m4975constrainWidthK40F9xA, m4974constrainHeightK40F9xA, i73, i2, i66, orientation, z, lazyLayoutMeasureScope, i5, i8);
        if (z2) {
            list = calculatePagesOffsets;
        } else {
            ArrayList arrayList = new ArrayList(calculatePagesOffsets.size());
            int size5 = calculatePagesOffsets.size();
            for (int i77 = 0; i77 < size5; i77++) {
                MeasuredPage measuredPage5 = calculatePagesOffsets.get(i77);
                MeasuredPage measuredPage6 = measuredPage5;
                if (measuredPage6.getIndex() >= ((MeasuredPage) arrayDeque12.first()).getIndex() && measuredPage6.getIndex() <= ((MeasuredPage) arrayDeque12.last()).getIndex()) {
                    arrayList.add(measuredPage5);
                }
            }
            list = arrayList;
        }
        int i78 = orientation == Orientation.Vertical ? m4974constrainHeightK40F9xA : m4975constrainWidthK40F9xA;
        if (list.isEmpty()) {
            measuredPage2 = null;
        } else {
            MeasuredPage measuredPage7 = list.get(0);
            MeasuredPage measuredPage8 = measuredPage7;
            float f3 = -Math.abs(SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(lazyLayoutMeasureScope, i78, i3, i4, i8, measuredPage8.getOffset(), measuredPage8.getIndex(), PagerStateKt.getSnapAlignmentStartToStart()));
            int lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
                MeasuredPage measuredPage9 = measuredPage7;
                int i79 = 1;
                float f4 = f3;
                while (true) {
                    MeasuredPage measuredPage10 = list.get(i79);
                    MeasuredPage measuredPage11 = measuredPage10;
                    int i80 = i79;
                    float f5 = -Math.abs(SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(lazyLayoutMeasureScope, i78, i3, i4, i8, measuredPage11.getOffset(), measuredPage11.getIndex(), PagerStateKt.getSnapAlignmentStartToStart()));
                    if (Float.compare(f4, f5) < 0) {
                        f4 = f5;
                        measuredPage9 = measuredPage10;
                    }
                    if (i80 == lastIndex) {
                        break;
                    }
                    i79 = i80 + 1;
                }
                measuredPage2 = measuredPage9;
            } else {
                measuredPage2 = measuredPage7;
            }
        }
        return new PagerMeasureResult(list, i, i8, i5, i4, orientation, i28, i14, z, f2, measuredPage4, measuredPage2, i23, i76 < i || i73 > i2, layout.invoke(Integer.valueOf(m4975constrainWidthK40F9xA), Integer.valueOf(m4974constrainHeightK40F9xA), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope invoke) {
                Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                List<MeasuredPage> list2 = calculatePagesOffsets;
                int size6 = list2.size();
                for (int i81 = 0; i81 < size6; i81++) {
                    list2.get(i81).place(invoke);
                }
            }
        }));
    }

    private static final List<MeasuredPage> createPagesAfterList(int i, int i2, int i3, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int min = Math.min(i3 + i, i2 - 1);
        int i4 = i + 1;
        ArrayList arrayList = null;
        if (i4 <= min) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(i4)));
                if (i4 == min) {
                    break;
                }
                i4++;
            }
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            int intValue = list.get(i5).intValue();
            if (min + 1 <= intValue && intValue < i2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(intValue)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<MeasuredPage> createPagesBeforeList(int i, int i2, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int max = Math.max(0, i - i2);
        int i3 = i - 1;
        ArrayList arrayList = null;
        if (max <= i3) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(i3)));
                if (i3 == max) {
                    break;
                }
                i3--;
            }
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            int intValue = list.get(i4).intValue();
            if (intValue < max) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(intValue)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAndMeasure-SGf7dI0, reason: not valid java name */
    public static final MeasuredPage m744getAndMeasureSGf7dI0(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, long j, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, long j2, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z, int i2) {
        return new MeasuredPage(i, i2, lazyLayoutMeasureScope.mo678measure0kLqBqw(i, j), j2, pagerLazyLayoutItemProvider.getKey(i), orientation, horizontal, vertical, layoutDirection, z, null);
    }

    private static final List<MeasuredPage> calculatePagesOffsets(LazyLayoutMeasureScope lazyLayoutMeasureScope, List<MeasuredPage> list, List<MeasuredPage> list2, List<MeasuredPage> list3, int i, int i2, int i3, int i4, int i5, Orientation orientation, boolean z, Density density, int i6, int i7) {
        int i8;
        int i9;
        int i10 = i7 + i6;
        if (orientation == Orientation.Vertical) {
            i8 = i4;
            i9 = i2;
        } else {
            i8 = i4;
            i9 = i;
        }
        boolean z2 = i3 < Math.min(i9, i8);
        if (z2 && i5 != 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (z2) {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            int size = list.size();
            int[] iArr = new int[size];
            for (int i11 = 0; i11 < size; i11++) {
                iArr[i11] = i7;
            }
            int[] iArr2 = new int[size];
            for (int i12 = 0; i12 < size; i12++) {
                iArr2[i12] = 0;
            }
            Arrangement.HorizontalOrVertical m430spacedBy0680j_4 = Arrangement.Absolute.INSTANCE.m430spacedBy0680j_4(lazyLayoutMeasureScope.mo357toDpu2uoSUM(i7));
            if (orientation == Orientation.Vertical) {
                m430spacedBy0680j_4.arrange(density, i9, iArr, iArr2);
            } else {
                m430spacedBy0680j_4.arrange(density, i9, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntRange indices = ArraysKt.getIndices(iArr2);
            if (z) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int i13 = iArr2[first];
                    MeasuredPage measuredPage = list.get(calculatePagesOffsets$reverseAware(first, z, size));
                    if (z) {
                        i13 = (i9 - i13) - measuredPage.getSize();
                    }
                    measuredPage.position(i13, i, i2);
                    arrayList.add(measuredPage);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size2 = list2.size();
            int i14 = i5;
            for (int i15 = 0; i15 < size2; i15++) {
                MeasuredPage measuredPage2 = list2.get(i15);
                i14 -= i10;
                measuredPage2.position(i14, i, i2);
                arrayList.add(measuredPage2);
            }
            int size3 = list.size();
            int i16 = i5;
            for (int i17 = 0; i17 < size3; i17++) {
                MeasuredPage measuredPage3 = list.get(i17);
                measuredPage3.position(i16, i, i2);
                arrayList.add(measuredPage3);
                i16 += i10;
            }
            int size4 = list3.size();
            for (int i18 = 0; i18 < size4; i18++) {
                MeasuredPage measuredPage4 = list3.get(i18);
                measuredPage4.position(i16, i, i2);
                arrayList.add(measuredPage4);
                i16 += i10;
            }
        }
        return arrayList;
    }
}
