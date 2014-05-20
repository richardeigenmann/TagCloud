/*
 WordAnalyser.java:  A class that does the analytics for the tag cloud

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
    private final List<WeightedWord> weightedWords;

    /**
     * Creates a new WordAnalyzer with the supplied list of WeightedWords.
     * Figures out the minimum and maximum values and can calculate the weigth
     * from 0 to 1 for the font weight and color weight.
     *
     * @param weightedWords The list of weightedWords
     */
    public WordAnalyser( List<WeightedWord> weightedWords ) {
        this.weightedWords = weightedWords;
    }

    /**
     * Returns the word for the index
     *
     * @param i the word index, 0 to size() - 1 
     * @return the weighted word
     */
    public WeightedWord getWord( int i ) {
        return weightedWords.get( i );
    }

    /**
     * Returns the list of WeightedWords
     *
     * @return the weighted words
     */
    public List<WeightedWord> getWeightedWords() {
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
            sizeValueSortedTreeSet = new TreeSet<>( new Comparator<Integer>() {

                /**
                 * override the compare method so that we can have the TreeMap
                 * sorted by value instead of by word
                 */
                @Override
                public int compare( Integer index1, Integer index2 ) {
                    int size1 = weightedWords.get( index1 ).getSizeValue();
                    int size2 = weightedWords.get( index2 ).getSizeValue();
                    if ( !( size1 == size2 ) ) {
                        return ( (Integer) size2 ).compareTo( size1 );
                    } else {
                        String word1 = weightedWords.get( index1 ).getWord();
                        String word2 = weightedWords.get( index2 ).getWord();
                        return word1.compareTo( word2 );
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
     * Returns the highest value of the size values
     * @return the highest value of the size weights
     */
    public int getMaxSizeValue() {
        return weightedWords.get( getSizeValueSortedTreeSet().first() ).getSizeValue();
    }

    /**
     * Returns the lowest value of the size values
     * @return the lowest value of the size weights
     */
    public int getMinSizeValue() {
        return weightedWords.get( getSizeValueSortedTreeSet().last() ).getSizeValue();
    }

    /**
     * Returns the weight from 0 to 1 for a given size value
     * @param value the value for which to figure out the weight
     * @return the weight in the range 0..1
     */
    public float getSizeWeight( int value ) {
        int adjustedValue = value - getMinSizeValue();
        int adjustedMax = getMaxSizeValue() - getMinSizeValue();
        if ( adjustedMax == 0 ) {
            return 0; //prevent division by zero
        } else {
            return (float) adjustedValue / (float) adjustedMax;
        }
    }

    /**
     * Returns an alphabetical List of the the first n words as per the
     * SizeValue order
     *
     * @param limit The maximum words to return
     * @return an alphabetical set of the highest ranking n words
     */
    public List<WeightedWord> getTopWordsSizeWeighted( int limit ) {
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
            colorValueSortedTreeSet = new TreeSet<>( new Comparator<Integer>() {

                /**
                 * override the compare method so that we can have the TreeMap
                 * sorted by value instead of by word
                 */
                @Override
                public int compare( Integer index1, Integer index2 ) {
                    int size1 = weightedWords.get( index1 ).getColorValue();
                    int size2 = weightedWords.get( index2 ).getColorValue();
                    if ( !( size1 == size2 ) ) {
                        return ( (Integer) size2 ).compareTo( size1 );
                    } else {
                        String word1 = weightedWords.get( index1 ).getWord();
                        String word2 = weightedWords.get( index2 ).getWord();
                        return word1.compareTo( word2 );
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
    public int getMaxColorValue() {
        return weightedWords.get( getColorValueSortedTreeSet().first() ).getColorValue();
    }

    /**
     * Returns the lowest value of the color value
     * @return the lowest color value
     */
    public int getMinColorValue() {
        return weightedWords.get( getColorValueSortedTreeSet().last() ).getColorValue();
    }

    /**
     * Figures out the weight from 0 to 1 based on the supplied color value
     * @param value the value for which to figure out the weight
     * @return the weight
     */
    public float getColorWeight( int value ) {
        int adjustedValue = value - getMinColorValue();
        int adjustedMax = getMaxColorValue() - getMinColorValue();
        if ( adjustedMax == 0 ) {
            return 0; //prevent division by zero
        } else {
            return (float) adjustedValue / (float) adjustedMax;
        }
    }

    /**
     * Returns an alphabetical List of the the first n words as per the
     * ColorValue order
     *
     * @param limit The maximum words to return
     * @return an alphabetical set of the highest ranking n words
     */
    public List<WeightedWord> getTopWordsColorWeighted( int limit ) {
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
    private List<WeightedWord> getTopWords( Iterator<Integer> indexIterator, int limit ) {
        List<WeightedWord> resultList = new ArrayList<>();
        if ( ( limit < 1 ) || ( weightedWords.isEmpty() ) ) {
            resultList.add( new WeightedWord( "", 0, 0 ) );
            return resultList;
        }

        TreeSet<Integer> topWords = new TreeSet<>( new Comparator<Integer>() {

            /**
             * override the compare method so that we can have the TreeSet
             * sorted by value instead of by word
             */
            @Override
            public int compare( Integer index1, Integer index2 ) {
                String word1 = weightedWords.get( index1 ).getWord();
                String word2 = weightedWords.get( index2 ).getWord();
                return word1.compareTo( word2 );
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
