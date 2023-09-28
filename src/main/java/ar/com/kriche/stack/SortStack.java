package ar.com.kriche.stack;

import java.util.Stack;

/**
 * @author Kriche
 */
public class SortStack {

    /**
     * sorts a stack using only another stack.
     * smaller element on top.
     */
    public static void sortStack(Stack<Integer> stack) {

        Stack<Integer> reverseSorted = new Stack<>();

        while (!stack.empty()) {

            Integer number = stack.pop();

            // put into stack any item from reverseSorted that is bigger than number.
            while (!reverseSorted.empty() && reverseSorted.peek() > number) {
                stack.push(reverseSorted.pop());
            }
            // now any item in reverseSorted is equal to or smaller than number
            // so save number to reverseSorted
            reverseSorted.push(number);
        }

        while (!reverseSorted.empty()) {
            stack.push(reverseSorted.pop());
        }

    }

}
