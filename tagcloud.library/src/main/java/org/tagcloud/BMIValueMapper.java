package org.tagcloud;

import org.tagcloud.colorproviders.BMIColorProvider;

import java.awt.*;

/**
 * A special ColorMapper that maps the second value of a weighted word
 * to a BMI color
 */
public class BMIValueMapper extends ColorMapper{

    private static final BMIColorProvider bmiColorProvider = new BMIColorProvider();

    @Override
    public Color getColor(final WeightedWordInterface weightedWord) {
        return bmiColorProvider.getColor(weightedWord.getColorValue());
    }
}
