package ar.com.kriche.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Kriche
 */
class RecursiveIntegerPrinterTest {

    @Test
    void printNumTest() {
        final int min = -5000000;
        final int max = -min;
        for (int i = min; i <= max; i++) {
            assertEquals(String.valueOf(i), RecursiveIntegerPrinter.printNum(i));
        }
    }

}