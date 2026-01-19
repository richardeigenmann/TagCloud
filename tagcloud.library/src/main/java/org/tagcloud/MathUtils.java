package org.tagcloud;

/**
 * Utility class with mathematical functions.
 */
public class MathUtils {

    private MathUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Returns the normalised weight from 0 to 1 for a given size value withing a min and max value
     * @param value the value for which to figure out the weight
     * @param min  the lower bound
     * @param max The upper bound
     * @return the weight in the range 0..1
     */
    public static double getSizeWeight(double value, double min, double max) {
        if (max <= min) {
            return 0.0; // actually bad input but let's be graceful
        }
        final var deltaToMin = value - min;
        var range = max - min;
        if (range == 0) {
            return 0; //prevent division by zero
        }
        return Math.clamp(deltaToMin / range, 0.0, 1.0);
    }
}
