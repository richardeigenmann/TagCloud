/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.TagCloud;

import java.awt.Color;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author richi
 */
public class ColorPickerTest {

    /**
     * Test of getColor method, of class ColorPicker.
     */
    @Test
    public void testGetColor() {
        ColorPicker twoColorPicket = new ColorPickerImpl();
        assertEquals( "For weight 0 we expect the first color", twoColorArray[0], twoColorPicket.getColor( 0f ) );
        assertEquals( "For weight 1 we expect the second color", twoColorArray[1], twoColorPicket.getColor( 1f ) );
        assertEquals( "For weight 0.3 we expect the first color", twoColorArray[0], twoColorPicket.getColor( 0.3f ) );
        assertEquals( "For weight 0.48 we expect the first color", twoColorArray[0], twoColorPicket.getColor( 0.48f ) );
        assertEquals( "For weight 0.5 we expect the second color", twoColorArray[1], twoColorPicket.getColor( 0.5f ) );
        assertEquals( "For weight 0.7 we expect the second color", twoColorArray[1], twoColorPicket.getColor( 0.7f ) );
    }

    public static Color[] twoColorArray = { Color.black, Color.white };
    
    public class ColorPickerImpl extends ColorPicker {

        @Override
        public Color[] getColorPoints() {
            return twoColorArray;
        }
    }
    
}
