package androidx.transition;

import androidx.core.util.Consumer;

/* loaded from: classes2.dex */
public interface TransitionSeekController {
    void addOnProgressChangedListener(Consumer<TransitionSeekController> consumer);

    void addOnReadyListener(Consumer<TransitionSeekController> consumer);

    void animateToEnd();

    void animateToStart(Runnable runnable);

    float getCurrentFraction();

    long getCurrentPlayTimeMillis();

    long getDurationMillis();

    boolean isReady();

    void removeOnProgressChangedListener(Consumer<TransitionSeekController> consumer);

    void removeOnReadyListener(Consumer<TransitionSeekController> consumer);

    void setCurrentFraction(float f);

    void setCurrentPlayTimeMillis(long j);
}
