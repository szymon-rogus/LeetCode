package algorithms.easy.other;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/happy-number">...</a>
 * This solution beats 66.84% other Java submissions' runtime
 * This solution beats 39.69% other Java submissions' memory complexity
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();

        while (n != 1) {
            if (list.contains(n)) return false;

            list.add(n);
            int next = 0;
            while (n > 0) {
                next += (n % 10) * (n % 10);
                n /= 10;
            }
            n = next;

        }
        return true;
    }
}
