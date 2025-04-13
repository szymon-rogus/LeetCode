package algorithms.easy;

/**
 * <a href="https://leetcode.com/problems/confusing-number">...</a>
 * This solution beats 67.08% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class ConfusingNumber {

    public static boolean confusingNumber(int n) {

        int oldValue = n;
        int newValue = 0;

        while (n > 0) {
            /// cut and get rid of last digit
            int digit = n % 10;
            n /= 10;

            /// rotate digit
            if (digit == 2 || digit == 3 || digit == 4 || digit == 5 || digit == 7) {
                return false;
            }
            if (digit == 6) {
                digit = 9;
            } else if (digit == 9) {
                digit = 6;
            }

            /// stack digit in front of the new value
            newValue *= 10;
            newValue += digit;
        }

        /// check if it was really confusing
        return oldValue != newValue;
    }
}
