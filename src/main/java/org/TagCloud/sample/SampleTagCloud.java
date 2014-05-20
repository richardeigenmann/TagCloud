/*
 Copyright (C) 2009, 2014 Richard Eigenmann, Zürich, Switzerland

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
package org.TagCloud.sample;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import ColorProviders.BlackToWhiteGradient;
import org.TagCloud.FontProviders.HeavyFontProvider;
import ColorProviders.SampleGradientColors;
import org.TagCloud.FontProviders.SansSerifFontProvider;
import org.TagCloud.FontProviders.SerifFontProvider;
import ColorProviders.ShadesOfLightBlue;
import org.TagCloud.TagClickListener;
import org.TagCloud.TagCloud;
import org.TagCloud.WeightedWord;
import ColorProviders.YellowBrownGradient;
import ColorProviders.YellowOrBrown;
import javax.swing.BoxLayout;

/**
 * Shows how to generate a sample tag cloud
 *
 * @author Richard Eigenmann
 */
public class SampleTagCloud extends JFrame {

    /**
     * Let's have a logger
     */
    private static final Logger LOGGER = Logger.getLogger( SampleTagCloud.class.getName() );

    /**
     * Make this class directly executable.
     *
     * @param args Command line arguments
     */
    public static void main( String[] args ) {
        SwingUtilities.invokeLater( new Runnable() {

            @Override
            public void run() {
                new SampleTagCloud();
            }
        } );
    }

    /**
     * The TagCloud widget that we would like to show.
     */
    private final TagCloud tagCloud = new TagCloud();

    /**
     * Creates the JFrame, control widgets and TagCloud
     */
    public SampleTagCloud() {
        setPreferredSize( new Dimension( 600, 400 ) );
        setTitle( "Sample Tag Cloud" );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.getContentPane().add( getControlsPanel(), BorderLayout.PAGE_START );

        tagCloud.addTagClickListener( new TagClickListener() {

            @Override
            public void tagClicked( String word ) {
                doTagClicked( word );
            }
        } );
        this.getContentPane().add( tagCloud );

        pack();
        setVisible( true );
    }

    /**
     * Build the widgets to have some interaction on the screen
     *
     * @return Returns a panel with stuff
     */
    private JPanel getControlsPanel() {
        JPanel firstLinePanel = new JPanel();

        String[] wordLists = { "Cities", "European Cities", "Countries", "Short Cities List" };
        final JComboBox wordListChooser = new JComboBox( wordLists );
        wordListChooser.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed( ActionEvent e ) {
                int index = wordListChooser.getSelectedIndex();
                switch ( index ) {
                    case 0:
                        tagCloud.setWordsList( new Cities() );
                        tagCloud.showWords();
                        break;
                    case 1:
                        tagCloud.setWordsList( new EuropeanCities() );
                        tagCloud.showWords();
                        break;
                    case 2:
                        tagCloud.setWordsList( new Countries() );
                        tagCloud.showWords();
                        break;
                    case 3:
                        tagCloud.setWordsList( new ShortCitiesList() );
                        tagCloud.showWords();
                        break;
                    default:
                        tagCloud.setWordsList( new Cities() );
                        tagCloud.showWords();

                }
            }
        } );
        firstLinePanel.add( wordListChooser );
        wordListChooser.setSelectedIndex( 0 );

        String[] colorSchemes = { "Shades of Light Blue", "Sample Gradient Colors", "Black to White Gradient", "Yellow Brown Gradient", "Yellow or Brown" };
        final JComboBox colorSchemeChooser = new JComboBox( colorSchemes );
        colorSchemeChooser.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed( ActionEvent e ) {
                int index = colorSchemeChooser.getSelectedIndex();
                switch ( index ) {
                    case 0:
                        tagCloud.setColorProvider( new ShadesOfLightBlue() );
                        break;
                    case 1:
                        tagCloud.setColorProvider( new SampleGradientColors() );
                        break;
                    case 2:
                        tagCloud.setColorProvider( new BlackToWhiteGradient() );
                        break;
                    case 3:
                        tagCloud.setColorProvider( new YellowBrownGradient() );
                        break;
                    case 4:
                        tagCloud.setColorProvider( new YellowOrBrown() );
                        break;
                    default:
                        tagCloud.setColorProvider( new ShadesOfLightBlue() );
                        tagCloud.showWords();

                }
            }
        } );
        firstLinePanel.add( colorSchemeChooser );
        colorSchemeChooser.setSelectedIndex( 0 );

        String[] fontSchemes = { "Sans Serif", "Serif", "Heavy Font" };
        final JComboBox fontProviderChooser = new JComboBox( fontSchemes );
        fontProviderChooser.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed( ActionEvent e ) {
                int index = fontProviderChooser.getSelectedIndex();
                switch ( index ) {
                    case 0:
                        tagCloud.setFontProvider( new SansSerifFontProvider() );
                        break;
                    case 1:
                        tagCloud.setFontProvider( new SerifFontProvider() );
                        break;
                    case 2:
                        tagCloud.setFontProvider( new HeavyFontProvider() );
                        break;
                    default:
                        tagCloud.setFontProvider( new SansSerifFontProvider() );
                        tagCloud.showWords();

                }
            }
        } );
        firstLinePanel.add( fontProviderChooser );
        fontProviderChooser.setSelectedIndex( 0 );

        JSlider slider = new JSlider( 0, 100 ); // we will only use the slider for the percentage of total
        slider.setPreferredSize( new Dimension( 150, 20 ) );
        slider.addChangeListener( new MySliderChangeListener() );
        JPanel secondLinePanel = new JPanel();
        secondLinePanel.add( slider );
        secondLinePanel.add( commentLabel );

        JPanel controlsPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout( controlsPanel, BoxLayout.Y_AXIS );
        controlsPanel.setLayout( boxLayout );
        controlsPanel.add( firstLinePanel );
        controlsPanel.add( secondLinePanel );

        return controlsPanel;
    }

    /**
     * A label that we can use to show what is happening.
     */
    private final JLabel commentLabel = new JLabel( "Try out the controls!" );

    /**
     * handles the click on a word
     *
     * @param key The string that the user clicked on
     */
    public void doTagClicked( String key ) {
        List<WeightedWord> weightedWords = tagCloud.getWordsList();
        for ( WeightedWord weightedWord : weightedWords ) {
            if ( key.equals( weightedWord.getWord() ) ) {
                int population = weightedWord.getSizeValue();
                commentLabel.setText( String.format( "Clicked: %s; Population: %,d", key, population ) );
                break;
            }
        }
    }

    /**
     * Listener for the slider which limits the number of words to be shown
     */
    private class MySliderChangeListener
            implements ChangeListener {

        int minimumWords = 10;

        /**
         * Receive slider moves and using an exponential formula to adjust the
         * number of words being shown.
         *
         * @param changeEvent The event
         */
        @Override
        public void stateChanged( ChangeEvent changeEvent ) {
            final JSlider slider = (JSlider) changeEvent.getSource();
            final int value = slider.getValue();
            double pct = (double) value / slider.getMaximum();

            List<WeightedWord> weightedWords = tagCloud.getWordsList();
            if ( weightedWords == null ) {
                return;
            }
            int availableWords = tagCloud.getWordsList().size();
            int numberOfWords = (int) ( pct * ( availableWords - minimumWords ) ) + minimumWords;
            commentLabel.setText( String.format( "Slider set to %d%%; showing %d words", (int) ( pct * 100f ), numberOfWords ) );
            tagCloud.setMaxWordsToShow( numberOfWords );
            tagCloud.showWords();
        }
    }

}
