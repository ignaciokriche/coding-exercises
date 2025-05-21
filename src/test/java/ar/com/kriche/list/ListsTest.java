package ar.com.kriche.list;

import org.junit.jupiter.api.Test;

import static ar.com.kriche.list.Lists.*;
import static ar.com.kriche.list.Lists.LinkedNode.fromArray;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Kriche
 */
public class ListsTest {

    @Test
    public void removeDuplicatesEmptyListTest() {
        LinkedNode actualList = fromArray(new Integer[]{});
        removeDuplicates(actualList);
        LinkedNode expectedList = fromArray(new Integer[]{});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void removeDuplicatesRecursiveEmptyListTest() {
        LinkedNode actualList = fromArray(new Integer[]{});
        removeDuplicatesRecursive(actualList);
        LinkedNode expectedList = fromArray(new Integer[]{});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void removeDuplicatesOneElementTest() {
        LinkedNode actualList = fromArray(new Integer[]{1});
        removeDuplicates(actualList);
        LinkedNode expectedList = fromArray(new Integer[]{1});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void removeDuplicatesRecursiveOneElementTest() {
        LinkedNode actualList = fromArray(new Integer[]{1});
        removeDuplicatesRecursive(actualList);
        LinkedNode expectedList = fromArray(new Integer[]{1});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void removeDuplicatesNoDuplicatesNoTest() {
        LinkedNode actualList = fromArray(new Integer[]{1, 2, 3});
        removeDuplicates(actualList);
        LinkedNode expectedList = fromArray(new Integer[]{1, 2, 3});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void removeDuplicatesRecursiveNoDuplicatesNoTest() {
        LinkedNode actualList = fromArray(new Integer[]{1, 2, 3});
        removeDuplicatesRecursive(actualList);
        LinkedNode expectedList = fromArray(new Integer[]{1, 2, 3});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void removeDuplicatesFirstDuplicateTest() {
        LinkedNode actualList = fromArray(new Integer[]{1, 1, 2, 3});
        removeDuplicates(actualList);
        LinkedNode expectedList = fromArray(new Integer[]{1, 2, 3});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void removeDuplicatesRecursiveFirstDuplicateTest() {
        LinkedNode actualList = fromArray(new Integer[]{1, 1, 2, 3});
        removeDuplicatesRecursive(actualList);
        LinkedNode expectedList = fromArray(new Integer[]{1, 2, 3});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void removeDuplicatesLastDuplicateTest() {
        LinkedNode actualList = fromArray(new Integer[]{1, 2, 3, 3});
        removeDuplicates(actualList);
        LinkedNode expectedList = fromArray(new Integer[]{1, 2, 3});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void removeDuplicatesRecursiveLastDuplicateTest() {
        LinkedNode actualList = fromArray(new Integer[]{1, 2, 3, 3});
        removeDuplicatesRecursive(actualList);
        LinkedNode expectedList = fromArray(new Integer[]{1, 2, 3});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void removeDuplicatesAllDuplicateTest() {
        LinkedNode actualList = fromArray(new Integer[]{1, 1, 1, 1});
        removeDuplicates(actualList);
        LinkedNode expectedList = fromArray(new Integer[]{1});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void removeDuplicatesRecursiveAllDuplicateTest() {
        LinkedNode actualList = fromArray(new Integer[]{1, 1, 1, 1});
        removeDuplicatesRecursive(actualList);
        LinkedNode expectedList = fromArray(new Integer[]{1});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void removeDuplicatesFirstAndLastDuplicatedTest() {
        LinkedNode actualList = fromArray(new Integer[]{1, 2, 3, 2, 1});
        removeDuplicates(actualList);
        LinkedNode expectedList = fromArray(new Integer[]{1, 2, 3});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void removeDuplicatesRecursiveFirstAndLastDuplicatedTest() {
        LinkedNode actualList = fromArray(new Integer[]{1, 2, 3, 2, 1});
        removeDuplicatesRecursive(actualList);
        LinkedNode expectedList = fromArray(new Integer[]{1, 2, 3});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void removeDuplicatesMultipleDuplicateTest() {
        LinkedNode actualList =
                fromArray(new Integer[]{1, 2, 3, 2, 3, 3, 4, 5, 4, 6, 7, 8, 7, 1, 2, 8, 3, 4, 5, 6, 7});
        removeDuplicates(actualList);
        LinkedNode expectedList = fromArray(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void removeDuplicatesRecursiveMultipleDuplicateTest() {
        LinkedNode actualList =
                fromArray(new Integer[]{1, 2, 3, 2, 3, 3, 4, 5, 4, 6, 7, 8, 7, 1, 2, 8, 3, 4, 5, 6, 7});
        removeDuplicatesRecursive(actualList);
        LinkedNode expectedList = fromArray(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        assertEquals(expectedList, actualList);
    }

    /* ************************************************************************************************************** */

    @Test
    public void getFromLastOneElementTest() {
        LinkedNode actualList = fromArray(new Integer[]{0});
        assertEquals(0, getFromLast(actualList, 0));
    }

    @Test
    public void getFromLastRecursiveOneElementTest() {
        LinkedNode actualList = fromArray(new Integer[]{0});
        assertEquals(0, getFromLastRecursive(actualList, 0));
    }

    @Test
    public void getFromLastFirstElementTest() {
        LinkedNode actualList = fromArray(new Integer[]{0, 1, 2});
        assertEquals(0, getFromLast(actualList, 2));
    }

    @Test
    public void getFromLastRecursiveFirstElementTest() {
        LinkedNode actualList = fromArray(new Integer[]{0, 1, 2});
        assertEquals(0, getFromLastRecursive(actualList, 2));
    }

    @Test
    public void getFromLastLastElementTest() {
        LinkedNode actualList = fromArray(new Integer[]{0, 1, 2, 3});
        assertEquals(3, getFromLast(actualList, 0));
    }

    @Test
    public void getFromLastRecursiveLastElementTest() {
        LinkedNode actualList = fromArray(new Integer[]{0, 1, 2, 3});
        assertEquals(3, getFromLastRecursive(actualList, 0));
    }

    @Test
    public void getFromLastMiddleElementTest() {
        LinkedNode actualList = fromArray(new Integer[]{0, 1, 2, 3, 4});
        assertEquals(2, getFromLast(actualList, 2));
    }

    @Test
    public void getFromLastRecursiveMiddleElementTest() {
        LinkedNode actualList = fromArray(new Integer[]{0, 1, 2, 3, 4});
        assertEquals(2, getFromLastRecursive(actualList, 2));
    }

    @Test
    public void getFromLastIndexOutOfBoundsExceptionTest() {
        LinkedNode actualList = fromArray(new Integer[]{0, 1, 2, 3, 4, 5});
        try {
            getFromLast(actualList, 6);
            fail("Error: IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException expectedError) {
            // no op. IndexOutOfBoundsException expected.
        }
    }

    @Test
    public void getFromLastRecursiveIndexOutOfBoundsExceptionTest() {
        LinkedNode actualList = fromArray(new Integer[]{0, 1, 2, 3, 4, 5});
        try {
            getFromLastRecursive(actualList, 6);
            fail("Error: IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException expectedError) {
            // no op. IndexOutOfBoundsException expected.
        }
    }

    /* ************************************************************************************************************** */

    @Test
    public void deleteMiddleNodeTest() {
        LinkedNode actualList = fromArray(new Integer[]{1, 2, 3});
        deleteMiddleNode(actualList.tail);
        LinkedNode expectedList = fromArray(new Integer[]{1, 3});
        assertEquals(expectedList, actualList);
    }

    /* ************************************************************************************************************** */

    @Test
    public void partitionListTest() {

        LinkedNode list = fromArray(new Integer[]{3, 5, 8, 5, 10, 2, 1});
        Integer partition = 5;

        LinkedNode actualList = partitionList(list, partition);

        LinkedNode expectedList = fromArray(new Integer[]{3, 2, 1, 10, 5, 8, 5});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void partitionListOneElementLeftTest() {
        LinkedNode list = fromArray(new Integer[]{1});
        Integer partition = 5;

        LinkedNode actualList = partitionList(list, partition);

        LinkedNode expectedList = fromArray(new Integer[]{1});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void partitionListOneElementRightTest() {
        LinkedNode list = fromArray(new Integer[]{1});
        Integer partition = 0;

        LinkedNode actualList = partitionList(list, partition);

        LinkedNode expectedList = fromArray(new Integer[]{1});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void partitionListOneElementPartitionTest() {
        LinkedNode list = fromArray(new Integer[]{1});
        Integer partition = 1;

        LinkedNode actualList = partitionList(list, partition);

        LinkedNode expectedList = fromArray(new Integer[]{1});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void partitionListTwoElementsLeftTest() {
        LinkedNode list = fromArray(new Integer[]{1, 2});
        Integer partition = 5;

        LinkedNode actualList = partitionList(list, partition);

        LinkedNode expectedList = fromArray(new Integer[]{1, 2});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void partitionListTwoElementsRightTest() {
        LinkedNode list = fromArray(new Integer[]{1, 2});
        Integer partition = 0;

        LinkedNode actualList = partitionList(list, partition);

        LinkedNode expectedList = fromArray(new Integer[]{2, 1});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void partitionListTwoElementsLeftRightTest() {
        LinkedNode list = fromArray(new Integer[]{1, 3});
        Integer partition = 2;

        LinkedNode actualList = partitionList(list, partition);

        LinkedNode expectedList = fromArray(new Integer[]{1, 3});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void partitionListTwoElementsRightLeftTest() {
        LinkedNode list = fromArray(new Integer[]{3, 1});
        Integer partition = 2;

        LinkedNode actualList = partitionList(list, partition);

        LinkedNode expectedList = fromArray(new Integer[]{1, 3});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void partitionListThreeElementsRightPartitionLeftTest() {
        LinkedNode list = fromArray(new Integer[]{3, 2, 1});
        Integer partition = 2;

        LinkedNode actualList = partitionList(list, partition);

        LinkedNode expectedList = fromArray(new Integer[]{1, 2, 3});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void partitionListThreeElementsLeftPartitionRightTest() {
        LinkedNode list = fromArray(new Integer[]{1, 2, 3});
        Integer partition = 2;

        LinkedNode actualList = partitionList(list, partition);

        LinkedNode expectedList = fromArray(new Integer[]{1, 3, 2});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void partitionListMultipleElementTest() {
        LinkedNode list = fromArray(new Integer[]{11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3});
        Integer partition = 5;

        LinkedNode actualList = partitionList(list, partition);

        LinkedNode expectedList = fromArray(new Integer[]{2, 3, 4, 1, 2, 3, 10, 9, 8, 7, 6, 5, 11});
        assertEquals(expectedList, actualList);
    }

    /* ************************************************************************************************************** */

    @Test
    public void isPalindromeOneElementTest() {
        LinkedNode list = fromArray(new Integer[]{1});
        assertTrue(isPalindrome(list));
    }

    @Test
    public void isPalindromeTrueTwoElementsTest() {
        LinkedNode list = fromArray(new Integer[]{1, 1});
        assertTrue(isPalindrome(list));
    }

    @Test
    public void isPalindromeTrueThreeElementsTest() {
        LinkedNode list = fromArray(new Integer[]{1, 2, 1});
        assertTrue(isPalindrome(list));
    }

    @Test
    public void isPalindromeTrueFourElementsTest() {
        LinkedNode list = fromArray(new Integer[]{1, 2, 2, 1});
        assertTrue(isPalindrome(list));
    }

    @Test
    public void isPalindromeFalseTwoElementsTest() {
        LinkedNode list = fromArray(new Integer[]{1, 2});
        assertFalse(isPalindrome(list));
    }

    @Test
    public void isPalindromeFalseThreeElementsTest() {
        LinkedNode list = fromArray(new Integer[]{1, 2, 3});
        assertFalse(isPalindrome(list));
    }

    @Test
    public void isPalindromeFalseFourElementsTest() {
        LinkedNode list = fromArray(new Integer[]{1, 2, 1, 1});
        assertFalse(isPalindrome(list));
    }

}
