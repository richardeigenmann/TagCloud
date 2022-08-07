/*
 ColorProvider.java:  Interface that defines the method to call to receive a color for a weight

 Copyright (C) 2014  Richard Eigenmann.
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
package org.tagcloud;

import java.awt.Color;

/**
 * Defines the method signature of a call to retrieve the color for a given
 * weight
 *
 * @author Richard Eigenmann
 */
public interface ColorProvider {

    /**
     * The implementing class must return an appropriate color for the supplied
     * weight
     *
     * @param weight The weight for which the color should be returned range is
     * 0 to 1 for relative weight choices
     * @param value The value for providers that work on absolute numbers
     * @return The color to use for the supplied weight.
     */
    Color getColor(float weight, int value);

}
