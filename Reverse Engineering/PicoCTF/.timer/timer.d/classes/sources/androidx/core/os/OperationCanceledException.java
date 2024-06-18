package androidx.core.os;

import androidx.core.util.ObjectsCompat;

/* loaded from: /home/vinnie/CTF/Reverse Engineering/PicoCTF/timer/timer.d/classes.dex */
public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(String message) {
        super(ObjectsCompat.toString(message, "The operation has been canceled."));
    }
}
