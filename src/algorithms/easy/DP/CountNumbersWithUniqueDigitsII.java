package algorithms.easy.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/count-numbers-with-unique-digits-ii">...</a>
 * This solution beats 50.65% other Java submissions' runtime
 * This solution beats 25.97% other Java submissions' memory complexity
 */
public class CountNumbersWithUniqueDigitsII {

    ///  Not optimal brute-force solution
    public int numberCount(int a, int b) {
        int solution = 0;

        for (int i = a; i <= b; i++) {
            if (isUnique(i)) solution++;
        }

        return solution;
    }

    private boolean isUnique(int number) {
        List<Integer> list = new ArrayList<>();

        while (number > 0) {
            int element = number % 10;
            if (list.contains(element)) return false;

            list.add(element);
            number /= 10;
        }

        return true;
    }
}
