package com.google.android.material.color;

import com.google.android.material.R;
import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class MaterialColorUtilitiesHelper {
    private static final Map<Integer, DynamicColor> colorResourceIdToColorValue;
    private static final MaterialDynamicColors dynamicColors;

    private MaterialColorUtilitiesHelper() {
    }

    static {
        MaterialDynamicColors materialDynamicColors = new MaterialDynamicColors();
        dynamicColors = materialDynamicColors;
        Map<Integer, DynamicColor> map = new HashMap<>();
        map.put(Integer.valueOf(R.color.material_personalized_color_primary), materialDynamicColors.primary());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_primary), materialDynamicColors.onPrimary());
        map.put(Integer.valueOf(R.color.material_personalized_color_primary_inverse), materialDynamicColors.inversePrimary());
        map.put(Integer.valueOf(R.color.material_personalized_color_primary_container), materialDynamicColors.primaryContainer());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_primary_container), materialDynamicColors.onPrimaryContainer());
        map.put(Integer.valueOf(R.color.material_personalized_color_secondary), materialDynamicColors.secondary());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_secondary), materialDynamicColors.onSecondary());
        map.put(Integer.valueOf(R.color.material_personalized_color_secondary_container), materialDynamicColors.secondaryContainer());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_secondary_container), materialDynamicColors.onSecondaryContainer());
        map.put(Integer.valueOf(R.color.material_personalized_color_tertiary), materialDynamicColors.tertiary());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_tertiary), materialDynamicColors.onTertiary());
        map.put(Integer.valueOf(R.color.material_personalized_color_tertiary_container), materialDynamicColors.tertiaryContainer());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_tertiary_container), materialDynamicColors.onTertiaryContainer());
        map.put(Integer.valueOf(R.color.material_personalized_color_background), materialDynamicColors.background());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_background), materialDynamicColors.onBackground());
        map.put(Integer.valueOf(R.color.material_personalized_color_surface), materialDynamicColors.surface());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_surface), materialDynamicColors.onSurface());
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_variant), materialDynamicColors.surfaceVariant());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_surface_variant), materialDynamicColors.onSurfaceVariant());
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_inverse), materialDynamicColors.inverseSurface());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_surface_inverse), materialDynamicColors.inverseOnSurface());
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_bright), materialDynamicColors.surfaceBright());
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_dim), materialDynamicColors.surfaceDim());
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_container), materialDynamicColors.surfaceContainer());
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_container_low), materialDynamicColors.surfaceContainerLow());
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_container_high), materialDynamicColors.surfaceContainerHigh());
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_container_lowest), materialDynamicColors.surfaceContainerLowest());
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_container_highest), materialDynamicColors.surfaceContainerHighest());
        map.put(Integer.valueOf(R.color.material_personalized_color_outline), materialDynamicColors.outline());
        map.put(Integer.valueOf(R.color.material_personalized_color_outline_variant), materialDynamicColors.outlineVariant());
        map.put(Integer.valueOf(R.color.material_personalized_color_error), materialDynamicColors.error());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_error), materialDynamicColors.onError());
        map.put(Integer.valueOf(R.color.material_personalized_color_error_container), materialDynamicColors.errorContainer());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_error_container), materialDynamicColors.onErrorContainer());
        map.put(Integer.valueOf(R.color.material_personalized_color_control_activated), materialDynamicColors.controlActivated());
        map.put(Integer.valueOf(R.color.material_personalized_color_control_normal), materialDynamicColors.controlNormal());
        map.put(Integer.valueOf(R.color.material_personalized_color_control_highlight), materialDynamicColors.controlHighlight());
        map.put(Integer.valueOf(R.color.material_personalized_color_text_primary_inverse), materialDynamicColors.textPrimaryInverse());
        map.put(Integer.valueOf(R.color.material_personalized_color_text_secondary_and_tertiary_inverse), materialDynamicColors.textSecondaryAndTertiaryInverse());
        map.put(Integer.valueOf(R.color.material_personalized_color_text_secondary_and_tertiary_inverse_disabled), materialDynamicColors.textSecondaryAndTertiaryInverseDisabled());
        map.put(Integer.valueOf(R.color.material_personalized_color_text_primary_inverse_disable_only), materialDynamicColors.textPrimaryInverseDisableOnly());
        map.put(Integer.valueOf(R.color.material_personalized_color_text_hint_foreground_inverse), materialDynamicColors.textHintInverse());
        colorResourceIdToColorValue = Collections.unmodifiableMap(map);
    }

    public static Map<Integer, Integer> createColorResourcesIdsToColorValues(DynamicScheme colorScheme) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Map.Entry<Integer, DynamicColor> entry : colorResourceIdToColorValue.entrySet()) {
            map.put(entry.getKey(), Integer.valueOf(entry.getValue().getArgb(colorScheme)));
        }
        return Collections.unmodifiableMap(map);
    }
}
