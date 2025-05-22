package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TapGestureDetector.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004ø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAwaitRelease", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface PressGestureScope extends Density {
    Object awaitRelease(Continuation<? super Unit> continuation);

    Object tryAwaitRelease(Continuation<? super Boolean> continuation);

    /* compiled from: TapGestureDetector.kt */
    /* renamed from: androidx.compose.foundation.gestures.PressGestureScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    /* compiled from: TapGestureDetector.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m341roundToPxR2X_6o(PressGestureScope pressGestureScope, long j) {
            return Density.CC.m4979$default$roundToPxR2X_6o(pressGestureScope, j);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m342roundToPx0680j_4(PressGestureScope pressGestureScope, float f) {
            return Density.CC.m4980$default$roundToPx0680j_4(pressGestureScope, f);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m343toDpGaN1DYA(PressGestureScope pressGestureScope, long j) {
            return Density.CC.m4981$default$toDpGaN1DYA(pressGestureScope, j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m344toDpu2uoSUM(PressGestureScope pressGestureScope, float f) {
            return Density.CC.m4982$default$toDpu2uoSUM(pressGestureScope, f);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m345toDpu2uoSUM(PressGestureScope pressGestureScope, int i) {
            return Density.CC.m4983$default$toDpu2uoSUM((Density) pressGestureScope, i);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m346toDpSizekrfVVM(PressGestureScope pressGestureScope, long j) {
            return Density.CC.m4984$default$toDpSizekrfVVM(pressGestureScope, j);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m347toPxR2X_6o(PressGestureScope pressGestureScope, long j) {
            return Density.CC.m4985$default$toPxR2X_6o(pressGestureScope, j);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m348toPx0680j_4(PressGestureScope pressGestureScope, float f) {
            return Density.CC.m4986$default$toPx0680j_4(pressGestureScope, f);
        }

        @Deprecated
        public static Rect toRect(PressGestureScope pressGestureScope, DpRect receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return Density.CC.$default$toRect(pressGestureScope, receiver);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m349toSizeXkaWNTQ(PressGestureScope pressGestureScope, long j) {
            return Density.CC.m4987$default$toSizeXkaWNTQ(pressGestureScope, j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m350toSp0xMU5do(PressGestureScope pressGestureScope, float f) {
            return Density.CC.m4988$default$toSp0xMU5do(pressGestureScope, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m351toSpkPz2Gy4(PressGestureScope pressGestureScope, float f) {
            return Density.CC.m4989$default$toSpkPz2Gy4(pressGestureScope, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m352toSpkPz2Gy4(PressGestureScope pressGestureScope, int i) {
            return Density.CC.m4990$default$toSpkPz2Gy4((Density) pressGestureScope, i);
        }
    }
}
