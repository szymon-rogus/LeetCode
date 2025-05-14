package algorithms.medium.other;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/simplify-path">...</a>
 * This solution beats 10.14% other Java submissions' memory complexity
 * This solution beats 17.74% other Java submissions' runtime
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] directories = path.split("/");

        for (String element : directories) {
            if (element.equals(".") || element.isEmpty()) {
                continue;
            } else if (element.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(element);
            }
        }

        StringBuilder simplified = new StringBuilder();
        while (!stack.isEmpty()) {
            String element = stack.pop();

            if (simplified.isEmpty()) {
                simplified = new StringBuilder(element);
            } else {
                simplified.insert(0, element + "/");
            }

        }

        return "/" + simplified;
    }
}
