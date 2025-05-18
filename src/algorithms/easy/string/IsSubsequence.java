package algorithms.easy.string;

/**
 * <a href="https://leetcode.com/problems/is-subsequence">...</a>
 * This solution beats 65.88% other Java submissions' runtime
 * This solution beats 9.74% other Java submissions' memory complexity
 */
public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        int sPointer = 0;
        for (int i = 0; i < t.length(); i++) {
            ///  if we move to the end of the subString with pointer,
            ///  it means all characters has been present in the original one
            if (sPointer == s.length()) return true;
            if (t.charAt(i) == s.charAt(sPointer)) sPointer++;
        }
        return sPointer == s.length();
    }
}
