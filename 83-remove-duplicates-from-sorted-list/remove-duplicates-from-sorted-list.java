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
    public ListNode deleteDuplicates(ListNode head) {
         ListNode dummy = new ListNode(-1);
        ListNode current = head;
        ListNode tail = dummy;
        while(current != null){
            if(current.next == null ||current.val!=current.next.val){
                tail.next = current;
                tail = tail.next;
            }
            current = current.next;
        }
        tail.next = null;
        return dummy.next;
    }
}