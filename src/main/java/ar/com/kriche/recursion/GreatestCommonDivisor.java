/**
 * The Euclidean algorithm is based on the principle that the greatest common divisor of two numbers does not change if
 * the larger number is replaced by its difference with the smaller number.
 * A more efficient method is a variant in which the difference of the two numbers a and b is replaced by the
 * remainder of the Euclidean division (also called division with remainder) of a by b.
 *
 * @author Kriche
 */
package ar.com.kriche.recursion;

public class GreatestCommonDivisor {

    public static int computeGreatestCommonDivisor(int a, int b) {
        if (b == 0) {
            return a;
        }
        return computeGreatestCommonDivisor(b, a % b);
    }
    
}
