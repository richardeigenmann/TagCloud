/*
 SerifFontProvider.java:  An implementation of the FontList interface with Sans Serif fonts

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
package org.tagcloud.fontproviders;

import java.awt.Font;
import org.tagcloud.FontProvider;


/**
 * An implementation of the FontList interface with Sans Serif fonts
 *
 * @author Richard Eigenmann
 */
public class SerifFontProvider implements FontProvider {

    /**
     * An array of fonts in increasing size
     */
    private static final Font[] fonts = {
        new Font( "Serif", Font.PLAIN, 10 ),
        new Font( "Serif", Font.PLAIN, 11 ),
        new Font( "Serif", Font.PLAIN, 12 ),
        new Font( "Serif", Font.PLAIN, 13 ),
        new Font( "Serif", Font.PLAIN, 14 ),
        new Font( "Serif", Font.PLAIN, 15 ),
        new Font( "Serif", Font.PLAIN, 16 ),
        new Font( "Serif", Font.PLAIN, 17 ),
        new Font( "Serif", Font.PLAIN, 18 ),
        new Font( "Serif", Font.PLAIN, 19 ),
        new Font( "Serif", Font.PLAIN, 20 ),
        new Font( "Serif", Font.PLAIN, 21 ),
        new Font( "Serif", Font.PLAIN, 22 ),
        new Font( "Serif", Font.PLAIN, 23 ),
        new Font( "Serif", Font.PLAIN, 24 ),
        new Font( "Serif", Font.PLAIN, 25 ) };

    /**
     * Returns the font for the specified weight
     *
     * @param weight the weight for which to return the font
     * @param value ignored
     * @return the font for the weight
     */
    @Override
    public Font getFont( float weight, int value  ) {
        final int index = Math.round( ( weight * ( fonts.length - 1 ) ) );
        return fonts[index];
    }

}
