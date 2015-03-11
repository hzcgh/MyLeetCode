import java.util.LinkedList;
import java.util.Queue;

/**
 * http://www.careercup.com/question?id=6266917077647360
 */

/*
    Better Recursive algorithm
    1. Recursively traverse to the leftmost node.
    2. This becomes the NewRoot, and keep returning this value, up the chain.
    3. Make the following changes
    - CurrentRoot. Left.Left = CurrentRoot.Right
    - CurrentRoot.Left.Right = CurrentRoot
    - CurrentRoot.Left = CurrentRoot.Right = NULL
 */

public class FlipBinaryTree {
    static class TreeNode {
        Integer value;
        TreeNode left;
        TreeNode right;
    }

    Queue<Integer> queue = new LinkedList<>();

    TreeNode flipTree(TreeNode root){
        postOrderTraverse(root);
        TreeNode newRoot = null;
        TreeNode currentNode = newRoot;

        while (!queue.isEmpty()){
            TreeNode t1 = new TreeNode();
            t1.value = queue.poll();

            if (newRoot == null){
                newRoot = t1;
                currentNode = newRoot;

            } else if (currentNode.left == null)
            {
                currentNode.left = t1;
            } else{
                currentNode.right = t1;
                currentNode = currentNode.right;
            }
        }

        return newRoot;
    }

    void postOrderTraverse(TreeNode node){

        if (node.left != null)
            postOrderTraverse(node.left);
        if (node.right!=null)
            postOrderTraverse((node.right));
        queue.add(node.value);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode();
        t1.value = 1;

        TreeNode t2 = new TreeNode();
        t2.value = 2;

        TreeNode t3 = new TreeNode();
        t3.value = 3;

        t1.left = t2;
        t1.right = t3;

        TreeNode t4 = new TreeNode();
        t4.value =4;

        TreeNode t5 = new TreeNode();
        t5.value = 5;

        t2.left = t4;
        t2.right = t5;

        TreeNode t6 = new TreeNode();
        t6.value = 6;

        TreeNode t7 = new TreeNode();
        t7.value = 7;

        t4.left = t6;
        t4.right = t7;

        FlipBinaryTree flip= new FlipBinaryTree();
        flip.flipTree(t1);

        System.out.println();

    }
}
