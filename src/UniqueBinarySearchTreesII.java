import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> results = new ArrayList<>();

        if (start > end){
            results.add(null);
        }
        else if (start == end)
        {
            TreeNode node = new TreeNode(start);
            results.add(node);
        } else {
            for(int i=start;i<=end; i++){
                List<TreeNode> leftSubTrees = generateTrees(start, i-1);
                List<TreeNode> rightSubTrees = generateTrees(i+1, end);
                for(TreeNode left:leftSubTrees){
                    for(TreeNode right: rightSubTrees){
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        results.add(root);
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
       new UniqueBinarySearchTreesII().generateTrees(3);
    }
}
