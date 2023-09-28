package ar.com.kriche.stack;

import java.util.Stack;

/**
 * A stack that keeps track of the min value added.
 *
 * @author Kriche
 */
public class StackMin extends Stack<Integer> {

    private final Stack<Integer> mins = new Stack<>();

    @Override
    public Integer push(Integer value) {

        if (value == null) {
            throw new IllegalArgumentException("value cannot be null.");
        }

        if (mins.empty() || value <= getMin()) {
            mins.push(value);
        }

        return super.push(value);
    }

    @Override
    public Integer pop() {
        Integer value = super.pop();

        int min = mins.peek();
        if (min == value) {
            mins.pop();
        }

        return value;
    }

    /**
     * @return the stored min element (in constant time) without removing it from the stack.
     * @throws EmptyStackException if this stack is empty.
     */
    public int getMin() {
        return mins.peek();
    }

}

