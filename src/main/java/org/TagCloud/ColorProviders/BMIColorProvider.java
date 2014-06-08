/*
 BMIColorProvider.java:  A ColorProvider that returns colors as per the BMI classification

 Copyright (C) 2009-2014  Richard Eigenmann.
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
package org.TagCloud.ColorProviders;

import java.awt.Color;
import org.TagCloud.ColorProvider;

/**
 * A ColorProvider that returns colors based on the BMI classification of the
 * colorSize value. This ColorProvider is different from the other Color
 * providers because it returns the colors based on the value supplied.
 *
 * @author Richard Eigenmann
 */
public class BMIColorProvider implements ColorProvider {

    /**
     * Color for underweight
     */
    private final static Color UNDERWEIGHT = Color.PINK;

    /**
     * Color for normal
     */
    private final static Color NORMAL = Color.GREEN;

    /**
     * Color for overweight
     */
    private final static Color OVERWEIGHT = Color.ORANGE;

    /**
     * Color for obese
     */
    private final static Color OBESE = Color.RED;

    /**
     * Returns the color for the supplied value
     *
     * @see <a href="http://en.wikipedia.org/wiki/Body_mass_index">http://en.wikipedia.org/wiki/Body_mass_index</a>
     * @param weight ignored
     * @param value returns colors based on the value
     * @return the appropriate color for the BMI
     */
    @Override
    public Color getColor( float weight, int value ) {
        if ( value < 18.5f ) {
            return UNDERWEIGHT;
        } else if ( value < 26 ) {
            return NORMAL;
        } else if ( value < 31 ) {
            return OVERWEIGHT;
        } else {
            return OBESE;
        }
    }
}
