/**
 * @author Kriche
 */

package ar.com.kriche;


import java.util.HashMap;
import java.util.Map;

public class MostFrequentNumbers {

    /**
     * @param numbers
     * @param k
     * @return an array containing the k-th most frequent numbers in numbers.
     */
    public static int[] mostFrequentNumbers(int[] numbers, int k) {
        if (k <= 0) {
            return new int[]{};
        }
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int n : numbers) {
            Integer f = frequency.get(n);
            if (f == null) {
                frequency.put(n, 1);
            } else {
                frequency.put(n, f + 1);
            }
        }
        return frequency.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
