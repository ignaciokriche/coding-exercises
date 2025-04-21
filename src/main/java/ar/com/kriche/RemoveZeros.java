package ar.com.kriche;

/**
 * @author Kriche 2025
 */
public class RemoveZeros {

    /**
     * @param number must be a valid decimal number.
     * @return the equivalent number removing redundant '0' digits.
     */
    public static String removeRedundantZeros(String number) {

        if (number == null) {
            return null;
        }

        // first find the position of the '.' char:
        int decimalPlace = 0;
        while (decimalPlace < number.length()) {
            if (number.charAt(decimalPlace) == '.') {
                break;
            }
            decimalPlace++;
        }

        // so far from beginning up to decimalPlace we sure need.
        // let's now look for first nonzero char from right to left:
        int rightMostNonZero = number.length() - 1;
        while (rightMostNonZero > decimalPlace) {
            if (number.charAt(rightMostNonZero) != '0') {
                break;
            }
            rightMostNonZero--;
        }

        if (rightMostNonZero > -1 && number.charAt(rightMostNonZero) == '.') {
            return number.substring(0, rightMostNonZero);
        }
        return number.substring(0, rightMostNonZero + 1);

    }

}
