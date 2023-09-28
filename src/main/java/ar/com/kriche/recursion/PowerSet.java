package ar.com.kriche.recursion;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Kriche
 */
public class PowerSet {

    public static Set<Set<Integer>> powerSet(Set<Integer> set) {

        if (set.isEmpty()) {
            Set<Set<Integer>> powerSet = new HashSet<>();
            powerSet.add(set);
            return powerSet;
        }

        Integer element = set.iterator().next();
        Set<Integer> subSetWithoutElement = getSubSetWithoutElement(set, element);
        Set<Set<Integer>> powerSetSubSetWithoutElement = powerSet(subSetWithoutElement);
        Set<Set<Integer>> powerSetSubSetWithElement = addElementToAll(powerSetSubSetWithoutElement, element);

        Set<Set<Integer>> powerSet = new HashSet<>();
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
