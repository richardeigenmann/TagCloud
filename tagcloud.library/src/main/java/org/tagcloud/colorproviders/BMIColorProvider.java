/*
 BMIColorProvider.java:  A ColorProvider that returns colors as per the BMI classification

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
 * A ColorProvider that returns colors based on the BMI classification of the
 * colorSize value. This color provider is different from the other color
 * providers because it returns the colors based on the value supplied. It
 * purposely does not implement che ColorProvider Interface as it doesn't
 * work off a range [0,1] value.
 *
 * @author Richard Eigenmann
 */
public class BMIColorProvider  {

    /**
     * Constructs a new BMIColorProvider provider.
     */
    public BMIColorProvider() {
        // for javadoc purposes
    }

    /**
     * Color for underweight
     */
    private static final Color COLOR_UNDERWEIGHT = Color.CYAN;

    /**
     * Color for normal weight
     */
    private static final Color COLOR_NORMAL_WEIGHT = Color.GREEN;

    /**
     * Color for overweight
     */
    private static final Color COLOR_OVERWEIGHT = Color.decode("#f3843d");

    /**
     * Color for obese
     */
    private static final Color COLOR_OBESE = Color.RED;

    /**
     * Official threshold for BMI that is underweight
     * @see <a href="https://en.wikipedia.org/wiki/Body_mass_index">Body mass index (Wikipedia)</a>
     */
    public static final double UNDERWEIGHT_BMI_THRESHOLD = 18.5;

    /**
     * Official threshold for BMI that is normal weight
     * @see <a href="https://en.wikipedia.org/wiki/Body_mass_index">Body mass index (Wikipedia)</a>
     */
    public static final int NORMAL_BMI_THRESHOLD = 25;

    /**
     * Official threshold for BMI that is overweight
     * @see <a href="https://en.wikipedia.org/wiki/Body_mass_index">Body mass index (Wikipedia)</a>
     */
    public static final int OVERWEIGHT_BMI_THRESHOLD = 31;

    /**
     * Returns the color for the supplied BMI value
     *
     * @see <a href="https://en.wikipedia.org/wiki/Body_mass_index">Body mass index (Wikipedia)</a>
     * @param value returns colors based on the value
     * @return the appropriate color for the BMI
     */
    public Color getColor( final double value ) {
        if ( value < UNDERWEIGHT_BMI_THRESHOLD) {
            return COLOR_UNDERWEIGHT;
        } else if ( value < NORMAL_BMI_THRESHOLD) {
            return COLOR_NORMAL_WEIGHT;
        } else if ( value < OVERWEIGHT_BMI_THRESHOLD) {
            return COLOR_OVERWEIGHT;
        } else {
            return COLOR_OBESE;
        }
    }
}
