package androidx.compose.foundation.pager;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: PagerMeasurePolicy.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0094\u0001\u0010\u0000\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\b\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"rememberPagerMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "beyondBoundsPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "pageCount", "rememberPagerMeasurePolicy-BxUkNYg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;IFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PagerMeasurePolicyKt {
    /* renamed from: rememberPagerMeasurePolicy-BxUkNYg, reason: not valid java name */
    public static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> m746rememberPagerMeasurePolicyBxUkNYg(final Function0<PagerLazyLayoutItemProvider> itemProviderLambda, final PagerState state, final PaddingValues contentPadding, final boolean z, final Orientation orientation, final int i, final float f, final PageSize pageSize, final Alignment.Horizontal horizontal, final Alignment.Vertical vertical, final Function0<Integer> pageCount, Composer composer, int i2, int i3) {
        Intrinsics.checkNotNullParameter(itemProviderLambda, "itemProviderLambda");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(pageSize, "pageSize");
        Intrinsics.checkNotNullParameter(pageCount, "pageCount");
        composer.startReplaceableGroup(-241579856);
        ComposerKt.sourceInformation(composer, "C(rememberPagerMeasurePolicy)P(3,9,1,8,4!1,7:c#ui.unit.Dp,6!1,10)53@2154L5676:PagerMeasurePolicy.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-241579856, i2, i3, "androidx.compose.foundation.pager.rememberPagerMeasurePolicy (PagerMeasurePolicy.kt:41)");
        }
        Object[] objArr = {contentPadding, Dp.m5015boximpl(f), pageSize, state, contentPadding, Boolean.valueOf(z), orientation, horizontal, vertical, pageCount};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean z2 = false;
        for (int i4 = 0; i4 < 10; i4++) {
            z2 |= composer.changed(objArr[i4]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ PagerMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m747invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final PagerMeasureResult m747invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                    int i5;
                    int i6;
                    int i7;
                    int m4961getMaxWidthimpl;
                    long IntOffset;
                    int firstVisiblePageOffset$foundation_release;
                    Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "$this$null");
                    boolean z3 = Orientation.this == Orientation.Vertical;
                    CheckScrollableContainerConstraintsKt.m221checkScrollableContainerConstraintsK40F9xA(j, z3 ? Orientation.Vertical : Orientation.Horizontal);
                    if (z3) {
                        i5 = lazyLayoutMeasureScope.mo354roundToPx0680j_4(contentPadding.mo470calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i5 = lazyLayoutMeasureScope.mo354roundToPx0680j_4(PaddingKt.calculateStartPadding(contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    if (z3) {
                        i6 = lazyLayoutMeasureScope.mo354roundToPx0680j_4(contentPadding.mo471calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i6 = lazyLayoutMeasureScope.mo354roundToPx0680j_4(PaddingKt.calculateEndPadding(contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    int i8 = lazyLayoutMeasureScope.mo354roundToPx0680j_4(contentPadding.getTop());
                    int i9 = lazyLayoutMeasureScope.mo354roundToPx0680j_4(contentPadding.getBottom());
                    final int i10 = i8 + i9;
                    final int i11 = i5 + i6;
                    int i12 = z3 ? i10 : i11;
                    if (z3 && !z) {
                        i7 = i8;
                    } else if (z3 && z) {
                        i7 = i9;
                    } else {
                        i7 = (z3 || z) ? i6 : i5;
                    }
                    int i13 = i12 - i7;
                    long m4977offsetNN6EwU = ConstraintsKt.m4977offsetNN6EwU(j, -i11, -i10);
                    LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                    state.setDensity$foundation_release(lazyLayoutMeasureScope2);
                    int i14 = lazyLayoutMeasureScope.mo354roundToPx0680j_4(f);
                    if (z3) {
                        m4961getMaxWidthimpl = Constraints.m4960getMaxHeightimpl(j) - i10;
                    } else {
                        m4961getMaxWidthimpl = Constraints.m4961getMaxWidthimpl(j) - i11;
                    }
                    if (!z || m4961getMaxWidthimpl > 0) {
                        IntOffset = IntOffsetKt.IntOffset(i5, i8);
                    } else {
                        if (!z3) {
                            i5 += m4961getMaxWidthimpl;
                        }
                        if (z3) {
                            i8 += m4961getMaxWidthimpl;
                        }
                        IntOffset = IntOffsetKt.IntOffset(i5, i8);
                    }
                    long j2 = IntOffset;
                    int calculateMainAxisPageSize = pageSize.calculateMainAxisPageSize(lazyLayoutMeasureScope2, m4961getMaxWidthimpl, i14);
                    state.m750setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, Orientation.this == Orientation.Vertical ? Constraints.m4961getMaxWidthimpl(m4977offsetNN6EwU) : calculateMainAxisPageSize, 0, Orientation.this != Orientation.Vertical ? Constraints.m4960getMaxHeightimpl(m4977offsetNN6EwU) : calculateMainAxisPageSize, 5, null));
                    Snapshot.Companion companion = Snapshot.INSTANCE;
                    PagerState pagerState = state;
                    Snapshot createNonObservableSnapshot = companion.createNonObservableSnapshot();
                    try {
                        Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                        try {
                            int firstVisiblePage$foundation_release = pagerState.getFirstVisiblePage$foundation_release();
                            if (Intrinsics.areEqual(pagerState.getLayoutInfo$foundation_release(), PagerStateKt.getEmptyLayoutInfo())) {
                                firstVisiblePageOffset$foundation_release = MathKt.roundToInt(pagerState.getInitialPageOffsetFraction() * calculateMainAxisPageSize);
                            } else {
                                firstVisiblePageOffset$foundation_release = pagerState.getFirstVisiblePageOffset$foundation_release();
                            }
                            int i15 = firstVisiblePageOffset$foundation_release;
                            Unit unit = Unit.INSTANCE;
                            createNonObservableSnapshot.dispose();
                            PagerLazyLayoutItemProvider invoke = itemProviderLambda.invoke();
                            PagerMeasureResult m745measurePagerntgEbfI = PagerMeasureKt.m745measurePagerntgEbfI(lazyLayoutMeasureScope, pageCount.invoke().intValue(), invoke, m4961getMaxWidthimpl, i7, i13, i14, firstVisiblePage$foundation_release, i15, state.getScrollToBeConsumed(), m4977offsetNN6EwU, Orientation.this, vertical, horizontal, z, j2, calculateMainAxisPageSize, i, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, state.getPinnedPages(), state.getBeyondBoundsInfo()), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                    return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                }

                                public final MeasureResult invoke(int i16, int i17, Function1<? super Placeable.PlacementScope, Unit> placement) {
                                    Intrinsics.checkNotNullParameter(placement, "placement");
                                    return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m4975constrainWidthK40F9xA(j, i16 + i11), ConstraintsKt.m4974constrainHeightK40F9xA(j, i17 + i10), MapsKt.emptyMap(), placement);
                                }
                            });
                            state.applyMeasureResult$foundation_release(m745measurePagerntgEbfI);
                            return m745measurePagerntgEbfI;
                        } finally {
                            createNonObservableSnapshot.restoreCurrent(makeCurrent);
                        }
                    } catch (Throwable th) {
                        createNonObservableSnapshot.dispose();
                        throw th;
                    }
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = (Function2) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function2;
    }
}
