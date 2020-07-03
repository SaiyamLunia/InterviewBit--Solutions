/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
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
    public ListNode partition(ListNode A, int B) {
        if(A == null || A.next == null)
            return A;
        ListNode lessThan = null;
        ListNode greaterThan = null;
        ListNode p1 = null;
        ListNode p2= null;
        while(A != null) {
            if(A.val < B) {
                if(lessThan == null) {
                    lessThan = new ListNode(A.val);
                    p1 = lessThan;
                } else {
                    lessThan.next = new ListNode(A.val);
                    lessThan = lessThan.next;
                }
            } else {
                if(greaterThan == null) {
                    greaterThan = new ListNode(A.val);
                    p2 = greaterThan;
                } else {
                    greaterThan.next = new ListNode(A.val);
                    greaterThan = greaterThan.next;
                }
            }
            A = A.next;
        }
        if(lessThan != null) {
            lessThan.next = p2;
            return p1;
        } else {
            greaterThan.next = p1;
            return p2;
        }
        
    }
}



