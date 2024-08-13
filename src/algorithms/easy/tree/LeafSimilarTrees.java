package algorithms.easy.tree;

import dataStrucutres.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/unique-binary-search-trees">...</a>
 * This solution beats 27.50% other Java submissions' memory complexity
 * This solution beats 19.10% other Java submissions' runtime
 */
public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root1);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);

            if (node.left == null && node.right == null) list1.add(node.val);
        }

        stack.push(root2);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);

            if (node.left == null && node.right == null) list2.add(node.val);
        }

        return list1.equals(list2);

    }
}
