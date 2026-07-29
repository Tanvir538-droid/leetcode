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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode current = head;
        ListNode tail = dummy;
        while(current != null){
            if(current.val!=val){
                tail.next = current;
                tail = tail.next;
            }
            current = current.next;
        }
        tail.next = null;
        return dummy.next;

    }
}