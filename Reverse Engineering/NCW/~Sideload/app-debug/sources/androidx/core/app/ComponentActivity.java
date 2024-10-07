package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComponentActivity.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001)B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J'\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\b\b\u0000\u0010\u0017*\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0007H\u0017¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001dH\u0015J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\bH\u0017J\u001d\u0010\"\u001a\u00020\u00122\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0004¢\u0006\u0002\u0010&J\u001d\u0010'\u001a\u00020\u00122\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0002¢\u0006\u0002\u0010&J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0017R(\u0010\u0005\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0004¨\u0006*"}, d2 = {"Landroidx/core/app/ComponentActivity;", "Landroid/app/Activity;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/core/view/KeyEventDispatcher$Component;", "()V", "extraDataMap", "Landroidx/collection/SimpleArrayMap;", "Ljava/lang/Class;", "Landroidx/core/app/ComponentActivity$ExtraData;", "getExtraDataMap$annotations", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycleRegistry$annotations", "dispatchKeyEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "dispatchKeyShortcutEvent", "getExtraData", "T", "extraDataClass", "(Ljava/lang/Class;)Landroidx/core/app/ComponentActivity$ExtraData;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "putExtraData", "extraData", "shouldDumpInternalState", "args", "", "", "([Ljava/lang/String;)Z", "shouldSkipDump", "superDispatchKeyEvent", "ExtraData", "core_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public class ComponentActivity extends Activity implements LifecycleOwner, KeyEventDispatcher.Component {
    private final SimpleArrayMap<Class<? extends ExtraData>, ExtraData> extraDataMap = new SimpleArrayMap<>();
    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    /* compiled from: ComponentActivity.kt */
    @Deprecated(message = "Store the object you want to save directly by using\n      {@link View#setTag(int, Object)} with the window's decor view.")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/core/app/ComponentActivity$ExtraData;", "", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static class ExtraData {
    }

    private static /* synthetic */ void getExtraDataMap$annotations() {
    }

    private static /* synthetic */ void getLifecycleRegistry$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "Use {@link View#setTag(int, Object)} with the window's decor view.")
    public void putExtraData(ExtraData extraData) {
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        this.extraDataMap.put(extraData.getClass(), extraData);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ReportFragment.INSTANCE.injectIfNeededIn(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        super.onSaveInstanceState(outState);
    }

    @Deprecated(message = "Use {@link View#getTag(int)} with the window's decor view.")
    public <T extends ExtraData> T getExtraData(Class<T> extraDataClass) {
        Intrinsics.checkNotNullParameter(extraDataClass, "extraDataClass");
        return (T) this.extraDataMap.get(extraDataClass);
    }

    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    @Override // androidx.core.view.KeyEventDispatcher.Component
    public boolean superDispatchKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return super.dispatchKeyEvent(event);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        View decor = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decor, "window.decorView");
        if (KeyEventDispatcher.dispatchBeforeHierarchy(decor, event)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(event);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        View decor = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decor, "window.decorView");
        if (KeyEventDispatcher.dispatchBeforeHierarchy(decor, event)) {
            return true;
        }
        return KeyEventDispatcher.dispatchKeyEvent(this, decor, this, event);
    }

    protected final boolean shouldDumpInternalState(String[] args) {
        return !shouldSkipDump(args);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0046, code lost:
    
        if (r2.equals("--list-dumpables") == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 33) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004f, code lost:
    
        if (r2.equals("--dump-dumpable") == false) goto L51;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean shouldSkipDump(java.lang.String[] r5) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            if (r5 == 0) goto Lf
            int r2 = r5.length
            if (r2 != 0) goto L9
            r2 = r0
            goto La
        L9:
            r2 = r1
        La:
            if (r2 == 0) goto Ld
            goto Lf
        Ld:
            r2 = r1
            goto L10
        Lf:
            r2 = r0
        L10:
            if (r2 != 0) goto L6d
            r2 = r5[r1]
            int r3 = r2.hashCode()
            switch(r3) {
                case -645125871: goto L5b;
                case 100470631: goto L49;
                case 472614934: goto L40;
                case 1159329357: goto L2e;
                case 1455016274: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L6d
        L1c:
            java.lang.String r3 = "--autofill"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L25
            goto L1b
        L25:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r2 < r3) goto L2c
            goto L2d
        L2c:
            r0 = r1
        L2d:
            return r0
        L2e:
            java.lang.String r3 = "--contentcapture"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L37
            goto L1b
        L37:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 29
            if (r2 < r3) goto L3e
            goto L3f
        L3e:
            r0 = r1
        L3f:
            return r0
        L40:
            java.lang.String r3 = "--list-dumpables"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L52
            goto L1b
        L49:
            java.lang.String r3 = "--dump-dumpable"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L52
            goto L1b
        L52:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 33
            if (r2 < r3) goto L59
            goto L5a
        L59:
            r0 = r1
        L5a:
            return r0
        L5b:
            java.lang.String r3 = "--translation"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L64
            goto L1b
        L64:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 31
            if (r2 < r3) goto L6b
            goto L6c
        L6b:
            r0 = r1
        L6c:
            return r0
        L6d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.ComponentActivity.shouldSkipDump(java.lang.String[]):boolean");
    }
}
