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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

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
        Assertions.assertEquals(0.5f, tagCloudJLabel.getWeightedWord().getSizeWeight(), 0.01f, "After creating a TagCloudJLabel with a sizeWeight of 0.5 and colorWeight of 0.6 we expect the correct sizeWeight to be returned.");
        Assertions.assertEquals(0.6f, tagCloudJLabel.getWeightedWord().getColorWeight(), 0.01f, "After creating a TagCloudJLabel with a sizeWeight of 0.5 and colorWeight of 0.6 we expect the correct colorWeight to be returned.");
    }

    @Test
    public void testVerifyWeightSingleArg() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setSizeWeight( 0.4f );
        weightedWord.setColorWeight( 0.4f );
        TagCloudJLabel tagCloudJLabel = new TagCloudJLabel( weightedWord );
        Assertions.assertEquals(0.4f, tagCloudJLabel.getWeightedWord().getSizeWeight(), 0.01f, "After creating a TagCloudJLabel with a single weight of 0.4 we expect the correct sizeWeight to be returned.");
        Assertions.assertEquals(0.4f, tagCloudJLabel.getWeightedWord().getColorWeight(), 0.01f, "After creating a TagCloudJLabel with a single weight of 0.4 we expect the correct colorWeight to be returned.");
    }

    @Test
    public void testVerifyWeightZero() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setSizeWeight( 0 );
        weightedWord.setColorWeight( 0 );
        TagCloudJLabel tagCloudJLabel = new TagCloudJLabel( weightedWord );
        Assertions.assertEquals(0f, tagCloudJLabel.getWeightedWord().getSizeWeight(), 0.01f, "After creating a TagCloudJLabel with a single weight of 0 we expect the correct sizeWeight to be returned.");
        Assertions.assertEquals(0f, tagCloudJLabel.getWeightedWord().getColorWeight(), 0.01f, "After creating a TagCloudJLabel with a single weight of 0 we expect the correct colorWeight to be returned.");
    }

    @Test
    public void testVerifyWeight1() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setSizeWeight( 1 );
        weightedWord.setColorWeight( 1 );
        TagCloudJLabel tagCloudJLabel = new TagCloudJLabel( weightedWord );
        Assertions.assertEquals(1f, tagCloudJLabel.getWeightedWord().getSizeWeight(), 0.01f, "After creating a TagCloudJLabel with a single weight of 1 we expect the correct sizeWeight to be returned.");
        Assertions.assertEquals(1f, tagCloudJLabel.getWeightedWord().getColorWeight(), 0.01f, "After creating a TagCloudJLabel with a single weight of 1 we expect the correct colorWeight to be returned.");
    }

    @Test
    public void testVerifyWeightTooLarge() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setSizeWeight( 1.5f );
        weightedWord.setColorWeight( 2000 );
        TagCloudJLabel tagCloudJLabel = new TagCloudJLabel( weightedWord );
        Assertions.assertEquals(1f, tagCloudJLabel.getWeightedWord().getSizeWeight(), 0.01f, "After creating a TagCloudJLabel with a sizeWeight of 1.5f and colorWeight of 2000  we expect the sizeWeight to be clipped at 1");
        Assertions.assertEquals(1f, tagCloudJLabel.getWeightedWord().getColorWeight(), 0.01f, "After creating a TagCloudJLabel with a sizeWeight of 1.5f and colorWeight of 2000  we expect the colorWeight to be clipped at 1");
    }

    @Test
    public void testVerifyWeightTooSmall() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setSizeWeight( -0.5f );
        weightedWord.setColorWeight( -2000 );
        TagCloudJLabel tagCloudJLabel = new TagCloudJLabel( weightedWord );
        Assertions.assertEquals(0f, tagCloudJLabel.getWeightedWord().getSizeWeight(), 0.01f, "After creating a TagCloudJLabel with a sizeWeight of -0.5f and colorWeight of -2000  we expect the sizeWeight to be floored at 0");
        Assertions.assertEquals(0f, tagCloudJLabel.getWeightedWord().getColorWeight(), 0.01f, "After creating a TagCloudJLabel with a sizeWeight of -0.5f and colorWeight of -2000  we expect the colorWeight to be floored at 0");
    }

    @Test
    public void testFont() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setSizeWeight( 0.5f );
        weightedWord.setColorWeight( 0.6f );
        TagCloudJLabel tagCloudJLabel = new TagCloudJLabel( weightedWord );
        Font font = tagCloudJLabel.getFont();
        Assertions.assertEquals("SansSerif.plain", font.getFontName(), "A default TagCloudJLabel with a sizeWeight of 0.5 and a colorWeight of 0.6 sould have a SansSerif font");
        Assertions.assertEquals(18, font.getSize(), "A default TagCloudJLabel with a sizeWeight of 0.5 and a colorWeight of 0.6 sould have the size 18");

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
        Assertions.assertEquals(new Color( 0x421ed9 ), tagCloudJLabel.getForeground(), "Check default mouseover color");

        // send a mouseExited event to the tagCloudJLabel
        MouseEvent e2 = new MouseEvent( tagCloudJLabel, 0, 0, 0, 100, 100, 0, false );
        for ( MouseListener ml : tagCloudJLabel.getMouseListeners() ) {
            ml.mouseExited( e2 );
        }
        Assertions.assertNotSame(new Color( 0x421ed9 ), tagCloudJLabel.getForeground(), "Check we are out of the default mouseover color");
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
        Assertions.assertEquals(Color.YELLOW, tagCloudJLabel.getForeground(), "Check mouseover color is YELLOW");

        // send a mouseExited event to the tagCloudJLabel
        MouseEvent e2 = new MouseEvent( tagCloudJLabel, 0, 0, 0, 100, 100, 0, false );
        for ( MouseListener ml : tagCloudJLabel.getMouseListeners() ) {
            ml.mouseExited( e2 );
        }
        Assertions.assertNotSame(colorBeforeTest, tagCloudJLabel.getForeground(), "Check we are back on the previous colore after the mouseExited");
    }

}
