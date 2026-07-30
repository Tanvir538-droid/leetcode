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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode current = head;
        int numberOfNodes = 0;
        while(current != null){
            numberOfNodes++;
            current = current.next;
        }

        current = head;
        //the position of the node that should be removed
        int position = (numberOfNodes - n) ; 
        int count = 0;
        while(current!=null){
            if(count != position){
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