/**
 * @author Kriche
 */

package ar.com.kriche;

import org.jetbrains.annotations.NotNull;

public class Sort {

    /**
     * merges 2 sorted arrays into merged.
     *
     * @param arr1
     * @param arr2
     * @param merged
     */
    public static void mergeSorted(@NotNull int[] arr1, @NotNull int[] arr2, @NotNull int[] merged) {
        int index1 = 0, index2 = 0, mergedIndex = 0;
        int v1, v2;
        while (index1 < arr1.length && index2 < arr2.length) {
            v1 = arr1[index1];
            v2 = arr2[index2];
            if (v1 <= v2) {
                merged[mergedIndex++] = v1;
                index1++;
            } else {
                merged[mergedIndex++] = v2;
                index2++;
            }
        }
        while (index1 < arr1.length) {
            merged[mergedIndex++] = arr1[index1++];
        }
        while (index2 < arr2.length) {
            merged[mergedIndex++] = arr2[index2++];
        }
    }

}
