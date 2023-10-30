/**
 * @author Kriche
 */

package ar.com.kriche.recursion;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static ar.com.kriche.recursion.CoinCombinations.computeCoinCombinations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CoinCombinationsTest {

    @Test
    void noCombinationTest() {

        int amount = 21;
        Integer[] coins = new Integer[]{2, 10};

        Set<List<Integer>> combinations = computeCoinCombinations(amount, coins);

        assertTrue(combinations.isEmpty());
    }

    @Test
    void combinationsTest() {

        int amount = 21;
        Integer[] coins = new Integer[]{2, 5, 10};

        Set<List<Integer>> combinations = computeCoinCombinations(amount, coins);

        Set<List<Integer>> expected =
                Set.of(
                        List.of(2, 2, 2, 2, 2, 2, 2, 2, 5),
                        List.of(2, 2, 2, 5, 10),
                        List.of(2, 2, 2, 5, 5, 5)
                );

        assertEquals(expected, combinations);

    }

}
