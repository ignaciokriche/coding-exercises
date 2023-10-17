/**
 * Prints a histogram, such as:
 * <p>
 * #        #
 * #        #              #
 * #        #        #     #
 * #     #  #        #     #  #
 * #     #  #  #     #     #  #
 * #  #  #  #  #     #     #  #
 * #  #  #  #  #     #     #  #  #
 * #  #  #  #  #     #  #  #  #  #
 *
 * @author Kriche
 */
package ar.com.kriche;

import java.util.Arrays;

public class PrintHistogram {

    public static void main(String[] args) {

        int[] columns = {8, 3, 5, 8, 4, 0, 6, 1, 7, 5, 2};

        System.out.println("Histogram:\n");
        printHistogram(columns, Arrays.stream(columns).max().getAsInt());
        System.out.println();

    }

    private static void printHistogram(int[] values, int maxHeight) {
        for (int r = maxHeight; r > 0; r--) {
            for (int c = 0; c < values.length; c++) {
                int value = values[c];
                if (value >= r) {
                    System.out.print(" # ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}

