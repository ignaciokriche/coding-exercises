package ar.com.kriche;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ar.com.kriche.SubstringPermutations.findPermutations;

/**
 * @author Kriche 2025
 */
public class SubstringPermutationsTest {

    @Test
    public void findPermutationsTest() {

        List<Integer> permutations = findPermutations("abc", "abcd");
        Assertions.assertEquals(List.of(0), permutations);

        permutations = findPermutations("abc", "icba");
        Assertions.assertEquals(List.of(1), permutations);

        permutations = findPermutations("abc", "cbaabc");
        Assertions.assertEquals(List.of(0, 3), permutations);

        permutations = findPermutations("abc", "abeioucba");
        Assertions.assertEquals(List.of(6), permutations);

        permutations = findPermutations("abbc", "cbabadcbbabbcbabaabccbabc");
        Assertions.assertEquals(List.of(0, 6, 9, 11, 12, 20, 21), permutations);

    }

}
