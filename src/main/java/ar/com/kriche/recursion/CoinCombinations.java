/**
 * @author Kriche 2020
 */
package ar.com.kriche.recursion;

import java.util.*;

public class CoinCombinations {

    /**
     * @param amount positive
     * @param coins  non null array of positive values
     * @return the combinations of coins summing amount
     */
    public static Set<List<Integer>> computeCoinCombinations(int amount, Integer[] coins) {

        Set<List<Integer>> combinations = new HashSet<>();

        if (amount == 0) {
            return combinations;
        }

        for (int coin : coins) {
            int remainder = amount - coin;
            if (remainder > 0) {
                Set<List<Integer>> subCombinations = computeCoinCombinations(remainder, coins);
                subCombinations.forEach(c -> {
                    c.add(coin);
                    Collections.sort(c);
                });
                combinations.addAll(subCombinations);
            } else if (remainder == 0) {
                List<Integer> combination = new ArrayList<>();
                combination.add(coin);
                combinations.add(combination);
            }
        }

        return combinations;

    }

}
