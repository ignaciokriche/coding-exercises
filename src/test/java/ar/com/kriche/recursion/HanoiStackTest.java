package ar.com.kriche.recursion;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Kriche
 */
public class HanoiStackTest {

    @Test
    public void hanoiZeroDiskTest() throws IOException {
        hanoiTest(0);
    }

    @Test
    public void hanoiOneDiskTest() throws IOException {
        hanoiTest(1);
    }

    @Test
    public void hanoiTwoDisksTest() throws IOException {
        hanoiTest(2);
    }

    @Test
    public void hanoiThreeDisksTest() throws IOException {
        hanoiTest(3);
    }

    @Test
    public void hanoiManyDisksTest() throws IOException {
        for (int d = 4; d <= 11; d++) {
            hanoiTest(d);
        }
    }

    /**
     * Compares actual hanoi (iterative solution) against expected hanoi (recursive solution) for the given number
     * of disks.
     *
     * @param disks
     * @throws IOException
     */
    private void hanoiTest(int disks) throws IOException {

        // setup:

        PipedReader reader = new PipedReader();
        PipedWriter writer = new PipedWriter();
        reader.connect(writer);

        PipedReader readerExpected = new PipedReader();
        PipedWriter writerExpected = new PipedWriter();
        readerExpected.connect(writerExpected);

        Thread hanoiExpectedThread = new Thread(() -> {
            try {
                new HanoiExpected(writerExpected).hanoi(disks, "ini", "temp", "end");
                writerExpected.close();
            } catch (Exception e) {
                // don't care about errors here. The test will fail anyway.
                throw new Error(e);
            }
        });

        Thread hanoiThread = new Thread(() -> {
            try {
                new HanoiStack(writer).hanoi(disks, "ini", "temp", "end");
                writer.close();
            } catch (Exception e) {
                // don't care about errors here. The test will fail anyway.
                throw new Error(e);
            }
        });

        // exercise:
        hanoiThread.start();

        // verify:

        hanoiExpectedThread.start();

        try (BufferedReader lineReader = new BufferedReader(reader);
             BufferedReader lineReaderExpected = new BufferedReader(readerExpected)) {

            String expectedMove = lineReaderExpected.readLine();
            String actualMove = lineReader.readLine();
            while (expectedMove != null && actualMove != null) {
                assertEquals(expectedMove, actualMove);
                expectedMove = lineReaderExpected.readLine();
                actualMove = lineReader.readLine();
            }

            // test all the movements were done:
            assertNull(expectedMove);
            assertNull(actualMove);
        }

    }

    /**
     * Using the well known recursive solution for testing only.
     */
    private static class HanoiExpected {

        private final Writer out;

        public HanoiExpected(Writer out) {
            this.out = out;
        }

        public void hanoi(int n, String ini, String temp, String finish) throws IOException {
            if (n == 0) {
                return;
            }
            hanoi(n - 1, ini, finish, temp);
            out.write("move disk: " + n + " from " + ini + " to " + finish + ".\n");
            hanoi(n - 1, temp, ini, finish);
        }

    }

}
