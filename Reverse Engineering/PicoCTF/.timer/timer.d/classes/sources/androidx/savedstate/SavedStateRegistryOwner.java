package androidx.savedstate;

import androidx.lifecycle.LifecycleOwner;

/* loaded from: /home/vinnie/CTF/Reverse Engineering/PicoCTF/timer/timer.d/classes.dex */
public interface SavedStateRegistryOwner extends LifecycleOwner {
    SavedStateRegistry getSavedStateRegistry();
}
