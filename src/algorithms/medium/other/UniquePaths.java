package algorithms.medium.other;

import java.math.BigInteger;

/**
 * <a href="https://leetcode.com/problems/unique-paths">...</a>
 * This solution beats 5.36% other Java submissions' memory complexity
 * This solution beats 10.10% other Java submissions' runtime
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        BigInteger uniquePaths = new BigInteger("1");

        int downSteps = m - 1;
        int rightSteps = n - 1;
        int allSteps = downSteps + rightSteps;

        for (int i = allSteps; i > Math.max(rightSteps, downSteps); i--) {
            uniquePaths = uniquePaths.multiply(BigInteger.valueOf(i));
        }

        long divider = 1;
        for (int i = Math.min(rightSteps, downSteps); i > 1; i--) {
            divider *= i;
        }

        uniquePaths = uniquePaths.divide(BigInteger.valueOf(divider));

        return uniquePaths.intValue();
    }
}
