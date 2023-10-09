package ar.com.kriche;

import org.junit.jupiter.api.Test;

import static ar.com.kriche.SumDigits.sumDigits;
import static ar.com.kriche.SumDigits.sumDigitsRecursive;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Kriche 2020
 */
public class SumDigitsTest {

    @Test
    public void emptySumTest() {
        assertEquals(0, sumDigits(""));
    }

    @Test
    public void oneDigitSumTest() {
        assertEquals(9, sumDigits("9"));
    }

    @Test
    public void twoDigitsSumTest() {
        assertEquals(8, sumDigits("98"));
    }

    @Test
    public void multipleDigitsSumTest() {
        assertEquals(3, sumDigits("123456"));
        assertEquals(5, sumDigits("14522"));
    }

    @Test
    public void emptySumRecursivelyTest() {
        assertEquals(0, sumDigitsRecursive(""));
    }

    @Test
    public void oneDigitSumRecursivelyTest() {
        assertEquals(9, sumDigitsRecursive("9"));
    }

    @Test
    public void twoDigitsSumRecursivelyTest() {
        assertEquals(8, sumDigitsRecursive("98"));
    }

    @Test
    public void multipleDigitsSumRecursivelyTest() {
        assertEquals(3, sumDigitsRecursive("123456"));
        assertEquals(5, sumDigitsRecursive("14522"));
    }

}