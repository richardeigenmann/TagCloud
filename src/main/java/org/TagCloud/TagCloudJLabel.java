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
     * Defines a logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger( TagCloudJLabel.class.getName() );

    /**
     * The weight for the size 0..1
     */
    private float sizeWeight;
    /**
     * The weight for the color 0..1
     */
    private float colorWeight;
    /**
     * The font provider for the label
     */
    private FontProvider fontProvider;
    /**
     * The color provider for the label
     */
    private ColorProvider colorProvider;
    /**
     * The color to highlight the label in when moving the mouse over the label.
     */
    private Color mouseoverColor;

    /**
     * Constructs a Word Label with default styles and one weight
     *
     * @param word The word to show
     * @param weight The weight between 0 and 1 to show the weight of the word
     * used for both the weight of the font and the weight of the color
     */
    public TagCloudJLabel( String word, float weight ) {
        this( word, weight, weight );
    }

    

    /**
     * Constructs a Word Label with default styles with 2 weights
     *
     * @param word The word to show
     * @param sizeWeight The weight between 0 and 1 to determine the size of the
     * font
     * @param colorWeight The weight between 0 and 1 to determine the color of
     * the font
     */
    public TagCloudJLabel( String word, float sizeWeight, float colorWeight ) {
        this( word, sizeWeight, new SansSerifFontProvider(), colorWeight, new ShadesOfLightBlue(), new Color( 0x421ed9 ) );
    }

    /**
     * Constructs a Word Label
     *
     * @param word The word to show
     * @param sizeWeight The weight between 0 and 1 to determine the size of the
     * font
     * @param fontProvider The font provider that will return the font to use
     * @param colorWeight The weight between 0 and 1 to determine the color of
     * the font
     * @param colorProvider the color provider that will return the color to use
     * @param mouseoverColor the color to use in the mouseover
     */
    public TagCloudJLabel( String word, float sizeWeight, FontProvider fontProvider, float colorWeight, ColorProvider colorProvider, Color mouseoverColor ) {
        super( word );
        this.sizeWeight = verifyWeight( sizeWeight );
        this.colorWeight = verifyWeight( colorWeight );
        setFontProvider( fontProvider );
        setColorProvider( colorProvider );
        setMouseoverColor( mouseoverColor );

        addMouseListener( new MouseAdapter() {

            @Override
            public void mouseEntered( MouseEvent e ) {
                super.mouseEntered( e );
                setForeground( getMouseoverColor() );

            }

            @Override
            public void mouseExited( MouseEvent e ) {
                super.mouseExited( e );
                setForegroundColor();

            }
        } );
    }

    /**
     * Allows the Font provider to be set. Call validate after changing.
     *
     * @param fontProvider the new font provider.
     */
    public final void setFontProvider( FontProvider fontProvider ) {
        this.fontProvider = fontProvider;
        setFont();
    }

    /**
     * Sets the font based on the sizeWeight by querying the font provider.
     */
    private void setFont() {
        setFont( fontProvider.getFont( this.sizeWeight ) );
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
     *
     * @param mouseoverColor the color for the mouseover
     */
    public final void setMouseoverColor( Color mouseoverColor ) {
        this.mouseoverColor = mouseoverColor;
    }

    /**
     * Returns the color to use when the mouse moves over the word
     *
     * @return the color to use in a mouseover
     */
    public final Color getMouseoverColor() {
        return mouseoverColor;
    }

    /**
     * Sets the color provider for the label. Call validate() after changing.
     * Internally calls setForegroundColor().
     *
     * @param colorProvider the new color provider
     */
    public final void setColorProvider( ColorProvider colorProvider ) {
        this.colorProvider = colorProvider;
        setForegroundColor();
    }

    /**
     * Sets the foreground color according to the colorWeight by calling the
     * color provider's getColor method
     */
    private void setForegroundColor() {
        setForeground( colorProvider.getColor( colorWeight ) );
    }

}
