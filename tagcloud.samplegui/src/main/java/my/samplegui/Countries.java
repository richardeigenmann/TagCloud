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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.tagcloud.WeightedWord;
import org.tagcloud.WeightedWordInterface;

/**
 * This class creates a List of WeightedWords countries and their
 * to illustrate the TagCloud.
 *
 * @see <a
 * href="http://en.wikipedia.org/wiki/List_of_countries_by_population">Wikipedia
 * List of countries by population</a>
 * @author Richard Eigenmann
 */
public class Countries  {

    private Countries() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * List of countries and their population
     */
    public static List<WeightedWordInterface> getCountriesAsWeightedWords() {
        List<WeightedWordInterface> countries = new ArrayList<>();
        countries.add( new WeightedWord( "People's Republic of China", 1332120000 ) );
        countries.add( new WeightedWord( "India", 1167020000 ) );
        countries.add( new WeightedWord( "United States", 307033000 ) );
        countries.add( new WeightedWord( "Indonesia", 230781846 ) );
        countries.add( new WeightedWord( "Brazil", 191615000 ) );
        countries.add( new WeightedWord( "Pakistan", 167047000 ) );
        countries.add( new WeightedWord( "Bangladesh", 162221000 ) );
        countries.add( new WeightedWord( "Nigeria", 154729000 ) );
        countries.add( new WeightedWord( "Russia", 141868000 ) );
        countries.add( new WeightedWord( "Japan", 127580000 ) );
        countries.add( new WeightedWord( "Mexico", 107550697 ) );
        countries.add( new WeightedWord( "Philippines", 92226600 ) );
        countries.add( new WeightedWord( "Vietnam", 88069000 ) );
        countries.add( new WeightedWord( "Germany", 82046000 ) );
        countries.add( new WeightedWord( "Ethiopia", 79221000 ) );
        countries.add( new WeightedWord( "Egypt", 76978937 ) );
        countries.add( new WeightedWord( "Iran", 74196000 ) );
        countries.add( new WeightedWord( "Turkey", 71517100 ) );
        countries.add( new WeightedWord( "Dem. Rep. of Congo", 66020000 ) );
        countries.add( new WeightedWord( "France", 65073482 ) );
        countries.add( new WeightedWord( "Thailand", 63389730 ) );
        countries.add( new WeightedWord( "United Kingdom", 61634599 ) );
        countries.add( new WeightedWord( "Italy", 60067554 ) );
        countries.add( new WeightedWord( "Myanmar (Burma)", 50020000 ) );
        countries.add( new WeightedWord( "South Africa", 48697000 ) );
        countries.add( new WeightedWord( "South Korea", 48333000 ) );
        countries.add( new WeightedWord( "Ukraine", 46143700 ) );
        countries.add( new WeightedWord( "Spain", 45828172 ) );
        countries.add( new WeightedWord( "Colombia", 45025388 ) );
        countries.add( new WeightedWord( "Tanzania", 43739000 ) );
        return Collections.unmodifiableList(countries);
    }
}
