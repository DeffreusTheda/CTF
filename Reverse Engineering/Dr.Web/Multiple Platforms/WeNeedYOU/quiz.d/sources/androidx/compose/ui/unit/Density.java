package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: Density.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u000b\u001a\u00020\f*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u000b\u001a\u00020\f*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\r*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0013\u001a\u00020\r*\u00020\u0003H\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0013\u001a\u00020\r*\u00020\fH\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u001a*\u00020\u001bH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u0003*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0017J\u0019\u0010\u001e\u001a\u00020\u0003*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0015J\f\u0010!\u001a\u00020\"*\u00020#H\u0017J\u0019\u0010$\u001a\u00020\u001b*\u00020\u001aH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010\u001dJ\u0019\u0010&\u001a\u00020\u0010*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\u001c\u0010&\u001a\u00020\u0010*\u00020\u0003H\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010(J\u001c\u0010&\u001a\u00020\u0010*\u00020\fH\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007ø\u0001\u0003\u0082\u0002\u0015\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!\n\u0004\b!0\u0001¨\u0006+À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "fontScale", "getFontScale$annotations", "getFontScale", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface Density {
    float getDensity();

    float getFontScale();

    /* renamed from: roundToPx--R2X_6o */
    int mo353roundToPxR2X_6o(long j);

    /* renamed from: roundToPx-0680j_4 */
    int mo354roundToPx0680j_4(float f);

    /* renamed from: toDp-GaN1DYA */
    float mo355toDpGaN1DYA(long j);

    /* renamed from: toDp-u2uoSUM */
    float mo356toDpu2uoSUM(float f);

    /* renamed from: toDp-u2uoSUM */
    float mo357toDpu2uoSUM(int i);

    /* renamed from: toDpSize-k-rfVVM */
    long mo358toDpSizekrfVVM(long j);

    /* renamed from: toPx--R2X_6o */
    float mo359toPxR2X_6o(long j);

    /* renamed from: toPx-0680j_4 */
    float mo360toPx0680j_4(float f);

    Rect toRect(DpRect dpRect);

    /* renamed from: toSize-XkaWNTQ */
    long mo361toSizeXkaWNTQ(long j);

    /* renamed from: toSp-0xMU5do */
    long mo362toSp0xMU5do(float f);

    /* renamed from: toSp-kPz2Gy4 */
    long mo363toSpkPz2Gy4(float f);

    /* renamed from: toSp-kPz2Gy4 */
    long mo364toSpkPz2Gy4(int i);

    /* compiled from: Density.kt */
    /* renamed from: androidx.compose.ui.unit.Density$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* renamed from: $default$toPx-0680j_4, reason: not valid java name */
        public static float m4986$default$toPx0680j_4(Density _this, float f) {
            return f * _this.getDensity();
        }

        /* renamed from: $default$roundToPx-0680j_4, reason: not valid java name */
        public static int m4980$default$roundToPx0680j_4(Density _this, float f) {
            float mo360toPx0680j_4 = _this.mo360toPx0680j_4(f);
            if (Float.isInfinite(mo360toPx0680j_4)) {
                return Integer.MAX_VALUE;
            }
            return MathKt.roundToInt(mo360toPx0680j_4);
        }

        /* renamed from: $default$toSp-0xMU5do, reason: not valid java name */
        public static long m4988$default$toSp0xMU5do(Density _this, float f) {
            return TextUnitKt.getSp(f / _this.getFontScale());
        }

        /* renamed from: $default$toPx--R2X_6o, reason: not valid java name */
        public static float m4985$default$toPxR2X_6o(Density _this, long j) {
            if (!TextUnitType.m5226equalsimpl0(TextUnit.m5197getTypeUIouoOA(j), TextUnitType.INSTANCE.m5231getSpUIouoOA())) {
                throw new IllegalStateException("Only Sp can convert to Px".toString());
            }
            return TextUnit.m5198getValueimpl(j) * _this.getFontScale() * _this.getDensity();
        }

        /* renamed from: $default$roundToPx--R2X_6o, reason: not valid java name */
        public static int m4979$default$roundToPxR2X_6o(Density _this, long j) {
            return MathKt.roundToInt(_this.mo359toPxR2X_6o(j));
        }

        /* renamed from: $default$toDp-GaN1DYA, reason: not valid java name */
        public static float m4981$default$toDpGaN1DYA(Density _this, long j) {
            if (!TextUnitType.m5226equalsimpl0(TextUnit.m5197getTypeUIouoOA(j), TextUnitType.INSTANCE.m5231getSpUIouoOA())) {
                throw new IllegalStateException("Only Sp can convert to Px".toString());
            }
            return Dp.m5017constructorimpl(TextUnit.m5198getValueimpl(j) * _this.getFontScale());
        }

        /* renamed from: $default$toDp-u2uoSUM, reason: not valid java name */
        public static float m4983$default$toDpu2uoSUM(Density _this, int i) {
            return Dp.m5017constructorimpl(i / _this.getDensity());
        }

        /* renamed from: $default$toSp-kPz2Gy4, reason: not valid java name */
        public static long m4990$default$toSpkPz2Gy4(Density _this, int i) {
            return TextUnitKt.getSp(i / (_this.getFontScale() * _this.getDensity()));
        }

        /* renamed from: $default$toDp-u2uoSUM, reason: not valid java name */
        public static float m4982$default$toDpu2uoSUM(Density _this, float f) {
            return Dp.m5017constructorimpl(f / _this.getDensity());
        }

        /* renamed from: $default$toSp-kPz2Gy4, reason: not valid java name */
        public static long m4989$default$toSpkPz2Gy4(Density _this, float f) {
            return TextUnitKt.getSp(f / (_this.getFontScale() * _this.getDensity()));
        }

        public static Rect $default$toRect(Density _this, DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "<this>");
            return new Rect(_this.mo360toPx0680j_4(dpRect.m5100getLeftD9Ej5fM()), _this.mo360toPx0680j_4(dpRect.m5102getTopD9Ej5fM()), _this.mo360toPx0680j_4(dpRect.m5101getRightD9Ej5fM()), _this.mo360toPx0680j_4(dpRect.m5099getBottomD9Ej5fM()));
        }

        /* renamed from: $default$toSize-XkaWNTQ, reason: not valid java name */
        public static long m4987$default$toSizeXkaWNTQ(Density _this, long j) {
            if (j != DpSize.INSTANCE.m5124getUnspecifiedMYxV2XQ()) {
                return SizeKt.Size(_this.mo360toPx0680j_4(DpSize.m5115getWidthD9Ej5fM(j)), _this.mo360toPx0680j_4(DpSize.m5113getHeightD9Ej5fM(j)));
            }
            return Size.INSTANCE.m2523getUnspecifiedNHjbRc();
        }

        /* renamed from: $default$toDpSize-k-rfVVM, reason: not valid java name */
        public static long m4984$default$toDpSizekrfVVM(Density _this, long j) {
            if (j != Size.INSTANCE.m2523getUnspecifiedNHjbRc()) {
                return DpKt.m5039DpSizeYgX7TsA(_this.mo356toDpu2uoSUM(Size.m2515getWidthimpl(j)), _this.mo356toDpu2uoSUM(Size.m2512getHeightimpl(j)));
            }
            return DpSize.INSTANCE.m5124getUnspecifiedMYxV2XQ();
        }
    }

    /* compiled from: Density.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        public static /* synthetic */ void getDensity$annotations() {
        }

        public static /* synthetic */ void getFontScale$annotations() {
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m5010toPx0680j_4(Density density, float f) {
            return CC.m4986$default$toPx0680j_4(density, f);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m5004roundToPx0680j_4(Density density, float f) {
            return CC.m4980$default$roundToPx0680j_4(density, f);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m5012toSp0xMU5do(Density density, float f) {
            return CC.m4988$default$toSp0xMU5do(density, f);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m5009toPxR2X_6o(Density density, long j) {
            return CC.m4985$default$toPxR2X_6o(density, j);
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m5003roundToPxR2X_6o(Density density, long j) {
            return CC.m4979$default$roundToPxR2X_6o(density, j);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m5005toDpGaN1DYA(Density density, long j) {
            return CC.m4981$default$toDpGaN1DYA(density, j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5007toDpu2uoSUM(Density density, int i) {
            return CC.m4983$default$toDpu2uoSUM(density, i);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5014toSpkPz2Gy4(Density density, int i) {
            return CC.m4990$default$toSpkPz2Gy4(density, i);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5006toDpu2uoSUM(Density density, float f) {
            return CC.m4982$default$toDpu2uoSUM(density, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5013toSpkPz2Gy4(Density density, float f) {
            return CC.m4989$default$toSpkPz2Gy4(density, f);
        }

        @Deprecated
        public static Rect toRect(Density density, DpRect receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return CC.$default$toRect(density, receiver);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m5011toSizeXkaWNTQ(Density density, long j) {
            return CC.m4987$default$toSizeXkaWNTQ(density, j);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m5008toDpSizekrfVVM(Density density, long j) {
            return CC.m4984$default$toDpSizekrfVVM(density, j);
        }
    }
}
