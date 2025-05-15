package ar.com.kriche;

import org.junit.jupiter.api.Test;

import static ar.com.kriche.SortedArraysFindCommonValues.sortedArraysFindCommonValueBinarySearchOptimized;
import static ar.com.kriche.SortedArraysFindCommonValues.sortedArraysFindCommonValueBinarySearch;
import static ar.com.kriche.SortedArraysFindCommonValues.sortedArraysFindCommonValues;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class SortedArraysFindCommonValuesTest {

    @Test
    public void sortedArraysFindCommonValuesTest() {
        verifyCommons(new Integer[]{1, 2, 3}, new Integer[]{1, 2, 3}, new Integer[]{1, 2, 3});
        verifyCommons(new Integer[]{1, 2, 3, 4, 5}, new Integer[]{2, 4}, new Integer[]{2, 4});
        verifyCommons(new Integer[]{1, 3, 5, 7}, new Integer[]{2, 4, 6}, new Integer[]{});
        verifyCommons(new Integer[]{1, 2, 3, 4}, new Integer[]{5, 6}, new Integer[]{});
        verifyCommons(new Integer[]{10, 20, 30, 40}, new Integer[]{15, 16}, new Integer[]{});
        verifyCommons(new Integer[]{13, 27, 35, 40, 49, 55, 59}, new Integer[]{17, 35, 39, 40, 55, 58, 60}, new Integer[]{35, 40, 55});
        verifyCommons(new Integer[]{11, 14, 15}, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 19, 20, 22, 26, 200}, new Integer[]{});
        verifyCommons(new Integer[]{11, 13, 15}, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 19, 20, 22, 26, 200}, new Integer[]{13});
    }

    private static void verifyCommons(Integer[] arr1, Integer[] arr2, Integer[] expected) {

        assertArrayEquals(expected, sortedArraysFindCommonValues(arr1, arr2));
        assertArrayEquals(expected, sortedArraysFindCommonValues(arr2, arr1));

        assertArrayEquals(expected, sortedArraysFindCommonValueBinarySearch(arr1, arr2));
        assertArrayEquals(expected, sortedArraysFindCommonValueBinarySearch(arr2, arr1));

        assertArrayEquals(expected, sortedArraysFindCommonValueBinarySearchOptimized(arr1, arr2));
        assertArrayEquals(expected, sortedArraysFindCommonValueBinarySearchOptimized(arr2, arr1));

    }

}
