package ar.com.kriche.stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static ar.com.kriche.stack.SortStack.sortStack;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Kriche
 */
public class SortStackTest {

    @Test
    public void sortStackEmptyTest() {
        Stack<Integer> emptyStack = new Stack<>();
        sortStack(emptyStack);
        assertTrue(emptyStack.empty());
    }

    @Test
    public void sortStackOneElementTest() {

        Stack<Integer> stack = new Stack<>();
        stack.push(123);

        sortStack(stack);

        Stack<Integer> expected = new Stack<>();
        expected.push(123);

        assertEquals(expected, stack);

    }

    @Test
    public void sortStackTwoElementsTest() {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        sortStack(stack);

        Stack<Integer> expected = new Stack<>();
        expected.push(2);
        expected.push(1);

        assertEquals(expected, stack);

    }

    @Test
    public void sortStackThreeElementsTest() {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        sortStack(stack);

        Stack<Integer> expected = new Stack<>();
        expected.push(3);
        expected.push(2);
        expected.push(1);

        assertEquals(expected, stack);

    }

    @Test
    public void sortStackMultipleElementsTest() {

        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(1);
        stack.push(9);
        stack.push(8);
        stack.push(10);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(6);
        stack.push(4);
        stack.push(10);
        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(8);

        sortStack(stack);

        Stack<Integer> expected = new Stack<>();
        expected.push(10);
        expected.push(10);
        expected.push(9);
        expected.push(8);
        expected.push(8);
        expected.push(7);
        expected.push(6);
        expected.push(5);
        expected.push(4);
        expected.push(3);
        expected.push(3);
        expected.push(3);
        expected.push(3);
        expected.push(2);
        expected.push(1);

        assertEquals(expected, stack);

    }

}