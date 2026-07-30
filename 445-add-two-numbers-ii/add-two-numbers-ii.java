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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Reverse both lists
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        int carry = 0;

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        // Add until both lists and carry are finished
        while (l1 != null || l2 != null || carry != 0) {

            int s1 = (l1 != null) ? l1.val : 0;
            int s2 = (l2 != null) ? l2.val : 0;

            int sum = s1 + s2 + carry;

            carry = sum / 10;

            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // Reverse the answer back
        return reverseList(dummy.next);
    }

    public ListNode reverseList(ListNode head) {

        ListNode previous = null;
        ListNode current = head;

        while (current != null) {

            ListNode next = current.next;

            current.next = previous;

            previous = current;

            current = next;
        }

        return previous;
    }
}