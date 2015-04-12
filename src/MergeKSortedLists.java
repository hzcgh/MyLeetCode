import utils.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size()==0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>((l1,l2)->l1.val-l2.val);

        queue.addAll(lists.stream().filter(node -> node != null).collect(Collectors.toList()));

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            curr.next = node;
            curr = curr.next;

            if (node.next!=null)
                queue.add(node.next);
        }

        return dummy.next;
    }
}
