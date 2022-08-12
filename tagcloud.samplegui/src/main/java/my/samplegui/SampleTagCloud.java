/*
 Copyright (C) 2009, 2019 Richard Eigenmann, Zurich, Switzerland

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
package my.samplegui;

import org.tagcloud.TagCloud;
import org.tagcloud.WeightedWordInterface;
import org.tagcloud.colorproviders.*;
import org.tagcloud.fontproviders.HeavyFontProvider;
import org.tagcloud.fontproviders.SansSerifFontProvider;
import org.tagcloud.fontproviders.SerifFontProvider;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.List;
import java.util.logging.Logger;

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
        SwingUtilities.invokeLater(SampleTagCloud::new);
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

        tagCloud.addTagClickListener(this::doTagClicked);
        this.getContentPane().add( tagCloud );

        pack();
        setVisible( true );
    }

    private final JComboBox<String> wordListChooser  = new JComboBox<>(new String[]{"Cities", "European Cities", "Countries", "Short Cities List", "People"});

    /**
     * Build the widgets to have some interaction on the screen
     *
     * @return Returns a panel with stuff
     */
    private JPanel getControlsPanel() {
        JPanel firstLinePanel = new JPanel();

        wordListChooser.addActionListener(e -> {
            int index = wordListChooser.getSelectedIndex();
            switch ( index ) {
                case 1:
                    tagCloud.setWordsList( new EuropeanCities() );
                    break;
                case 2:
                    tagCloud.setWordsList( new Countries() );
                    break;
                case 3:
                    tagCloud.setWordsList( new ShortCitiesList() );
                    break;
                case 4:
                    tagCloud.setWordsList( new People() );
                    break;
                case 0:
                default:
                    tagCloud.setWordsList( new Cities() );

            }
        });
        firstLinePanel.add( wordListChooser );
        wordListChooser.setSelectedIndex( 0 );

        final JComboBox<String> colorSchemeChooser = new JComboBox<>( new String[]{ "Shades of Light Blue", "Sample Gradient Colors", "Black to White Gradient", "Yellow Brown Gradient", "Yellow or Brown", "Body Mass Index" } );
        colorSchemeChooser.addActionListener(e -> {
            int index = colorSchemeChooser.getSelectedIndex();
            switch ( index ) {
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
                case 5:
                    tagCloud.setColorProvider( new BMIColorProvider() );
                    break;
                case 0:
                default:
                    tagCloud.setColorProvider( new ShadesOfLightBlue() );

            }
        });
        firstLinePanel.add( colorSchemeChooser );
        colorSchemeChooser.setSelectedIndex( 0 );

        final JComboBox<String> fontProviderChooser = new JComboBox<>( new String[]{ "Sans Serif", "Serif", "Heavy Font" } );
        fontProviderChooser.addActionListener(e -> {
            int index = fontProviderChooser.getSelectedIndex();
            switch ( index ) {
                case 1:
                    tagCloud.setFontProvider( new SerifFontProvider() );
                    break;
                case 2:
                    tagCloud.setFontProvider( new HeavyFontProvider() );
                    break;
                case 0:
                default:
                    tagCloud.setFontProvider( new SansSerifFontProvider() );
            }
        });
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
     * @param weightedWord The string that the user clicked on
     */
    public void doTagClicked( WeightedWordInterface weightedWord ) {
        String comment;
        if ( wordListChooser.getSelectedIndex() != 4 ) {
            comment = String.format( "%s, Population: %d", weightedWord.getWord(),
                    weightedWord.getSizeValue() );
        } else {
            comment = String.format( "%s; Height: %d, BMI: %d",
                    weightedWord.getWord(),
                    weightedWord.getSizeValue(),
                    weightedWord.getColorValue()
            );
        }
        commentLabel.setText( comment );
    }

    /**
     * Listener for the slider which limits the number of words to be shown
     */
    private class MySliderChangeListener
            implements ChangeListener {

        final int minimumWords = 10;

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

            List<WeightedWordInterface> weightedWords = tagCloud.getWordsList();
            if ( weightedWords == null ) {
                return;
            }
            int availableWords = tagCloud.getWordsList().size();
            int numberOfWords = (int) ( pct * ( availableWords - minimumWords ) ) + minimumWords;
            commentLabel.setText( String.format( "Slider is %d%%; showing %d words", (int) ( pct * 100f ), numberOfWords ) );
            tagCloud.setMaxWordsToShow( numberOfWords );
        }
    }

}
