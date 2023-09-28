package ar.com.kriche.stack;

import java.util.Stack;

/**
 * Implements a Stack of unlimited capacity (by using multiple stacks each with a limited capacity).
 * Adds new behavior: popAt(int).
 *
 * @author Kriche
 */
public class StackOfStacks extends Stack<Integer> {

    private final Stack<Stack<Integer>> stacks;
    private final int stackCapacity;

    private int stacksCount;
    private int topLength;

    public StackOfStacks(int stackCapacity) {

        if (stackCapacity <= 0) {
            throw new IllegalArgumentException("stackCapacity must be greater than 0.");
        }

        // initial state: empty stacks.
        stacks = new Stack<>();
        this.stackCapacity = stackCapacity;
        topLength = 0;
        stacksCount = 0;
    }

    @Override
    public Integer push(Integer item) {

        if (stacks.empty()) {
            // special case: empty stacks
            stacks.push(new Stack<>());
            stacksCount++;
        } else if (topLength == stackCapacity) {
            // new stack needed
            stacks.push(new Stack<>());
            stacksCount++;
            topLength = 0;
        }

        stacks.peek().push(item);
        topLength++;

        return item;
    }

    @Override
    public Integer pop() {

        Stack<Integer> top = stacks.peek();
        Integer item = top.pop();
        topLength--;
        if (topLength == 0) {
            stacks.pop();
            stacksCount--;
            if (!stacks.empty()) {
                topLength = stackCapacity;
            }
        }

        return item;
    }

    /**
     * performs a pop operation on a specific stack.
     * it will pop all the elements of the stacks on top of stackIndex
     *
     * @param stackIndex
     * @return the top item of the stack of index stackIndex.
     */
    public Integer popAt(int stackIndex) {
        return popAtIndexFromTop(stacksCount - stackIndex - 1);
    }

    private Integer popAtIndexFromTop(int stackTopIndex) {
        if (stackTopIndex == 0) {
            return pop();
        }
        stacks.pop();
        stacksCount--;
        topLength = stackCapacity;
        return popAtIndexFromTop(stackTopIndex - 1);
    }

    @Override
    public Integer peek() {
        return stacks.peek().peek();
    }

    @Override
    public boolean empty() {
        return stacks.empty();
    }

}
