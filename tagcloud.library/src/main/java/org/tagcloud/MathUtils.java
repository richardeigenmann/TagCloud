package org.tagcloud;

public class MathUtils {

    private MathUtils() {
        throw new IllegalStateException("Utility class");
    }
    /**
     * Returns the weight from 0 to 1 for a given size value
     *
     * @param value the value for which to figure out the weight
     * @return the weight in the range 0..1
     */
    public static double getSizeWeight(double value, double min, double max) {
        final var deltaToMin = value - min; //getMinFontSizeValue()
        var range = max - min; // getMaxFontSizeValue()
        if (range == 0) {
            return 0; //prevent division by zero
        }
        return Math.clamp(deltaToMin / range, 0.0, 1.0);
    }
}
