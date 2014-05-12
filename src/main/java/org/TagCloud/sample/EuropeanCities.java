package org.TagCloud.sample;

import java.util.HashMap;
import java.util.Map;
import org.TagCloud.WordMap;


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
/**
 * This class extends the WordMap with a list of European cities and their
 * population taken from the Internet to illustrate the TagCloud.
 *
 * @see <a href="http://www.citymayors.com/features/euro_cities1.html">Link</a>
 *
 * @author Richard Eigenmann
 */
public class EuropeanCities extends WordMap {

    @Override
    public Map<String, Integer> getWordValueMap() {
        Map<String, Integer> cities = new HashMap<>();
        cities.put( "Moscow", 8297000 );
        cities.put( "London", 7074000 );
        cities.put( "St Petersburg", 4678000 );
        cities.put( "Berlin", 3387000 );
        cities.put( "Madrod", 2824000 );
        cities.put( "Rome", 2649000 );
        cities.put( "Kiev", 2590000 );
        cities.put( "Paris", 2152000 );
        cities.put( "Bucharest", 2016000 );
        cities.put( "Budapest", 1825000 );
        cities.put( "Hamburg", 1705000 );
        cities.put( "Minsk", 1677000 );
        cities.put( "Warsaw", 1615000 );
        cities.put( "Belgrade", 1594000 );
        cities.put( "Vienna", 1540000 );
        cities.put( "Kharkov", 1494000 );
        cities.put( "Barcelona", 1455000 );
        cities.put( "Novosibirsk", 1400000 );
        cities.put( "Nizhny Novgorod", 1358000 );
        cities.put( "Milano (Milan)", 1306000 );
        cities.put( "Ekaterinoburg", 1267000 );
        cities.put( "München", 1195000 );
        cities.put( "Prague", 1193000 );
        cities.put( "Samara", 1165000 );
        cities.put( "Omsk", 1153000 );
        cities.put( "Sofia", 1139000 );
        cities.put( "Dnepropetrovsk", 1108000 );
        cities.put( "Kazan", 1092000 );
        cities.put( "Ufa", 1088000 );
        cities.put( "Chelyabinsk", 1084000 );
        cities.put( "Donetsk", 1050000 );
        cities.put( "Naples", 1047000 );
        cities.put( "Birmingham", 1021000 );
        cities.put( "Perm", 1014000 );
        cities.put( "Rostov-na-Donu", 1003000 );
        cities.put( "Odessa", 1002000 );
        cities.put( "Volgograd", 992000 );
        cities.put( "Köln", 963000 );
        cities.put( "Turin", 921000 );
        cities.put( "Voronezh", 903000 );
        cities.put( "Krasnoyarsk", 876000 );
        cities.put( "Saratov", 875000 );
        cities.put( "Zagreb", 868000 );
        cities.put( "Zaporozhye", 850000 );
        cities.put( "Lódz", 803000 );
        cities.put( "Marseille", 800000 );
        cities.put( "Riga", 793000 );
        cities.put( "Lvov", 786000 );
        cities.put( "Athens", 772000 );
        cities.put( "Salonika", 749000 );
        cities.put( "Stockholm", 744000 );
        cities.put( "Kraków", 740000 );
        cities.put( "Valencia", 736000 );
        cities.put( "Amsterdam", 729000 );
        cities.put( "Leeds", 727000 );
        cities.put( "Tolyatti", 720000 );
        cities.put( "Kryvy Rig", 705000 );
        cities.put( "Sevilla", 695000 );
        cities.put( "Palermo", 689000 );
        cities.put( "Ulyanovsk", 668000 );
        cities.put( "KISHINEV", 658000 );
        cities.put( "Genova", 656000 );
        cities.put( "Izhevsk", 654000 );
        cities.put( "Frankfurt am Main", 644000 );
        cities.put( "Krasnodar", 640000 );
        cities.put( "Wroclaw (Breslau)", 637000 );
        cities.put( "Glasgow", 616000 );
        cities.put( "Yaroslave", 614000 );
        cities.put( "Khabarovsk", 609000 );
        cities.put( "Vladivostok", 607000 );
        cities.put( "Zaragoza", 601000 );
        cities.put( "Essen", 600000 );
        cities.put( "Rotterdam", 593000 );
        cities.put( "Irkutsk", 591000 );
        cities.put( "Dortmund", 590000 );
        cities.put( "Stuttgart", 582000 );
        cities.put( "Barnaul", 580000 );
        cities.put( "Vilnius", 578000 );
        cities.put( "Poznan", 578000 );
        cities.put( "Düsseldorf", 569000 );
        cities.put( "Novokuznetsk", 564000 );
        cities.put( "Lisbon", 563000 );
        cities.put( "Helsinki", 549000 );
        cities.put( "Málaga", 543000 );
        cities.put( "Bremen", 540000 );
        cities.put( "Sheffield", 530000 );
        cities.put( "SARAJEVO", 529000 );
        cities.put( "Penza", 528000 );
        cities.put( "Ryazan", 528000 );
        cities.put( "Orenburg", 523000 );
        cities.put( "Naberezhnye Tchelny", 521000 );
        cities.put( "Duisburg", 520000 );
        cities.put( "Lipetsk", 519000 );
        cities.put( "Hannover", 515000 );
        cities.put( "Mykolaiv", 510000 );
        cities.put( "Tula", 506000 );
        cities.put( "Oslo", 505000 );
        cities.put( "Tyumen", 502000 );
        cities.put( "Copenhagen", 499000 );
        cities.put( "Kemerovo", 492000 );

        return cities;
    }
}
