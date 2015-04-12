package utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * Created by Peter on 3/23/2015.
 */
public class Util {
    public static ListNode createListFromArray(Integer[] array){
        ListNode head=null;
        ListNode pre = null;
        for(int i=0;i<array.length;i++){
            ListNode newNode = new ListNode(array[i]);
            if (i==0){
                head = newNode;
            } else{
                pre.next = newNode;
            }
            pre = newNode;
        }
        return head;
    }

    public static void printList(ListNode head){
        ListNode curr = head;
        while(curr!=null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    public static TreeNode deserilize(String str){
        String[] tokens = str.split(",");
        if (tokens.length == 0)
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(tokens[0]));
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        for(int i=1;i<tokens.length;i+=2){
            String left = tokens[i];
            String right = i+1 < tokens.length? tokens[i+1]: null;

            TreeNode node = queue.poll();
            TreeNode left_t = null;
            TreeNode right_t = null;

            if (!left.equals("#"))
                left_t = new TreeNode(Integer.valueOf(left));
            if (right!=null && !right.equals("#"))
                right_t = new TreeNode(Integer.valueOf(right));

            node.left = left_t;
            node.right = right_t;

            if (left_t!=null)
                queue.add(left_t);
            if (right_t!=null)
                queue.add(right_t);
        }

        return root;
    }

}
