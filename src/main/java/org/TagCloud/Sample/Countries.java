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
import org.TagCloud.WeightedWordInterface;

/**
 * This class creates a List of WeightedWords countries and their (out of date)
 * population taken form Wikipedia to illustrate the TagCloud.
 *
 * @see <a
 * href="http://en.wikipedia.org/wiki/List_of_countries_by_population">Wikipedia
 * List of countries by population</a>
 * @author Richard Eigenmann
 */
public class Countries extends ArrayList<WeightedWordInterface> {

    /**
     * List of countries and their population
     */
    public Countries() {
        add( new WeightedWord( "People's Republic of China", 1332120000 ) );
        add( new WeightedWord( "India", 1167020000 ) );
        add( new WeightedWord( "United States", 307033000 ) );
        add( new WeightedWord( "Indonesia", 230781846 ) );
        add( new WeightedWord( "Brazil", 191615000 ) );
        add( new WeightedWord( "Pakistan", 167047000 ) );
        add( new WeightedWord( "Bangladesh", 162221000 ) );
        add( new WeightedWord( "Nigeria", 154729000 ) );
        add( new WeightedWord( "Russia", 141868000 ) );
        add( new WeightedWord( "Japan", 127580000 ) );
        add( new WeightedWord( "Mexico", 107550697 ) );
        add( new WeightedWord( "Philippines", 92226600 ) );
        add( new WeightedWord( "Vietnam", 88069000 ) );
        add( new WeightedWord( "Germany", 82046000 ) );
        add( new WeightedWord( "Ethiopia", 79221000 ) );
        add( new WeightedWord( "Egypt", 76978937 ) );
        add( new WeightedWord( "Iran", 74196000 ) );
        add( new WeightedWord( "Turkey", 71517100 ) );
        add( new WeightedWord( "Dem. Rep. of Congo", 66020000 ) );
        add( new WeightedWord( "France", 65073482 ) );
        add( new WeightedWord( "Thailand", 63389730 ) );
        add( new WeightedWord( "United Kingdom", 61634599 ) );
        add( new WeightedWord( "Italy", 60067554 ) );
        add( new WeightedWord( "Myanmar (Burma)", 50020000 ) );
        add( new WeightedWord( "South Africa", 48697000 ) );
        add( new WeightedWord( "South Korea", 48333000 ) );
        add( new WeightedWord( "Ukraine", 46143700 ) );
        add( new WeightedWord( "Spain", 45828172 ) );
        add( new WeightedWord( "Colombia", 45025388 ) );
        add( new WeightedWord( "Tanzania", 43739000 ) );
    }
}
