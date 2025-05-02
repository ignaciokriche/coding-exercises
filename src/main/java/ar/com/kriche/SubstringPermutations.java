package ar.com.kriche;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a smaller string s and a bigger string b, design an algorithm to find all permutations
 * of the shorter string within the longer one. Return the location of each permutation.
 *
 * @author Kriche 2025
 */
public class SubstringPermutations {

    /**
     * @param s not null or empty and smaller than b.
     * @param b not null or empty and bigger than s.
     * @return the location of each permutation of s in b.
     */
    public static List<Integer> findPermutations(String s, String b) {

        HashMap<Character, Integer> sValueCount = new HashMap<>();
        HashMap<Character, Integer> bValueCount = new HashMap<>();
        List<Integer> locations = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            increaseCounter(s.charAt(i), sValueCount);
            increaseCounter(b.charAt(i), bValueCount);
        }

        // permutation found if all chars are the same (and with the same count):
        if (sValueCount.equals(bValueCount)) {
            locations.add(0);
        }

        for (int i = s.length(); i < b.length(); i++) {

            // remove the left char from bValueCount:
            decreaseCounter(b.charAt(i - s.length()), bValueCount);

            // add the right char to bValueCount:
            increaseCounter(b.charAt(i), bValueCount);

            // permutation found if all chars are the same (and with the same count):
            if (sValueCount.equals(bValueCount)) {
                locations.add(i - s.length() + 1);
            }

        }

        return locations;
    }

    private static void increaseCounter(Character ch, HashMap<Character, Integer> countMap) {
        Integer value = countMap.get(ch);
        if (value == null) {
            countMap.put(ch, 1);
        } else {
            countMap.put(ch, value + 1);
        }
    }

    private static void decreaseCounter(Character ch, HashMap<Character, Integer> countMap) {
        int value = countMap.get(ch);
        if (value == 1) {
            countMap.remove(ch);
        } else {
            countMap.put(ch, value - 1);
        }
    }

}
