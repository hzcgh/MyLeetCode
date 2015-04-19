import utils.TreeNode;
import utils.Util;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 1) Solution 1: the value should be within the range: low<value<high; use "long" type on low & high to avoid overflow
 * 2) Solution 2: In-order traversal: when in-order traversal a BST, we obtain the values in ascending order
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long low, long high) {
        if (root == null)
            return true;
        if (root.val <= low || root.val >= high)
            return false;
        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
    }

    public boolean isValidBSTInOrder(TreeNode root) {
        if (root == null)
            return true;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        TreeNode prev = null;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;

            if (left == null && right == null) {
                if (prev != null && prev.val >= node.val)
                    return false;
                prev = node;
            } else {
                if (right != null)
                    stack.push(right);
                node.left = node.right = null;
                stack.push(node);
                if (left != null)
                    stack.push(left);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = Util.deserilize("3,1,5,0,2,4,6,#,#,#,3");
        System.out.println(new ValidateBinarySearchTree().isValidBSTInOrder(root));
    }

}
