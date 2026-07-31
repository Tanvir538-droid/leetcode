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
    public ListNode reverseKGroup(ListNode head, int k) {
        


        return reverseKElements(head,k); 
    }

    public ListNode reverseKElements(ListNode head,int k){
        
        if(head == null){
            return null;
        }
        
        ListNode current = head;
        ListNode dummy = head;
        

for (int i = 0; i < k; i++) {
    if (dummy == null) {
        return head;
    }
    dummy = dummy.next;
}

        ListNode previous = null;
        current = head;
        ListNode conn = head;
        ListNode next = null;
        int counter = 0;
        while(counter!=k){
            next = current.next;
            current.next = previous;
           
            previous = current;
            current = next;
            counter++;
        }
        conn.next = reverseKElements(dummy,k);

        return previous;
    }
}


// int length =0;
        // ListNode current = head;
        // while(current!=null){
        //     length++;
        //     current = current.next;
        // }
        // ListNode secondHead = head;
        // current = head;
        // int tempPrime = 0;
        // while(tempPrime!=k){
        //     secondHead = current;
        //     current = current.next;
        //     tempPrime++;
        // }
        
        // int iteration = length/k;
        // int temp =0;
        // ListNode previous = null;
        // ListNode next = null;
        // current = head;

        // while(iteration != 0){
        //     while(temp != k){
        //         next = current.next;
        //         current.next = previous;
        //         if(temp==k-1){
        //             current.next.next = next;
        //         }
        //         previous = current;
        //         current = next;
        //         temp++;
        //     }
        //         previous = null;
        //         temp = 0;
                
            

        //     iteration--;
        // }

        // return secondHead;