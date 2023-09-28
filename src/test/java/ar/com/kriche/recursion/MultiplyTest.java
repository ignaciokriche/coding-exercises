package ar.com.kriche.recursion;

import org.junit.jupiter.api.Test;

import static ar.com.kriche.recursion.Multiply.multiply;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Kriche
 */
public class MultiplyTest {

    @Test
    public void multiplyNeutralityTest() {
        int n = 1;
        int m = 8;
        assertEquals(m, multiply(n, m));
    }

    @Test
    public void multiplyCommutativityTest() {
        int n = 3;
        int m = 8;
        int expected = n * m;
        assertEquals(expected, multiply(n, m));
        assertEquals(expected, multiply(m, n));
    }

    @Test
    public void multiplyTest() {
        for (int n = 1; n < 100; n++) {
            for (int m = 1; m < 100; m++) {
                assertEquals(n * m, multiply(n, m));
            }
        }
    }

}