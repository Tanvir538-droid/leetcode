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
    public ListNode middleNode(ListNode head) {
        //suppose there are n nodes
        //the node that should be retured is (n/2)+1 th node
        ListNode current = head;
        ListNode middle = head;
        int count=0;
        while(current!= null){
            count++;
            current = current.next;
        }
        current = head;
        int n = (count/2) + 1;
        count = 0;
        while(current!= null){
            count++;
           
            if(count == n){
                middle = current;
            } 
            current = current.next;
        }


        return middle;
    }
}