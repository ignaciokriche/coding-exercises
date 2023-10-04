package ar.com.kriche.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates the permutations of a text in 2 slightly different ways.
 *
 * @author Kriche
 */
public class Permutations {

    private static final String WORD = "zero";

    public static void main(String[] args) {

        System.out.print("Permutations of \"" + WORD + "\" first approach:\n\t");
        System.out.println(listPermutations(WORD));
        System.out.println();

        System.out.print("Permutations of \"" + WORD + "\" second approach:\n\t[");
        printPermutations("", WORD);
        System.out.print("]\n\n");

    }

    /**
     * @param word
     * @return a list with all the permutations or the given word.
     */
    public static List<String> listPermutations(String word) {

        List<String> permutations = new ArrayList<String>();

        // implicit base case: empty word, an empty list is returned.
        if (word.length() == 1) {
            // base case: a word with one character, return a list with just that word.
            permutations.add(word);
            return permutations;
        }

        // concatenate each character in word to the permutations of the rest of the characters:
        for (int t = 0; t < word.length(); ++t) {
            char currentCh = word.charAt(t);
            for (String currentPermutation : listPermutations(removeCharAt(word, t))) {
                permutations.add(currentCh + currentPermutation);
            }
        }

        return permutations;

    }

    /**
     * Prints prefix concatenating it to the permutations of word.
     *
     * @param prefix
     * @param word
     */
    public static void printPermutations(String prefix, String word) {

        if (word.equals("")) {
            // base case: word is empty so there are no permutations, just print prefix
            System.out.print(prefix + ", ");
        }

        // for each char in word, start by concatenating it to prefix and 
        // recursively deal with the rest of the chars:
        for (int t = 0; t < word.length(); ++t) {
            printPermutations(prefix + word.charAt(t), removeCharAt(word, t));
        }

    }

    private static String removeCharAt(String str, int i) {
        return str.substring(0, i) + str.substring(i + 1);
    }

}
