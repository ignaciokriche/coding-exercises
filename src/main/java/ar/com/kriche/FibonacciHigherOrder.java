/**
 *
 * A Fibonacci sequence of order n is an integer sequence in which each term is the
 * sum of the previous n terms (except the first n terms in the sequence).
 *
 * Examples:
 *
 * The usual Fibonacci numbers are a Fibonacci sequence of order 2 (with first 2 terms: 0, 1):
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, ...
 *
 * If n is 3 and first 3 terms are 3, 2, 5 then the sequence will be:
 * 3, 2, 5, 10, 17, 32, 59, 108, 199, 366, 673, 1238, 2277, 4188, 7703, 14168, 26059, 47930, 88157, 162146, 298233, ...
 *
 * If n is 5 and first 5 terms are 1, 2, 3, 4, 5 then the sequence will be:
 * 1, 2, 3, 4, 5, 15, 29, 56, 109, 214, 423, 831, 1633, 3210, 6311, 12408, 24393, 47955, 94277, 185344, 364377, ...
 *
 * If n is 5 and first 5 terms are 0, 5, 1, 4, 8 then the sequence will be:
 * 0, 5, 1, 4, 8, 18, 36, 67, 133, 262, 516, 1014, 1992, 3917, 7701, 15140, 29764, 58514, 115036, 226155, 444609, ...
 * 
 */
package ar.com.kriche;

import java.util.*;

/**
 *
 * Calculates the Fibonacci sequence of a given order and initial terms.
 * This class demonstrates different implementations. 
 * 
 * @author Kriche 2020
 */
public class FibonacciHigherOrder {

    public static void main(String[] args) {

        System.out.println("Fibonacci of Higher Order N:\n");

        System.out.println("Fibonacci of order: 2 and initial terms: 0, 1:");
        for (int n = 0; n < 21; n++) {
            long nthTerm = fibonacciOrder(n, 0, 1);
            System.out.print(nthTerm + ", ");
        }
        System.out.println("...\n");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        System.out.println("Fibonacci of order: 3 and initial terms: 3, 2, 5:");
        for (int n = 0; n < 21; n++) {
            long nthTerm = fibonacciOrderRecursive(n, 3, 2, 5);
            System.out.print(nthTerm + ", ");
        }
        System.out.println("...\n");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        System.out.println("Fibonacci of order: 5 and initial terms: 1, 2, 3, 4, 5:");
        for (int n = 0; n < 21; n++) {
            long nthTerm = fibonacciOrderRecursiveCache(n, 1, 2, 3, 4, 5);
            System.out.print(nthTerm + ", ");
        }
        System.out.println("...\n");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Fibonacci of order: 5 and initial terms: 0, 5, 1, 4, 8:");
        for (int n = 0; n < 21; n++) {
            long nthTerm = fibonacciOrder(n, 0, 5, 1, 4, 8);
            System.out.print(nthTerm + ", ");
        }
        System.out.println("...\n");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }

    /**
     *
     * @param n the term index, 0 based.
     * @param initialTerms
     * @return the <code>n</code>-th term of the Fibonacci of order and initial terms given by <code>initialTerms</code>.
     */
    public static long fibonacciOrder(final int n, Integer... initialTerms) {

        // if the term asked is within the initial terms then just return it:
        if (n < initialTerms.length) {
            return initialTerms[n];
        }

        // we keep a queue with the last N terms, where N is the order of the sequence:        
        Queue<Long> previousTerms = new LinkedList<>();
        // we keep in sum the current term:
        long sum = 0;

        // we initialize the queue and sum with the terms from initial terms:
        for (int term : initialTerms) {
            previousTerms.add(Long.valueOf(term));
            sum += term;
        }
        // note that at this point we have in previousTerms the initial values and in sum
        // the value for the next term. this is:
        // if previous terms are a0, a1, a2 (N=3) them sum will be a4.

        int currentN = initialTerms.length;
        while (currentN < n) {
            /*
             * while we didn't reach the term asked (an) then:
             * we need to compute the next term.
            
             * we can do this by adding up all the values in previousTerms
             * then add the new value at the end of previousTerms and discard the first one.
             * (try this manually for a few terms of a fibonacci of order 3 with first terms 3, 2, 5)
             * however note that we will be reapiting computations:
             * imagine a fibonacci of order 3:
             * then by definition:
             * for n >= 3
             * a(n) == a(n-3) + a(n-2) + a(n-1)
             * thus:
             * a(n+1) == a(n-2) + a(n-1) + a(n)
             * if we do a(n+1) - a(n) we will get:
             * a(n+1) - a(n) == (a(n-2) + a(n-1) + a(n)) - (a(n-3) + a(n-2) + a(n-1))
             * we can cancel out the middle terms (reapiting computations):
             * a(n+1) - a(n) == a(n) - a(n-3)
             * a(n+1) ==  a(n) - a(n-3) + a(n)
             * thus:
             * a(n+1) ==  2 a(n) - a(n-3), with n >= 3.
             */

            // get the first term in the queue, this term will not be part of the current one:
            long leftMostTerm = previousTerms.poll();
            // add to the queue the previously calculated term aka sum:
            previousTerms.add(sum);
            // our current term is equal to (the previous one times 2) minus the first term that was in the queue: 
            sum = sum * 2 - leftMostTerm;
            currentN++;
        }

        return sum;
    }

    /**
     *
     * @param n the term index, 0 based.
     * @param initialTerms
     * @return the <code>n</code>-th term of the Fibonacci of order and initial terms given by <code>initialTerms</code>.
     */
    public static long fibonacciOrderRecursive(final int n, Integer... initialTerms) {

        // if the term asked is within the initial terms then just return it:
        if (n < initialTerms.length) {
            return initialTerms[n];
        }

        if (n == initialTerms.length) {
            // return the sum of initialTerms
            return Arrays.asList(initialTerms).stream().reduce(0, Integer::sum);
        }

        // starting with the term at n = initialTerms.length + 1, we know we can use the formula:
        // a(n+1) ==  2 a(n) - a(n-3)
        // see the fibonacciOrder method for an explanation.
        return 2 * fibonacciOrderRecursive(n - 1, initialTerms) - fibonacciOrderRecursive(n - initialTerms.length - 1, initialTerms);

    }

    /**
     *
     * @param n the term index, 0 based.
     * @param initialTerms
     * @return the <code>n</code>-th term of the Fibonacci of order and initial terms given by <code>initialTerms</code>.
     */
    public static long fibonacciOrderRecursiveCache(final int n, Integer... initialTerms) {
        return fibonacciOrderRecursiveCache(n, new HashMap<>(), initialTerms);
    }

    /**
     * 
     * @param n the term index, 0 based.
     * @param calculatedTerms   the cache, on the first call this must be an empty map.
     * @param initialTerms
     * @return the <code>n</code>-th term of the Fibonacci of order and initial terms given by <code>initialTerms</code>.
     */
    private static long fibonacciOrderRecursiveCache(final int n, Map<Integer, Long> calculatedTerms, Integer... initialTerms) {

        // if the term asked is within the initial terms then just return it:
        if (n < initialTerms.length) {
            return initialTerms[n];
        }

        Long term = calculatedTerms.get(n);
        if (term != null) {
            return term;
        }

        if (n == initialTerms.length) {
            // the sum of initialTerms
            term = Long.valueOf(Arrays.asList(initialTerms).stream().reduce(0, Integer::sum));
        } else {
            // starting with the term at n = initialTerms.length + 1, we know we can use the formula:
            // a(n+1) ==  2 a(n) - a(n-3)
            // see the fibonacciOrder method for an explanation.
            term = 2 * fibonacciOrderRecursiveCache(n - 1, calculatedTerms, initialTerms) -
                   fibonacciOrderRecursiveCache(n - initialTerms.length - 1, calculatedTerms, initialTerms);
        }

        // cache it
        calculatedTerms.put(n, term);

        return term;

    }

}
