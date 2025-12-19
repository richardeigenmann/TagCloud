package org.tagcloud;

import org.tagcloud.fontproviders.FontProvider;

import java.awt.*;

public class FontMapper {

    private final FontProvider fontProvider;

    public FontMapper( final FontProvider fontProvider ) {
        this.fontProvider = fontProvider;
    }

    public  Font getFont(final WeightedWordInterface weightedWord) {
        return fontProvider.getFont( MathUtils.getSizeWeight(weightedWord.getFontSizeValue(), getMinimumValue(), getMaximumValue() ));
    }

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
