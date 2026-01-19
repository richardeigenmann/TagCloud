/*
 WordAnalyserTest.java:  Unit tests of the WordAnalyser

 Copyright (C) 2009-2025 Richard Eigenmann.
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
package my.samplegui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.tagcloud.WeightedWord;
import org.tagcloud.WeightedWordInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit tests for the WordAnalyser
 *
 * @author Richard Eigenmann
 */
class WordAnalyserTest {

    private List<WeightedWordInterface> weightedWords;
    private final WeightedWord word1 = new WeightedWord( "word1", 10, 100 );
    private final WeightedWord word2 = new WeightedWord( "word2", 20, 40 );
    private final WeightedWord word3 = new WeightedWord( "abcWord3", 30, 200 );
    private final WeightedWord word4 = new WeightedWord( "word4", 4, 300 );

    @BeforeEach
    void setUp() {
        weightedWords = new ArrayList<>();
        weightedWords.add( word1 );
        weightedWords.add( word2 );
        weightedWords.add( word3 );
        weightedWords.add( word4 );
    }

    /**
     * Test of toString method, of class WordAnalyser.
     */
    @Test
    void testConstructor() {
        final var wordAnalyser = new WordAnalyser( weightedWords );
        Assertions.assertEquals(word1, wordAnalyser.getWord( 0 ), "Check retrieval for index 0");
        Assertions.assertEquals(10, wordAnalyser.getWord( 0 ).getFontSizeValue(), "Check weights for index 0");
        Assertions.assertEquals(100, wordAnalyser.getWord( 0 ).getColorValue(), "Check weights for index 0");
        Assertions.assertEquals(word4, wordAnalyser.getWord( 3 ), "Check retrieval for index 3");
        Assertions.assertEquals(word4, wordAnalyser.getWord( wordAnalyser.getWeightedWords().size() - 1 ), "Check retrieval for last index");
    }

    /**
     * Test the getSizeValueSortedTreeSet method
     */
    @Test
    void testGetSizeValueSortedTreeSet() {
        final var wordAnalyser = new WordAnalyser( weightedWords );
        Assertions.assertEquals((Integer) 2, wordAnalyser.getSizeValueSortedTreeSet().first(), "Checks the sizeValueSortedTreeSet: first value should be the index of the largest value i.e. word3");
        Assertions.assertEquals((Integer) 3, wordAnalyser.getSizeValueSortedTreeSet().last(), "Checks the sizeValueSortedTreeSet: last value should be the index of the smallest value i.e. word4");
        Assertions.assertEquals(4, wordAnalyser.getSizeValueSortedTreeSet().size(), "Checks the sizeValueSortedTreeSet: we have not lost an entry");
    }

    /**
     * Test the getMinSizeValue method
     */
    @Test
    void testGetMinFontSizeValue() {
        final var wordAnalyser = new WordAnalyser( weightedWords );
        Assertions.assertEquals(4, wordAnalyser.getMinFontSizeValue(), "Checks that we get back the smallest sizeValue");
    }

    /**
     * Test the getMaxSizeValue method
     */
    @Test
    void testGetMaxFontSizeValue() {
        final var wordAnalyser = new WordAnalyser( weightedWords );
        Assertions.assertEquals(30, wordAnalyser.getMaxFontSizeValue(), "Checks that we get back the largest sizeValue");
    }

    @Test
    void testGetTopWordsSizeWeighted() {
        final var wordAnalyser = new WordAnalyser( weightedWords );
        List<WeightedWordInterface> fourWords = wordAnalyser.getTopWordsSizeWeighted( 4 );
        Assertions.assertEquals(4, fourWords.size(), "If we ask for the top 4 words we should get 4 words");
        Assertions.assertEquals("abcWord3", fourWords.get( 0 ).getWord(), "Since the list should be alphabetical the first word should be abcWord3");
        Assertions.assertEquals("word4", fourWords.get( 3 ).getWord(), "Since the list should be alphabetical the last word should be word4");

        List<WeightedWordInterface> twoWords = wordAnalyser.getTopWordsSizeWeighted( 2 );
        Assertions.assertEquals(2, twoWords.size(), "If we ask for the top 2 words we should get 2 words");
        Assertions.assertEquals("abcWord3", twoWords.get( 0 ).getWord(), "Since the list should be alphabetical the first word of a truncated list should be abcWord3");
        Assertions.assertEquals("word2", twoWords.get( 1 ).getWord(), "Since the list should be alphabetical the last word of a truncated list should be word2");
    }

    @Test
    void testGetTopWordsSizeWeightedEmpty() {
        List<WeightedWordInterface> emptyList = new ArrayList<>();
        final var wordAnalyser = new WordAnalyser( emptyList );
        List<WeightedWordInterface> fourWords = wordAnalyser.getTopWordsSizeWeighted( 4 );
        Assertions.assertEquals(1, fourWords.size(), "If we ask for the top 4 words from an empty list we should get 1 word");
        Assertions.assertEquals("", fourWords.getFirst().getWord(), "The word should be an empty string");
    }

    @Test
    void testGetTopWordsSizeWeightedSillyLimit() {
        final var wordAnalyser = new WordAnalyser( weightedWords );
        List<WeightedWordInterface> fourWords = wordAnalyser.getTopWordsSizeWeighted( 0 );
        Assertions.assertEquals(1, fourWords.size(), "If we ask for the 0 words list we should get 1 empty string word");
        Assertions.assertEquals("", fourWords.getFirst().getWord(), "The word should be an empty string");

        List<WeightedWordInterface> minusFiveWords = wordAnalyser.getTopWordsSizeWeighted( -5 );
        Assertions.assertEquals(1, minusFiveWords.size(), "If we ask for the -5 words list we should get 1 empty string word");
        Assertions.assertEquals("", minusFiveWords.getFirst().getWord(), "The word should be an empty string");

    }

    /**
     * Test the getSizeValueSortedTreeSet method
     */
    @Test
    void testGetColorValueSortedTreeSet() {
        final var wordAnalyser = new WordAnalyser( weightedWords );
        Assertions.assertEquals((Integer) 3, wordAnalyser.getColorValueSortedTreeSet().first(), "Checks the colorValueSortedTreeSet: first value should be the index of the largest value i.e. word4");
        Assertions.assertEquals((Integer) 1, wordAnalyser.getColorValueSortedTreeSet().last(), "Checks the colorValueSortedTreeSet: last value should be the index of the smallest value i.e. word2");
        Assertions.assertEquals(4, wordAnalyser.getColorValueSortedTreeSet().size(), "Checks the colorValueSortedTreeSet: we have not lost an entry");
    }

    /**
     * Test the getMinSizeValue method
     */
    @Test
    void testGetMinColorValue() {
        final var wordAnalyser = new WordAnalyser( weightedWords );
        Assertions.assertEquals(40, wordAnalyser.getMinColorValue(), "Checks that we get back the smallest sizeValue");
    }

    /**
     * Test the getMaxSizeValue method
     */
    @Test
    void testGetMaxColorValue() {
        final var wordAnalyser = new WordAnalyser( weightedWords );
        Assertions.assertEquals(300, wordAnalyser.getMaxColorValue(), "Checks that we get back the largest sizeValue");
    }

    /**
     * Test the getSizeWeight method
     *
     */
    @Test
    void testGetColorWeight() {
        final var wordAnalyser = new WordAnalyser( weightedWords );
        Assertions.assertEquals(0f, wordAnalyser.getColorWeight( 40 ), 0.000001, "If we come with value 40 we should get a weight of 0");
        Assertions.assertEquals(1f, wordAnalyser.getColorWeight( 300 ), 0.000001, "If we come with value 300 we should get a weight of 1");
        Assertions.assertEquals(0.5, wordAnalyser.getColorWeight( 170 ), 0.000001, "If we come with value 170 we should get a weight of 0.5");
    }

    /**
     * Test the getSizeWeight method with a division by zero situation.
     *
     */
    @Test
    void testGetColorWeightZero() {
        final var zeroWord1 = new WeightedWord( "word1", 10, 0 );
        final var zeroWord2 = new WeightedWord( "word2", 20, 0 );
        List<WeightedWordInterface> zeroWeightedWords = new ArrayList<>();
        zeroWeightedWords.add( zeroWord1 );
        zeroWeightedWords.add( zeroWord2 );
        WordAnalyser zeroWordAnalyser = new WordAnalyser( zeroWeightedWords );
        Assertions.assertEquals(0f, zeroWordAnalyser.getColorWeight( 0 ), 0.000001, "If we come with value 0 we should get a weight of 0");
    }

    @Test
    void testGetTopWordsColorWeighted() {
        final var wordAnalyser = new WordAnalyser( weightedWords );
        List<WeightedWordInterface> fourWords = wordAnalyser.getTopWordsColorWeighted( 4 );
        Assertions.assertEquals(4, fourWords.size(), "If we ask for the top 4 words we should get 4 words");
        Assertions.assertEquals("abcWord3", fourWords.get( 0 ).getWord(), "Since the list should be alphabetical the first word should be abcWord3");
        Assertions.assertEquals("word4", fourWords.get( 3 ).getWord(), "Since the list should be alphabetical the last word should be word4");

        List<WeightedWordInterface> twoWords = wordAnalyser.getTopWordsColorWeighted( 2 );
        Assertions.assertEquals(2, twoWords.size(), "If we ask for the top 2 words we should get 2 words");
        Assertions.assertEquals("abcWord3", twoWords.get( 0 ).getWord(), "Since the list should be alphabetical the first word of a truncated Color weighted list should be abcWord3");
        Assertions.assertEquals("word4", twoWords.get( 1 ).getWord(), "Since the list should be alphabetical the last word of a truncated Color weighted list should be word4");
    }

    @Test
    void testGetTopWordsColorWeightedEmpty() {
        List<WeightedWordInterface> emptyList = new ArrayList<>();
        final var wordAnalyser = new WordAnalyser( emptyList );
        List<WeightedWordInterface> fourWords = wordAnalyser.getTopWordsColorWeighted( 4 );
        Assertions.assertEquals(1, fourWords.size(), "If we ask for the top 4 words from an empty list we should get 1 word");
        Assertions.assertEquals("", fourWords.getFirst().getWord(), "The word should be an empty string");
    }

    @Test
    void testGetTopWordsColorWeightedSillyLimit() {
        final var wordAnalyser = new WordAnalyser( weightedWords );
        List<WeightedWordInterface> fourWords = wordAnalyser.getTopWordsColorWeighted( 0 );
        Assertions.assertEquals(1, fourWords.size(), "If we ask for the 0 words list we should get 1 empty string word");
        Assertions.assertEquals("", fourWords.getFirst().getWord(), "The word should be an empty string");

        List<WeightedWordInterface> minusFiveWords = wordAnalyser.getTopWordsColorWeighted( -5 );
        Assertions.assertEquals(1, minusFiveWords.size(), "If we ask for the -5 words list we should get 1 empty string word");
        Assertions.assertEquals("", minusFiveWords.getFirst().getWord(), "The word should be an empty string");
    }
}
