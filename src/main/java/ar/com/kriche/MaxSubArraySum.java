/**
 * @author Kriche
 */
package ar.com.kriche;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class MaxSubArraySum {

    /**
     * @param numbers
     * @return the subarray with the biggest sum.
     */
    public static int[] maxSubArraySum(@NotNull int[] numbers) {
        if (numbers.length == 0) {
            return new int[]{};
        }
        // Kadane’s Algorithm:
        int maxEndingHere = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxSumLeftIndex = 0, maxSumRightIndex = 0, currentSumIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            maxEndingHere += numbers[i];
            if (maxEndingHere > maxSum) {
                maxSum = maxEndingHere;
                maxSumLeftIndex = currentSumIndex;
                maxSumRightIndex = i;
            }
            if (maxEndingHere < 0) {
                currentSumIndex = i + 1;
                maxEndingHere = 0;
            }
        }
        return Arrays.copyOfRange(numbers, maxSumLeftIndex, maxSumRightIndex + 1);
    }

}
