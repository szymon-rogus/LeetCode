package algorithms.medium.DP;

/**
 * <a href="https://leetcode.com/problems/2-keys-keyboard">...</a>
 * This solution beats 100% other Java submissions' runtime
 * This solution beats 87.62% other Java submissions' memory complexity
 */
public class TwoKeysKeyboard {

    /// The most optimal solution ever done, makes me feel PROUD!
    public int minSteps(int n) {
        int operations = 0;
        int divisor = 2;

        while (n > 1) {
            if (n % divisor != 0) {
                divisor++;
            } else {
                n /= divisor;
                operations += divisor;
                divisor = 2;
            }
        }

        return operations;
    }
}
