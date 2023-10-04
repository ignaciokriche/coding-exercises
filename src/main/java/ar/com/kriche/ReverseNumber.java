package ar.com.kriche;

/**
 *
 * @author Kriche 2020
 */
public class ReverseNumber {

    public static void main(String[] args) {
        int number = 1234567;
        System.out.println("number:\t\t\t\t" + number);
        number = reverseNumber(number);
        System.out.println("reversed:\t\t\t" + number);
        number = reverseNumber(number);
        System.out.println("reversed back:\t\t" + number);
    }

    private static int reverseNumber(int number) {
        int reversed = 0;
        while (number > 0) {
            int digit = number % 10;
            number = number / 10;
            reversed = reversed * 10 + digit;
        }
        return reversed;
    }

}
