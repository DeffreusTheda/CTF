package l;

import android.view.DisplayCutout;
import java.util.Objects;

/* renamed from: l.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0067a {

    /* renamed from: a, reason: collision with root package name */
    public final DisplayCutout f945a;

    public C0067a(DisplayCutout displayCutout) {
        this.f945a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0067a.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f945a, ((C0067a) obj).f945a);
    }

    public final int hashCode() {
        int hashCode;
        hashCode = this.f945a.hashCode();
        return hashCode;
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f945a + "}";
    }
}
