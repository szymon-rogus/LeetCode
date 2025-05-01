package algorithms.medium.other;

/**
 * <a href="https://leetcode.com/problems/rectangle-area">...</a>
 * This solution beats 33.64% other Java submissions' memory complexity
 * This solution beats 11.89% other Java submissions' runtime
 */
public class ReverseInteger {

    public int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) return 0;

        int flag = x < 0 ? -1 : 1;
        x *= flag;

        while (x % 10 == 0) {
            x = x / 10;
        }

        String string = String.valueOf(x);
        StringBuilder reversed = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            if (reversed.isEmpty() && string.charAt(i) == '0') {
                continue;
            }
            reversed.append(string.charAt(i));
        }

        string = reversed.toString();
        long result = Long.parseLong(string);

        if (Integer.MAX_VALUE < result) {
            return 0;
        }

        return (int) result *flag;
    }
}
