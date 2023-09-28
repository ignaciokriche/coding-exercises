package ar.com.kriche.recursion;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static ar.com.kriche.recursion.PowerSet.powerSet;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Kriche
 */
public class PowerSetTest {

    @Test
    public void powerSetEmptyTest() {

        Set<Integer> empty = Set.of();

        Set<Set<Integer>> actual = powerSet(empty);

        Set<Set<Integer>> expected = Set.of(empty);
        assertEquals(expected, actual);
    }

    @Test
    public void powerSetOneElementTest() {

        Integer elem = 1;
        Set<Integer> oneElemSet = Set.of(elem);

        Set<Set<Integer>> actual = powerSet(oneElemSet);

        Set<Set<Integer>> expected = Set.of(Set.of(), Set.of(elem));
        assertEquals(expected, actual);
    }

    @Test
    public void powerSetTwoElementsTest() {

        Integer elem1 = 1;
        Integer elem2 = elem1 + 1;
        Set<Integer> inputSet = Set.of(elem1, elem2);

        Set<Set<Integer>> actual = powerSet(inputSet);

        Set<Set<Integer>> expected = Set.of(Set.of(), Set.of(elem1), Set.of(elem2), Set.of(elem1, elem2));
        assertEquals(expected, actual);
    }

    @Test
    public void powerSetThreeElementsTest() {

        Integer elem1 = 1;
        Integer elem2 = elem1 + 1;
        Integer elem3 = elem2 + 1;

        Set<Integer> inputSet = Set.of(elem1, elem2, elem3);

        Set<Set<Integer>> actual = powerSet(inputSet);

        Set<Set<Integer>> expected = Set.of(
                Set.of(), Set.of(elem1), Set.of(elem2), Set.of(elem3),
                Set.of(elem1, elem2), Set.of(elem1, elem3),
                Set.of(elem2, elem3),
                Set.of(elem1, elem2, elem3));

        assertEquals(expected, actual);
    }

    @Test
    public void powerSetFourElementsTest() {

        Integer elem1 = 1;
        Integer elem2 = elem1 + 1;
        Integer elem3 = elem2 + 1;
        Integer elem4 = elem3 + 1;

        Set<Integer> inputSet = Set.of(elem1, elem2, elem3, elem4);

        Set<Set<Integer>> actual = powerSet(inputSet);

        Set<Set<Integer>> expected = Set.of(
                Set.of(),
                Set.of(elem1), Set.of(elem2), Set.of(elem3), Set.of(elem4),
                Set.of(elem1, elem2), Set.of(elem1, elem3), Set.of(elem1, elem4), Set.of(elem2, elem3), Set.of(elem2, elem4), Set.of(elem3, elem4),
                Set.of(elem1, elem2, elem3), Set.of(elem1, elem2, elem4), Set.of(elem1, elem3, elem4), Set.of(elem2, elem3, elem4),
                Set.of(elem1, elem2, elem3, elem4));

        assertEquals(expected, actual);

    }


}