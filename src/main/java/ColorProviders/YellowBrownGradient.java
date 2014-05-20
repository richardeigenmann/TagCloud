/*
 YellowBrownGradient.java:  A ColorProvider that returns a color from Yellow to Brown

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
package ColorProviders;

import java.awt.Color;
import org.TagCloud.ColorInterpolator;

/**
 * A ColorProvider that returns a color from Yellow to Brown
 *
 * @author Richard Eigenmann
 */
public class YellowBrownGradient extends ColorInterpolator {

    /**
     * Predefined color gradient points for a yellow to chocolate brown
     */
    private final static Color[] YELLOW_BROWN = { Color.YELLOW, new Color( 123, 63, 0 ) };

    /**
     * Provides the color points to the ColorInterpolator
     *
     * @return the color points for interpolation
     */
    @Override
    public Color[] getColorPoints() {
        return YELLOW_BROWN;
    }
}
