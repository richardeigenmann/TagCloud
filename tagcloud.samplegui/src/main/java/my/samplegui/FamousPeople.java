/*
 Copyright (C) 2009, 2025 Richard Eigenmann, Zürich, Switzerland

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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.tagcloud.WeightedWord;
import org.tagcloud.WeightedWordInterface;

/**
 * A factory class to create a list of famous People for the tag cloud sample.
 *
 * @author Richard Eigenmann
 */
public final class FamousPeople {

    private FamousPeople() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * A record to model a person's data clearly.
     */
    private record Person(String name, int heightInCm, double weightInKg) {
        /**
         * Calculates the Body Mass Index (BMI).
         * @see <a href="https://en.wikipedia.org/wiki/Body_mass_index">https://en.wikipedia.org/wiki/Body_mass_index</a>
         * @return the BMI value.
         */
        public double getBmi() {
            // Avoid division by zero if height is 0
            if (heightInCm <= 0) {
                return 0;
            }
            // BMI formula: weight (kg) / [height (m)]^2
            return weightInKg / Math.pow((double) heightInCm / 100, 2);
        }

        /**
         * Converts this Person object into a WeightedWord for the tag cloud.
         * The tag's "weight" is based on the person's height.
         * @return A {@link WeightedWordInterface} instance.
         */
        public WeightedWordInterface toWeightedWord() {
            return new WeightedWord(name, heightInCm, (int) getBmi());
        }
    }

    private static final List<Person> FAMOUS_PEOPLE = Arrays.asList(
            new Person("Napoleon Bonaparte", 170, 63.5),
            new Person("Abraham Lincoln", 193, 81.6),
            new Person("Michael Moore", 182, 154.2),
            new Person("Claudia Schiffer", 181, 58.7),
            new Person("Vladimir Putin", 170, 75),
            new Person("Michael Jackson", 175, 64),
            new Person("Snoop Dogg", 193, 80),
            new Person("Miley Cyrus", 165, 52),
            new Person("Keanu Reeves", 185, 79),
            new Person("Larry Page", 180, 81),
            new Person("Quentin Tarantino", 185, 92),
            new Person("Steve Jobs", 183, 70),
            new Person("Warren Buffet", 178, 86),
            new Person("Donald Trump", 190, 110)
    );

    /**
     * Returns an unmodifiable list of famous people as {@link WeightedWordInterface} objects.
     *
     * @return A list of people for the tag cloud.
     */
    public static List<WeightedWordInterface> getPeopleAsWeightedWords() {
        return Collections.unmodifiableList(
                FAMOUS_PEOPLE.stream()
                        .map(Person::toWeightedWord)
                        .toList()
        );
    }
}
