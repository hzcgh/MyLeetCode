import utils.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListTwo {
    // 8:15 - 8:50

    public class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head == null)
                return null;

            // Create a dummy start node
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;

            int counter = 0;
            ListNode curr = dummyHead;

            ListNode start = curr;
            while (counter != m) {
                if (counter + 1 == m) {
                    start = curr;
                }

                curr = curr.next;
                counter++;
            }
            ListNode next = curr.next;
            for (; counter != n; counter++) {
                ListNode tmp = next.next;
                next.next = curr;
                curr = next;
                next = tmp;
            }

            start.next.next = next;
            start.next = curr;

            return dummyHead.next;

        }
    }
}

