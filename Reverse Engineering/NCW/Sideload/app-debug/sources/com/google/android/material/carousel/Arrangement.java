package com.google.android.material.carousel;

import androidx.core.math.MathUtils;

/* loaded from: classes.dex */
final class Arrangement {
    private static final float MEDIUM_ITEM_FLEX_PERCENTAGE = 0.1f;
    final float cost;
    final int largeCount;
    float largeSize;
    int mediumCount;
    float mediumSize;
    final int priority;
    int smallCount;
    float smallSize;

    Arrangement(int priority, float targetSmallSize, float minSmallSize, float maxSmallSize, int smallCount, float targetMediumSize, int mediumCount, float targetLargeSize, int largeCount, float availableSpace) {
        this.priority = priority;
        this.smallSize = MathUtils.clamp(targetSmallSize, minSmallSize, maxSmallSize);
        this.smallCount = smallCount;
        this.mediumSize = targetMediumSize;
        this.mediumCount = mediumCount;
        this.largeSize = targetLargeSize;
        this.largeCount = largeCount;
        fit(availableSpace, minSmallSize, maxSmallSize, targetLargeSize);
        this.cost = cost(targetLargeSize);
    }

    public String toString() {
        return "Arrangement [priority=" + this.priority + ", smallCount=" + this.smallCount + ", smallSize=" + this.smallSize + ", mediumCount=" + this.mediumCount + ", mediumSize=" + this.mediumSize + ", largeCount=" + this.largeCount + ", largeSize=" + this.largeSize + ", cost=" + this.cost + "]";
    }

    private float getSpace() {
        return (this.largeSize * this.largeCount) + (this.mediumSize * this.mediumCount) + (this.smallSize * this.smallCount);
    }

    private void fit(float availableSpace, float minSmallSize, float maxSmallSize, float targetLargeSize) {
        float delta = availableSpace - getSpace();
        int i = this.smallCount;
        if (i > 0 && delta > 0.0f) {
            float f = this.smallSize;
            this.smallSize = f + Math.min(delta / i, maxSmallSize - f);
        } else if (i > 0 && delta < 0.0f) {
            float f2 = this.smallSize;
            this.smallSize = f2 + Math.max(delta / i, minSmallSize - f2);
        }
        int i2 = this.smallCount;
        float f3 = i2 > 0 ? this.smallSize : 0.0f;
        this.smallSize = f3;
        float calculateLargeSize = calculateLargeSize(availableSpace, i2, f3, this.mediumCount, this.largeCount);
        this.largeSize = calculateLargeSize;
        float f4 = (this.smallSize + calculateLargeSize) / 2.0f;
        this.mediumSize = f4;
        int i3 = this.mediumCount;
        if (i3 > 0 && calculateLargeSize != targetLargeSize) {
            float targetAdjustment = (targetLargeSize - calculateLargeSize) * this.largeCount;
            float availableMediumFlex = f4 * 0.1f * i3;
            float distribute = Math.min(Math.abs(targetAdjustment), availableMediumFlex);
            if (targetAdjustment > 0.0f) {
                this.mediumSize -= distribute / this.mediumCount;
                this.largeSize += distribute / this.largeCount;
            } else {
                this.mediumSize += distribute / this.mediumCount;
                this.largeSize -= distribute / this.largeCount;
            }
        }
    }

    private float calculateLargeSize(float availableSpace, int smallCount, float smallSize, int mediumCount, int largeCount) {
        return (availableSpace - ((smallCount + (mediumCount / 2.0f)) * (smallCount > 0 ? smallSize : 0.0f))) / (largeCount + (mediumCount / 2.0f));
    }

    private boolean isValid() {
        int i = this.largeCount;
        if (i <= 0 || this.smallCount <= 0 || this.mediumCount <= 0) {
            return i <= 0 || this.smallCount <= 0 || this.largeSize > this.smallSize;
        }
        float f = this.largeSize;
        float f2 = this.mediumSize;
        return f > f2 && f2 > this.smallSize;
    }

    private float cost(float targetLargeSize) {
        if (!isValid()) {
            return Float.MAX_VALUE;
        }
        return Math.abs(targetLargeSize - this.largeSize) * this.priority;
    }

    static Arrangement findLowestCostArrangement(float availableSpace, float targetSmallSize, float minSmallSize, float maxSmallSize, int[] smallCounts, float targetMediumSize, int[] mediumCounts, float targetLargeSize, int[] largeCounts) {
        Arrangement lowestCostArrangement = null;
        int priority = 1;
        for (int largeCount : largeCounts) {
            int length = mediumCounts.length;
            int i = 0;
            while (i < length) {
                int mediumCount = mediumCounts[i];
                int length2 = smallCounts.length;
                int i2 = 0;
                while (i2 < length2) {
                    int smallCount = smallCounts[i2];
                    int i3 = i2;
                    int i4 = length2;
                    int i5 = i;
                    int i6 = length;
                    Arrangement arrangement = new Arrangement(priority, targetSmallSize, minSmallSize, maxSmallSize, smallCount, targetMediumSize, mediumCount, targetLargeSize, largeCount, availableSpace);
                    if (lowestCostArrangement == null || arrangement.cost < lowestCostArrangement.cost) {
                        lowestCostArrangement = arrangement;
                        if (lowestCostArrangement.cost == 0.0f) {
                            return lowestCostArrangement;
                        }
                    }
                    priority++;
                    i2 = i3 + 1;
                    length2 = i4;
                    i = i5;
                    length = i6;
                }
                i++;
            }
        }
        return lowestCostArrangement;
    }

    int getItemCount() {
        return this.smallCount + this.mediumCount + this.largeCount;
    }
}
