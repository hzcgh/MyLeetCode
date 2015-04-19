import utils.TreeNode;

/**
 * http://articles.leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-tree-part-i.html
 */
public class LowestCommonAncestorOfBinaryTree {
    public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q){
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if (left!=null && right!=null)
            return root;
        if (left !=null)
            return left;
        else
            return right;
    }

}
