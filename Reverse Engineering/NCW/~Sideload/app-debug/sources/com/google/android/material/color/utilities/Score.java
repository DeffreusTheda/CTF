package com.google.android.material.color.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class Score {
    private static final int BLUE_500 = -12417548;
    private static final double CUTOFF_CHROMA = 5.0d;
    private static final double CUTOFF_EXCITED_PROPORTION = 0.01d;
    private static final int MAX_COLOR_COUNT = 4;
    private static final double TARGET_CHROMA = 48.0d;
    private static final double WEIGHT_CHROMA_ABOVE = 0.3d;
    private static final double WEIGHT_CHROMA_BELOW = 0.1d;
    private static final double WEIGHT_PROPORTION = 0.7d;

    private Score() {
    }

    public static List<Integer> score(Map<Integer, Integer> colorsToPopulation) {
        return score(colorsToPopulation, 4, BLUE_500, true);
    }

    public static List<Integer> score(Map<Integer, Integer> colorsToPopulation, int maxColorCount) {
        return score(colorsToPopulation, maxColorCount, BLUE_500, true);
    }

    public static List<Integer> score(Map<Integer, Integer> colorsToPopulation, int maxColorCount, int fallbackColorArgb) {
        return score(colorsToPopulation, maxColorCount, fallbackColorArgb, true);
    }

    public static List<Integer> score(Map<Integer, Integer> colorsToPopulation, int maxColorCount, int fallbackColorArgb, boolean filter) {
        List<Hct> colorsHct = new ArrayList<>();
        int[] huePopulation = new int[360];
        double populationSum = 0.0d;
        for (Map.Entry<Integer, Integer> entry : colorsToPopulation.entrySet()) {
            Hct hct = Hct.fromInt(entry.getKey().intValue());
            colorsHct.add(hct);
            int hue = (int) Math.floor(hct.getHue());
            int population = entry.getValue().intValue();
            huePopulation[hue] = huePopulation[hue] + population;
            populationSum += population;
        }
        double[] hueExcitedProportions = new double[360];
        for (int hue2 = 0; hue2 < 360; hue2++) {
            double proportion = huePopulation[hue2] / populationSum;
            for (int i = hue2 - 14; i < hue2 + 16; i++) {
                int neighborHue = MathUtils.sanitizeDegreesInt(i);
                hueExcitedProportions[neighborHue] = hueExcitedProportions[neighborHue] + proportion;
            }
        }
        List<ScoredHCT> scoredHcts = new ArrayList<>();
        for (Hct hct2 : colorsHct) {
            int hue3 = MathUtils.sanitizeDegreesInt((int) Math.round(hct2.getHue()));
            double proportion2 = hueExcitedProportions[hue3];
            if (!filter || (hct2.getChroma() >= CUTOFF_CHROMA && proportion2 > CUTOFF_EXCITED_PROPORTION)) {
                double proportionScore = 100.0d * proportion2 * WEIGHT_PROPORTION;
                double chromaWeight = hct2.getChroma() < TARGET_CHROMA ? WEIGHT_CHROMA_BELOW : WEIGHT_CHROMA_ABOVE;
                double chromaScore = (hct2.getChroma() - TARGET_CHROMA) * chromaWeight;
                int[] huePopulation2 = huePopulation;
                double score = proportionScore + chromaScore;
                scoredHcts.add(new ScoredHCT(hct2, score));
                huePopulation = huePopulation2;
                populationSum = populationSum;
            }
        }
        Collections.sort(scoredHcts, new ScoredComparator());
        List<Hct> chosenColors = new ArrayList<>();
        for (int differenceDegrees = 90; differenceDegrees >= 15; differenceDegrees--) {
            chosenColors.clear();
            Iterator<ScoredHCT> it = scoredHcts.iterator();
            while (it.hasNext()) {
                Hct hct3 = it.next().hct;
                boolean hasDuplicateHue = false;
                Iterator<Hct> it2 = chosenColors.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Hct chosenHct = it2.next();
                    if (MathUtils.differenceDegrees(hct3.getHue(), chosenHct.getHue()) < differenceDegrees) {
                        hasDuplicateHue = true;
                        break;
                    }
                }
                if (!hasDuplicateHue) {
                    chosenColors.add(hct3);
                }
                if (chosenColors.size() >= maxColorCount) {
                    break;
                }
            }
            if (chosenColors.size() >= maxColorCount) {
                break;
            }
        }
        List<Integer> colors = new ArrayList<>();
        if (chosenColors.isEmpty()) {
            colors.add(Integer.valueOf(fallbackColorArgb));
            return colors;
        }
        for (Hct chosenHct2 : chosenColors) {
            colors.add(Integer.valueOf(chosenHct2.toInt()));
        }
        return colors;
    }

    private static class ScoredHCT {
        public final Hct hct;
        public final double score;

        public ScoredHCT(Hct hct, double score) {
            this.hct = hct;
            this.score = score;
        }
    }

    private static class ScoredComparator implements Comparator<ScoredHCT> {
        @Override // java.util.Comparator
        public int compare(ScoredHCT entry1, ScoredHCT entry2) {
            return Double.compare(entry2.score, entry1.score);
        }
    }
}
