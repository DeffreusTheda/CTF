package androidx.window.embedding;

import androidx.window.core.ExperimentalWindowApi;
import b0.q;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.i;

@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class SplitPairRule extends SplitRule {
    private final boolean clearTop;
    private final Set<SplitPairFilter> filters;
    private final boolean finishPrimaryWithSecondary;
    private final boolean finishSecondaryWithPrimary;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitPairRule(Set<SplitPairFilter> filters, boolean z2, boolean z3, boolean z4, int i2, int i3, float f2, int i4) {
        super(i2, i3, f2, i4);
        Set<SplitPairFilter> t2;
        i.e(filters, "filters");
        this.finishPrimaryWithSecondary = z2;
        this.finishSecondaryWithPrimary = z3;
        this.clearTop = z4;
        t2 = q.t(filters);
        this.filters = t2;
    }

    public /* synthetic */ SplitPairRule(Set set, boolean z2, boolean z3, boolean z4, int i2, int i3, float f2, int i4, int i5, kotlin.jvm.internal.e eVar) {
        this(set, (i5 & 2) != 0 ? false : z2, (i5 & 4) != 0 ? true : z3, (i5 & 8) != 0 ? false : z4, (i5 & 16) != 0 ? 0 : i2, (i5 & 32) == 0 ? i3 : 0, (i5 & 64) != 0 ? 0.5f : f2, (i5 & 128) != 0 ? 3 : i4);
    }

    @Override // androidx.window.embedding.SplitRule
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairRule) || !super.equals(obj)) {
            return false;
        }
        SplitPairRule splitPairRule = (SplitPairRule) obj;
        return i.a(this.filters, splitPairRule.filters) && this.finishPrimaryWithSecondary == splitPairRule.finishPrimaryWithSecondary && this.finishSecondaryWithPrimary == splitPairRule.finishSecondaryWithPrimary && this.clearTop == splitPairRule.clearTop;
    }

    public final boolean getClearTop() {
        return this.clearTop;
    }

    public final Set<SplitPairFilter> getFilters() {
        return this.filters;
    }

    public final boolean getFinishPrimaryWithSecondary() {
        return this.finishPrimaryWithSecondary;
    }

    public final boolean getFinishSecondaryWithPrimary() {
        return this.finishSecondaryWithPrimary;
    }

    @Override // androidx.window.embedding.SplitRule
    public int hashCode() {
        return (((((((super.hashCode() * 31) + this.filters.hashCode()) * 31) + a.a(this.finishPrimaryWithSecondary)) * 31) + a.a(this.finishSecondaryWithPrimary)) * 31) + a.a(this.clearTop);
    }

    public final SplitPairRule plus$window_release(SplitPairFilter filter) {
        Set t2;
        i.e(filter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(filter);
        t2 = q.t(linkedHashSet);
        return new SplitPairRule(t2, this.finishPrimaryWithSecondary, this.finishSecondaryWithPrimary, this.clearTop, getMinWidth(), getMinSmallestWidth(), getSplitRatio(), getLayoutDirection());
    }
}
