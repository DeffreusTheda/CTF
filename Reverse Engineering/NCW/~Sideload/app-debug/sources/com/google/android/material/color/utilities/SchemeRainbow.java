package com.google.android.material.color.utilities;

/* loaded from: classes.dex */
public class SchemeRainbow extends DynamicScheme {
    public SchemeRainbow(Hct sourceColorHct, boolean isDark, double contrastLevel) {
        super(sourceColorHct, Variant.RAINBOW, isDark, contrastLevel, TonalPalette.fromHueAndChroma(sourceColorHct.getHue(), 48.0d), TonalPalette.fromHueAndChroma(sourceColorHct.getHue(), 16.0d), TonalPalette.fromHueAndChroma(MathUtils.sanitizeDegreesDouble(sourceColorHct.getHue() + 60.0d), 24.0d), TonalPalette.fromHueAndChroma(sourceColorHct.getHue(), 0.0d), TonalPalette.fromHueAndChroma(sourceColorHct.getHue(), 0.0d));
    }
}
