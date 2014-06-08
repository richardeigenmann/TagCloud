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
package org.TagCloud.Sample;

import java.util.ArrayList;
import org.TagCloud.WeightedWord;

/**
 * This class creates a list of People with their height and BMI.
 *
 * @author Richard Eigenmann
 */
public class People extends ArrayList<WeightedWord> {

    /**
     * Short list of cities
     */
    public People() {
        // http://europeanhistory.about.com/od/bonapartenapoleon/a/napoleonheight.htm
        // http://deadliestwarrior.wikia.com/wiki/Napoleon_Bonaparte
        add( new WeightedWord( "Napolen Bonaparte", 170, bmi( 1.70f, 63.5f ) ) );
        // http://rogerjnorton.com/Lincoln92.html
        add( new WeightedWord( "Abraham Lincoln", 193, bmi ( 1.93f, 81.6f) ) );
        // https://answers.yahoo.com/question/index?qid=20060805203846AAa41YB 
        add( new WeightedWord( "Michael Moore", 182, bmi ( 1.82f, 154.2f) ) );
        // http://en.wikipedia.org/wiki/Claudia_Schiffer
        add( new WeightedWord( "Claudia Schiffer", 181, bmi ( 1.81f, 58.7f) ) );
        // http://en.wikipedia.org/wiki/Vladimir_Putin
        // http://hollywoodmeasurements.com/vladimir-putin-height-weight-body-fat-percentage/
        add( new WeightedWord( "Vladimir Putin", 170, bmi ( 1.70f, 75f) ) );
        // http://hollywoodmeasurements.com/michael-jackson-height-weight-body-fat-percentage/
        add( new WeightedWord( "Michael Jackson", 175, bmi ( 1.75f, 64f) ) );
        // http://hollywoodmeasurements.com/snoop-dogg-height-weight-age-body-fat-percentage/
        add( new WeightedWord( "Snoop Dogg", 193, bmi ( 1.93f, 80f) ) );
        // http://hollywoodmeasurements.com/miley-cyrus-height-weight-bra-size-age-measurements/
        add( new WeightedWord( "Miley Cyrus", 165, bmi ( 1.65f, 52f) ) );
        // http://hollywoodmeasurements.com/keanu-reeves-height-weight-body-fat-percentage/
        add( new WeightedWord( "Keanu Reeves", 185, bmi ( 1.85f, 79f) ) );
        // http://hollywoodmeasurements.com/larry-page-height-weight-body-fat-percentage/
        add( new WeightedWord( "Larry Page", 180, bmi ( 1.80f, 81f) ) );
        // http://hollywoodmeasurements.com/quentin-tarantino-height-weight-body-fat-percentage/
        add( new WeightedWord( "Quentin Tarantino", 185, bmi ( 1.85f, 92f) ) );
        // http://hollywoodmeasurements.com/steve-jobs-height-weight-body-fat-percentage/
        add( new WeightedWord( "Steve Jobs", 188, bmi ( 1.88f, 70f) ) );
        // http://hollywoodmeasurements.com/warren-buffett-height-weight-body-fat-percentage/
        add( new WeightedWord( "Warren Buffet", 178, bmi ( 1.78f, 86f) ) );
        // http://hollywoodmeasurements.com/donald-trump-height-weight-body-fat-percentage/
        add( new WeightedWord( "Donald Trump", 188, bmi ( 1.88f, 95f) ) );
    }

    /**
     * Returns the Body mass index for the supplied height in meters and weight in kg
     * @see <a href="http://en.wikipedia.org/wiki/Body_mass_index">http://en.wikipedia.org/wiki/Body_mass_index</a>
     * @param height Height in meters
     * @param weight Weight in kg
     * @return  the BMI
     */
    private int bmi( float height, float weight ) {
        return (int) ( weight / ( Math.pow( height, 2 )) );
    }
}
