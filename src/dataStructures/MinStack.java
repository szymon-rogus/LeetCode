package dataStructures;

import lombok.NoArgsConstructor;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/min-stack">...</a>
 * This solution beats 18.22% other Java submissions' memory complexity
 * This solution beats 97.30% other Java submissions' runtime
 */
@NoArgsConstructor
public class MinStack {

    private final Stack<Integer> stack = new Stack<>();

    private final Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        if (minStack.isEmpty()) {
            minStack.push(val);
            stack.push(val);
            return;
        }

        int currentMin = minStack.peek();

        minStack.push(Math.min(currentMin, val));
        stack.push(val);
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public void clear() {
        stack.clear();
        minStack.clear();
    }
}
