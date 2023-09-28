package ar.com.kriche.recursion;

import org.junit.jupiter.api.Test;

import static ar.com.kriche.recursion.MagicIndex.magicIndexOnSortedArray;
import static ar.com.kriche.recursion.MagicIndex.magicIndexOnSortedArrayDistinctNumbers;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Kriche
 */
public class MagicIndexTest {

    @Test
    public void magicIndexOnSortedArrayDistinctNumberTest() {
        int numbers[] = new int[]{0};
        assertEquals(0, magicIndexOnSortedArrayDistinctNumbers(numbers));
    }

    @Test
    public void magicIndexOnSortedArrayDistinctNumberNotFoundRightTest() {
        int numbers[] = new int[]{1};
        assertEquals(-1, magicIndexOnSortedArrayDistinctNumbers(numbers));
    }

    @Test
    public void magicIndexOnSortedArrayDistinctNumberNotFoundLeftTest() {
        int numbers[] = new int[]{-1};
        assertEquals(-1, magicIndexOnSortedArrayDistinctNumbers(numbers));
    }

    @Test
    public void magicIndexOnSortedArrayDistinctNumbersNotFoundRightTest() {
        int numbers[] = new int[]{1, 2};
        assertEquals(-1, magicIndexOnSortedArrayDistinctNumbers(numbers));
    }

    @Test
    public void magicIndexOnSortedArrayDistinctNumbersNotFoundLeftTest() {
        int numbers[] = new int[]{-1, 0};
        assertEquals(-1, magicIndexOnSortedArrayDistinctNumbers(numbers));
    }

    @Test
    public void magicIndexOnSortedArrayDistinctNumbersMiddleTest() {
        int numbers[] = new int[]{-1, 0, 1, 2, 4, 6, 7};
        assertEquals(4, magicIndexOnSortedArrayDistinctNumbers(numbers));
    }

    @Test
    public void magicIndexOnSortedArrayDistinctNumbersRightTest() {
        int numbers[] = new int[]{-1, 0, 1, 2, 3, 4, 5, 7};
        assertEquals(7, magicIndexOnSortedArrayDistinctNumbers(numbers));
    }

    @Test
    public void magicIndexOnSortedArrayDistinctNumbersLeftTest() {
        int numbers[] = new int[]{0, 3, 4, 5, 6};
        assertEquals(0, magicIndexOnSortedArrayDistinctNumbers(numbers));
    }

    @Test
    public void magicIndexOnSortedArrayDistinctNumbersNotFoundTest() {
        int numbers[] = new int[]{-1, 0, 1, 2, 3, 4, 5};
        assertEquals(-1, magicIndexOnSortedArrayDistinctNumbers(numbers));
    }

    /* ************************************************************************************************************** */

    @Test
    public void magicIndexOnSortedArrayOneElemTest() {
        int numbers[] = new int[]{0};
        assertEquals(0, magicIndexOnSortedArray(numbers));
    }

    @Test
    public void magicIndexOnSortedArrayOneElemNotFoundRightTest() {
        int numbers[] = new int[]{1};
        assertEquals(-1, magicIndexOnSortedArray(numbers));
    }

    @Test
    public void magicIndexOnSortedArrayOneElemNotFoundLeftTest() {
        int numbers[] = new int[]{-1};
        assertEquals(-1, magicIndexOnSortedArray(numbers));
    }

    @Test
    public void magicIndexOnSortedArrayNotFoundRightTest() {
        int numbers[] = new int[]{1, 4, 4};
        assertEquals(-1, magicIndexOnSortedArray(numbers));
    }

    @Test
    public void magicIndexOnSortedArrayNotFoundLeftTest() {
        int numbers[] = new int[]{-2, -1, -1, 1, 2, 3};
        assertEquals(-1, magicIndexOnSortedArray(numbers));
    }

    @Test
    public void magicIndexOnSortedArrayMiddleTest() {
        int numbers[] = new int[]{-2, -1, 0, 0, 5, 5, 5, 5, 9, 10, 11, 14};
        assertEquals(5, magicIndexOnSortedArray(numbers));
    }

    @Test
    public void magicIndexOnSortedArrayRightTest() {
        int numbers[] = new int[]{-2, 0, 0, 2, 2, 4, 4, 7};
        assertEquals(7, magicIndexOnSortedArray(numbers));
    }

    @Test
    public void magicIndexOnSortedArrayLeftTest() {
        int numbers[] = new int[]{0, 2, 5, 5, 5, 7, 7, 10};
        assertEquals(0, magicIndexOnSortedArray(numbers));
    }

    @Test
    public void magicIndexOnSortedArrayTest() {
        int numbers[] = new int[]{-10, 1, 1, 1, 4, 20};
        assertEquals(1, magicIndexOnSortedArray(numbers));
    }

    @Test
    public void magicIndexOnSortedArrayNotFoundTest() {
        int numbers[] = new int[]{-1, 0, 0, 0, 1, 1, 1, 2, 3, 3, 3, 4, 5, 5, 5};
        assertEquals(-1, magicIndexOnSortedArray(numbers));
    }

}
