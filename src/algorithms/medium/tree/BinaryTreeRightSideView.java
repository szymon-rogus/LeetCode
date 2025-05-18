package algorithms.medium.tree;

import dataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-right-side-view">...</a>
 * This solution beats 71.22% other Java submissions' runtime
 * This solution beats 43.83% other Java submissions' memory complexity
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        List<Integer> view = new ArrayList<>();
        if (root == null) return view;

        list.add(root);

        while (!list.isEmpty()) {
            Integer toAdd = list.getFirst().val;
            view.add(toAdd);

            /// loop for adding next level of tree - nd the most right element will be first in the tempList;
            List<TreeNode> tempList = new ArrayList<>();
            while (!list.isEmpty()) {
                TreeNode currentNode = list.removeFirst();
                if (currentNode.right != null) tempList.add(currentNode.right);
                if (currentNode.left != null) tempList.add(currentNode.left);
            }

            list.addAll(tempList);
            tempList.clear();
        }
        return view;
    }
}
