package kotlin.collections;

import java.util.Arrays;
import java.util.List;

/* loaded from: /home/vinnie/CTF/Reverse Engineering/PicoCTF/timer/timer.d/classes.dex */
class ArraysUtilJVM {
    ArraysUtilJVM() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> List<T> asList(T[] array) {
        return Arrays.asList(array);
    }
}
