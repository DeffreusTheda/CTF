package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;

/* loaded from: /home/vinnie/CTF/Reverse Engineering/PicoCTF/timer/timer.d/classes.dex */
public interface FragmentResultOwner {
    void clearFragmentResult(String str);

    void clearFragmentResultListener(String str);

    void setFragmentResult(String str, Bundle bundle);

    void setFragmentResultListener(String str, LifecycleOwner lifecycleOwner, FragmentResultListener fragmentResultListener);
}
