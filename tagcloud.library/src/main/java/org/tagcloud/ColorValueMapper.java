package org.tagcloud;

import org.tagcloud.colorproviders.ColorProvider;

import java.awt.*;

public class ColorValueMapper extends ColorMapper {

    private final ColorProvider colorProvider;

    public ColorValueMapper(final ColorProvider colorProvider) {
        this.colorProvider = colorProvider;
    }

    @Override
    public Color getColor(final WeightedWordInterface weightedWord) {
        final var weight = MathUtils.getSizeWeight(weightedWord.getColorValue(), getMinimumValue(), getMaximumValue());
        return colorProvider.getColor(weight);
    }
}
