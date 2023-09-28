package ar.com.kriche.recursion;

import org.jetbrains.annotations.NotNull;

/**
 * Magic Index:
 * A magic index in an array A[0...n-1] is defined to be an index such that A[i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists.
 * <p>
 * Follow up: What if the values are not distinct?
 *
 * @author Kriche
 */
public class MagicIndex {

    /**
     * @param numbers a sorted array of distinct integers.
     * @return the index of a magic number, if present. -1, otherwise.
     */
    public static int magicIndexOnSortedArrayDistinctNumbers(@NotNull int numbers[]) {
        return magicIndexOnSortedArrayDistinctNumbers(numbers, 0, numbers.length - 1);
    }

    /**
     * @param numbers a sorted array.
     * @return the index of a magic number, if present. -1, otherwise.
     */
    public static int magicIndexOnSortedArray(@NotNull int numbers[]) {
        return magicIndexOnSortedArray(numbers, 0, numbers.length - 1);
    }

    private static int magicIndexOnSortedArrayDistinctNumbers(int numbers[], int left, int right) {

        if (left > right) {
            return -1;
        }
        if (left == right) {
            return numbers[left] == left ? left : -1;
        }

        int midIndex = (left + right) / 2;
        int diff = numbers[midIndex] - midIndex;
        if (diff == 0) {
            return midIndex;
        }
        if (diff < 0) {
            return magicIndexOnSortedArrayDistinctNumbers(numbers, midIndex + 1, right);
        }
        return magicIndexOnSortedArrayDistinctNumbers(numbers, left, midIndex - 1);

    }

    private static int magicIndexOnSortedArray(int numbers[], int left, int right) {

        if (left > right) {
            return -1;
        }

        int midIndex = (left + right) / 2;
        int midValue = numbers[midIndex];

        if (midIndex == midValue) {
            return midIndex;
        }

        // midIndex:                     3
        // index:        0    1    2     3     4     5
        // numbers:    -10,   1,   1,   [1],   4,    20

        int maxIndexLeft = midValue < midIndex ? midValue : midIndex - 1;
        int leftMagicIndex = magicIndexOnSortedArray(numbers, left, maxIndexLeft);
        if (leftMagicIndex != -1) {
            return leftMagicIndex;
        }

        int minIndexRight = midValue > midIndex ? midValue : midIndex + 1;
        return magicIndexOnSortedArray(numbers, minIndexRight, right);
    }

}