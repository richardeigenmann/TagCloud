/*
 SansSerifFontProvider.java:  An implementation of the FontList interface with large fat Sans Serif fonts

 Copyright (C) 2014-2025  Richard Eigenmann.
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
package org.tagcloud.fontproviders;

import java.awt.Font;

/**
 * An implementation of the FontList interface with large fat Sans Serif fonts
 *
 * @author Richard Eigenmann
 */
public class HeavyFontProvider implements FontProvider {

    /**
     * An array of fonts in increasing size
     */
    private static final Font[] fonts = {
        new Font( "SansSerif", Font.BOLD, 18 ),
        new Font( "SansSerif", Font.BOLD, 20 ),
        new Font( "SansSerif", Font.BOLD, 24 ),
        new Font( "SansSerif", Font.BOLD, 28 ) };

    /**
     * Returns the font for the specified weight
     *
     * @param weight the weight for which to return the font
     * @return the font for the weight
     */
    @Override
    public Font getFont( double weight ) {
        final int index = (int) Math.round( ( weight * ( fonts.length - 1 ) ) );
        return fonts[index];
    }

}
