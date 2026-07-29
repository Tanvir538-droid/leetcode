/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode current = head;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int count=0;
        while(current!= null){
            count++;
            current = current.next;
        }
        current = head;
        int middle = (count/2) + 1;
        count = 1;
        while(current!= null){
            if(count!=middle){
                tail.next = current;
                tail = tail.next;
            }
            current = current.next;
            count++;
        }
        tail.next = null;

        return dummy.next;
    }
}