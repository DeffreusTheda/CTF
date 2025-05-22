package androidx.window.embedding;

import androidx.window.core.ExperimentalWindowApi;
import b0.q;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.i;

@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class ActivityRule extends EmbeddingRule {
    private final boolean alwaysExpand;
    private final Set<ActivityFilter> filters;

    public ActivityRule(Set<ActivityFilter> filters, boolean z2) {
        Set<ActivityFilter> t2;
        i.e(filters, "filters");
        this.alwaysExpand = z2;
        t2 = q.t(filters);
        this.filters = t2;
    }

    public /* synthetic */ ActivityRule(Set set, boolean z2, int i2, kotlin.jvm.internal.e eVar) {
        this(set, (i2 & 2) != 0 ? false : z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityRule)) {
            return false;
        }
        ActivityRule activityRule = (ActivityRule) obj;
        return i.a(this.filters, activityRule.filters) && this.alwaysExpand == activityRule.alwaysExpand;
    }

    public final boolean getAlwaysExpand() {
        return this.alwaysExpand;
    }

    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    public int hashCode() {
        return (this.filters.hashCode() * 31) + a.a(this.alwaysExpand);
    }

    public final ActivityRule plus$window_release(ActivityFilter filter) {
        Set t2;
        i.e(filter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(filter);
        t2 = q.t(linkedHashSet);
        return new ActivityRule(t2, this.alwaysExpand);
    }
}
