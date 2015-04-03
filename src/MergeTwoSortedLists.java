import utils.ListNode;
import utils.Util;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode head;
        ListNode curr;

        if (l1.val<l2.val){
            head = curr = l1;
            l1 = l1.next;
        } else{
            head = curr = l2;
            l2 = l2.next;
        }

        while(l1!=null && l2!=null){
            if (l1.val<l2.val){
                curr.next = l1;
                l1 = l1.next;
            } else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 == null)
            curr.next = l2;
        if (l2 == null)
            curr.next = l1;

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = Util.createListFromArray(new Integer[]{5});
        ListNode l2 = Util.createListFromArray(new Integer[]{1,2,4});

        ListNode newList = new MergeTwoSortedLists().mergeTwoLists( l1,l2);
        Util.printList(newList);

    }

}
