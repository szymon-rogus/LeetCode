package algorithms.easy.DP;

/**
 * <a href="https://leetcode.com/problems/n-th-tribonacci-number">...</a>
 * This solution beats 100.00% other Java submissions' runtime
 * This solution beats 10.05% other Java submissions' memory complexity
 */
public class Tribonacci {

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int zero = 0;
        int one = 1;
        int two = 1;

        for (int i = 3; i <= n; i++) {
            int next = zero + one + two;
            zero = one;
            one = two;
            two = next;
        }

        return two;
    }
}
