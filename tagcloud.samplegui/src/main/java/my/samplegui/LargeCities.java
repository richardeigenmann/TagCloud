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

public class LargeCities {

    private LargeCities() {
        throw new IllegalStateException("Utility class");
    }

    public static List<WeightedWordInterface> getCitiesAsWeightedWords() {
        List<WeightedWordInterface> cities = new ArrayList<>();
        cities.add(new WeightedWord("Mumbai", 20700000));
        cities.add(new WeightedWord("Shanghai", 24870000));
        cities.add(new WeightedWord("Karachi", 16090000));
        cities.add(new WeightedWord("Delhi", 16780000));
        cities.add(new WeightedWord("Istanbul", 15520000));
        cities.add(new WeightedWord("Sao Paulo", 12330000));
        cities.add(new WeightedWord("Moscow", 12640000));
        cities.add(new WeightedWord("Seoul", 9776000));
        cities.add(new WeightedWord("Beijing", 21540000));
        cities.add(new WeightedWord("Mexico City", 9209944));
        cities.add(new WeightedWord("Tokyo", 13960000));
        cities.add(new WeightedWord("Jakarta", 10560000));
        cities.add(new WeightedWord("New York City", 8804190));
        cities.add(new WeightedWord("Wuhan", 11000000));
        cities.add(new WeightedWord("Lagos", 14860000));
        cities.add(new WeightedWord("Kinshasa", 14970000));
        cities.add(new WeightedWord("Tehran", 8694000));
        cities.add(new WeightedWord("Lima", 9674000));
        cities.add(new WeightedWord("London", 8982000));
        cities.add(new WeightedWord("Bogota", 7413000));
        cities.add(new WeightedWord("Hong Kong", 7482000));
        cities.add(new WeightedWord("Bangkok", 10539000));
        cities.add(new WeightedWord("Cairo", 9539000));
        cities.add(new WeightedWord("Dhaka", 21006000));
        cities.add(new WeightedWord("Ho Chi Minh City", 8993000));
        cities.add(new WeightedWord("Lahore", 11126000));
        cities.add(new WeightedWord("Guangzhou", 15305000));
        cities.add(new WeightedWord("Rio de Janeiro", 6748000));
        cities.add(new WeightedWord("Tianjin", 15600000));
        cities.add(new WeightedWord("Baghdad", 7665000));
        cities.add(new WeightedWord("Bangalore", 8443000));
        cities.add(new WeightedWord("Kolkata", 4496000));
        cities.add(new WeightedWord("Santiago", 5228000));
        cities.add(new WeightedWord("Singapore", 5686000));
        cities.add(new WeightedWord("Chongqing", 32050000));
        cities.add(new WeightedWord("Saint Petersburg", 5384000));
        cities.add(new WeightedWord("Chennai", 6727000));
        cities.add(new WeightedWord("Riyadh", 7676000));
        cities.add(new WeightedWord("Surat", 4467000));
        cities.add(new WeightedWord("Alexandria", 5200000));
        cities.add(new WeightedWord("Shenyang", 8106000));
        cities.add(new WeightedWord("Yangon", 5430000));
        cities.add(new WeightedWord("Hyderabad", 6809000));
        cities.add(new WeightedWord("Ahmedabad", 5570000));
        cities.add(new WeightedWord("Ankara", 5663000));
        cities.add(new WeightedWord("Johannesburg", 5635000));
        cities.add(new WeightedWord("Los Angeles", 3898747));
        cities.add(new WeightedWord("Abidjan", 4707000));
        cities.add(new WeightedWord("Yokohama", 3778000));
        cities.add(new WeightedWord("Busan", 3411000));
        cities.add(new WeightedWord("Cape Town", 4710000));
        cities.add(new WeightedWord("Durban", 3950000));
        cities.add(new WeightedWord("Berlin", 3645000));
        cities.add(new WeightedWord("Pune", 3124000));
        cities.add(new WeightedWord("Pyongyang", 2870000));
        cities.add(new WeightedWord("Madrid", 3305000));
        cities.add(new WeightedWord("Kanpur", 2765000));
        cities.add(new WeightedWord("Jaipur", 3073000));
        cities.add(new WeightedWord("Buenos Aires", 2891000));
        cities.add(new WeightedWord("Nairobi", 4397000));
        cities.add(new WeightedWord("Jeddah", 3976000));
        return Collections.unmodifiableList(cities);
    }
}
