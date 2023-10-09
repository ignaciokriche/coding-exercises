package ar.com.kriche;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author Kriche
 */
public class MemoryArithmeticTest {

    private static final int X = 4;
    private static final int Y = 3;
    private static final int Z = 5;
    private static final int T = 9;

    @Test
    public void memoryArithmeticTest() {

        MemoryArithmetic<Integer> actualArrayRecursive = new MemoryArithmetic<Integer>(X, Y, Z, T);
        MemoryArithmetic<Integer> actualArrayIterative = new MemoryArithmetic<Integer>(X, Y, Z, T);

        System.out.println("Loading arrays...");

        int expectedValue = 1;
        for (int x = 0; x < X; x++)
            for (int y = 0; y < Y; y++)
                for (int z = 0; z < Z; z++)
                    for (int t = 0; t < T; t++) {
                        System.out.println("setting coordinate (" + x + "," + y + "," + z + "," + t + ") to store: " + expectedValue + ".");
                        actualArrayRecursive.setValueAtRecursive(expectedValue, x, y, z, t);
                        actualArrayIterative.setValueAtIterative(expectedValue, x, y, z, t);
                        expectedValue++;
                    }

        System.out.println("Verifying arrays...");

        int actualValueRecursive, actualValueIterative;
        expectedValue = 1;
        for (int x = 0; x < X; x++)
            for (int y = 0; y < Y; y++)
                for (int z = 0; z < Z; z++)
                    for (int t = 0; t < T; t++) {
                        System.out.println("expecting coordinate (" + x + "," + y + "," + z + "," + t + ") to be: " + expectedValue + ".");
                        actualValueRecursive = actualArrayRecursive.getValueAtRecursive(x, y, z, t);
                        actualValueIterative = actualArrayIterative.getValueAtIterative(x, y, z, t);
                        if (!(actualValueRecursive == actualValueIterative && expectedValue == actualValueRecursive))
                            fail("Error: memory arithmetic failure. expected: " +
                                    expectedValue + "; iterative: " + actualValueIterative + "; recursive: " + actualValueRecursive + ";");
                        expectedValue++;
                    }

        System.out.println("All good ;)");

    }

}