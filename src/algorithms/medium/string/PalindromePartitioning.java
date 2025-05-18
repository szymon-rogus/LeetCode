package algorithms.medium.string;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/palindrome-partitioning">...</a>
 * This solution beats 14.69% other Java submissions' runtime
 * This solution beats 91.73% other Java submissions' memory complexity
 */
public class PalindromePartitioning {

    /// forgive me father - this solution has O(n*(2^n)) runtime complexity
    /// update: this complexity seems to be optimal, although is very bad
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();

        for (int i = 1; i <= s.length(); i++) {
            String currentSubstring = s.substring(0, i);
            String rest = s.substring(i);
            generatePartition(list, new ArrayList<>(), currentSubstring, rest);
        }
        return list;
    }

    /// this is just generating all substring in recursion
    /// when current substring is a palindrome we add it to new list and follow down the recursion tree
    /// we can add partition list to final list when we 'clean' the current String
    private void generatePartition(List<List<String>> list, List<String> partition,
                                   String current, String s) {
        if (!isPalindrome(current)) return;

        partition.add(current);

        if (s.isEmpty()) list.add(partition);

        for (int i = 1; i <= s.length(); i++) {
            String currentSubstring = s.substring(0, i);
            String rest = s.substring(i);
            List<String> partitionCopy = new ArrayList<>(partition);

            generatePartition(list, partitionCopy, currentSubstring, rest);
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
