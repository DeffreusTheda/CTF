package D;

/* renamed from: D.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0009j {
    public static int a(String str) {
        String str2;
        for (int i2 : n.e.b(2)) {
            if (i2 == 1) {
                str2 = "Brightness.light";
            } else {
                if (i2 != 2) {
                    throw null;
                }
                str2 = "Brightness.dark";
            }
            if (str2.equals(str)) {
                return i2;
            }
        }
        throw new NoSuchFieldException("No such Brightness: " + str);
    }

    public static int b(String str) {
        for (int i2 : n.e.b(5)) {
            String str2 = null;
            if (i2 != 1) {
                if (i2 == 2) {
                    str2 = "HapticFeedbackType.lightImpact";
                } else if (i2 == 3) {
                    str2 = "HapticFeedbackType.mediumImpact";
                } else if (i2 == 4) {
                    str2 = "HapticFeedbackType.heavyImpact";
                } else {
                    if (i2 != 5) {
                        throw null;
                    }
                    str2 = "HapticFeedbackType.selectionClick";
                }
            }
            if ((str2 == null && str == null) || (str2 != null && str2.equals(str))) {
                return i2;
            }
        }
        throw new NoSuchFieldException("No such HapticFeedbackType: " + str);
    }

    public static int c(String str) {
        String str2;
        for (int i2 : n.e.b(2)) {
            if (i2 == 1) {
                str2 = "SystemSoundType.click";
            } else {
                if (i2 != 2) {
                    throw null;
                }
                str2 = "SystemSoundType.alert";
            }
            if (str2.equals(str)) {
                return i2;
            }
        }
        throw new NoSuchFieldException("No such SoundType: " + str);
    }

    public static /* synthetic */ int d(int i2) {
        switch (i2) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 8;
            case 5:
                return 16;
            case 6:
                return 32;
            case 7:
                return 64;
            case 8:
                return 128;
            case 9:
                return 256;
            case 10:
                return 512;
            case 11:
                return 1024;
            case 12:
                return 2048;
            case 13:
                return 4096;
            case 14:
                return 8192;
            case 15:
                return 16384;
            case 16:
                return 32768;
            case 17:
                return 65536;
            case 18:
                return 131072;
            case 19:
                return 262144;
            case 20:
                return 524288;
            case 21:
                return 1048576;
            case 22:
                return 2097152;
            case 23:
                return 4194304;
            case 24:
                return 8388608;
            case 25:
                return 16777216;
            case 26:
                return 33554432;
            case 27:
                return 67108864;
            case 28:
                return 134217728;
            case 29:
                return 268435456;
            case 30:
                return 536870912;
            case 31:
                return 1073741824;
            default:
                throw null;
        }
    }

    public static /* synthetic */ void e(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static /* synthetic */ void f(String str, int i2) {
        if (i2 == 0) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = a0.h.class.getName();
            int i3 = 0;
            while (!stackTrace[i3].getClassName().equals(name)) {
                i3++;
            }
            while (stackTrace[i3].getClassName().equals(name)) {
                i3++;
            }
            StackTraceElement stackTraceElement = stackTrace[i3];
            NullPointerException nullPointerException = new NullPointerException("Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str);
            a0.h.f(nullPointerException, a0.h.class.getName());
            throw nullPointerException;
        }
    }
}
