/*
 SansSerifFontListTest.java:  Unit tests for SansSerifFontList

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
package org.tagcloud.colorprovider;

import org.junit.jupiter.api.Assertions;
import org.tagcloud.fontproviders.SansSerifFontProvider;
import org.junit.jupiter.api.Test;

class SansSerifFontProviderTest {

    /**
     * Test of getFont method, of class SansSerifFontList.
     */
    @Test
    void testGetFont() {
        final var sansSerifFontProvider = new SansSerifFontProvider();
        final var font0 = sansSerifFontProvider.getFont( 0 );
        Assertions.assertEquals("SansSerif.plain", font0.getFontName(), "Expecting font for weight 0 to be SansSerif");
        Assertions.assertEquals(10, font0.getSize(), "Expecting font size for weight 0 to be 10");

        final var font1 = sansSerifFontProvider.getFont( 1 );
        Assertions.assertEquals("SansSerif.plain", font1.getFontName(), "Expecting font for weight 1 to be SansSerif");
        Assertions.assertEquals(25, font1.getSize(), "Expecting font size for weight 1 to be 25");
    }

}
