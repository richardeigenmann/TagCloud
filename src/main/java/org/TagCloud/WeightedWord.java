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
 *
 * @author Richard Eigenmann
 */
public class WeightedWord {

    private final String word;
    private final int sizeValue;
    private final int colorValue;

    /**
     * Constructs a word with the same value for the size and color
     * @param word the word
     * @param value the value
     */
    public WeightedWord( String word, int value ) {
        this( word, value, value);
    }

    /**
     * Constructs the word 
     * @param word the word
     * @param sizeValue the value for the size weighting
     * @param colorValue  the value for the color weighting
     */
    public WeightedWord( String word, int sizeValue, int colorValue) {
        this.word = word;
        this.sizeValue = sizeValue;
        this.colorValue = colorValue;
    }
    
    public String getWord() {
        return word;
    }
    
    public int getSizeValue() {
        return sizeValue;
    }
    
    public int getColorValue() {
        return colorValue;
    }
    
}
