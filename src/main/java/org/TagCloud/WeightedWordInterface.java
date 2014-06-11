/*
 WeightedWordInterface.java:  The interface that the words must conform to

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

/**
 * The interface that the words must conform to
 *
 * @author Richard Eigenmann
 */
public interface WeightedWordInterface {

    /**
     * Returns the value for the size
     *
     * @return the value for the size
     */
    public int getSizeValue();

    /**
     * Returns the String of the word
     *
     * @return the word
     */
    public String getWord();

    /**
     * Returns the value for the color
     *
     * @return the value for the color
     */
    public int getColorValue();

    /**
     * Sets the sizeWeight
     *
     * @param sizeWeight the new sizeWeight
     */
    public void setSizeWeight( float sizeWeight );

    /**
     * Returns the sizeWeight
     *
     * @return the sizeWeight
     */
    public float getSizeWeight();

    /**
     * Sets the colorWeight
     *
     * @param colorWeight the new sizeWeight
     */
    public void setColorWeight( float colorWeight );

    /**
     * Returns the colorWeight
     *
     * @return the colorWeight
     */
    public float getColorWeight();

}
