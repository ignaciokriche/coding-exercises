/**
 * String related exercises.
 *
 * @author Kriche
 */

package ar.com.kriche;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class Strings {

    /**
     * @return if str has all unique characters.
     */
    public static boolean isUnique(@NotNull String str) {
        Set<Character> chars = str.chars().mapToObj(intValue -> (char) intValue).collect(Collectors.toSet());
        return str.length() == chars.size(); // only if all chars are unique then lengths will be equal.
    }

    /**
     * @param words a string containing words (separated by a ' ').
     * @return a string with the words in reverse order.
     * Example:
     * hello world
     * world hello
     */
    public static String reverseWords(@NotNull String words) {

        char[] wordsArray = words.toCharArray();

        // first reverse the string as a whole:
        reverse(wordsArray, 0, wordsArray.length);

        // then reverse each word:
        int left = 0, right = 0;
        for (; right < wordsArray.length; right++) {
            if (wordsArray[right] == ' ') {
                reverse(wordsArray, left, right);
                left = right + 1;
            }
        }
        reverse(wordsArray, left, right);

        return String.valueOf(wordsArray);
    }

    /**
     * @param chars
     * @param beginIndex the beginning index, inclusive.
     * @param endIndex   the ending index, exclusive.
     */
    private static void reverse(char[] chars, int beginIndex, int endIndex) {
        for (int left = beginIndex, right = endIndex - 1; left < right; left++, right--) {
            char aux = chars[left];
            chars[left] = chars[right];
            chars[right] = aux;
        }
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
        // we need to pair all the letters (except at most for one, eg "aba")
        // once a pair is formed we can remove it:
        Set<Character> visited = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (visited.contains(ch)) {
                // remove the pair
                visited.remove(ch);
            } else {
                // add the char to form a pair later
                visited.add(ch);
            }
        }

        // there could be a most 1 char unpaired:
        return visited.size() <= 1;
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


    /**
     * @param words
     * @return the length of the last word. a word is a string with no ' ' character.
     */
    public static int lastWordLength(@NotNull String words) {
        words = words.trim(); // avoids error with strings such as "hello     "
        int lastSpaceIndex = words.lastIndexOf(' ');
        return lastSpaceIndex == -1 ? words.length() : words.length() - lastSpaceIndex - 1;
    }

    /**
     * @param words
     * @return words grouped together by anagram, this is word1 and word2 will be in the same set only if
     * word1 and word2 are anagrams.
     */
    public static Set<Set<String>> groupAnagrams(@NotNull Set<String> words) {
        Map<String, Set<String>> grouped = new HashMap<>();
        words.forEach(w -> {
            // we need a function f(w) = k such as f(w1) = f(w2) only if w1 is an anagram of w2.
            // this function will be the key for our map of anagrams.
            // since an anagram of a word is a permutation of the word letters, we can sort the letters of the word and
            // that will give us the function we are looking for.
            String sorted = sortChars(w);
            Set<String> anagramGroup = grouped.get(sorted);
            if (anagramGroup == null) {
                anagramGroup = new HashSet<>();
                grouped.put(sorted, anagramGroup);
            }
            anagramGroup.add(w);
        });
        return grouped.values().stream().collect(Collectors.toSet());
    }

    private static String sortChars(@NotNull String w) {
        char[] chars = w.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars).intern();
    }

    /**
     * @param str
     * @return all str substrings.
     */
    public static Set<String> subStrings(@NotNull String str) {
        Set<String> subStrings = new HashSet<>();
        for (int lh = 0; lh < str.length(); lh++) {
            for (int rh = lh; rh < str.length(); rh++) {
                subStrings.add(str.substring(lh, rh + 1));
            }
        }
        return subStrings;
    }

    /**
     * @param str
     * @param substr      cannot be empty.
     * @param overlapping
     * @return the amount of times substr is present in str.
     */
    public static int substringCount(@NotNull String str, @NotNull String substr, boolean overlapping) {

        if (substr.isEmpty()) {
            throw new IllegalArgumentException("substring cannot be empty.");
        }
        if (str.length() < substr.length()) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (substr.length() > str.length() - i) {
                break;
            }
            if (str.substring(i, i + substr.length()).equals(substr)) {
                count++;
                if (!overlapping) {
                    i += substr.length() - 1;
                }
            }
        }
        return count;
    }

    /**
     * @param str
     * @return the length of the longest substring without repeating characters.
     */
    public static int longestSubStrNoDupCharsLength(String str) {
        if (str == null) {
            return -1;
        }
        return longestSubStrNoDupCharsLength(str, str.length());
    }

    /**
     * @param str
     * @param maxLimit substrings of bigger length will be ignored. A negative value means no limit.
     * @return the length of the longest substring without repeating characters and no greater than maxLength.
     */
    public static int longestSubStrNoDupCharsLength(String str, final int maxLimit) {

        if (str == null) {
            return -1;
        }

        int maxFound = 0, currentMax = 0;
        int left = 0;
        Set<Character> visited = new HashSet<>();

        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            if (visited.contains(ch)) {
                char leftCh;
                do {
                    leftCh = str.charAt(left++);
                    visited.remove(leftCh);
                    currentMax--;
                } while (ch != leftCh);
            }
            currentMax++;
            maxFound = maxLimited(currentMax, maxFound, maxLimit);
            visited.add(ch);
        }

        return maxFound;

    }

    /**
     * @param currentMax
     * @param oldMax     cannot be greater than limit.
     * @param limit
     * @return the biggest value between oldMax and currentMax provided this value is no greater than limit or
     * limit is negative. oldMax, otherwise.
     */
    private static int maxLimited(int currentMax, int oldMax, int limit) {
        if (limit < 0 || currentMax <= limit) {
            return currentMax > oldMax ? currentMax : oldMax;
        }
        return oldMax;
    }

    /**
     * @param compressed a string with the format:
     *                   str = letters
     *                   str = [str]
     *                   str = number[str]
     *                   where number indicates the positive amount of times to expand the value between brackets.
     *                   number can be omitted, which means to expand only once.
     *                   <p>
     *                   Examples:
     *                   "2[ab]" -> "abab"
     *                   "ab" -> "ab"
     *                   "2[ab]d3[k]2[m]g2[ob]" -> "ababdkkkmmgobob"
     *                   "3[abc2[de]]" -> "abcdedeabcdedeabcdede"
     *                   "3[abc2[de]o2[qw]]" -> "abcdedeoqwqwabcdedeoqwqwabcdedeoqwqw
     * @return the expanded form of the string.
     */
    public static String expandStr(@NotNull String compressed) {
        String repeatNumber = "";
        StringBuilder expanded = new StringBuilder();
        for (int i = 0; i < compressed.length(); i++) {
            char ch = compressed.charAt(i);
            if (Character.isDigit(ch)) {
                repeatNumber += ch;
            } else {
                if (ch == ']') {
                    throw new IllegalArgumentException(String.format("unexpected ']' at index: %d", i));
                }
                if (ch == '[') {
                    int right = findClosingBracket(compressed, i + 1);
                    if (right < 0) {
                        throw new IllegalArgumentException("unterminated expression");
                    }
                    String innerExpanded = expandStr(compressed.substring(i + 1, right));
                    if (repeatNumber.isEmpty()) {
                        expanded.append(innerExpanded);
                    } else {
                        expanded.append(innerExpanded.repeat(Integer.valueOf(repeatNumber)));
                    }
                    repeatNumber = "";
                    i = right;
                } else {
                    // is a letter:
                    expanded.append(ch);
                }
            }
        }
        return expanded.toString();
    }

    private static int findClosingBracket(@NotNull String str, int left) {
        int balance = 1;
        for (int i = left; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (ch == '[') {
                balance++;
            } else if (ch == ']') {
                balance--;
            }
            if (balance == 0) {
                return i;
            }
        }
        return -1;
    }

}
