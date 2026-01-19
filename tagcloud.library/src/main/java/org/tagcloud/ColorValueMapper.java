package org.tagcloud;

import org.tagcloud.colorproviders.ColorProvider;

import java.awt.*;

/**
 * An implementation of {@link ColorMapper} that determines colors by normalizing
 * a word's color value against a defined numeric range.
 * <p>
 * This mapper calculates a weight (0.0 to 1.0) by comparing the word's color value
 * to the {@link #getMinimumValue()} and {@link #getMaximumValue()}. This weight is
 * then passed to a {@link ColorProvider} to retrieve the final color.
 * </p>
 *
 * @author Richard Eigenmann
 */
public class ColorValueMapper extends ColorMapper {

    private final ColorProvider colorProvider;

    /**
     * Constructs a new ColorValueMapper with a specific color strategy.
     *
     * @param colorProvider the provider used to translate normalized weights into colors
     */
    public ColorValueMapper(final ColorProvider colorProvider) {
        this.colorProvider = colorProvider;
    }

    /**
     * Maps the color value of a weighted word to a Java Color.
     * <p>
     * The process follows these steps:
     * <ol>
     * <li>Extracts the raw color value from the word.</li>
     * <li>Normalizes the value between {@code min} and {@code max} using {@link MathUtils}.</li>
     * <li>Fetches the color from the internal {@link ColorProvider} using that weight.</li>
     * </ol>
     *
     * @param weightedWord the word containing the value to be mapped
     * @return the resulting {@link Color} from the provider
     */
    @Override
    public Color getColor(final WeightedWordInterface weightedWord) {
        final var weight = MathUtils.getSizeWeight(weightedWord.getColorValue(), getMinimumValue(), getMaximumValue());
        return colorProvider.getColor(weight);
    }
}
