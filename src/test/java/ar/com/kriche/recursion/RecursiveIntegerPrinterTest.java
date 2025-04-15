package ar.com.kriche.recursion;

import org.junit.jupiter.api.Test;

import static ar.com.kriche.recursion.RecursiveIntegerPrinter.printNum;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Kriche
 */
public class RecursiveIntegerPrinterTest {

    @Test
    public void printNumTest() {
        final int min = -5000000;
        final int max = -min;
        for (int i = min; i <= max; i++) {
            assertEquals(String.valueOf(i), printNum(i));
        }
    }

}