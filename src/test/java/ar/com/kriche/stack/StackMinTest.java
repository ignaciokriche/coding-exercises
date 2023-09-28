package ar.com.kriche.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Kriche
 */
public class StackMinTest {

    @Test
    public void getMinTest() {
        StackMin theTested = new StackMin();
        theTested.push(2);
        assertEquals(2, theTested.getMin());
        theTested.push(1);
        assertEquals(1, theTested.getMin());
        theTested.push(3);
        assertEquals(1, theTested.getMin());
        theTested.push(-1);
        assertEquals(-1, theTested.getMin());
        theTested.push(-1);
        assertEquals(-1, theTested.getMin());
        theTested.push(5);
        assertEquals(-1, theTested.getMin());
        theTested.push(-3);
        assertEquals(-3, theTested.getMin());
        theTested.push(8);
        assertEquals(-3, theTested.getMin());
    }
}