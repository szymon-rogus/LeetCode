package algorithms.easy.other;

/**
 * <a href="https://leetcode.com/problems/count-symmetric-integers">...</a>
 * This solution beats 80.52% other Java submissions' memory complexity
 * This solution beats 17.53% other Java submissions' runtime
 */
public class CountSymmetricIntegers {

    public static int countSymmetricIntegers(int low, int high) {
        int counter = 0;
        for (int i = low; i <= high; i++) {
            String number = String.valueOf(i);
            ///  only numbers that have even digits
            if (number.length() % 2 == 0) {
                String first = number.substring(0, number.length() / 2);
                String second = number.substring(number.length() / 2);
                ///  simple comparison of sum of both parts of number
                if (sumDigits(first) == sumDigits(second)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private static int sumDigits(String string) {
        int sum = 0;
        for (char c : string.toCharArray()) {
            sum += c;
        }
        return sum;
    }
}
