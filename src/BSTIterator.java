import utils.TreeNode;

import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/binary-search-tree-iterator/
 */

public class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack =  new Stack<>();
        leftmostNode(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() >0;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null)
            leftmostNode(node.right);

        return node.val;
    }

    private void leftmostNode(TreeNode node)
    {
        if (node == null)
            return;
        else{
            stack.push(node);
            leftmostNode(node.left);
            node.left = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

         BSTIterator i = new BSTIterator(root);
         while (i.hasNext()) {
             System.out.println(i.next());
         }
    }
}
