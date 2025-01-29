package com.google.android.material.color.utilities;

/* loaded from: classes.dex */
public class SchemeFruitSalad extends DynamicScheme {
    public SchemeFruitSalad(Hct sourceColorHct, boolean isDark, double contrastLevel) {
        super(sourceColorHct, Variant.FRUIT_SALAD, isDark, contrastLevel, TonalPalette.fromHueAndChroma(MathUtils.sanitizeDegreesDouble(sourceColorHct.getHue() - 50.0d), 48.0d), TonalPalette.fromHueAndChroma(MathUtils.sanitizeDegreesDouble(sourceColorHct.getHue() - 50.0d), 36.0d), TonalPalette.fromHueAndChroma(sourceColorHct.getHue(), 36.0d), TonalPalette.fromHueAndChroma(sourceColorHct.getHue(), 10.0d), TonalPalette.fromHueAndChroma(sourceColorHct.getHue(), 16.0d));
    }
}
