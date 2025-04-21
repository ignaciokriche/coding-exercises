package ar.com.kriche;

import org.junit.jupiter.api.Test;

import static ar.com.kriche.RemoveZeros.removeRedundantZeros;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Kriche 2025
 */
public class RemoveZerosTest {

    @Test
    public void removeRedundantZerosTest() {
        assertEquals(null, removeRedundantZeros(null));
        assertEquals("", removeRedundantZeros(""));
        assertEquals("123", removeRedundantZeros("123"));
        assertEquals("123", removeRedundantZeros("123.000"));
        assertEquals("123.456", removeRedundantZeros("123.456"));
        assertEquals("123.456", removeRedundantZeros("123.45600"));
        assertEquals("123.456001", removeRedundantZeros("123.456001"));
        assertEquals("123.456001", removeRedundantZeros("123.4560010"));
        assertEquals("1230", removeRedundantZeros("1230"));
        assertEquals("100", removeRedundantZeros("100"));
        assertEquals("0", removeRedundantZeros("0.0"));
        assertEquals("", removeRedundantZeros("."));
        assertEquals("", removeRedundantZeros(".0"));
        assertEquals("0.121001", removeRedundantZeros("0.121001"));
        assertEquals(".121001", removeRedundantZeros(".121001"));
        assertEquals("10.11", removeRedundantZeros("10.110"));
    }

}