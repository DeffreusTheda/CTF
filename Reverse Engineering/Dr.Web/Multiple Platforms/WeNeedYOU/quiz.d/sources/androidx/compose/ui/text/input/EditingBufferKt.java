package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: EditingBuffer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", TypedValues.AttributesType.S_TARGET, "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m4677updateRangeAfterDeletepWDy79M(long j, long j2) {
        int m4528getLengthimpl;
        int m4530getMinimpl = TextRange.m4530getMinimpl(j);
        int m4529getMaximpl = TextRange.m4529getMaximpl(j);
        if (TextRange.m4534intersects5zctL8(j2, j)) {
            if (TextRange.m4522contains5zctL8(j2, j)) {
                m4530getMinimpl = TextRange.m4530getMinimpl(j2);
                m4529getMaximpl = m4530getMinimpl;
            } else {
                if (TextRange.m4522contains5zctL8(j, j2)) {
                    m4528getLengthimpl = TextRange.m4528getLengthimpl(j2);
                } else if (TextRange.m4523containsimpl(j2, m4530getMinimpl)) {
                    m4530getMinimpl = TextRange.m4530getMinimpl(j2);
                    m4528getLengthimpl = TextRange.m4528getLengthimpl(j2);
                } else {
                    m4529getMaximpl = TextRange.m4530getMinimpl(j2);
                }
                m4529getMaximpl -= m4528getLengthimpl;
            }
        } else if (m4529getMaximpl > TextRange.m4530getMinimpl(j2)) {
            m4530getMinimpl -= TextRange.m4528getLengthimpl(j2);
            m4528getLengthimpl = TextRange.m4528getLengthimpl(j2);
            m4529getMaximpl -= m4528getLengthimpl;
        }
        return TextRangeKt.TextRange(m4530getMinimpl, m4529getMaximpl);
    }
}
