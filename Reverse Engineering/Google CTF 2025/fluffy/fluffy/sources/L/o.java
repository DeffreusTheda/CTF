package l;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* loaded from: classes.dex */
public class o extends C0080n {
    public o(s sVar, WindowInsets windowInsets) {
        super(sVar, windowInsets);
    }

    @Override // l.r
    public s a() {
        WindowInsets consumeDisplayCutout;
        consumeDisplayCutout = this.f965c.consumeDisplayCutout();
        return s.a(consumeDisplayCutout, null);
    }

    @Override // l.r
    public C0067a e() {
        DisplayCutout displayCutout;
        displayCutout = this.f965c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new C0067a(displayCutout);
    }

    @Override // l.AbstractC0079m, l.r
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return Objects.equals(this.f965c, oVar.f965c) && Objects.equals(this.f967e, oVar.f967e);
    }

    @Override // l.r
    public int hashCode() {
        return this.f965c.hashCode();
    }
}
