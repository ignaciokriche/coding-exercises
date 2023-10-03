package ar.com.kriche;

/**
 * Given a number of pairs of braces: {} print all possible balanced combinations.
 * 
 * For example:
 * If pairs == 1
 *  {} is the only valid combination.
 * 
 * If pairs == 2
 *  {}{}
 *  {{}}
 * are the only valid combinations.
 * 
 *
 * @author Kriche 2020
 * 
 */
public class BallancedBraces {

    public static void main(String[] args) {
        int numberOfPairs = 3;
        System.out.println("Combinations:\n");
        int countCombinations = printBalancedBraces(numberOfPairs);
        System.out.println("\nTotal number of combinations: " + countCombinations + " for " + numberOfPairs + " pairs.\n");
    }

    public static int printBalancedBraces(int numberOfPairs) {
        return printBalancedBraces("", 0, 0, numberOfPairs);
    }

    private static int printBalancedBraces(String combinations, int leftCount, int rightCount, int numberOfPairs) {
        
        /**
         * This is a non-trivial problem!
         * One trick here is to realize that as soon as put a closing brace '}' (aka right brace) that has no preceding opening
         * brace '{' (aka left brace) then the combination becomes irremediably unbalanced. In other words, as long as the amount
         * closing braces is less or equal than the amount of opening braces then the combination can be balanced.
         * 
         * https://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/
         */

        if (rightCount == numberOfPairs) {
            /* base case: no more pairs available.
             * note that at this point
             * leftCount is also == numberOfPairs
             * because right <= left 
             */
            System.out.println("\t" + combinations + "\n");
            return 1;
        }

        int count = 0;

        // as long as '{' count is less than the number of pairs then we can keep adding '{':
        if (leftCount < numberOfPairs) {
            count = printBalancedBraces(combinations + " { ", leftCount + 1, rightCount, numberOfPairs);
        }

        // as long as '}' count is less than the number of '{' then we can keep adding '}':
        if (rightCount < leftCount) {
            count += printBalancedBraces(combinations + " } ", leftCount, rightCount + 1, numberOfPairs);
        }

        return count;

    }

}
