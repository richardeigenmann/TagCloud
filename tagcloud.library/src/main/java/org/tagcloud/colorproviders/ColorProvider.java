/*
 ColorProvider.java:  Interface that defines the method to call to receive a color for a weight

 Copyright (C) 2014-2025 Richard Eigenmann.
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
 * Defines the method signature of a call to retrieve the color for a given
 * weight
 *
 * @author Richard Eigenmann
 */
@FunctionalInterface
public interface ColorProvider {

    /**
     * The implementing class must return an appropriate color for the supplied
     * value. The value must be in the range [0,1] which will either become
     * an interpolated color on a gradient between points or the nearest color in the
     * color points depending on the overriding class.
     *
     * @param value the value in the range [0,1] for which a color should be provided
     * @return The color to use for the supplied weight.
     */
    Color getColor( final double value );

}
