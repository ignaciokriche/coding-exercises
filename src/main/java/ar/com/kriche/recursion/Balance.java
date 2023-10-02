package ar.com.kriche.recursion;

import java.util.Arrays;

public class Balance {

    public static void main(String[] args) {

        int amount = 4;
        int[] weights = {3, 5,};
        System.out.println("is measurable: " + amount + " by weights: " + Arrays.toString(weights) +  " ? ---> " +
                           isMeasurable(amount, weights, weights.length));
    }

    private static boolean isMeasurable(int amount, int[] weights, int length) {

        if (length == 0) {
            return false;
        }

        int currentWeight = weights[length - 1];
        int diff = amount - currentWeight;

        if (diff == 0) {
            return true;
        }

        return isMeasurable(Math.abs(diff), weights, length - 1) ||
               isMeasurable(amount, weights, length - 1);

    }

}
