/**
 * Binary search recursive and iterative implementations.
 *
 * @author Kriche
 */

package ar.com.kriche.recursion;

public class BinarySearch {

    public static void main(String[] args) {
        Integer numbers[] = {1, 3, 5, 6, 8, 10, 13, 33, 101, 298, 299, 3000};
        Integer number = 8;

        System.out.println("index for number: " + number + " is: " + binarySearch(numbers, number) + ".");
        System.out.println("index for number: " + number + " is: " + binarySearchIterative(numbers, number) + ".");
    }

    public static int binarySearch(Object[] arr, Object key) {
        return binarySearchRecursive(arr, 0, arr.length - 1, key);
    }

    // check java.util.Arrays.binarySearch
    public static int binarySearchIterative(Object[] arr, Object key) {
        return binarySearchIterative(arr, 0, arr.length - 1, key);
    }

    private static int binarySearchRecursive(Object[] arr, int left, int right, Object key) {
        if (left > right) {
            return -1;
        }
        int index = (left + right) / 2;
        int cmp = ((Comparable) arr[index]).compareTo(key);
        if (cmp == 0) {
            return index;
        }
        if (cmp < 0) {
            return binarySearchRecursive(arr, index + 1, right, key);
        }
        return binarySearchRecursive(arr, left, index - 1, key);
    }

    private static int binarySearchIterative(Object[] arr, int left, int right, Object key) {
        while (left <= right) {
            int index = (left + right) / 2;
            int cmp = ((Comparable) arr[index]).compareTo(key);
            if (cmp == 0) {
                return index;
            }
            if (cmp < 0) {
                left = index + 1;
            } else {
                right = index - 1;
            }

        }
        return -1;
    }

}
