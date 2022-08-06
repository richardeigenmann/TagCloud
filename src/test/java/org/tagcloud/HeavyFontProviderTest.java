/*
 SansSerifFontListTest.java:  Unit tests for SansSerifFontList

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

import org.junit.jupiter.api.Assertions;
import org.tagcloud.fontproviders.HeavyFontProvider;
import org.junit.jupiter.api.Test;

import java.awt.*;

/**
 * Unit tests for SansSerifFontList
 *
 * @author Richard Eigenmann
 */
public class HeavyFontProviderTest {

    public HeavyFontProviderTest() {
    }

    /**
     * Test of getFont method, of class SansSerifFontList.
     */
    @Test
    public void testGetFont() {
        HeavyFontProvider heavyFontProvider = new HeavyFontProvider();
        Font font = heavyFontProvider.getFont( 0, 0 );
        Assertions.assertEquals("SansSerif.bold", font.getFontName(), "Expecting font for weight 0 to be SansSerif");
        Assertions.assertEquals(18, font.getSize(), "Expecting font size for weight 0 to be 18");

        font = heavyFontProvider.getFont( 1, 0 );
        Assertions.assertEquals("SansSerif.bold", font.getFontName(), "Expecting font for weight 1 to be SansSerif");
        Assertions.assertEquals(28, font.getSize(), "Expecting font size for weight 1 to be 28");

    }

}
