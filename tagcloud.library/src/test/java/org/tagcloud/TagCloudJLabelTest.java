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
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.tagcloud.colorproviders.ShadesOfLightBlue;
import org.tagcloud.fontproviders.SansSerifFontProvider;

/**
 * Unit tests for TagCloudJLabel
 *
 * @author Richard Eigenmann
 */
class TagCloudJLabelTest {

    @Test
    void testVerifyWeightVanilla() {
        final var weightedWord1 = new WeightedWord( "Word", 10, 100 );
        final var weightedWord2 = new WeightedWord( "Word", 15, 150 );
        final var weightedWord3 = new WeightedWord( "Word", 20, 200 );
        final var wordList = List.of(weightedWord1, weightedWord2, weightedWord3);
        final var fontValueMapper = new FontMapper(new SansSerifFontProvider() );
        final var colorValueMapper = new ColorValueMapper( new ShadesOfLightBlue() );
        TagCloud.identifyValueRanges(wordList, fontValueMapper, colorValueMapper);

        final var tagCloudJLabel1 = new TagCloudJLabel( weightedWord1, fontValueMapper, colorValueMapper, Color.BLACK );
        final var font1 = tagCloudJLabel1.getFont();
        Assertions.assertEquals(10, font1.getSize(), "The lowest weight should come out at size 10");
        final var color1 = tagCloudJLabel1.getForeground();
        Assertions.assertEquals(new Color( 0x355ddb ), color1, "The lowest weight should come out with the lower boundary color");

        final var tagCloudJLabel2 = new TagCloudJLabel( weightedWord2, fontValueMapper, colorValueMapper, Color.BLACK );
        final var font2 = tagCloudJLabel2.getFont();
        Assertions.assertEquals(18, font2.getSize(), "The middle weight should come out at size 18");
        final var color2 = tagCloudJLabel2.getForeground();
        Assertions.assertEquals(new Color( 87,129,231 ), color2, "The highest weight should come out with the upper boundary color");

        final var tagCloudJLabel3 = new TagCloudJLabel( weightedWord3, fontValueMapper, colorValueMapper, Color.BLACK );
        final var font3 = tagCloudJLabel3.getFont();
        Assertions.assertEquals(25, font3.getSize(), "The middle weight should come out at size 25");
        final var color3 = tagCloudJLabel3.getForeground();
        Assertions.assertEquals(new Color( 0x7aa5f4 ), color3, "The highest weight should come out with the upper boundary color");
    }

    /*@Test
    void testVerifyWeightSingleArg() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setFontSizeWeight( 0.4f );
        weightedWord.setColorWeight( 0.4f );
        TagCloudJLabel tagCloudJLabel = new TagCloudJLabel( weightedWord );
        Assertions.assertEquals(0.4f, tagCloudJLabel.getWeightedWord().getFontSizeWeight(), 0.01f, "After creating a TagCloudJLabel with a single weight of 0.4 we expect the correct sizeWeight to be returned.");
        Assertions.assertEquals(0.4f, tagCloudJLabel.getWeightedWord().getColorValue(), 0.01f, "After creating a TagCloudJLabel with a single weight of 0.4 we expect the correct colorWeight to be returned.");
    }

    @Test
    void testVerifyWeightZero() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setFontSizeWeight( 0 );
        weightedWord.setColorWeight( 0 );
        TagCloudJLabel tagCloudJLabel = new TagCloudJLabel( weightedWord );
        Assertions.assertEquals(0f, tagCloudJLabel.getWeightedWord().getFontSizeWeight(), 0.01f, "After creating a TagCloudJLabel with a single weight of 0 we expect the correct sizeWeight to be returned.");
        Assertions.assertEquals(0f, tagCloudJLabel.getWeightedWord().getColorValue(), 0.01f, "After creating a TagCloudJLabel with a single weight of 0 we expect the correct colorWeight to be returned.");
    }

    @Test
    void testVerifyWeight1() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setFontSizeWeight( 1 );
        weightedWord.setColorWeight( 1 );
        TagCloudJLabel tagCloudJLabel = new TagCloudJLabel( weightedWord );
        Assertions.assertEquals(1f, tagCloudJLabel.getWeightedWord().getFontSizeWeight(), 0.01f, "After creating a TagCloudJLabel with a single weight of 1 we expect the correct sizeWeight to be returned.");
        Assertions.assertEquals(1f, tagCloudJLabel.getWeightedWord().getColorValue(), 0.01f, "After creating a TagCloudJLabel with a single weight of 1 we expect the correct colorWeight to be returned.");
    }

    @Test
    void testVerifyWeightTooLarge() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setFontSizeWeight( 1.5f );
        weightedWord.setColorWeight( 2000 );
        TagCloudJLabel tagCloudJLabel = new TagCloudJLabel( weightedWord );
        Assertions.assertEquals(1f, tagCloudJLabel.getWeightedWord().getFontSizeWeight(), 0.01f, "After creating a TagCloudJLabel with a sizeWeight of 1.5f and colorWeight of 2000  we expect the sizeWeight to be clipped at 1");
        Assertions.assertEquals(1f, tagCloudJLabel.getWeightedWord().getColorValue(), 0.01f, "After creating a TagCloudJLabel with a sizeWeight of 1.5f and colorWeight of 2000  we expect the colorWeight to be clipped at 1");
    }

    @Test
    void testVerifyWeightTooSmall() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setFontSizeWeight( -0.5f );
        weightedWord.setColorWeight( -2000 );
        TagCloudJLabel tagCloudJLabel = new TagCloudJLabel( weightedWord );
        Assertions.assertEquals(0f, tagCloudJLabel.getWeightedWord().getFontSizeWeight(), 0.01f, "After creating a TagCloudJLabel with a sizeWeight of -0.5f and colorWeight of -2000  we expect the sizeWeight to be floored at 0");
        Assertions.assertEquals(0f, tagCloudJLabel.getWeightedWord().getColorValue(), 0.01f, "After creating a TagCloudJLabel with a sizeWeight of -0.5f and colorWeight of -2000  we expect the colorWeight to be floored at 0");
    }

    @Test
    void testFont() {
        final var weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setFontSizeWeight( 0.5f );
        weightedWord.setColorWeight( 0.6f );
        final var tagCloudJLabel = new TagCloudJLabel( weightedWord );
        tagCloudJLabel.setFontMapper(new FontMapper(new SansSerifFontProvider()));
        final var font = tagCloudJLabel.getFont();
        Assertions.assertEquals("SansSerif.plain", font.getFontName(), "A default TagCloudJLabel with a sizeWeight of 0.5 and a colorWeight of 0.6 sould have a SansSerif font");
        Assertions.assertEquals(18, font.getSize(), "A default TagCloudJLabel with a sizeWeight of 0.5 and a colorWeight of 0.6 sould have the size 18");

    }

    @Test
    void testMousoverColor() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setFontSizeWeight( 0.5f );
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
    void testSetMousoverColor() {
        WeightedWord weightedWord = new WeightedWord( "Word", 10 );
        weightedWord.setFontSizeWeight( 0.5f );
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
    }*/

}
