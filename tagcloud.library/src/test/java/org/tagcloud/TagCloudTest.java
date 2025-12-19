/*
 TagCloudJLabelTest.java:  Unit tests for TagCloudJLabel

 Copyright (C) 2014-2025 Richard Eigenmann.
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

import org.junit.jupiter.api.Test;
import org.tagcloud.colorproviders.ColorProvider;
import org.tagcloud.fontproviders.FontProvider;

import org.junit.jupiter.api.Assertions;

import javax.swing.SwingUtilities;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class TagCloudTest {

    @Test
    void testConstructor() throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(() -> {
            final var tagCloud = new TagCloud();
            Assertions.assertNotNull(tagCloud, "TagCloud could not be constructed");
        });
    }

    @Test
    void testIdentifyValueRanges() {
        // 1. Arrange
        List<WeightedWord> wordList = new ArrayList<>();
        wordList.add(new WeightedWord("Word1", 10, 100)); // min size, max color
        wordList.add(new WeightedWord("Word2", 20, 50));
        wordList.add(new WeightedWord("Word3", 30, 0));   // max size, min color

        FontProvider fontProvider = size -> null; // Dummy provider
        ColorProvider colorProvider = value -> null; // Dummy provider

        FontMapper fontMapper = new FontMapper(fontProvider);
        ColorMapper colorMapper = new ColorValueMapper(colorProvider);

        // 2. Act
        TagCloud.identifyValueRanges(wordList, fontMapper, colorMapper);

        // 3. Assert
        Assertions.assertEquals(10.0, fontMapper.getMinimumValue(), "Min font value is incorrect");
        Assertions.assertEquals(30.0, fontMapper.getMaximumValue(), "Max font value is incorrect");
        Assertions.assertEquals(0.0, colorMapper.getMinimumValue(), "Min color value is incorrect");
        Assertions.assertEquals(100.0, colorMapper.getMaximumValue(), "Max color value is incorrect");
    }

    @Test
    void testIdentifyValueRanges_SingleWord() {
        // 1. Arrange
        List<WeightedWord> wordList = new ArrayList<>();
        wordList.add(new WeightedWord("Word1", 25, 75));

        FontMapper fontMapper = new FontMapper(size -> null);
        ColorMapper colorMapper = new ColorValueMapper(value -> null);

        // 2. Act
        TagCloud.identifyValueRanges(wordList, fontMapper, colorMapper);

        // 3. Assert
        Assertions.assertEquals(25.0, fontMapper.getMinimumValue(), "Min font value should equal max with single word");
        Assertions.assertEquals(25.0, fontMapper.getMaximumValue(), "Max font value should equal min with single word");
        Assertions.assertEquals(75.0, colorMapper.getMinimumValue(), "Min color value should equal max with single word");
        Assertions.assertEquals(75.0, colorMapper.getMaximumValue(), "Max color value should equal min with single word");
    }

    @Test
    void testIdentifyValueRanges_SameValues() {
        // 1. Arrange
        List<WeightedWord> wordList = new ArrayList<>();
        wordList.add(new WeightedWord("Word1", 50, 50));
        wordList.add(new WeightedWord("Word2", 50, 50));
        wordList.add(new WeightedWord("Word3", 50, 50));

        FontMapper fontMapper = new FontMapper(size -> null);
        ColorMapper colorMapper = new ColorValueMapper(value -> null);

        // 2. Act
        TagCloud.identifyValueRanges(wordList, fontMapper, colorMapper);

        // 3. Assert
        Assertions.assertEquals(50.0, fontMapper.getMinimumValue(), "Min font value is incorrect with same values");
        Assertions.assertEquals(50.0, fontMapper.getMaximumValue(), "Max font value is incorrect with same values");
        Assertions.assertEquals(50.0, colorMapper.getMinimumValue(), "Min color value is incorrect with same values");
        Assertions.assertEquals(50.0, colorMapper.getMaximumValue(), "Max color value is incorrect with same values");
    }

    @Test
    void testSetWordsListAndMaxWords() throws InvocationTargetException, InterruptedException {
        // 1. Arrange
        List<WeightedWord> wordList = IntStream.range(0, 50)
                .mapToObj(i -> new WeightedWord("Word" + i, i, i))
                .toList();

        SwingUtilities.invokeAndWait(() -> {
            TagCloud tagCloud = new TagCloud();

            // 2. Act & Assert - Initial state
            tagCloud.setWordsList(wordList);
            Container viewportContent = (Container) tagCloud.getViewport().getComponent(0);
            // The default wordsToShow is 30
            Assertions.assertEquals(30, viewportContent.getComponentCount(), "Default number of words not shown correctly");

            // 3. Act & Assert - Change max words
            tagCloud.setMaxWordsToShow(15);
            Assertions.assertEquals(15, viewportContent.getComponentCount(), "Number of words not updated correctly after setMaxWordsToShow");

            // 4. Act & Assert - Test invalid (negative) max words
            tagCloud.setMaxWordsToShow(-5);
            Assertions.assertEquals(1, viewportContent.getComponentCount(), "Negative max words should default to 1");
        });
    }

    @Test
    void testTagClickListener() throws InvocationTargetException, InterruptedException {
        // 1. Arrange
        final var wordToClick = new WeightedWord("ClickMe", 10, 10);
        final List<WeightedWord> wordList = new ArrayList<>();
        wordList.add(wordToClick);
        final var listener = new MockTagClickListener();

        SwingUtilities.invokeAndWait(() -> {
            final var tagCloud = new TagCloud();
            tagCloud.setWordsList(wordList);

            // 2. Act & Assert - Add listener and simulate click
            tagCloud.addTagClickListener(listener);
            final var label = (TagCloudJLabel) ((Container) tagCloud.getViewport().getComponent(0)).getComponent(0);
            label.dispatchEvent(new MouseEvent(label, MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, 10, 10, 1, false));

            Assertions.assertTrue(listener.isClicked(), "Listener should have been clicked");
            Assertions.assertEquals(wordToClick, listener.getClickedWord(), "The correct word should be passed to the listener");

            // 3. Act & Assert - Remove listener and simulate click again
            listener.reset(); // Reset the mock
            tagCloud.removeTagClickListener(listener);
            label.dispatchEvent(new MouseEvent(label, MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, 10, 10, 1, false));

            Assertions.assertFalse(listener.isClicked(), "Listener should not be clicked after being removed");
        });
    }

    /**
     * Mock implementation of TagClickListener for testing purposes.
     */
    private static class MockTagClickListener implements TagClickListener {
        private boolean clicked = false;
        private WeightedWordInterface clickedWord;

        @Override
        public void tagClicked(WeightedWordInterface weightedWord) {
            this.clicked = true;
            this.clickedWord = weightedWord;
        }

        public boolean isClicked() {
            return clicked;
        }

        public WeightedWordInterface getClickedWord() {
            return clickedWord;
        }

        public void reset() {
            this.clicked = false;
            this.clickedWord = null;
        }
    }
}
