/*
 TagCloud.java:  A Swing Component that shows a TagCloud

 Copyright (C) 2009-2025  Richard Eigenmann.
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
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.swing.JScrollPane;

import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.teeing;

/**
 * A controller that constructs the TagCloud of Labels and handles mouse clicks,
 * sending them on to TagClickListeners.
 *
 * @author Richard Eigenmann
 */
public class TagCloud extends JScrollPane {


    /**
     * This special panel holds the words (TagCloudJLabel).
     */
    private final VerticalGrowJPanel verticalGrowJPanel;

    /**
     * Constructor to call to create a new TagCloud. It usesBorderLayout and
     * puts the Slider in the top part and the scroll pane in the center part.
     */
    public TagCloud() {
        verticalGrowJPanel = new VerticalGrowJPanel();
        setViewportView( verticalGrowJPanel );
        setHorizontalScrollBarPolicy( HORIZONTAL_SCROLLBAR_AS_NEEDED );
        setVerticalScrollBarPolicy( VERTICAL_SCROLLBAR_AS_NEEDED );
    }

    /**
     * The list of weighted words being shown
     */
    private List<? extends WeightedWordInterface> weightedWords = null;


    /**
     * This method receives the WeightedWordInterface list of the words to be shown in
     * the TagCloud and puts them on the container removing any that might have
     * been there before.
     *
     * @param weightedWords The WeightedWord of the words to be shown.
     */
    public void setWordsList( final List<? extends WeightedWordInterface> weightedWords ) {
        this.weightedWords = weightedWords;
        identifyValueRanges(weightedWords, fontMapper, colorMapper);
        showWords();
    }

    public static void identifyValueRanges(final List<? extends WeightedWordInterface> weightedWords,FontMapper fontMapper, ColorMapper colorMapper ) {
        var result = weightedWords.stream().collect(
                teeing(
                        // First branch: Length stats
                        summarizingDouble(WeightedWordInterface::getFontSizeValue),
                        // Second branch: Height stats
                        summarizingDouble(WeightedWordInterface::getColorValue),
                        // Merger: Combine them into a custom container or Map
                        (fontSizeStats, colorValueStats) -> Map.of(
                                "minFontSizeValue", fontSizeStats.getMin(),
                                "maxFontSizeValue", fontSizeStats.getMax(),
                                "minColorValue", colorValueStats.getMin(),
                                "maxColorValue", colorValueStats.getMax()
                        )
                )
        );

        fontMapper.setMinimumValue(result.get("minFontSizeValue"));
        fontMapper.setMaximumValue(result.get("maxFontSizeValue"));
        colorMapper.setMinimumValue(result.get("minColorValue"));
        colorMapper.setMaximumValue(result.get("maxColorValue"));
    }

    /**
     * Runs off and creates the labels for the wordsToShow number of words.
     * Removes all previous labels and adds the labels for the supplied map.
     * Adds the MouseListener to the labels.
     */
    public void showWords() {
        verticalGrowJPanel.removeAll();
        if ( weightedWords != null ) { // if no wordMap, leave panel empty
            for ( final var weightedWord: weightedWords ) {
                final var tagCloudEntry = new TagCloudJLabel(
                        weightedWord,
                        fontMapper,
                        colorMapper,
                        mouseOverColor
                );
                tagCloudEntry.addMouseListener( wordClickListener );
                verticalGrowJPanel.add( tagCloudEntry );
            }
        }
        verticalGrowJPanel.validate();
        validate();
        repaint();
    }

    private ColorMapper colorMapper = new ColorValueMapper( new ShadesOfLightBlue() );

    private FontMapper fontMapper = new FontMapper(new SansSerifFontProvider());

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
     * @param colorMapper The colorMapper to use
     */
    public void setColorMapper( final ColorMapper colorMapper ) {
        this.colorMapper = colorMapper;
        for ( Component component : verticalGrowJPanel.getComponents() ) {
            if ( component instanceof TagCloudJLabel tagCloudJLabel) {
                tagCloudJLabel.setColorMapper( colorMapper );
            }
        }
    }

    /**
     * Sets the font Provider of the tagCloudJLabels
     *
     * @param fontMapper The FontProvider to use
     */
    public void setFontMapper(final FontMapper fontMapper) {
        this.fontMapper = fontMapper;
        for ( Component component : verticalGrowJPanel.getComponents() ) {
            if ( component instanceof TagCloudJLabel tagCloudJLabel ) {
                tagCloudJLabel.setFontMapper(fontMapper);
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
            final var tagCloudJLabel = (TagCloudJLabel) e.getComponent();
            final var weightedWord = tagCloudJLabel.getWeightedWord();
            for ( final var tagClickListener : tagClickListeners ) {
                tagClickListener.tagClicked(weightedWord);
            }
        }
    };

    /**
     * The TagClickListeners that want to be notified when the user clicks on a
     * Tag.
     */
    private final Set<TagClickListener> tagClickListeners = new CopyOnWriteArraySet<>();

    /**
     * Register a TagClickListener to receive the word a user clicked on.
     *
     * @param listener The listener that will be registered
     */
    public void addTagClickListener( final TagClickListener listener ) {
        tagClickListeners.add( listener );
    }

    /**
     * Remove the specified TagClickListener.
     *
     * @param listener	The listener to deregister
     */
    public void removeTagClickListener( final TagClickListener listener ) {
        tagClickListeners.remove( listener );
    }
}
