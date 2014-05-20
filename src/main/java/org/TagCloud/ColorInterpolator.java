/*
 ColorInterpolator.java:  This abstract class can interpolate a color from a set of color points based on weight 0 to 1.

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

import java.awt.Color;

/**
 * This abstract class can interpolate a color from a set of color points based
 * on weight 0 to 1. Extending classed must provide an array with the colors to
 * use in the getColorPoints method.
 *
 * @author Richard Eigenmann
 */
public abstract class ColorInterpolator implements ColorProvider {

    /*
     * Let's have a logger
     *
     *private static final Logger LOGGER = Logger.getLogger( ColorInterpolator.class.getName() );
     */
    
    /**
     * The extending class must implement this method and provide an array of
     * colors
     *
     * @return The array of colors between which to interpolate
     */
    public abstract Color[] getColorPoints();

    /**
     * This method returns a color along a multi point color gradiant. The
     * Gradiant color points are specified by an array of Colors. The Array must
     * have at least 2 color entries. The interpolation uses the weight parameter.
     *
     * @param weight between 0 and 1
     * @param value ignored
     * @return The Color in the gradient
     */
    @Override
    public Color getColor( float weight, int value ) {
        // figure out the closest two color points
        int lowerIndex = (int) Math.round( weight * ( getColorPoints().length - 2 ) );
        int higherIndex = lowerIndex + 1;
        Color lowerColor = getColorPoints()[lowerIndex];
        Color higherColor = getColorPoints()[higherIndex];

        double lowerIndexFactor = (double) lowerIndex / ( getColorPoints().length - 1 );
        double higherIndexFactor = (double) higherIndex / ( getColorPoints().length - 1 );
        double interpolationFactor = ( weight - lowerIndexFactor ) / ( higherIndexFactor - lowerIndexFactor );
        double pctOfColorDelta = weight - lowerIndexFactor;

        //LOGGER.info(String.format("Lower Index: %d Factor: %f ", lowerIndex, lowerIndexFactor));
        //LOGGER.info(String.format("Higher Index: %d Factor: %f ", higherIndex, higherIndexFactor));
        //LOGGER.info(String.format("pctOfColorDelta: %f ", pctOfColorDelta));
        int r1 = lowerColor.getRed();
        int r2 = higherColor.getRed();
        int newRed = r1 + (int) ( ( r2 - r1 ) * pctOfColorDelta );
        //LOGGER.fine(String.format("Red: lower= %d higher= %d new=%d", r1, r2, newRed));
        int g1 = lowerColor.getGreen();
        int g2 = higherColor.getGreen();
        int newGreen = g1 + (int) ( ( g2 - g1 ) * pctOfColorDelta );
        //LOGGER.fine(String.format("Red: lower= %d higher= %d new=%d", g1, g2, newGreen));
        int b1 = lowerColor.getBlue();
        int b2 = higherColor.getBlue();
        int newBlue = b1 + (int) ( ( b2 - b1 ) * pctOfColorDelta );
        //LOGGER.info( String.format( "Red: lower= %d higher= %d new=%d", b1, b2, newBlue ) );
        Color gradientColor = new Color( newRed, newGreen, newBlue );

        return gradientColor;
    }
}
