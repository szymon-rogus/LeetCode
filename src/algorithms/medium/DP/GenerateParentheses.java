package algorithms.medium.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/plus-one">...</a>
 * This solution beats 47.01% other Java submissions' runtime
 * This solution beats 58.82% other Java submissions' memory complexity
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        generateParenthesis(list, "(", n, 1, 0);

        return list;
    }

    private void generateParenthesis(List<String> list, String string, int n, int opened, int closed) {
        if (n == opened && n == closed) {
            list.add(string);
            return;
        }
        if (n == opened) {
            generateParenthesis(list, string + ")", n, opened, closed + 1);
        } else if (opened > closed) {
            generateParenthesis(list, string + "(", n, opened + 1, closed);
            generateParenthesis(list, string + ")", n, opened, closed + 1);
        } else {
            generateParenthesis(list, string + "(", n, opened + 1, closed);
        }
    }
}
