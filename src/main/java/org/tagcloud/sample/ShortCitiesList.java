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
package org.tagcloud.sample;

import java.util.ArrayList;
import org.tagcloud.WeightedWord;
import org.tagcloud.WeightedWordInterface;

/**
 * This class creates a list of WeightedWords with just 3 cities to illustrate
 * the TagCloud on a short list.
 *
 * @see <a
 * href="http://en.wikipedia.org/wiki/List_of_cities_proper_by_population">Wikipedia
 * Cities by Population</a>
 * @author Richard Eigenmann
 */
public class ShortCitiesList extends ArrayList<WeightedWordInterface> {

    /**
     * Short list of cities
     */
    public ShortCitiesList() {
        add( new WeightedWord( "Shanghai", 13831900 ) );
        add( new WeightedWord( "Cape Town", 3497097 ) );
        add( new WeightedWord( "Zurich", 366765 ) ); // Google, value from 2009
    }
}
