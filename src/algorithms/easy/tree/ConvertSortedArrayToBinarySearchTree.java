package algorithms.easy.tree;

import dataStructures.TreeNode;

/**
 * <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree">...</a>
 * This solution beats 100.00% other Java submissions' runtime
 * This solution beats 85.81% other Java submissions' memory complexity
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return generateRoot(nums, 0, nums.length - 1);
    }

    private TreeNode generateRoot(int [] nums, int first, int last) {
        /// edge cases - we can easily work with the one or two element arrays
        if (first == last) return new TreeNode(nums[first]);
        if (Math.abs(last - first) == 1) {
            if (nums[first] > nums[last]) {
                TreeNode root = new TreeNode(nums[first]);
                root.left = generateRoot(nums, last, last);
                return root;
            }
            TreeNode root = new TreeNode(nums[last]);
            root.left = generateRoot(nums, first, first);
            return root;
        }

        /// new center for divide and conquer
        int center = (last + first + 1) / 2;

        /// we generate current's subtree root and search in left and right parts of array for left and right subtree
        TreeNode root = new TreeNode(nums[center]);
        root.left = generateRoot(nums, first, center - 1);
        root.right = generateRoot(nums, center + 1, last);

        return root;
    }
}
