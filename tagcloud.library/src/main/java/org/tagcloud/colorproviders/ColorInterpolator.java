/*
 ColorInterpolator.java:  This abstract class can interpolate a color from a set of color points based on weight 0 to 1.

 Copyright (C) 2009-2025  Richard Eigenmann.
 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation; either version 2
 of the License, or any later version. This program is distributed
 in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
 more details. You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 The license is in gpl.txt.
 See http://www.gnu.org/copyleft/gpl.html for the details.
 */
package org.tagcloud.colorproviders;

import java.awt.Color;

/**
 * This abstract class can interpolate a color from a set of color points based
 * on values ranging from 0 to 1. Extending classes must provide an array with the colors to
 * use in the getColorPoints method.
 *
 * @author Richard Eigenmann
 */
public abstract class ColorInterpolator implements ColorProvider {


    /**
     * The extending class must implement this method and provide an array of
     * colors
     *
     * @return The array of colors between which to interpolate
     */
    public abstract Color[] getColorPoints();

    /**
     * This method returns a color along a multi point color gradiant. The
     * Gradiant color points are specified by an array of Colors. The Array must
     * have at least 2 color entries. The interpolation uses the weight parameter.
     *
     * @param value the value in the range from 0 to 1
     * @return The Color in the gradient
     */
    @Override
    public Color getColor( final double value  ) {
        Color[] colors = getColorPoints();
        if (colors == null || colors.length < 2) {
            // Or return a default color, or throw an exception
            return Color.BLACK;
        }

        var clampedValue = Math.clamp(value, 0, 1);

        // 2. Determine the two colors to interpolate between
        var scaledPoint = clampedValue * (colors.length - 1);
        var lowerIndex = (int) scaledPoint;

        // Ensure lowerIndex is not the last index
        if (lowerIndex >= colors.length - 1) {
            return colors[colors.length - 1];
        }
        int upperIndex = lowerIndex + 1;

        // 3. Calculate the percentage between the two chosen colors
        double localPercentage = scaledPoint - lowerIndex;

        Color lowerColor = colors[lowerIndex];
        Color upperColor = colors[upperIndex];

        // 4. Interpolate each color component
        int newRed = (int) (lowerColor.getRed() + localPercentage * (upperColor.getRed() - lowerColor.getRed()));
        int newGreen = (int) (lowerColor.getGreen() + localPercentage * (upperColor.getGreen() - lowerColor.getGreen()));
        int newBlue = (int) (lowerColor.getBlue() + localPercentage * (upperColor.getBlue() - lowerColor.getBlue()));

        return new Color(newRed, newGreen, newBlue);
    }
}
