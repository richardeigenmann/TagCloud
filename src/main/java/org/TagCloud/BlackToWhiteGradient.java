/*
BlackToWhiteGradient.java:  A Color Gradient from Black to White

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
public class BlackToWhiteGradient extends ColorInterpolator  {

    /**
     * Defines a logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(BlackToWhiteGradient.class.getName());
    /**
     * Sample gradient colors for use in the application
     */
    public final static Color[] SAMPLE_GRADIENT_COLORS = {new Color(0x099716), new Color(0x18c928),
        new Color(0x36e410), new Color(0x64e410), new Color(0xa1e70c),
        new Color(0xc3d000), new Color(0xe8e410), new Color(0xdcaf1e),
        new Color(0xe87514), new Color(0xed723b)};
    
    /**
     * Predefined color for a Black to White gradient
     */
    public final static Color[] BLACK_WHITE_COLORS = {Color.BLACK, Color.WHITE};
   

    @Override
    public Color[] getColorPoints() {
        return BLACK_WHITE_COLORS;
    }
}
