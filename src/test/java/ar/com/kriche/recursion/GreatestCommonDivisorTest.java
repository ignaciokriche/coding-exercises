/**
 * @author Kriche
 */

package ar.com.kriche.recursion;

import org.junit.jupiter.api.Test;

import static ar.com.kriche.recursion.GreatestCommonDivisor.computeGreatestCommonDivisor;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreatestCommonDivisorTest {

    @Test
    public void GreatestCommonDivisorTest() {

        assertEquals(0, computeGreatestCommonDivisor(0, 0));

        assertEquals(8, computeGreatestCommonDivisor(8, 0));
        assertEquals(8, computeGreatestCommonDivisor(0, 8));

        assertEquals(1, computeGreatestCommonDivisor(8, 1));
        assertEquals(1, computeGreatestCommonDivisor(1, 8));

        assertEquals(3, computeGreatestCommonDivisor(12, 3));
        assertEquals(3, computeGreatestCommonDivisor(3, 12));

        assertEquals(21, computeGreatestCommonDivisor(21, 84));

        assertEquals(41, computeGreatestCommonDivisor(82, 123));

        assertEquals(6, computeGreatestCommonDivisor(54, 24));

    }
}