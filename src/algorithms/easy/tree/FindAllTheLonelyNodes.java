package algorithms.easy.tree;

import dataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-all-the-lonely-nodes">...</a>
 * This solution beats 100% other Java submissions' runtime
 * This solution beats 66.14% other Java submissions' memory complexity
 */
public class FindAllTheLonelyNodes {

    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        isAlone(root, list);

        return list;
    }

    private void isAlone(TreeNode node, List<Integer> list) {
        if (node == null) return;

        if (node.left != null && node.right != null) {
            isAlone(node.left, list);
            isAlone(node.right, list);
        } else if (node.left != null) {
            list.add(node.left.val);
            isAlone(node.left, list);
        } else if (node.right != null) {
            list.add(node.right.val);
            isAlone(node.right, list);
        }
    }
}
