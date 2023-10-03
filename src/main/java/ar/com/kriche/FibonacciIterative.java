package ar.com.kriche;

/**
 *
 * @author Kriche
 *
 */
// f(n)= f(n-1) + f(n-2);
public class FibonacciIterative {

    private static final int N = 12;

    public static void main(String args[]) {

        long fibo = 1, previousTerm = 1, beforePreviousTerm = 0;

        for (int i = 1; i < N; i++) {
            fibo = previousTerm + beforePreviousTerm;
            beforePreviousTerm = previousTerm;
            previousTerm = fibo;
        }

        System.out.println("fibo(" + N + ") = " + String.valueOf(fibo));

    }

}
