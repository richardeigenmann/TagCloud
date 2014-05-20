/*
 WordAnalyserTest.java:  Unit tests of the WordAnalyser

 Copyright (C) 2009-2014  Richard Eigenmann.
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

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the WordAnalyser
 *
 * @author Richard Eigenmann
 */
public class WordAnalyserTest {

    private List<WeightedWord> weightedWords;
    private final WeightedWord word1 = new WeightedWord( "word1", 10, 100 );
    private final WeightedWord word2 = new WeightedWord( "word2", 20, 40 );
    private final WeightedWord word3 = new WeightedWord( "abcWord3", 30, 200 );
    private final WeightedWord word4 = new WeightedWord( "word4", 4, 300 );

    @Before
    public void setUp() {
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
    public void testConstructor() {
        WordAnalyser wordAnalyser = new WordAnalyser( weightedWords );
        assertEquals( "Check retrieval for index 0", word1, wordAnalyser.getWord( 0 ) );
        assertEquals( "Check weights for index 0", 10, wordAnalyser.getWord( 0 ).getSizeValue() );
        assertEquals( "Check weights for index 0", 100, wordAnalyser.getWord( 0 ).getColorValue() );
        assertEquals( "Check retrieval for index 3", word4, wordAnalyser.getWord( 3 ) );
        assertEquals( "Check retrieval for last index", word4, wordAnalyser.getWord( wordAnalyser.getWeightedWords().size() - 1 ) );
    }

    /**
     * Test the getSizeValueSortedTreeSet method
     */
    @Test
    public void testGetSizeValueSortedTreeSet() {
        WordAnalyser wordAnalyser = new WordAnalyser( weightedWords );
        assertEquals( "Checks the sizeValueSortedTreeSet: first value should be the index of the largest value i.e. word3", (Integer) 2, wordAnalyser.getSizeValueSortedTreeSet().first() );
        assertEquals( "Checks the sizeValueSortedTreeSet: last value should be the index of the smallest value i.e. word4", (Integer) 3, wordAnalyser.getSizeValueSortedTreeSet().last() );
        assertEquals( "Checks the sizeValueSortedTreeSet: we have not lost an entry", 4, wordAnalyser.getSizeValueSortedTreeSet().size() );
    }

    /**
     * Test the getMinSizeValue method
     */
    @Test
    public void testGetMinSizeValue() {
        WordAnalyser wordAnalyser = new WordAnalyser( weightedWords );
        assertEquals( "Checks that we get back the smallest sizeValue", 4, wordAnalyser.getMinSizeValue() );
    }

    /**
     * Test the getMaxSizeValue method
     */
    @Test
    public void testGetMaxSizeValue() {
        WordAnalyser wordAnalyser = new WordAnalyser( weightedWords );
        assertEquals( "Checks that we get back the largetst sizeValue", 30, wordAnalyser.getMaxSizeValue() );
    }

    /**
     * Test the getSizeWeight method
     */
    @Test
    public void testGetSizeWeight() {
        WordAnalyser wordAnalyser = new WordAnalyser( weightedWords );
        assertEquals( "If we come with value 4 we should get a weight of 0", 0f, wordAnalyser.getSizeWeight( 4 ), 0.000001 );
        assertEquals( "If we come with value 30 we should get a weight of 1", 1f, wordAnalyser.getSizeWeight( 30 ), 0.000001 );
        assertEquals( "If we come with value 17 we should get a weight of 0.5", 0.5, wordAnalyser.getSizeWeight( 17 ), 0.000001 );
    }

    /**
     * Test the getSizeWeight method with a division by zero situation.
     *
     */
    @Test
    public void testGetSizeWeightZero() {
        WeightedWord zeroWord1 = new WeightedWord( "word1", 0, 100 );
        WeightedWord zeroWord2 = new WeightedWord( "word2", 0, 200 );
        List<WeightedWord> zeroWeightedWords = new ArrayList<>();
        zeroWeightedWords.add( zeroWord1 );
        zeroWeightedWords.add( zeroWord2 );
        WordAnalyser zeroWordAnalyser = new WordAnalyser( zeroWeightedWords );
        assertEquals( "If we come with value 0 we should get a weight of 0", 0f, zeroWordAnalyser.getSizeWeight( 0 ), 0.000001 );
    }

    @Test
    public void testGetTopWordsSizeWeighted() {
        WordAnalyser wordAnalyser = new WordAnalyser( weightedWords );
        List<WeightedWord> fourWords = wordAnalyser.getTopWordsSizeWeighted( 4 );
        assertEquals( "If we ask for the top 4 words we should get 4 words", 4, fourWords.size() );
        assertEquals( "Since the list should be alphabetical the first word should be abcWord3", "abcWord3", fourWords.get( 0 ).getWord() );
        assertEquals( "Since the list should be alphabetical the last word should be word4", "word4", fourWords.get( 3 ).getWord() );

        List<WeightedWord> twoWords = wordAnalyser.getTopWordsSizeWeighted( 2 );
        assertEquals( "If we ask for the top 2 words we should get 2 words", 2, twoWords.size() );
        assertEquals( "Since the list should be alphabetical the first word of a truncated list should be abcWord3", "abcWord3", twoWords.get( 0 ).getWord() );
        assertEquals( "Since the list should be alphabetical the last word of a truncated list should be word2", "word2", twoWords.get( 1 ).getWord() );
    }

    @Test
    public void testGetTopWordsSizeWeightedEmpty() {
        List<WeightedWord> emptyList = new ArrayList<>();
        WordAnalyser wordAnalyser = new WordAnalyser( emptyList );
        List<WeightedWord> fourWords = wordAnalyser.getTopWordsSizeWeighted( 4 );
        assertEquals( "If we ask for the top 4 words from an empty list we should get 1 word", 1, fourWords.size() );
        assertEquals( "The word should be an empty string", "", fourWords.get( 0 ).getWord() );
    }

    @Test
    public void testGetTopWordsSizeWeightedSillyLimit() {
        WordAnalyser wordAnalyser = new WordAnalyser( weightedWords );
        List<WeightedWord> fourWords = wordAnalyser.getTopWordsSizeWeighted( 0 );
        assertEquals( "If we ask for the 0 words list we should get 1 empty string word", 1, fourWords.size() );
        assertEquals( "The word should be an empty string", "", fourWords.get( 0 ).getWord() );

        List<WeightedWord> minusFiveWords = wordAnalyser.getTopWordsSizeWeighted( -5 );
        assertEquals( "If we ask for the -5 words list we should get 1 empty string word", 1, minusFiveWords.size() );
        assertEquals( "The word should be an empty string", "", minusFiveWords.get( 0 ).getWord() );

    }

    /**
     * Test the getSizeValueSortedTreeSet method
     */
    @Test
    public void testGetColorValueSortedTreeSet() {
        WordAnalyser wordAnalyser = new WordAnalyser( weightedWords );
        assertEquals( "Checks the colorValueSortedTreeSet: first value should be the index of the largest value i.e. word4", (Integer) 3, wordAnalyser.getColorValueSortedTreeSet().first() );
        assertEquals( "Checks the colorValueSortedTreeSet: last value should be the index of the smallest value i.e. word2", (Integer) 1, wordAnalyser.getColorValueSortedTreeSet().last() );
        assertEquals( "Checks the colorValueSortedTreeSet: we have not lost an entry", 4, wordAnalyser.getColorValueSortedTreeSet().size() );
    }

    /**
     * Test the getMinSizeValue method
     */
    @Test
    public void testGetMinColorValue() {
        WordAnalyser wordAnalyser = new WordAnalyser( weightedWords );
        assertEquals( "Checks that we get back the smallest sizeValue", 40, wordAnalyser.getMinColorValue() );
    }

    /**
     * Test the getMaxSizeValue method
     */
    @Test
    public void testGetMaxColorValue() {
        WordAnalyser wordAnalyser = new WordAnalyser( weightedWords );
        assertEquals( "Checks that we get back the largetst sizeValue", 300, wordAnalyser.getMaxColorValue() );
    }

    /**
     * Test the getSizeWeight method
     *
     */
    @Test
    public void testGetColorWeight() {
        WordAnalyser wordAnalyser = new WordAnalyser( weightedWords );
        assertEquals( "If we come with value 40 we should get a weight of 0", 0f, wordAnalyser.getColorWeight( 40 ), 0.000001 );
        assertEquals( "If we come with value 300 we should get a weight of 1", 1f, wordAnalyser.getColorWeight( 300 ), 0.000001 );
        assertEquals( "If we come with value 170 we should get a weight of 0.5", 0.5, wordAnalyser.getColorWeight( 170 ), 0.000001 );
    }

    /**
     * Test the getSizeWeight method with a division by zero situation.
     *
     */
    @Test
    public void testGetColorWeightZero() {
        WeightedWord zeroWord1 = new WeightedWord( "word1", 10, 0 );
        WeightedWord zeroWord2 = new WeightedWord( "word2", 20, 0 );
        List<WeightedWord> zeroWeightedWords = new ArrayList<>();
        zeroWeightedWords.add( zeroWord1 );
        zeroWeightedWords.add( zeroWord2 );
        WordAnalyser zeroWordAnalyser = new WordAnalyser( zeroWeightedWords );
        assertEquals( "If we come with value 0 we should get a weight of 0", 0f, zeroWordAnalyser.getColorWeight( 0 ), 0.000001 );
    }

    @Test
    public void testGetTopWordsColorWeighted() {
        WordAnalyser wordAnalyser = new WordAnalyser( weightedWords );
        List<WeightedWord> fourWords = wordAnalyser.getTopWordsColorWeighted( 4 );
        assertEquals( "If we ask for the top 4 words we should get 4 words", 4, fourWords.size() );
        assertEquals( "Since the list should be alphabetical the first word should be abcWord3", "abcWord3", fourWords.get( 0 ).getWord() );
        assertEquals( "Since the list should be alphabetical the last word should be word4", "word4", fourWords.get( 3 ).getWord() );

        List<WeightedWord> twoWords = wordAnalyser.getTopWordsColorWeighted( 2 );
        assertEquals( "If we ask for the top 2 words we should get 2 words", 2, twoWords.size() );
        assertEquals( "Since the list should be alphabetical the first word of a truncated Color weighted list should be abcWord3", "abcWord3", twoWords.get( 0 ).getWord() );
        assertEquals( "Since the list should be alphabetical the last word of a truncated Color weighted list should be word4", "word4", twoWords.get( 1 ).getWord() );
    }

    @Test
    public void testGetTopWordsColorWeightedEmpty() {
        List<WeightedWord> emptyList = new ArrayList<>();
        WordAnalyser wordAnalyser = new WordAnalyser( emptyList );
        List<WeightedWord> fourWords = wordAnalyser.getTopWordsColorWeighted( 4 );
        assertEquals( "If we ask for the top 4 words from an empty list we should get 1 word", 1, fourWords.size() );
        assertEquals( "The word should be an empty string", "", fourWords.get( 0 ).getWord() );
    }

    @Test
    public void testGetTopWordsColorWeightedSillyLimit() {
        WordAnalyser wordAnalyser = new WordAnalyser( weightedWords );
        List<WeightedWord> fourWords = wordAnalyser.getTopWordsColorWeighted( 0 );
        assertEquals( "If we ask for the 0 words list we should get 1 empty string word", 1, fourWords.size() );
        assertEquals( "The word should be an empty string", "", fourWords.get( 0 ).getWord() );

        List<WeightedWord> minusFiveWords = wordAnalyser.getTopWordsColorWeighted( -5 );
        assertEquals( "If we ask for the -5 words list we should get 1 empty string word", 1, minusFiveWords.size() );
        assertEquals( "The word should be an empty string", "", minusFiveWords.get( 0 ).getWord() );

    }

}
