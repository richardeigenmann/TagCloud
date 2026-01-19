/*
 ColorPicker.java:  Picks the nearest color

 Copyright (C) 2009-2025 Richard Eigenmann.
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
 * This class picks the nearest color based on weight
 *
 * @author Richard Eigenmann
 */
public abstract class ColorPicker implements ColorProvider {

    /**
     * Creates a ColorPicker object
     */
    protected ColorPicker() {}

    /**
     * The extending class must implement this method and provide an array of
     * colors
     *
     * @return The array of colors between which to interpolate
     */
    public abstract Color[] getColorPoints();

    /**
     * This method returns the nearest color from a list. The value should be in the range [0,1]
     *
     * @param value the value for which the nearest color is to be chosen. Must be between 0 and 1
     * @return The Color picked
     */
    @Override
    public Color getColor( final double value ) {
        final var interpolationPoint = Math.clamp(value, 0, 1);
        final var index = (int) Math.round( interpolationPoint * ( getColorPoints().length - 1 ) );
        return getColorPoints()[index];
    }
}
