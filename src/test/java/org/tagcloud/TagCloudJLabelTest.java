/*
 TagCloudJLabelTest.java:  Unit tests for TagCloudJLabel

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

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for TagCloudJLabel
 *
 * @author Richard Eigenmann
 */
public class TagCloudJLabelTest {

    @Test
    public void testVerifyWeightVanilla() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setSizeWeight( 0.5f );
        weightedWord.setColorWeight( 0.6f );
        TagCloudJLabel tagCloudJLabel = new TagCloudJLabel( weightedWord );
        assertEquals( "After creating a TagCloudJLabel with a sizeWeight of 0.5 and colorWeight of 0.6 we expect the correct sizeWeight to be returned.",
                0.5f, tagCloudJLabel.getWeightedWord().getSizeWeight(), 0.01f );
        assertEquals( "After creating a TagCloudJLabel with a sizeWeight of 0.5 and colorWeight of 0.6 we expect the correct colorWeight to be returned.",
                0.6f, tagCloudJLabel.getWeightedWord().getColorWeight(), 0.01f );
    }

    @Test
    public void testVerifyWeightSingleArg() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setSizeWeight( 0.4f );
        weightedWord.setColorWeight( 0.4f );
        TagCloudJLabel tagCloudJLabel = new TagCloudJLabel( weightedWord );
        assertEquals( "After creating a TagCloudJLabel with a single weight of 0.4 we expect the correct sizeWeight to be returned.",
                0.4f, tagCloudJLabel.getWeightedWord().getSizeWeight(), 0.01f );
        assertEquals( "After creating a TagCloudJLabel with a single weight of 0.4 we expect the correct colorWeight to be returned.",
                0.4f, tagCloudJLabel.getWeightedWord().getColorWeight(), 0.01f );
    }

    @Test
    public void testVerifyWeightZero() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setSizeWeight( 0 );
        weightedWord.setColorWeight( 0 );
        TagCloudJLabel tagCloudJLabel = new TagCloudJLabel( weightedWord );
        assertEquals( "After creating a TagCloudJLabel with a single weight of 0 we expect the correct sizeWeight to be returned.",
                0f, tagCloudJLabel.getWeightedWord().getSizeWeight(), 0.01f );
        assertEquals( "After creating a TagCloudJLabel with a single weight of 0 we expect the correct colorWeight to be returned.",
                0f, tagCloudJLabel.getWeightedWord().getColorWeight(), 0.01f );
    }

    @Test
    public void testVerifyWeight1() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setSizeWeight( 1 );
        weightedWord.setColorWeight( 1 );
        TagCloudJLabel tagCloudJLabel = new TagCloudJLabel( weightedWord );
        assertEquals( "After creating a TagCloudJLabel with a single weight of 1 we expect the correct sizeWeight to be returned.",
                1f, tagCloudJLabel.getWeightedWord().getSizeWeight(), 0.01f );
        assertEquals( "After creating a TagCloudJLabel with a single weight of 1 we expect the correct colorWeight to be returned.",
                1f, tagCloudJLabel.getWeightedWord().getColorWeight(), 0.01f );
    }

    @Test
    public void testVerifyWeightTooLarge() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setSizeWeight( 1.5f );
        weightedWord.setColorWeight( 2000 );
        TagCloudJLabel tagCloudJLabel = new TagCloudJLabel( weightedWord );
        assertEquals( "After creating a TagCloudJLabel with a sizeWeight of 1.5f and colorWeight of 2000  we expect the sizeWeight to be clipped at 1",
                1f, tagCloudJLabel.getWeightedWord().getSizeWeight(), 0.01f );
        assertEquals( "After creating a TagCloudJLabel with a sizeWeight of 1.5f and colorWeight of 2000  we expect the colorWeight to be clipped at 1",
                1f, tagCloudJLabel.getWeightedWord().getColorWeight(), 0.01f );
    }

    @Test
    public void testVerifyWeightTooSmall() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setSizeWeight( -0.5f );
        weightedWord.setColorWeight( -2000 );
        TagCloudJLabel tagCloudJLabel = new TagCloudJLabel( weightedWord );
        assertEquals( "After creating a TagCloudJLabel with a sizeWeight of -0.5f and colorWeight of -2000  we expect the sizeWeight to be floored at 0",
                0f, tagCloudJLabel.getWeightedWord().getSizeWeight(), 0.01f );
        assertEquals( "After creating a TagCloudJLabel with a sizeWeight of -0.5f and colorWeight of -2000  we expect the colorWeight to be floored at 0",
                0f, tagCloudJLabel.getWeightedWord().getColorWeight(), 0.01f );
    }

    @Test
    public void testFont() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setSizeWeight( 0.5f );
        weightedWord.setColorWeight( 0.6f );
        TagCloudJLabel tagCloudJLabel = new TagCloudJLabel( weightedWord );
        Font font = tagCloudJLabel.getFont();
        assertEquals( "A default TagCloudJLabel with a sizeWeight of 0.5 and a colorWeight of 0.6 sould have a SansSerif font",
                "SansSerif.plain", font.getFontName() );
        assertEquals( "A default TagCloudJLabel with a sizeWeight of 0.5 and a colorWeight of 0.6 sould have the size 18",
                18, font.getSize() );

    }

    @Test
    public void testMousoverColor() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setSizeWeight( 0.5f );
        weightedWord.setColorWeight( 0.6f );
        TagCloudJLabel tagCloudJLabel = new TagCloudJLabel( weightedWord );
        // send a mouseEntered event to the tagCloudJLabel
        MouseEvent e1 = new MouseEvent( tagCloudJLabel, 0, 0, 0, 100, 100, 0, false );
        for ( MouseListener ml : tagCloudJLabel.getMouseListeners() ) {
            ml.mouseEntered( e1 );
        }
        assertEquals( "Check default mouseover color",
                new Color( 0x421ed9 ), tagCloudJLabel.getForeground() );

        // send a mouseExited event to the tagCloudJLabel
        MouseEvent e2 = new MouseEvent( tagCloudJLabel, 0, 0, 0, 100, 100, 0, false );
        for ( MouseListener ml : tagCloudJLabel.getMouseListeners() ) {
            ml.mouseExited( e2 );
        }
        assertNotSame( "Check we are out of the default mouseover color",
                new Color( 0x421ed9 ), tagCloudJLabel.getForeground() );
    }

    @Test
    public void testSetMousoverColor() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setSizeWeight( 0.5f );
        weightedWord.setColorWeight( 0.6f );
        TagCloudJLabel tagCloudJLabel = new TagCloudJLabel( weightedWord );
        Color colorBeforeTest = tagCloudJLabel.getForeground();
        tagCloudJLabel.setMouseoverColor( Color.YELLOW );

        // send a mouseEntered event to the tagCloudJLabel
        MouseEvent e1 = new MouseEvent( tagCloudJLabel, 0, 0, 0, 100, 100, 0, false );
        for ( MouseListener ml : tagCloudJLabel.getMouseListeners() ) {
            ml.mouseEntered( e1 );
        }
        assertEquals( "Check mouseover color is YELLOW",
                Color.YELLOW, tagCloudJLabel.getForeground() );

        // send a mouseExited event to the tagCloudJLabel
        MouseEvent e2 = new MouseEvent( tagCloudJLabel, 0, 0, 0, 100, 100, 0, false );
        for ( MouseListener ml : tagCloudJLabel.getMouseListeners() ) {
            ml.mouseExited( e2 );
        }
        assertNotSame( "Check we are back on the previous colore after the mouseExited",
                colorBeforeTest, tagCloudJLabel.getForeground() );
    }

}
