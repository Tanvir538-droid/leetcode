/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;

        int countA =0;
        while(l1!= null){
            countA++;
            l1 = l1.next;
        }

        int countB = 0;
        while(l2!=null){
            countB++;
            l2 = l2.next;
        }
        
         l1 = headA;
         l2 = headB;
        int temp = 0;
        if(countB!=countA){
            if(countB>countA){
                temp = countB - countA;
                while(temp!=0){
                    l2 = l2.next;
                    temp--;
                }
            }else{
                temp = countA - countB;
                while(temp!=0){
                    l1 = l1.next;
                    temp--;
                }
            }
        }
        while(l1!=null && l2!=null){
            if(l1 == l2){
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }
}