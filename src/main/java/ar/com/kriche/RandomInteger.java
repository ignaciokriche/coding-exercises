/**
 * Demonstrates how to generate a random integer in a given interval: [min;max] from
 * a random double value in the [0,1) interval.
 *
 * @author Kriche
 */

package ar.com.kriche;

import java.util.Date;
import java.util.Random;

public class RandomInteger {

    private static final Random RANDOM_GENERATOR = new Random(new Date().getTime());

    /**
     * @param min
     * @param max
     * @return a random number in interval [min;max]
     */
    public static int randomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("min (" + min + ") cannot be greater than max (" + max + ").");
        }
        return ((int) (RANDOM_GENERATOR.nextDouble() * (max - min + 1))) + min;
    }

}
