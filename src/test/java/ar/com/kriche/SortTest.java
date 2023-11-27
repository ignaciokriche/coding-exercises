/**
 * @author Kriche
 */

package ar.com.kriche;

import org.junit.jupiter.api.Test;

import static ar.com.kriche.Sort.mergeSorted;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortTest {

    @Test
    public void mergeSortedTest() {
        int[] merged = new int[10];
        mergeSorted(new int[]{1, 3, 5, 10}, new int[]{2, 4, 6, 7, 8, 12}, merged);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10, 12}, merged);
    }
}