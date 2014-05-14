package org.TagCloud;

import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.util.logging.Logger;
import javax.swing.JLabel;

/*
 TagCloudJLabel.java:  A widget that shows a word in a Tag Cloud

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
/**
 * A JLabel that shows a word (in a Tag Cloud) with a color that changes
 * depending on a percentage and a size that increases with a percentage. It
 * also highlights the term in a different color if the mouse moves over the
 * label.
 *
 * @author Richard Eigenmann
 */
public class TagCloudJLabel extends JLabel {


    /**
     * I have chosen a the GradientColor.SHADES_OF_LIGHT_BLUE colors for this
     * component.
     */
    private static final Color[] gradientColor = GradientColor.SHADES_OF_LIGHT_BLUE;

    /**
     * The color to highlight the label in when moving the mouse over the label.
     */
    private Color mouseoverColor;

    /**
     * Defines a logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger( TagCloudJLabel.class.getName() );

    /**
     * Constructs a Word Label
     *
     * @param word The word to show
     * @param weight The weight between 0 and 1 to show the weight of the word
     */
    public TagCloudJLabel( String word, float weight ) {
        this( word, weight, weight );
    }

    private float sizeWeight;
    private float colorWeight;
    private FontProvider fontProvider;
    private ColorProvider colorProvider;

    /**
     * Constructs a Word Label
     *
     * @param word The word to show
     * @param sizeWeight The weight between 0 and 1 to determine the size of the
     * font
     * @param colorWeight The weight between 0 and 1 to determine the color of
     * the font
     */
    public TagCloudJLabel( String word, float sizeWeight, float colorWeight ) {
        super( word );
        this.sizeWeight = verifyWeight( sizeWeight );
        this.colorWeight = verifyWeight( colorWeight );
        setFontProvider( new SansSerifFontProvider() );
        setColorGradient( new GradientColor() );
        setMouseoverColor(  new Color( 0x421ed9 ) );
        
        LOGGER.finest( String.format( "Formatting word: \"%s\" sizeWeight: %f colorWeight %f", word, sizeWeight, colorWeight ) );

        final float finalColorWeight = this.colorWeight;

        setFont( fontProvider.getFont( this.sizeWeight ) );
        setForeground( colorProvider.getColor( finalColorWeight ) );
        addMouseListener( new MouseAdapter() {

            @Override
            public void mouseEntered( MouseEvent e ) {
                super.mouseEntered( e );
                setForeground( mouseoverColor );

            }

            @Override
            public void mouseExited( MouseEvent e ) {
                super.mouseExited( e );
                setForeground( colorProvider.getColor( finalColorWeight ) );

            }
        } );
    }
    
    public final void setFontProvider ( FontProvider fontProvider ) {
        this.fontProvider = fontProvider;
    }

    /**
     * Ensures that a weight value is between 0 and 1. Lower values are set to
     * 0, higher values are set to 1
     *
     * @param weight The weight to be validated
     * @return the weight or 0 or 1 whatever is nearer
     */
    private static float verifyWeight( float weight ) {
        if ( weight > 1f ) {
            return 1;
        }
        if ( weight < 0f ) {
            return 0;
        }
        return weight;
    }

    /**
     * Returns the weight 0..1 for the label size
     *
     * @return the weight for the size between 0 and 1
     */
    public float getSizeWeight() {
        return sizeWeight;
    }

    /**
     * Returns the weight 0..1 for the label color
     *
     * @return the weight for the color between 0 and 1
     */
    public float getColorWeight() {
        return colorWeight;
    }
    
    /**
     * Sets the color to use when the mouse moves over the word
     * @param mouseoverColor the color for the mouseover
     */
    public final void setMouseoverColor( Color mouseoverColor ) {
        this.mouseoverColor = mouseoverColor;
    }

    public final void setColorGradient( ColorProvider colorGradient) {
        this.colorProvider = colorGradient;
    }
    
}
