/*
 ColorGradient.java:  Interface that defines how colors should be returned

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
package org.TagCloud;

import java.awt.Color;

/**
 * Defines how fonts should be returned for a given weight
 * @author Richard Eigenmann
 */
public interface ColorGradient {

    /**
     * The implementing class must return an appropriate color for the supplied weight
     * @param weight The weight for which the color should be returned range is 0 to 1
     * @return The color to use for the supplied weight.
     */
    public Color getColor( float weight );

}
