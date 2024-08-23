package algorithms.medium.tree;

import dataStrucutres.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/path-sum-ii">...</a>
 * This solution beats 6.47% other Java submissions' memory complexity
 * This solution beats 5.14% other Java submissions' runtime
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) return list;

        if (root.left == null && root.right == null && targetSum == root.val) {
            List<Integer> rootList = List.of(root.val);
            list.add(rootList);
            return list;
        }
        search(root.left, targetSum - root.val, new LinkedList<>(List.of(root.val)), list);
        search(root.right, targetSum - root.val, new LinkedList<>(List.of(root.val)), list);

        return list;
    }

    private void search(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> list) {
        if (root == null) return;

        targetSum -= root.val;

        if (targetSum == 0) {
            if (root.left == null && root.right == null) {
                path.add(root.val);
                list.add(path);
                return;
            }
        }

        path.add(root.val);
        search(root.left, targetSum, new LinkedList<>(path) , list);
        search(root.right, targetSum, new LinkedList<>(path), list);
    }
}
