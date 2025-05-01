package algorithms.easy.string;

/**
 * <a href="https://leetcode.com/problems/length-of-last-word">...</a>
 * This solution beats 87.13% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        String trimedString = s.trim();
        int position = trimedString.lastIndexOf(' ');
        return trimedString.length() - 1 - position;
    }
}
