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
 * This class creates an list of WeightedWords list of cities and their (out of
 * date) population taken form Wikipedia to illustrate the TagCloud.
 *
 * @see <a
 * href="http://en.wikipedia.org/wiki/List_of_cities_proper_by_population">Wikipedia
 * Cities by Population</a>
 *
 * @author Richard Eigenmann
 */
public class Cities extends ArrayList<WeightedWordInterface> {

    /**
     * List of cities and their population
     */
    public Cities() {
        add( new WeightedWord( "Mumbai", 13922125 ) );
        add( new WeightedWord( "Shanghai", 13831900 ) );
        add( new WeightedWord( "Karachi", 12991000 ) );
        add( new WeightedWord( "Delhi", 12259230 ) );
        add( new WeightedWord( "Istanbul", 11372613 ) );
        add( new WeightedWord( "São Paulo", 10990249 ) );
        add( new WeightedWord( "Moscow", 10452000 ) );
        add( new WeightedWord( "Seoul", 10421782 ) );
        add( new WeightedWord( "Beijing", 10123000 ) );
        add( new WeightedWord( "Mexico City", 8836045 ) );
        add( new WeightedWord( "Tokyo", 8731000 ) );
        add( new WeightedWord( "Jakarta", 8489910 ) );
        add( new WeightedWord( "New York City", 8310212 ) );
        add( new WeightedWord( "Wuhan", 8001541 ) );
        add( new WeightedWord( "Lagos", 7937932 ) );
        add( new WeightedWord( "Kinshasa", 784000 ) );
        add( new WeightedWord( "Tehran", 7797520 ) );
        add( new WeightedWord( "Lima", 7605742 ) );
        add( new WeightedWord( "London", 7556900 ) );
        add( new WeightedWord( "Bogotá", 7155052 ) );
        add( new WeightedWord( "Hong Kong", 6985200 ) );
        add( new WeightedWord( "Bangkok", 6972000 ) );
        add( new WeightedWord( "Cairo", 6758581 ) );
        add( new WeightedWord( "Dhaka", 6737774 ) );
        add( new WeightedWord( "Ho Chi Minh City", 6650942 ) );
        add( new WeightedWord( "Lahore", 6318745 ) );
        add( new WeightedWord( "Guangzhou", 6172839 ) );
        add( new WeightedWord( "Rio de Janeiro", 6161047 ) );
        add( new WeightedWord( "Tianjin", 5800000 ) );
        add( new WeightedWord( "Baghdad", 5337684 ) );
        add( new WeightedWord( "Bangalore", 5310318 ) );
        add( new WeightedWord( "Kolkata", 5080519 ) );
        add( new WeightedWord( "Santiago", 4985893 ) );
        add( new WeightedWord( "Singapore", 4839400 ) );
        add( new WeightedWord( "Chongqing", 4776027 ) );
        add( new WeightedWord( "Saint Petersburg", 4596000 ) );
        add( new WeightedWord( "Chennai", 4590267 ) );
        add( new WeightedWord( "Riyadh", 4465000 ) );
        add( new WeightedWord( "Surat", 4274429 ) );
        add( new WeightedWord( "Alexandria", 4110015 ) );
        add( new WeightedWord( "Shenyang", 4101197 ) );
        add( new WeightedWord( "Yangon", 4088000 ) );
        add( new WeightedWord( "Hyderabad", 4025335 ) );
        add( new WeightedWord( "Ahmedabad", 3913793 ) );
        add( new WeightedWord( "Ankara", 3901201 ) );
        add( new WeightedWord( "Johannesburg", 3888180 ) );
        add( new WeightedWord( "Los Angeles", 3849378 ) );
        add( new WeightedWord( "Abidjan", 3802000 ) );
        add( new WeightedWord( "Yokohama", 3650000 ) );
        add( new WeightedWord( "Busan", 3615101 ) );
        add( new WeightedWord( "Cape Town", 3497097 ) );
        add( new WeightedWord( "Durban", 3468086 ) );
        add( new WeightedWord( "Berlin", 3426354 ) );
        add( new WeightedWord( "Pune", 3337481 ) );
        add( new WeightedWord( "Pyongyang", 3255388 ) );
        add( new WeightedWord( "Madrid", 3213271 ) );
        add( new WeightedWord( "Kanpur", 3144267 ) );
        add( new WeightedWord( "Jaipur", 3102808 ) );
        add( new WeightedWord( "Buenos Aires", 3050728 ) );
        add( new WeightedWord( "Nairobi", 3038553 ) );
        add( new WeightedWord( "Jeddah", 3012000 ) );
    }
}
