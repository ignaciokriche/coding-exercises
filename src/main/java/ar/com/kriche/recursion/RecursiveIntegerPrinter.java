package ar.com.kriche.recursion;

/**
 * prints an Integer into a String.
 *
 * @author kriche
 */
public class RecursiveIntegerPrinter {

    /**
     * @param number
     */
    public static String printNum(int number) {
        StringBuilder out = new StringBuilder();
        long longNumber = number;
        if (longNumber < 0) {
            out.append("-");
            longNumber = longNumber * -1;
        }
        printNum(longNumber, out);
        return out.toString();
    }

    public static void printNum(long number, StringBuilder out) {
        if (number < 10) {
            out.append(number);
        } else {
            printNum(number / 10, out);
            printNum(number % 10, out);
        }
    }

}
