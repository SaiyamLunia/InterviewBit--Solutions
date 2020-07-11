/*
Given a linked list, remove the nth node from the end of list and return its head.
For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
If n is greater than the size of the list, remove the first node of the list
*/


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode head = A;
        int count = 1;
        while(head != null && head.next != null) {
            head = head.next.next;
            count += 2;
        }
        
        if(head == null)
            count--;
            
        if(B >= count) {
            A = A.next;
            return A;
        }
        
        ListNode prev = A;
        head = A.next;
        for(int i = 1; i <= count; i++) {
            if (B == count - i) {
                prev.next = head.next;
                head.next = null;
                System.gc();
                break;
            }
            prev = head;
            head = head.next;
        }
        return A;
    }
}



