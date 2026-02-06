package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.annotation.Keep;
import androidx.lifecycle.c;

@Keep
/* loaded from: classes.dex */
public class HiddenLifecycleReference {
    private final c lifecycle;

    public HiddenLifecycleReference(c cVar) {
        this.lifecycle = cVar;
    }

    public c getLifecycle() {
        return this.lifecycle;
    }
}
