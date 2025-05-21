package ar.com.kriche.list;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Lists related exercises.
 *
 * @author Kriche
 */
public class Lists {

    /**
     * @author Kriche
     * For simplicity, the node class is defined in here:
     */
    public static class LinkedNode {

        public LinkedNode tail;
        public Integer value;

        private LinkedNode() {
        }

        public static LinkedNode fromArray(Integer[] values) {
            if (values == null || values.length == 0) {
                return null;
            }
            return fromArray(values, 0);
        }

        private static LinkedNode fromArray(Integer[] values, int index) {
            if (index == values.length) {
                return null;
            }
            LinkedNode list = new LinkedNode();
            list.value = values[index];
            list.tail = fromArray(values, index + 1);
            return list;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            LinkedNode that = (LinkedNode) o;
            return Objects.equals(value, that.value) && Objects.equals(tail, that.tail);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, tail);
        }

        @Override
        public String toString() {
            return value + (tail != null ? " -> " + tail : "");
        }

    }

    /**
     * remove duplicates from a linked list.
     * How would you solve this problem if a temporary buffer is not allowed?
     */
    public static void removeDuplicates(LinkedNode head) {
        LinkedNode current, previous;
        while (head != null) {
            previous = head;
            current = previous.tail;
            while (current != null) {
                if (Objects.equals(head.value, current.value)) {
                    // skip current
                    previous.tail = current.tail;
                } else {
                    previous = current;
                }
                current = current.tail;
            }
            head = head.tail;
        }
    }

    /**
     * remove duplicates from a linked list.
     * How would you solve this problem if a temporary buffer is not allowed?
     */
    public static void removeDuplicatesRecursive(LinkedNode list) {
        if (list != null) {
            // remove all the nodes equal to list.value:
            list.tail = removeNodesRecursive(list.tail, list.value);
            // remove all duplicates in the sublist:
            removeDuplicatesRecursive(list.tail);
        }
    }

    /**
     * @return a list where value has been removed.
     */
    private static LinkedNode removeNodesRecursive(LinkedNode list, final Integer value) {
        if (list == null) {
            return null;
        }
        if (Objects.equals(value, list.value)) {
            // skip current value from the list to return
            return removeNodesRecursive(list.tail, value);
        }
        list.tail = removeNodesRecursive(list.tail, value);
        return list;
    }

    /**
     * find the kth to last element of a singly linked list.
     */
    public static Integer getFromLast(@NotNull LinkedNode list, int index) {

        LinkedNode kthToLast = list;
        while (kthToLast.tail != null && index > 0) {
            kthToLast = kthToLast.tail;
            index--;
        }
        if (index > 0) {
            throw new IndexOutOfBoundsException();
        }

        while (kthToLast.tail != null) {
            kthToLast = kthToLast.tail;
            list = list.tail;
        }

        return list.value;

    }

    /**
     * find the kth to last element of a singly linked list.
     */
    public static Integer getFromLastRecursive(@NotNull LinkedNode list, int index) {
        LinkedNodeFromLast linkedNodeFromLast = getFromLastRecursiveHelper(list, index);
        if (linkedNodeFromLast.indexFromLast < index) {
            throw new IndexOutOfBoundsException();
        }
        return linkedNodeFromLast.node.value;
    }

    private static class LinkedNodeFromLast {
        public int indexFromLast;
        public LinkedNode node;
    }

    private static LinkedNodeFromLast getFromLastRecursiveHelper(@NotNull LinkedNode list, final int index) {

        LinkedNodeFromLast linkedNodeFromLast;
        if (list.tail == null) {
            linkedNodeFromLast = new LinkedNodeFromLast();
        } else {
            linkedNodeFromLast = getFromLastRecursiveHelper(list.tail, index);
            linkedNodeFromLast.indexFromLast++;
        }

        if (linkedNodeFromLast.indexFromLast == index) {
            linkedNodeFromLast.node = list;
        }

        return linkedNodeFromLast;
    }

    /**
     * deletes a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) of a
     * singly linked list, given only access to that node.
     */
    public static void deleteMiddleNode(@NotNull LinkedNode node) {
        node.value = node.tail.value;
        node.tail = node.tail.tail;
    }

    /**
     * Partition: Write code to partition a linked list around a value x, such that all nodes less than x come before
     * all nodes greater than or equal to x. If x is contained within the list, the values of x only need to be
     * after the elements less than x (see below). The partition element x can appear anywhere in
     * the "right partition"; it does not need to appear between the left and right partitions.
     * <p>
     * Example:
     * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition=5]
     * Output: 3 -> 2 -> 1 -> 10 -> 5 -> 8 -> 5
     */
    public static LinkedNode partitionList(@NotNull LinkedNode list, Integer partition) {

        // create a left and right list and move the nodes to them accordingly.
        // then link the right list to the end of the left list.
        // the left list will be the partitioned list.

        LinkedNode leftPartitionHead = null, leftPartitionLast = null;
        LinkedNode rightPartitionHeadReversed = null;
        LinkedNode currentNode = list;
        LinkedNode nextNode;
        while (currentNode != null) {
            nextNode = currentNode.tail;

            if (compareNullSafe(currentNode.value, partition) < 0) {
                // add current node to left partition list:
                currentNode.tail = null;
                if (leftPartitionHead == null) {
                    leftPartitionHead = currentNode;
                } else {
                    leftPartitionLast.tail = currentNode;
                }
                leftPartitionLast = currentNode;

            } else {
                // add current node to the head of the right partition list:
                currentNode.tail = rightPartitionHeadReversed;
                rightPartitionHeadReversed = currentNode;
            }
            currentNode = nextNode;
        }

        if (leftPartitionHead != null) {
            if (rightPartitionHeadReversed != null) {
                leftPartitionLast.tail = rightPartitionHeadReversed;
            }
            return leftPartitionHead;
        }
        return rightPartitionHeadReversed;
    }

    private static int compareNullSafe(Integer a, Integer b) {
        if (a == b) {
            return 0;
        }
        if (a == null) {
            return -1;
        }
        if (b == null) {
            return 1;
        }
        return a.compareTo(b);
    }

    /**
     * @return true if a linked list is a palindrome. false otherwise.
     */
    public static boolean isPalindrome(@NotNull LinkedNode list) {

        LinkedNode reversedList = null;
        LinkedNode listHead = list;
        int listLenght = 0;

        while (list != null) {
            LinkedNode aux = new LinkedNode();
            aux.value = list.value;
            aux.tail = reversedList;
            reversedList = aux;

            list = list.tail;
            listLenght++;
        }

        list = listHead;

        while (listLenght-- / 2 > 0) {
            if (compareNullSafe(list.value, reversedList.value) != 0) {
                return false;
            }
            list = list.tail;
            reversedList = reversedList.tail;
        }

        return true;
    }

}
