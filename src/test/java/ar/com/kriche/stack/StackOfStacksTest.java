package ar.com.kriche.stack;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Kriche
 */
public class StackOfStacksTest {

    @Test
    public void StackOfStacksCapacity1Test() {

        StackOfStacks theTested = new StackOfStacks(1);
        final Integer first = 1;
        final Integer second = 2;
        final Integer third = 3;

        theTested.push(first);
        theTested.push(second);
        assertSame(second, theTested.peek());
        theTested.push(third);

        assertSame(third, theTested.pop());
        assertSame(second, theTested.pop());
        assertSame(first, theTested.pop());
        assertTrue(theTested.empty());
    }

    @Test
    public void StackOfStacksCapacity2Test() {

        StackOfStacks theTested = new StackOfStacks(2);
        final Integer first = 1;
        final Integer second = 2;
        final Integer third = 3;

        theTested.push(first);
        theTested.push(second);
        assertSame(second, theTested.peek());
        theTested.push(third);

        assertSame(third, theTested.pop());
        assertSame(second, theTested.pop());
        assertSame(first, theTested.pop());
        assertTrue(theTested.empty());
    }

    @Test
    public void StackOfStacksCapacity3Test() {

        StackOfStacks theTested = new StackOfStacks(3);
        final Integer first = 1;
        final Integer second = 2;
        final Integer third = 3;
        final Integer fourth = 4;

        theTested.push(first);
        theTested.push(second);
        assertSame(second, theTested.peek());
        theTested.push(third);
        theTested.push(fourth);

        assertSame(fourth, theTested.pop());
        assertSame(third, theTested.pop());
        assertSame(second, theTested.pop());
        assertSame(first, theTested.pop());
        assertTrue(theTested.empty());

    }

    @Test
    public void StackOfStacksPushPopTest() {

        final int size = 100;
        final int stackCapacity = 7;
        StackOfStacks theTested = new StackOfStacks(stackCapacity);

        assertTrue(theTested.empty());

        Integer items[] = Stream.iterate(1, i -> i + 1).limit(size).toArray(Integer[]::new);
        // add all the numbers:
        for (int i = 0; i < size; i++) {
            theTested.push(items[i]);
        }

        // check all the numbers:
        for (int i = size - 1; i >= 0; i--) {
            assertSame(items[i], theTested.pop());
        }
        assertTrue(theTested.empty());

    }

    @Test
    public void StackOfStacksPopAtTest() {

        final int size = 100;
        final int stackCapacity = 7;

        StackOfStacks theTested = new StackOfStacks(stackCapacity);

        assertTrue(theTested.empty());

        Integer items[] = Stream.iterate(1, i -> i + 1).limit(size).toArray(Integer[]::new);

        // add all the numbers:
        for (int i = 0; i < size; i++) {
            theTested.push(items[i]);
        }

        // get the top number from stack 2 (from the bottom):
        int stackIndex = 2;
        Integer expected = 21;
        assertSame(expected, theTested.popAt(stackIndex));

        while (--expected > 0) {
            assertSame(expected, theTested.pop());
        }

        assertTrue(theTested.empty());

    }

}