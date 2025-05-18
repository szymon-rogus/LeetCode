package algorithms.medium.other;

import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation">...</a>
 * This solution beats 72.79% other Java submissions' runtime
 * This solution beats 32.14% other Java submissions' memory complexity
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        List<String> operators = List.of("+", "-", "*", "/");

        for (String token : tokens) {
            /// an operator gets two most recent elements from stack and execute operation
            if (operators.contains(token)) {
                int second = stack.pop();
                int first = stack.pop();
                int result = executeOperation(first, second, token);
                /// result being pushed in stack as well
                stack.push(result);
            } else {
                /// keep integers in the stack
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }

    private int executeOperation(int first, int second, String operator) {
        return switch (operator) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            default -> first / second;
        };
    }
}
