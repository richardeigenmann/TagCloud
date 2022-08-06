package org.tagcloud;

import org.tagcloud.colorproviders.ShadesOfLightBlue;
import org.tagcloud.fontproviders.SansSerifFontProvider;
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
     * The weighted word for which we are building a label
     */
    private final WeightedWordInterface weightedWord;
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
     * Constructs a Word Label with default styles
     *
     * @param word The word to show
     */
    public TagCloudJLabel( WeightedWordInterface word ) {
        this( word, new SansSerifFontProvider(), new ShadesOfLightBlue(), new Color( 0x421ed9 ) );
    }

    /**
     * Constructs a Word Label
     *
     * @param word The word to show
     * @param fontProvider The font provider that will return the font to use
     * @param colorProvider the color provider that will return the color to use
     * @param mouseoverColor the color to use in the mouseover
     */
    public TagCloudJLabel( final WeightedWordInterface word, final FontProvider fontProvider, final ColorProvider colorProvider, final Color mouseoverColor ) {
        super( word.getWord() );
        this.weightedWord = word;
        setFontProvider( fontProvider );
        setColorProvider( colorProvider );
        setMouseoverColor( mouseoverColor );

        addMouseListener( new MouseAdapter() {

            @Override
            public void mouseEntered( final MouseEvent e ) {
                super.mouseEntered( e );
                setForeground( getMouseoverColor() );

            }

            @Override
            public void mouseExited( final MouseEvent e ) {
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
    public final void setFontProvider( final FontProvider fontProvider ) {
        this.fontProvider = fontProvider;
        setFont();
    }

    /**
     * Sets the font based on the sizeWeight by querying the font provider.
     */
    private void setFont() {
        setFont( fontProvider.getFont( weightedWord.getSizeWeight(), weightedWord.getSizeValue() ) );
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
        setForeground( colorProvider.getColor( weightedWord.getColorWeight(), weightedWord.getColorValue() ) );
    }
    
    /**
     * Returns the WeightedWord for the Label
     * @return the weighted word
     */
    public WeightedWordInterface getWeightedWord() {
        return weightedWord;
    }

}
