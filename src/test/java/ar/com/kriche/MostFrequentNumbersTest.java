/**
 * @author Kriche
 */
package ar.com.kriche;

import org.junit.jupiter.api.Test;

import static ar.com.kriche.MostFrequentNumbers.mostFrequentNumbers;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MostFrequentNumbersTest {

    @Test
    public void mostFrequentNumbersTest() {
        int[] numbers = new int[]{1, 1, 1, 1, 2, 2, 5, 5, 5, 3, 4};
        assertArrayEquals(new int[]{}, mostFrequentNumbers(numbers, -1));
        assertArrayEquals(new int[]{}, mostFrequentNumbers(numbers, 0));
        assertArrayEquals(new int[]{1}, mostFrequentNumbers(numbers, 1));
        assertArrayEquals(new int[]{1, 5}, mostFrequentNumbers(numbers, 2));
        assertArrayEquals(new int[]{1, 5, 2}, mostFrequentNumbers(numbers, 3));
        assertArrayEquals(new int[]{1, 5, 2, 3}, mostFrequentNumbers(numbers, 4));
        assertArrayEquals(new int[]{1, 5, 2, 3, 4}, mostFrequentNumbers(numbers, 5));
        assertArrayEquals(new int[]{1, 5, 2, 3, 4}, mostFrequentNumbers(numbers, 6));
    }

}