package ar.com.kriche;


/**
 * @author Kriche 2020
 */
public class MergeSortedLists {

    public static Node mergeSortedLists(Node head1, Node head2) {

        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        Node merged, previous;

        if (head1.value <= head2.value) {
            previous = head1;
            head1 = head1.next;
        } else {
            previous = head2;
            head2 = head2.next;
        }
        merged = previous;

        while (head1 != null && head2 != null) {
            if (head1.value <= head2.value) {
                previous.next = head1;
                previous = head1;
                head1 = head1.next;
            } else {
                previous.next = head2;
                previous = head2;
                head2 = head2.next;
            }
        }

        if (head1 == null) {
            previous.next = head2;
        } else {
            previous.next = head1;
        }

        return merged;

    }

}

class Node {

    int value;
    Node next;

    static Node createList(Integer... numbers) {

        if (numbers == null || numbers.length == 0) {
            return null;
        }

        Node head = new Node();

        if (numbers.length >= 1) {
            head.value = numbers[0];
        }

        Node previous = head;
        for (int i = 1; i < numbers.length; i++) {
            Node node = new Node();
            node.value = numbers[i];
            previous.next = node;
            previous = node;
        }
        previous.next = null;

        return head;
    }

    @Override
    public boolean equals(Object other) {

        if (this == other) {
            return true;
        }

        if (!(other instanceof Node)) {
            return false;
        }

        Node otherNode = (Node) other;
        if (value != otherNode.value) {
            return false;
        }
        if (next == null) {
            return otherNode.next == null;
        }
        return next.equals(otherNode.next);
    }

    @Override
    public int hashCode() {
        return value;
    }
}
