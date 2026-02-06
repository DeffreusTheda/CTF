package androidx.window.embedding;

import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import b0.q;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.i;

@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class SplitPlaceholderRule extends SplitRule {
    private final Set<ActivityFilter> filters;
    private final Intent placeholderIntent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitPlaceholderRule(Set<ActivityFilter> filters, Intent placeholderIntent, int i2, int i3, float f2, int i4) {
        super(i2, i3, f2, i4);
        Set<ActivityFilter> t2;
        i.e(filters, "filters");
        i.e(placeholderIntent, "placeholderIntent");
        this.placeholderIntent = placeholderIntent;
        t2 = q.t(filters);
        this.filters = t2;
    }

    public /* synthetic */ SplitPlaceholderRule(Set set, Intent intent, int i2, int i3, float f2, int i4, int i5, kotlin.jvm.internal.e eVar) {
        this(set, intent, (i5 & 4) != 0 ? 0 : i2, (i5 & 8) != 0 ? 0 : i3, (i5 & 16) != 0 ? 0.5f : f2, (i5 & 32) != 0 ? 3 : i4);
    }

    @Override // androidx.window.embedding.SplitRule
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPlaceholderRule) || !super.equals(obj) || !super.equals(obj)) {
            return false;
        }
        SplitPlaceholderRule splitPlaceholderRule = (SplitPlaceholderRule) obj;
        return i.a(this.filters, splitPlaceholderRule.filters) && i.a(this.placeholderIntent, splitPlaceholderRule.placeholderIntent);
    }

    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    public final Intent getPlaceholderIntent() {
        return this.placeholderIntent;
    }

    @Override // androidx.window.embedding.SplitRule
    public int hashCode() {
        return (((super.hashCode() * 31) + this.filters.hashCode()) * 31) + this.placeholderIntent.hashCode();
    }

    public final SplitPlaceholderRule plus$window_release(ActivityFilter filter) {
        Set t2;
        i.e(filter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(filter);
        t2 = q.t(linkedHashSet);
        return new SplitPlaceholderRule(t2, this.placeholderIntent, getMinWidth(), getMinSmallestWidth(), getSplitRatio(), getLayoutDirection());
    }
}
