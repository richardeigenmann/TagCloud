/*
 WordAnalyser.java:  A class that does the analytics for the tag cloud

 Copyright (C) 2009-2025  Richard Eigenmann.
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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Logger;

/**
 * This class does the processing and filtering of the words
 *
 * @author Richard Eigenmann
 */
public class WordAnalyser {

    /**
     * Defines the logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger( WordAnalyser.class.getName() );

    /**
     * The list of words with their weights
     */
    private final List<? extends WeightedWordInterface> weightedWords;

    /**
     * Creates a new WordAnalyzer with the supplied list of WeightedWords.
     * Figures out the minimum and maximum values and can calculate the weight
     * from 0 to 1 for the font weight and color weight.
     *
     * @param weightedWords The list of weightedWords
     */
    public WordAnalyser( final List<? extends WeightedWordInterface> weightedWords ) {
        this.weightedWords = weightedWords;
    }

    /**
     * Returns the word for the index
     *
     * @param i the word index, 0 to size() - 1 
     * @return the weighted word
     */
    public WeightedWordInterface getWord( int i ) {
        return weightedWords.get( i );
    }

    /**
     * Returns the list of WeightedWords
     *
     * @return the weighted words
     */
    public List<? extends WeightedWordInterface> getWeightedWords() {
        return weightedWords;
    }

    /**
     * Sorted set of indexes ordered by sizeValue
     */
    private TreeSet<Integer> sizeValueSortedTreeSet;

    /**
     * This method returns a TreeSet of the index numbers of the weightedWords
     * list where the indexes are sorted by the sizeValue of the weighted word.
     * If two values are identical the alphabetically smaller word will come first.
     *
     * @return The TreeSet of index values
     */
    public TreeSet<Integer> getSizeValueSortedTreeSet() {
        if ( sizeValueSortedTreeSet == null ) {
            sizeValueSortedTreeSet = new TreeSet<>(new Comparator<>() {

                /**
                 * override the compare method so that we can have the TreeMap
                 * sorted by value instead of by word
                 */
                @Override
                public int compare(final Integer index1, final Integer index2) {
                    final var size1 = weightedWords.get(index1).getFontSizeValue();
                    final var size2 = weightedWords.get(index2).getFontSizeValue();
                    if (!(size1 == size2)) {
                        return Double.compare(size2, size1);
                    } else {
                        String word1 = weightedWords.get(index1).getWord();
                        String word2 = weightedWords.get(index2).getWord();
                        return word1.compareTo(word2);
                    }
                }
            } );
            for ( int i = 0; i < weightedWords.size(); i++ ) {
                sizeValueSortedTreeSet.add( i );
            }
        }
        return sizeValueSortedTreeSet;
    }

    /**
     * Returns the highest value of the fontSize values
     * @return the highest value of the fontSize weights
     */
    public double getMaxFontSizeValue() {
        return weightedWords.get( getSizeValueSortedTreeSet().first() ).getFontSizeValue();
    }

    /**
     * Returns the lowest value of the size values
     * @return the lowest value of the size weights
     */
    public double getMinFontSizeValue() {
        return weightedWords.get( getSizeValueSortedTreeSet().last() ).getFontSizeValue();
    }

    /**
     * Returns the weight from 0 to 1 for a given size value
     * @param value the value for which to figure out the weight
     * @return the weight in the range 0..1
     */
    public static double getSizeWeight( double value, double min, double max ) {
        final var deltaToMin = value - min; //getMinFontSizeValue()
        var range = max - min; // getMaxFontSizeValue()
        if ( range == 0 ) {
            return 0; //prevent division by zero
        } else {
            return (double) deltaToMin / (double) range;
        }
    }

    /**
     * Returns an alphabetical List of the the first n words as per the
     * SizeValue order
     *
     * @param limit The maximum words to return
     * @return an alphabetical set of the highest ranking n words
     */
    public List<WeightedWordInterface> getTopWordsSizeWeighted( int limit ) {
        return getTopWords( getSizeValueSortedTreeSet().iterator(), limit );
    }

    /**
     * Sorted set of indexes ordered by colorValue
     */
    private TreeSet<Integer> colorValueSortedTreeSet;

    /**
     * This method returns a TreeSet of the index numbers of the weightedWords
     * list where the indexes are sorted by the colorValue of the weighted word.
     *
     * @return The TreeSet of index values
     */
    public TreeSet<Integer> getColorValueSortedTreeSet() {
        if ( colorValueSortedTreeSet == null ) {
            colorValueSortedTreeSet = new TreeSet<>(new Comparator<>() {

                /**
                 * override the compare method so that we can have the TreeMap
                 * sorted by value instead of by word
                 */
                @Override
                public int compare(Integer index1, Integer index2) {
                    final var size1 = weightedWords.get(index1).getColorValue();
                    final var size2 = weightedWords.get(index2).getColorValue();
                    if (!(size1 == size2)) {
                        return Double.compare(size2, size1);
                    } else {
                        String word1 = weightedWords.get(index1).getWord();
                        String word2 = weightedWords.get(index2).getWord();
                        return word1.compareTo(word2);
                    }
                }
            } );
            for ( int i = 0; i < weightedWords.size(); i++ ) {
                colorValueSortedTreeSet.add( i );
            }
        }
        return colorValueSortedTreeSet;
    }

    /**
     * Returns the highest value of the color value
     * @return the highest color value
     */
    public double getMaxColorValue() {
        return weightedWords.get( getColorValueSortedTreeSet().first() ).getColorValue();
    }

    /**
     * Returns the lowest value of the color value
     * @return the lowest color value
     */
    public double getMinColorValue() {
        return weightedWords.get( getColorValueSortedTreeSet().last() ).getColorValue();
    }

    /**
     * Figures out the weight from 0 to 1 based on the supplied color value
     * @param value the value for which to figure out the weight
     * @return the weight
     */
    public double getColorWeight( double value ) {
        final var deltaToMin = value - getMinColorValue();
        final var valueRange = getMaxColorValue() - getMinColorValue();
        if ( valueRange == 0 ) {
            return 0; //prevent division by zero
        } else {
            return (double) deltaToMin / (float) valueRange;
        }
    }

    /**
     * Returns an alphabetical List of the the first n words as per the
     * ColorValue order
     *
     * @param limit The maximum words to return
     * @return an alphabetical set of the highest ranking n words
     */
    public List<WeightedWordInterface> getTopWordsColorWeighted( int limit ) {
        return getTopWords( getColorValueSortedTreeSet().iterator(), limit );
    }

    /**
     * Returns an alphabetical List of the the first n words as per the
     * ColorValue order
     *
     * @param indexIterator The iterator to use to step through the words
     * @param limit The maximum words to return
     * @return an alphabetical set of the highest ranking n words
     */
    private List<WeightedWordInterface> getTopWords( Iterator<Integer> indexIterator, int limit ) {
        List<WeightedWordInterface> resultList = new ArrayList<>();
        if ( ( limit < 1 ) || ( weightedWords.isEmpty() ) ) {
            resultList.add( new WeightedWord( "", 0, 0 ) );
            return resultList;
        }

        TreeSet<Integer> topWords = new TreeSet<>(new Comparator<>() {

            /**
             * override the compare method so that we can have the TreeSet
             * sorted by value instead of by word
             */
            @Override
            public int compare(Integer index1, Integer index2) {
                String word1 = weightedWords.get(index1).getWord();
                String word2 = weightedWords.get(index2).getWord();
                return word1.compareTo(word2);
            }
        } );

        int i = 0;
        while ( indexIterator.hasNext() && i < limit ) {
            topWords.add( indexIterator.next() );
            i++;
        }

        for ( Integer index : topWords ) {
            resultList.add( weightedWords.get( index ) );
        }

        return resultList;
    }

}
