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

import org.tagcloud.fontproviders.SansSerifFontProvider;
import java.awt.Font;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for SansSerifFontList
 *
 * @author Richard Eigenmann
 */
public class SansSerifFontProviderTest {

    public SansSerifFontProviderTest() {
    }

    /**
     * Test of getFont method, of class SansSerifFontList.
     */
    @Test
    public void testGetFont() {
        SansSerifFontProvider sansSerifFontProvider = new SansSerifFontProvider();
        Font font = sansSerifFontProvider.getFont( 0, 0 );
        assertEquals( "Expecting font for weight 0 to be SansSerif", "SansSerif.plain", font.getFontName() );
        assertEquals( "Expecting font size for weight 0 to be 10", 10, font.getSize() );

        font = sansSerifFontProvider.getFont( 1, 0 );
        assertEquals( "Expecting font for weight 1 to be SansSerif", "SansSerif.plain", font.getFontName() );
        assertEquals( "Expecting font size for weight 1 to be 25", 25, font.getSize() );

    }

}
