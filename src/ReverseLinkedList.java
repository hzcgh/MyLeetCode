import utils.ListNode;
import utils.Util;

/**
 * Created by Peter on 4/14/2015.
 */
public class ReverseLinkedList {
    public ListNode reverseLinkedListRecursive(ListNode head){
        if (head == null || head.next == null)
            return  head;
        ListNode newHead = reverseLinkedListRecursive(head.next);
        head.next.next = head;  // IMPORTANT! the new tail is head.next; So here let the new tails point to head
        head.next = null;
        return newHead;

    }

    public ListNode reverseLinkedListIterative(ListNode head){
        if (head == null || head.next == null)
            return  head;

        ListNode prev = head;
        ListNode curr = head.next;

        while(curr!=null){
            ListNode tmp = curr.next;
            curr.next = prev;
            if (prev.next.next == prev)     // IMPORTANT! Make the tail point to null; otherwise the head and second node forms a cycle
                prev.next = null;
            prev = curr;
            curr = tmp;
        }

        return prev;
    }


    public static void main(String[] args) {
        ListNode head = Util.createListFromArray(new Integer[]{1,2,3});
        head = new ReverseLinkedList().reverseLinkedListIterative(head);
        Util.printList(head);
    }
}
