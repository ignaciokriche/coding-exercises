/**
 * @author Kriche
 */

package ar.com.kriche.recursion;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PowerSet {

    /**
     * @param set not null
     * @return the power set.
     */
    public static Set<Set<Integer>> powerSet(Set<Integer> set) {

        Set<Set<Integer>> powerSet = new HashSet<>();

        if (set.isEmpty()) {
            powerSet.add(set);
            return powerSet;
        }

        Integer element = set.iterator().next();
        Set<Integer> subSetWithoutElement = getSubSetWithoutElement(set, element);
        Set<Set<Integer>> powerSetSubSetWithoutElement = powerSet(subSetWithoutElement);
        Set<Set<Integer>> powerSetSubSetWithElement = addElementToAll(powerSetSubSetWithoutElement, element);

        powerSet.addAll(powerSetSubSetWithoutElement);
        powerSet.addAll(powerSetSubSetWithElement);

        return powerSet;
    }

    private static Set<Set<Integer>> addElementToAll(Set<Set<Integer>> set, Integer element) {
        return set.stream().map(s -> {
            Set<Integer> p = new HashSet<>(s);
            p.add(element);
            return p;
        }).collect(Collectors.toSet());
    }

    private static Set<Integer> getSubSetWithoutElement(Set<Integer> set, Integer element) {
        return set.stream().filter(e -> !e.equals(element)).collect(Collectors.toSet());
    }

}
