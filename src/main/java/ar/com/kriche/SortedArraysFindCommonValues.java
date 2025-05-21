package ar.com.kriche;

import java.util.Arrays;


public class SortedArraysFindCommonValues {

    /**
     * @param arr1 not null sorted array with no duplicate values.
     * @param arr2 not null sorted array with no duplicate values.
     * @return a new array with the values in common between arr1 and arr2.
     */
    public static Integer[] sortedArraysFindCommonValues(Integer[] arr1, Integer[] arr2) {

        Integer[] commonValues = new Integer[Math.min(arr1.length, arr2.length)];
        int k = 0;

        // approach one:
        // moves forward both arrays comparing and increasing the index of the smallest value:
        for (int i = 0, j = 0; i < arr1.length && j < arr2.length; ) {
            int diff = arr1[i] - arr2[j];
            if (diff == 0) {
                commonValues[k++] = arr1[i];
                i++;
                j++;
            } else if (diff < 0) {
                i++;
            } else {
                j++;
            }
        }

        return Arrays.copyOf(commonValues, k);

    }


    /**
     * @param arr1 not null sorted array with no duplicate values.
     * @param arr2 not null sorted array with no duplicate values.
     * @return a new array with the values in common between arr1 and arr2.
     */
    public static Integer[] sortedArraysFindCommonValueBinarySearchOptimized(Integer[] arr1, Integer[] arr2) {

        Integer[] commonValues = new Integer[Math.min(arr1.length, arr2.length)];
        int k = 0;

        int left = 0;
        int right;

        for (int i = 0; i < arr1.length; i++) {

            final int value = arr1[i];
            boolean found = false;
            // asign index to a dummy value to avoid compilation error.
            int index = -1;

            // the index of the latest value smaller than value
            int indexSmallerValue = -1;
            right = arr2.length - 1;

            // binary search:
            while (!found && left <= right) {
                index = (left + right) / 2;
                int diff = value - arr2[index];
                if (diff == 0) {
                    found = true;
                } else if (diff < 0) {
                    right = index - 1;
                } else {
                    indexSmallerValue = index;
                    left = index + 1;
                }
            }

            if (found) {
                commonValues[k++] = value;
                // for next value in arr1 start searching in:
                left = index + 1;
            } else {
                // for next value in arr1 start searching from the last smaller value found:
                left = indexSmallerValue + 1;
            }

        }

        return Arrays.copyOf(commonValues, k);
    }

}
