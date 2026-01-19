package org.tagcloud;

import java.awt.*;

public abstract class ColorMapper {

    /**
     * Creates a ColorMapper object
     */
    protected ColorMapper() {
        // for javadoc purposes
    }

    /**
     * The overriding class must implement the getColor based on the supplied weightedWord.
     * It can use the minValue and maxValue to figure out the color in a range of colors if so desired.
     * @param weightedWord The weightedWord for which to figure out the color
     * @return The Java Color for the supplied word
     */
    public abstract Color getColor(final WeightedWordInterface weightedWord);

    private double minValue = Double.MIN_VALUE;
    private double maxValue = Double.MAX_VALUE;

    /**
     * @return the current minimum boundary for color calculation
     */
    public double getMinimumValue() {
        return minValue;
    }
    /**
     * Sets the minimum boundary.
     * @param minValue the new minimum
     * @return this mapper instance for method chaining
     */
    public ColorMapper setMinimumValue(double minValue) {
        this.minValue = minValue;
        return this;
    }

    /**
     * @return the current maximum boundary for color calculation
     */
    public double getMaximumValue() {
        return maxValue;
    }

    /**
     * Sets the maximum boundary.
     * @param maxValue the new maximum
     * @return this mapper instance for method chaining
     */
    public ColorMapper setMaximumValue(double maxValue) {
        this.maxValue = maxValue;
        return this;
    }
}
