package androidx.core.os;

import android.os.Handler;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: Handler.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u001a1\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b¨\u0006\f"}, d2 = {"postAtTime", "Ljava/lang/Runnable;", "Landroid/os/Handler;", "uptimeMillis", "", "token", "", "action", "Lkotlin/Function0;", "", "postDelayed", "delayInMillis", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class HandlerKt {
    public static /* synthetic */ Runnable postDelayed$default(Handler $this$postDelayed_u24default, long delayInMillis, Object token, Function0 action, int i, Object obj) {
        if ((i & 2) != 0) {
            token = null;
        }
        Runnable runnable = new HandlerKt$postDelayed$runnable$1(action);
        if (token == null) {
            $this$postDelayed_u24default.postDelayed(runnable, delayInMillis);
        } else {
            HandlerCompat.postDelayed($this$postDelayed_u24default, runnable, token, delayInMillis);
        }
        return runnable;
    }

    public static final Runnable postDelayed(Handler $this$postDelayed, long delayInMillis, Object token, Function0<Unit> function0) {
        Runnable runnable = new HandlerKt$postDelayed$runnable$1(function0);
        if (token == null) {
            $this$postDelayed.postDelayed(runnable, delayInMillis);
        } else {
            HandlerCompat.postDelayed($this$postDelayed, runnable, token, delayInMillis);
        }
        return runnable;
    }

    public static /* synthetic */ Runnable postAtTime$default(Handler $this$postAtTime_u24default, long uptimeMillis, Object token, Function0 action, int i, Object obj) {
        if ((i & 2) != 0) {
            token = null;
        }
        Runnable runnable = new HandlerKt$postAtTime$runnable$1(action);
        $this$postAtTime_u24default.postAtTime(runnable, token, uptimeMillis);
        return runnable;
    }

    public static final Runnable postAtTime(Handler $this$postAtTime, long uptimeMillis, Object token, Function0<Unit> function0) {
        Runnable runnable = new HandlerKt$postAtTime$runnable$1(function0);
        $this$postAtTime.postAtTime(runnable, token, uptimeMillis);
        return runnable;
    }
}
