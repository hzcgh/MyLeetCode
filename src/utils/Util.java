package utils;

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
}
