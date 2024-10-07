package com.google.android.material.internal;

import android.os.Build;
import java.util.Locale;

/* loaded from: classes.dex */
public class ManufacturerUtils {
    private static final String LGE = "lge";
    private static final String MEIZU = "meizu";
    private static final String SAMSUNG = "samsung";

    private ManufacturerUtils() {
    }

    public static boolean isMeizuDevice() {
        return getManufacturer().equals(MEIZU);
    }

    public static boolean isLGEDevice() {
        return getManufacturer().equals(LGE);
    }

    public static boolean isSamsungDevice() {
        return getManufacturer().equals(SAMSUNG);
    }

    public static boolean isDateInputKeyboardMissingSeparatorCharacters() {
        return isLGEDevice() || isSamsungDevice();
    }

    private static String getManufacturer() {
        String manufacturer = Build.MANUFACTURER;
        if (manufacturer != null) {
            return manufacturer.toLowerCase(Locale.ENGLISH);
        }
        return "";
    }
}
