package com.google.android.material.color.utilities;

import com.google.errorprone.annotations.CheckReturnValue;

@CheckReturnValue
/* loaded from: classes2.dex */
public class Scheme {
    private int background;
    private int error;
    private int errorContainer;
    private int inverseOnSurface;
    private int inversePrimary;
    private int inverseSurface;
    private int onBackground;
    private int onError;
    private int onErrorContainer;
    private int onPrimary;
    private int onPrimaryContainer;
    private int onSecondary;
    private int onSecondaryContainer;
    private int onSurface;
    private int onSurfaceVariant;
    private int onTertiary;
    private int onTertiaryContainer;
    private int outline;
    private int outlineVariant;
    private int primary;
    private int primaryContainer;
    private int scrim;
    private int secondary;
    private int secondaryContainer;
    private int shadow;
    private int surface;
    private int surfaceVariant;
    private int tertiary;
    private int tertiaryContainer;

    public Scheme() {
    }

    public Scheme(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29) {
        this.primary = i;
        this.onPrimary = i2;
        this.primaryContainer = i3;
        this.onPrimaryContainer = i4;
        this.secondary = i5;
        this.onSecondary = i6;
        this.secondaryContainer = i7;
        this.onSecondaryContainer = i8;
        this.tertiary = i9;
        this.onTertiary = i10;
        this.tertiaryContainer = i11;
        this.onTertiaryContainer = i12;
        this.error = i13;
        this.onError = i14;
        this.errorContainer = i15;
        this.onErrorContainer = i16;
        this.background = i17;
        this.onBackground = i18;
        this.surface = i19;
        this.onSurface = i20;
        this.surfaceVariant = i21;
        this.onSurfaceVariant = i22;
        this.outline = i23;
        this.outlineVariant = i24;
        this.shadow = i25;
        this.scrim = i26;
        this.inverseSurface = i27;
        this.inverseOnSurface = i28;
        this.inversePrimary = i29;
    }

    public static Scheme light(int i) {
        return lightFromCorePalette(CorePalette.of(i));
    }

    public static Scheme dark(int i) {
        return darkFromCorePalette(CorePalette.of(i));
    }

    public static Scheme lightContent(int i) {
        return lightFromCorePalette(CorePalette.contentOf(i));
    }

    public static Scheme darkContent(int i) {
        return darkFromCorePalette(CorePalette.contentOf(i));
    }

    private static Scheme lightFromCorePalette(CorePalette corePalette) {
        return new Scheme().withPrimary(corePalette.a1.tone(40)).withOnPrimary(corePalette.a1.tone(100)).withPrimaryContainer(corePalette.a1.tone(90)).withOnPrimaryContainer(corePalette.a1.tone(10)).withSecondary(corePalette.a2.tone(40)).withOnSecondary(corePalette.a2.tone(100)).withSecondaryContainer(corePalette.a2.tone(90)).withOnSecondaryContainer(corePalette.a2.tone(10)).withTertiary(corePalette.a3.tone(40)).withOnTertiary(corePalette.a3.tone(100)).withTertiaryContainer(corePalette.a3.tone(90)).withOnTertiaryContainer(corePalette.a3.tone(10)).withError(corePalette.error.tone(40)).withOnError(corePalette.error.tone(100)).withErrorContainer(corePalette.error.tone(90)).withOnErrorContainer(corePalette.error.tone(10)).withBackground(corePalette.n1.tone(99)).withOnBackground(corePalette.n1.tone(10)).withSurface(corePalette.n1.tone(99)).withOnSurface(corePalette.n1.tone(10)).withSurfaceVariant(corePalette.n2.tone(90)).withOnSurfaceVariant(corePalette.n2.tone(30)).withOutline(corePalette.n2.tone(50)).withOutlineVariant(corePalette.n2.tone(80)).withShadow(corePalette.n1.tone(0)).withScrim(corePalette.n1.tone(0)).withInverseSurface(corePalette.n1.tone(20)).withInverseOnSurface(corePalette.n1.tone(95)).withInversePrimary(corePalette.a1.tone(80));
    }

    private static Scheme darkFromCorePalette(CorePalette corePalette) {
        return new Scheme().withPrimary(corePalette.a1.tone(80)).withOnPrimary(corePalette.a1.tone(20)).withPrimaryContainer(corePalette.a1.tone(30)).withOnPrimaryContainer(corePalette.a1.tone(90)).withSecondary(corePalette.a2.tone(80)).withOnSecondary(corePalette.a2.tone(20)).withSecondaryContainer(corePalette.a2.tone(30)).withOnSecondaryContainer(corePalette.a2.tone(90)).withTertiary(corePalette.a3.tone(80)).withOnTertiary(corePalette.a3.tone(20)).withTertiaryContainer(corePalette.a3.tone(30)).withOnTertiaryContainer(corePalette.a3.tone(90)).withError(corePalette.error.tone(80)).withOnError(corePalette.error.tone(20)).withErrorContainer(corePalette.error.tone(30)).withOnErrorContainer(corePalette.error.tone(80)).withBackground(corePalette.n1.tone(10)).withOnBackground(corePalette.n1.tone(90)).withSurface(corePalette.n1.tone(10)).withOnSurface(corePalette.n1.tone(90)).withSurfaceVariant(corePalette.n2.tone(30)).withOnSurfaceVariant(corePalette.n2.tone(80)).withOutline(corePalette.n2.tone(60)).withOutlineVariant(corePalette.n2.tone(30)).withShadow(corePalette.n1.tone(0)).withScrim(corePalette.n1.tone(0)).withInverseSurface(corePalette.n1.tone(90)).withInverseOnSurface(corePalette.n1.tone(20)).withInversePrimary(corePalette.a1.tone(40));
    }

    public int getPrimary() {
        return this.primary;
    }

    public void setPrimary(int i) {
        this.primary = i;
    }

    public Scheme withPrimary(int i) {
        this.primary = i;
        return this;
    }

    public int getOnPrimary() {
        return this.onPrimary;
    }

    public void setOnPrimary(int i) {
        this.onPrimary = i;
    }

    public Scheme withOnPrimary(int i) {
        this.onPrimary = i;
        return this;
    }

    public int getPrimaryContainer() {
        return this.primaryContainer;
    }

    public void setPrimaryContainer(int i) {
        this.primaryContainer = i;
    }

    public Scheme withPrimaryContainer(int i) {
        this.primaryContainer = i;
        return this;
    }

    public int getOnPrimaryContainer() {
        return this.onPrimaryContainer;
    }

    public void setOnPrimaryContainer(int i) {
        this.onPrimaryContainer = i;
    }

    public Scheme withOnPrimaryContainer(int i) {
        this.onPrimaryContainer = i;
        return this;
    }

    public int getSecondary() {
        return this.secondary;
    }

    public void setSecondary(int i) {
        this.secondary = i;
    }

    public Scheme withSecondary(int i) {
        this.secondary = i;
        return this;
    }

    public int getOnSecondary() {
        return this.onSecondary;
    }

    public void setOnSecondary(int i) {
        this.onSecondary = i;
    }

    public Scheme withOnSecondary(int i) {
        this.onSecondary = i;
        return this;
    }

    public int getSecondaryContainer() {
        return this.secondaryContainer;
    }

    public void setSecondaryContainer(int i) {
        this.secondaryContainer = i;
    }

    public Scheme withSecondaryContainer(int i) {
        this.secondaryContainer = i;
        return this;
    }

    public int getOnSecondaryContainer() {
        return this.onSecondaryContainer;
    }

    public void setOnSecondaryContainer(int i) {
        this.onSecondaryContainer = i;
    }

    public Scheme withOnSecondaryContainer(int i) {
        this.onSecondaryContainer = i;
        return this;
    }

    public int getTertiary() {
        return this.tertiary;
    }

    public void setTertiary(int i) {
        this.tertiary = i;
    }

    public Scheme withTertiary(int i) {
        this.tertiary = i;
        return this;
    }

    public int getOnTertiary() {
        return this.onTertiary;
    }

    public void setOnTertiary(int i) {
        this.onTertiary = i;
    }

    public Scheme withOnTertiary(int i) {
        this.onTertiary = i;
        return this;
    }

    public int getTertiaryContainer() {
        return this.tertiaryContainer;
    }

    public void setTertiaryContainer(int i) {
        this.tertiaryContainer = i;
    }

    public Scheme withTertiaryContainer(int i) {
        this.tertiaryContainer = i;
        return this;
    }

    public int getOnTertiaryContainer() {
        return this.onTertiaryContainer;
    }

    public void setOnTertiaryContainer(int i) {
        this.onTertiaryContainer = i;
    }

    public Scheme withOnTertiaryContainer(int i) {
        this.onTertiaryContainer = i;
        return this;
    }

    public int getError() {
        return this.error;
    }

    public void setError(int i) {
        this.error = i;
    }

    public Scheme withError(int i) {
        this.error = i;
        return this;
    }

    public int getOnError() {
        return this.onError;
    }

    public void setOnError(int i) {
        this.onError = i;
    }

    public Scheme withOnError(int i) {
        this.onError = i;
        return this;
    }

    public int getErrorContainer() {
        return this.errorContainer;
    }

    public void setErrorContainer(int i) {
        this.errorContainer = i;
    }

    public Scheme withErrorContainer(int i) {
        this.errorContainer = i;
        return this;
    }

    public int getOnErrorContainer() {
        return this.onErrorContainer;
    }

    public void setOnErrorContainer(int i) {
        this.onErrorContainer = i;
    }

    public Scheme withOnErrorContainer(int i) {
        this.onErrorContainer = i;
        return this;
    }

    public int getBackground() {
        return this.background;
    }

    public void setBackground(int i) {
        this.background = i;
    }

    public Scheme withBackground(int i) {
        this.background = i;
        return this;
    }

    public int getOnBackground() {
        return this.onBackground;
    }

    public void setOnBackground(int i) {
        this.onBackground = i;
    }

    public Scheme withOnBackground(int i) {
        this.onBackground = i;
        return this;
    }

    public int getSurface() {
        return this.surface;
    }

    public void setSurface(int i) {
        this.surface = i;
    }

    public Scheme withSurface(int i) {
        this.surface = i;
        return this;
    }

    public int getOnSurface() {
        return this.onSurface;
    }

    public void setOnSurface(int i) {
        this.onSurface = i;
    }

    public Scheme withOnSurface(int i) {
        this.onSurface = i;
        return this;
    }

    public int getSurfaceVariant() {
        return this.surfaceVariant;
    }

    public void setSurfaceVariant(int i) {
        this.surfaceVariant = i;
    }

    public Scheme withSurfaceVariant(int i) {
        this.surfaceVariant = i;
        return this;
    }

    public int getOnSurfaceVariant() {
        return this.onSurfaceVariant;
    }

    public void setOnSurfaceVariant(int i) {
        this.onSurfaceVariant = i;
    }

    public Scheme withOnSurfaceVariant(int i) {
        this.onSurfaceVariant = i;
        return this;
    }

    public int getOutline() {
        return this.outline;
    }

    public void setOutline(int i) {
        this.outline = i;
    }

    public Scheme withOutline(int i) {
        this.outline = i;
        return this;
    }

    public int getOutlineVariant() {
        return this.outlineVariant;
    }

    public void setOutlineVariant(int i) {
        this.outlineVariant = i;
    }

    public Scheme withOutlineVariant(int i) {
        this.outlineVariant = i;
        return this;
    }

    public int getShadow() {
        return this.shadow;
    }

    public void setShadow(int i) {
        this.shadow = i;
    }

    public Scheme withShadow(int i) {
        this.shadow = i;
        return this;
    }

    public int getScrim() {
        return this.scrim;
    }

    public void setScrim(int i) {
        this.scrim = i;
    }

    public Scheme withScrim(int i) {
        this.scrim = i;
        return this;
    }

    public int getInverseSurface() {
        return this.inverseSurface;
    }

    public void setInverseSurface(int i) {
        this.inverseSurface = i;
    }

    public Scheme withInverseSurface(int i) {
        this.inverseSurface = i;
        return this;
    }

    public int getInverseOnSurface() {
        return this.inverseOnSurface;
    }

    public void setInverseOnSurface(int i) {
        this.inverseOnSurface = i;
    }

    public Scheme withInverseOnSurface(int i) {
        this.inverseOnSurface = i;
        return this;
    }

    public int getInversePrimary() {
        return this.inversePrimary;
    }

    public void setInversePrimary(int i) {
        this.inversePrimary = i;
    }

    public Scheme withInversePrimary(int i) {
        this.inversePrimary = i;
        return this;
    }

    public String toString() {
        return "Scheme{primary=" + this.primary + ", onPrimary=" + this.onPrimary + ", primaryContainer=" + this.primaryContainer + ", onPrimaryContainer=" + this.onPrimaryContainer + ", secondary=" + this.secondary + ", onSecondary=" + this.onSecondary + ", secondaryContainer=" + this.secondaryContainer + ", onSecondaryContainer=" + this.onSecondaryContainer + ", tertiary=" + this.tertiary + ", onTertiary=" + this.onTertiary + ", tertiaryContainer=" + this.tertiaryContainer + ", onTertiaryContainer=" + this.onTertiaryContainer + ", error=" + this.error + ", onError=" + this.onError + ", errorContainer=" + this.errorContainer + ", onErrorContainer=" + this.onErrorContainer + ", background=" + this.background + ", onBackground=" + this.onBackground + ", surface=" + this.surface + ", onSurface=" + this.onSurface + ", surfaceVariant=" + this.surfaceVariant + ", onSurfaceVariant=" + this.onSurfaceVariant + ", outline=" + this.outline + ", outlineVariant=" + this.outlineVariant + ", shadow=" + this.shadow + ", scrim=" + this.scrim + ", inverseSurface=" + this.inverseSurface + ", inverseOnSurface=" + this.inverseOnSurface + ", inversePrimary=" + this.inversePrimary + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scheme) || !super.equals(obj)) {
            return false;
        }
        Scheme scheme = (Scheme) obj;
        return this.primary == scheme.primary && this.onPrimary == scheme.onPrimary && this.primaryContainer == scheme.primaryContainer && this.onPrimaryContainer == scheme.onPrimaryContainer && this.secondary == scheme.secondary && this.onSecondary == scheme.onSecondary && this.secondaryContainer == scheme.secondaryContainer && this.onSecondaryContainer == scheme.onSecondaryContainer && this.tertiary == scheme.tertiary && this.onTertiary == scheme.onTertiary && this.tertiaryContainer == scheme.tertiaryContainer && this.onTertiaryContainer == scheme.onTertiaryContainer && this.error == scheme.error && this.onError == scheme.onError && this.errorContainer == scheme.errorContainer && this.onErrorContainer == scheme.onErrorContainer && this.background == scheme.background && this.onBackground == scheme.onBackground && this.surface == scheme.surface && this.onSurface == scheme.onSurface && this.surfaceVariant == scheme.surfaceVariant && this.onSurfaceVariant == scheme.onSurfaceVariant && this.outline == scheme.outline && this.outlineVariant == scheme.outlineVariant && this.shadow == scheme.shadow && this.scrim == scheme.scrim && this.inverseSurface == scheme.inverseSurface && this.inverseOnSurface == scheme.inverseOnSurface && this.inversePrimary == scheme.inversePrimary;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((super.hashCode() * 31) + this.primary) * 31) + this.onPrimary) * 31) + this.primaryContainer) * 31) + this.onPrimaryContainer) * 31) + this.secondary) * 31) + this.onSecondary) * 31) + this.secondaryContainer) * 31) + this.onSecondaryContainer) * 31) + this.tertiary) * 31) + this.onTertiary) * 31) + this.tertiaryContainer) * 31) + this.onTertiaryContainer) * 31) + this.error) * 31) + this.onError) * 31) + this.errorContainer) * 31) + this.onErrorContainer) * 31) + this.background) * 31) + this.onBackground) * 31) + this.surface) * 31) + this.onSurface) * 31) + this.surfaceVariant) * 31) + this.onSurfaceVariant) * 31) + this.outline) * 31) + this.outlineVariant) * 31) + this.shadow) * 31) + this.scrim) * 31) + this.inverseSurface) * 31) + this.inverseOnSurface) * 31) + this.inversePrimary;
    }
}
