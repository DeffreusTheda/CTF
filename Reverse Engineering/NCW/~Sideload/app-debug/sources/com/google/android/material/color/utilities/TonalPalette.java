package com.google.android.material.color.utilities;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class TonalPalette {
    Map<Integer, Integer> cache = new HashMap();
    double chroma;
    double hue;
    Hct keyColor;

    public static TonalPalette fromInt(int argb) {
        return fromHct(Hct.fromInt(argb));
    }

    public static TonalPalette fromHct(Hct hct) {
        return new TonalPalette(hct.getHue(), hct.getChroma(), hct);
    }

    public static TonalPalette fromHueAndChroma(double hue, double chroma) {
        return new TonalPalette(hue, chroma, createKeyColor(hue, chroma));
    }

    private TonalPalette(double hue, double chroma, Hct keyColor) {
        this.hue = hue;
        this.chroma = chroma;
        this.keyColor = keyColor;
    }

    private static Hct createKeyColor(double hue, double chroma) {
        Hct smallestDeltaHct = Hct.from(hue, chroma, 50.0d);
        double smallestDelta = Math.abs(smallestDeltaHct.getChroma() - chroma);
        Hct smallestDeltaHct2 = smallestDeltaHct;
        double smallestDelta2 = smallestDelta;
        for (double delta = 1.0d; delta < 50.0d; delta += 1.0d) {
            if (Math.round(chroma) == Math.round(smallestDeltaHct2.getChroma())) {
                return smallestDeltaHct2;
            }
            Hct hctAdd = Hct.from(hue, chroma, 50.0d + delta);
            double hctAddDelta = Math.abs(hctAdd.getChroma() - chroma);
            if (hctAddDelta < smallestDelta2) {
                smallestDelta2 = hctAddDelta;
                smallestDeltaHct2 = hctAdd;
            }
            Hct hctSubtract = Hct.from(hue, chroma, 50.0d - delta);
            double hctSubtractDelta = Math.abs(hctSubtract.getChroma() - chroma);
            if (hctSubtractDelta < smallestDelta2) {
                smallestDelta2 = hctSubtractDelta;
                smallestDeltaHct2 = hctSubtract;
            }
        }
        return smallestDeltaHct2;
    }

    public int tone(int tone) {
        Integer color = this.cache.get(Integer.valueOf(tone));
        if (color == null) {
            color = Integer.valueOf(Hct.from(this.hue, this.chroma, tone).toInt());
            this.cache.put(Integer.valueOf(tone), color);
        }
        return color.intValue();
    }

    public Hct getHct(double tone) {
        return Hct.from(this.hue, this.chroma, tone);
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getHue() {
        return this.hue;
    }

    public Hct getKeyColor() {
        return this.keyColor;
    }
}
