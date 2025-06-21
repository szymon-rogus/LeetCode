package algorithms.easy.DP;

/**
 * <a href="https://leetcode.com/problems/fibonacci-number">...</a>
 * This solution beats 100.00% other Java submissions' runtime
 * This solution beats 11.59% other Java submissions' memory complexity
 */
public class FibonacciNumber {

    /**
     * Optimal DP approach with memoization of 2 most recent elements
     * @param n fibonacci number
     * @return result of fibonacci sequence
     */
    public int fib(int n) {
        if (n == 0 || n == 1) return n;

        int current = 1;
        int previous = 0;

        for (int i = 2; i <= n; i++) {
            int next = current + previous;
            previous = current;
            current = next;
        }

        return current;
    }
}
