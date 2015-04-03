import utils.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric( root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right){
        if (left == null || right == null)
            return left == right;

        if (left.val!=right.val)
            return false;

        return isSymmetric(left.left,right.right) && isSymmetric(left.right, right.left);
    }

    public boolean isSymmetricIterative(TreeNode root){
        if (root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();      // Allowing null value in the stack greatly reduces code complexity
        boolean ret = compare(root.left, root.right);
        if (!ret)
            return false;
        if (root.left!=null && root.right!=null)
        {
            stack.push(root.right);
            stack.push(root.left);
        }

        while(!stack.isEmpty()){
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();

            ret = compare(left, right) ;
            if (!ret)
                return false;
            if (left!=null && right!=null){
                stack.push(left.left);
                stack.push(right.right);

                stack.push(left.right);
                stack.push(right.left);
            }
        }
        return true;
    }

    private boolean compare(TreeNode left, TreeNode right){
        if (left == null || right == null)
            return left == right;

        return left.val == right.val;
    }

}
