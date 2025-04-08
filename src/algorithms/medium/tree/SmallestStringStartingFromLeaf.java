package algorithms.medium.tree;

import dataStructures.TreeNode;

/**
 * <a href="https://leetcode.com/problems/smallest-string-starting-from-leaf">...</a>
 * This solution beats 52.40% other Java submissions' memory complexity
 * This solution beats 89.78% other Java submissions' runtime
 */
public class SmallestStringStartingFromLeaf {

    public String smallestFromLeaf(TreeNode root) {
        return getSmaller(root, "");
    }

    private String getSmaller(TreeNode root, String string) {
        if (root.left == null && root.right == null) return convert(root.val).concat(string);
        if (root.left == null) return getSmaller(root.right, convert(root.val).concat(string));
        if (root.right == null) return getSmaller(root.left, convert(root.val).concat(string));

        String left = getSmaller(root.left, convert(root.val).concat(string));
        String right = getSmaller(root.right, convert(root.val).concat(string));
        return left.compareTo(right) > 0 ? right : left;
    }

    private String convert(int value) {
        char element = (char) (value + 97);
        return String.valueOf(element);
    }
}
