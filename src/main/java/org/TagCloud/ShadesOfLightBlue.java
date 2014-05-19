/*
ShadesOfLightBlue.java:  A helper to pick the color along a gradient Line.

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
import java.util.logging.Logger;

/**
 * A helper to pick the color along a gradient Line.
 * This class can be used as a regular class or it can be used for it's
 * static getColor method.
 *
 * @author Richard Eigenmann
 */
public class ShadesOfLightBlue extends ColorInterpolator  {

    /**
     * Defines a logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(ShadesOfLightBlue.class.getName());
    
    /**
     * Predefined color gradient points for a blue gradient
     */
    private final static Color[] SHADES_OF_LIGHT_BLUE = {new Color(0x355ddb), new Color(0x7aa5f4)};
    

    @Override
    public Color[] getColorPoints() {
        return SHADES_OF_LIGHT_BLUE;
    }
}
