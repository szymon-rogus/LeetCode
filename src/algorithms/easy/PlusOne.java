package algorithms.easy;

/**
 * <a href="https://leetcode.com/problems/plus-one">...</a>
 * This solution beats 44.86% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int accumulator = 1;
        /// we accumulate the values if the digit is equal 9.
        /// this loop will not return only in case the result of incrementation
        /// will create integer with extra digit (e.g. 999 + 1 = 1000)
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + accumulator == 10) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }

        /// reallocation
        if (digits[0] == 0) {
            int [] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            return newDigits;
        }
        return digits;
    }
}
