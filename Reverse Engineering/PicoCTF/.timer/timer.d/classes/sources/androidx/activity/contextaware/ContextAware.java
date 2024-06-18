package androidx.activity.contextaware;

import android.content.Context;

/* loaded from: /home/vinnie/CTF/Reverse Engineering/PicoCTF/timer/timer.d/classes.dex */
public interface ContextAware {
    void addOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener);

    Context peekAvailableContext();

    void removeOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener);
}
