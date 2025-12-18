package org.tagcloud;

import java.awt.*;

public abstract class ColorMapper {
    public abstract Color getColor(final WeightedWordInterface weightedWord);

    private double minValue = Double.MIN_VALUE;
    private double maxValue = Double.MAX_VALUE;

    public double getMinimumValue() {
        return minValue;
    }

    public void setMinimumValue(double minValue) {
        this.minValue = minValue;
    }

    public double getMaximumValue() {
        return maxValue;
    }

    public void setMaximumValue(double maxValue) {
        this.maxValue = maxValue;
    }
}
