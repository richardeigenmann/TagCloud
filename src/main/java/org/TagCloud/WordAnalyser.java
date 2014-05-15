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

    public WordAnalyser( List<WeightedWord> weightedWords ) {
        this.weightedWords = weightedWords;
    }

    /**
     * Returns the word for the index
     *
     * @param i the word index
     * @return the weighted word
     */
    public WeightedWord getWord( int i ) {
        return weightedWords.get( i );
    }

    /**
     * Returns the list of WeightedWords
     *
     * @return the weighted word
     */
    public List<WeightedWord> getWeightedWords() {
        return weightedWords;
    }

    /**
     * Empties the cache of the sorted-by-value word list and rebuilds it,
     */
    public void rebuild() {
        //valueSortedTreeMap = null;
        //getValueSortedMap();
    }

    /**
     * Sorted set of indexes ordered by sizeValue
     */
    private TreeSet<Integer> sizeValueSortedTreeSet;

    /**
     * This method returns a TreeSet of the index numbers of the weightedWords
     * list where the indexes are sorted by the sizeValue of the weighted word.
     * If the source words change you need to call
     *
     * @see #rebuild().
     * <p>
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

    public int getMaxSizeValue() {
        return weightedWords.get( getSizeValueSortedTreeSet().first() ).getSizeValue();
    }

    public int getMinSizeValue() {
        return weightedWords.get( getSizeValueSortedTreeSet().last() ).getSizeValue();
    }

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
        return getTopWords(getSizeValueSortedTreeSet().iterator(), limit );
    }

    
    
    /**
     * Sorted set of indexes ordered by colorValue
     */
    private TreeSet<Integer> colorValueSortedTreeSet;

    /**
     * This method returns a TreeSet of the index numbers of the weightedWords
     * list where the indexes are sorted by the colorValue of the weighted word.
     * If the source words change you need to call
     *
     * @see #rebuild().
     * <p>
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

    public int getMaxColorValue() {
        return weightedWords.get( getColorValueSortedTreeSet().first() ).getColorValue();
    }

    public int getMinColorValue() {
        return weightedWords.get( getColorValueSortedTreeSet().last() ).getColorValue();
    }

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
        return getTopWords(getColorValueSortedTreeSet().iterator(), limit );
    }

    
    
       /**
     * Returns an alphabetical List of the the first n words as per the
     * ColorValue order
     *
     * @param limit The maximum words to return
     * @return an alphabetical set of the highest ranking n words
     */
    public List<WeightedWord> getTopWords( Iterator<Integer> indexIterator, int limit ) {
        List<WeightedWord> resultList = new ArrayList<>();
        if (( limit < 1 ) || ( weightedWords.isEmpty() ) ) {
            resultList.add( new WeightedWord("",0,0) );
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
            resultList.add( weightedWords.get( index ));
        }
        
        return resultList;
    }

  
}
