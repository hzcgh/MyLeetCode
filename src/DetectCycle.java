import utils.ListNode;

/**
 * Created by Peter on 3/10/2015.
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;

        do{
            if (fast.next!=null && fast.next.next!=null){
                fast = fast.next.next;
                slow = slow.next;
            } else
            {
                return null;
            }
        } while(fast != slow);

        ListNode cycle = head;
        while(cycle!=slow){
            slow = slow.next;
            cycle = cycle.next;
        }

        return cycle;
    }



    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);

        n1.next = n2;
        n2.next = n1;

        DetectCycle d = new DetectCycle();
        ListNode node = d.detectCycle(n1);

        System.out.println(node.val);
    }
}
