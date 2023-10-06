package ar.com.kriche;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumPairsTest {

    @Test
    public void sumPairsTest() {

        int numbers[] = {1, 3, 4, 6, 3, 7, 10, 0, 9, -2};
        int sum = 7;

        List<Pair> pairs = SumPairs.sumPairs(numbers, sum);

        List<Pair> expected = List.of(new Pair(3, 4), new Pair(1, 6), new Pair(7, 0), new Pair(9, -2));
        assertEquals(expected, pairs);

    }

    @Test
    public void sumPairsDuplicatedTest() {

        int numbers[] = {1, 3, 4, 3, 4, 6, 3, 7, 10, 0, 0, 7, 7};
        int sum = 7;

        List<Pair> pairs = SumPairs.sumPairs(numbers, sum);

        List<Pair> expected = List.of(new Pair(3, 4), new Pair(3, 4), new Pair(1, 6), new Pair(7, 0), new Pair(0, 7));
        assertEquals(expected, pairs);

    }

}
