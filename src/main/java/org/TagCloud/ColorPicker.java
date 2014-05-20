/*
 ColorPicker.java:  Picks the nearest color

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
package org.TagCloud;

import java.awt.Color;

/**
 * This class picks the nearest color based on weight
 *
 * @author Richard Eigenmann
 */
public abstract class ColorPicker implements ColorProvider {

    /**
     * The extending class must implement this method and provide an array of
     * colors
     *
     * @return The array of colors between which to interpolate
     */
    public abstract Color[] getColorPoints();

    /**
     * This method returns the nearest color from a set and ignores the value parameter
     *
     * @param weight between 0 and 1
     * @param value ignored
     * @return The Color picked
     */
    @Override
    public Color getColor( float weight, int value ) {
        int index = (int) Math.round( weight * ( getColorPoints().length - 1 ) );
        Color color = getColorPoints()[index];
        return color;
    }
}
