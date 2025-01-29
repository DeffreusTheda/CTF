package B;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class c extends RuntimeException {
    public c(String str, String[] strArr, String[] strArr2) {
        super("Could not find '" + str + "'. Looked for: " + Arrays.toString(strArr) + ", but only found: " + Arrays.toString(strArr2) + ".");
    }
}
