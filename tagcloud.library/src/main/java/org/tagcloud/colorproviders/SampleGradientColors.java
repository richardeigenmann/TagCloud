/*
 SampleGradientColors.java:  A multi color gradient

 Copyright (C) 2009-20254  Richard Eigenmann.
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
 * A green to red gradient.
 *
 * @author Richard Eigenmann
 */
public class SampleGradientColors extends ColorInterpolator {

    /**
     * Constructs a new SampleGradientColors ColorProvider.
     */
    public SampleGradientColors() {
        // for javadoc purposes
    }

    /**
     * Sample gradient color points
     */
    private static final Color[] SAMPLE_GRADIENT_COLORS = {
        new Color( 0x099716 ),
        new Color( 0x18c928 ),
        new Color( 0x36e410 ),
        new Color( 0x64e410 ),
        new Color( 0xa1e70c ),
        new Color( 0xc3d000 ),
        new Color( 0xe8e410 ),
        new Color( 0xdcaf1e ),
        new Color( 0xe87514 ),
        new Color( 0xed723b )
    };

    /**
     * Provides the color points to the ColorInterpolator
     *
     * @return The color points for interpolation
     */
    @Override
    public Color[] getColorPoints() {
        return SAMPLE_GRADIENT_COLORS;
    }
}
