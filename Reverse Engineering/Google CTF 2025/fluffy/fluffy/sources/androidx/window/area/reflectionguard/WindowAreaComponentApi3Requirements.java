package androidx.window.area.reflectionguard;

import android.app.Activity;
import android.util.DisplayMetrics;
import androidx.window.extensions.area.ExtensionWindowAreaPresentation;
import androidx.window.extensions.area.ExtensionWindowAreaStatus;
import androidx.window.extensions.core.util.function.Consumer;

/* loaded from: classes.dex */
public interface WindowAreaComponentApi3Requirements extends WindowAreaComponentApi2Requirements {
    void addRearDisplayPresentationStatusListener(Consumer<ExtensionWindowAreaStatus> consumer);

    void endRearDisplayPresentationSession();

    DisplayMetrics getRearDisplayMetrics();

    ExtensionWindowAreaPresentation getRearDisplayPresentation();

    void removeRearDisplayPresentationStatusListener(Consumer<ExtensionWindowAreaStatus> consumer);

    void startRearDisplayPresentationSession(Activity activity, Consumer<Integer> consumer);
}
