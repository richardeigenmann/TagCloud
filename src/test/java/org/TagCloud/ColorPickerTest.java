/*
 ColorPickerTest.java:  Unit tests for the ColorPicker class

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
package org.TagCloud;

import java.awt.Color;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the ColorPicker class
 *
 * @author Richard Eigenmann
 */
public class ColorPickerTest {

    /**
     * Test of getColor method, of class ColorPicker.
     */
    @Test
    public void testGetColor() {
        ColorPicker twoColorPicket = new ColorPickerImpl();
        assertEquals( "For weight 0 we expect the first color", twoColorArray[0], twoColorPicket.getColor( 0f, 0 ) );
        assertEquals( "For weight 1 we expect the second color", twoColorArray[1], twoColorPicket.getColor( 1f, 0 ) );
        assertEquals( "For weight 0.3 we expect the first color", twoColorArray[0], twoColorPicket.getColor( 0.3f, 0 ) );
        assertEquals( "For weight 0.48 we expect the first color", twoColorArray[0], twoColorPicket.getColor( 0.48f, 0 ) );
        assertEquals( "For weight 0.5 we expect the second color", twoColorArray[1], twoColorPicket.getColor( 0.5f, 0 ) );
        assertEquals( "For weight 0.7 we expect the second color", twoColorArray[1], twoColorPicket.getColor( 0.7f, 0 ) );
    }

    public static Color[] twoColorArray = { Color.black, Color.white };

    public class ColorPickerImpl extends ColorPicker {

        @Override
        public Color[] getColorPoints() {
            return twoColorArray;
        }
    }

}
