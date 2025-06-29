package algorithms.medium.DP;

/**
 * <a href="https://leetcode.com/problems/paint-fence">...</a>
 * This solution beats 100.00% other Java submissions' runtime
 * This solution beats 62.86% other Java submissions' memory complexity
 */
public class PaintFence {

    public int numWays(int n, int k) {
        int previous = k * k;
        int prePrevious = k;

        for (int i = 2; i < n; i++) {
            int next = (previous + prePrevious) * (k - 1);
            prePrevious = previous;
            previous = next;
        }

        return n == 1 ? prePrevious : previous;
    }
}
