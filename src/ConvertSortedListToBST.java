import utils.ListNode;
import utils.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertSortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        return sortedListToBST(head, head, null);
    }

    public TreeNode sortedListToBST(ListNode head, ListNode start, ListNode end){
        if (start == null){
            return null;
        } else if (start == end || start.next == end){
            TreeNode root = new TreeNode(start.val);
            return root;
        } else{
            ListNode mid = findMid(start, end);
            TreeNode root = new TreeNode(mid.val);
            root.left = sortedListToBST(head, start, mid);
            root.right = sortedListToBST(head,mid.next, end);
            return root;
        }
    }

    private ListNode findMid(ListNode start, ListNode end){
        ListNode fast = start;
        ListNode slow = start;

        if (fast.next!=end && fast.next.next!=end){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
