import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode setNext(ListNode next) {
            this.next = next;
            return this;
        }
    }

    Map<ListNode, ListNode> previousNodes = new HashMap<>();

    class HeadAndTail{
        ListNode head;
        ListNode tail;

        public HeadAndTail(ListNode head, ListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null)
            return;

        for (ListNode next = head; next != null; next = next.next) {
            if (next.next != null) {
                previousNodes.put(next.next, next);
            }
        }

        reorder(head, findTheNodeBeforeTail(head, null));
    }

    public void reorder(ListNode head, ListNode tail) {
/*        if (head.next == tail || head == tail) {
            tail.next = null;
            return;
        }
        reorder(head.next, findTheNodeBeforeTail(head.next, tail));
        tail.next = head.next;
        head.next = tail;*/

        Deque<HeadAndTail> stack = new ArrayDeque<>();
        ListNode newHead = head;
        ListNode newTail = tail;

        while(true){
            if (newHead.next == newTail || newHead == newTail){
                newTail.next = null;
                break;
            } else{
                stack.push(new HeadAndTail(newHead,newTail));
                newHead = newHead.next;
                newTail = findTheNodeBeforeTail(newHead, newTail);
            }
        }

        while (!stack.isEmpty()){
            HeadAndTail ht = stack.pop();
            ListNode s_head = ht.head;
            ListNode s_tail = ht.tail;

            s_tail.next = newHead;
            s_head.next = s_tail;

            newHead = s_head;
        }

    }

    private ListNode findTheNodeBeforeTail(ListNode head, ListNode tail) {
        if (tail == null) {
            ListNode curr = head;
            while (curr.next != tail) {
                curr = curr.next;
            }
            return curr;
        } else {
            return previousNodes.get(tail);
        }
    }

    public static void main(String[] args) {
/*        ListNode head = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(3)*//*.setNext(new ListNode(4).setNext(new ListNode(5)))*//*));
        ReorderList r = new ReorderList();
        r.reorderList(head);

        ListNode curr = head;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }*/
    }
}


