/*
 WeightedWord.java:  Unit tests for TagCloudJLabel

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
package org.TagCloud;

/**
 * Stores the attributes of a word for the Tag Cloud. Each word has a positive
 * integer value for the weight of the font and the weight of the color. They
 * can be the same but don't have to. The WordAnalyser figures out the maximum
 * and minimum values and calculates a weight from 0 to 1.
 *
 * @author Richard Eigenmann
 */
public class WeightedWord {

    /**
     * Remembers the word
     */
    private final String word;

    /**
     * Remembers the value for the size. Should be any positive integer
     */
    private final int sizeValue;

    /**
     * Remembers the value for the color. Should be any positive integer
     */
    private final int colorValue;

    /**
     * Constructs a word with the same value for the size and color
     *
     * @param word the word
     * @param value the value, any positive integer
     */
    public WeightedWord( String word, int value ) {
        this( word, value, value );
    }

    /**
     * Constructs the word
     *
     * @param word the word
     * @param sizeValue the value for the size weighting, any positive integer
     * @param colorValue the value for the color weighting, any positive integer
     */
    public WeightedWord( String word, int sizeValue, int colorValue ) {
        this.word = word;
        this.sizeValue = sizeValue;
        this.colorValue = colorValue;
    }

    /**
     * Returns the String of the word
     *
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * Returns the value for the size
     *
     * @return the value for the size
     */
    public int getSizeValue() {
        return sizeValue;
    }

    /**
     * Returns the value for the color
     *
     * @return the value for the color
     */
    public int getColorValue() {
        return colorValue;
    }

}
