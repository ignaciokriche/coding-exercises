package ar.com.kriche.recursion;

/**
 * Write a recursive method to multiply two positive integers without using the * operator.
 *
 * @author Kriche
 */
public class Multiply {

    /**
     * @param n positive integer
     * @param m positive integer
     * @return n * m
     */
    public static int multiply(int n, int m) {
        if (m == 1) {
            return n;
        }
        return multiplyRecursive(n, m);
    }


    /**
     * @param n positive integer
     * @param m positive integer
     * @return n * m
     */
    private static int multiplyRecursive(int n, int m) {
        if (n == 1) {
            return m;
        }
        return m + multiplyRecursive(n - 1, m);
    }

}
