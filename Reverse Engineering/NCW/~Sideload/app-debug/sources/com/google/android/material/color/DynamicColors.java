package com.google.android.material.color;

import android.app.Activity;
import android.app.Application;
import android.app.UiModeManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import androidx.core.os.BuildCompat;
import com.google.android.material.R;
import com.google.android.material.color.DynamicColorsOptions;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.color.utilities.SchemeContent;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class DynamicColors {
    private static final DeviceSupportCondition DEFAULT_DEVICE_SUPPORT_CONDITION;
    private static final Map<String, DeviceSupportCondition> DYNAMIC_COLOR_SUPPORTED_BRANDS;
    private static final Map<String, DeviceSupportCondition> DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS;
    private static final int[] DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE = {R.attr.dynamicColorThemeOverlay};
    private static final DeviceSupportCondition SAMSUNG_DEVICE_SUPPORT_CONDITION;
    private static final String TAG;
    private static final int USE_DEFAULT_THEME_OVERLAY = 0;

    private interface DeviceSupportCondition {
        boolean isSupported();
    }

    public interface OnAppliedCallback {
        void onApplied(Activity activity);
    }

    public interface Precondition {
        boolean shouldApplyDynamicColors(Activity activity, int i);
    }

    static {
        DeviceSupportCondition deviceSupportCondition = new DeviceSupportCondition() { // from class: com.google.android.material.color.DynamicColors.1
            @Override // com.google.android.material.color.DynamicColors.DeviceSupportCondition
            public boolean isSupported() {
                return true;
            }
        };
        DEFAULT_DEVICE_SUPPORT_CONDITION = deviceSupportCondition;
        DeviceSupportCondition deviceSupportCondition2 = new DeviceSupportCondition() { // from class: com.google.android.material.color.DynamicColors.2
            private Long version;

            @Override // com.google.android.material.color.DynamicColors.DeviceSupportCondition
            public boolean isSupported() {
                if (this.version == null) {
                    try {
                        Method method = Build.class.getDeclaredMethod("getLong", String.class);
                        method.setAccessible(true);
                        this.version = Long.valueOf(((Long) method.invoke(null, "ro.build.version.oneui")).longValue());
                    } catch (Exception e) {
                        this.version = -1L;
                    }
                }
                return this.version.longValue() >= 40100;
            }
        };
        SAMSUNG_DEVICE_SUPPORT_CONDITION = deviceSupportCondition2;
        Map<String, DeviceSupportCondition> deviceMap = new HashMap<>();
        deviceMap.put("fcnt", deviceSupportCondition);
        deviceMap.put("google", deviceSupportCondition);
        deviceMap.put("hmd global", deviceSupportCondition);
        deviceMap.put("infinix", deviceSupportCondition);
        deviceMap.put("infinix mobility limited", deviceSupportCondition);
        deviceMap.put("itel", deviceSupportCondition);
        deviceMap.put("kyocera", deviceSupportCondition);
        deviceMap.put("lenovo", deviceSupportCondition);
        deviceMap.put("lge", deviceSupportCondition);
        deviceMap.put("meizu", deviceSupportCondition);
        deviceMap.put("motorola", deviceSupportCondition);
        deviceMap.put("nothing", deviceSupportCondition);
        deviceMap.put("oneplus", deviceSupportCondition);
        deviceMap.put("oppo", deviceSupportCondition);
        deviceMap.put("realme", deviceSupportCondition);
        deviceMap.put("robolectric", deviceSupportCondition);
        deviceMap.put("samsung", deviceSupportCondition2);
        deviceMap.put("sharp", deviceSupportCondition);
        deviceMap.put("shift", deviceSupportCondition);
        deviceMap.put("sony", deviceSupportCondition);
        deviceMap.put("tcl", deviceSupportCondition);
        deviceMap.put("tecno", deviceSupportCondition);
        deviceMap.put("tecno mobile limited", deviceSupportCondition);
        deviceMap.put("vivo", deviceSupportCondition);
        deviceMap.put("wingtech", deviceSupportCondition);
        deviceMap.put("xiaomi", deviceSupportCondition);
        DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS = Collections.unmodifiableMap(deviceMap);
        Map<String, DeviceSupportCondition> deviceMap2 = new HashMap<>();
        deviceMap2.put("asus", deviceSupportCondition);
        deviceMap2.put("jio", deviceSupportCondition);
        DYNAMIC_COLOR_SUPPORTED_BRANDS = Collections.unmodifiableMap(deviceMap2);
        TAG = DynamicColors.class.getSimpleName();
    }

    private DynamicColors() {
    }

    public static void applyToActivitiesIfAvailable(Application application) {
        applyToActivitiesIfAvailable(application, new DynamicColorsOptions.Builder().build());
    }

    @Deprecated
    public static void applyToActivitiesIfAvailable(Application application, int theme) {
        applyToActivitiesIfAvailable(application, new DynamicColorsOptions.Builder().setThemeOverlay(theme).build());
    }

    @Deprecated
    public static void applyToActivitiesIfAvailable(Application application, Precondition precondition) {
        applyToActivitiesIfAvailable(application, new DynamicColorsOptions.Builder().setPrecondition(precondition).build());
    }

    @Deprecated
    public static void applyToActivitiesIfAvailable(Application application, int theme, Precondition precondition) {
        applyToActivitiesIfAvailable(application, new DynamicColorsOptions.Builder().setThemeOverlay(theme).setPrecondition(precondition).build());
    }

    public static void applyToActivitiesIfAvailable(Application application, DynamicColorsOptions dynamicColorsOptions) {
        application.registerActivityLifecycleCallbacks(new DynamicColorsActivityLifecycleCallbacks(dynamicColorsOptions));
    }

    @Deprecated
    public static void applyIfAvailable(Activity activity) {
        applyToActivityIfAvailable(activity);
    }

    @Deprecated
    public static void applyIfAvailable(Activity activity, int theme) {
        applyToActivityIfAvailable(activity, new DynamicColorsOptions.Builder().setThemeOverlay(theme).build());
    }

    @Deprecated
    public static void applyIfAvailable(Activity activity, Precondition precondition) {
        applyToActivityIfAvailable(activity, new DynamicColorsOptions.Builder().setPrecondition(precondition).build());
    }

    public static void applyToActivityIfAvailable(Activity activity) {
        applyToActivityIfAvailable(activity, new DynamicColorsOptions.Builder().build());
    }

    public static void applyToActivityIfAvailable(Activity activity, DynamicColorsOptions dynamicColorsOptions) {
        int themeOverlay;
        if (!isDynamicColorAvailable()) {
            return;
        }
        int theme = 0;
        if (dynamicColorsOptions.getContentBasedSeedColor() == null) {
            if (dynamicColorsOptions.getThemeOverlay() == 0) {
                themeOverlay = getDefaultThemeOverlay(activity, DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE);
            } else {
                themeOverlay = dynamicColorsOptions.getThemeOverlay();
            }
            theme = themeOverlay;
        }
        if (dynamicColorsOptions.getPrecondition().shouldApplyDynamicColors(activity, theme)) {
            if (dynamicColorsOptions.getContentBasedSeedColor() != null) {
                SchemeContent scheme = new SchemeContent(Hct.fromInt(dynamicColorsOptions.getContentBasedSeedColor().intValue()), !MaterialColors.isLightTheme(activity), getSystemContrast(activity));
                ColorResourcesOverride resourcesOverride = ColorResourcesOverride.getInstance();
                if (resourcesOverride == null || !resourcesOverride.applyIfPossible(activity, MaterialColorUtilitiesHelper.createColorResourcesIdsToColorValues(scheme))) {
                    return;
                }
            } else {
                ThemeUtils.applyThemeOverlay(activity, theme);
            }
            dynamicColorsOptions.getOnAppliedCallback().onApplied(activity);
        }
    }

    public static Context wrapContextIfAvailable(Context originalContext) {
        return wrapContextIfAvailable(originalContext, 0);
    }

    public static Context wrapContextIfAvailable(Context originalContext, int theme) {
        return wrapContextIfAvailable(originalContext, new DynamicColorsOptions.Builder().setThemeOverlay(theme).build());
    }

    public static Context wrapContextIfAvailable(Context originalContext, DynamicColorsOptions dynamicColorsOptions) {
        if (!isDynamicColorAvailable()) {
            return originalContext;
        }
        int theme = dynamicColorsOptions.getThemeOverlay();
        if (theme == 0) {
            theme = getDefaultThemeOverlay(originalContext, DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE);
        }
        if (theme == 0) {
            return originalContext;
        }
        if (dynamicColorsOptions.getContentBasedSeedColor() != null) {
            SchemeContent scheme = new SchemeContent(Hct.fromInt(dynamicColorsOptions.getContentBasedSeedColor().intValue()), !MaterialColors.isLightTheme(originalContext), getSystemContrast(originalContext));
            ColorResourcesOverride resourcesOverride = ColorResourcesOverride.getInstance();
            if (resourcesOverride != null) {
                return resourcesOverride.wrapContextIfPossible(originalContext, MaterialColorUtilitiesHelper.createColorResourcesIdsToColorValues(scheme));
            }
        }
        return new ContextThemeWrapper(originalContext, theme);
    }

    public static boolean isDynamicColorAvailable() {
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        if (BuildCompat.isAtLeastT()) {
            return true;
        }
        DeviceSupportCondition deviceSupportCondition = DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS.get(Build.MANUFACTURER.toLowerCase(Locale.ROOT));
        if (deviceSupportCondition == null) {
            deviceSupportCondition = DYNAMIC_COLOR_SUPPORTED_BRANDS.get(Build.BRAND.toLowerCase(Locale.ROOT));
        }
        return deviceSupportCondition != null && deviceSupportCondition.isSupported();
    }

    private static int getDefaultThemeOverlay(Context context, int[] themeOverlayAttribute) {
        TypedArray dynamicColorAttributes = context.obtainStyledAttributes(themeOverlayAttribute);
        int theme = dynamicColorAttributes.getResourceId(0, 0);
        dynamicColorAttributes.recycle();
        return theme;
    }

    private static class DynamicColorsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        private final DynamicColorsOptions dynamicColorsOptions;

        DynamicColorsActivityLifecycleCallbacks(DynamicColorsOptions options) {
            this.dynamicColorsOptions = options;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle savedInstanceState) {
            DynamicColors.applyToActivityIfAvailable(activity, this.dynamicColorsOptions);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }
    }

    private static float getSystemContrast(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        if (uiModeManager == null || Build.VERSION.SDK_INT < 34) {
            return 0.0f;
        }
        return uiModeManager.getContrast();
    }
}
