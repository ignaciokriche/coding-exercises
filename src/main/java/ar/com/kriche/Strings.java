package ar.com.kriche;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

/**
 * String related exercises.
 *
 * @author Kriche
 */
public class Strings {

    /**
     * @return if str has all unique characters.
     */
    public static boolean isUnique(@NotNull String str) {
        Set<Character> chars = str.chars().mapToObj(intValue -> (char) intValue).collect(Collectors.toSet());
        return str.length() == chars.size(); // only if all chars are unique then lengths will be equal.
    }

    /**
     * What if you cannot use additional data structures?
     *
     * @return if str has all unique characters.
     */
    public static boolean isUniqueNoDataStructures(@NotNull String str) {
        // search each char to the right:
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                if (ch == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Given two strings, write a method to decide if one is a permutation of the other.
     *
     * @return true if str1 is a permutation of str2.
     */
    public static boolean checkPermutation(@NotNull String str1, @NotNull String str2) {

        if (str1 == str2) {
            return true;
        }

        List<Character> list1 = str1.chars()
                .mapToObj(intValue -> (char) intValue).collect(Collectors.toCollection(ArrayList::new));
        List<Character> list2 = str2.chars()
                .mapToObj(intValue -> (char) intValue).collect(Collectors.toCollection(ArrayList::new));

        if (list1.size() != list2.size()) {
            return false;
        }

        list1.forEach(ch -> {
            // remove ONLY the first occurrence, if present.
            list2.remove(ch);
        });

        return list2.isEmpty();
    }

    /**
     * Write a method to replace all spaces in a string with '%20'.
     * You may assume that the string has sufficient space at the end to hold the additional characters, and that you
     * are given the "true" length of the string.
     */
    public static String urlifyNoRegEx(@NotNull String str) {
        if (str.isEmpty()) {
            return str;
        }
        String first = str.substring(0, 1).replace(" ", "%20");
        return first + urlifyNoRegEx(str.substring(1, 1));
    }

    /**
     * Write a method to replace all spaces in a string with '%20'.
     * You may assume that the string has sufficient space at the end to hold the additional characters, and that you
     * are given the "true" length of the string.
     */
    public static String urlifyStringBuilder(@NotNull String str) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(ch);
            }

        }
        return stringBuilder.toString();
    }

    /**
     * Write a method to replace all spaces in a string with '%20'.
     * You may assume that the string has sufficient space at the end to hold the additional characters, and that you
     * are given the "true" length of the string.
     */
    public static void urlifyArray(@NotNull char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == ' ') {
                System.arraycopy(chars, i, chars, i + 1, 2);
                chars[i] = '%';
                chars[i + 1] = '2';
                chars[i + 2] = '0';
                i += 2;
            }
        }
    }

    /**
     * Write a method to replace all spaces in a string with '%20'.
     * You may assume that the string has sufficient space at the end to hold the additional characters, and that you
     * are given the "true" length of the string.
     */
    public static String urlifyRegEx(@NotNull String str) {
        return str.replaceAll(" ", "%20");
    }

    /**
     * Check if a string is a permutation of a palindrome.
     * Example:
     * Input: tactcoa
     * Output: true
     *
     * @return true only if str is a permutation of a palindrome.
     */
    public static boolean palindromePermutation(@NotNull String str) {

        // we need to check if a palindrome can be built using str characters.
        if (str.isEmpty()) {
            return true;
        }

        // to build a palindrome, for each letter we need another one to keep symmetry:
        // if we put one 'x' to the left then we balance by adding other 'x' to the right.
        // there could only at most be one letter in the middle with no match and in this case the total length of the
        // string will be odd.

        Map<Character, Integer> charCount = new HashMap<>();
        str.chars().mapToObj(intValue -> (char) intValue).forEach(ch -> {
            Integer count = charCount.get(ch);
            count = count == null ? 1 : count + 1;
            charCount.put(ch, count);
        });

        if (str.length() % 2 == 0) {
            // there must not be any char with count odd
            return charCount.values().stream().noneMatch(count -> count % 2 == 1);
        }
        // there could be at most 1 char with count odd
        return charCount.values().stream().filter(count -> count % 2 == 1).count() < 2;
    }

    /**
     * There are three types of edits that can be performed on strings:
     * insert a character, remove a character, or replace a character.
     * Given two strings, write a function to check if they are one edit (or zero edits) away.
     *
     * @return true only if str1 is 0 or 1 edit away from str2.
     */
    public static boolean oneAway(@NotNull String str1, @NotNull String str2) {

        if (str1 == str2) {
            return true;
        }

        int diffCount = 0;
        switch (str1.length() - str2.length()) {
            case 0:
                // same length there could be at most 1 char diff:
                for (int i = 0; i < str1.length(); i++) {
                    if (str1.charAt(i) != str2.charAt(i)) {
                        if (diffCount++ > 0) {
                            return false;
                        }
                    }
                }
                return true;

            case -1:
                // str1 is one char smaller than str2 then swap and fall into the next case.
                String aux = str1;
                str1 = str2;
                str2 = aux;

            case 1:
                // str1 is one char bigger than str2 then there must be exactly one difference:
                for (int i = 0, j = 0; j < str2.length(); i++) {
                    if (str1.charAt(i) != str2.charAt(j)) {
                        if (diffCount++ > 0) {
                            return false;
                        }
                    } else {
                        j++;
                    }
                }
                return true;
            default:
                // any other case then there are more than one edit away.
                return false;
        }

    }

    /**
     * Implement a method to perform basic string compression using the counts of repeated characters.
     * For example, the string aabcccccaaa would become a2b1c5a3,
     * If the "compressed" string would not become smaller than the original string, your method should
     * return the original string.
     * You can assume the string has only uppercase and lowercase letters (a - z).
     *
     * @return the compressed string if shorter, str otherwise.
     */
    public static String compress(@NotNull String str) {

        if (str.length() <= 2) {
            return str;
        }

        StringBuilder compressed = new StringBuilder();
        char current, next;
        int counter = 1;

        next = ' '; // to avoid not initialized error.

        for (int i = 0; i < str.length() - 1; i++) {
            current = str.charAt(i);
            next = str.charAt(i + 1);
            if (current == next) {
                counter++;
            } else {
                compressed.append(current);
                compressed.append(counter);
                counter = 1;
            }
        }

        compressed.append(next);
        compressed.append(counter);

        return compressed.length() < str.length() ? compressed.toString() : str;

    }

}
