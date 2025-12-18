/*
 Copyright (C) 2009, 2025 Richard Eigenmann, Zurich, Switzerland

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

import org.tagcloud.*;
import org.tagcloud.colorproviders.*;
import org.tagcloud.fontproviders.HeavyFontProvider;
import org.tagcloud.fontproviders.SansSerifFontProvider;
import org.tagcloud.fontproviders.SerifFontProvider;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.List;

/**
 * Sample GUI to demonstrate the use of the tag cloud
 *
 * @author Richard Eigenmann
 */
public class SampleTagCloud extends JFrame {

    /**
     * Main entry point of this Swing GUI application
     */
    static void main() {
        SwingUtilities.invokeLater(SampleTagCloud::new);
    }

    /**
     * The TagCloud widget that we would like to show.
     */
    private final TagCloud tagCloud = new TagCloud();

    /**
     * Creates a JFrame, control widgets and TagCloud
     */
    public SampleTagCloud() {
        this.setPreferredSize( new Dimension( 600, 400 ) );
        this.setTitle( "Sample Tag Cloud" );
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.getContentPane().add( getControlsPanel(), BorderLayout.PAGE_START );

        this.tagCloud.addTagClickListener(this::doTagClicked);
        this.getContentPane().add( tagCloud );

        pack();
        setVisible( true );
    }

    private final JComboBox<String> wordListChooser  =
        new JComboBox<>(
            new String[]{
                "Cities by population",
                "European Cities by population",
                "Countries by population",
                "Short Cities List by population",
                "Famous People by height and BMI"
            }
        );

    /**
     * Build the widgets to have some interaction on the screen
     *
     * @return Returns a panel with stuff
     */
    private JPanel getControlsPanel() {
        final var firstLinePanel = new JPanel();

        wordListChooser.addActionListener(e -> {
            int index = wordListChooser.getSelectedIndex();
            switch ( index ) {
                case 1:
                    tagCloud.setWordsList( EuropeanCities.getCitiesAsWeightedWords() );
                    break;
                case 2:
                    tagCloud.setWordsList( Countries.getCountriesAsWeightedWords() );
                    break;
                case 3:
                    tagCloud.setWordsList( ShortCitiesList.getCitiesAsWeightedWords() );
                    break;
                case 4:
                    tagCloud.setWordsList( FamousPeople.getPeopleAsWeightedWords() );
                    break;
                case 0:
                default:
                    tagCloud.setWordsList( LargeCities.getCitiesAsWeightedWords() );

            }
        });
        firstLinePanel.add( wordListChooser );


        final JComboBox<String> colorSchemeChooser = new JComboBox<>( new String[]{ "Shades of Light Blue", "Sample Gradient Colors", "Black to White Gradient", "Yellow Brown Gradient", "Yellow or Brown", "Body Mass Index" } );
        colorSchemeChooser.addActionListener(e -> {
            int index = colorSchemeChooser.getSelectedIndex();
            switch ( index ) {
                case 1:
                    tagCloud.setColorMapper( new ColorValueMapper( new SampleGradientColors()) );
                    break;
                case 2:
                    tagCloud.setColorMapper( new ColorValueMapper( new BlackToWhiteGradient()) );
                    break;
                case 3:
                    tagCloud.setColorMapper( new ColorValueMapper( new YellowBrownGradient()) );
                    break;
                case 4:
                    tagCloud.setColorMapper( new ColorValueMapper( new YellowOrBrown() ) );
                    break;
                case 5:
                    tagCloud.setColorMapper( new BMIValueMapper() );
                    break;
                case 0:
                default:
                    tagCloud.setColorMapper( new ColorValueMapper( new ShadesOfLightBlue() ) );

            }
        });
        firstLinePanel.add( colorSchemeChooser );
        colorSchemeChooser.setSelectedIndex( 0 );

        final JComboBox<String> fontProviderChooser = new JComboBox<>( new String[]{ "Sans Serif", "Serif", "Heavy Font" } );
        fontProviderChooser.addActionListener(e -> {
            int index = fontProviderChooser.getSelectedIndex();
            switch ( index ) {
                case 1:
                    tagCloud.setFontMapper( new FontMapper(new SerifFontProvider() ));
                    break;
                case 2:
                    tagCloud.setFontMapper( new FontMapper(new HeavyFontProvider() ));
                    break;
                case 0:
                default:
                    tagCloud.setFontMapper( new FontMapper(new SansSerifFontProvider() ));
            }
        });
        firstLinePanel.add( fontProviderChooser );
        fontProviderChooser.setSelectedIndex( 0 );
        wordListChooser.setSelectedIndex( 0 );

        final var slider = new JSlider( 0, 100 ); // we will only use the slider for the percentage of total
        slider.setPreferredSize( new Dimension( 150, 20 ) );
        slider.addChangeListener( new MySliderChangeListener() );

        final var secondLinePanel = new JPanel();
        secondLinePanel.add( slider );
        secondLinePanel.add( commentLabel );

        final var controlsPanel = new JPanel();
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
            comment = String.format( "%s, Population: %f", weightedWord.getWord(),
                    weightedWord.getFontSizeValue() );
        } else {
            comment = String.format( "%s; Height: %f, BMI: %f",
                    weightedWord.getWord(),
                    weightedWord.getFontSizeValue(),
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

        static final int MINIMUM_WORDS = 10;

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

            List<? extends WeightedWordInterface> weightedWords = tagCloud.getWordsList();
            if ( weightedWords == null ) {
                return;
            }
            int availableWords = tagCloud.getWordsList().size();
            int numberOfWords = (int) ( pct * ( availableWords - MINIMUM_WORDS) ) + MINIMUM_WORDS;
            commentLabel.setText( String.format( "Slider is %d%%; showing %d words", (int) ( pct * 100f ), numberOfWords ) );
            tagCloud.setMaxWordsToShow( numberOfWords );
        }
    }

}
