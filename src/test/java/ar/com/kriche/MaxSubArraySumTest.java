/**
 * @author Kriche
 */

package ar.com.kriche;

import org.junit.jupiter.api.Test;

import static ar.com.kriche.MaxSubArraySum.maxSubArraySum;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MaxSubArraySumTest {

    @Test
    public void maxSubArraySumTest() {
        assertArrayEquals(new int[]{}, maxSubArraySum(new int[]{}));
        assertArrayEquals(new int[]{-1}, maxSubArraySum(new int[]{-1}));
        assertArrayEquals(new int[]{1}, maxSubArraySum(new int[]{-1, 1}));
        assertArrayEquals(new int[]{1, 2}, maxSubArraySum(new int[]{-1, 1, 2}));
        assertArrayEquals(new int[]{1, 2}, maxSubArraySum(new int[]{2, -3, 1, 2, -1}));
        assertArrayEquals(new int[]{2}, maxSubArraySum(new int[]{2, -3, 1, -1, 1}));
        assertArrayEquals(new int[]{10, 1}, maxSubArraySum(new int[]{-10, 10, 1, -2}));
        assertArrayEquals(new int[]{9, 1}, maxSubArraySum(new int[]{-10, 9, 1, -2}));
        assertArrayEquals(new int[]{1, 9}, maxSubArraySum(new int[]{0, -11, 1, 9, -3, -2, 1, 1, -8}));
        assertArrayEquals(new int[]{4, -1, -2, 1, 5}, maxSubArraySum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
        assertArrayEquals(new int[]{-2}, maxSubArraySum(new int[]{-6, -3, -2, -8}));
        assertArrayEquals(new int[]{0}, maxSubArraySum(new int[]{-6, -3, -2, 0}));
    }

}