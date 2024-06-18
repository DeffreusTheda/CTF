package androidx.core.content.pm;

import java.util.List;

/* loaded from: /home/vinnie/CTF/Reverse Engineering/PicoCTF/timer/timer.d/classes.dex */
public abstract class ShortcutInfoChangeListener {
    public void onShortcutAdded(List<ShortcutInfoCompat> shortcuts) {
    }

    public void onShortcutUpdated(List<ShortcutInfoCompat> shortcuts) {
    }

    public void onShortcutRemoved(List<String> shortcutIds) {
    }

    public void onAllShortcutsRemoved() {
    }

    public void onShortcutUsageReported(List<String> shortcutIds) {
    }
}
