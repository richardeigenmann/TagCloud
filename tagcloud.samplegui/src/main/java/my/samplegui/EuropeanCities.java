/*
 Copyright (C)) 2009, 2025 Richard Eigenmann, Zurich, Switzerland

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
 * This class creates a List of WeightedWords for European cities and their
 * population to illustrate the TagCloud.
 *
 * @see <a href="http://www.citymayors.com/features/euro_cities1.html">Link</a>
 *
 * @author Richard Eigenmann
 */
public class EuropeanCities  {

    private EuropeanCities() {
        throw new IllegalStateException("Utility class");
    }


    /**
     * List of European Cities
     */
    public static List<WeightedWordInterface> getCitiesAsWeightedWords() {
        List<WeightedWordInterface> cities = new ArrayList<>();
        cities.add( new WeightedWord( "Moscow", 8297000 ) );
        cities.add( new WeightedWord( "London", 7074000 ) );
        cities.add( new WeightedWord( "St Petersburg", 4678000 ) );
        cities.add( new WeightedWord( "Berlin", 3387000 ) );
        cities.add( new WeightedWord( "Madrid", 2824000 ) );
        cities.add( new WeightedWord( "Rome", 2649000 ) );
        cities.add( new WeightedWord( "Kiev", 2590000 ) );
        cities.add( new WeightedWord( "Paris", 2152000 ) );
        cities.add( new WeightedWord( "Bucharest", 2016000 ) );
        cities.add( new WeightedWord( "Budapest", 1825000 ) );
        cities.add( new WeightedWord( "Hamburg", 1705000 ) );
        cities.add( new WeightedWord( "Minsk", 1677000 ) );
        cities.add( new WeightedWord( "Warsaw", 1615000 ) );
        cities.add( new WeightedWord( "Belgrade", 1594000 ) );
        cities.add( new WeightedWord( "Vienna", 1540000 ) );
        cities.add( new WeightedWord( "Kharkov", 1494000 ) );
        cities.add( new WeightedWord( "Barcelona", 1455000 ) );
        cities.add( new WeightedWord( "Novosibirsk", 1400000 ) );
        cities.add( new WeightedWord( "Nizhny Novgorod", 1358000 ) );
        cities.add( new WeightedWord( "Milano (Milan))", 1306000 ) );
        cities.add( new WeightedWord( "Ekaterinoburg", 1267000 ) );
        cities.add( new WeightedWord( "München", 1195000 ) );
        cities.add( new WeightedWord( "Prague", 1193000 ) );
        cities.add( new WeightedWord( "Samara", 1165000 ) );
        cities.add( new WeightedWord( "Omsk", 1153000 ) );
        cities.add( new WeightedWord( "Sofia", 1139000 ) );
        cities.add( new WeightedWord( "Dnepropetrovsk", 1108000 ) );
        cities.add( new WeightedWord( "Kazan", 1092000 ) );
        cities.add( new WeightedWord( "Ufa", 1088000 ) );
        cities.add( new WeightedWord( "Chelyabinsk", 1084000 ) );
        cities.add( new WeightedWord( "Donetsk", 1050000 ) );
        cities.add( new WeightedWord( "Naples", 1047000 ) );
        cities.add( new WeightedWord( "Birmingham", 1021000 ) );
        cities.add( new WeightedWord( "Perm", 1014000 ) );
        cities.add( new WeightedWord( "Rostov-na-Donu", 1003000 ) );
        cities.add( new WeightedWord( "Odessa", 1002000 ) );
        cities.add( new WeightedWord( "Volgograd", 992000 ) );
        cities.add( new WeightedWord( "Köln", 963000 ) );
        cities.add( new WeightedWord( "Turin", 921000 ) );
        cities.add( new WeightedWord( "Voronezh", 903000 ) );
        cities.add( new WeightedWord( "Krasnoyarsk", 876000 ) );
        cities.add( new WeightedWord( "Saratov", 875000 ) );
        cities.add( new WeightedWord( "Zagreb", 868000 ) );
        cities.add( new WeightedWord( "Zaporozhye", 850000 ) );
        cities.add( new WeightedWord( "Lodz", 803000 ) );
        cities.add( new WeightedWord( "Marseille", 800000 ) );
        cities.add( new WeightedWord( "Riga", 793000 ) );
        cities.add( new WeightedWord( "Lvov", 786000 ) );
        cities.add( new WeightedWord( "Athens", 772000 ) );
        cities.add( new WeightedWord( "Salonika", 749000 ) );
        cities.add( new WeightedWord( "Stockholm", 744000 ) );
        cities.add( new WeightedWord( "Krakow", 740000 ) );
        cities.add( new WeightedWord( "Valencia", 736000 ) );
        cities.add( new WeightedWord( "Amsterdam", 729000 ) );
        cities.add( new WeightedWord( "Leeds", 727000 ) );
        cities.add( new WeightedWord( "Tolyatti", 720000 ) );
        cities.add( new WeightedWord( "Kryvy Rig", 705000 ) );
        cities.add( new WeightedWord( "Sevilla", 695000 ) );
        cities.add( new WeightedWord( "Palermo", 689000 ) );
        cities.add( new WeightedWord( "Ulyanovsk", 668000 ) );
        cities.add( new WeightedWord( "Kishinev", 658000 ) );
        cities.add( new WeightedWord( "Genova", 656000 ) );
        cities.add( new WeightedWord( "Izhevsk", 654000 ) );
        cities.add( new WeightedWord( "Frankfurt am Main", 644000 ) );
        cities.add( new WeightedWord( "Krasnodar", 640000 ) );
        cities.add( new WeightedWord( "Wroclaw (Breslau))", 637000 ) );
        cities.add( new WeightedWord( "Glasgow", 616000 ) );
        cities.add( new WeightedWord( "Yaroslave", 614000 ) );
        cities.add( new WeightedWord( "Khabarovsk", 609000 ) );
        cities.add( new WeightedWord( "Vladivostok", 607000 ) );
        cities.add( new WeightedWord( "Zaragoza", 601000 ) );
        cities.add( new WeightedWord( "Essen", 600000 ) );
        cities.add( new WeightedWord( "Rotterdam", 593000 ) );
        cities.add( new WeightedWord( "Irkutsk", 591000 ) );
        cities.add( new WeightedWord( "Dortmund", 590000 ) );
        cities.add( new WeightedWord( "Stuttgart", 582000 ) );
        cities.add( new WeightedWord( "Barnaul", 580000 ) );
        cities.add( new WeightedWord( "Vilnius", 578000 ) );
        cities.add( new WeightedWord( "Poznan", 578000 ) );
        cities.add( new WeightedWord( "Düsseldorf", 569000 ) );
        cities.add( new WeightedWord( "Novokuznetsk", 564000 ) );
        cities.add( new WeightedWord( "Lisbon", 563000 ) );
        cities.add( new WeightedWord( "Helsinki", 549000 ) );
        cities.add( new WeightedWord( "Malaga", 543000 ) );
        cities.add( new WeightedWord( "Bremen", 540000 ) );
        cities.add( new WeightedWord( "Sheffield", 530000 ) );
        cities.add( new WeightedWord( "Sarajevo", 529000 ) );
        cities.add( new WeightedWord( "Penza", 528000 ) );
        cities.add( new WeightedWord( "Ryazan", 528000 ) );
        cities.add( new WeightedWord( "Orenburg", 523000 ) );
        cities.add( new WeightedWord( "Naberezhnye Tchelny", 521000 ) );
        cities.add( new WeightedWord( "Duisburg", 520000 ) );
        cities.add( new WeightedWord( "Lipetsk", 519000 ) );
        cities.add( new WeightedWord( "Hannover", 515000 ) );
        cities.add( new WeightedWord( "Mykolaiv", 510000 ) );
        cities.add( new WeightedWord( "Tula", 506000 ) );
        cities.add( new WeightedWord( "Oslo", 505000 ) );
        cities.add( new WeightedWord( "Tyumen", 502000 ) );
        cities.add( new WeightedWord( "Copenhagen", 499000 ) );
        cities.add( new WeightedWord( "Kemerovo", 492000 ) );
        return Collections.unmodifiableList(cities);
    }
}
