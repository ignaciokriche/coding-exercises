package ar.com.kriche;

/**
 * You are given a string of numeric digits such as "123456"
 * your goal is to write a method to sum each digit from left to right and
 * if the sum has more than 2 digits then you first need to sum those digits
 * until only one digit is left, and then you keep moving.
 * <p>
 * AKA binary root?
 * <p>
 * For the example above: "123456"
 * 1 + 2 + 3 + 4 = 10
 * 1 + 0 = 1
 * 1 + 5 = 6
 * 6 + 6 = 12
 * 1 + 2 = 3
 * then sumDigits("123456") = 3
 * <p>
 * For: "99"
 * 9 + 9 = 18
 * 1 + 8 = 9
 * then sumDigits("99") = 9
 * <p>
 * For: "14522"
 * 1 + 4 + 5 = 10
 * 1 + 0 = 1
 * 1 + 2 = 3
 * 3 + 2 = 5
 * <p>
 * then sumDigits("14522") = 5
 *
 * @author Kriche 2020
 */
public class SumDigits {

    /**
     * @param numbers
     * @return the one digit sum
     */
    public static int sumDigits(String numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length(); i++) {
            sum += Integer.parseInt("" + numbers.charAt(i));
            if (sum > 9) {
                sum = sum - 9;
            }
        }
        return sum;
    }

    /**
     * @param numbers
     * @return the one digit sum
     */
    public static int sumDigitsRecursive(String numbers) {

        if (numbers.length() == 0) {
            return 0;
        }

        if (numbers.length() == 1) {
            return Integer.parseInt("" + numbers.charAt(0));
        }

        // the 2 base cases above are quite easy. How can we move toward the base case?
        // get the first 2 digits and add them together
        // whatever you get cannot be bigger than the original number:
        // first + second <= first * 10 + second
        // because first and second are both >= 0
        // so put it at the left of your string and recurse!
        int first = Integer.parseInt("" + numbers.charAt(0));
        int second = Integer.parseInt("" + numbers.charAt(1));
        return sumDigitsRecursive((first + second) + numbers.substring(2));
    }
    
}
