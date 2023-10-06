/*
 * Given an integer array `arr` and an integer `k`,
 * find the pairs of elements in the array whose sum is k.
 *
 * Examples:
 *      arr = [1, 3, 4, 6, 3, 7, 10, 0, 9, -2];
 *      k = 7;
 *      response: ((3, 4), (1, 6), (7, 0), (9, -2));
 *
 *      arr = [1, 3, 4, 3, 4, 6, 3, 7, 10, 0, 0, 7, 7, 9, -2];
 *      k = 7;
 *      response: ((3, 4), (3, 4), (1, 6), (7, 0), (0, 7));
 *
 * @author Kriche
 */

package ar.com.kriche;

import java.util.*;

public class SumPairs {

    public static List<Pair> sumPairs(int[] numbers, int sum) {

        List<Pair> pairs = new ArrayList<>(numbers.length / 2);
        Set<Integer> complements = new HashSet<>(numbers.length / 2);

        for (int n : numbers) {
            int complement = sum - n;
            if (complements.contains(complement)) {
                // we got a pair that sums sum
                pairs.add(new Pair(complement, n));
                // remove the complement so it is not used again:
                complements.remove(complement);
            } else {
                complements.add(n);
            }

        }

        return pairs;
    }

}


class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
