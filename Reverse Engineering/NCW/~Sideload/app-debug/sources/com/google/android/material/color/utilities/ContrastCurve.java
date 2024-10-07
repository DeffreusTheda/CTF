package com.google.android.material.color.utilities;

/* loaded from: classes.dex */
public final class ContrastCurve {
    private final double high;
    private final double low;
    private final double medium;
    private final double normal;

    public ContrastCurve(double low, double normal, double medium, double high) {
        this.low = low;
        this.normal = normal;
        this.medium = medium;
        this.high = high;
    }

    public double getContrast(double contrastLevel) {
        if (contrastLevel <= -1.0d) {
            return this.low;
        }
        if (contrastLevel < 0.0d) {
            return MathUtils.lerp(this.low, this.normal, (contrastLevel - (-1.0d)) / 1.0d);
        }
        if (contrastLevel < 0.5d) {
            return MathUtils.lerp(this.normal, this.medium, (contrastLevel - 0.0d) / 0.5d);
        }
        if (contrastLevel < 1.0d) {
            return MathUtils.lerp(this.medium, this.high, (contrastLevel - 0.5d) / 0.5d);
        }
        return this.high;
    }
}
