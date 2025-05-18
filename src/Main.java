import java.time.Instant;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        String s = "leetcode";
        System.out.println(longestSubPalindrome(s, 0, s.length() - 1));

    }

    private static int longestSubPalindrome(String s, int start, int end) {
        while (start < end) {
            char leftChar = s.charAt(start);
            char rightChar = s.charAt(end);
            if (leftChar != rightChar) {
                String left = s.charAt(end) + s.substring(start, end + 1); /// babab
                String right = s.substring(start, end + 1) + s.charAt(start); /// ababa
                int leftInsertion = longestSubPalindrome(left, 0, left.length() - 1); /// 0
                int rightInsertion = longestSubPalindrome(right, 0, right.length() - 1); /// 0
                return Math.min(leftInsertion, rightInsertion) + 1;
            }
            start++;
            end--;
        }
        return 0;
    }

}