/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3
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
    public ListNode deleteDuplicates(ListNode A) {
        if(A == null || A.next == null)
            return A;
        ListNode head = A, prev = null;
        while(head != null && head.next != null) {
            prev = head;
            head = head.next;
            while(head != null && head.val == prev.val)
                head = head.next;
            prev.next = head;
        }
        return A;
    }
}

