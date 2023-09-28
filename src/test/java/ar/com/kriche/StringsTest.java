package ar.com.kriche;

import org.junit.jupiter.api.Test;

import static ar.com.kriche.Strings.*;
import static org.junit.jupiter.api.Assertions.*;


/**
 * @author Kriche
 */
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
        assertTrue(oneAway("",""));
        assertTrue(oneAway("abc","abc"));
        assertTrue(oneAway("abc","atc"));
        assertTrue(oneAway("abc","abcd"));
        assertTrue(oneAway("abc","aebc"));
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

}
