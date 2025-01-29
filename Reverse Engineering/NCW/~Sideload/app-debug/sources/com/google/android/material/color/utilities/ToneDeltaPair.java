package com.google.android.material.color.utilities;

/* loaded from: classes.dex */
public final class ToneDeltaPair {
    private final double delta;
    private final TonePolarity polarity;
    private final DynamicColor roleA;
    private final DynamicColor roleB;
    private final boolean stayTogether;

    public ToneDeltaPair(DynamicColor roleA, DynamicColor roleB, double delta, TonePolarity polarity, boolean stayTogether) {
        this.roleA = roleA;
        this.roleB = roleB;
        this.delta = delta;
        this.polarity = polarity;
        this.stayTogether = stayTogether;
    }

    public DynamicColor getRoleA() {
        return this.roleA;
    }

    public DynamicColor getRoleB() {
        return this.roleB;
    }

    public double getDelta() {
        return this.delta;
    }

    public TonePolarity getPolarity() {
        return this.polarity;
    }

    public boolean getStayTogether() {
        return this.stayTogether;
    }
}
