/*
 BlackToWhiteGradient.java:  A ColorProvider that returns a color on the gradient from Black to White based on the suplied weight

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
import org.TagCloud.ColorInterpolator;

/**
 * A ColorProvider that returns a color on the gradient from Black to White
 * based on the suplied weight
 *
 * @author Richard Eigenmann
 */
public class BlackToWhiteGradient extends ColorInterpolator {

    /**
     * Predefined colors for a Black to White gradient
     */
    public final static Color[] BLACK_WHITE_COLORS = { Color.BLACK, Color.WHITE };

    /**
     * Returns the two colors to the ColorInterpolator
     *
     * @return the color points for interpolation
     */
    @Override
    public Color[] getColorPoints() {
        return BLACK_WHITE_COLORS;
    }
}
