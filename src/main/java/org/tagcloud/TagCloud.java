/*
 TagCloud.java:  A Swing Component that shows a TagCloud

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
package org.tagcloud;

import org.tagcloud.colorproviders.ShadesOfLightBlue;
import org.tagcloud.fontproviders.SansSerifFontProvider;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import javax.swing.JScrollPane;

/**
 * A controller that constructs the TagCloud of Labels and handles mouse clicks,
 * sending them on to TagClickListeners.
 *
 * @author Richard Eigenmann
 */
public class TagCloud extends JScrollPane {

    /**
     * Defines a logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger( TagCloud.class.getName() );

    /**
     * This special panel holds the words (TagCloudJLabel).
     */
    private final VerticalGrowJPanel verticalGrowJPanel;

    /**
     * Constructor to call to create a new TagCloud. It used BorderLayout and
     * puts the Slider in the top part and the scroll pane in the centre part.
     */
    public TagCloud() {
        verticalGrowJPanel = new VerticalGrowJPanel();
        setViewportView( verticalGrowJPanel );
        setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );
    }

    /**
     * The number of words to show. The default is 30 words.
     */
    private int wordsToShow = 30;

    /**
     * Sets the maximum number of words to show. The number is validated and set
     * to be 1 or higher. Call showWords afterwards to update the tags being
     * shown.
     *
     * @param wordsToShow the number of words to show in the range
     * 1..Integer.MAX_VALUE.
     */
    public void setMaxWordsToShow( int wordsToShow ) {
        // never trust inputs
        if ( wordsToShow < 1 ) {
            LOGGER.finest( String.format( "wordsToShow was %d which is less than 1; setting to 1.", wordsToShow ) );
            wordsToShow = 1;
        }
        this.wordsToShow = wordsToShow;
        showWords();
    }

    /**
     * The list of weighted words being shown
     */
    private List<WeightedWordInterface> weightedWords = null;

    private WordAnalyser wordAnalyser;

    /**
     * This method receives the WeightedWordInterface list of the words to be shown in
     * the TagCloud and puts them on the container removing any that might have
     * been there before.
     *
     * @param weightedWords The WeightedWord of the words to be shown.
     */
    public void setWordsList( List<WeightedWordInterface> weightedWords ) {
        this.weightedWords = weightedWords;
        wordAnalyser = new WordAnalyser( this.weightedWords );
        // initialise the weights
        for ( WeightedWordInterface weightedWord : this.weightedWords ) {
            weightedWord.setSizeWeight( wordAnalyser.getSizeWeight( weightedWord.getSizeValue() ) );
            weightedWord.setColorWeight( wordAnalyser.getColorWeight( weightedWord.getColorValue() ) );
        }

        showWords();
    }

    /**
     * Runs off an creates the labels for the wordsToShow number of words.
     * Removes all previous labels and adds the labels for the supplied map.
     * Adds the MouseListener to the labels.
     */
    private void showWords() {
        verticalGrowJPanel.removeAll();
        if ( weightedWords != null ) { // if no wordMap, leave panel empty

            List<WeightedWordInterface> topWords = wordAnalyser.getTopWordsSizeWeighted( wordsToShow );

            for ( WeightedWordInterface weightedWord : topWords ) {
                TagCloudJLabel tagCloudEntry = new TagCloudJLabel(
                        weightedWord,
                        fontProvider,
                        colorProvider,
                        mouseOverColor
                );
                tagCloudEntry.addMouseListener( wordClickListener );
                verticalGrowJPanel.add( tagCloudEntry );
            }
        }
        // After hours of frustration it turns out we need to validate the panel and the scrollpane.
        verticalGrowJPanel.validate();
        validate();
        repaint();
    }

    /**
     * This method returns the WeightedWords List shown in the TagCloud.
     *
     * @return weightedWords The WeightedWord of the words to be shown.
     */
    public List<WeightedWordInterface> getWordsList() {
        return weightedWords;
    }

    private ColorProvider colorProvider = new ShadesOfLightBlue();

    private FontProvider fontProvider = new SansSerifFontProvider();

    private Color mouseOverColor = new Color( 0x421ed9 );

    /**
     * Sets the color to use on a mouseover event
     *
     * @param mouseOverColor the color to use on a mouseOverEvent
     */
    public void setMouseOverColor( Color mouseOverColor ) {
        this.mouseOverColor = mouseOverColor;
    }

    /**
     * Sets the color Provider of the tagCloudJLabels
     *
     * @param colorProvider The colorProvider to use
     */
    public void setColorProvider( ColorProvider colorProvider ) {
        this.colorProvider = colorProvider;
        for ( Component component : verticalGrowJPanel.getComponents() ) {
            if ( component instanceof TagCloudJLabel ) {
                ( (TagCloudJLabel) component ).setColorProvider( colorProvider );
            }
        }
    }

    /**
     * Sets the font Provider of the tagCloudJLabels
     *
     * @param fontProvider The FontProvider to use
     */
    public void setFontProvider( FontProvider fontProvider ) {
        this.fontProvider = fontProvider;
        for ( Component component : verticalGrowJPanel.getComponents() ) {
            if ( component instanceof TagCloudJLabel ) {
                ( (TagCloudJLabel) component ).setFontProvider( fontProvider );
                //component.validate();
            }
        }
        verticalGrowJPanel.validate();
    }

    /**
     * A click listener that fires off the tagClicked event to the
     * tagClickListener when a click is registered on a word label.
     */
    private final transient MouseAdapter wordClickListener = new MouseAdapter() {

        @Override
        public void mouseClicked( MouseEvent e ) {
            TagCloudJLabel tagCloudJLabel = (TagCloudJLabel) e.getComponent();
            notifyTagClickListeners( tagCloudJLabel.getWeightedWord() );
        }
    };

    /**
     * Notifies the listeners that a tag was clicked
     *
     * @param weightedWord the tag that was clicked
     */
    private void notifyTagClickListeners( WeightedWordInterface weightedWord ) {
        synchronized ( tagClickListeners ) {
            for ( TagClickListener tagClickListener : tagClickListeners ) {
                tagClickListener.tagClicked( weightedWord );
            }
        }
    }

    /**
     * The TagClickListeners that want to be notified when the user clicks on a
     * Tag.
     */
    private final Set<TagClickListener> tagClickListeners = Collections.synchronizedSet(new HashSet<>() );

    /**
     * Register a TagClickListener to receive the word a user clicked on.
     *
     * @param listener The listener that will be registered
     */
    public void addTagClickListener( TagClickListener listener ) {
        tagClickListeners.add( listener );
    }

    /**
     * Remove the specified TagClickListener.
     *
     * @param listener	The listener to deregister
     */
    public void removeTagClickListener( TagClickListener listener ) {
        tagClickListeners.remove( listener );
    }
}
