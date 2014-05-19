package org.TagCloud.sample;

import java.util.ArrayList;
import org.TagCloud.WeightedWord;


/*
 Copyright (C)) 2009, 2014 Richard Eigenmann, Zürich, Switzerland

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
public class EuropeanCities extends ArrayList<WeightedWord> {

    public EuropeanCities() {
        add( new WeightedWord( "Moscow", 8297000 ) );
        add( new WeightedWord( "London", 7074000 ) );
        add( new WeightedWord( "St Petersburg", 4678000 ) );
        add( new WeightedWord( "Berlin", 3387000 ) );
        add( new WeightedWord( "Madrod", 2824000 ) );
        add( new WeightedWord( "Rome", 2649000 ) );
        add( new WeightedWord( "Kiev", 2590000 ) );
        add( new WeightedWord( "Paris", 2152000 ) );
        add( new WeightedWord( "Bucharest", 2016000 ) );
        add( new WeightedWord( "Budapest", 1825000 ) );
        add( new WeightedWord( "Hamburg", 1705000 ) );
        add( new WeightedWord( "Minsk", 1677000 ) );
        add( new WeightedWord( "Warsaw", 1615000 ) );
        add( new WeightedWord( "Belgrade", 1594000 ) );
        add( new WeightedWord( "Vienna", 1540000 ) );
        add( new WeightedWord( "Kharkov", 1494000 ) );
        add( new WeightedWord( "Barcelona", 1455000 ) );
        add( new WeightedWord( "Novosibirsk", 1400000 ) );
        add( new WeightedWord( "Nizhny Novgorod", 1358000 ) );
        add( new WeightedWord( "Milano (Milan))", 1306000 ) );
        add( new WeightedWord( "Ekaterinoburg", 1267000 ) );
        add( new WeightedWord( "München", 1195000 ) );
        add( new WeightedWord( "Prague", 1193000 ) );
        add( new WeightedWord( "Samara", 1165000 ) );
        add( new WeightedWord( "Omsk", 1153000 ) );
        add( new WeightedWord( "Sofia", 1139000 ) );
        add( new WeightedWord( "Dnepropetrovsk", 1108000 ) );
        add( new WeightedWord( "Kazan", 1092000 ) );
        add( new WeightedWord( "Ufa", 1088000 ) );
        add( new WeightedWord( "Chelyabinsk", 1084000 ) );
        add( new WeightedWord( "Donetsk", 1050000 ) );
        add( new WeightedWord( "Naples", 1047000 ) );
        add( new WeightedWord( "Birmingham", 1021000 ) );
        add( new WeightedWord( "Perm", 1014000 ) );
        add( new WeightedWord( "Rostov-na-Donu", 1003000 ) );
        add( new WeightedWord( "Odessa", 1002000 ) );
        add( new WeightedWord( "Volgograd", 992000 ) );
        add( new WeightedWord( "Köln", 963000 ) );
        add( new WeightedWord( "Turin", 921000 ) );
        add( new WeightedWord( "Voronezh", 903000 ) );
        add( new WeightedWord( "Krasnoyarsk", 876000 ) );
        add( new WeightedWord( "Saratov", 875000 ) );
        add( new WeightedWord( "Zagreb", 868000 ) );
        add( new WeightedWord( "Zaporozhye", 850000 ) );
        add( new WeightedWord( "Lódz", 803000 ) );
        add( new WeightedWord( "Marseille", 800000 ) );
        add( new WeightedWord( "Riga", 793000 ) );
        add( new WeightedWord( "Lvov", 786000 ) );
        add( new WeightedWord( "Athens", 772000 ) );
        add( new WeightedWord( "Salonika", 749000 ) );
        add( new WeightedWord( "Stockholm", 744000 ) );
        add( new WeightedWord( "Kraków", 740000 ) );
        add( new WeightedWord( "Valencia", 736000 ) );
        add( new WeightedWord( "Amsterdam", 729000 ) );
        add( new WeightedWord( "Leeds", 727000 ) );
        add( new WeightedWord( "Tolyatti", 720000 ) );
        add( new WeightedWord( "Kryvy Rig", 705000 ) );
        add( new WeightedWord( "Sevilla", 695000 ) );
        add( new WeightedWord( "Palermo", 689000 ) );
        add( new WeightedWord( "Ulyanovsk", 668000 ) );
        add( new WeightedWord( "KISHINEV", 658000 ) );
        add( new WeightedWord( "Genova", 656000 ) );
        add( new WeightedWord( "Izhevsk", 654000 ) );
        add( new WeightedWord( "Frankfurt am Main", 644000 ) );
        add( new WeightedWord( "Krasnodar", 640000 ) );
        add( new WeightedWord( "Wroclaw (Breslau))", 637000 ) );
        add( new WeightedWord( "Glasgow", 616000 ) );
        add( new WeightedWord( "Yaroslave", 614000 ) );
        add( new WeightedWord( "Khabarovsk", 609000 ) );
        add( new WeightedWord( "Vladivostok", 607000 ) );
        add( new WeightedWord( "Zaragoza", 601000 ) );
        add( new WeightedWord( "Essen", 600000 ) );
        add( new WeightedWord( "Rotterdam", 593000 ) );
        add( new WeightedWord( "Irkutsk", 591000 ) );
        add( new WeightedWord( "Dortmund", 590000 ) );
        add( new WeightedWord( "Stuttgart", 582000 ) );
        add( new WeightedWord( "Barnaul", 580000 ) );
        add( new WeightedWord( "Vilnius", 578000 ) );
        add( new WeightedWord( "Poznan", 578000 ) );
        add( new WeightedWord( "Düsseldorf", 569000 ) );
        add( new WeightedWord( "Novokuznetsk", 564000 ) );
        add( new WeightedWord( "Lisbon", 563000 ) );
        add( new WeightedWord( "Helsinki", 549000 ) );
        add( new WeightedWord( "Málaga", 543000 ) );
        add( new WeightedWord( "Bremen", 540000 ) );
        add( new WeightedWord( "Sheffield", 530000 ) );
        add( new WeightedWord( "SARAJEVO", 529000 ) );
        add( new WeightedWord( "Penza", 528000 ) );
        add( new WeightedWord( "Ryazan", 528000 ) );
        add( new WeightedWord( "Orenburg", 523000 ) );
        add( new WeightedWord( "Naberezhnye Tchelny", 521000 ) );
        add( new WeightedWord( "Duisburg", 520000 ) );
        add( new WeightedWord( "Lipetsk", 519000 ) );
        add( new WeightedWord( "Hannover", 515000 ) );
        add( new WeightedWord( "Mykolaiv", 510000 ) );
        add( new WeightedWord( "Tula", 506000 ) );
        add( new WeightedWord( "Oslo", 505000 ) );
        add( new WeightedWord( "Tyumen", 502000 ) );
        add( new WeightedWord( "Copenhagen", 499000 ) );
        add( new WeightedWord( "Kemerovo", 492000 ) );
    }
}
