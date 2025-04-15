package ar.com.kriche;

import org.junit.jupiter.api.Test;

import static ar.com.kriche.MergeSortedLists.mergeSortedLists;
import static ar.com.kriche.Node.createList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeSortedListsTest {

    @Test
    public void mergeSortedListsTest() {

        Node list1 = createList(1, 7, 9, 9, 10, 15, 33, 48, 73);
        Node list2 = createList(6, 9, 11, 22, 29, 31, 70);

        Node merged = mergeSortedLists(list1, list2);

        assertEquals(createList(1, 6, 7, 9, 9, 9, 10, 11, 15, 22, 29, 31, 33, 48, 70, 73), merged);

    }

}
