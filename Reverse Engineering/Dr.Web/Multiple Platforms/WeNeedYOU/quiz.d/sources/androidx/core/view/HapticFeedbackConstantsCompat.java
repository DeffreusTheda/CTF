package androidx.core.view;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class HapticFeedbackConstantsCompat {
    public static final int CLOCK_TICK = 4;
    public static final int CONFIRM = 16;
    public static final int CONTEXT_CLICK = 6;
    public static final int DRAG_START = 25;
    static final int FIRST_CONSTANT_INT = 0;
    public static final int FLAG_IGNORE_VIEW_SETTING = 1;
    public static final int GESTURE_END = 13;
    public static final int GESTURE_START = 12;
    public static final int GESTURE_THRESHOLD_ACTIVATE = 23;
    public static final int GESTURE_THRESHOLD_DEACTIVATE = 24;
    public static final int KEYBOARD_PRESS = 3;
    public static final int KEYBOARD_RELEASE = 7;
    public static final int KEYBOARD_TAP = 3;
    static final int LAST_CONSTANT_INT = 27;
    public static final int LONG_PRESS = 0;
    public static final int NO_HAPTICS = -1;
    public static final int REJECT = 17;
    public static final int SEGMENT_FREQUENT_TICK = 27;
    public static final int SEGMENT_TICK = 26;
    public static final int TEXT_HANDLE_MOVE = 9;
    public static final int TOGGLE_OFF = 22;
    public static final int TOGGLE_ON = 21;
    public static final int VIRTUAL_KEY = 1;
    public static final int VIRTUAL_KEY_RELEASE = 8;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HapticFeedbackFlags {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HapticFeedbackType {
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002a, code lost:
    
        if (r6 != 17) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004a A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static int getFeedbackConstantOrFallback(int r6) {
        /*
            r0 = -1
            if (r6 != r0) goto L4
            return r0
        L4:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 34
            r3 = 0
            r4 = 4
            r5 = 6
            if (r1 >= r2) goto L16
            switch(r6) {
                case 21: goto L15;
                case 22: goto L13;
                case 23: goto L15;
                case 24: goto L13;
                case 25: goto L11;
                case 26: goto L15;
                case 27: goto L13;
                default: goto L10;
            }
        L10:
            goto L16
        L11:
            r6 = 0
            goto L16
        L13:
            r6 = 4
            goto L16
        L15:
            r6 = 6
        L16:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 30
            if (r1 >= r2) goto L31
            r1 = 12
            if (r6 == r1) goto L2f
            r1 = 13
            if (r6 == r1) goto L2d
            r1 = 16
            if (r6 == r1) goto L2f
            r1 = 17
            if (r6 == r1) goto L32
            goto L31
        L2d:
            r3 = 6
            goto L32
        L2f:
            r3 = 1
            goto L32
        L31:
            r3 = r6
        L32:
            int r6 = android.os.Build.VERSION.SDK_INT
            r1 = 27
            if (r6 >= r1) goto L43
            r6 = 7
            if (r3 == r6) goto L44
            r6 = 8
            if (r3 == r6) goto L44
            r6 = 9
            if (r3 == r6) goto L44
        L43:
            r0 = r3
        L44:
            int r6 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r6 >= r1) goto L4c
            if (r0 == r5) goto L4d
        L4c:
            r4 = r0
        L4d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.HapticFeedbackConstantsCompat.getFeedbackConstantOrFallback(int):int");
    }

    private HapticFeedbackConstantsCompat() {
    }
}
