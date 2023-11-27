/**
 * @author Kriche
 */

package ar.com.kriche;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;

import static ar.com.kriche.Strings.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringsTest {

    @Test
    public void isUniqueTest() {
        assertTrue(isUnique(""));
        assertTrue(isUnique(" "));
        assertTrue(isUnique("a"));
        assertTrue(isUnique("ab"));
        assertTrue(isUnique("abc"));
        assertTrue(isUnique("aA"));
        assertTrue(isUnique(" abcd0123ABC.#$"));

        assertFalse(isUnique("aa"));
        assertFalse(isUnique("aba"));
        assertFalse(isUnique("  "));
        assertFalse(isUnique(" abcd0123ABC.#$ "));
    }

    @Test
    public void isUniqueNoDataStructuresTest() {
        assertTrue(isUniqueNoDataStructures(""));
        assertTrue(isUniqueNoDataStructures(" "));
        assertTrue(isUniqueNoDataStructures("a"));
        assertTrue(isUniqueNoDataStructures("ab"));
        assertTrue(isUniqueNoDataStructures("abc"));
        assertTrue(isUniqueNoDataStructures("aA"));
        assertTrue(isUniqueNoDataStructures(" abcd0123ABC.#$"));

        assertFalse(isUniqueNoDataStructures("aa"));
        assertFalse(isUniqueNoDataStructures("aba"));
        assertFalse(isUniqueNoDataStructures("  "));
        assertFalse(isUniqueNoDataStructures(" abcd0123ABC.#$ "));
    }

    @Test
    public void checkPermutationTest() {
        assertTrue(checkPermutation("", ""));
        assertTrue(checkPermutation(" ", " "));
        assertTrue(checkPermutation("a", "a"));
        assertTrue(checkPermutation("ab", "ab"));
        assertTrue(checkPermutation("ab", "ba"));
        assertTrue(checkPermutation("abc", "cba"));
        assertTrue(checkPermutation("abcd", "adbc"));
        assertTrue(checkPermutation("abcd0123 .!#", "#!. 3210dcba"));

        assertFalse(checkPermutation("a", "aa"));
        assertFalse(checkPermutation("aa", "a"));
        assertFalse(checkPermutation("01", "ab"));
        assertFalse(checkPermutation("01", "012"));
    }

    @Test
    public void urlifyTest() {
        assertEquals("", urlifyNoRegEx(""));
        assertEquals("", urlifyStringBuilder(""));
        urlifyArray(new char[]{});
        assertEquals("", urlifyRegEx(""));
    }

    @Test
    public void palindromePermutationTest() {

        assertTrue(palindromePermutation("tactcoa"));

        assertTrue(palindromePermutation(""));
        assertTrue(palindromePermutation("t"));
        assertTrue(palindromePermutation("tt"));
        assertTrue(palindromePermutation("tta"));
        assertTrue(palindromePermutation("t1t2a3a123"));
        assertTrue(palindromePermutation("t1t2a3a1233"));
        assertTrue(palindromePermutation("t1t2a3a12333"));
        assertTrue(palindromePermutation("t1t2a3a1234"));

        assertFalse(palindromePermutation("tta1"));
        assertFalse(palindromePermutation("t1t2a3a122"));
        assertFalse(palindromePermutation("t1t2a3a12233"));
        assertFalse(palindromePermutation("t1t2a3a12234"));
    }

    @Test
    public void oneAwayTest() {
        assertTrue(oneAway("", ""));
        assertTrue(oneAway("abc", "abc"));
        assertTrue(oneAway("abc", "atc"));
        assertTrue(oneAway("abc", "abcd"));
        assertTrue(oneAway("abc", "aebc"));
    }

    @Test
    public void compressTest() {

        assertEquals("a2b1c5a3", compress("aabcccccaaa"));

        assertEquals("", compress(""));
        assertEquals("a", compress("a"));
        assertEquals("aa", compress("aa"));
        assertEquals("abb", compress("abb"));
        assertEquals("a3", compress("aaa"));
        assertEquals("aaab", compress("aaab"));
        assertEquals("a3b2", compress("aaabb"));
        assertEquals("abcddddd", compress("abcddddd"));
        assertEquals("a1b1c1d6", compress("abcdddddd"));
        assertEquals("a1b2c3d4", compress("abbcccdddd"));
        assertEquals("a1b2c3d4a1b2c3b2a1", compress("abbcccddddabbcccbba"));
    }

    @Test
    public void lastWordLengthNoWordsTest() {
        assertEquals(0, lastWordLength(""));
        assertEquals(0, lastWordLength(" "));
        assertEquals(0, lastWordLength("  "));
        assertEquals(0, lastWordLength("   "));
    }

    @Test
    public void lastWordLengthOneWordTest() {
        assertEquals(3, lastWordLength("odd"));
        assertEquals(4, lastWordLength("even"));
        assertEquals(5, lastWordLength(" hello"));
        assertEquals(5, lastWordLength("hello "));
        assertEquals(5, lastWordLength(" hello "));
        assertEquals(5, lastWordLength("    hello   "));
    }

    @Test
    public void lastWordLengthManyWordsTest() {
        assertEquals(6, lastWordLength("hello world."));
        assertEquals(4, lastWordLength("the length of the last word is four"));
        assertEquals(1, lastWordLength("1 2 3 4 1"));
    }

    @Test
    public void groupAnagramsTest() {
        Set<String> words = Set.of("tea", "ate", "tab", "eta", "bat");
        Collection<Set<String>> actual = groupAnagrams(words);
        Set<Set<String>> expected = Set.of(Set.of("ate", "tea", "eta"), Set.of("tab", "bat"));
        assertEquals(expected, actual);
    }

    @Test
    public void subStringsTest() {
        assertEquals(Set.of(), subStrings(""));
        assertEquals(Set.of("a"), subStrings("a"));
        assertEquals(Set.of("a", "ab", "b"), subStrings("ab"));
        assertEquals(Set.of("a", "b", "c", "ab", "abc", "bc"), subStrings("abc"));
        assertEquals(Set.of("a", "b", "c", "ab", "abc", "bc", "d", "cd", "bcd", "abcd"), subStrings("abcd"));
    }

    @Test
    public void longestSubStringNoRepeatingCharsLengthNullTest() {
        assertEquals(-1, longestSubStrNoDupCharsLength(null));
    }

    @Test
    public void longestSubStringNoRepeatingCharsLengthEmptyTest() {
        assertEquals(0, longestSubStrNoDupCharsLength(""));
    }

    @Test
    public void longestSubStringNoRepeatingCharsLengthTest() {
        assertEquals(3, longestSubStrNoDupCharsLength("pwwkew"));
        assertEquals(1, longestSubStrNoDupCharsLength("a"));
        assertEquals(1, longestSubStrNoDupCharsLength("aa"));
        assertEquals(1, longestSubStrNoDupCharsLength("aaa"));
        assertEquals(2, longestSubStrNoDupCharsLength("ab"));
        assertEquals(3, longestSubStrNoDupCharsLength("abc"));
        assertEquals(2, longestSubStrNoDupCharsLength("aaabb"));
        assertEquals(4, longestSubStrNoDupCharsLength("aaabbcdeert"));
        assertEquals(7, longestSubStrNoDupCharsLength("abcdefg"));
        assertEquals(4, longestSubStrNoDupCharsLength("abcddcba"));
        assertEquals(8, longestSubStrNoDupCharsLength("aaaaioubcdebhjuy"));
        assertEquals(10, longestSubStrNoDupCharsLength("aaaaioubcdebhyokjuy"));
    }

    @Test
    public void longestSubStringNoRepeatingCharsLengthLimitedNullTest() {
        assertEquals(-1, longestSubStrNoDupCharsLength(null, -1));
        assertEquals(-1, longestSubStrNoDupCharsLength(null, 0));
        assertEquals(-1, longestSubStrNoDupCharsLength(null, 1));
    }

    @Test
    public void longestSubStringNoRepeatingCharsLengthLimitedEmptyTest() {
        assertEquals(0, longestSubStrNoDupCharsLength("", -1));
        assertEquals(0, longestSubStrNoDupCharsLength("", 0));
        assertEquals(0, longestSubStrNoDupCharsLength("", 1));
    }

    @Test
    public void longestSubStringNoRepeatingCharsLengthLimitedTest() {

        assertEquals(3, longestSubStrNoDupCharsLength("pwwkew", -1));
        assertEquals(2, longestSubStrNoDupCharsLength("pwwkew", 2));
        assertEquals(3, longestSubStrNoDupCharsLength("pwwkew", 3));
        assertEquals(3, longestSubStrNoDupCharsLength("pwwkew", 4));

        assertEquals(1, longestSubStrNoDupCharsLength("a", -1));
        assertEquals(0, longestSubStrNoDupCharsLength("a", 0));
        assertEquals(1, longestSubStrNoDupCharsLength("a", 1));
        assertEquals(1, longestSubStrNoDupCharsLength("a", 2));

        assertEquals(1, longestSubStrNoDupCharsLength("aa", -1));
        assertEquals(0, longestSubStrNoDupCharsLength("aa", 0));
        assertEquals(1, longestSubStrNoDupCharsLength("aa", 1));
        assertEquals(1, longestSubStrNoDupCharsLength("aa", 2));

        assertEquals(1, longestSubStrNoDupCharsLength("aaa", -1));
        assertEquals(0, longestSubStrNoDupCharsLength("aaa", 0));
        assertEquals(1, longestSubStrNoDupCharsLength("aaa", 1));
        assertEquals(1, longestSubStrNoDupCharsLength("aaa", 3));

        assertEquals(2, longestSubStrNoDupCharsLength("ab", -1));
        assertEquals(0, longestSubStrNoDupCharsLength("ab", 0));
        assertEquals(1, longestSubStrNoDupCharsLength("ab", 1));
        assertEquals(2, longestSubStrNoDupCharsLength("ab", 2));

        assertEquals(3, longestSubStrNoDupCharsLength("abc", -1));
        assertEquals(0, longestSubStrNoDupCharsLength("abc", 0));
        assertEquals(1, longestSubStrNoDupCharsLength("abc", 1));
        assertEquals(3, longestSubStrNoDupCharsLength("abc", 3));
        assertEquals(3, longestSubStrNoDupCharsLength("abc", 5));

        assertEquals(4, longestSubStrNoDupCharsLength("aaabbcdeert", -1));
        assertEquals(0, longestSubStrNoDupCharsLength("aaabbcdeert", 0));
        assertEquals(3, longestSubStrNoDupCharsLength("aaabbcdeert", 3));
        assertEquals(4, longestSubStrNoDupCharsLength("aaabbcdeert", 5));

        assertEquals(7, longestSubStrNoDupCharsLength("abcdefg", -1));
        assertEquals(0, longestSubStrNoDupCharsLength("abcdefg", 0));
        assertEquals(4, longestSubStrNoDupCharsLength("abcdefg", 4));
        assertEquals(7, longestSubStrNoDupCharsLength("abcdefg", 9));

        assertEquals(4, longestSubStrNoDupCharsLength("abcddcba", -1));
        assertEquals(0, longestSubStrNoDupCharsLength("abcddcba", 0));
        assertEquals(3, longestSubStrNoDupCharsLength("abcddcba", 3));
        assertEquals(4, longestSubStrNoDupCharsLength("abcddcba", 10));

        assertEquals(8, longestSubStrNoDupCharsLength("aaaaioubcdebhjuy", -1));
        assertEquals(0, longestSubStrNoDupCharsLength("aaaaioubcdebhjuy", 0));
        assertEquals(5, longestSubStrNoDupCharsLength("aaaaioubcdebhjuy", 5));
        assertEquals(8, longestSubStrNoDupCharsLength("aaaaioubcdebhjuy", 8));
        assertEquals(8, longestSubStrNoDupCharsLength("aaaaioubcdebhjuy", 10));

        assertEquals(10, longestSubStrNoDupCharsLength("aaaaioubcdebhyokjuy", -1));
        assertEquals(0, longestSubStrNoDupCharsLength("aaaaioubcdebhyokjuy", 0));
        assertEquals(9, longestSubStrNoDupCharsLength("aaaaioubcdebhyokjuy", 9));
        assertEquals(10, longestSubStrNoDupCharsLength("aaaaioubcdebhyokjuy", 10));
        assertEquals(10, longestSubStrNoDupCharsLength("aaaaioubcdebhyokjuy", 11));

    }

    @Test
    public void expandStrNoCompressionTest() {
        assertEquals("ab", expandStr("ab"));
        assertEquals("ab", expandStr("[ab]"));
        assertEquals("ab", expandStr("1[ab]"));
        assertEquals("ab", expandStr("[[ab]]"));
        assertEquals("ab", expandStr("1[1[ab]]"));
    }

    @Test
    public void expandStrSequentialCompressionTest() {
        assertEquals("abab", expandStr("2[ab]"));
        assertEquals("ababccc", expandStr("2[ab]3[c]"));
        assertEquals("abccc", expandStr("[ab]3[c]"));
        assertEquals("abccc", expandStr("1[ab]3[c]"));
        assertEquals("ababdkkkmmgobob", expandStr("2[ab]d3[k]2[m]g2[ob]"));
    }

    @Test
    public void expandStrNestedCompressionTest() {
        assertEquals("abcdedeabcdedeabcdede", expandStr("3[abc2[de]]"));
        assertEquals("abcdepkepkepkdepkepkepkabcdepkepkepkdepkepkepkabcdepkepkepkdepkepkepk",
                expandStr("3[abc2[d3[e[pk]]]]"));
        assertEquals("abcdepkepkepkdepkepkepkabcdepkepkepkdepkepkepkabcdepkepkepkdepkepkepk",
                expandStr("3[abc2[d3[e1[pk]]]]"));
    }

    @Test
    public void expandStrSequentialNestedCompressionTest() {
        assertEquals("abcdedeoqwqwabcdedeoqwqwabcdedeoqwqw", expandStr("3[abc2[de]o2[qw]]"));
        assertEquals("pppgyzazazagyzazazapppgyzazazagyzazazapppgyzazazagyzazazapppgyzazazagyzazazapppgyzazazagyzaz" +
                        "azapppgyzazazagyzazazapppgyzazazagyzazazapppgyzazazagyzazazapppgyzazazagyzazazapppgyzazaz" +
                        "agyzazazapppgyzazazagyzazazapppgyzazazagyzazaza",
                expandStr("3[2[2[3[p]2[1[gy3[za]]]]]]"));
    }

    @Test
    public void maxSubArraySumTest() {
        assertArrayEquals(new int[]{}, maxSubArraySum(new int[]{}));
        assertArrayEquals(new int[]{-1}, maxSubArraySum(new int[]{-1}));
        assertArrayEquals(new int[]{1}, maxSubArraySum(new int[]{-1, 1}));
        assertArrayEquals(new int[]{1, 2}, maxSubArraySum(new int[]{-1, 1, 2}));
        assertArrayEquals(new int[]{1, 2}, maxSubArraySum(new int[]{2, -3, 1, 2, -1}));
        assertArrayEquals(new int[]{2}, maxSubArraySum(new int[]{2, -3, 1, -1, 1}));
        assertArrayEquals(new int[]{10, 1}, maxSubArraySum(new int[]{-10, 10, 1, -2}));
        assertArrayEquals(new int[]{9, 1}, maxSubArraySum(new int[]{-10, 9, 1, -2}));
        assertArrayEquals(new int[]{1, 9}, maxSubArraySum(new int[]{0, -11, 1, 9, -3, -2, 1, 1, -8}));
        assertArrayEquals(new int[]{4, -1, -2, 1, 5}, maxSubArraySum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
        assertArrayEquals(new int[]{-2}, maxSubArraySum(new int[]{-6, -3, -2, -8}));
        assertArrayEquals(new int[]{0}, maxSubArraySum(new int[]{-6, -3, -2, 0}));
    }

}
