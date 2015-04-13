import utils.ListNode;

/**
 * https://leetcode.com/problems/sort-list/
 *
 * FIXME Incorrect!
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = findMidNode(head, null);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return sortedMerge(left, right);
    }

    public ListNode findMidNode(ListNode start, ListNode end){
        if (start == null)
            return null;

        if (start.next == end)
            return end;

        ListNode fast = start;
        ListNode slow = start;

        while(fast!=end && fast.next!=end){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode sortedMerge(ListNode left, ListNode right){
        if (left == null)
            return right;
        if (right == null)
            return left;

        ListNode head;
        if (left.val<right.val) {
            head = left;
            head.next = sortedMerge(left.next, right);
        }
        else {
            head = right;
            head.next = sortedMerge(left, right.next);
        }
        return head;
    }
}
