package com.google.android.material.color;

/* loaded from: classes.dex */
public class ColorContrastOptions {
    private final int highContrastThemeOverlayResourceId;
    private final int mediumContrastThemeOverlayResourceId;

    private ColorContrastOptions(Builder builder) {
        this.mediumContrastThemeOverlayResourceId = builder.mediumContrastThemeOverlayResourceId;
        this.highContrastThemeOverlayResourceId = builder.highContrastThemeOverlayResourceId;
    }

    public int getMediumContrastThemeOverlay() {
        return this.mediumContrastThemeOverlayResourceId;
    }

    public int getHighContrastThemeOverlay() {
        return this.highContrastThemeOverlayResourceId;
    }

    public static class Builder {
        private int highContrastThemeOverlayResourceId;
        private int mediumContrastThemeOverlayResourceId;

        public Builder setMediumContrastThemeOverlay(int mediumContrastThemeOverlayResourceId) {
            this.mediumContrastThemeOverlayResourceId = mediumContrastThemeOverlayResourceId;
            return this;
        }

        public Builder setHighContrastThemeOverlay(int highContrastThemeOverlayResourceId) {
            this.highContrastThemeOverlayResourceId = highContrastThemeOverlayResourceId;
            return this;
        }

        public ColorContrastOptions build() {
            return new ColorContrastOptions(this);
        }
    }
}
